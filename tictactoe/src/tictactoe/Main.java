package tictactoe;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
     
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        MainGame game = new MainGame();
       // nonPlayer opp = new nonPlayer();
        game.initializeBoard();
        
        System.out.println("Tic-Tac-Toe!");
        do
        {
            System.out.println("Current board layout:");
            game.printBoard();
            int mark;
            do
            {
                if(game.getCurrentPlayer() == 'X'){
                   // System.out.println("Player " + game.getCurrentPlayer() + ", enter an empty location 1-9!");
                     mark = scan.nextInt()-1;
                    //mark = minimax(game.getCurrentBoard(), 'X', 1000);
                }
                else{
                    /*System.out.println("Player " + game.getCurrentPlayer() + ", enter an empty location 1-9!");
                    mark = scan.nextInt()-1;*/
                    //System.out.println(game.getCurrentPlayer());
                    mark = minimax(game.getCurrentBoard(), 'O', Integer.MAX_VALUE);
                }
                
            }
            
            while (!game.placeMark(mark));{      
            game.changePlayer();
            //System.out.println(minimax(game));
        }
        }
        while(!game.isWinner(game.getOtherPlayer()) && !game.isBoardFull());
        if (game.isBoardFull() && !game.isWinner(game.getOtherPlayer()))
        {
            game.printBoard();
            System.out.println("CATS GAME!");
        }
        else
        {
            System.out.println("Current board layout:");
            game.printBoard();
            game.changePlayer();
            System.out.println(game.getCurrentPlayer() + " IS THE WINNER!");
        }
    }

    private static int victor(char[] newBoard){
        MainGame tempGame = new MainGame();
        tempGame.makeBoard(newBoard);
        //tempGame.printBoard();
        if(tempGame.isWinner('X')) return 1;
        else if(tempGame.isWinner('O')) return 2;
        else if(tempGame.isBoardFull()) return 3;
        else return 0;      
     }
     private static int score(int point) {
        if(point == 1) return -10;
        else if(point == 2) return 10;
        else return 0;
    }
      private static int minimax(char[] board, char player, int depth){
//            int bestMove = 0;
//            int max = Integer.MIN_VALUE;
//            int min = Integer.MAX_VALUE;
            int victor = victor(board);
            //System.out.println(score(victor));
            if(victor != 0 || depth == 0) return score(victor);
            if(player == 'O'){ 
                int max = Integer.MIN_VALUE;
                int bestMove = 0;
                for (int i = 0; i < 9; i++){
                   // System.out.println(i);
                    if(board[i] != '-') continue;
                    board[i] = player;
                    int v = minimax(board, 'X', depth-1);
                    if(v > max){
                        max = v;
                        bestMove = i;
                        //System.out.println("Minimax returned " + max + " for O bestMove" + i);
                    }
                    board[i] = '-';
                }  
                   
                   return bestMove;
                   
            }
            else {
                int min = Integer.MAX_VALUE;
                int bestMove = 0;
                for (int i = 0; i < 9; i++){
                    if(board[i] != '-') continue;
                    board[i] = player;
                    int v = minimax(board, 'O', depth-1);
                    if(v < min){
                        min = v;
                        bestMove = i;
                        //System.out.println("Minimax returned " + min + " for X bestMove" + i);
                    }
                    
                    board[i] = '-';
                }
                   
                   return bestMove;
                }
            
            }

    
}
