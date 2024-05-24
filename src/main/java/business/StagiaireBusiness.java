package business;

import java.util.List;

import beans.Stagiaire;

public interface StagiaireBusiness {
	public void addStagiaire(Stagiaire stagiaire,String codeStage);
	public Stagiaire getStagiaire(String name,String prenom);
	public List<Stagiaire> listAll();
	public List<Stagiaire> getStagiaireByCodeStage(String code_stage);
}
