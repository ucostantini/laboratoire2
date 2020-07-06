package tests;

import framework.CollectionJoueurs;
import framework.IterateurJoueurs;
import framework.Joueur;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CollectionJoueursTest {

    private CollectionJoueurs cJ;
    private Joueur joueur1;
    private Joueur joueur2;
    private IterateurJoueurs iterateurJoueurs;

    @Before
    public void faireAvant()
    {
        joueur1 = new Joueur("joueur1");
        joueur2 = new Joueur("joueur2");
        iterateurJoueurs = new IterateurJoueurs(cJ);


    }
    @Test
    public void getJoueur(){

        cJ = new CollectionJoueurs(2);
        cJ.ajouterJoueur(joueur1);
        cJ.ajouterJoueur(joueur2);
        Joueur [] tabJoueurs = cJ.getJoueurs();

        assertEquals(2, cJ.getJoueurs().length);
        assertEquals("joueur1", tabJoueurs[0].getNom());
        assertEquals("joueur2", tabJoueurs[1].getNom());
    }
    @Test
    public void creerIterateur(){

        assertTrue(iterateurJoueurs instanceof IterateurJoueurs);

    }

}
