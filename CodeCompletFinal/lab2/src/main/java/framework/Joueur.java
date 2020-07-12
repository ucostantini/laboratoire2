package framework;

/**
 * Classe responsable du Joueur
 */
public class Joueur implements Comparable<Joueur> {
    private final String nom;
    private int score;

    /**
     * Constructeur de la classe, qui sert a instancier un joueur
     * @param nom, nom du joueur
     */
    public Joueur(String nom)
    {
        this.nom = nom;
        this.score = 0;
    }

    /**
     * Sert a mettre a jour le score du joueur, en ajoutant les points de chaque tour
     * @param points, points obtenue dans le tour courant
     */
    public void ajouterPoints(int points)
    {
        this.score += points;
    }

    /**
     *  Sert a mettre a jour le score du joueur, en retirant les points de chaque tour
     * @param points, points a retirer dans le tour courant
     */
    public void enleverPoints(int points)
    {
        this.score -= points;
    }

    /**
     * Sert a retourner le score du joueur
     * @return une instance du score du joueur.
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Sert a retourner le nom du joueur
     * @return une instance du nom du joueur
     */
    public String getNom()
    {
        return nom;
    }

    /**
     * Sert a comparer le score de deux joueur, si le score du premier joueur est egale au score du deuxieme
     * joueur sa retourne 0, si le score du premier joueur est plus grand que le score du deuxieme sa retourne 1,
     * sinon si le score du premier joueur est plus petit que celui du deuxieme sa retourne -1
     * @param joueur, joueur qui est comparer au premier
     * @return
     */
    @Override
    public int compareTo(Joueur joueur)
    {
        return Integer.compare(this.getScore(), joueur.getScore());
    }

    /**
     * Sert a ajuster le score du joueur
     * @param score a affecter au joueur
     */
    public void setScore(int score)
    {
        this.score = score;
    }
}
