/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

/**
 *
 * @author sayre
 */
class nonPlayer {
    
    public int pass;

    public int getRow(MainGame game) {
        int row = 0;
        if(!game.isMark(1, 1))
        {
            row = 1;
            pass = 1;
        }
        else if(game.checkWin()[0] < 3 && !game.isMark(game.checkWin()[0], game.checkWin()[1])){
            System.out.println("Triggered");
            row = game.checkWin()[0];
            pass = game.checkWin()[1];
        }
         else if(game.checkBlock()[0] < 3 && !game.isMark(game.checkBlock()[0], game.checkBlock()[1])){
            System.out.println("Triggered");
            row = game.checkBlock()[0];
            pass = game.checkBlock()[1];
        }
        else{
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(!game.isMark(i, j)){
                        row = i;
                        pass = j;
                        break;
                    }
                }
            }
        }
        
        return row;
    }

    public int getCol() {
        return pass;
    }
    
}
