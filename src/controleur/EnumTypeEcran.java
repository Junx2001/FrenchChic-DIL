package controleur;

public enum EnumTypeEcran {
    ECRAN_ACCUEIL("ECRAN_ACCUEIL"), ECRAN_ACCUEIL_PERSO("ECRAN_ACCUEIL_PERSO"), ECRAN_PANIER("ECRAN_PANIER");

    private final String ecran;

    private EnumTypeEcran(String ecran) {
        this.ecran = ecran;
    }

    public String getEcran() {
        return ecran;
    }
}
