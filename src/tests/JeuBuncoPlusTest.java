package tests;

import buncoPlus.JeuBuncoPlus;
import framework.CollectionDes;
import framework.CollectionJoueurs;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class JeuBuncoPlusTest {

    private JeuBuncoPlus jeu;

    @Before
    public void setUp() throws Exception
    {
        this.jeu = new JeuBuncoPlus(10);
    }

    @Test
    public void initialiserJoueurs()
    {
        String input = "2\nAlice\nBob";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        CollectionJoueurs cj = this.jeu.initialiserJoueurs();

        assertEquals(2, cj.getJoueurs().length);

        assertEquals("Alice", cj.getJoueurs()[0].getNom());
        assertEquals("Bob", cj.getJoueurs()[1].getNom());
    }

    @Test
    public void initialiserDes()
    {
        CollectionDes cd = this.jeu.initialiserDes();

        assertEquals(3, cd.getDes().length);
    }
}