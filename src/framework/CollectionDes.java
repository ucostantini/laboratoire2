package framework;

/**
 * Collection de joueurs
 */
public class CollectionDes implements Collection {
    private final De[] des;

    /**
     * Constructeur de la class CollectionDes
     *
     * @param nbDes, nombre de des dans la collection
     */
    public CollectionDes(int nbDes)
    {
        this.des = new De[nbDes];
    }

    /**
     * Permet d'ajouter un de a la collection si elle n'est pas remplie
     * @param De, le de qui sera ajouter a la collection
     */
    public void ajouterDe(De De)
    {
        for (int i = 0; i < this.des.length; i++)
        {
            if (des[i] == null)
            {
                des[i] = De;
                break;
            }
        }
    }

    /**
     * Permet d'avoir le tableau des des
     * @return la collection des des
     */
    public De[] getDes()
    {
        return des;
    }

    /**
     * Instancie et retourne un iterateur pour la collection des
     * @return un iterateur pour cette collection
     */
    public IterateurDes creerIterateur()
    {
        return new IterateurDes(this);
    }

    /**
     * Getter de la taille du tableau de des.
     *
     * @return le nombre de des dans la collection.
     */
    public int getNbDes()
    {
        return des.length;
    }
}

