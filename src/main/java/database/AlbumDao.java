package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Album;
import model.Artist;

public class AlbumDao {
	
	private Database db = new Database();
	
	public List<Album> getAlbums(long artistId) {
		
		List<Album> Albums = new ArrayList<>();
		
		try (Connection connection = db.connect(); 
				PreparedStatement statement = connection.prepareStatement(
				"SELECT AlbumId, Title, ArtistId FROM Album WHERE ArtistId = ? ORDER BY Title ASC;");){
			statement.setLong(1, artistId);
    		
    		try (ResultSet results = statement.executeQuery();) {
		        while (results.next()) {
		        	long albumId = results.getLong("albumId");
					String title = results.getString("title");
					
					Album album = new Album(albumId, title, artistId);
					Albums.add(album);
		        }
	        return Albums;  
    		}
    	} catch (SQLException e) {
	        e.printStackTrace();
	    }
    	return null;
	}
	
	public List<Album> getAlbumByName(String searchTerm) {
		
		List<Album> Albums = new ArrayList<>();
		
		try (Connection connection = db.connect();
	            PreparedStatement statement = connection.prepareStatement(
	            "SELECT AlbumId, ArtistId, Title FROM Album WHERE Title LIKE ? ORDER BY Title ASC;");){
    		statement.setString(1, "%" + searchTerm + "%");
    		
    		try (ResultSet results = statement.executeQuery();) {
		        while (results.next()) {
		        	long albumId = results.getLong("albumId");
					long artistId = results.getLong("artistId");
					String title = results.getString("title");
					
					Album album = new Album(albumId, title, artistId);
					Albums.add(album);
		        }
	        return Albums;  
    		}
    	} catch (SQLException e) {
	        e.printStackTrace();
	    }
    	return null;
    }
	
public boolean addAlbum (Album newAlbum) {
    	
    	int lines = 0;
    	
    	try (Connection connection = db.connect();
    			PreparedStatement statement = connection.prepareStatement("INSERT INTO Album (Title, ArtistId) VALUES (?, ?);");){
			String title = newAlbum.getTitle();
			statement.setString(1, title);
			long artistId = newAlbum.getArtistId();
			statement.setLong(2, artistId);
			lines = statement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	if (lines == 1) {
			return true;
		} else {
			return false;
		}
    }
}