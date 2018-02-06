package tictactoe;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;

public class MainGame {

    private char[][] board;
    int gameSize = 3
            ;
    private char currentPlayer;
    private String id = "";

    public MainGame() {
        board = new char[gameSize][gameSize];
        currentPlayer = 'X';
        initializeBoard();
    }
    
    public String getId(){
        id = "";
        for (int i = 0; i < gameSize; i++){
            for (int j = 0; j < gameSize; j++){
                id += board[i][j];
            }
        }
        return id;
    }

    //Gives us access to currentPlayerMark
    public char getCurrentPlayer()
    {
        return currentPlayer;
    }
    
    public int getGameSize()
    {
        return gameSize;
    }
    
    //Gives us access to currentPlayerMark
    public char getOtherPlayer()
    {
        char player;
        if(currentPlayer == 'X')  player = 'O';
        else player = 'X';
        return player;
    }
    
    public char[][] getCurrentBoard()
    {
        return board;
    }

    // Set/Reset the board back to all empty values.
    public void initializeBoard() {

        // Loop through array
        for (int i = 0; i < gameSize; i++){
            for (int j = 0; j < gameSize; j++){
                board[i][j] = '-';
            }
        }
    }
    public void makeBoard(char[][] newBoard) {

        // Loop through array
        for (int i = 0; i < gameSize; i++){
            for(int j = 0; j< gameSize; j++){
                board[i] = newBoard[i];
            }
        }
    }


    // Print the current board (may be replaced by GUI implementation later)
    public void printBoard() {
        String topline = "    ";
        String line = "  -";
        for (int i = 1; i < gameSize+1; i++){
            topline += i + "   ";
            line += "----";
        }
        System.out.println(topline);
        System.out.println(line);
        int count = 1;
        for (int i = 0; i < gameSize; i++) {
            System.out.print(count + " | ");
            count++;
            for (int j = 0; j < gameSize; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println(line);
        }
    }


    // Loop through all cells of the board and if one is found to be empty (contains char '-') then return false.
    // Otherwise the board is full.
    public boolean isBoardFull() {
        boolean isFull = true;

        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                if (board[i][j] == '-') {
                    isFull = false;
                }
            }
        }
        return isFull;
    }


    // Returns true if there is a win, false otherwise.
    // This calls our other win check functions to check the entire board.
    public boolean isWinner(char player) {
        boolean isWin = false;
        if(checkColumn(player) || checkRow(player) || checkDiagonal(player)) isWin = true;
        return isWin;
    }
    
    private boolean checkColumn (char player){
        boolean isCol = false;
        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                if(i < gameSize-2){
                if ((board[i][j] == player) && (board[i+1][j] == player) && (board[i+2][j] == player)) {
                    isCol = true;}
                }
            }
        }
        return isCol;
    }    
    
    private boolean checkRow (char player){
        boolean isRow = false;
        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                if(j < gameSize-2){
                if ((board[i][j] == player) && (board[i][j+1] == player) && (board[i][j+2] == player)) {
                    isRow = true;
                }
                }
            }
        }
        return isRow;
    }

    private boolean checkDiagonal (char player){
        boolean isDia = false;
        for (int i = 0; i < gameSize; i++) {
            for (int j = 0; j < gameSize; j++) {
                if (i < gameSize-2 && j < gameSize-2 ){
                if ((board[i][j] == player) && (board[i+1][j+1] == player) && (board[i+2][j+2] == player)) {
                    isDia = true;}}
                else if(i > gameSize-2 && j < gameSize-2){
                    if ((board[i][j] == player) && (board[i-1][j+1] == player) && (board[i-2][j+2] == player)) {
                        isDia = true;
                    }
                }
            }
        }
        return isDia;
    }
    
    // Change player marks back and forth.
    public void changePlayer() {
        if (currentPlayer == 'X') {
            currentPlayer = 'O';
        }
        else {
            currentPlayer = 'X';
        }
    }

    // Places a mark at the cell specified by row and col with the mark of the current player.
    public boolean placeMark(Pair<Integer, Integer> mark) {

        // Make sure that row and column are in bounds of the board.
        if ((mark.getKey() >= 0) && (mark.getKey() < gameSize+1) && (mark.getValue() >= 0) && (mark.getValue() < gameSize+1)) {
                if (board[mark.getKey()][mark.getValue()] == '-') {
                    board[mark.getKey()][mark.getValue()] = currentPlayer;
                    return true;
                }
        }
        return false;
    }
    public void removeMark(Pair<Integer, Integer> mark) {

        board[mark.getKey()][mark.getValue()] = '-';
    }
    
    public boolean isMark(Pair<Integer, Integer> mark){
        return board[mark.getKey()][mark.getValue()] != '-';
    }
    
}