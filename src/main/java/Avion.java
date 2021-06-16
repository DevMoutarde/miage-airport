public class Avion extends Thread{

    private String compagnie;
    private Aeroport aeroport;

    public Avion(String compagnie, Aeroport aeroport)
    {
        this.aeroport= aeroport;
        this.compagnie = compagnie;
        this.setName("Thread-Avion-"+this.compagnie);
    }


    public void atterissage() throws InterruptedException
    {
        int autorisation = aeroport.demanderAutorisation();
        System.out.println("Demande d'autorisation pour: " +getName()+ " => autorisation obtenue avec le no "+ autorisation);
        int atterirStatus = aeroport.atterir(autorisation, compagnie);
        System.out.println(getName() +" status: "+ atterirStatus +" (1 = success, -1 = failed)");
    }

    @Override
    public void run()
    {
        try {
            this.atterissage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
