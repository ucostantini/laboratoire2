package buncoPlus;

import framework.CollectionDes;
import framework.CollectionJoueurs;
import framework.Jeu;

import java.util.Scanner;

/**
 * Classe concrete du jeu pour initialiser un jeu BuncoPlus
 */
public class JeuBuncoPlus extends Jeu {

    private static final int NBDES = 3;
    private static final int NBFACES_DES = 6;

    /**
     * Constructeur d un jeu BuncoPlus, utilise une strategie BuncoPlus pour fonctionner
     *
     * @param nbTours
     */
    public JeuBuncoPlus(int nbTours)
    {
        super(nbTours, new StrategieBuncoPlus());
    }

    @Override
    public CollectionJoueurs initialiserJoueurs()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Salut ! Quel est le nombre de joueurs pour cette partie ?");
        int nbJoueurs = sc.nextInt();

        CollectionJoueurs collectionJoueurs = new CollectionJoueurs(nbJoueurs);

        for (int i = 1; i <= nbJoueurs; i++)
        {
            System.out.println("Quel est le nom du joueur " + i + " ?");
            collectionJoueurs.ajouterJoueur(new FabriqueBuncoPlus().getJoueur(sc.next()));
        }

        super.setIterateurJoueurs(collectionJoueurs.creerIterateur());
        return collectionJoueurs;
    }

    @Override
    public CollectionDes initialiserDes()
    {
        CollectionDes collectionDes = new CollectionDes(JeuBuncoPlus.NBDES);

        for (int i = 0; i < JeuBuncoPlus.NBDES; i++)
            collectionDes.ajouterDe(new FabriqueBuncoPlus().getDe(JeuBuncoPlus.NBFACES_DES));

        super.setIterateurDes(collectionDes.creerIterateur());
        return collectionDes;
    }
}
