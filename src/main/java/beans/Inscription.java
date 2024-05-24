package beans;

public class Inscription {
	private String code_stage;
	private String num_stagiaire;
	private String date_inscription;
	private String status_insc ;
	private String code_position;
	public Inscription(String code_stage, String num_stagiaire, String date_inscription, String status_insc,
			String code_position) {
		super();
		this.code_stage = code_stage;
		this.num_stagiaire = num_stagiaire;
		this.date_inscription = date_inscription;
		this.status_insc = status_insc;
		this.code_position = code_position;
	}
	
	public Inscription(String code_stage, String num_stagiaire, String date_inscription, String status_insc) {
		super();
		this.code_stage = code_stage;
		this.num_stagiaire = num_stagiaire;
		this.date_inscription = date_inscription;
		this.status_insc = status_insc;
		this.code_position = "0";
	}
	
	public Inscription(String code_stage, String num_stagiaire) {
		super();
		this.code_stage = code_stage;
		this.num_stagiaire = num_stagiaire;
		this.date_inscription = "a";
		this.status_insc = "V";
		this.code_position = "0";
	}
	
	
	
	public String getCode_stage() {
		return code_stage;
	}
	public void setCode_stage(String code_stage) {
		this.code_stage = code_stage;
	}
	public String getNum_stagiaire() {
		return num_stagiaire;
	}
	public void setNum_stagiaire(String num_stagiaire) {
		this.num_stagiaire = num_stagiaire;
	}
	public String getDate_inscription() {
		return date_inscription;
	}
	public void setDate_inscription(String date_inscription) {
		this.date_inscription = date_inscription;
	}
	public String getStatus_insc() {
		return status_insc;
	}
	public void setStatus_insc(String status_insc) {
		this.status_insc = status_insc;
	}
	public String getCode_position() {
		return code_position;
	}
	public void setCode_position(String code_position) {
		this.code_position = code_position;
	}
	@Override
	public String toString() {
		return "Inscription [code_stage=" + code_stage + ", num_stagiaire=" + num_stagiaire + ", date_inscription="
				+ date_inscription + ", status_insc=" + status_insc + ", code_position=" + code_position + "]";
	}
	
}
