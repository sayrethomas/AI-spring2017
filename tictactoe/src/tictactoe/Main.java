package tictactoe;
import static java.lang.Integer.max;
import static java.lang.Integer.min;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javafx.util.Pair;

public class Main {
     
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        MainGame game = new MainGame();
        game.initializeBoard();
        Map<String, Integer> cache = new HashMap<String, Integer>();
        System.out.println("Tic-Tac-Toe!");
        do
        {
            //System.out.println(cache.size());
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
                    mark = minimax(game.getCurrentBoard(), 7, cache);
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
            cache.forEach((k, v)->System.out.println(k+" "+v));
            System.out.println(cache.size());
        }
        else
        {
            System.out.println("Current board layout:");
            game.printBoard();
            game.changePlayer();
            System.out.println(game.getCurrentPlayer() + " IS THE WINNER!");
            cache.forEach((k, v)->System.out.println(k+" "+v));
            System.out.println(cache.size());
        }
    }

      private static Pair<Integer, Integer> minimax(char[][] board, int depth, Map<String, Integer> cache){
            Pair<Integer, Integer> bestMove = new Pair<Integer, Integer> (0, 0);
            int score = Integer.MAX_VALUE;
            MainGame tempGame = new MainGame();
            tempGame.makeBoard(board);
            for (int i = 0; i < tempGame.getGameSize(); i++){
                for (int j = 0; j < tempGame.getGameSize(); j++){
                if(board[i][j] != '-') continue;
                //if(!cache.containsKey(tempGame.getId())) rotater(tempGame.getCurrentBoard(), cache, depth);
                board[i][j] = 'O';
                int temp = maxxer(board, depth, cache);
                if(temp < score){
                    score = temp;
                    bestMove = new Pair<Integer, Integer> (i, j);;
                }
                board[i][j] = '-';  
                }
            }
            return bestMove;
      }
      
    private static int maxxer(char[][] board, int depth, Map<String, Integer> cache) {
        MainGame tempGame = new MainGame();
        tempGame.makeBoard(board);
        if(tempGame.isWinner('X')) return 10;
        else if(tempGame.isWinner('O')) return -10;
        else if(tempGame.isBoardFull() || depth <= 0) return 0;
        //else if(cache.get(tempGame.getId()) != null && cache.get(tempGame.getId()) != 0) return cache.get(tempGame.getId());
        int min = Integer.MIN_VALUE;
        depth = depth-1;
        for (int i = 0; i < tempGame.getGameSize(); i++){
            for (int j = 0; j < tempGame.getGameSize(); j++){
            if(board[i][j] == '-'){
                board[i][j] = 'X';
                //if(!cache.containsKey(tempGame.getId())) rotater(tempGame.getCurrentBoard(), cache, depth);
                min = max(min, minner(board, depth, cache));
                board[i][j] = '-';
            }
            }
        }
        return min;
    }

    private static int minner(char[][] board, int depth, Map<String, Integer> cache) {
        MainGame tempGame = new MainGame();
        tempGame.makeBoard(board);
        if(tempGame.isWinner('X')) return 10;
        else if(tempGame.isWinner('O')) return -10;
        else if(tempGame.isBoardFull() || depth <= 0) return 0;
        //else if(cache.get(tempGame.getId()) != null && cache.get(tempGame.getId()) != 0) return cache.get(tempGame.getId());
        int max = Integer.MAX_VALUE;
        depth = depth-1;
        for (int i = 0; i < tempGame.getGameSize(); i++){
            for (int j = 0; j < tempGame.getGameSize(); j++){
            if(board[i][j] == '-'){
                board[i][j] = 'O';
                //if(!cache.containsKey(tempGame.getId())) rotater(tempGame.getCurrentBoard(), cache, depth);
                max = min(max, maxxer(board, depth, cache));
                board[i][j] = '-';
            }
            }
        }
        
        return max;
    }
    
    private static void rotater(char[][] board, Map<String, Integer> cache, int depth){
        MainGame tempGame = new MainGame();
        tempGame.makeBoard(board);
        int score = 0;
        if(tempGame.isWinner('X')) score = 10;
        else if(tempGame.isWinner('O')) score = -10;
        else if(tempGame.isBoardFull() || depth <= 0) score = 0;
        //else if(!tempGame.isBoardFull()) score = huey(board);
        for(int k = 0; k < 4; k++){
           board = tempGame.getCurrentBoard();
           char[][] newBoard = new char[tempGame.getGameSize()][tempGame.getGameSize()];
           for (int i = 0; i < tempGame.getGameSize(); i++){
                for (int j = 0; j < tempGame.getGameSize(); j++){
                     newBoard[i][j] = board[j][(tempGame.getGameSize()-1)-i];
                }
            }
            tempGame.makeBoard(newBoard);
            //System.out.println(tempGame.getId());
            //if (cache.contains(tempGame.getId())) System.out.println("Contained");
            if (!cache.containsKey(tempGame.getId())) {
                String id = tempGame.getId();
                cache.put(id, score);
            }
        }
    }

    private static int huey(char[][] board) {
        MainGame tempGame = new MainGame();
        tempGame.makeBoard(board);
        int ristic = 0;
        for (int i = 0; i < tempGame.getGameSize(); i++){
                for (int j = 0; j < tempGame.getGameSize(); j++){
                    if(board[i][j] == 'X') ristic++;
                    else ristic--;
                }
            }
        System.out.println(ristic);
        return ristic;
    }
            
}
