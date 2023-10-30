package personnages;

public class Romain {
	private String nom;
	private int force;
	private String texte;
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

	public void recevoirCoup(int forceCoup) {
		assert force>0;
		int force1=force;
		force -= forceCoup;
		if (force > 0) {
			parler("A�e");
		} else {
			parler("J'abandonne...");
		}
		assert force1<force;
	}

    public static void main(String[] args) {
        Romain minus = new Romain("Minus", 6);
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.CASQUE);
        minus.sEquiper(Equipement.BOUCLIER);
        minus.sEquiper(Equipement.CASQUE);
    }
}
//public Equipement[] recevoirCoup(int forceCoup) {
//	Equipement[] equipementEjecte = null;
//	// pr�condition
//	assert force > 0;
//	int oldForce = force;
//	forceCoup = CalculResistanceEquipement(forceCoup);
//	force -= forceCoup;
//	// if (force > 0) {
//	// parler("A�e");
//	// } else {
//	// equipementEjecte = ejecterEquipement();
//	// parler("J'abandonne...");
//	// }
//	switch (force) {
//	case 0:
//		parler("A�e");
//	default:
//		equipementEjecte = ejecterEquipement();
//		parler("J'abandonne...");
//		break;
//	}
//	// post condition la force a diminu�e
//	assert force < oldForce;
//	return equipementEjecte;
//}
//
//private int CalculResistanceEquipement(int forceCoup) {
//	texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
//	int resistanceEquipement = 0;
//	if (!(nbEquipement == 0)) {
//		texte += "\nMais heureusement, grace � mon �quipement sa force est diminu� de ";
//		for (int i = 0; i < nbEquipement;) {
//			if ((equipements[i] != null &&
//				equipements[i].equals(Equipement.BOUCLIER)) == true) {
//				resistanceEquipement += 8;
//			} else {
//				System.out.println("Equipement casque");
//				resistanceEquipement += 5;
//			}
//			i++;
//		}
//		texte =+ resistanceEquipement + "!";
//	}
//	parler(texte);
//	forceCoup -= resistanceEquipement;
//	return forceCoup;
//}
//

//private Equipement[] ejecterEquipement() {
//	Equipement[] equipementEjecte = new Equipement[nbEquipement];
//	System.out.println("L'�quipement de " + nom.toString() + "s'envole sous la force du coup.");
//	//TODO
//	int nbEquipementEjecte = 0;
//	for (int i = 0; i < nbEquipement; i++) {
//		if (equipements[i] == null) {
//			continue;
//		} else {
//			equipementEjecte[nbEquipementEjecte] = equipements[i];
//			nbEquipementEjecte++;
//			equipements[i] = null;
//		}
//	}
//	return equipementEjecte;
//}
