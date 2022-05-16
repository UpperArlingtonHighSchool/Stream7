package src.main.java;

public class streamSevenMain {

    public static void main(String[] args) {
        
        //This is the part where Collin's program gets the acceptable values off of the web
        Scraper collin = new Scraper();
        System.out.println("Acceptable Nitrite level = "+ collin.getAcceptableNitrite());
        System.out.println("Acceptable pH level = "+ collin.getAcceptablePH());
        
        //This is the part where Jack's program draws a cool chart of our values with JFreeCharts
        chartRunner jack = new chartRunner();
        
        
        
    }

}
