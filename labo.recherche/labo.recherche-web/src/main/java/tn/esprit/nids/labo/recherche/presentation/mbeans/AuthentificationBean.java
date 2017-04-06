package tn.esprit.nids.labo.recherche.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.nids.labo.recherche.persistence.Administrateur;
import tn.esprit.nids.labo.recherche.persistence.Chercheur;
import tn.esprit.nids.labo.recherche.persistence.Employe;
import tn.esprit.nids.labo.recherche.persistence.Ingenieur;
import tn.esprit.nids.labo.recherche.services.GererEmployeeServiceLocal;

@ManagedBean
@SessionScoped
public class AuthentificationBean {

	private String login;
	private String password;
	private Employe loggedInEmploye;
	@EJB
	private GererEmployeeServiceLocal employeeServiceLocal;

	public String doLogin() {
		loggedInEmploye = employeeServiceLocal.authentification(login, password);
		if (loggedInEmploye == null) {
			return "/login";
		} else if (loggedInEmploye instanceof Chercheur) {
			return "/chercheur/home?faces-redirect=true";
		} else if (loggedInEmploye instanceof Ingenieur) {
			return "/ingenieur/home?faces-redirect=true";
		} else if (loggedInEmploye instanceof Administrateur) {
			return "/admin/home?faces-redirect=true";
		} else
			return "/login";
	}

	public String doLogOut() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public GererEmployeeServiceLocal getEmployeeServiceLocal() {
		return employeeServiceLocal;
	}

	public void setEmployeeServiceLocal(GererEmployeeServiceLocal employeeServiceLocal) {
		this.employeeServiceLocal = employeeServiceLocal;
	}

	public Employe getLoggedInEmploye() {
		return loggedInEmploye;
	}

	public void setLoggedInEmploye(Employe loggedInEmploye) {
		this.loggedInEmploye = loggedInEmploye;
	}

}
