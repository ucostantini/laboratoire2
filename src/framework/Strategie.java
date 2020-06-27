package framework;

public interface Strategie {
    void calculerLeVainqueur(Jeu jeu);

    void calculerScoreTour(Jeu jeu, int tourCourant);
}
