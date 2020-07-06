package framework;

import java.util.List;

public interface Strategie {
    public List<Joueur> calculerLeVainqueur(Jeu jeu);

    public void calculerScoreTour(Jeu jeu, int tourCourant);
}
