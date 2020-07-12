package framework;

public interface Fabrique {
    /**
     * Signature de la methode qui cree un nouveau de avec le nombre de faces specifiees.
     * @param nbFaces le nombre de face que doit avoir le de.
     * @return un objet De.
     */
    De getDe(int nbFaces);

    /**
     * Signature de la methode qui cree un nouveau joueur avec un nom.
     * @param nom le nom du joueur.
     * @return un objet Joueur.
     */
    Joueur getJoueur(String nom);

    /**
     * Signature de la methode qui cree un nouveau jeu avec le nombre de tours durant lequel la partie dure.
     * @param nbTours le nombre de tours durant lequel la partie dure.
     * @return un objet Jeu.
     */
    Jeu getJeu(int nbTours);
}
