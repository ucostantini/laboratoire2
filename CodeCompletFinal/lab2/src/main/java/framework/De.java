package framework;

import java.util.Random;

/**
 * Classe responsable du De
 */
public class De implements Comparable<De> {
    private final int nbFaces;
    private int faceActuelle;

    /**
     * Constructeur de la classe, qui sert a instancier un de
     * @param nbFaces, nombre de faces que le de possede
     */
    public De(int nbFaces)
    {
        this.nbFaces = nbFaces;
    }

    /**
     * Met un nombre aleatoire a faceActuelle entre 1 et le nombre de faces
     * @return la propriete faceActuelle du de
     */
    public int lancer()
    {
        this.faceActuelle = 1 + new Random().nextInt(this.nbFaces);
        return this.faceActuelle;
    }

    /**
     * Retourne la propriete faceActuelle du de
     * @return la propriete faceActuelle du de
     */
    public int getFaceActuelle()
    {
        return faceActuelle;
    }

    /**
     * Permet de mettre la face actuelle du de que l on veut
     * @param faceActuelle, la face actuelle qu'on veut que le de soit
     */
    public void setFaceActuelle(int faceActuelle)
    {
        this.faceActuelle = faceActuelle;
    }

    /**
     * Sert a comparer la face actuelle de deux des, si la face actuelle du premier de est egale a la face actuelle du deuxieme
     * de, ca retourne 0, si la face actuelle du premier de est plus grand que la face actuelle du deuxieme, ca retourne 1,
     * sinon si la face actuelle du premier de est plus petit que celui du deuxieme, ca retourne -1
     * @param de, de qui est comparer au premier
     * @return
     */
    @Override
    public int compareTo(De de)
    {
        return Integer.compare(this.faceActuelle, de.getFaceActuelle());
    }
}
