package business;

import java.util.List;

import beans.Inscription;

public interface InscriptionBusiness {
	public void addInscription(Inscription inscription);
	public List<Inscription> getInscriptionByCode(String codeInscription);
	public void modifyInscription(Inscription inscription);
	public void removeInscription(String codeStage, String numStagiaire);
}
