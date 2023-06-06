package metier;

import java.util.Objects;

public class Client {
    private String numero;
    private String nom;
    private String prenom;
    private String pseudo;
    private String motDePasse;
    private static Client[] lesClients;

    public static void initializeClients(){
        Client john = new Client("CLI_1","Stephen","Curry","Threeshooter","goldenState!");
        Client linda = new Client("CLI_2","Blake","Griffin","GiantDunker","Clippers12");
        Client maggy = new Client("CLI_3","Lebron","James","TheKing","Lakers#1");

        Client[] liste = new Client[3];
        liste[0] = john;
        liste[1] = linda;
        liste[2] = maggy;

        lesClients = liste;
    }

    public Client(String numero, String nom, String prenom, String pseudo, String motDePasse) {
        this.numero = numero;
        this.nom = nom;
        this.prenom = prenom;
        this.pseudo = pseudo;
        this.motDePasse = motDePasse;
    }



    public Client() {
    }

    public String getNumero() {
        return numero;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public static Client rechercherClientParPseudo(String pseudo, String mdp){
        for(int i=0;i<lesClients.length;i++){
            if(Objects.equals(lesClients[i].pseudo, pseudo) && Objects.equals(lesClients[i].motDePasse, mdp)){
                return lesClients[i];
            }
        }
        return null;
    }

}
