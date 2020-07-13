package tests;

import framework.CollectionDes;
import framework.De;
import framework.IterateurDes;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CollectionDesTest {

    private CollectionDes cD;
    private De De1;
    private De De2;
    private IterateurDes iterateurDes;

    @Before
    public void faireAvant()
    {
        De1 = new De(8);
        De1.setFaceActuelle(8);
        De2 = new De(6);
        De2.setFaceActuelle(6);
        iterateurDes = new IterateurDes(cD);

    }

    public void initialisationCollection()
    {
        cD = new CollectionDes(2);
        cD.ajouterDe(De1);
        cD.ajouterDe(De2);

    }

    @Test
    public void getDe()
    {

        initialisationCollection();
        De[] tabDes = cD.getDes();

        assertEquals(8, tabDes[0].getFaceActuelle());
        assertEquals(6, tabDes[1].getFaceActuelle());
    }

    @Test
    public void creerIterateur()
    {
        assertNotNull(iterateurDes);
    }

    @Test
    public void getNbDes()
    {
        initialisationCollection();
        assertEquals(2, cD.getNbDes());
    }
}