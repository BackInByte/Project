package restaurant;

import logger.Logger;
import logger.LoggerFactory;

public class Caisse {

    private java.text.DecimalFormat df = new java.text.DecimalFormat("0.##");
    private Logger logger = LoggerFactory.getLogger("caisse");
    private static double total_TVA = 0;
    private static double total_benefices = 0;
    private static double total_rentrees_argent = 0;


    //A l'arrivée des clients dans le restaurant, on ouvre une note
    public void ouvrir_note(Clients clients){
        clients.afficherListe(false);//clients déjà présents
        String nom_client = Affichage.choix_chaine(Affichage.output_note_client_ouvrir, Affichage.input_note_client_ouvrir);
        Note note_client = clients.verification_client_existant(nom_client, false);
        if(note_client == null) {//s'il s'agit d'un nouvrau client, on lui crée une note
            clients.creer_note(nom_client);
        } else  note_client.afficherListe();
    }

  
    //Lors d'une commande d'un client
    public void enregistrer(Clients clients, Produits produits){
        clients.afficherListe(true);
        if(clients.getNoteList().size()!=0){
            String nom_client = Affichage.choix_chaine(Affichage.output_nom_client_facturer, Affichage.input_nom_client_facturer);
            Note note_client = clients.verification_client_existant(nom_client, true);
            if(note_client != null) {
                produits.afficherListe();
                String nom_aliment = Affichage.choix_chaine(Affichage.output_nom_aliment_facturer, Affichage.input_nom_aliment_facturer);
                Aliment aliment_demande = Produits.verification_aliment_existant(nom_aliment, true, produits.getProductList());
                if(aliment_demande != null) {
                    int quantite = clients.selection_quantite(aliment_demande, produits);
                    if(quantite != -1){
                        clients.getNoteList().get(clients.getIndexNote(note_client.getNom())).ajouter_aliment(aliment_demande, quantite); } } } }
    }
  

    //Lorsqu'un client s'en va
    public void cloturer(Clients clients){
        clients.afficherListe(true);
        if(clients.getNoteList().size()!=0){
            String nom_client = Affichage.choix_chaine(Affichage.output_nom_client_cloturer, Affichage.input_nom_client_cloturer);
            Note note_client = clients.verification_client_existant(nom_client, true);
            if(note_client!=null) {
                int index_note = clients.getIndexNote(nom_client);
                boolean remise = false;
                if(clients.getNoteList().get(index_note).getProductList().size()!=0){ remise = Note.demander_remise(); }
                clients.getNoteList().get(index_note).afficher_facture(remise);
                clients.getNoteList().remove(clients.getNoteList().get(index_note)); } }
    }


    //Affichage des comptes (fin de journée)
    public void donnees_comptable(){
        logger.info("OUTPUT", String.format("\nTotal des rentrées d'argent: %s €\n", df.format(total_rentrees_argent)));
        logger.info("OUTPUT", String.format("Total de la TVA facturée: %s €\n", df.format(total_TVA)));
        logger.info("OUTPUT", String.format("Total des bénéfices: %s €\n", df.format(total_benefices)));
    }


    //Mettre à jour les comptes après cloture d'une note d'un client
    static void mise_a_jour_donnees_comptable(boolean remise, double prixHT, double TVA){
        if(!remise){//sans remise
            total_benefices = total_benefices + prixHT;
            total_TVA = total_TVA + TVA;
        }else{
            total_benefices = total_benefices + (prixHT - prixHT*0.1);
            total_TVA = total_TVA + (TVA - TVA*0.1);}
        total_rentrees_argent = total_benefices + total_TVA;
    }

}