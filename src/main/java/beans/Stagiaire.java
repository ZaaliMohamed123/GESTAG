package beans;

public class Stagiaire {
	String num_stagiaire;
	String nom;
	String prenom;
	String sexe;
	String dateNaiss;
	String diplome;
	public String getNum_stagiaire() {
		return num_stagiaire;
	}
	public void setNum_stagiaire(String num_stagiaire) {
		this.num_stagiaire = num_stagiaire;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getDateNaiss() {
		return dateNaiss;
	}
	public void setDateNaiss(String dateNaiss) {
		this.dateNaiss = dateNaiss;
	}
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public Stagiaire(String num_stagiaire, String nom, String prenom, String sexe, String dateNaiss, String diplome) {
		super();
		this.num_stagiaire = num_stagiaire;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.dateNaiss = dateNaiss;
		this.diplome = diplome;
	}
	@Override
	public String toString() {
		return "Stagiaire [num_stagiaire=" + num_stagiaire + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe
				+ ", dateNaiss=" + dateNaiss + ", diplome=" + diplome + "]";
	}
}
