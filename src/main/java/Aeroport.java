public class Aeroport {

    private int num_autorisation = 0;
    private  boolean landingOnGoing = false;

    public Aeroport(){

    }

    /**
     * permet atterissage et relache le verrou pour les autres threads
     * synchronized pour que le thread en cours soit owner et puisse notifier les autres threads
     * @param autorisation
     * @param compagnie
     * @return
     */
    public synchronized int atterir(int autorisation, String compagnie)
    {

        if(!verifierAutorisation(autorisation))
        {
            System.out.println("Atterissage refusé pour la compagnie "+ compagnie);
            return -1;
        }

        System.out.println("Atterissage reussi pour la compagnie "+ compagnie);
        landingOnGoing = false;
        notifyAll();
        return 1;
    }

    private boolean verifierAutorisation(int autoriation)
    {

        return autoriation == num_autorisation;
    }

    /**
     * zone synchronisée avec mise en attente de threads si nécessaire
     * synchronized pour eviter les acces conccurents
     * @return no d'authorisation
     * @throws InterruptedException
     */
    public synchronized int demanderAutorisation() throws InterruptedException
    {
        if(landingOnGoing)
        {
            wait();
        }
        this.num_autorisation++;
        landingOnGoing = true;
        return num_autorisation;

    }
}
