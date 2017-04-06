package tn.esprit.nids.labo.recherche.persistence;

import java.io.Serializable;

import javax.persistence.*;

@Embeddable
public class Adresse  implements Serializable {
	
	private String cite;
	private String ville;
	private Integer codePostal;
	public String getCite() {
		return cite;
	}
	public void setCite(String cite) {
		this.cite = cite;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public Integer getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(Integer codePostal) {
		this.codePostal = codePostal;
	}
	

}
