public class Avion {

    private String compagnie;
    private Aeroport aeroport;

    public Avion(String compagnie, Aeroport aeroport)
    {
        this.aeroport= aeroport;
        this.compagnie = compagnie;
    }

    public void atterissage()
    {
        int autorisation = aeroport. demanderAutorisation();
        aeroport.atterir(autorisation, compagnie);
    }
}
