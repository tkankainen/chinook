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

@WebServlet("/albums")
public class AlbumListServlet extends HttpServlet{
	
	private AlbumDao dao = new AlbumDao();
	private ArtistDao artistdao = new ArtistDao();
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		long artistId = Long.parseLong(req.getParameter("artistId"));
		
		//req.setAttribute("artistId", artistId);

		List<Album> albums = this.dao.getAlbums(artistId);
		//hae artisti -- joku getartistbyalbumid?
		//resp.getWriter().println(albums);
		
		req.setAttribute("albums", albums);
		req.getRequestDispatcher("/WEB-INF/albumList.jsp").forward(req, resp);
		
		//if-lause, jos albums empty (tai artist?), notfound.jsp? tai virheilmoitus albumList.jsp
	}
}
