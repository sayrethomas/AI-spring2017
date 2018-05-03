/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasnake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

/**
 *
 * @author sayre
 */
public class Token {
    
    private int x, y, score;
    private int length = 7;
    private Snake snake;
    //New 
    public Token(Snake s){
        x = (int)(Math.random() * 390);
        y = (int)(Math.random() * 390);
        snake = s;
        }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    //Change the Token location
    public void changePosition(){
        x = (int)(Math.random() * 390);
        y = (int)(Math.random() * 390);
               
    }
    public int getScore(){
        return score;
    }
     public int getLength(){
        return length;
    }
    public void draw(Graphics g){
        g.setColor(Color.green);
        g.fillRect(x, y, 10, 10);
    }
   //Collison rules for Token
    public boolean snakeCollision(int i, int j){
        int snakeX = i + 4;
        int snakeY = j + 4;
        if (snakeX >= x-3 && snakeX <= (x + 12))
            if(snakeY >= y-3 && snakeY <= (y + 12)){
                changePosition();
                score+=50;
                length+=8;
                snake.setElongate(true);
                return true;
            }
        return false;
    }
    public boolean treeCollision(int i, int j){
        int snakeX = i + 4;
        int snakeY = j + 4;
        if (snakeX >= x-3 && snakeX <= (x + 12))
            if(snakeY >= y-3 && snakeY <= (y + 12)){
                return true;
            }
        return false;
    }
  
}
