/**
 * Ceci est une classe qui permet de tester toutes les méthodes reliés à la classe CollectionJoueurs.
 *
 * @author Richard Layhout Lao
 * @author Huy-Thai-Tom Duong
 * @version 1.0
 */
package Test;

import Framework.CollectionJoueurs;
import Framework.Joueur;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

public class CollectionJoueursTest {

    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueur3;
    private CollectionJoueurs<Joueur> collectionJoueurs;



    /**
     * La méthode faireAvant() permet de faire toutes les instanciations des joueurs.
     */
    @Before
    public void faireAvant() {
        joueur1 = new Joueur("Naruto");
        joueur2 = new Joueur("Tangiro");
        joueur3 = new Joueur("Gon");
        collectionJoueurs = new CollectionJoueurs<>(3);
    }


    /**
     * La méthode sizeTest() permet de vérifier la méthode size() afin de savoir la grandeur du
     * tableau.
     */
    @Test
    public void sizeTest() {
        int nbJoueur = collectionJoueurs.size();
        assertTrue(nbJoueur == 3);
    }


    /**
     * La méthode addAndGetTest() permet de vérifier les méthode add() et getDice(). En effet, cette méthode
     * teste les ajout des joueurs et s'il recoit ces même joueurs.
     */
    @Test
    public void addAndGetTest() {
        collectionJoueurs.add(joueur1);
        collectionJoueurs.add(joueur2);
        collectionJoueurs.add(joueur3);

        assertSame(collectionJoueurs.getJoueur(0), joueur1);
        assertSame(collectionJoueurs.getJoueur("tangiro"), joueur2);
        assertSame(collectionJoueurs.getJoueur("GON"), joueur3);
    }

    /**
     * La méthode outOfBoundCollection() permet de vérifier s'il y aura une
     * exception(ArrayIndexOutOfBoundsException) lancé lorsqu'il y a un dépassement de capacité
     * du tableau.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void outOfBoundCollection() {
        collectionJoueurs.add(joueur1);
        collectionJoueurs.add(joueur2);
        collectionJoueurs.add(joueur3);
        collectionJoueurs.add(joueur3);
        Joueur player4 = collectionJoueurs.getJoueur("Danny");
    }


    /**
     * La méthode toPointageArrayTest() permet de vérifier si la collection de joueurs est
     * converti en tableau de pointage des joueurs.
     */
    @Test
    public void toPointageArrayTest() {
        collectionJoueurs.add(joueur1);
        collectionJoueurs.add(joueur2);
        collectionJoueurs.add(joueur3);

        joueur1.setPointage(10);
        joueur2.setPointage(20);
        joueur3.setPointage(30);


        int[] listPointageJoueur = collectionJoueurs.toPointageArray();

//        for (int i = 0; i < listPointageJoueur.length; i++)
//            System.out.println(listPointageJoueur[i]);

        assertTrue(listPointageJoueur[2] == 30);
    }
}



