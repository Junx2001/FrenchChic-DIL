package controleur;

import metier.*;
public class TraiterIdentificationReponse {
    public Client leClient = null;
    public Produit leProduit = null;

    public EnumTypeEcran typeEcran;
    public TraiterIdentificationReponse(EnumTypeEcran typeEcran) {
        this.typeEcran = typeEcran;
    }
}
