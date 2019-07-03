package it.corsoWebapp.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.corsoWebapp.model.UtenteDao;
import it.corsoWebapp.model.UtenteVo;

public class UtenteServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) {
		
		try {
			int id = Integer.valueOf(req.getParameter("idUtente"));
			UtenteDao ud = new UtenteDao();
			UtenteVo utente = ud.getUtenteByPK(id);
			
			req.setAttribute("utente", utente);
			
			getServletContext().getRequestDispatcher("/WEB-INF/pages/GetDetails.jsp").forward(req, res);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
