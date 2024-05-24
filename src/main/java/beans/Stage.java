package beans;

public class Stage {
private String code_stage;
 private String type_stage;
 private String debut_stage ;
 private String fin_stage ;
 private int nbPlace_Stage;
 private int nbInscrit_stage;
 public Stage(String code_stage, String type_stage, String debut_stage, String fin_stage, int nbPlace_Stage,
			int nbInscrit_stage) {
		
		this.code_stage = code_stage;
		this.type_stage = type_stage;
		this.debut_stage = debut_stage;
		this.fin_stage = fin_stage;
		this.nbPlace_Stage = nbPlace_Stage;
		this.nbInscrit_stage = nbInscrit_stage;
	}
@Override
public String toString() {
	return "Stage [code_stage=" + code_stage + ", type_stage=" + type_stage + ", debut_stage=" + debut_stage
			+ ", fin_stage=" + fin_stage + ", nbPlace_Stage=" + nbPlace_Stage + ", nbInscrit_stage=" + nbInscrit_stage
			+ "]";
}
public String getCode_stage() {
	return code_stage;
}
public void setCode_stage(String code_stage) {
	this.code_stage = code_stage;
}
public String getType_stage() {
	return type_stage;
}
public void setType_stage(String type_stage) {
	this.type_stage = type_stage;
}
public String getDebut_stage() {
	return debut_stage;
}
public void setDebut_stage(String debut_stage) {
	this.debut_stage = debut_stage;
}
public String getFin_stage() {
	return fin_stage;
}
public void setFin_stage(String fin_stage) {
	this.fin_stage = fin_stage;
}
public int getNbPlace_Stage() {
	return nbPlace_Stage;
}
public void setNbPlace_Stage(int nbPlace_Stage) {
	this.nbPlace_Stage = nbPlace_Stage;
}
public int getNbInscrit_stage() {
	return nbInscrit_stage;
}
public void setNbInscrit_stage(int nbInscrit_stage) {
	this.nbInscrit_stage = nbInscrit_stage;
}

}
