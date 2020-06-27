package framework;

public class Joueur implements Comparable<Joueur> {
    private String nom;
    private int score;

    public Joueur(String nom)
    {
        this.nom = nom;
        this.score = 0;
    }

    public void ajouterPoints(int points)
    {
        this.score += points;
    }

    public void enleverPoints(int points)
    {
        this.score -= points;
    }

    public int getScore()
    {
        return score;
    }

    public String getNom()
    {
        return nom;
    }

    @Override
    public int compareTo(Joueur joueur)
    {
        return Integer.compare(this.getScore(), joueur.getScore());
    }
}
