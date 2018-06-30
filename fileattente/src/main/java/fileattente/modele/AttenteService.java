package fileattente.modele;

import java.util.LinkedList;
import java.util.Queue;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Stateless
public class AttenteService {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("fileAttente");
	
	private int numeroSuivant;
	private LinkedList<RendezVous> file = new LinkedList<>();
	private final RendezVousComparator rendezVousComparator = new RendezVousComparator();
	
	public void mettreEnAttente(Civilite civilite, String prenom, String nom, boolean urgent) throws RendezVousInvalideException, FileAttentePleineException {
		FileAttente file = new FileAttente();
		if (file.isFilePleine()) {
			throw new FileAttentePleineException();
		}

		RendezVousInvalideException ex = new RendezVousInvalideException();
		if (civilite == null) {
			ex.addMessage("civilite", "La civilite doit être renseignée !");
		}
		if (prenom == null || prenom.isEmpty()) {
			ex.addMessage("prenom", "Le prénom doit être renseigné !");
		}
		if (nom == null || nom.isEmpty()) {
			ex.addMessage("nom", "Le nom doit être renseigné !");
		}
		if (ex.mustBeThrown()) {
			throw ex;
		}
		
		RendezVous rendezVous = new RendezVous(++numeroSuivant, civilite, prenom, nom, urgent);
		mettreEnAttente(rendezVous);
	}

	private void mettreEnAttente(RendezVous rendezVous) {
		int index = 0;
		for(RendezVous precedentRendezVous : this.file) {
			if (rendezVousComparator.compare(rendezVous, precedentRendezVous) < 0) {
				break;
			}
			index++;
		}
		file.add(index, rendezVous);
	}

	public void passerAuSuivant() {
		file.pollFirst();
	}
	
	public Queue<RendezVous> getFile() {
		return file;
	}
}
