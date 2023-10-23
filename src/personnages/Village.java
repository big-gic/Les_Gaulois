package personnages;

public class Village {
    private String nom;
    private Chef chef;
    private Gaulois[] villageois;
    private int nbVillageois=0;

    public String getNom() {
        return nom;
    }
    public void setChef(Chef chef) {
        this.chef = chef;
    }
    public Village(String nom, int nbVillageoisMaximum) {
    	this.nom = nom;
    	this.villageois= new Gaulois[nbVillageoisMaximum];
    }
    public void ajouterHabitant(Gaulois gaulois){
        this.villageois[nbVillageois]= gaulois;
        this.nbVillageois++;
    }
    public Gaulois trouverHabitant(int numero) {
                return villageois[numero];
    }
    public void afficherVillageois(){
        if (nbVillageois<=0){
            System.out.println("il n'y a pas de villageois");
        }
        else{
            System.out.println(this.chef.getNom());
            for (int i=0; i<nbVillageois; i++){
                if (villageois[i].getNom()!=this.chef.getNom()){
                    System.out.println(villageois[i].getNom());
                }
            }
        }
    }
    public static void main(String[] args){
        Village village= new Village("Village des Irr�ductibles",30);
        /*Gaulois gaulois = village.trouverHabitant(30);
         * Il y a une erreur parce que le num�ro 30 ne peut pas �tre le num�ro
         * d'un gaulois puisque les num�ros vont de 0 � 29 maximum
         */
        Chef Abra = new Chef("Abraracourcix",6,village);
        village.setChef(Abra);
        Gaulois asterix = new Gaulois("Ast�rix",8);
        village.ajouterHabitant(asterix);
        /*Gaulois gaulois = village.trouverHabitant(1);
        System.out.println(gaulois);
        cela affiche null car le num�ro d'Ast�rix est 0 et non 1
        */
        Gaulois obelix = new Gaulois("Ob�lix", 25);
        village.ajouterHabitant(obelix);
        village.afficherVillageois();
    }    
}