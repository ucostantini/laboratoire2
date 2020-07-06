package tests;

import framework.CollectionJoueurs;
import framework.IterateurJoueurs;
import framework.Joueur;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IterateurJoueursTest {

    private CollectionJoueurs cJ;
    private IterateurJoueurs iterateurJoueurs;
    private Joueur joueur1;


    @Before
    public void faireAvant()
    {
        joueur1 = new Joueur("joueur1");
    }

    @Test
    public void hasNextVrai(){
        cJ = new CollectionJoueurs(1);
        iterateurJoueurs = new IterateurJoueurs(cJ);
        cJ.ajouterJoueur(joueur1);
        assertTrue(iterateurJoueurs.hasNext());
    }
    @Test
    public void hasNextFaux(){

        cJ = new CollectionJoueurs(0);
        iterateurJoueurs = new IterateurJoueurs(cJ);
        assertFalse(iterateurJoueurs.hasNext());
    }
    @Test
    public void nextVrai(){
        cJ = new CollectionJoueurs(1);
        iterateurJoueurs = new IterateurJoueurs(cJ);
        cJ.ajouterJoueur(joueur1);
        Joueur joueur = iterateurJoueurs.next();
        assertEquals("joueur1", joueur.getNom());

    }
    @Test
    public void nextFaux(){
        cJ = new CollectionJoueurs(0);
        iterateurJoueurs = new IterateurJoueurs(cJ);
        assertNull(iterateurJoueurs.next());

    }
    @Test
    public void reset(){

        Joueur joueur2 = new Joueur("joueur2");
        cJ = new CollectionJoueurs(2);
        cJ.ajouterJoueur(joueur1);
        cJ.ajouterJoueur(joueur2);

        iterateurJoueurs = new IterateurJoueurs(cJ);
        iterateurJoueurs.next();
        iterateurJoueurs.next();
        iterateurJoueurs.reset();

        assertEquals("joueur1", iterateurJoueurs.next().getNom());
    }

}
