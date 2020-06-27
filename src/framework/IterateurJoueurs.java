package framework;

import java.util.Iterator;

/**
 * Iterateur sur une collection de joueurs
 */
public class IterateurJoueurs implements Iterator<Joueur> {
    private CollectionJoueurs collectionJoueurs;
    private int position;


    public IterateurJoueurs(CollectionJoueurs collectionJoueurs)
    {
        this.collectionJoueurs = collectionJoueurs;
        this.position = 0;
    }

    @Override
    public boolean hasNext()
    {
        return this.position < this.collectionJoueurs.getJoueurs().length
                && this.collectionJoueurs.getJoueurs()[position] != null;
    }

    @Override
    public Joueur next()
    {
        if (this.hasNext())
        {
            Joueur joueur = this.collectionJoueurs.getJoueurs()[position];
            position++;
            return joueur;
        } else
            return null;
    }

    public void reset()
    {
        this.position = 0;
    }
}
