/**
 * Ceci est une classe qui implémente le système de pointage du jeu Bunco+. Il permet de
 * cumuler le score du joueur actuel après une lancée de dés et décide s'il doit passer son
 * tour pour le prochain joueur ou non. Puis, il permet de trier les joueurs selon un ordre
 * décroissant de score.
 *
 * @author Richard Layhout Lao
 * @author Huy-Thai-Tom Duong
 * @version 1.0
 */


package Bunco;

import Framework.*;

public class StrategieBunco implements IStrategie {

    private CollectionJoueurs collectionJoueurs;
    private CollectionDes collectionDes;
    private int tourActuel;
    private int valeurDe1;
    private int valeurDe2;
    private int valeurDe3;
    private Joueur joueurActuel;
    private int pointJoueurActuel;
    private final int BUNCO = 21;
    private final int CINQ_POINTS = 5;
    private final int DEUX_POINTS = 2;
    private final int UN_POINT = 1;
    private final int ZERO_POINT = 0;


    /**
     * La méthode calculerScoreTour() cumule le score du joueur actuel après une lancée de
     * dés (selon les règles du jeu) et décide s'il faut passer la main au prochain joueur
     * ou non.
     *
     * @param jeu Le Jeu qui utilise le système de pointage de Bunco+.
     */
    @Override
    public void calculerScoreTour(Jeu jeu) {
//        System.out.println("StrategieBunco - calculerScoreTour() executed");

        int pointsTotal;
        int point = ZERO_POINT;

        joueurActuel = jeu.getJoueurActuel();
        pointJoueurActuel = joueurActuel.getPointage();

        collectionJoueurs = jeu.getJoueurs();
        collectionDes = jeu.getDes();

        tourActuel = jeu.getTourActuel();

        valeurDe1 = jeu.getDes().getDice(0).getFaceObtenue();
        valeurDe2 = jeu.getDes().getDice(1).getFaceObtenue();
        valeurDe3 = jeu.getDes().getDice(2).getFaceObtenue();

//        System.out.println(collectionJoueurs.getJoueur(0).getNom());
//        System.out.println("valeur de 1 confirm: " + valeurDe1);
//        System.out.println("valeur de 2 confirm: " + valeurDe2);
//        System.out.println("valeur de 3 confirm: " + valeurDe3);


        //Permet de déterminer le score du joueur selon les valeurs des trois dées et du nombre de tour.

        if (valeurDe1 == tourActuel) {

            if (valeurDe2 == tourActuel) {

                if (valeurDe3 == tourActuel) {
                    //111
                    point = BUNCO;
                } else {
                    //110
                    point = DEUX_POINTS;
                }

            } else if (valeurDe3 == tourActuel) {
                //101
                point = DEUX_POINTS;
            } else {
                //100
                point = UN_POINT;
            }

        } else if (valeurDe2 == tourActuel) {

            if (valeurDe3 == tourActuel) {
                //011
                point = DEUX_POINTS;
            } else {
                //010
                point = UN_POINT;
            }

        } else if (valeurDe3 == tourActuel) {
            //001
            point = UN_POINT;
        } else if ((valeurDe1 == valeurDe2) && (valeurDe1 == valeurDe3) && (valeurDe2 == valeurDe3)) {
            //111 nb tour
            point = CINQ_POINTS;
        } else {
            //000
//            System.out.println("TOUR TERMINE");

            //Chacun des valeurs des dées ne sont pas égale au nombre de tour et il n'ont pas tous la même valeur
            joueurActuel.setTourActif(false);
        }

        //Calcul des points
        pointsTotal = point + pointJoueurActuel;

        joueurActuel.setPointage(pointsTotal);
//        System.out.println("Points : " + pointsTotal);


    }

    /**
     * La méthode calculerScoreTour() cumule le score du joueur actuel après une lancée de
     * dés (selon les règles du jeu) et décide s'il faut passer la main au prochain joueur
     * ou non.
     *
     * @param jeu Le Jeu qui utilise le système de pointage de Bunco+.
     */
    @Override
    public void calculerLeVainqueur(Jeu jeu) {
        collectionJoueurs = jeu.getJoueurs();

//        System.out.println("calculerLeVainqueur() executed");

        int[] pointageJoueurListe = collectionJoueurs.toPointageArray();
        Joueur[] joueurListe = collectionJoueurs.toArray();

        /*
        CODE EMPRUNTÉ :
        Les lignes suivantes sont basées sur une classe provenant du site :
        https://beginnersbook.com/2014/07/java-program-for-bubble-sort-in-ascending-descending-order/

        Nous avons pris un algorithme(Bubble sort) de la classe BubbleSortExample qui permet de classer les chiffres en ordre décroissant.
        */

        int compteur2;
        int compteur;
        int intTemp;        //chiffre temporaire
        Joueur joueurTemp;  //Joueur temporaire

        int longueurJoueurListe = pointageJoueurListe.length;

        for (compteur = 0; compteur < (longueurJoueurListe - 1); compteur++) {
            for (compteur2 = 0; compteur2 < longueurJoueurListe - compteur - 1; compteur2++) {
                if (pointageJoueurListe[compteur2] < pointageJoueurListe[compteur2 + 1]) {
                    intTemp = pointageJoueurListe[compteur2];
                    joueurTemp = joueurListe[compteur2];

                    pointageJoueurListe[compteur2] = pointageJoueurListe[compteur2 + 1];
                    joueurListe[compteur2] = joueurListe[compteur2 + 1];

                    pointageJoueurListe[compteur2 + 1] = intTemp;
                    joueurListe[compteur2 + 1] = joueurTemp;
                }
            }
        }

        /* FIN DU CODE EMPRUNTÉ */


//        System.out.println("TEST " + joueurListe[0].getNom());
//        System.out.println("TEST " + joueurListe[1].getNom());
//        System.out.println("TEST " + joueurListe[2].getNom());


        collectionJoueurs.setPointageTableauTrier(pointageJoueurListe);
        collectionJoueurs.setJoueurTableauTrier(joueurListe);
    }


}



