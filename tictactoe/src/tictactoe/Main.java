package tictactoe;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.util.Pair;

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
            int row, col;
            Pair <Integer, Integer> mark;
            do
            {
                if(game.getCurrentPlayer() == 'X'){
                    System.out.println("Player " + game.getCurrentPlayer() + ", enter an empty location 1-9!");
                    row = scan.nextInt()-1;
                    col = scan.nextInt()-1;
                    mark = new Pair<Integer, Integer> (row, col);
                }
                else{
                    mark = minimax(game.getCurrentBoard(), 1);
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

      private static Pair<Integer, Integer> minimax(char[][] board, int depth){
            Pair<Integer, Integer> bestMove = new Pair<Integer, Integer> (0, 0);
            int score = Integer.MAX_VALUE;
            MainGame tempGame = new MainGame();
            tempGame.makeBoard(board);
            for (int i = 0; i < tempGame.getGameSize(); i++){
                for (int j = 0; j < tempGame.getGameSize(); j++){
                if(board[i][j] != '-') continue;
                board[i][j] = 'O';
                int temp = maxxer(board, 0, depth);
                if(temp < score){
                    score = temp;
                    bestMove = new Pair<Integer, Integer> (i, j);;
                }
                board[i][j] = '-';  
                }
            }
            return bestMove;
      }
      
    private static int maxxer(char[][] board, int level, int depth) {
        MainGame tempGame = new MainGame();
        tempGame.makeBoard(board);
        //tempGame.printBoard();
        if(tempGame.isWinner('X')) return 10;
        else if(tempGame.isWinner('O')) return -10;
        else if(tempGame.isBoardFull() || depth <= 0) return 0;
        int min = Integer.MIN_VALUE;
        depth = depth-1;
        for (int i = 0; i < tempGame.getGameSize(); i++){
            for (int j = 0; j < tempGame.getGameSize(); j++){
            if(board[i][j] == '-'){
                board[i][j] = 'X';
                min = max(min, minner(board, level+1, depth)-level);
                board[i][j] = '-';
            }
            }
        }
        return min;
    }

    private static int minner(char[][] board, int level, int depth) {
        MainGame tempGame = new MainGame();
        tempGame.makeBoard(board);
        //tempGame.printBoard();
        if(tempGame.isWinner('X')) return 10;
        else if(tempGame.isWinner('O')) return -10;
        else if(tempGame.isBoardFull() || depth <= 0) return 0;
        int max = Integer.MAX_VALUE;
        depth = depth-1;
        for (int i = 0; i < tempGame.getGameSize(); i++){
            for (int j = 0; j < tempGame.getGameSize(); j++){
            if(board[i][j] == '-'){
                board[i][j] = 'O';
                max = min(max, maxxer(board, level+1, depth)+level);
                board[i][j] = '-';
            }
            }
        }
        
        return max;
    }
            
}
