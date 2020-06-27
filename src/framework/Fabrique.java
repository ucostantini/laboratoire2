package framework;

public interface Fabrique {
    De getDe(int nbFaces);

    Joueur getJoueur(String nom);

    Jeu getJeu(int nbToursRestant);
}
