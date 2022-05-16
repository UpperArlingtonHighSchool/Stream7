package src.main.java;

public class streamSevenMain {

    public static void main(String[] args) {
        
        Scraper collin = new Scraper();
        System.out.println("Acceptable Nitrite level = "+ collin.getAcceptableNitrite());
        System.out.println("Acceptable pH level = "+ collin.getAcceptablePH());
        
        ChartRunner jack = new ChartRunner();
        
        
        
    }

}
