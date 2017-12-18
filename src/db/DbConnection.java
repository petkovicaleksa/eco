/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import domen.IndexSlider;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import domen.Photo;
/**
 *
 * @author SonjaAleksa
 */
public class DbConnection {
        private static Connection conn;
    
    public static void getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            
            conn = DriverManager.getConnection("jdbc:mysql://136.243.5.37:33063/eco_test", "root", "cubesqa");
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void close() {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static IndexSlider getIndex(String query){
            IndexSlider i = new IndexSlider();
        try {
            
            Statement st = conn.createStatement();
            ResultSet rs =  st.executeQuery(query);
            
            System.out.println(query);
            
            if(rs.next()){
                i.setId(rs.getInt(1));
                i.setTitle(rs.getString(2));
                i.setDescription(rs.getString(3));
                i.setLinkType(rs.getString(4));
                i.setLinkLabel(rs.getString(5));
                i.setDeleted(false);
                } else {
                i.setDeleted(true);
            
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
        }
     public static Photo getPhoto(String query){
            Photo p = new Photo();
        try {
            
            Statement st = conn.createStatement();
            ResultSet rs =  st.executeQuery(query);
            
            System.out.println(query);
            
            if(rs.next()){
                p.setId(rs.getInt(1));
                p.setTitle(rs.getString(2));
                p.setDescription(rs.getString(3));
                p.setDeleted(false);
                } else {
                p.setDeleted(true);
            
            
                
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
        }
     public static Boolean isDeleted(String query) {

        try {

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);

            System.out.println(query);

            if (rs.next()) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

   
}
