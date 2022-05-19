package src.main.java;
import org.jfree.*;
import org.jfree.chart.JFreeChart;
public class streamSevenMain {

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
<<<<<<< HEAD
        // //This is the part where Jack's program draws a cool chart of our values with JFreeCharts
        // chartRunner jack = new chartRunner();
=======
        //This is the part where Nathan's program takes in the data from a text file and puts it into a matrix
        DataSet pH_vs_nitrite = new DataSet("src/main/resources/data/Nitrite_vs_pH.txt");
        System.out.println("Here is a matrix containing each stream's pH and nitrite values-");
        double[][] mat = pH_vs_nitrite.getMatrix();
        
        //This is where we compare the acceptable vs observed values
        int goodCount = 0;
        int badCount = 0;
        
       

        //This is the part where Jack's program draws a cool chart of our values with JFreeCharts
        chartRunner jack = new chartRunner(pH_vs_nitrite.getMatrix());
        
>>>>>>> dc174e96549940438b306361bc5308a43fef1efb
        
        JFreeChart test = new JFreeChart();
        
    }

}
