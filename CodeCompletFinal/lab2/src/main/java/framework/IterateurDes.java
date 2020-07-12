package framework;

import java.util.Iterator;

/**
 * Iterateur sur une collection de des
 */
public class IterateurDes implements Iterator<De> {
    private final CollectionDes collectionDes;
    private int position;

    /**
     * Constructeur de la classe IterateurDe
     * @param collectionDes, collection de des
     */
    public IterateurDes(CollectionDes collectionDes)
    {
        this.collectionDes = collectionDes;
        this.position = 0;
    }

    /**
     * Verifie si la position courante est plus petit que la taille de la collection
     * @return vrai si la position est plus petit que la taille ou faux si non
     */
    @Override
    public boolean hasNext()
    {
        return this.position < this.collectionDes.getDes().length
                && this.collectionDes.getDes()[position] != null;
    }

    /**
     * Retourne le de a la position courante et incremente la position
     * @return de, le de a la position courante
     */
    @Override
    public De next()
    {
        if (this.hasNext())
        {
            De de = this.collectionDes.getDes()[position];
            position++;
            return de;
        } else
            return null;
    }

    /**
     * Met la position de l iterateur a 0 pour reiterer a partir du debut
     */
    public void reset()
    {
        this.position = 0;
    }

    /**
     * Getter du nombre de des contenus dans la collection.
     * @return le nombre de des dans la collection.
     */
    public int getNbDes(){
        return collectionDes.getNbDes();
    }
}