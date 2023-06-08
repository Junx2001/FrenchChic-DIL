package vue;

/*import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;*/

import java.text.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controleur.*;
import metier.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.border.LineBorder;

public class VueJetable {

    static Session laSession;
    static JFrame frame;

    public static void main(String[] args) {
        initialize();

        laSession = new Session();
        TraiterConnexionReponse reponse = laSession.traiterConnexion();
        if (reponse.typeEcran == EnumTypeEcran.ECRAN_ACCUEIL) {
            afficherEcranAccueil();
        }

    }

    private static void afficherEcranAccueil() {
        frame = new JFrame();
        frame.setTitle("French Chic - Login");
        frame.setSize(650, 600);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        JPanel accueilPanel = new JPanel();
        accueilPanel.setBackground(Color.WHITE);
        frame.setContentPane(accueilPanel);
        frame.setLayout(null);

        //initialiserPanel();
        JLabel title = new JLabel("French Chic");
        title.setBorder(null); // Remove the border
        title.setLocation(150, 50);
        title.setSize(1000, 100);

        // set font and color
        try {
            Font italianaFont = Font.createFont(Font.TRUETYPE_FONT, new File("././italiana.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(italianaFont);

            Font f = new Font("Italiana", Font.PLAIN, 65);
            title.setFont(f);
            title.setForeground(Color.decode("#f77983"));
        }
        catch (Exception e) {}


        JLabel pseudoLabel = null;
        JLabel mdpLabel = null;

        pseudoLabel = new JLabel("Pseudo:");
        pseudoLabel.setSize(120, 20);
        pseudoLabel.setLocation(150, 201);
        Font f = new Font("Calibiri", Font.PLAIN, 18);
        pseudoLabel.setFont(f);

        mdpLabel = new JLabel("Mot de passe:");
        mdpLabel.setSize(120, 20);
        mdpLabel.setLocation(150, 270);
        Font mdpFont = new Font("Calibiri", Font.PLAIN, 18);
        mdpLabel.setFont(mdpFont);

        int longueur = 200;
        int largeur = 30;

        final JTextField pseudoField;
        final JPasswordField mdpField;

        pseudoField = new JTextField();
        pseudoField.setSize(longueur-16, largeur);
        pseudoField.setLocation(266, 200);
        // set border radius
        pseudoField.setBorder(new RoundBorder(10));
        pseudoField.setBackground(Color.decode("#EEEEEE"));


        mdpField = new JPasswordField();
        mdpField.setSize(longueur-17, largeur);
        mdpField.setLocation(270, 271);
        // set border radius
        mdpField.setBorder(new RoundBorder(10));
        mdpField.setBackground(Color.decode("#EEEEEE"));

        JButton login = new JButton("S'identifier");
        login.setLocation(150, 340);
        login.setSize(longueur+104, largeur+5);
        // set border radius
        login.setBorder(new RoundBorder(10));
        login.setBackground(Color.decode("#FFD5D4"));


        login.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                TraiterIdentificationReponse reponse = laSession.traiterIdentification(pseudoField.getText(), mdpField.getText());
                frame.setVisible(false);
                System.out.println(reponse.leProduitSemaine);
                if (reponse.typeEcran == EnumTypeEcran.ECRAN_ACCUEIL_PERSO) {
                    afficherEcranAccueilPerso(reponse.leClient, reponse.leProduit,reponse.leProduitSemaine);
                }
            }
        });

