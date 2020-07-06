package tests;

import buncoPlus.FabriqueBuncoPlus;
import buncoPlus.JeuBuncoPlus;
import framework.Jeu;
import framework.Joueur;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FabriqueBuncoPlusTest {

    private FabriqueBuncoPlus fb;

    @Before
    public void setUp() throws Exception
    {
        this.fb = new FabriqueBuncoPlus();
    }

    @Test
    public void getJoueurNom()
    {
        Joueur j = this.fb.getJoueur("Jean");
        Joueur j2 = this.fb.getJoueur("Alex");

        assertEquals("Jean", j.getNom());
        assertEquals("Alex", j2.getNom());
    }

    @Test
    public void getJoueurScore()
    {
        Joueur j = this.fb.getJoueur("Jean");
        Joueur j2 = this.fb.getJoueur("Alex");

        assertEquals(0, j.getScore());
        assertEquals(0, j2.getScore());
    }

    @Test
    public void getJeuNbTours()
    {
        Jeu j = this.fb.getJeu(10);

        assertEquals(10, j.getNbTours());
    }

    @Test
    public void getJeuInstance()
    {
        Jeu j = this.fb.getJeu(10);

        assertTrue(j instanceof JeuBuncoPlus);
    }
}