
import java.io.File;
import java.util.ArrayList;

import org.jfree.*;
import org.jfree.chart.JFreeChart;
public class streamSevenMain {
//This is David Butz(Group Leader) coding the main method and adding comments
    public static void main(String[] args) {
        
        //This is the part where Collin's program gets the acceptable values off of the web
        Scraper collin = new Scraper();
        double maxNit = collin.getAcceptableNitrite();
        double minPH = collin.getMinAcceptablePH();
        double maxPH = collin.getMaxAcceptablePH();
        System.out.println("Acceptable maximum Nitrite level = "+ maxNit);
        System.out.println("Acceptable minimum pH level = "+ minPH);
        System.out.println("Acceptable maximum pH level = "+ maxPH);
        //Hey Dr. Kahle! How are you doing? I hope you are having a good day! 

        

        //This is the part where Nathan's program takes in the data from a text file and puts it into a matrix
        DataSet pH_vs_nitrite = new DataSet("src/main/resources/data/Nitrite_vs_pH.txt");
        System.out.println("Here is a matrix containing each stream's pH and nitrite values-");
        Object[][] mat = pH_vs_nitrite.getMatrix();
        
        //Here we use Nathan's methods to do great things
        double pHAverage = pH_vs_nitrite.getPHAverage();
        double nitriteAverage = pH_vs_nitrite.getNitriteAverage();
        double[] nitriteRange = pH_vs_nitrite.getNitriteRange();
        double[] pHRange = pH_vs_nitrite.getPHRange();
        double correlationCoefficient = pH_vs_nitrite.getCorrelationCoefficient();
        ArrayList<Location> locations = pH_vs_nitrite.getLocations();
        
        
       

        //This is the part where Jack's program draws a cool chart of our values with JFreeCharts
        chartRunner jack = new chartRunner(pH_vs_nitrite.getMatrix());
        File chart = jack.getChart();

        
        
    }

}
