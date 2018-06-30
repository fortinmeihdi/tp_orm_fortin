package fileattente.modele;

import java.util.Comparator;

public class RendezVousComparator implements Comparator<RendezVous> {

	@Override
	public int compare(RendezVous rdv1, RendezVous rdv2) {
		if (rdv1.isUrgent() != rdv2.isUrgent()) {
			return rdv1.isUrgent() ? -1 : 1;
		}
		return rdv1.getNumero() - rdv2.getNumero();
	}

}
