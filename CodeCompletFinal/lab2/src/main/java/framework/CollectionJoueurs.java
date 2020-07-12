package framework;

/**
 * Collection de joueurs
 */
public class CollectionJoueurs implements Collection {
    private final Joueur[] joueurs;

    /**
     * Connstructeur de la collection de joueur
     * @param nbJoueurs, nombre de joueur dans la collection
     */
    public CollectionJoueurs(int nbJoueurs)
    {
        this.joueurs = new Joueur[nbJoueurs];
    }

    /**
     * Sert a ajouter un joueur a la collection de joueurs
     * @param joueur, joueur qui sera ajoute a la collection
     */
    public void ajouterJoueur(Joueur joueur)
    {
        //pour chaque joueur dans le tableau de joueurs
        for (int i = 0; i < this.joueurs.length; i++)
        {
            // s'il n'y a pas de joueur a cette position
            if (joueurs[i] == null)
            {
                //ajouter le joueur
                joueurs[i] = joueur;
                break;
            }
        }
    }

    /**
     * Sert a retourner le tableau de joueurs
     * @return le tableau de joueurs
     */
    public Joueur[] getJoueurs()
    {
        return joueurs;
    }

    /**
     * Sert a instancier un iterateur de joueur
     * @return un iterateur de joueur
     */
    public IterateurJoueurs creerIterateur()
    {
        return new IterateurJoueurs(this);
    }
}