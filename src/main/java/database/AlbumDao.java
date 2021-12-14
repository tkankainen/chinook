package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Album;

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
}
