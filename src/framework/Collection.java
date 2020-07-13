package framework;

import java.util.Iterator;

public interface Collection {
    /**
     * Signature de la methode qui cree un iterateur.
     *
     * @return un objet Iterateur.
     */

    Iterator creerIterateur();
}
