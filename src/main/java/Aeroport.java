public class Aeroport {

    private int num_autorisation = 0;
    private int lastAuthorizedLanding = 0;

    public Aeroport(){

    }

    /**
     * permet atterissage et relache le verrou pour les autres threads
     * synchronized pour que le thread en cours soit owner et puisse notifier les autres threads
     * @param autorisation
     * @param compagnie
     * @return
     */
    public synchronized int atterir(int autorisation, String compagnie) throws InterruptedException {

        if(!verifierAutorisation(autorisation))
        {
            System.out.println("Atterissage refusé pour la compagnie (auth: "+autorisation+":"+"- mise en attente  "+ compagnie);
            wait();
            atterir(autorisation, compagnie);
            return -1;
        }

        System.out.println("Atterissage reussi pour la compagnie "+ compagnie);
        notifyAll();
        return 1;
    }

    private boolean verifierAutorisation(int autoriation)
    {
        if(lastAuthorizedLanding+1 == autoriation)
        {
            System.out.println("verification pour l'autorisation no: "+autoriation);
            lastAuthorizedLanding++;
            return true;
        }
        return false;
    }

    /**
     * zone synchronisée avec mise en attente de threads si nécessaire
     * synchronized pour eviter les acces conccurents
     * @return no d'authorisation
     * @throws InterruptedException
     */
    public synchronized int demanderAutorisation()
    {

        this.num_autorisation++;
        return num_autorisation;

    }
}
