package framework;

public abstract class Jeu {

    private final int nbTours;
    private final Strategie strategieScore;
    private IterateurDes iterateurDes;
    private IterateurJoueurs iterateurJoueurs;

    /**
     * Le constructeur de la classe jeu.
     * @param nbTours le nombre de tour durant lequel on joue.
     * @param strategieScore la strategie choisie pour le calcul du score et du vainqueur.
     */
    public Jeu(int nbTours, Strategie strategieScore)
    {
        this.nbTours = nbTours;
        this.strategieScore = strategieScore;
    }

    /**
     * Cette methode permet d'initialiser un jeu avec une collection de joueurs et une collection de des.
     */

    public void initialiserJeu()
    {
        this.initialiserJoueurs();
        this.initialiserDes();
    }

    /**
     * Cette methode permet d initialiser une collection de joueurs.
     * @return CollectionJoueurs.
     */
    protected abstract CollectionJoueurs initialiserJoueurs();

    /**
     * Cette methode permet d initialiser une collection de Des.
     * @return CollectionDes.
     */
    protected abstract CollectionDes initialiserDes();

    /**
     * Cette methode permet de jouer pendant un certain nombre de tour.
     * tout en donnant le score et le vamiqueur de la partie.
     *
     */
    public void jouer()
    {
        for (int i = 1; i <= nbTours; i++)
            this.calculerScoreTour(i);

        this.calculerLeVainqueur();
    }

    /**
     * Cette methode permet l appel d une strategie pour calculer le score de chaque de tour.
     * @param tourCourant le tour courant de la partie.
     */
    public void calculerScoreTour(int tourCourant)
    {
        this.strategieScore.calculerScoreTour(this, tourCourant);
    }

    /**
     * Cette methode permet l appel d une strategie pour calculer le vainqueur de la partie.
     */
    public void calculerLeVainqueur()
    {
        this.strategieScore.calculerLeVainqueur(this);
    }

    /**
     * Getter de l attribut nbTours.
     * @return le nombre de tours durant lequel une partie doit se jouer.
     */
    public int getNbTours()
    {
        return nbTours;
    }

    /**
     * Getter de l attribut iterateurDes.
     * @return l attribut iterateurDes.
     */
    public IterateurDes getIterateurDes()
    {
        return iterateurDes;
    }

    /**
     * Setter de l attribut iterateurDes.
     */
    public void setIterateurDes(IterateurDes iterateurDes)
    {
        this.iterateurDes = iterateurDes;
    }

    /**
     * Getter de l attribut iterateurJoueurs.
     * @return l attribut iterateurJoueurs.
     */
    public IterateurJoueurs getIterateurJoueurs()
    {
        return iterateurJoueurs;
    }

    /**
     * Setter de l attribut iterateurJoueurs.
     */
    public void setIterateurJoueurs(IterateurJoueurs iterateurJoueurs)
    {
        this.iterateurJoueurs = iterateurJoueurs;
    }

}
