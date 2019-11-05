/**
 * Ceci est une classe qui permet de tester toutes les méthodes reliés à la classe JoueurIterator.
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

import java.util.Iterator;

import static org.junit.Assert.assertTrue;

public class JoueurIteratorTest {

    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueur3;
    private CollectionJoueurs<Joueur> collectionJoueurs;

    /**
     * La méthode faireAvant() permet de faire toutes les instanciations des dés, des joueurs et du jeu.
     * Les joueurs et les dés seront ajouté dans une liste. Puis, le système de pointage sera associé au jeu Bunco+
     */
    @Before
    public void faireAvant() {
        joueur1 = new Joueur("Tom");
        joueur2 = new Joueur("Richard");
        joueur3 = new Joueur("Bob");
        collectionJoueurs = new CollectionJoueurs<>(3);
        collectionJoueurs.add(joueur1);
        collectionJoueurs.add(joueur2);
        collectionJoueurs.add(joueur3);
    }

    /**
     * La méthode hasNextAndNextTest() permet de vérifier si la méthode hasNext() et next()
     * fonctionne.
     */
    @Test
    public void hasNextAndNextTest() {
        boolean cycleComplete = false;
//        System.out.println(collectionJoueurs.size());
        Iterator iterator = collectionJoueurs.iterator();

        while (iterator.hasNext()) {
            Joueur joueur = (Joueur) iterator.next();
//            System.out.println("Joueur: " + joueur.getNom());
//            System.out.println("Pointage: " + joueur.getPointage());
//            System.out.println("TourTermine: " + joueur.isTourTermine());
            if (iterator.hasNext() == false) {
                cycleComplete = true;
            }
        }
        assertTrue(cycleComplete == true);
    }
}
