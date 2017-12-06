package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Sprint;
import service.Isprint;
import service.SprintImpl;

/**
 * Servlet implementation class ControleurSprint
 */
public class SprintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Isprint sprint ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SprintServlet() {
        super();
        
    }
    public void init() throws ServletException{
    	sprint = new SprintImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("SprintR", sprint.ListSprintR());
		response.sendRedirect("Sprint.jsp");
		//request.getRequestDispatcher("Sprint.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		 if(action!=null){
			if(action.equals("Générer les KPIs réels")){
			int id=Integer.parseInt(request.getParameter("id"));
			int duree=Integer.parseInt(request.getParameter("duree"));
			int nbrPer=Integer.parseInt(request.getParameter("nbrPer"));
			int nbrPo=Integer.parseInt(request.getParameter("nbrPo"));
			int nbrAno=Integer.parseInt(request.getParameter("nbrAno"));
			int charge=duree*nbrPer;
			double velocity=nbrPo/charge;
			double anomaly=nbrAno/charge;
			sprint.addSprint(new Sprint("real",duree,nbrPer,nbrPo,nbrAno,charge,velocity,anomaly));
		}
			if(action.equals("Générer les KPIs estimés")){
				int id=Integer.parseInt(request.getParameter("idsprint"));
				int duree=Integer.parseInt(request.getParameter("duree"));
				int nbrPer=Integer.parseInt(request.getParameter("nbrPer"));
				int nbrPo=Integer.parseInt(request.getParameter("nbrPo"));
				int nbrAno=Integer.parseInt(request.getParameter("nbrAno"));
				int charge=duree*nbrPer;
				double velocity=nbrPo/charge;
				double anomaly=nbrAno/charge;
				sprint.addSprint(new Sprint("estimated",duree,nbrPer,nbrPo,nbrAno,charge,velocity,anomaly));
			}
			else if (action.equals("supp")) {
			 int id = Integer.parseInt(request.getParameter("idsprint"));
			 sprint.deleteSprint(id);
		}
			else if (action.equals("edit")) {
			 int id = Integer.parseInt(request.getParameter("idsprint"));
			 Sprint s = sprint.getSprint(id);
			 request.setAttribute("sprint", s);
			 
		 }
			else if (action.equals("Update")) {
			 int id =Integer.parseInt(request.getParameter("idsprint"));
			 String type=request.getParameter("type");
			 int duree=Integer.parseInt(request.getParameter("duree"));
			int nbrPer=Integer.parseInt(request.getParameter("nbrPer"));
			int nbrPo=Integer.parseInt(request.getParameter("nbrPo"));
			int nbrAno=Integer.parseInt(request.getParameter("nbrAno"));
			int chargeR=duree*nbrPer;
			double velocity=nbrPo/chargeR;
			double anomaly=nbrAno/chargeR;
			Sprint s=new Sprint(type,duree,nbrPer,nbrPo,nbrAno,chargeR,velocity,anomaly);
			s.setId(id);	
			sprint.updateSprint(s);
		 }
		 }
		doGet(request,response);
	}

}
