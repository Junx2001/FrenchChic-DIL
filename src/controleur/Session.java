package controleur;

import metier.*;

public class Session {
    private EnumTypeEcran ecran;

    private Commande commEnCours;
    public TraiterConnexionReponse traiterConnexion(){
        TraiterConnexionReponse trait = new TraiterConnexionReponse(EnumTypeEcran.ECRAN_ACCUEIL);
        return trait;
    }
    public TraiterIdentificationReponse traiterIdentification(String pseudo, String mdp){
        TraiterIdentificationReponse trait = new TraiterIdentificationReponse(EnumTypeEcran.ECRAN_ACCUEIL_PERSO);
        Client cli = Client.rechercherClientParPseudo(pseudo,mdp);
        Produit pro = Produit.rechercherProduitDuJour();
        if(cli!=null && pro!=null){
            trait.leClient = cli;
            trait.leProduit = pro;

        }

        return trait;
    }
    public TraiterAjoutPanierReponse traiterAjoutPanier(Produit produit, Integer qte){
        TraiterAjoutPanierReponse trait = new TraiterAjoutPanierReponse(EnumTypeEcran.ECRAN_PANIER);
        if(commEnCours == null){
            //Commande comm = Commande.lesCommandes[0];
            Commande comm = new Commande();
            commEnCours = comm.creerPanier();
        }
        //commEnCours = commEnCours.creerPanier();
        commEnCours.ajouterProduit(produit, qte);
        trait.laCommande = commEnCours;

        return trait;
    }
    public EnumTypeEcran ecranCourant(){
        return ecran;
    }
}
