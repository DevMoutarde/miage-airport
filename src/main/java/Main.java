public class Main {
    public static void main(String[] args) throws InterruptedException
    {
        Aeroport aeroport = new Aeroport();

        new Avion("gab airline", aeroport).start();
        new Avion("ingrid airline", aeroport).start();
        new Avion("gab airline1", aeroport).start();
        new Avion("ingrid airline1", aeroport).start();
        new Avion("gab airline2", aeroport).start();
        new Avion("ingrid airline2", aeroport).start();




    }
}
