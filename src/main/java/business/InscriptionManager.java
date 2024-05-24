package business;

import java.util.List;

import beans.Inscription;
import dao.InscriptionDao;

public class InscriptionManager implements InscriptionBusiness{
	private InscriptionDao insD;
	
	
	public InscriptionManager() {
	}

	public InscriptionManager(InscriptionDao insD) {
		this.insD=insD;
	}

	public InscriptionDao getInsD() {
		return insD;
	}

	public void setInsD(InscriptionDao insD) {
		this.insD = insD;
	}

	public void addInscription(Inscription inscription) {
		insD.insertInscription(inscription);
	}

	public List<Inscription> getInscriptionByCode(String codeInscription) {
		return insD.selectInscriptionByCode(codeInscription);
	}

	
	public void modifyInscription(Inscription inscription) {
		insD.updateInscription(inscription);
		
	}

	
	public void removeInscription(String codeStage, String numStagiaire) {
		insD.deleteInscription(codeStage, numStagiaire);
	}

}
