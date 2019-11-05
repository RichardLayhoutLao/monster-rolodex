/**
 * Ceci est une classe qui représente une collection qui contient des dés.
 *
 * @author Richard Layhout Lao
 * @author Huy-Thai-Tom Duong
 * @version 1.0
 */
package Framework;

import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class CollectionDes<E> implements Collection {

    //Variables privées
    private int nbDes;
    private De [] deTableau;
    private int nbEspaceDe;

    //Constructeur
    public CollectionDes(int nbEspaceDe) {
        this.deTableau = new De[nbEspaceDe];
        this.nbEspaceDe = nbEspaceDe;
    }

    @Override
    public boolean add(Object de) {
        this.nbDes++;                                //incremente


//        System.out.println("nbJoueur: " + nbJoueur);
        De[] temp = new De[nbEspaceDe];
        De[] nouveauList = new De[nbEspaceDe];    //Nouveau tableau


        //stackoverflow                                 //Copie vers le tab temp
        for (int i = 0; i < nbEspaceDe; i++) {
            temp[i] = deTableau[i];
//            System.out.println("temp index i: " + i + " " + temp[i]);
        }

        nouveauList[nbDes - 1] = (De) de;    //Ajout joueur a la derniere case
        deTableau = nouveauList;

        for (int i = 0; i < nbDes-1; i++) {
            deTableau[i] = temp[i];
        }

//        for (int i = 0; i < nbEspaceJoueur; i++) {
//            System.out.println("joueurList index i: " + i + " " + joueurList[i]);
//        }
        return true;
    }


    /**
     * La méthode iterator() permet de retourner un itérateur pour la collection CollectionDés
     *
     * @return new DeIterator(deTableau)  Un itérateur pour la collection CollectionDés
     */
    @Override
    public Iterator iterator() {
        return new DeIterator(deTableau);
    }

    /**
     * La méthode size() permet de retourner le nombre de dé qu'il y a dans la collection CollectionDés
     *
     * @return this.deTableau.length   Le nombre de dé dans la collection.
     */
    @Override
    public int size() {
        return this.deTableau.length;
    }

    /**
     * La méthode getDice() permet de retourner le dé de la collection CollectionDé à partir d'un index.
     *
     * @param index L'index de la collectionDés
     * @return deTableau[index]   Le dé qu'on cherche dans la collection.
     */
    public De getDice(int index) {
        return deTableau[index];
    }

    @Override
    public boolean removeIf(Predicate filter) {
        return false;
    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    @Override
    public Stream stream() {
        return null;
    }

    @Override
    public Stream parallelStream() {
        return null;
    }


    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
