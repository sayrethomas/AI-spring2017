package javasnake;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class createLog {

    //Connect to SQL
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/users/sayre/projects/JAVA-project1/Snake/db/snakeLogs.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    //Create New Table
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/users/sayre/projects/JAVA-project1/Snake/db/snakeLogs.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS scores (\n"
                + "	gNo integer PRIMARY KEY,\n"
                + "	score integer NOT NULL,\n"
                + "	length integer\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            System.out.println("Success");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Insert into DB    
    public void insert(int score, int length) {
        String sql = "INSERT INTO scores(score, length) VALUES(?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, score);
            pstmt.setInt(2, length);
            pstmt.executeUpdate();
            System.out.println("Inserted");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //Return highest score from DB
     public String selectHigh(){
        String sql = "SELECT  MAX(score) FROM scores";
        String o = "";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                o = ("Score: " + rs.getInt(1));
            }
            return o;
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    //Clear entire Table
    public void delete() {
        String sql = "DELETE FROM scores";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // execute the delete statement
            pstmt.executeUpdate();
             System.out.println("Deleted");
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void main(String[] args){
        //createNewTable();
        createLog log = new createLog();
        log.selectHigh();
        //log.delete();
       
    }
    
    
}
