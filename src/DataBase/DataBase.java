/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author toze
 */
public class DataBase {
    
    private Connection con;
    private boolean tie;
    
    public DataBase(String url){
        try (con = DriverManager.getConnection(url)) {
            tie = true;
        } catch (SQLException e) {
            tie = false;
        }
    }
    
     public DataBase(String url, String username, String password){
        try (con = DriverManager.getConnection(url, username, password)) {
            tie = true;
        } catch (SQLException e) {
            tie = false;
        }
    }
    
    public static void connect(){
        String url = url;
        //String username = "root";
        //String password = "";
        System.out.println("Connecting database...");
        try (Connection connection = DriverManager.getConnection(url)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the tie
     */
    public boolean isTie() {
        return tie;
    }
    
    
    
    
}
