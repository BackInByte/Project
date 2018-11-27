package test;

import logger.Logger;
import logger.LoggerFactory;
import restaurant.Produits;


public class RunTest {

    private static Test_TVA test_tva = new Test_TVA();
    private static Test_Produit test_produit = new Test_Produit();
    private static Logger logger = LoggerFactory.getLogger("RunTest");


    public static void main(String[] args) {
        logger.info("PROGRAM","TESTS\n\n");

        logger.info("PROGRAM", "Tests TVA\n");
        test_tva.Test_get_TVA_entier();
        test_tva.Test_get_TVA_decimal();
        test_tva.Test_get_TVA_nulle();

        logger.info("PROGRAM", "\n\nTests Produits\n");
        Produits produits = new Produits();
        test_produit.remplir_liste(produits);
        test_produit.test_getIndexAliment(produits);
        test_produit.test_verif_aliment_existant(produits);
        test_produit.test_verif_aliment_inexistant(produits);



    }

}
