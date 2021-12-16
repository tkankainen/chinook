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
		String selectAlbums = "SELECT albumId, title, artistId FROM Album WHERE artistId = ? ORDER BY title ASC;";
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Album> Albums = new ArrayList<>();
		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectAlbums);
			statement.setLong(1, artistId);
			results = statement.executeQuery();
			
			while(results.next()) {
				long albumId = results.getLong("albumId");
				String title = results.getString("title");
				
				Album album = new Album(albumId, title, artistId);
				Albums.add(album);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return Albums;
	}
	
	public List<Album> getAlbumByName(String searchTerm) {
    	String select = "SELECT albumId, artistId, title FROM Album WHERE title LIKE ? ORDER BY title ASC;";
    	Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Album> Albums = new ArrayList<>();
		try {
			connection = db.connect();
			statement = connection.prepareStatement(select);
			statement.setString(1, "%" + searchTerm + "%");
			results = statement.executeQuery();
			while(results.next()) {
				long albumId = results.getLong("albumId");
				long artistId = results.getLong("artistId");
				String title = results.getString("title");
				
				Album album = new Album(albumId, title, artistId);
				Albums.add(album);
			}
			return Albums;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return null;
    }
	
public boolean addAlbum (Album newAlbum) {
    	
    	int lines = 0;
		//ResultSet results = null;
    	
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
