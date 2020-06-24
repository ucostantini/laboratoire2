package framework;

import java.util.Iterator;

/**
 * Iterateur sur une collection de joueurs
 */
public class IterateurJoueurs implements Iterator<Joueur> {
    @Override
    public boolean hasNext()
    {
        return false;
    }

    @Override
    public Joueur next()
    {
        return null;
    }
}
