import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class streamSevenMain {

    public static void main(String[] args) throws IOException {

        //Hey Dr. Kahle! How are you doing? I hope you are having a good day!

        // Instantiate GUI
        GUI gui = new GUI();

        //This is the part where Nathan's program takes in the data from a text file and puts it into a matrix
        DataSet pH_vs_nitrite = new DataSet("src/main/resources/data/AllTheDataCorrected.txt");
        System.out.println("Here is a matrix containing each stream's pH and nitrite values-");

        Object[][] mat = pH_vs_nitrite.getMatrix();
        
        //Here we use Nathan's methods to do great things
        double pHAverage = pH_vs_nitrite.getPHAverage();
        double nitriteAverage = pH_vs_nitrite.getNitriteAverage();
        double[] nitriteRange = pH_vs_nitrite.getNitriteRange();
        double[] pHRange = pH_vs_nitrite.getPHRange();
        double correlationCoefficient = pH_vs_nitrite.getCorrelationCoefficient();
        ArrayList<Location> locations = pH_vs_nitrite.getLocations();
        System.out.println(Arrays.deepToString(pH_vs_nitrite.getMatrix()));

        //This is the part where Collin's program gets the acceptable values off of the web
        Scraper collin = new Scraper();
        double maxNit = collin.getAcceptableNitrite();
        double minPH = collin.getMinAcceptablePH();
        double maxPH = collin.getMaxAcceptablePH();
        System.out.println("Acceptable maximum Nitrite level = " + maxNit);
        System.out.println("Acceptable minimum pH level = " + minPH);
        System.out.println("Acceptable maximum pH level = " + maxPH);
        gui.setAcceptablePH(minPH + "-" + maxPH);
        gui.setAcceptableNitrite("" + maxNit);

        // Initialize GUI button listeners
        gui.getLoadButton().addActionListener(e -> {
            gui.setData(pH_vs_nitrite.getMatrix());
            gui.populateTable();

            //Here we use Nathan's methods to do great things
            gui.getInfoArea().append("pH avg: " + pH_vs_nitrite.getPHAverage() + "\n");
            gui.getInfoArea().append("Nitrite avg: " + pH_vs_nitrite.getNitriteAverage() + "\n");
            gui.getInfoArea().append("pH range: " + Arrays.toString(pH_vs_nitrite.getPHRange()) + "\n");
            gui.getInfoArea().append("Nitrite range: " + Arrays.toString(pH_vs_nitrite.getNitriteRange()) + "\n");
            gui.getInfoArea().append("Correlation Coefficient: " + pH_vs_nitrite.getCorrelationCoefficient() + "\n");

            gui.getLoadButton().setEnabled(false);
            gui.getGraphButton().setEnabled(true);
        });

        gui.getGraphButton().addActionListener(e -> {
            //This is the part where Jack's program draws a cool chart of our values with JFreeCharts
            chartRunner jack = null;
            try {
                jack = new chartRunner(pH_vs_nitrite.getMatrix());
                ImageIcon chart = new ImageIcon("BarChart.jpeg");
                JDialog graphPopup = new JDialog();
                JLabel label = new JLabel(chart);
                graphPopup.add(label);
                graphPopup.pack();
                graphPopup.setLocationRelativeTo(null);
                graphPopup.setVisible(true);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
