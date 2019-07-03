package it.corsoWebapp.servlet;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.corsoWebapp.model.UtenteDao;
import it.corsoWebapp.model.UtenteVo;

public class UserListServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			UtenteDao ud = new UtenteDao();
			List<UtenteVo> listaUtenti = ud.getAllUsers();
			
			req.setAttribute("listaUtenti", listaUtenti);
			
			getServletContext().getRequestDispatcher("/WEB-INF/pages/ListaUtenti.jsp").forward(req, res);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
