package web;

import java.io.IOException;
import java.util.List;

import beans.Stage;
import beans.User;
import business.StageBusiness;
import business.StageManager;
import business.UserBusiness;
import business.UserManager;
import dao.OracleDataSource;
import dao.StageDao;
import dao.StageDaoImplOrcl;
import dao.UserDaoImplOrcl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuhentificationServlet extends HttpServlet {
	private UserBusiness business;
	private UserDaoImplOrcl dao;
	private StageDao sdao;
	private StageBusiness sbusiness ;
	
	
	public void init() throws ServletException {
		dao = new UserDaoImplOrcl(new OracleDataSource());
		business = new UserManager(dao);
		sdao = new StageDaoImplOrcl(new OracleDataSource());
		sbusiness = new StageManager(sdao);
	}
	
	
	protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		String username = req.getParameter("id");
		String password=req.getParameter("mdp");
		User user=new User(username,password);
		if(business.determineExistant(user)) {
			List<Stage> sl = sbusiness.getAllByDate();
			req.setAttribute("sl", sl);
			req.getRequestDispatcher("/views/Page1.jsp").forward(req, resp);
		}
		req.getRequestDispatcher("/html/fail.html").forward(req, resp);
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
		doGet(req, resp);
	}
}
