package buncoPlus;

import framework.Fabrique;
import framework.Jeu;

public class Main {

    public static void main(String[] args)
    {
        Fabrique fabrique = new FabriqueBuncoPlus();

        Jeu j = fabrique.getJeu(6);
        j.initialiserJeu();
        j.jouer();
    }
}
