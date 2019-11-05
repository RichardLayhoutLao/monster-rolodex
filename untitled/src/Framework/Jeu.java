package Framework;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Jeu {

    private int tourActuel;
    private CollectionJoueurs<Joueur> joueurs;
    private CollectionDes<De> des;
    private IStrategie regles;
    private final int min = 1;
    private final int max = 6;
    private int randomNumber;
    private Joueur joueurActuel;

    public Jeu(CollectionJoueurs<Joueur> joueurs, CollectionDes<De> des, IStrategie regles) {
        this.joueurs = joueurs;
        this.des = des;
        this.setRegles(regles);

    }

    public void calculerLeVainqueur() {
        regles.calculerLeVainqueur(this);
    }

    public void calculerScoreTour() {
        regles.calculerScoreTour(this);
    }

    public int getTourActuel() {
        return tourActuel;
    }

    public void setTourActuel(int tourActuel) {
        this.tourActuel = tourActuel;
    }

    public CollectionJoueurs<Joueur> getJoueurs() {
        return joueurs;
    }

    public CollectionDes<De> getDes() {
        return des;
    }

    public void setRegles(IStrategie regles) {
        this.regles = regles;
    }

    public IStrategie getRegles() {
        return regles;
    }

    public int getRandomNumber() {
        //CODE Emprunte
        return this.randomNumber = ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public Joueur getJoueurActuel() {
        return joueurActuel;
    }

    public void setJoueurActuel(Joueur joueurActuel) {
        this.joueurActuel = joueurActuel;
    }
}
