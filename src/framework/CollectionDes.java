package framework;

public class CollectionDes implements Collection {
    private De[] des;

    public CollectionDes(int nbDes)
    {
        this.des = new De[nbDes];
    }

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

    public De[] getDes()
    {
        return des;
    }

    public IterateurDes creerIterateur()
    {
        return new IterateurDes(this);
    }
}
