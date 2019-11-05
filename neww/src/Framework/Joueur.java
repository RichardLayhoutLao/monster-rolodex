/**
 * Ceci est une classe qui représente un joueur concret.
 *
 * @author Richard Layhout Lao
 * @author Huy-Thai-Tom Duong
 * @version 1.0
 */

package Framework;

public class Joueur implements Comparable<Joueur> {

    //Variables privés
    private String nom;
    private int pointage = 0;
    private boolean tourActif = true;

    //Constructeur
    public Joueur(String nom) {
        this.nom = nom;
    }

    /**-------------------
     * Setters et getters
     ---------------------*/
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPointage() {
        return pointage;
    }

    public void setPointage(int pointage) {
        this.pointage = pointage;
    }

    public boolean isTourActif() {
        return tourActif;
    }

    public void setTourActif(boolean tourActif) {
        this.tourActif = tourActif;
    }

    /**
     * Cette méthode permet de comparer les points de deux joueurs et qui permet de retourner le nombre
     * de points.
     *
     * @param autreJoueur le deuxième joueur à comparer.
     * @return this.getPointage()-comparePoint  La différence des points.
     */
    @Override
    public int compareTo(Joueur autreJoueur) {
        int comparePoint = autreJoueur.getPointage();
        return this.getPointage() - comparePoint;
    }
}
