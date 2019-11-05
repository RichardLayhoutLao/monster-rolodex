/**
 * Cette classe est une abstraction d'un concept d'un jeu de dé. Cette classe sert à créer
 * des instances d'un jeu, des dés et des joueurs.
 *
 * @author Richard Layhout Lao
 * @author Huy-Thai-Tom Duong
 * @version 1.0
 */
package Framework;

public abstract class Fabrique {

    /**
     * La méthode creerDes() permet de créer le nombre de dés.
     */
    public abstract void creerDes();


    /**
     * La méthode creerJeu() permet de créer un jeu de dé.
     */
    public abstract void creerJeu();


    /**
     * La méthode creerJeu() permet de créer le nombre de joueurs.
     */
    public abstract void creerJoueur(int nbJoueurs);

    /**
     * Cette méthode permet de créer les éléments d'un jeu de dé
     */
    public final void fabriquer(int nombreJoueur) {
        creerJeu();
        creerDes();
        creerJoueur(nombreJoueur);
    }

}
