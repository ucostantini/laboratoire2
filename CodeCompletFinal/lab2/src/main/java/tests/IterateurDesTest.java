package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import framework.CollectionDes;
import framework.IterateurDes;
import framework.De;

public class IterateurDesTest {

    private CollectionDes cD;
    private IterateurDes iterateurDes;
    private De de1;


    @Before
    public void faireAvant()
    {
        de1 = new De(8);
        de1.setFaceActuelle(8);
    }

    @Test
    public void hasNextVrai(){
        cD = new CollectionDes(1);
        iterateurDes = new IterateurDes(cD);
        cD.ajouterDe(de1);
        assertTrue(iterateurDes.hasNext());
    }
    @Test
    public void hasNextFaux(){

        cD = new CollectionDes(0);
        iterateurDes = new IterateurDes(cD);
        assertFalse(iterateurDes.hasNext());
    }
    @Test
    public void nextVrai(){
        cD = new CollectionDes(1);
        iterateurDes = new IterateurDes(cD);
        cD.ajouterDe(de1);
        De de = iterateurDes.next();
        assertEquals(8, de.getFaceActuelle());

    }
    @Test
    public void nextFaux(){
        cD = new CollectionDes(0);
        iterateurDes = new IterateurDes(cD);
        assertNull(iterateurDes.next());

    }
    @Test
    public void reset(){

        De de2 = new De(6);
        cD = new CollectionDes(2);
        cD.ajouterDe(de1);
        cD.ajouterDe(de2);

        iterateurDes = new IterateurDes(cD);
        iterateurDes.next();
        iterateurDes.next();
        iterateurDes.reset();

        assertEquals(8, iterateurDes.next().getFaceActuelle());
    }

    @Test
    public void getNbDes(){
        cD = new CollectionDes(8);
        iterateurDes = new IterateurDes(cD);
        assertEquals(8, iterateurDes.getNbDes());;
    }

}
