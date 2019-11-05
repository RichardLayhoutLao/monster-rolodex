/**
 * Ceci est une classe qui permet de tester toutes les méthodes reliés à la classe Joueur.
 *
 * @author Richard Layhout Lao
 * @author Huy-Thai-Tom Duong
 * @version 1.0
 */
package Test;
import org.junit.*;
import Framework.Joueur;




import static org.junit.Assert.*;

public class JoueurTest {

    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueur3;

    /**
     * La méthode faireAvant() permet de faire toutes les instanciations des joueurs.
     */
    @Before
    public void faireAvant() {
        joueur1 = new Joueur("Naruto");
        joueur2 = new Joueur("Tangiro");
        joueur3 = new Joueur("Gon");
    }

    /**
     * La méthode getNomTest() permet de vérifier si le nom du joueur est exact.
     */
    @Test
    public void getNomTest() {
        String nom = joueur1.getNom();
        assertSame("Naruto", nom);
    }


    /**
     * La méthode tourActifTest() permet de vérifier si le tour du joueur est actif.
     */
    @Test
    public void tourActifTest() {
        joueur1.setTourActif(true);
        assertTrue(joueur1.isTourActif() == true);
    }


    /**
     * La méthode pointInferieurTest() permet de vérifier si le pointage d'un joueur est
     * inférieur à un autre joueur.
     */
    @Test
    public void pointInferieurTest() {
        joueur1.setPointage(5);
        joueur2.setPointage(15);
        int resultat = joueur1.compareTo(joueur2);
        assertTrue(resultat == -10);
    }



    /**
     * La méthode pointSuperieurTest() permet de vérifier si le pointage d'un joueur est
     * égal à un autre joueur.
     */
    @Test
    public void pointEgalTest() {
        joueur2.setPointage(30);
        joueur3.setPointage(30);
        int resultat = joueur2.compareTo(joueur3);
        assertTrue(resultat == 0);
    }



    /**
     * La méthode pointSuperieurTest() permet de vérifier si le pointage d'un joueur est
     * supérieur à un autre joueur.
     */
    @Test
    public void pointSuperieurTest() {
        joueur1.setPointage(19);
        joueur2.setPointage(29);
        int resultat = joueur2.compareTo(joueur1);
        assertTrue(resultat == 10);
    }

    /**
     * La méthode joueurNullTest() permet de vérifier si la méthode compareTo() de Joueur
     * peut déclancher une exception (NullPointerException) qui prend en paramètre un "null".
     */
    @Test(expected = NullPointerException.class)
    public void joueurNullTest() {
        int resultat = joueur1.compareTo(null);
    }

}
