/**
 * Ceci est une classe qui sert à parcourir une collection de joueurs dans un jeu.
 *
 * @author Richard Layhout Lao
 * @author Huy-Thai-Tom Duong
 * @version 1.0
 */
package Framework;

import java.util.Iterator;
import java.util.function.Consumer;

public class JoueurIterator implements Iterator {
    //Variables privées
    private Joueur[] joueurlist;
    private int positionJoueur = 0;

    //Constructeur
    public JoueurIterator(Joueur[] joueurList) {
        this.joueurlist = joueurList;
    }

    /**
     * Cette méthode retourne le prochain objet(Joueur) de l'index suivant du tableau de joueurs.
     *
     * @return joueur le prochain objet(Joueur) de l'index suivant du tableau de joueurs.
     */
    @Override
    public Object next() {

        Joueur joueur = joueurlist[positionJoueur];
        positionJoueur = positionJoueur + 1;
        return joueur;
    }

    /**
     * Cette méthode détermine s'il y a un objet (Joueur) au prochain index de la collection
     *
     * @return True s'il y un objet au prochain index ou un false s'il n'y d'objet au prochain index
     * ou si c'est la limite du tableau
     */
    @Override
    public boolean hasNext() {
        if (positionJoueur >= joueurlist.length || joueurlist[positionJoueur] == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * -------------------------------------------------------------------------
     * Les méthodes suivantes doivent être implémenter de la classe Iterator.
     * Cependant, nous n'allons pas les utiliser.
     * ---------------------------------------------------------------------------
     */

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer action) {

    }

}
