package tests;

import framework.De;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DeTest {

    private De de1;
    private De de2;

    @Before
    public void faireAvant()
    {
        de1 = new De(6);
        de2 = new De(6);
    }

    @Test
    public void deSuperieurTest()
    {
        de1.setFaceActuelle(4);
        de2.setFaceActuelle(5);
        assertTrue(de1.compareTo(de2) == -1);
    }

    @Test
    public void deInferieurTest()
    {
        de1.setFaceActuelle(4);
        de2.setFaceActuelle(5);
        assertEquals(1, de2.compareTo(de1));
    }

    @Test
    public void memeDeTest()
    {
        de1.setFaceActuelle(4);
        assertTrue(de1.compareTo(de1) == 0);
    }

    @Test(expected = NullPointerException.class)
    public void deNullTest()
    {
        de1.setFaceActuelle(4);
        de1.compareTo(null);
    }
}