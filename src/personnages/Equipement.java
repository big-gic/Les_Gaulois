package personnages;

public enum Equipement {
	CASQUE("casque"), BOUCLIER("bouclier");
	private String nom;
	
	private Equipement(String nom) {
		this.nom=nom;
	}
	public void toString(Equipement eq) {
		System.out.println(eq.nom);
	}
}
