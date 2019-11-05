/**
 * Ceci est une classe qui représente une collection qui contient des joueurs.
 *
 * @author Richard Layhout Lao
 * @author Huy-Thai-Tom Duong
 * @version 1.0
 */
package Framework;

import java.util.Collection;
import java.util.Iterator;

public class CollectionJoueurs<E> implements Collection {

    //Variables privées
    private int nbJoueur = 0;
    private int nbEspaceJoueur;
    private Joueur[] joueurTableau;
    private Joueur[] joueurTableauTrier;
    private int[] pointageTableau;
    private int[] pointageTableauTrier;

    //Constructeur
    public CollectionJoueurs(int nbEspaceJoueur) {
        this.joueurTableau = new Joueur[nbEspaceJoueur];
        this.nbEspaceJoueur = nbEspaceJoueur;
    }

    /**
     * La méthode add() permet d'ajouter un joueur dans la collection CollectionJoueur.
     *
     * @param joueur Le joueur qu'on veut ajouter dans la collection CollectionJoueur.
     * @return true   Selon la documentation de Java 8, il faut implémenter cette méthode en retournant un boolean.
     */
    @Override
    public boolean add(Object joueur) {                 //Ajout joueur
        this.nbJoueur++;                                //incremente


//        System.out.println("nbJoueur: " + nbJoueur);
        Joueur[] tableauTemp = new Joueur[nbEspaceJoueur];    //Tableau temporaire
        Joueur[] nouveauTableau = new Joueur[nbEspaceJoueur];    //Nouveau tableau


        /*
           CODE EMPRUNTÉ :
           Les lignes suivantes sont basées sur une classe provenant du site :
           https:www.geeksforgeeks.org/how-do-dynamic-arrays-work/

           Dans ce site, nous avons pris et modifier le code de la classe DynamicArray afin d'ajouter un élément
           dans le tableau.
        */

        //Copie vers un tableau temporaire
        for (int i = 0; i < nbEspaceJoueur; i++) {
            tableauTemp[i] = joueurTableau[i];
        }

        //Ajout du joueur a la dernière case
        nouveauTableau[nbJoueur - 1] = (Joueur) joueur;
        joueurTableau = nouveauTableau;

        //Remettre les joueurs du tableau temporaire dans un tableau de joueurs
        for (int i = 0; i < nbJoueur - 1; i++) {
            joueurTableau[i] = tableauTemp[i];
        }

        /*FIN DU CODE EMPRUNTÉ*/


//        for (int i = 0; i < nbEspaceJoueur; i++) {
//            System.out.println("joueurTableau index i: " + i + " " + joueurTableau[i]);
//        }
        return true;
    }

    /**
     * La méthode iterator() permet de retourner un itérateur pour la collection CollectionJoueurs
     *
     * @return new JoueurIterator(joueurTableau)  Un itérateur pour la collection CollectionJoueurs
     */
    @Override
    public Iterator iterator() {
        return new JoueurIterator(joueurTableau);
    }

    /**
     * La méthode size() permet de retourner le nombre de joueur qu'il y a dans la collection CollectionJoueurs
     *
     * @return this.joueurTableau.length   Le nombre de joueur dans la collection.
     */
    @Override
    public int size() {
        return this.joueurTableau.length;
    }

    /**
     * La méthode getJoueur() permet de retourner le joueur de la collection CollectionJoueurs à partir d'un index.
     *
     * @param index L'index de la collectionJoueur
     * @return joueurTableau[index]  Le joueur qu'on cherche dans la collection.
     */
    public Joueur getJoueur(int index) {
        return joueurTableau[index];
    }

    /**
     * La méthode getJoueur() permet de retourner le joueur de la collection CollectionJoueurs à partir du nom.
     *
     * @param name le nom du joueur qu'on cherche
     * @return joueur Le joueur qu'on cherche dans la collection.
     */
    public Joueur getJoueur(String name) {
        String lowerName = name.toLowerCase();

        for (Joueur joueur : this.joueurTableau) {
            String nomJoueur = joueur.getNom().toLowerCase();
            if (nomJoueur.equals(lowerName)) {
                return joueur;
            }
        }
        return null;
    }

    /**
     * La méthode toArray() permet de retourner un tableau des joueurs
     *
     * @return joueurTableau Un tableau des joueurs
     */
    @Override
    public Joueur[] toArray() {
        return joueurTableau;
    }

    /**
     * La méthode toPointageArray() permet de retourner un tableau des points des joueurs
     *
     * @return pointageTableau Un tableau des points des joueurs
     */

    public int[] toPointageArray() {                        // A mettre dans les test

        pointageTableau = new int[nbJoueur];

        for (int i = 0; i < nbEspaceJoueur; i++) {
            pointageTableau[i] = joueurTableau[i].getPointage();
        }

        return pointageTableau;
    }


    /**-------------------
     * Setters et getters
     ---------------------*/
    public int[] getPointageTableauTrier() {
        return pointageTableauTrier;
    }


    public void setPointageTableauTrier(int[] pointageTableauTrier) {
        this.pointageTableauTrier = pointageTableauTrier;
    }


    public Joueur[] getJoueurTableauTrier() {
        return joueurTableauTrier;
    }


    public void setJoueurTableauTrier(Joueur[] joueurTableauTrier) {
        this.joueurTableauTrier = joueurTableauTrier;
    }


    /**-------------------------------------------------------------------------
     * Les méthodes suivantes doivent être implémenter de la classe Collection.
     * Cependant, nous n'allons pas les utiliser.
     ---------------------------------------------------------------------------*/


    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] objects) {
        return new Object[0];
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        return false;
    }

    @Override
    public boolean addAll(Collection collection) {
        return false;
    }

    @Override
    public boolean removeAll(Collection collection) {
        return false;
    }

    @Override
    public boolean retainAll(Collection collection) {
        return false;
    }

    @Override
    public void clear() {

    }
}
