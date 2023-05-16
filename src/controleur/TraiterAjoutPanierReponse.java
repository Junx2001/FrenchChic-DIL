package controleur;
import metier.*;
public class TraiterAjoutPanierReponse {
    public Commande laCommande = null;

    public EnumTypeEcran typeEcran;
    public TraiterAjoutPanierReponse(EnumTypeEcran typeEcran) {
        this.typeEcran = typeEcran;
    }
}
