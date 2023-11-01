package personnages;

public class Gaulois {
	private String nom;
	private int force;
	private int nbTrophees=0;
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
	
	public int getForce() {
		return force;
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
	
	public void faireUneDonnation(Musee musee) {
		if (nbTrophees!=0) {
			parler("Je donne au musee tous mes trophees :");
			for (int i=0; i<nbTrophees; i++) {
				System.out.println("-"+trophees[i]+"\n");
			}
			Trophee troph = new Trophee(this,this.trophees);
			musee.donnerTrophees(troph);
			
		}else {
			System.out.println("je n'ai rien à donner");
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
