package beans;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DB {

    private static DB instanceDB;

    private static Calendar calendar = Calendar.getInstance();
    private static List<Customer> customers = new ArrayList<>();
    private static List<Occupation> occupations = new ArrayList<>();
    private static List<Handyman> handymen = new ArrayList<>();
    private static List<Handyman.Job> jobs = new ArrayList<>();
    private static Customer currentCustomer;
    private static Handyman currentHandyman;

    private DB(){}

    public static DB getDBInstance(){
        if (instanceDB == null)
            instanceDB = new DB();
        return instanceDB;
    }

    static{
        //CUSTOMERS
        calendar.set(2020, Calendar.FEBRUARY, 1);
        LocalDate localDate =  calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        currentCustomer = new Customer("Mirjana", "Konjikovac", "0612345678", "mirjanakonjikovac@gmail.com",
                "km140484d", "123", "Odgovaraju popodnevni časovi za popravke.");
        currentCustomer.setCreditCard(currentCustomer.new CreditCard("1234567891234567", localDate,"123", 10230.56));
        customers.add(currentCustomer);
        calendar.set(2019, calendar.MAY, 1);
        localDate =  calendar.getTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        currentCustomer = new Customer("Luka", "Savić", "0619599678", "lukasavic@yahoo.com",
                "sl140283d", "123", "Pozeljan rad vikendom.");
        currentCustomer.setCreditCard(currentCustomer.new CreditCard( "9999567822224567", localDate, "111", 8561.23));
        customers.add(currentCustomer);
        currentCustomer = null;

        //OCCUPATIONS
        occupations.add(new Occupation("Električar")); //0
        occupations.add(new Occupation("Moler")); //1
        occupations.add(new Occupation("Stolar")); //2
        occupations.add(new Occupation("Vodoinstalater")); //3
        occupations.add(new Occupation("Tapetar")); //4

        //HANDYMEN
        currentHandyman = new Handyman("Elena", "Vuceljić", "06911122330", "elena@hotmail.com",
                "Farbanje");
        jobs.add(currentHandyman.new Job(occupations.get(0), 2000, 10));
        currentHandyman.setJobs(jobs);
        handymen.add(currentHandyman);

        currentHandyman = new Handyman("Milica", "Bulatović", "06922277335", "mica@gmail.com",
                "Krecenje");
        jobs.clear();
        jobs.add(currentHandyman.new Job(occupations.get(0), 1800, 9));
        jobs.add(currentHandyman.new Job(occupations.get(1), 1300, 7));
        jobs.add(currentHandyman.new Job(occupations.get(4), 1800, 10));
        currentHandyman.setJobs(jobs);
        handymen.add(currentHandyman);

        currentHandyman = new Handyman("Dane", "Nikolić", "0645556667", "dane@gmail.com",
                "Plocice");
        jobs.clear();
        jobs.add(currentHandyman.new Job(occupations.get(1), 1500, 8));
        jobs.add(currentHandyman.new Job(occupations.get(2), 2100, 10));
        currentHandyman.setJobs(jobs);
        handymen.add(currentHandyman);

        currentHandyman = new Handyman("Dane", "Danicic", "0645556667", "djolence@gmail.com",
                "Drvorez");
        jobs.clear();
        jobs.add(currentHandyman.new Job(occupations.get(0), 2300, 8));
        jobs.add(currentHandyman.new Job(occupations.get(2), 2500, 10));
        currentHandyman.setJobs(jobs);
        handymen.add(currentHandyman);

        currentHandyman = null;
    }

    public static List<Customer> getCustomers() {
        return customers;
    }

    public static void addCustomer(Customer customer) { customers.add(customer); }

    public static List<Occupation> getOccupations() {
        return occupations;
    }

    public static List<Handyman> getHandymen() {
        return handymen;
    }

    public static Customer getCurrentCustomer() {
        return currentCustomer;
    }

    public static void setCurrentCustomer(Customer currentCustomer) {
        DB.currentCustomer = currentCustomer;
    }

    public static Handyman getCurrentHandyman() {
        return currentHandyman;
    }

    public static void setCurrentHandyman(Handyman currentHandyman) {
        DB.currentHandyman = currentHandyman;
    }


}
