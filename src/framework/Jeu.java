package framework;

public abstract class Jeu {
    private int nbTours;
    private Strategie strategieScore;
    private IterateurDes iterateurDes;
    private IterateurJoueurs iterateurJoueurs;

    public Jeu(int nbTours, Strategie strategieScore)
    {
        this.nbTours = nbTours;
        this.strategieScore = strategieScore;
    }

    public void initialiserJeu()
    {
        this.initialiserJoueurs();
        this.initialiserDes();
    }

    protected abstract CollectionJoueurs initialiserJoueurs();

    protected abstract CollectionDes initialiserDes();

    public void jouer()
    {
        for (int i = 1; i <= nbTours; i++)
            this.calculerScoreTour(i);

        this.calculerLeVainqueur();
    }

    public void calculerScoreTour(int tourCourant)
    {
        this.strategieScore.calculerScoreTour(this, tourCourant);
    }

    public void calculerLeVainqueur()
    {
        this.strategieScore.calculerLeVainqueur(this);
    }

    public int getNbTours()
    {
        return nbTours;
    }

    public IterateurDes getIterateurDes()
    {
        return iterateurDes;
    }

    public void setIterateurDes(IterateurDes iterateurDes)
    {
        this.iterateurDes = iterateurDes;
    }

    public IterateurJoueurs getIterateurJoueurs()
    {
        return iterateurJoueurs;
    }

    public void setIterateurJoueurs(IterateurJoueurs iterateurJoueurs)
    {
        this.iterateurJoueurs = iterateurJoueurs;
    }

    public Strategie getStrategieScore()
    {
        return strategieScore;
    }
}
