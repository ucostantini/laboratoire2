package tests;

import buncoPlus.JeuBuncoPlus;
import buncoPlus.StrategieBuncoPlus;
import framework.CollectionJoueurs;
import framework.Jeu;
import framework.Joueur;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StrategieBuncoPlusTest {

    private StrategieBuncoPlus st;
    private CollectionJoueurs cj;
    private Jeu j;

    @Before
    public void setUp() throws Exception
    {
        this.st = new StrategieBuncoPlus();
        this.cj = new CollectionJoueurs(3);

        this.cj.ajouterJoueur(new Joueur("Bob"));
        this.cj.ajouterJoueur(new Joueur("Alice"));
        this.cj.ajouterJoueur(new Joueur("Alex"));

        this.j = new JeuBuncoPlus(3);
        this.j.setIterateurJoueurs(cj.creerIterateur());
    }

    @Test
    public void calculerLeVainqueurUnVainqueur()
    {
        this.cj.getJoueurs()[0].setScore(1);
        this.cj.getJoueurs()[1].setScore(2);
        this.cj.getJoueurs()[2].setScore(3);
        List<Joueur> vainqueur = this.st.calculerLeVainqueur(this.j);

        assertEquals(1, vainqueur.size());
        assertEquals("Alex", vainqueur.get(0).getNom());
        assertEquals(3, vainqueur.get(0).getScore());
    }

    @Test
    public void calculerLeVainqueurDeuxVainqueurs()
    {
        this.cj.getJoueurs()[0].setScore(4);
        this.cj.getJoueurs()[1].setScore(4);
        this.cj.getJoueurs()[2].setScore(3);
        List<Joueur> vainqueurs = this.st.calculerLeVainqueur(this.j);
        assertEquals(2, vainqueurs.size());
        assertEquals("Alice", vainqueurs.get(0).getNom());
        assertEquals("Bob", vainqueurs.get(1).getNom());
    }
}