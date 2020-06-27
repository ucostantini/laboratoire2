package framework;

public class CollectionJoueurs implements Collection {
    private Joueur[] joueurs;

    public CollectionJoueurs(int nbJoueurs)
    {
        this.joueurs = new Joueur[nbJoueurs];
    }

    public void ajouterJoueur(Joueur joueur)
    {
        for (int i = 0; i < this.joueurs.length; i++)
        {
            if (joueurs[i] == null)
            {
                joueurs[i] = joueur;
                break;
            }
        }
    }

    public Joueur[] getJoueurs()
    {
        return joueurs;
    }

    public IterateurJoueurs creerIterateur()
    {
        return new IterateurJoueurs(this);
    }
}
