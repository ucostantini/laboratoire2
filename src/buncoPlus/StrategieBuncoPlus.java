package buncoPlus;

import framework.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe concrete de la strategie d un jeu, pour le jeu Bunco Plus
 */
public class StrategieBuncoPlus implements Strategie {
    @Override
    public List<Joueur> calculerLeVainqueur(Jeu jeu)
    {
        IterateurJoueurs it = jeu.getIterateurJoueurs();
        it.reset();
        Joueur vainqueurCourant = it.next();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("********************************** SCORE FINAL ********************************************");
        System.out.println("Score de " + vainqueurCourant.getNom() + " : " + vainqueurCourant.getScore());

        //Liste qui contient tous les vainqueurs qui ont le meme score
        //Cette liste est reinitialisee de qu un joueur ayant un score plus eleve est trouve
        List<Joueur> vainqueurs = new ArrayList<>();

        while (it.hasNext())
        {
            Joueur joueurSuivant = it.next();
            System.out.println("Score de " + joueurSuivant.getNom() + " : " + joueurSuivant.getScore());

            /*
            Si le joueur a un score plus eleve,
              on remplace le vainqueur et on efface la liste des vainqueurs (qui ont le meme score)
            Sinon si les 2 joueurs ont le meme score, on ajoute le joueur a la liste des vainqueurs
            */
            if (vainqueurCourant.compareTo(joueurSuivant) < 0)
            {
                vainqueurCourant = joueurSuivant;
                vainqueurs.clear();
            } else if (vainqueurCourant.compareTo(joueurSuivant) == 0)
                vainqueurs.add(joueurSuivant);

        }
        vainqueurs.add(vainqueurCourant);

        System.out.println();

        if (vainqueurs.size() == 1)
            System.out.println(vainqueurCourant.getNom() + " a gagne !");
        else
        {
            for (Joueur joueur : vainqueurs)
                System.out.println(joueur.getNom() + " a gagne !");

        }
        return vainqueurs;
    }

    @Override
    public void calculerScoreTour(Jeu jeu, int tourCourant)
    {
        IterateurJoueurs iterateurJoueurs = jeu.getIterateurJoueurs();
        iterateurJoueurs.reset();
        System.out.println();
        System.out.println("******************************* TOUR " + tourCourant + " ***************************************");

        //On parcourt les joueurs
        while (iterateurJoueurs.hasNext())
        {
            Joueur joueur = iterateurJoueurs.next();

            System.out.println("-----------");
            System.out.println(joueur.getNom().toUpperCase() + " joue !");
            System.out.println("-----------");
            System.out.println();

            //Le score d une manche (un tour)
            int scoreManche = 0;
            boolean estBunco = true;

            //Si tous les des ont un resultat different
            boolean differents;

            //Score du de lance
            int scoreLancer;

            //Tant que le score obtenu avec le lancer des 3 des n est pas zero
            //Ou qu on obtient pas de bunco, on boucle et on lance les des a repetition
            do
            {
                IterateurDes iterateurDes = jeu.getIterateurDes();
                De actuel = null;
                iterateurDes.reset();
                differents = false;
                scoreLancer = 0;

                //On lance les 3 des
                while (iterateurDes.hasNext())
                {

                    int deResultat;
                    //Ce bloc sert a determiner si tous les des obtenus sont differents, tout en gerant l iterateur
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

                    System.out.println("Face obtenue : " + deResultat);

                    if (deResultat == tourCourant)
                    {
                        scoreLancer++;
                        scoreManche++;
                    } else
                        estBunco = false;

                }

                System.out.println("score du lancer : " + scoreLancer);
                System.out.println();


            } while (scoreLancer != 0 && !estBunco);


            if (estBunco)
            {
                scoreManche += 18;
                System.out.println("C est un Bunco !");

            } else if (!differents)
            {
                scoreManche += 5;
                System.out.println("Les trois des sont identiques !");
            }

            joueur.ajouterPoints(scoreManche);

            System.out.println("Le score du tour " + tourCourant + " de " + joueur.getNom() + " est : " + scoreManche);
            System.out.println();
        }
    }

}
