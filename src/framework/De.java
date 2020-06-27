package framework;

import java.util.Random;

public class De implements Comparable<De> {
    private int nbFaces;
    private int faceActuelle;

    public De(int nbFaces)
    {
        this.nbFaces = nbFaces;
    }

    public int lancer()
    {
        this.faceActuelle = 1 + new Random().nextInt(this.nbFaces);
        return this.faceActuelle;
    }

    public int getFaceActuelle()
    {
        return faceActuelle;
    }

    @Override
    public int compareTo(De de)
    {
        return Integer.compare(this.faceActuelle, de.getFaceActuelle());
    }
}
