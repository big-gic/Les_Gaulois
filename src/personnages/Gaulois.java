package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees;
	private int effetPotion = 1;
	private Equipement[] trophees = new Equipement[100];

	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "� " + texte + "�");
	}

//	private String prendreParole() {
//		return "Le gaulois " + nom + " : ";
//	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la m�choire de " + romain.getNom());
//		romain.recevoirCoup(force / 3);
//	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] ejecte = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; ejecte != null && i < ejecte.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = ejecte[i];
		}
	}


	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int force) {
		this.effetPotion = force;
		this.parler("Merci Druide, je sens que ma force est " + this.effetPotion + " fois décuplée.");
	}
	
	//	
	
	public void faireUneDonation(Musee musee) {
		if(this.nbTrophees > 0) {
			String texte = "Je donne au musée tous mes trophées :";
			
			for(int i = 0; i < this.nbTrophees; i++) {
				texte += "\n - " + this.trophees[i];
				musee.donnerTrophee(this, this.trophees[i]);
			}
			
			this.parler(texte);
		}
		else {
			this.parler("Je n'ai aucun trophée à donner.");
		}
	}

	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Ast�rix", 8);
		Romain cesar = new Romain("C�sar", 1);
		System.out.println(asterix);
		asterix.prendreParole();
		asterix.parler("YOOOOOOOO !");
		asterix.frapper(cesar);
	}

}
