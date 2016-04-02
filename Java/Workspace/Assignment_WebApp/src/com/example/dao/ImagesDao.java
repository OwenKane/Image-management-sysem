package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.business.Images;
import com.example.exceptions.DaoException;

public class ImagesDao extends Dao{
   
    public List<Images> getAllImages() throws DaoException {
    	
    	List<Images> mylist = new ArrayList<Images>();
    	
    	Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Images i = null;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM IMAGES ORDER BY RATING / NUM_OF_RATING DESC";
            ps = con.prepareStatement(query);
           
            rs = ps.executeQuery();
            while (rs.next()) {
            	int imageId = rs.getInt("ID");
                String title = rs.getString("TITLE");
                int rating = rs.getInt("RATING");
                int Norating = rs.getInt("NUM_OF_RATING");
                String fileName = rs.getString("FILENAME");
                i = new Images(imageId, title, rating, Norating, fileName);
                
                mylist.add(i);
            }
        } catch (SQLException e) {
            throw new DaoException("List Images: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("List Images:" + e.getMessage());
            }
        }
    	
    	return mylist;
    	
    }
    
    public List<Images> GetFromTitle(String userTitle) throws DaoException {
    	
    	List<Images> mylist = new ArrayList<Images>();
    	
    	Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Images i = null;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM IMAGES WHERE TITLE = ?";
            ps = con.prepareStatement(query);
            ps.setString(1, userTitle);
           
            rs = ps.executeQuery();
            while (rs.next()) {
            	int imageId = rs.getInt("ID");
                String title = rs.getString("TITLE");
                int rating = rs.getInt("RATING");
                int Norating = rs.getInt("NUM_OF_RATING");
                String fileName = rs.getString("FILENAME");
                i = new Images(imageId, title, rating, Norating, fileName);
                
                mylist.add(i);
            }
        } catch (SQLException e) {
            throw new DaoException("List Images: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("List Images:" + e.getMessage());
            }
        }
    	
    	return mylist;
    	
    }
    
    public Images GetOneFromID(int id) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Images i = null;
        try {
            con = this.getConnection();
            
            String query = "SELECT * FROM images WHERE id = ?";
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            
            rs = ps.executeQuery();
            if (rs.next()) {
            	int imageId = rs.getInt("ID");
                String title = rs.getString("TITLE");
                int rating = rs.getInt("RATING");
                int Norating = rs.getInt("NUM_OF_RATING");
                String fileName = rs.getString("FILENAME");
                i = new Images(imageId, title, rating, Norating, fileName);
            }
        } catch (SQLException e) {
            throw new DaoException("GetOneFromID " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("findUserByUsernamePassword" + e.getMessage());
            }
        }
        return i;     // i may be null 
    }
    
    public Images AddRating(int id, int rating, int numOfRatings) throws DaoException {

        Connection con = null;
        PreparedStatement ps = null;
        Images i = null;
        try {
            con = this.getConnection();
            
            String query = "UPDATE IMAGES SET RATING = ? , NUM_OF_RATING = ? WHERE ID = " + id;
            ps = con.prepareStatement(query);
            ps.setInt(1, rating);
            System.out.println(rating);
            
            ps.setInt(2, numOfRatings);
            System.out.println(numOfRatings);
            
            ps.executeUpdate();
                       
        } catch (SQLException e) {
            throw new DaoException("AddRating" + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    freeConnection(con);
                }
            } catch (SQLException e) {
                throw new DaoException("AddRating" + e.getMessage());
            }
        }
        return i;     // i may be null 
    }
}
