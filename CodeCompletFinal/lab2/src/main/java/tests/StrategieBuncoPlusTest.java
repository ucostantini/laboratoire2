package tests;

import buncoPlus.JeuBuncoPlus;
import buncoPlus.StrategieBuncoPlus;
import framework.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class StrategieBuncoPlusTest {

    private StrategieBuncoPlus st;
    private CollectionJoueurs cj;
    private Jeu j;


    @Before
    public void setUp() {
        st = new StrategieBuncoPlus();
    }


    public void setUpVainqueur() throws Exception
    {
        this.cj = new CollectionJoueurs(3);

        this.cj.ajouterJoueur(new Joueur("Bob"));
        this.cj.ajouterJoueur(new Joueur("Alice"));
        this.cj.ajouterJoueur(new Joueur("Alex"));

        this.j = new JeuBuncoPlus(3);
        this.j.setIterateurJoueurs(cj.creerIterateur());
    }

    public void setUpScoreTour(int tours, int nbDes, int nbFace) {
        CollectionDes cd = new CollectionDes(nbDes);
        cj = new CollectionJoueurs(1);
        cj.ajouterJoueur(new Joueur("Abder"));
        for (int i = 0; i < nbDes; i++){
            cd.ajouterDe(new De(nbFace));
        }
        j = new JeuBuncoPlus(tours);
        j.setIterateurJoueurs(cj.creerIterateur());
        j.setIterateurDes(cd.creerIterateur());
    }

    @Test
    public void calculerLeVainqueurUnVainqueur() throws Exception {
        setUpVainqueur();
        this.cj.getJoueurs()[0].setScore(1);
        this.cj.getJoueurs()[1].setScore(2);
        this.cj.getJoueurs()[2].setScore(3);
        List<Joueur> vainqueur = this.st.calculerLeVainqueur(this.j);

        assertEquals(1, vainqueur.size());
        assertEquals("Alex", vainqueur.get(0).getNom());
        assertEquals(3, vainqueur.get(0).getScore());
    }

    @Test
    public void calculerLeVainqueurDeuxVainqueurs() throws Exception {
        setUpVainqueur();
        this.cj.getJoueurs()[0].setScore(4);
        this.cj.getJoueurs()[1].setScore(4);
        this.cj.getJoueurs()[2].setScore(3);
        List<Joueur> vainqueurs = this.st.calculerLeVainqueur(this.j);
        assertEquals(2, vainqueurs.size());
        assertEquals("Alice", vainqueurs.get(0).getNom());
        assertEquals("Bob", vainqueurs.get(1).getNom());
    }

    @Test
    public void calculerScoreTour0Point()
    {
        setUpScoreTour(1,1,1);
        int score = st.calculerScoreTour(j,2); // tour 2 avec un de de face 1
        assertEquals(0, score);
    }

    @Test
    public void calculerScoreTour1Point()
    {
        setUpScoreTour(1,1,1);
        int score = st.calculerScoreTour(j,1);  // tour 1 avec un de de face 1
        assertEquals(1, score);
    }

    @Test
    public void calculerScoreTour5Point()
    {
        setUpScoreTour(1,3,1);
        int score = st.calculerScoreTour(j,2); // tour 2 avec trois des de face 1
        assertEquals(5, score);
    }

    @Test
    public void calculerScoreTourBunco()
    {
        setUpScoreTour(1,3,1);
        int score = st.calculerScoreTour(j,1); // tour 1 avec trois des de face 1
        assertEquals(21, score);
    }


}