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

@WebServlet("")
public class IndexServlet extends HttpServlet {
	
	private ArtistDao artistdao = new ArtistDao();
	private AlbumDao albumdao = new AlbumDao();
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchTerm = req.getParameter("searchTerm");
		
		List<Artist> artists = this.artistdao.getArtistByName(searchTerm);
		List<Album> albums = this.albumdao.getAlbumByName(searchTerm);
		
		req.setAttribute("artists", artists);
		req.setAttribute("albums", albums);
		
		req.getRequestDispatcher("/WEB-INF/searchResults.jsp").forward(req, resp);
	}
}