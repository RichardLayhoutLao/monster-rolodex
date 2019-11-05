/**
 * Ceci est une classe qui permet de tester toutes les méthodes reliés à la classe StrategieBunco.
 *
 * @author Richard Layhout Lao
 * @author Huy-Thai-Tom Duong
 * @version 1.0
 */

package Test;

import Bunco.Bunco;
import Bunco.StrategieBunco;
import Framework.CollectionDes;
import Framework.CollectionJoueurs;
import Framework.De;
import Framework.Joueur;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class StrategieBuncoTest {

    private CollectionJoueurs collectionJoueurs;
    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueur3;

    private CollectionDes collectionDes;
    private De de1;
    private De de2;
    private De de3;

    private StrategieBunco regleBunco;
    private Bunco bunco;

    /**
     * La méthode faireAvant() permet de faire toutes les instanciations des dés, des joueurs et du jeu.
     * Les joueurs et les dés seront ajouté dans une liste. Puis, le système de pointage sera associé au jeu Bunco+
     */
    @Before
    public void faireAvant() {
        collectionJoueurs = new CollectionJoueurs(3);
        joueur1 = new Joueur("Danny");
        joueur2 = new Joueur("Tom");
        joueur3 = new Joueur("Richard");

        collectionJoueurs.add(joueur1);
        collectionJoueurs.add(joueur2);
        collectionJoueurs.add(joueur3);

        collectionDes = new CollectionDes(3);

        de1 = new De();
        de2 = new De();
        de3 = new De();

        collectionDes.add(de1);
        collectionDes.add(de2);
        collectionDes.add(de3);

        regleBunco = new StrategieBunco();

        bunco = new Bunco(collectionJoueurs, collectionDes, regleBunco);
    }


    /**
     * La méthode calculScoreTest() permet de vérifier si la méthode calculerScoreTour()
     * cumule le score du joueur actuel après une lancée de dés (selon les règles du jeu)
     * et décide s'il faut passer la main au prochain joueur ou non.
     */
    @Test
    public void calculScoreTest() {
//        for (int i = 0; i< collectionJoueurs.size(); i++){
//            System.out.println("Nom : " + collectionJoueurs.getJoueur(i).getNom());        //Test
//
//            collectionDes.getDice(i);
//        }
//
//        System.out.println("-----------");
        bunco.setTourActuel(1);
//        System.out.println("nbtour = " +bunco.getTourActuel());

        de1.setFaceObtenue(1);
        de2.setFaceObtenue(1);
        de3.setFaceObtenue(6);

//        System.out.println(de1.getFaceObtenue());
//        System.out.println(de2.getFaceObtenue());
//        System.out.println(de3.getFaceObtenue());

//        System.out.println("de 1 : " + collectionDes.getDice(0).getFaceObtenue());     //de1
//        System.out.println("de 2 : " + collectionDes.getDice(1).getFaceObtenue());     //de2
//        System.out.println("de 3 : " + collectionDes.getDice(2).getFaceObtenue());     //de3


        bunco.setJoueurActuel(joueur1);
//        Joueur joueurActuel = bunco.getJoueurActuel();
//        System.out.println("Joueurs Actuel : " + joueurActuel.getNom());
//
//        System.out.println("Joueur Avant: " + joueurActuel.getNom());
//        System.out.println("Pointage Avant: " + joueurActuel.getPointage());
//        System.out.println("Tour Actif Avant: " + joueurActuel.isTourActif());
//        System.out.println("---------------");

        bunco.calculerScoreTour();

//        System.out.println("---------------");
//        System.out.println("Joueur Apres: " + joueurActuel.getNom());
//        System.out.println("Pointage Apres: " + joueurActuel.getPointage());
//        System.out.println("Tour Actif Apres: " + joueurActuel.isTourActif());

        bunco.setTourActuel(2);

        de1.setFaceObtenue(2);
        de2.setFaceObtenue(1);
        de3.setFaceObtenue(1);

        bunco.setJoueurActuel(joueur1);
        bunco.calculerScoreTour();

        assertEquals(3, bunco.getJoueurActuel().getPointage());
    }


    /**
     * La méthode verifierVainqueurTest() permet de vérifier la méthode calculerLeVainqueur
     * afin de trier les joueurs selon un ordre décroissant de scores.
     */

    @Test
    public void verifierVainqueurTest() {
        int[] listeJoueurPointage;

        joueur1.setPointage(10);
        joueur2.setPointage(0);
        joueur3.setPointage(20);


//        for (int i = 0; i < collectionJoueurs.toPointageArray().length; i++){
//            System.out.println(collectionJoueurs.getJoueur(i).getNom());
//            System.out.println("Point : " + collectionJoueurs.toPointageArray()[i]);
//            System.out.println("------");
//        }
        bunco.calculerLeVainqueur();

        listeJoueurPointage = collectionJoueurs.getPointageTableauTrier();

//        for (int i = 0; i < temp.length; i++){
//            System.out.println(collectionJoueurs.getJoueurTableauTrier()[i].getNom());
//            System.out.println("Point : " + temp[i]);
//            System.out.println("------");
//        }

        assertTrue((listeJoueurPointage[0] > listeJoueurPointage[1])
                && (listeJoueurPointage[0] > listeJoueurPointage[2])
                && (listeJoueurPointage[1] > listeJoueurPointage[2]));

    }

    /**
     * La méthode aucunPointTest() permet de vérifier si le joueur n'obtient aucun point et si
     * le tour du joueur est terminer() (tourActif false).
     */
    @Test
    public void aucunPointTest() {
        bunco.setTourActuel(6);

        bunco.setJoueurActuel(joueur1);

        de1.setFaceObtenue(1);
        de2.setFaceObtenue(2);
        de3.setFaceObtenue(3);

        bunco.calculerScoreTour();


        assertTrue((bunco.getJoueurActuel().getPointage() == 0) && (bunco.getJoueurActuel().isTourActif() == false));
    }


    /**
     * La méthode unPointTest() permet de vérifier si le joueur obtient uniquement un point.
     */
    @Test
    public void unPointTest() {
        bunco.setTourActuel(6);

        bunco.setJoueurActuel(joueur1);

        de1.setFaceObtenue(6);
        de2.setFaceObtenue(1);
        de3.setFaceObtenue(1);

        bunco.calculerScoreTour();

        assertTrue(bunco.getJoueurActuel().getPointage() == 1);
    }

    /**
     * La méthode deuxPointsTest() permet de vérifier si le joueur obtient 2 points.
     */

    @Test
    public void deuxPointsTest() {
        bunco.setTourActuel(6);

        bunco.setJoueurActuel(joueur1);

        de1.setFaceObtenue(6);
        de2.setFaceObtenue(6);
        de3.setFaceObtenue(1);

        bunco.calculerScoreTour();

        assertTrue(bunco.getJoueurActuel().getPointage() == 2);

    }


    /**
     * La méthode cinqPointsTest() permet de vérifier si le joueur obtient 5 points.
     */

    @Test
    public void cinqPointsTest() {
        bunco.setTourActuel(6);

        bunco.setJoueurActuel(joueur1);

        de1.setFaceObtenue(1);
        de2.setFaceObtenue(1);
        de3.setFaceObtenue(1);

        bunco.calculerScoreTour();

        assertTrue(bunco.getJoueurActuel().getPointage() == 5);

    }

    /**
     * La méthode buncoPointsTest() permer vérifier si le joueur obtient un Bunco, c'est-à-dire 21 points.
     */

    @Test
    public void buncoPointsTest() {
        bunco.setTourActuel(6);

        bunco.setJoueurActuel(joueur1);

        de1.setFaceObtenue(6);
        de2.setFaceObtenue(6);
        de3.setFaceObtenue(6);

        bunco.calculerScoreTour();

        assertTrue(bunco.getJoueurActuel().getPointage() == 21);
    }

}
