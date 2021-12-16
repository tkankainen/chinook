package servlet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.http.HttpResponse;
import java.sql.Connection;
import java.util.List;

import org.apache.catalina.LifecycleException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import database.AlbumDao;
import database.ArtistDao;
import database.Database;
import model.Album;
import model.Artist;
import testserver.TestServer;

public class ServletTest {
	
	private ArtistDao artistdao = new ArtistDao();
	private AlbumDao albumdao = new AlbumDao();

    @BeforeAll
    public static void startServer() throws LifecycleException {
        TestServer.start();
    }

    @AfterAll
    public static void stopServer() throws LifecycleException {
        TestServer.stop();
    }
    
    @BeforeEach
    public void setUp() throws Exception {
    	
    	Database db = new Database();
        Connection connection = db.connect();
        
        connection.prepareStatement("DELETE from Artist").executeUpdate();
        connection.prepareStatement("DELETE from Album").executeUpdate();
        connection.prepareStatement("INSERT INTO Artist (artistId, name) values (1, 'Bon Iver'), (2, 'Sufjan Stevens'), (3, 'Billy Joel')").executeUpdate();
        connection.prepareStatement("INSERT INTO Album (title, artistId) values ('22, A Million', 1), ('For Emma, Forever Ago', 1), ('Illinois', 2)").executeUpdate();
        connection.close();
    } 
    
    @Test
    public void testNewArtistIsAdded() {
    	Artist newArtist = new Artist("The National");
    	
		assertTrue(artistdao.addArtist(newArtist));
    }
    
    @Test
    public void testFirstArtistAlphabetically() {
    	List<Artist> artists = this.artistdao.getAllArtists();
        Artist first = artists.get(0);

        assertEquals("Billy Joel", first.getName() );
    }
    
    @Test
    public void testLastAlbumFromBonIver() {
    	List<Album> albums = this.albumdao.getAlbums(1);
        Album last = albums.get(1);

        assertEquals("For Emma, Forever Ago", last.getTitle() );
    }
    
    @Test
    public void testSearchArtistOrAlbum() {
    	
    	String searchTerm = "ill";
    	
    	List<Artist> artists = this.artistdao.getArtistByName(searchTerm);
    	String name = "";
    	for (Artist artist: artists) {
    		name = name + artist.getName();
    		}
    	
    	List<Album> albums = this.albumdao.getAlbumByName(searchTerm);
    	System.out.println(albums);
    	String title = "";
    	for (Album album: albums) {
    		title = title + album.getTitle();
    		}
    	
    	assertTrue(name.contains("ill") && title.contains("ill"));
    }

    @Test
    public void frontPageReturnsHttp200() {
        HttpResponse<String> response = TestServer.get("/");

        assertEquals(200, response.statusCode());
    }

    @Test
    public void frontPageContainsCorrectText() {
        HttpResponse<String> response = TestServer.get("/");

        assertTrue(response.body().contains("Search artist"));
    }

    @Test
    public void pagesHaveUtf8Encoding() {
        HttpResponse<String> response = TestServer.get("/");

        String contentType = response.headers().firstValue("Content-Type").get().toLowerCase();

        assertTrue(contentType.contains("utf-8"));
        assertTrue(contentType.contains("text/html"));
    }

    @Test
    public void nonexistingPathsReturnHttp404() {
        HttpResponse<String> response = TestServer.get("/this-is-not-found");

        assertEquals(404, response.statusCode());
    }
}
