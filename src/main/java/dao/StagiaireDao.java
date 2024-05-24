package dao;

import java.util.List;

import beans.Stagiaire;

public interface StagiaireDao {
	public void insert(Stagiaire stagiaire);
	public Stagiaire selectByName(String name,String prenom);
	public List<Stagiaire> selectAll();
	public List<Stagiaire> selectStagiaireByCodeStage(String code_stage);
}
