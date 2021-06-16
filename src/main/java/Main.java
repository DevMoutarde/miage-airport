public class Main {
    public static void main(String[] args) throws InterruptedException
    {
        Aeroport aeroport = new Aeroport();

        Avion gab_airline = new Avion("gab airline", aeroport);
        Avion ingrid_airline = new Avion("ingrid airline", aeroport);

        gab_airline.start();
        ingrid_airline.start();

        gab_airline.join();
        ingrid_airline.join();

        System.out.println("end of threads, rebooting");
        Thread.sleep(2000);


        gab_airline = new Avion("gab airline", aeroport);
        Avion gab_airline1 = new Avion("gab airline", aeroport);
        gab_airline.start();
        gab_airline1.start();
    }
}
