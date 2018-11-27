package test;

import logger.LoggerFactory;
import restaurant.Note;
import java.lang.*;
import java.text.DecimalFormat;


public class Test_TVA {

    private logger.Logger logger = LoggerFactory.getLogger("test_TVA");
    private Note note = new Note("note");

    private DecimalFormat df = new DecimalFormat("#.##");

    public void Test_get_TVA_entier(){
        String message ="\nPrix hors-taxe entré: 150 €\nTVA attendue: 15 €\n";
        double TVA = note.getTVA(150);
        String test_TVA = df.format(TVA);
        if (!df.format(15).equals(test_TVA)){
            throw new AssertionError(message+"La TVA de "+150+"€ devrait être "+15+"€, mais le résultat obtenu est "+test_TVA+"€");
        } else {
            logger.info("PROGRAM",message+"Le test de la fonction getTVA (avec un entier) a été réussi\n"); }
    }

    public void Test_get_TVA_decimal(){
        String message = "\nPrix hors-taxe entré: 150.48 €\nTVA attendue: 15.05 €\n";
        double TVA = note.getTVA(150.48);
        String test_TVA = df.format(TVA);
        if (!df.format(15.05).equals(test_TVA)){
            throw new AssertionError(message+"La TVA de "+150.48+"€ devrait être "+15.05+"€, mais le résultat obtenu est "+test_TVA+"€");
        } else {
            logger.info("PROGRAM",message+"Le test de la fonction getTVA (avec un nombre décimal) a été réussi\n"); }
    }

    public void Test_get_TVA_nulle(){
        String message = "\nPrix hors-taxe entré: 0 €\nTVA attendue: 0 €\n";
        double TVA = note.getTVA(0);
        String test_TVA = df.format(TVA);
        if (!df.format(0).equals(test_TVA)){
            throw new AssertionError(message+"La TVA de "+0+"€ devrait être "+0+"€, mais le résultat obtenu est "+test_TVA+"€");
        } else {
            logger.info("PROGRAM",message+"Le test de la fonction getTVA (avec un prix de 0 €) a été réussi\n"); }
    }

}