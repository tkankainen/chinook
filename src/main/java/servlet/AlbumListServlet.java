package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.AlbumDao;
import database.ArtistDao;
import model.Album;
import model.Artist;

@WebServlet("/albums")
public class AlbumListServlet extends HttpServlet{
	
	private AlbumDao albumdao = new AlbumDao();
	private ArtistDao artistdao = new ArtistDao();
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long artistId = Long.parseLong(req.getParameter("artistId"));

		List<Album> albums = this.albumdao.getAlbums(artistId);
		Artist artist = this.artistdao.getArtistByArtistId(artistId);
		
		req.setAttribute("albums", albums);
		req.setAttribute("artist", artist);
		
		req.getRequestDispatcher("/WEB-INF/albumList.jsp").forward(req, resp);
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("album");
		long artistId = Long.parseLong(req.getParameter("artistId")); //?
		
		Album newAlbum = new Album(title, artistId);
		this.albumdao.addAlbum(newAlbum);
		
		List<Album> albums = this.albumdao.getAlbums(artistId);
		Artist artist = this.artistdao.getArtistByArtistId(artistId);
		
		req.setAttribute("albums", albums);
		req.setAttribute("artist", artist);
		
		req.getRequestDispatcher("/WEB-INF/albumList.jsp").forward(req, resp);
	}
}