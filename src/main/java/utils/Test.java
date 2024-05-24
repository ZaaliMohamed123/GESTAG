package utils;

import dao.OracleDataSource;

import java.lang.reflect.Type;
import java.sql.SQLException;

import beans.Inscription;
import beans.Stagiaire;
import beans.User;
import business.StageBusiness;
import business.StageManager;
import dao.DataSource;
import dao.InscriptionDao;
import dao.InscriptionDaoImplOrcl;
import dao.StageDao;
import dao.StageDaoImplOrcl;
import dao.StagiaireDao;
import dao.StagiaireDaoImplOrcl;
import dao.UserDaoImplOrcl;

public class Test {

	public static void main(String[] args) {
		/*
		
		StagiaireDao st = new StagiaireDaoImplOrcl(new OracleDataSource());
		String numStagiaire = st.selectAll().getLast().getNum_stagiaire();
		String numericPart = numStagiaire.replaceAll("[^\\d]", ""); // Keep only digits
		Integer n = Integer.parseInt(numericPart);
		n = n+1;
		System.out.println(n);
		*/
		
		InscriptionDao i = new InscriptionDaoImplOrcl(new OracleDataSource());
		i.insertInscription(new Inscription("1", "3", "a", "a","a"));
		
		
	}

}
