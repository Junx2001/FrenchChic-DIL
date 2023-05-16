package metier;

import java.util.ArrayList;


public class Commande {
    private float montant;
    private EnumStatutCde statut;
    public static Commande[] lesCommandes;
    private ArrayList<LigneCommande> ligneCommandes;

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }
    public Commande creerPanier(){
        /*this.montant = 0;
        this.statut = EnumStatutCde.NOUVEAU;
        ArrayList<LigneCommande> list = new ArrayList<LigneCommande>();
        this.ligneCommandes = list;*/

        return lesCommandes[0];
    }

    public void ajouterProduit(Produit leProduit, int quantite){
        // Créer Ligne de Commande
        LigneCommande l = new LigneCommande();
        l.setProduit(leProduit);
        l.setQuantite(quantite);
        l.setMontant(leProduit.getPrix() * quantite);
        ligneCommandes.add(l);

        // Get Montant Total du Panier
        float total = 0;
        for(LigneCommande ligne : ligneCommandes){
            total += ligne.getMontant();
        }
        this.montant += total;

        leProduit.retirerDuStock(quantite);
    }

    public ArrayList<LigneCommande> getLesLignesCommande()
    {
        return ligneCommandes;
    }
    public static void initializeCommandes(){
        Commande[] listComm = new Commande[2];
        Commande com1 = new Commande();
        com1.montant = 0;
        com1.statut = EnumStatutCde.NOUVEAU;
        ArrayList<LigneCommande> list = new ArrayList<LigneCommande>();
        com1.ligneCommandes = list;

        listComm[0] = com1;

        Commande com2 = new Commande();
        com2.montant = 2000;
        com2.statut = EnumStatutCde.NOUVEAU;
        ArrayList<LigneCommande> list2 = new ArrayList<LigneCommande>();
        com2.ligneCommandes = list2;

        listComm[1] = com2;

        lesCommandes = listComm;


    }

}
