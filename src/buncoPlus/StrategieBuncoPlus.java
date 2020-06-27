package buncoPlus;

import framework.*;

import java.util.ArrayList;
import java.util.List;

public class StrategieBuncoPlus implements Strategie {
    @Override
    public void calculerLeVainqueur(Jeu jeu)
    {
        IterateurJoueurs it = jeu.getIterateurJoueurs();
        Joueur vainqueur = it.next();

        List<Joueur> vainqueurs = new ArrayList<>();

        while (it.hasNext())
        {
            Joueur joueurCourant = it.next();

            if (vainqueur.compareTo(joueurCourant) > 0)
                vainqueur = joueurCourant;
            else if (vainqueur.compareTo(joueurCourant) == 0)
                vainqueurs.add(joueurCourant);
        }

        if (vainqueurs.size() == 1)
            System.out.println("le joueur " + vainqueur.getNom() + " a gagne !");
        else
            System.out.println("C est un match nul");
    }

    @Override
    public void calculerScoreTour(Jeu jeu, int tourCourant)
    {
        IterateurJoueurs iterateurJoueurs = jeu.getIterateurJoueurs();
        System.out.println("***********************");
        System.out.println("Tour " + tourCourant + ":");
        System.out.println();

        while (iterateurJoueurs.hasNext())
        {
            Joueur joueur = iterateurJoueurs.next();

            System.out.println(joueur.getNom() + " joue !");
            System.out.println();
            System.out.println();

            int resultat;
            boolean estBunco = true;
            boolean differents = false;

            do
            {
                IterateurDes iterateurDes = jeu.getIterateurDes();
                De actuel = null;
                iterateurDes.reset();
                resultat = 0;


                while (iterateurDes.hasNext())
                {

                    int deResultat;
                    if (actuel != null)
                    {
                        De suivant = iterateurDes.next();
                        deResultat = actuel.lancer();

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
                        resultat++;
                    else
                        estBunco = false;

                }


                System.out.println();
                System.out.println("resultat : " + resultat);


            } while (resultat != 0 || !estBunco);


            if (estBunco)
            {
                resultat += 21;
                System.out.println("C est un Bunco !");

            } else if (!estBunco && !differents)
            {
                resultat += 5;
                System.out.println("Les trois des sont identiques !");
            } else
                joueur.ajouterPoints(resultat);

            System.out.println("Le score de " + joueur.getNom() + " est maintenant de : " + joueur.getScore());
        }
    }

}
