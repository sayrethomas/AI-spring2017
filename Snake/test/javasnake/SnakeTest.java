/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasnake;

import java.awt.Graphics;
import java.util.HashSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author sayre
 */
public class SnakeTest {
    
    
    /**
     * Test of move method, of class Snake.
     */
    @Test
    public void testMove() {
        System.out.println("Test if Elongate is set to False during Move--");
        boolean b = false;
        Snake snake = new Snake();
        snake.setElongate(true);
        snake.setIsMoving(true);
        snake.move();
        assertEquals(b, snake.getElongate());
        System.out.println("Test Passed-");
        
    }

    /**
     * Test of snakeCollision method, of class Snake.
     */
    @Test
    public void testSnakeCollision() {
        System.out.println("Test if snake would collide with a beginning position--");
         int y = 200;
        Snake snake = new Snake();
        int snakey = snake.getY();
        assertEquals(y, snakey);
        System.out.println("Test Passed-");
    }


    /**
     * Test of setIsMoving method, of class Snake.
     */
    @Test
    public void testSetIsMoving() {
        System.out.println("Test isMoving manipulators");
        Snake snake = new Snake();
        snake.setIsMoving(true);
        boolean b = true;
      assertEquals(b, snake.isMoving());
      System.out.println("Test Passed-");
    }

    
}
