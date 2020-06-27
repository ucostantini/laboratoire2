package buncoPlus;

import framework.*;

import java.util.ArrayList;
import java.util.List;

public class StrategieBuncoPlus implements Strategie {
    @Override
    public void calculerLeVainqueur(Jeu jeu)
    {
        IterateurJoueurs it = jeu.getIterateurJoueurs();
        it.reset();
        Joueur vainqueurCourant = it.next();
        System.out.println();
        System.out.println();
        System.out.println("***************************");
        System.out.println("score " + vainqueurCourant.getNom() + " : " + vainqueurCourant.getScore());

        List<Joueur> vainqueurs = new ArrayList<>();

        while (it.hasNext())
        {
            Joueur joueurSuivant = it.next();
            System.out.println("score " + joueurSuivant.getNom() + " : " + joueurSuivant.getScore());

            if (vainqueurCourant.compareTo(joueurSuivant) < 0)
            {
                vainqueurCourant = joueurSuivant;
                vainqueurs.clear();
            } else if (vainqueurCourant.compareTo(joueurSuivant) == 0)
                vainqueurs.add(joueurSuivant);

        }
        vainqueurs.add(vainqueurCourant);

        if (vainqueurs.size() == 1)
            System.out.println("le joueur " + vainqueurCourant.getNom() + " a gagne !");
        else
        {
            for (Joueur joueur : vainqueurs)
                System.out.println("le joueur " + joueur.getNom() + " a gagne !");

        }

    }

    @Override
    public void calculerScoreTour(Jeu jeu, int tourCourant)
    {
        IterateurJoueurs iterateurJoueurs = jeu.getIterateurJoueurs();
        iterateurJoueurs.reset();
        System.out.println("***********************");
        System.out.println("Tour " + tourCourant + ":");
        System.out.println();

        while (iterateurJoueurs.hasNext())
        {
            Joueur joueur = iterateurJoueurs.next();

            System.out.println(joueur.getNom() + " joue !");
            System.out.println();
            System.out.println();

            int scoreTotal = 0;
            boolean estBunco = true;
            boolean differents;
            int scoreManche;

            do
            {
                IterateurDes iterateurDes = jeu.getIterateurDes();
                De actuel = null;
                iterateurDes.reset();
                differents = false;

                scoreManche = 0;


                while (iterateurDes.hasNext())
                {

                    int deResultat;
                    if (actuel != null)
                    {
                        De suivant = iterateurDes.next();
                        deResultat = suivant.lancer();

                        if (actuel.compareTo(suivant) != 0)
                            differents = true;

                        actuel = suivant;
                    } else
                    {

                        actuel = iterateurDes.next();
                        deResultat = actuel.lancer();
                    }

                    System.out.println("Le lancer est : " + deResultat);

                    if (deResultat == tourCourant)
                    {
                        scoreManche++;
                        scoreTotal++;
                    } else
                        estBunco = false;

                }

                System.out.println("scoreManche : " + scoreManche);
                System.out.println();


            } while (scoreManche != 0 && !estBunco);


            if (estBunco)
            {
                scoreTotal += 18;
                System.out.println("C est un Bunco !");

            } else if (!estBunco && !differents)
            {
                scoreTotal += 5;
                System.out.println("Les trois des sont identiques !");
            }

            joueur.ajouterPoints(scoreTotal);

            System.out.println("Le score de " + joueur.getNom() + " est maintenant de : " + joueur.getScore());
        }
    }

}
