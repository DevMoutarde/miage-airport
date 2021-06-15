public class Main {
    public static void main(String[] args)
    {
        Aeroport aeroport = new Aeroport();

        Avion avion = new Avion("gab airline", aeroport);

        avion.atterissage();
    }
}
