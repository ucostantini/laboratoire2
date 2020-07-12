package framework;

import java.util.Iterator;

/**
 * Iterateur sur une collection de joueurs
 */
public class IterateurJoueurs implements Iterator<Joueur> {
    private final CollectionJoueurs collectionJoueurs;
    private int position;

    /**
     * Constructeur de la classe
     * @param collectionJoueurs, collection de joueur
     */
    public IterateurJoueurs(CollectionJoueurs collectionJoueurs)
    {
        this.collectionJoueurs = collectionJoueurs;
        this.position = 0;
    }

    /**
     * Sert a verifier si il y a un autre joueur dans la collection
     * @return vrai s'il y a un joueur, faux sinon
     */
    @Override
    public boolean hasNext()
    {
        return this.position < this.collectionJoueurs.getJoueurs().length
                && this.collectionJoueurs.getJoueurs()[position] != null;
    }

    /**
     * Sert a aller chercher le prochain joueur dans la collection
     * @return joueur, le joueur suivant
     */
    @Override
    public Joueur next()
    {
        //S'il y a un joueur suivant dans la collection
        if (this.hasNext())
        {
            Joueur joueur = this.collectionJoueurs.getJoueurs()[position];
            position++;
            return joueur;
        } else
            return null;
    }

    /**
     * Sert a mettre la position du joueur a 0
     */
    public void reset()
    {
        this.position = 0;
    }

    /**
     * Getter du nombre de joueurs contenus dans la collection.
     * @return le nombre de joueurs dans la collection.
     */
    public int getNbJoueurs(){
        return collectionJoueurs.getJoueurs().length;
    }
}
