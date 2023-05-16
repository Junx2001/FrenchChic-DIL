package metier;

public enum EnumStatutCde {
    NOUVEAU("NOUVEAU"), VALIDE("VALIDE"), PAYE("PAYE");

    private final String statut;

    private EnumStatutCde(String statut) {
        this.statut = statut;
    }

    public String getStatut() {
        return statut;
    }
}
