package tn.esprit.nids.labo.recherche.persistence;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: projet_chercheur_FK
 *
 */
@Embeddable
public class projet_chercheur_FK implements Serializable {

	private String chercheur_id;
	private int projet_id;
	
	private static final long serialVersionUID = 1L;

	public projet_chercheur_FK() {
		super();
	}

	public String getChercheur_id() {
		return chercheur_id;
	}

	public void setChercheur_id(String chercheur_id) {
		this.chercheur_id = chercheur_id;
	}

	public int getProjet_id() {
		return projet_id;
	}

	public void setProjet_id(int projet_id) {
		this.projet_id = projet_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((chercheur_id == null) ? 0 : chercheur_id.hashCode());
		result = prime * result + projet_id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		projet_chercheur_FK other = (projet_chercheur_FK) obj;
		if (chercheur_id == null) {
			if (other.chercheur_id != null)
				return false;
		} else if (!chercheur_id.equals(other.chercheur_id))
			return false;
		if (projet_id != other.projet_id)
			return false;
		return true;
	}


   
}
