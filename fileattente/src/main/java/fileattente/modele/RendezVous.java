package fileattente.modele;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RendezVous {
	
	@Id
	private int id;
	
	private int numero;
	private Civilite civilite;
	private String prenom;
	private String nom;
	private boolean urgent;
	private Date date;
	
	public RendezVous(int numero, Civilite civilite, String prenom, String nom, boolean urgent) {
		this.numero = numero;
		this.civilite = civilite;
		this.prenom = prenom;
		this.nom = nom;
		this.urgent = urgent;
		this.date = new Date();
	}
	
	public Civilite getCivilite() {
		return civilite;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNom() {
		return nom;
	}

	public Date getDate() {
		return date;
	}

	public int getNumero() {
		return numero;
	}
	
	public boolean isUrgent() {
		return urgent;
	}
}
