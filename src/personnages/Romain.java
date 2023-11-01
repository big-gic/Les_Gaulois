package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;

	public Romain(String nom, int force) {
		assert force > 0;
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

	public void sEquiper(Equipement equipement) {
		switch (nbEquipement) {
		case 0:
			equipements[nbEquipement] = equipement;
			nbEquipement++;
			afficherMessageEquipement("s'équipe avec un", equipement);
			break;
		case 1:
			if (equipements[0] == equipement) {
				afficherMessageEquipement("possède déjà", equipement);
			} else {
				equipements[nbEquipement] = equipement;
				nbEquipement++;
				afficherMessageEquipement("s'équipe avec un", equipement);
			}
			break;
		case 2:
			afficherMessageEquipement("est déjà bien protégé", null);
			break;
		default:
			System.out.println("problème dans sEquiper()");
			break;
		}
	}

	private void afficherMessageEquipement(String message, Equipement equipement) {
		if (equipement != null) {
			System.out.println("Le soldat " + nom + " " + message + " " + equipement + ".");
		} else {
			System.out.println("Le soldat " + nom + " " + message + " !");
		}
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		assert force>0;
//		int force1=force;
//		force -= forceCoup;
//		if (force > 0) {
//			parler("A�e");
//		} else {
//			parler("J'abandonne...");
//		}
//		assert force1<force;
//	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;

		// précondition
		assert this.force > 0;

		int oldForce = this.force;

		forceCoup = calculResistanceEquipement(forceCoup);
		this.force -= forceCoup;

		if(this.force == 0) { parler("Aïe"); }
		
		equipementEjecte = ejecterEquipement();
		parler("J'abandonne...");

		// post condition la force a diminuée
		assert this.force < oldForce;

		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;

		int resistanceEquipement = 0;

		if(nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";

			for (int i = 0; i < nbEquipement; i++) {
				if(equipements[i] != null) {
					if(equipements[i].equals(Equipement.BOUCLIER)) {
						resistanceEquipement += 8;
					} else if(equipements[i].equals(Equipement.CASQUE)) {
						System.out.println("Equipement casque");
						resistanceEquipement += 5;
					}
				}
			}

			texte += resistanceEquipement + "!";
		}

		parler(texte);

		forceCoup -= resistanceEquipement;
		return forceCoup < 0 ? 0 : forceCoup;
	}

	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'�quipement de " + nom + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}

	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
	}
}
