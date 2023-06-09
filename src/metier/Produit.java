package metier;

public class Produit {
    private String reference;
    private String libelle;

    private float prix;
    private boolean estDuJour;

    private int quantiteEnStock;
    private static Produit[] lesProduits;


    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public boolean isEstDuJour() {
        return estDuJour;
    }

    public void setEstDuJour(boolean estDuJour) {
        this.estDuJour = estDuJour;
    }

    public int getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(int quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    public Produit() {
    }

    public static void initializeProduits(){
        Produit prod1 = new Produit("PROD_1","BANANE",12,true,200);
        Produit prod2 = new Produit("PROD_2","FRAISE",24,false,500);
        Produit prod3 = new Produit("PROD_3","CAROTTE",27,false,600);

        Produit[] liste = new Produit[3];
        liste[0] = prod1;
        liste[1] = prod2;
        liste[2] = prod3;

        lesProduits = liste;


    }

    public Produit(String reference, String libelle, float prix, boolean estDuJour, int quantiteEnStock) {
        this.reference = reference;
        this.libelle = libelle;
        this.prix = prix;
        this.estDuJour = estDuJour;
        this.quantiteEnStock = quantiteEnStock;
    }

    public static Produit rechercherProduitDuJour(){
        for(int i=0;i<lesProduits.length;i++){
            if(lesProduits[i].estDuJour){
                return lesProduits[i];
            }
        }
        return null;
    }

    public void retirerDuStock(int quantite){
        if(this.quantiteEnStock >= quantite){
            this.quantiteEnStock -= quantite;
        }

    }


}
