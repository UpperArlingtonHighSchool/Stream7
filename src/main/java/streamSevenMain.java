package src.main.java;
import org.jfree.*;
import org.jfree.chart.JFreeChart;
public class streamSevenMain {

    public static void main(String[] args) {
        
        //This is the part where Collin's program gets the acceptable values off of the web
        Scraper collin = new Scraper();
        System.out.println("Acceptable Nitrite level = "+ collin.getAcceptableNitrite());
        System.out.println("Acceptable minimum pH level = "+ collin.getMinAcceptablePH());
        System.out.println("Acceptable maximum pH level = "+ collin.getMaxAcceptablePH());
        
<<<<<<< HEAD
        // //This is the part where Jack's program draws a cool chart of our values with JFreeCharts
        // chartRunner jack = new chartRunner();
=======
        //This is the part where Nathan's program takes in the data from a text file and puts it into a matrix
        DataSet pH_vs_nitrite = new DataSet("src/main/resources/data/Nitrite_vs_pH.txt");

        //This is the part where Jack's program draws a cool chart of our values with JFreeCharts
        chartRunner jack = new chartRunner(pH_vs_nitrite.getMatrix());
        
>>>>>>> dc174e96549940438b306361bc5308a43fef1efb
        
        JFreeChart test = new JFreeChart();
        
    }

}
