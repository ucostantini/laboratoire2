package tests;

import framework.Joueur;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JoueurTest {

    private Joueur joueur1;
    private Joueur joueur2;

    @Before
    public void faireAvant()
    {
        joueur1 = new Joueur("joueur1");
        joueur2 = new Joueur("joueur2");

    }
    @Test
    public void scoreSuperieurTest()
    {
        joueur1.ajouterPoints(1);
        joueur2.ajouterPoints(2);
        assertEquals(1, joueur2.compareTo(joueur1));
    }
    @Test
    public void scoreInferieurTest()
    {
        joueur1.ajouterPoints(1);
        joueur2.ajouterPoints(2);
        assertEquals(-1, joueur1.compareTo(joueur2));
    }
    @Test
    public void scoreEgaleTest()
    {
        joueur1.ajouterPoints(2);
        joueur2.ajouterPoints(2);
        assertEquals(0, joueur1.compareTo(joueur2));
    }
    @Test
    public void getNomJoueur(){

        assertEquals("joueur1",joueur1.getNom());
        assertEquals("joueur2",joueur2.getNom());

    }
    @Test
    public void getScoreJoueur(){
        joueur1.setScore(17);
        joueur2.setScore(24);

        assertEquals(17,joueur1.getScore());
        assertEquals(24,joueur2.getScore());

    }

}