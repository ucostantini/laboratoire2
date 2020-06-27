package buncoPlus;

import framework.CollectionDes;
import framework.CollectionJoueurs;
import framework.Fabrique;
import framework.Jeu;

import java.util.Scanner;

public class JeuBuncoPlus extends Jeu {
    private Fabrique fabrique;

    public JeuBuncoPlus(int nbTours)
    {
        super(nbTours, new StrategieBuncoPlus());
        this.fabrique = new FabriqueBuncoPlus();
    }

    public void initialiserJoueurs()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Salut ! Quel est le nombre de joueurs pour cette partie ?");
        int nbJoueurs = sc.nextInt();

        CollectionJoueurs collectionJoueurs = new CollectionJoueurs(nbJoueurs);

        for (int i = 1; i <= nbJoueurs; i++)
        {
            System.out.println("Quel est le nom du joueur " + i + " ?");
            collectionJoueurs.ajouterJoueur(this.fabrique.getJoueur(sc.next()));
        }

        super.setIterateurJoueurs(collectionJoueurs.creerIterateur());
    }

    public void initialiserDes()
    {
        CollectionDes collectionDes = new CollectionDes(3);

        for (int i = 0; i < 3; i++)
            collectionDes.ajouterDe(this.fabrique.getDe(6));

        super.setIterateurDes(collectionDes.creerIterateur());
    }
}