        frame.add(title);
        frame.add(pseudoLabel);
        frame.add(mdpLabel);
        frame.add(pseudoField);
        frame.add(mdpField);
        frame.add(login);
        frame.setVisible(true);

    }

    private static void afficherEcranAccueilPerso(final Client client, final Produit produit, final Produit produitSem) {
        frame = new JFrame();
        frame.setTitle("French Chic - Produit du jour");
        frame.setSize(850, 700);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        JPanel accueilPanel = new JPanel();
        accueilPanel.setBackground(Color.WHITE);
        frame.setContentPane(accueilPanel);
        frame.setLayout(null);

        JLabel title = new JLabel("French Chic");
        title.setLocation(70, 50);
        title.setSize(1000, 100);

        // set font and color
        try {
            Font italianaFont = Font.createFont(Font.TRUETYPE_FONT, new File("././italiana.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(italianaFont);

            Font f = new Font("Italiana", Font.PLAIN, 65);
            title.setFont(f);
            title.setForeground(Color.decode("#f77983"));
        }
        catch (Exception e) {}

        JLabel bonjourTexte = null;
        JLabel produitDuJourTexte = null;
        JLabel quantiteProduit = null;
        JLabel quantiteLabel = null;

        JLabel produitDeLaSemaineTexte = null;
        JLabel quantiteProduitSemaine = null;
        JLabel quantiteSemLabel = null;

        String bonjourTxt = "Bonjour " + client.getPrenom() + " " + client.getNom();
        bonjourTexte = new JLabel(bonjourTxt);
        bonjourTexte.setSize(250, 50);
        bonjourTexte.setLocation(70, 145);
        Font f = new Font("Calibiri", Font.PLAIN, 25);
        bonjourTexte.setFont(f);

        JLabel titreProduitJour = new JLabel("<html><u>Produit du jour</u></html>");
        titreProduitJour.setForeground(Color.decode("#f77983"));
        titreProduitJour.setSize(1000, 50);
        titreProduitJour.setLocation(70, 195);
        titreProduitJour.setFont(f);

        String produitTxt = "Le produit du jour est le \"" + produit.getLibelle() + "\" au prix de " + produit.getPrix() + " Euros";
        produitDuJourTexte = new JLabel(produitTxt);
        produitDuJourTexte.setSize(1000, 50);
        produitDuJourTexte.setLocation(70, 240);
        produitDuJourTexte.setFont(f);

        String quantiteProduitJour = "Quantité en stock: " + produit.getQuantiteEnStock();
        quantiteProduit = new JLabel(quantiteProduitJour);
        quantiteProduit.setSize(1000, 50);
        quantiteProduit.setLocation(70, 270);
        quantiteProduit.setFont(f);

        quantiteLabel = new JLabel("Quantite");
        quantiteLabel.setSize(120, 20);
        quantiteLabel.setLocation(70, 315);
        Font textFont = new Font("Calibiri", Font.PLAIN, 18);
        quantiteLabel.setFont(textFont);

        int longueur = 200;
        int largeur = 30;

        final JTextField quantiteField;

        quantiteField = new JTextField();
        quantiteField.setSize(50, 30);
        quantiteField.setLocation(150, 315);
        // set border radius
        quantiteField.setBorder(new RoundBorder(10));
        quantiteField.setBackground(Color.decode("#EEEEEE"));

        JButton ajouterProduit = new JButton("Ajouter le produit du jour au panier");
        ajouterProduit.setLocation(210, 315);
        ajouterProduit.setSize(150, 30);
        // set border radius
        ajouterProduit.setBorder(new RoundBorder(10));
        ajouterProduit.setBackground(Color.decode("#FFD5D4"));

        ajouterProduit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                Integer intg = new Integer(quantiteField.getText());
                TraiterAjoutPanierReponse reponse = laSession.traiterAjoutPanier(produit, intg);
                frame.setVisible(false);
                if (reponse.typeEcran == EnumTypeEcran.ECRAN_PANIER) {
                    afficherEcranPanier(reponse.laCommande);
                }
            }
        });

        JLabel titreProduitSemaine = new JLabel("<html><u>Produit de la semaine</u></html>");
        titreProduitSemaine.setForeground(Color.decode("#f77983"));
        titreProduitSemaine.setSize(1000, 50);
        titreProduitSemaine.setLocation(70, 345);
        titreProduitSemaine.setFont(f);

        String produitTxtSem = "Le produit de la semaine est le \"" + produitSem.getLibelle() + "\" au prix de " + produitSem.getPrix() + " Euros";
        produitDeLaSemaineTexte = new JLabel(produitTxtSem);
        produitDeLaSemaineTexte.setSize(1000, 50);
        produitDeLaSemaineTexte.setLocation(70, 390);
        produitDeLaSemaineTexte.setFont(f);

        String quantiteProduitSem = "Quantité en stock: " + produit.getQuantiteEnStock();
        quantiteProduitSemaine = new JLabel(quantiteProduitSem);
        quantiteProduitSemaine.setSize(1000, 50);
        quantiteProduitSemaine.setLocation(70, 430);
        quantiteProduitSemaine.setFont(f);

        quantiteSemLabel = new JLabel("Quantite");
        quantiteSemLabel.setSize(120, 20);
        quantiteSemLabel.setLocation(70, 475);
        quantiteSemLabel.setFont(textFont);


        final JTextField quantiteFieldSem;

        quantiteFieldSem = new JTextField();
        quantiteFieldSem.setSize(50, 30);
        quantiteFieldSem.setLocation(150, 475);
        // set border radius
        quantiteFieldSem.setBorder(new RoundBorder(10));
        quantiteFieldSem.setBackground(Color.decode("#EEEEEE"));

        JButton ajouterProduitSem = new JButton("Ajouter le produit de la semaine au panier");
        ajouterProduitSem.setLocation(210, 475);
        ajouterProduitSem.setSize(150, 30);
        // set border radius
        ajouterProduitSem.setBorder(new RoundBorder(10));
        ajouterProduitSem.setBackground(Color.decode("#FFD5D4"));

        ajouterProduitSem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                // TODO Auto-generated method stub
                Integer intg = new Integer(quantiteFieldSem.getText());
                TraiterAjoutPanierReponse reponse = laSession.traiterAjoutPanier(produitSem, intg);
                frame.setVisible(false);
                if (reponse.typeEcran == EnumTypeEcran.ECRAN_PANIER) {
                    afficherEcranPanier(reponse.laCommande);
                }
            }
        });

        frame.add(title);
        frame.add(bonjourTexte);
        frame.add(produitDuJourTexte);
        frame.add(quantiteProduit);
        frame.add(quantiteField);
        frame.add(quantiteLabel);
        frame.add(ajouterProduit);

        frame.add(titreProduitSemaine);
        frame.add(produitDeLaSemaineTexte);
        frame.add(quantiteProduitSemaine);
        frame.add(quantiteFieldSem);
        frame.add(quantiteSemLabel);
        frame.add(ajouterProduitSem);
        frame.add(titreProduitJour);
        frame.setVisible(true);
    }

    private static void afficherEcranPanier(Commande laCommande) {
        frame = new JFrame();
        frame.setTitle("French Chic - Panier");
        frame.setSize(800, 800);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        JPanel accueilPanel = new JPanel();
        accueilPanel.setBackground(Color.WHITE);
        frame.setContentPane(accueilPanel);
        frame.setLayout(null);

        /*JLabel title = new JLabel("Votre Panier");
        title.setLocation(150, 50);
        title.setSize(1000, 100);
        Font f = new Font("", Font.PLAIN, 70);
        title.setFont(f);
        title.setForeground(Color.MAGENTA);*/
        JLabel title = new JLabel("French Chic");
        title.setSize(800, 100);

        // set font and color
        try {
            Font italianaFont = Font.createFont(Font.TRUETYPE_FONT, new File("././italiana.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(italianaFont);

            Font f = new Font("Italiana", Font.PLAIN, 70);
            title.setFont(f);
            title.setForeground(Color.decode("#f77983"));
        }
        catch (Exception e) {}

        JLabel subtitle = new JLabel("Vos commandes dans le panier");
        Font f = new Font("Arial", Font.PLAIN, 33);
        subtitle.setFont(f);

        LigneCommande ligneC = laCommande.getLesLignesCommande().get(0);
        NumberFormat nf = NumberFormat.getInstance(Locale.FRENCH);
        nf.setMinimumFractionDigits(2);

        String prixHTLg = nf.format(ligneC.getProduit().getPrix());
        String montantLg = nf.format(ligneC.getMontant());

        String[] entetes = {"Libelle", "Prix HT", "Quantite", "Montant"};

        Object[][] donnees = {
                {ligneC.getProduit().getLibelle(), prixHTLg, new Integer(ligneC.getQuantite()).toString(), montantLg},};

        JTable table = new JTable(donnees, entetes);
        table.setSize(400, 100);
        table.setLocation(125, 200);
        JPanel paneTab = new JPanel();
        paneTab.setLocation(125, 200);
        paneTab.setSize(400, 200);
        paneTab.setBackground(Color.WHITE);
        paneTab.add(table.getTableHeader(), BorderLayout.NORTH);
        paneTab.add(table, BorderLayout.CENTER);

        JLabel montantLabel = null;

        montantLabel = new JLabel("Montant panier : ");
        montantLabel.setSize(140, 20);
        montantLabel.setLocation(200, 423);

        int longueur = 200;
        int largeur = 30;

        final JTextField montantField;

        montantField = new JTextField();
        montantField.setSize(longueur, largeur);
        montantField.setLocation(350, 420);
        montantField.setSize(100, largeur);

        String total = nf.format(laCommande.getMontant());

        String montantTxt = String.valueOf(total) + " Euros";
        montantField.setText(montantTxt);
        montantField.setEditable(false);

        frame.add(title);
        frame.add(subtitle);
        frame.add(montantField);
        frame.add(montantLabel);
        frame.add(paneTab);
        frame.setVisible(true);

    }

    private static void initialize(){
        Client.initializeClients();
        Commande.initializeCommandes();
        Produit.initializeProduits();
    }
}

class RoundBorder extends LineBorder {
    private int cornerRadius;

    public RoundBorder(int cornerRadius) {
        super(Color.decode("#9C9C9C"));
        this.cornerRadius = cornerRadius;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Shape borderShape = new RoundRectangle2D.Double(x, y, width - 1, height - 1, cornerRadius, cornerRadius);
        g2.setStroke(new BasicStroke(getThickness()));
        g2.setColor(getLineColor());
        g2.draw(borderShape);
    }
}
