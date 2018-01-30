package tictactoe;

import java.util.ArrayList;
import java.util.List;

public class MainGame {

    private char[] board;
    private char currentPlayer;

    public MainGame() {
        board = new char[9];
        currentPlayer = 'X';
        initializeBoard();
    }

    //Gives us access to currentPlayerMark
    public char getCurrentPlayer()
    {
        return currentPlayer;
    }

    public char[] getCurrentBoard()
    {
        return board;
    }

    // Set/Reset the board back to all empty values.
    public void initializeBoard() {

        // Loop through array
        for (int i = 0; i < 9; i++){
                board[i] = '-';
            }
    }
    public void makeBoard(char[] newBoard) {

        // Loop through array
        for (int i = 0; i < 9; i++){
                board[i] = newBoard[i];
            }
    }


    // Print the current board (may be replaced by GUI implementation later)
    public void printBoard() {
        System.out.println("-------------");
        int count = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[count] + " | ");
                count++;
            }
            System.out.println();
            System.out.println("-------------");
        }
    }


    // Loop through all cells of the board and if one is found to be empty (contains char '-') then return false.
    // Otherwise the board is full.
    public boolean isBoardFull() {
        boolean isFull = true;

        for (int i = 0; i < 9; i++) {
                if (board[i] == '-') {
                    isFull = false;
                }
        }
        return isFull;
    }


    // Returns true if there is a win, false otherwise.
    // This calls our other win check functions to check the entire board.
    public boolean isWinner(char play) {
        char player;
        if(play == 'X') player = 'O';
        else player = 'X';
        boolean isWin = false;
        if(
                (board[0] == player && board[1] == board[0] && board[2] == board[0]) ||
                (board[3] == player && board[4] == board[3] && board[5] == board[3]) ||
                (board[6] == player && board[7] == board[6] && board[8] == board[6]) ||
                (board[0] == player && board[3] == board[0] && board[6] == board[0]) ||
                (board[1] == player && board[4] == board[1] && board[7] == board[1]) ||
                (board[2] == player && board[5] == board[2] && board[8] == board[2]) ||
                (board[0] == player && board[4] == board[0] && board[8] == board[0]) ||
                (board[2] == player && board[4] == board[2] && board[6] == board[2])
                ) isWin = true;
        return isWin;
    }


    /*/ Loop through rows and see if any are winners.
    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[i][0], board[i][1], board[i][2]) == true) {
                return true;
            }
        }
        return false;
    }


    // Loop through columns and see if any are winners.
    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (checkRowCol(board[0][i], board[1][i], board[2][i]) == true) {
                return true;
            }
        }
        return false;
    }


    // Check the two diagonals to see if either is a win. Return true if either wins.
    private boolean checkDiagonals() {
        return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));
    }


    // Check to see if all three values are the same (and not empty) indicating a win.
    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }
    
    private int blocker(){
        if ((board[1][1] == 'x' && board[2][2] == 'x') || (board[0][1] == 'x' && board[0][2] == 'x') || (board[1][0] == 'x' && board[2][0] == 'x') && (board[0][0] == '-')){
               return 1;
        }
        else if ((board[0][0] == 'x' && board[0][2] == 'x') || (board[1][1] == 'x' && board[2][1] == 'x') && (board[0][1] == '-')){
               return 2;
        }
        else if ((board[1][1] == 'x' && board[2][0] == 'x') || (board[0][0] == 'x' && board[0][1] == 'x') || (board[1][2] == 'x' && board[2][2] == 'x') && (board[0][2] == '-')){
            System.out.println("Check");   
            return 3;
        }
        else if ((board[0][0] == 'x' && board[2][0] == 'x') || (board[1][1] == 'x' && board[1][2] == 'x') && (board[1][0] == '-')){
            //System.out.println("test");
               return 4;
        }
        else if((board[0][0] == 'x' && board[2][2] == 'x') || (board[0][2] == 'x' && board[2][0] == 'x') || (board[0][1] == 'x' && board[2][1] == 'x')|| (board[1][2] == 'x' && board[1][0] == 'x') && (board[1][1] == '-')){
               return 5;        
        }
        else if ((board[0][2] == 'x' && board[2][2] == 'x') || (board[1][1] == 'x' && board[1][0] == 'x') && (board[1][2] == '-')){
               return 6;
        }
        else if ((board[0][2] == 'x' && board[1][1] == 'x') || (board[0][0] == 'x' && board[1][0] == 'x') || (board[2][1] == 'x' && board[2][2] == 'x') && (board[2][0] == '-')){
               return 7;
        }
        else if ((board[2][0] == 'x' && board[2][2] == 'x') || (board[1][1] == 'x' && board[0][1] == 'x') && (board[2][1] == '-')){
               return 8;
        }
        else if ((board[0][0] == 'x' && board[1][1] == 'x') || (board[2][0] == 'x' && board[2][1] == 'x') || (board[0][2] == 'x' && board[1][2] == 'x') && (board[2][2] == '-')){
               return 9;
        }
        else
            return 0;
    }
    
    private int winner(){
        if ((board[1][1] == 'o' && board[2][2] == 'o') || (board[0][1] == 'o' && board[0][2] == 'o') || (board[1][0] == 'o' && board[2][0] == 'o') && (board[0][0] == '-')){
               return 1;
        }
        else if ((board[0][0] == 'o' && board[0][2] == 'o') || (board[1][1] == 'o' && board[2][1] == 'o') && (board[0][1] == '-')){
               return 2;
        }
        else if ((board[1][1] == 'o' && board[2][0] == 'o') || (board[0][0] == 'o' && board[0][1] == 'o') || (board[1][2] == 'o' && board[2][2] == 'o') && (board[0][2] == '-')){
               return 3;
        }
        else if ((board[0][0] == 'o' && board[2][0] == 'o') || (board[1][1] == 'o' && board[1][2] == 'o') && (board[1][0] == '-')){
               return 4;
        }
        else if((board[0][0] == 'o' && board[2][2] == 'o') || (board[0][2] == 'o' && board[2][0] == 'o') || (board[0][1] == 'o' && board[2][1] == 'o')|| (board[1][2] == 'o' && board[1][0] == 'o') && (board[1][1] == '-')){
               return 5;        
        }
        else if ((board[0][2] == 'o' && board[2][2] == 'o') || (board[1][1] == 'o' && board[1][0] == 'o') && (board[1][2] == '-')){
               return 6;
        }
        else if ((board[0][2] == 'o' && board[1][1] == 'o') || (board[0][0] == 'o' && board[1][0] == 'o') || (board[2][1] == 'o' && board[2][2] == 'o') && (board[2][0] == '-')){
               return 7;
        }
        else if ((board[2][0] == 'o' && board[2][2] == 'o') || (board[1][1] == 'o' && board[0][1] == 'o') && (board[2][1] == '-')){
               return 8;
        }
        else if ((board[0][0] == 'o' && board[1][1] == 'o') || (board[2][0] == 'o' && board[2][1] == 'o') || (board[0][2] == 'o' && board[1][2] == 'o') && (board[2][2] == '-')){
               return 9;
        }
        else
            return 0;
    }
    public int[] checkWin(){
        int location[];
        location = new int[2];
        int win = winner();
        switch(win){
            case 1: location[0] = 0;
                    location[1] = 0;
                    break;
            case 2: location[0] = 0;
                    location[1] = 1;
                    break;
            case 3: location[0] = 0;
                    location[1] = 2;
                    break;
            case 4: location[0] = 1;
                    location[1] = 0;
                    break;
            case 5: location[0] = 1;
                    location[1] = 1;
                    break;
            case 6: location[0] = 1;
                    location[1] = 2;
                    break;
            case 7: location[0] = 2;
                    location[1] = 0;
                    break;
            case 8: location[0] = 2;
                    location[1] = 1;
                    break;
            case 9: location[0] = 2;
                    location[1] = 2;
                    break;
            default: location[0] = 3;
                     location[1] = 3;
                     break;
        }
        return location;
    }
    
    public int[] checkBlock(){
        int location[];
        location = new int[2];
        int block = blocker();
        switch(block){
            case 1: location[0] = 0;
                    location[1] = 0;
                    break;
            case 2: location[0] = 0;
                    location[1] = 1;
                    break;
            case 3: location[0] = 0;
                    location[1] = 2;
                    break;
            case 4: location[0] = 1;
                    location[1] = 0;
                    break;
            case 5: location[0] = 1;
                    location[1] = 1;
                    break;
            case 6: location[0] = 1;
                    location[1] = 2;
                    break;
            case 7: location[0] = 2;
                    location[1] = 0;
                    break;
            case 8: location[0] = 2;
                    location[1] = 1;
                    break;
            case 9: location[0] = 2;
                    location[1] = 2;
                    break;
            default: location[0] = 3;
                     location[1] = 3;
                     break;
        }
        return location;
    }
*/

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
    public boolean placeMark(int mark) {

        // Make sure that row and column are in bounds of the board.
        if ((mark >= 0) && (mark < 9)) {
                if (board[mark] == '-') {
                    board[mark] = currentPlayer;
                    return true;
                }
        }
        return false;
    }
    public void removeMark(int mark) {

        board[mark] = '-';
    }
    
    public boolean isMark(int mark){
        return board[mark] != '-';
    }
    
    public ArrayList availableSpots(){
        ArrayList<Integer> avail = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            if(board[i] == '-'){
                avail.add(i);
            }
        }
        //System.out.println(avail.size());
        return avail;
    }

    boolean blocker(char opp) {
        char player;
        if(opp == 'X') player = 'O';
        else player = 'X';
        /*for(int i = 0; i < 7; i++){
            for(int j = 1; j < 3; j++){
                if(board[i] == player && board[i+j] == board[i])
                    if(board[i+1] == opp || board[i+2] == opp) return true;
                else if(board[i] == player && board[i+j] == board[i])
                    if(i > 0 && board[i-1] == opp) return true;
            }
            
        }*/
        
        if(board[0] == player && board[6] == player && board[3] == opp ||
           board[1] == player && board[7] == player && board[4] == opp ||
           board[2] == player && board[8] == player && board[5] == opp ||
           board[3] == player && board[6] == player && board[0] == opp ||
           board[4] == player && board[7] == player && board[1] == opp ||
           board[5] == player && board[8] == player && board[2] == opp ||
           board[0] == player && board[3] == player && board[6] == opp ||
           board[1] == player && board[4] == player && board[7] == opp ||
           board[2] == player && board[5] == player && board[8] == opp ||
           board[0] == player && board[1] == player && board[2] == opp ||
           board[3] == player && board[4] == player && board[5] == opp ||
           board[6] == player && board[7] == player && board[8] == opp ||
           board[1] == player && board[2] == player && board[0] == opp ||
           board[4] == player && board[5] == player && board[3] == opp ||
           board[7] == player && board[8] == player && board[6] == opp ||
           board[0] == player && board[2] == player && board[1] == opp ||
           board[3] == player && board[5] == player && board[4] == opp ||
           board[6] == player && board[8] == player && board[7] == opp ||
           board[0] == player && board[8] == player && board[4] == opp ||
           board[6] == player && board[2] == player && board[4] == opp ||
           board[0] == player && board[4] == player && board[8] == opp ||
           board[4] == player && board[8] == player && board[0] == opp ||
           board[6] == player && board[4] == player && board[2] == opp ||
           board[2] == player && board[4] == player && board[6] == opp ) return true;
        return false;
    }

}


