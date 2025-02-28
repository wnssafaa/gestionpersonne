package controlleur;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connexionDb.mydatabase;
import dao.peersonnemetier;
import models.personne;

/**
 * Servlet implementation class myServelet
 */
@WebServlet("/myServelet")
public class myServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public myServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        peersonnemetier e = new peersonnemetier();
        String id = request.getParameter("id");

        if(id != null) {
            peersonnemetier.supprimerpersonne(Integer.parseInt(id));
            response.sendRedirect("myServelet");
        } else {
            List<personne> personnes = peersonnemetier.Listpersonnes();
            System.out.println("Nombre de personnes envoyées à JSP: " + personnes.size()); // 🛠 DEBUG
            request.setAttribute("Listpersonnes", personnes);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nom = request.getParameter("nom");
        int age = Integer.parseInt(request.getParameter("age"));
        
        peersonnemetier e = new peersonnemetier();
        peersonnemetier.ajouterpersonne(new personne(nom, age));

    response.sendRedirect("myServelet");

    }


}
