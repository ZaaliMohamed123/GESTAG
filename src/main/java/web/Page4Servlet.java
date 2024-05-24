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

public class Page4Servlet extends HttpServlet {
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
		idao = new InscriptionDaoImplOrcl(new OracleDataSource());
		stagiairebusiness = new StagiaireManager(stagiairedao,idao);
		ibusiness  = new InscriptionManager(idao);
	}
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		
		if(url.contains("create")) {
			String numStagiaire = stagiairebusiness.listAll().getLast().getNum_stagiaire();
			String numericPart = numStagiaire.replaceAll("[^\\d]", ""); // Keep only digits
			Integer n = Integer.parseInt(numericPart);
			n = n+1;
			String num = "" + n ;
			String Nom = req.getParameter("Nom");
			String Prenom = req.getParameter("Prenom");
			String DateDeNaissance = req.getParameter("DateDeNaissance");
			String Diplome = req.getParameter("Diplome");
			String Sexe = req.getParameter("Sexe");
			Stagiaire st = new Stagiaire(num, Nom, Prenom, Sexe, DateDeNaissance, Diplome);
			String code_Stage = req.getParameter("codeStage");
			code_Stage = code_Stage.replaceAll("[^\\d]", "");
			Integer codeStage = Integer.parseInt(code_Stage);
			Stage s = sbusiness.getById(codeStage);
			stagiairebusiness.addStagiaire(st,""+ codeStage);
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

