package framework;

public interface Fabrique {
    public De getDe(int nbFaces);

    public Joueur getJoueur(String nom);

    public Jeu getJeu(int nbToursRestant);
}
