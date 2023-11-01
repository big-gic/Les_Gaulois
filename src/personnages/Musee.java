package personnages;

public class Musee {
	private Trophee[] trophees = new Trophee[200];
	private int nbTrophees=0;
	
	public void donnerTrophees(Trophee trophee) {
		trophees[nbTrophees] = trophee;
		nbTrophees++;
	}
	
	public String extraireInstructionsOCaml() {
		String texte="";
		for (int i=0; i<nbTrophees; i++) {
			texte += "\n"+trophees[i].getNom()+","+(trophees[i].getEquipement()).toString();
		}
		return "let musee = ["+texte+"]";
	}
}
