package business;

import java.util.List;

import beans.Inscription;
import beans.Stagiaire;
import dao.InscriptionDao;
import dao.StagiaireDao;

public class StagiaireManager implements StagiaireBusiness{
	private StagiaireDao std;
	private InscriptionDao idao ;
	
	
	public StagiaireManager() {
	}

	public StagiaireManager(StagiaireDao std) {
		this.std = std;
	}
	public StagiaireManager(StagiaireDao std,InscriptionDao idao) {
		this.std = std;
		this.idao = idao;
	}

	public StagiaireDao getStd() {
		return std;
	}

	public void setStd(StagiaireDao std) {
		this.std = std;
	}

	public void addStagiaire(Stagiaire stagiaire,String codeStage) {
		if(stagiaire.getSexe().contains("Femme")) {
			stagiaire.setSexe("F");
		}else {
			stagiaire.setSexe("M");
		}
		std.insert(stagiaire);
		Inscription i = new Inscription(codeStage, stagiaire.getNum_stagiaire());
		
		idao.insertInscription(i);
	}

	public Stagiaire getStagiaire(String name,String prenom) {
		return std.selectByName(name,prenom);
	}

	public List<Stagiaire> listAll() {
		return std.selectAll();
	}

	
	public List<Stagiaire> getStagiaireByCodeStage(String code_stage) {
		return std.selectStagiaireByCodeStage(code_stage);
	}



}
