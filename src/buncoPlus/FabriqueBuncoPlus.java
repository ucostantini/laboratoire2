package buncoPlus;

import framework.De;
import framework.Fabrique;
import framework.Jeu;
import framework.Joueur;

public class FabriqueBuncoPlus implements Fabrique {
    @Override
    public De getDe(int nbFaces)
    {
        return new De(nbFaces);
    }

    @Override
    public Joueur getJoueur(String nom)
    {
        return new Joueur(nom);
    }

    @Override
    public Jeu getJeu(int nbToursRestant)
    {
        return new JeuBuncoPlus(nbToursRestant);
    }
}
