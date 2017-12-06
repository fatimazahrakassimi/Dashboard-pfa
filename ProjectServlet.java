package controller;
import service.Iprojet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Projet;
import service.ProjetImpl;
/**
 * Servlet implementation class ProjectServlet
 */
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Iprojet metier; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
public void init() throws ServletException {
		super.init();
		metier = new ProjetImpl();
		
	}

	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			doPost(request, response);
		}


		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String action = request.getParameter("action");
			 if(action!=null){
			 if(action.equals("save")){
				 String nom = request.getParameter("nom");
				 String description =  request.getParameter("description");
				
				 metier.addProjet(new Projet( nom, description));		
			 
			 }
			 else if (action.equals("supp")) {
				 Long id = Long.parseLong(request.getParameter("id"));
				 metier.deleteProjet(id);
			 }
			 
			 else if (action.equals("edit")) {
				 Long id = Long.parseLong(request.getParameter("id"));
				 Projet p = metier.getProjet(id);
				 request.setAttribute("projet", p);
				 
			 }
			 else if (action.equals("Update")) {
				 Long id =Long.parseLong(request.getParameter("projetID"));
				 String nom = request.getParameter("nom");
				 String description =  request.getParameter("description");
			
				 Projet p= new Projet(nom, description);
				 p.setprojetID(id);
				 metier.updateProjet(p);		
				 
			 }
			 }
			 request.setAttribute("Projets", metier.listProjet());
				request.getRequestDispatcher("Projects.jsp").forward(request, response);
		}

}
