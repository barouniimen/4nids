package tn.esprit.nids.labo.recherche.presentation.mbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import tn.esprit.nids.labo.recherche.persistence.Employe;
import tn.esprit.nids.labo.recherche.services.GererEmployeeServiceLocal;

@ManagedBean
@ViewScoped
public class GererEmployeeBean {

	private List<Employe> employes;
	@EJB
	private GererEmployeeServiceLocal gererEmployeLocal;
	private Employe employeMiseAjour;
	private Boolean renderUpdateForm;

	@PostConstruct
	public void init() {
		renderUpdateForm = false;
		employeMiseAjour = new Employe();
		employes = gererEmployeLocal.ListerEmploye();
	}

	public String mettreAjour() {
		try {
			gererEmployeLocal.modifierEmployee(employeMiseAjour);
			FacesMessage facesMessage = new FacesMessage("Mise à jour avec succes");
			FacesContext.getCurrentInstance().addMessage("updateForm:idBtn", facesMessage);

		} catch (Exception e) {
			FacesMessage facesMessage = new FacesMessage("Problème de mise à jour!");
			FacesContext.getCurrentInstance().addMessage("updateForm:idBtn", facesMessage);
		}

		return null;
	}

	public List<Employe> getEmployes() {
		return employes;
	}

	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}

	public Employe getEmployeMiseAjour() {
		return employeMiseAjour;
	}

	public void setEmployeMiseAjour(Employe employeMiseAjour) {
		this.employeMiseAjour = employeMiseAjour;
	}

	public Boolean getRenderUpdateForm() {
		return renderUpdateForm;
	}

	public void setRenderUpdateForm(Boolean renderUpdateForm) {
		this.renderUpdateForm = renderUpdateForm;
	}

}
