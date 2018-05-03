/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasnake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author sayre
 */
public class Snake {
    
    List<Point> snakePoints;
    int xDir, yDir;
    boolean isMoving, elongate;
    final int STARTSIZE = 8, STARTX = 200, STARTY = 200;
    
    //Create Snake
    public Snake(){
        snakePoints = new ArrayList<Point>();
        xDir = 0;
        yDir = 0;
        isMoving = false;
        elongate = false;
        snakePoints.add(new Point(STARTX, STARTY));
        for(int i = 1; i < STARTSIZE; i++){
            snakePoints.add(new Point(STARTX, STARTY + i * 8));
        }
    }
    //Draw Snake
    public void draw(Graphics g){
        g.setColor(Color.white);
        for(Point p : snakePoints){
            g.fillRect(p.getX(), p.getY(), 8, 8);
        }
    }
    //Move rules
    public void move(){
        if(isMoving){
        Point temp = snakePoints.get(0);
        Point last = snakePoints.get(snakePoints.size()-1);
        Point newStart = new Point(temp.getX() + xDir * 8, temp.getY() +yDir * 8);
        
        for( int i =  snakePoints.size() - 1; i >= 1; i--){
            snakePoints.set(i, snakePoints.get(i-1));
        }
        //Increase Snake Length
        snakePoints.set(0, newStart);
        if(elongate){
            for(int i = 0; i < 7; i++){
            snakePoints.add(last);}
            elongate = false;
        }
        }
    }
    //Snake Collisions Rules
    public boolean snakeCollision(int x, int y){

        for(int i = 1; i < snakePoints.size(); i++){
            if(snakePoints.get(i).getX() == x && snakePoints.get(i).getY() == y)
                return true;
        }
        return false;
    }
    public List getPoints(){
        return snakePoints;
    }
    public boolean isMoving(){
        return isMoving;
    }
    
    public void setIsMoving(boolean b){
        isMoving = b;
    }
    public int getXDir(){
        return xDir;
    }
    
    public int getYDir(){
        return yDir;
    }
    
    public void setXDir(int x){
        xDir = x;
    }
    
    public void setYDir(int y){
        yDir = y;
    }
    
    //X pos for Head of Snake
    public int getX(){
        return snakePoints.get(0).getX();
    }
    
    //Y pos for Head of Snake
    public int getY(){
        return snakePoints.get(0).getY();
    }
    
    public void setElongate(boolean b){
        elongate = b;
    }
    
    public boolean getElongate(){
        return elongate;
    }
    public int getDir(){
        if(xDir == -1){
            return 3;
        }
        else if(yDir == 1){
            return 2;
        }
        else if(xDir == 1){
            return 1;
        }
        else{
            return 0;
        }
    }
}

