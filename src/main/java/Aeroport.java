public class Aeroport {

    private int num_autorisation = 0;

    public Aeroport(){

    }

    public int atterir(int autorisation, String compagnie)
    {
        if(!verifierAutorisation(autorisation))
        {
            System.out.println("Atterissage refusé");
            return -1;
        }

        System.out.println("Atterissage reussi");
        return 1;
    }

    private boolean verifierAutorisation(int autoriation)
    {

        return autoriation == num_autorisation;
    }

    public int demanderAutorisation()
    {
        this.num_autorisation++;
        return num_autorisation;
    }
}
