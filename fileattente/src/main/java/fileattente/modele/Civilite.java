package fileattente.modele;

public enum Civilite {
	
	MADAME, MONSIEUR;
	
	@Override
	public String toString() {
		return this == MADAME ? "Madame" : "Monsieur";
	}

}
