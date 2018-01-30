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
                    mark = minimax(game.getCurrentBoard(), 'O', 1000);
                }
                
            }
            
            while (!game.placeMark(mark));{      
            game.changePlayer();
            //System.out.println(minimax(game));
        }
        }
        while(!game.isWinner(game.getCurrentPlayer()) && !game.isBoardFull());
        if (game.isBoardFull() && !game.isWinner(game.getCurrentPlayer()))
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

    private static int victor(char[] newBoard, char player){
        MainGame tempGame = new MainGame();
        tempGame.makeBoard(newBoard);
        char opp;
        /*if(player == 'O') opp = 'X';
        else opp = 'O';*/
        if(tempGame.isWinner('O')) return 1;
        else if(tempGame.isWinner('X')) return 2;
        else return 0;      
     }
     private static int score(int point) {
        if(point == 1) return -10;
        else if(point == 2) return 10;
        else return 0;
    }
    /* 
    private static int adv(char[] board, char player) {
        MainGame tempGame = new MainGame();
        tempGame.makeBoard(board);
        if(tempGame.blocker('O')) return 1;
        else if(tempGame.blocker('X')) return 2;
        return 0;
    }
    private static int heur(int point){
        if(point == 1) return 10;
        else if(point == 2) return -10;
        else return 0;
    }*/
      private static int minimax(char[] board, char player, int depth){
            int bestMove = 0;
            int victor = victor(board, player);
            if(victor != 0) return score(victor);
            //int adv = adv(board, player);
            //if(adv != 0) bestMove = heur(adv);
            
           if(depth != 0){
            if(player == 'O'){ 
                int min = Integer.MIN_VALUE;
                for (int i = 0; i < board.length; i++){
                   // System.out.println(i);
                    if(board[i] != '-') continue;
                    board[i] = player;
                    //if(adv != 0) bestMove = heur(adv);
                    int v = minimax(board, 'X', depth-1);
                    if(v > min){
                        min = v;
                        bestMove = i;
                    }
                    board[i] = '-';
                }
                   return bestMove;
                   
            }
            else {
                int max = Integer.MAX_VALUE;
                for (int i = 0; i < board.length; i++){
                    if(board[i] != '-') continue;
                    board[i] = player;
                    
                    int v = minimax(board, 'O', depth-1);
                    //if(adv != 0) bestMove = heur(adv);
                    
                    if(v < max){
                        max = v;
                        bestMove = i;
                    }
                    
                    board[i] = '-';
                }
                   
                   return bestMove;
                } 
                   
                }
                return bestMove;
            }

    
}
