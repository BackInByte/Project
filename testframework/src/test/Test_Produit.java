package test;

import logger.Logger;
import logger.LoggerFactory;
import restaurant.Aliment;
import restaurant.Produits;

public class Test_Produit {

    private Logger logger = LoggerFactory.getLogger("Test_Index");
    private Aliment burger = new Aliment("burger", 10, 10);
    private Aliment bagel = new Aliment("bagel", 8, 20);
    private Aliment hot_dog = new Aliment("hot_dog", 15, 5);


    //Pour créer une liste de produit avec trois aliments
    public void remplir_liste(Produits produits){
        produits.getProductList().add(burger);
        produits.getProductList().add(bagel);
        produits.getProductList().add(hot_dog);
    }


    //Méthode qui teste la récupération de l'index d'un aliment
    public void test_getIndexAliment(Produits produits){
        long debut = System.currentTimeMillis();
        String message = "Nom de l'aliment dont on veut récupérer l'index: \"burger\"\nIndex attendu: 0\n";
        int index = Produits.getIndexAliment("burger", produits.getProductList());
        if (index != 0) {
            throw new AssertionError("\n"+message+ "L'index devrait être 0 mais c'est " + index);
        } else logger.info("PROGRAM","\n"+message+"Le test de la fonction \"getIndexAliment\" a réussi\n");
        long fin = +System.currentTimeMillis()-debut;
        logger.info("PROGRAM","Temps d'éxecution = "+fin+" millisecondes\n");
    }


    //Méthode qui teste la vérification de l'existence d'un aliment dans une liste
    public void test_verif_aliment_existant(Produits produits){
        long debut = System.currentTimeMillis();
        String message = "Nom de l'aliment dont on veut savoir s'il est présent dans la liste: \"burger\"\nRésultat attendu: l'aliment est présent dans la liste\n";
        Aliment aliment = Produits.verification_aliment_existant("burger", false, produits.getProductList());
        if(aliment==null){
            throw new AssertionError("\n"+message+"L'aliment \"burger\" est censé se trouver dans la liste de produits\n");
        }
        else logger.info("PROGRAM", "\n"+message+"L'aliment \"burger\" a bien été trouvé dans la liste de produits\n");
        long fin = +System.currentTimeMillis()-debut;
        logger.info("PROGRAM","Temps d'éxecution = "+fin+" millisecondes\n");
    }


    //Méthode qui teste la vérification de l'existence d'un aliment dans une liste
    public void test_verif_aliment_inexistant(Produits produits){
        long debut = System.currentTimeMillis();
        String message= "Nom de l'aliment dont on veut savoir s'il est présent dans la liste: \"coca\"\nRésultat attendu: l'aliment n'est pas présent dans la liste\n";
        Aliment aliment = Produits.verification_aliment_existant("coca", false, produits.getProductList());
        if(aliment!=null){
            throw new AssertionError("\n"+message+"L'aliment \"coca\" n'est pas censé se trouver dans la liste de produits\n");
        }
        else logger.info("PROGRAM", "\n"+message+"L'aliment \"coca\" n'a pas été trouvé dans la liste de produits\n");
        long fin = +System.currentTimeMillis()-debut;
        logger.info("PROGRAM","Temps d'éxecution = "+fin+" millisecondes\n");
    }

}