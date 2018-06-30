package fileattente.modele;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

@Entity
public class FileAttente {

	private static final int MAX_TAILLE_FILE_ATTENTE = 10;
	private LinkedList<RendezVous> file = new LinkedList<>();
	@Id
	private Long id;
	
	@OneToMany
	@OrderBy("numero")
	private List<RendezVous> rendezVous;
	
	public Long getId() {
		return id;
	}
	
	public boolean isFilePleine() {
		return file.size() >= MAX_TAILLE_FILE_ATTENTE;
	}
}
