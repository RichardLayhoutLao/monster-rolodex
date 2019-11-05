package Bunco;


import Framework.*;

public class FabriqueBunco extends Fabrique {
    private final int NB_DE = 3;
    private int nombreJoueurs;
    @Override
    public void creerDes() {
        CollectionDes<De> deBunco = new CollectionDes<>(NB_DE);

    }

    @Override
    public void creerJeu() {
        //c'est temporaire
        Jeu Bunco = new Bunco(new CollectionJoueurs<>(nombreJoueurs), new CollectionDes<>(NB_DE), new StrategieBunco());
    }

    @Override
    public void creerJoueur(int nbJoueurs) {
        CollectionJoueurs<Joueur> joueurBunco = new CollectionJoueurs<>(nbJoueurs);
    }
}
