/**
 * Ceci est une interface qui permet aux classes d'implementer le score d'un tour et de calculer le vainqueur du jeu
 *
 * @author Richard Layhout Lao
 * @author Huy-Thai-Tom Duong
 * @version 1.0
 */

package Framework;

public interface IStrategie {

    /**
     * Cette méthode permet de calculer le Vainqueur
     * @param jeu Le jeu associé
     */
     void calculerLeVainqueur(Jeu jeu);


    /**
     * Cette méthode permet de calculer le score d'un tour
     * @param jeu Le jeu associé
     */

     void calculerScoreTour(Jeu jeu);
}
