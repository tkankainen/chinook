package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Artist;

public class ArtistDao {
	
	private Database db = new Database();

	public List<Artist> getAllArtists() {
		String selectAll = "SELECT ArtistId, Name FROM Artist ORDER BY Name ASC;";
		
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Artist> allArtists = new ArrayList<>();
		try {
			connection = db.connect();
			statement = connection.prepareStatement(selectAll);
			results = statement.executeQuery();
			while(results.next()) {
				long id = results.getLong("artistId");
				String name = results.getString("name");
				
				Artist artist = new Artist(id, name);
				allArtists.add(artist);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return allArtists;
	}
	
    public boolean addArtist(Artist newArtist) {
    	
    	int lines = 0;
		//ResultSet results = null;
    	
    	try (Connection connection = db.connect();
    			PreparedStatement statement = connection.prepareStatement("INSERT INTO Artist (Name) VALUES (?);");){
			String artist = newArtist.getName();
			statement.setString(1, artist);
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
    
    public List<Artist> getArtistByName(String searchTerm) {
    	String select = "SELECT ArtistId, Name FROM Artist WHERE Name LIKE ? ORDER BY Name ASC;";
    	Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		List<Artist> Artists = new ArrayList<>();
		try {
			connection = db.connect();
			statement = connection.prepareStatement(select);
			statement.setString(1, "%" + searchTerm + "%");
			results = statement.executeQuery();
			while(results.next()) {
				long id = results.getLong("artistId");
				String name = results.getString("name");
				
				Artist artist = new Artist(id, name);
				Artists.add(artist);
			}
			return Artists;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return null;
    }
    
    public Artist getArtistByArtistId (long artistId) {
    	String select = "SELECT ArtistId, Name FROM Artist WHERE ArtistId = ?;";
    	Connection connection = null;
		PreparedStatement statement = null;
		ResultSet results = null;
		
		try {
			connection = db.connect();
			statement = connection.prepareStatement(select);
			statement.setLong(1, artistId);
			results = statement.executeQuery();
			while(results.next()) {
				String name = results.getString("name");
				Artist artist = new Artist(artistId, name);
				
				return artist;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.db.close(connection, statement, results);
		}
		return null;
    }
	
}
