/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javasnake;

import java.awt.Graphics;
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
public class TokenTest {
    
    @Test
    public void testSnakeCollision() {
        System.out.println("Test if Token is on the map and would collide--");
        Snake s = new Snake();
        Token t = new Token(s);
        int x = 0;
        for(int i = 0; i < 400; i++){
            if(i == t.getX())
                x = i;
        }
        assertEquals(x, t.getX());
        System.out.println("Test Passed-");
    }
    
}
