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
        double rander = Math.random();
        
        if(game.checkWin()[0] < 3 && !game.isMark(game.checkWin()[0], game.checkWin()[1])){
            System.out.println("WINNER");
            row = game.checkWin()[0];
            pass = game.checkWin()[1];
        }
        else if(game.checkBlock()[0] < 3 && !game.isMark(game.checkBlock()[0], game.checkBlock()[1])){
            System.out.println("BLOCKED");
            row = game.checkBlock()[0];
            pass = game.checkBlock()[1];
        }
        else if(!game.isMark(1, 1))
        {
            System.out.println(rander);
            if(rander < 0.8){
                row = 1;
                pass = 1;
            }
            else {
                row = rand(game)[0];
                pass = rand(game)[1];
            }
        }        
        else{
             row = rand(game)[0];
             pass = rand(game)[1];
            /*for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(!game.isMark(i, j)){
                        row = i;
                        pass = j;
                        break;
                    }
                }
                break;
            }*/
        }
        return row;
 }
    private int[] rand(MainGame game){
        int found = 0;
        double ent = Math.random();
        int loc[];
        loc = new int[2];
        if(ent < 0.4){
            if(!game.isMark(0, 0) && game.isLine(0, 0)){
                loc[0] = 0;
                loc[1] = 0;
            }
            else if(!game.isMark(2, 0) && game.isLine(2, 0)){
                loc[0] = 2;
                loc[1] = 0;
            }
            else if(!game.isMark(0, 2) && game.isLine(0, 2)){
                loc[0] = 0;
                loc[1] = 2;
            }
            else {
                loc[0] = 2;
                loc[1] = 2;
        }
        if(0.4 < ent && ent < 0.8){
            if(!game.isMark(2, 1) && game.isLine(2, 1)){
                loc[0] = 2;
                loc[1] = 1;
            }
            else if(!game.isMark(1, 2) && game.isLine(1, 2)){
                loc[0] = 1;
                loc[1] = 2;
            }
            else if(!game.isMark(0, 1) && game.isLine(0, 1)){
                loc[0] = 0;
                loc[1] = 1;
            }
            else {
                loc[0] = 1;
                loc[1] = 1;
        }    
        }
        else {
            for(int i = 2; i >= 0; i--){
                for(int j = 2; j >= 0; j--){
                    if(!game.isMark(i, j)){
                        loc[0] = i;
                        loc[1] = j;
                        found = 1;
                        break;
                    }
                }
                if(found == 1) break;
            }
        }
     }
    return loc;
 }
    public int getCol() {
        return pass;
    }
}
    
