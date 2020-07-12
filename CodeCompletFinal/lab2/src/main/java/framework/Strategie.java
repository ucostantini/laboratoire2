package framework;

import java.util.List;

public interface Strategie {
    /**
     * Signature de la methode qui calcul de vainqueur de la partie.
     * @param jeu Cette methode utilse un objet Jeu pour calculer le vainqueur de la partie.
     * @return Une liste du ou des vainqueurs de la partie.
     */
     List<Joueur> calculerLeVainqueur(Jeu jeu);

    /**
     * Signature de la methode qui calcul le score de tous les joueurs du tour courant.
     * @param jeu un objet Jeu est utilise pour calculer le vainqueur de la partie.
     * @param tourCourant le tour courant de la partie.
     * @return le nouveau score des joueurs.
     */
     int calculerScoreTour(Jeu jeu, int tourCourant);
}
