/**
 * Cette classe représente le jeu Bunco+ qui est un jeu qui se joue en 6 tours avec 3 dés.
 *
 * @author Richard Layhout Lao
 * @author Huy-Thai-Tom Duong
 * @version 1.0
 */
package Bunco;

import Framework.*;

public class Bunco extends Jeu {

    //Constante d'une variable privé
    private final int NB_TOUR = 6;

    //Constructeur
    public Bunco(CollectionJoueurs<Joueur> joueurs, CollectionDes<De> des, IStrategie regles) {
        super(joueurs, des, regles);
    }

    //TODO Methode qu'on peut enlever
    public void calculerLeVainqueur(){
        getRegles().calculerLeVainqueur(this);
    }

    //TODO Methode qu'on peut enlever
    public void calculerScoreTour(){
        getRegles().calculerScoreTour(this);
    }


    /**
     * La méthode setTourActuel permet mettre en paramètre le tour actuel entre 1 et 6.
     * @param tourActuel le tour actuel.
     */
    @Override
    public void setTourActuel(int tourActuel) {
        if ((tourActuel<= NB_TOUR) && (tourActuel >0)) {
            super.setTourActuel(tourActuel);
        }else {
            System.err.println("Il faut que le nombre de tour soit entre 1 et 6");
        }
    }

}
