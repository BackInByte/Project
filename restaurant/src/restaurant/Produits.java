package restaurant;

import java.util.LinkedList;
import logger.Logger;
import logger.LoggerFactory;

public class Produits {

    private final LinkedList<Aliment> productList = new LinkedList<>();
    private static Logger logger = LoggerFactory.getLogger("produit");

    public String toString() {
        return productList.toString();
    }

    public LinkedList<Aliment> getProductList() { return productList; }

    //Afficher la liste des aliments
    public void afficherListe(){
        StringBuilder liste = new StringBuilder("\n");
        logger.info("OUTPUT","\nLes produits en vente sont:");
        for (Aliment aliment : this.productList) { liste.append("\t").append(aliment).append("\n");  }
        logger.info("OUTPUT", liste+"\n");
    }

    //Ajouter un aliment à la vente
    private void add (Aliment aliment){
        productList.add(aliment);
    }

    //Créer puis ajouter un aliment à la vente
    private void create_add(String nom, int quantite, double prix){
        Aliment aliment = new Aliment(nom, quantite, prix);
        this.add(aliment);
    }

    //Initialiser les produits mis en vente
    public void initialiser() {
        double inf = Double.POSITIVE_INFINITY;
        create_add("bagel", 20, 8);
        create_add("burger", 10, 10);
        create_add("smoothie", 30, 5);
        create_add("café", (int)inf, 2);
    }


    public static Aliment verification_aliment_existant(String nom_aliment, boolean afficher_message, LinkedList<Aliment> productList){
        Aliment aliment = null; /*l'aliment n'existe pas par défault*/
        for (Aliment aliment_courant : productList) {
            if(aliment_courant.getNom().toLowerCase().compareTo(nom_aliment.toLowerCase())==0){
                aliment = aliment_courant;} //si les chaînes sont identiques, l'aliment existe
        }
        if(aliment == null && afficher_message){
            logger.error("OUTPUT","Ce produit n'est pas proposé à la vente.\n");}
        return aliment;
    }


    public static int getIndexAliment(String nom_aliment, LinkedList<Aliment> productList){
        int compteur = 0, index=0;
        for (Aliment aliment_courant : productList) {
            if(aliment_courant.getNom().toLowerCase().compareTo(nom_aliment.toLowerCase())==0){index=compteur;}
            compteur++;
        }
        return index;
    }

  
    public void ajouter_produit(){
        String nom_aliment = Affichage.choix_chaine(Affichage.output_nom_aliment_ajouter, Affichage.input_nom_aliment_ajouter);
        Aliment aliment = verification_aliment_existant(nom_aliment, false, productList);
        if(aliment==null) { //si l'aliment n'existe pas
            int quantite = (int)Affichage.verification_nombre("entier", Affichage.output_quantite, Affichage.input_quantite);
            double prix = Affichage.verification_nombre("double", Affichage.output_prix, Affichage.input_prix);
            create_add(nom_aliment, quantite, prix);
        } else { //si l'aliment existe déjà
            String stock = Affichage.choix_chaine(Affichage.output_produit_existant, Affichage.input_reponse);
            if (stock.equals("o")){ aliment.setQuantite(augmenter_stock(aliment)); }
        }
    }

  
    public int augmenter_stock(Aliment aliment){
        int quantite = (int)Affichage.verification_nombre("entier", Affichage.output_quantite, Affichage.input_quantite);
        quantite += aliment.getQuantite();
        logger.info("INPUT","Nouvelle quantité :"+quantite+", de l'aliment :"+aliment.getNom() );
        return quantite;
    }

}