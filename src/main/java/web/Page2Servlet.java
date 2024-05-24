package web;

import java.io.IOException;
import java.util.List;

import beans.Stage;
import beans.Stagiaire;
import business.StageBusiness;
import business.StageManager;
import business.StagiaireBusiness;
import business.StagiaireManager;
import dao.OracleDataSource;
import dao.StageDao;
import dao.StageDaoImplOrcl;
import dao.StagiaireDao;
import dao.StagiaireDaoImplOrcl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Page2Servlet extends HttpServlet {
	private StageDao sdao;
	private StageBusiness sbusiness ;
	private StagiaireDao stagiairedao;
	private StagiaireBusiness stagiairebusiness;
	
	
	public void init() throws ServletException {
		sdao = new StageDaoImplOrcl(new OracleDataSource());
		sbusiness = new StageManager(sdao);
		stagiairedao = new StagiaireDaoImplOrcl(new OracleDataSource());
		stagiairebusiness = new StagiaireManager(stagiairedao);
	}
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		
		if(url.contains("NvInscription")) {
			int codeStage = Integer.parseInt(req.getParameter("codeStage"));
			Stage s = sbusiness.getById(codeStage);
			//use the code stage to getAll stagiaire in that stage
			//and set it as attribute to add it in the select <option>
			List<Stagiaire> lstagiaire = stagiairebusiness.getStagiaireByCodeStage(""+codeStage); 
			req.setAttribute("s", s);
			req.setAttribute("lstagiaire", lstagiaire);
			req.getRequestDispatcher("views/Page3.jsp").forward(req, resp);	
		}
			
		
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

