package framework;

import java.util.Iterator;

/**
 * Iterateur sur une collection de des
 */
public class IterateurDes implements Iterator<De> {
    private CollectionDes collectionDes;
    private int position;


    public IterateurDes(CollectionDes collectionDes)
    {
        this.collectionDes = collectionDes;
        this.position = 0;
    }

    @Override
    public boolean hasNext()
    {
        return this.position < this.collectionDes.getDes().length
                && this.collectionDes.getDes()[position] != null;
    }

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

    public void reset()
    {
        this.position = 0;
    }
}
