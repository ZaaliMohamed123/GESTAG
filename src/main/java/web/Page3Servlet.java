package web;

import java.io.IOException;
import java.util.List;

import beans.Inscription;
import beans.Stage;
import beans.Stagiaire;
import business.InscriptionBusiness;
import business.InscriptionManager;
import business.StageBusiness;
import business.StageManager;
import business.StagiaireBusiness;
import business.StagiaireManager;
import dao.InscriptionDao;
import dao.InscriptionDaoImplOrcl;
import dao.OracleDataSource;
import dao.StageDao;
import dao.StageDaoImplOrcl;
import dao.StagiaireDao;
import dao.StagiaireDaoImplOrcl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Page3Servlet extends HttpServlet {
	private StageDao sdao;
	private StageBusiness sbusiness ;
	private StagiaireDao stagiairedao;
	private StagiaireBusiness stagiairebusiness;
	private InscriptionDao idao;
	private InscriptionBusiness ibusiness ;
	
	
	public void init() throws ServletException {
		sdao = new StageDaoImplOrcl(new OracleDataSource());
		sbusiness = new StageManager(sdao);
		stagiairedao = new StagiaireDaoImplOrcl(new OracleDataSource());
		stagiairebusiness = new StagiaireManager(stagiairedao);
		idao = new InscriptionDaoImplOrcl(new OracleDataSource());
		ibusiness  = new InscriptionManager(idao);
	}
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		
		if(url.contains("updateInscription")) {
			String codeStage = req.getParameter("codeStage") ;
			String Nom = req.getParameter("Nom");
			String Prenom = req.getParameter("Prenom");
			String Status = req.getParameter("Status");
			
			Stagiaire stagiaire = stagiairebusiness.getStagiaire(Nom, Prenom);
			Inscription i = new Inscription(codeStage, stagiaire.getNum_stagiaire(), null, Status);
			ibusiness.modifyInscription(i);
			req.getRequestDispatcher("views/Page6.jsp").forward(req, resp);
		}else {
			int codeStage = Integer.parseInt(req.getParameter("codeStage"));
			Stage s = sbusiness.getById(codeStage);
			req.setAttribute("s", s);
			req.getRequestDispatcher("views/Page4.jsp").forward(req, resp);
		}
			
		
	}
	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

