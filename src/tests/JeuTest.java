package tests;

import framework.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class JeuTest {
    Jeu j;
    IterateurDes itDes;
    IterateurJoueurs itJoueurs;
    Strategie strategieBase;

    @Before
    public void setUp()
    {
        j = Mockito.mock(Jeu.class, Mockito.withSettings()
                .useConstructor(5, strategieBase)
                .defaultAnswer(Mockito.CALLS_REAL_METHODS)
        );
        CollectionDes collectionDes = new CollectionDes(4);
        itDes = new IterateurDes(collectionDes);
        CollectionJoueurs collectionJoueurs = new CollectionJoueurs(3);
        itJoueurs = new IterateurJoueurs(collectionJoueurs);
    }

    @Test
    public void getIterateurDes()
    {
        j.setIterateurDes(itDes);
        assertEquals(4, j.getIterateurDes().getNbDes());
    }

    @Test
    public void setIterateurDes()
    {
        j.setIterateurDes(itDes);
        assertEquals(itDes, j.getIterateurDes());
    }

    @Test
    public void getNbTours()
    {
        assertEquals(5, j.getNbTours());
    }

    @Test
    public void getIterateurJoueur()
    {
        j.setIterateurJoueurs(itJoueurs);
        assertEquals(3, j.getIterateurJoueurs().getNbJoueurs());
    }

    @Test
    public void setIterateurJoueurs()
    {
        j.setIterateurJoueurs(itJoueurs);
        assertEquals(itJoueurs, j.getIterateurJoueurs());
    }
}
