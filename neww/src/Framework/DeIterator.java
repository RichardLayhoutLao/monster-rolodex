/**
 * Ceci est une classe qui sert à parcourir une collection de Dés dans un jeu.
 *
 * @author Richard Layhout Lao
 * @author Huy-Thai-Tom Duong
 * @version 1.0
 */

package Framework;

import java.util.Iterator;
import java.util.function.Consumer;

public class DeIterator implements Iterator {
    //Variables privées
    private De[] deTableau;
    private int positionDe = 0;

    //Constructeur
    public DeIterator(De[] deList) {
        this.deTableau = deList;
    }

    /**
     * Cette méthode retourne le prochain objet(De) de l'index suivant du tableau de dés.
     *
     * @return de le prochain objet(De) de l'index suivant du tableau de dés.
     */
    @Override
    public Object next() {

        De de = deTableau[positionDe];
        positionDe = positionDe + 1;
        return de;
    }

    /**
     * Cette méthode détermine s'il y a un objet (De) au prochain index de la collection
     *
     * @return True s'il y un objet au prochain index ou un false s'il n'y d'objet au prochain index
     * ou si c'est la limite du tableau
     */
    @Override
    public boolean hasNext() {
        if ( positionDe >= deTableau.length || deTableau[positionDe]== null){
            return false;
        }else {
            return true;
        }
    }

    /**
     * -------------------------------------------------------------------------
     * Les méthodes suivantes doivent être implémenter de la classe Iterator.
     * Cependant, nous n'allons pas les utiliser.
     * -------------------------------------------------------------------------
     */

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer action) {

    }
}
