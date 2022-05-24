package src.main.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class DataSet {
    
    private ArrayList<Location> locations = new ArrayList<Location>();

    private Object[] location;
    private Object[] year;
    private double[] pHs;
    private double[] nitrites;

    private Object[][] data;
    
    private DoubleSummaryStatistics pHStats;
    private DoubleSummaryStatistics nitriteStats;

    public DataSet (String pathname) throws FileNotFoundException {
        location = new Object[locations.size()];
        year = new Object[locations.size()];
        pHs = new double[locations.size()];
        nitrites = new double[locations.size()];

        Scanner lineChopper = new Scanner(new File(pathname));
        while (lineChopper.hasNextLine()) {
            locations.add(new Location(lineChopper.nextLine()));
        }

        for (int i = 0; i < locations.size(); i++) {
            location[i] = locations.get(i).getLocation();
            year[i] = locations.get(i).getYear();
            pHs[i] = locations.get(i).getPH();
            nitrites[i] = locations.get(i).getNitrite();
        }

        DoubleSummaryStatistics pHStats = DoubleStream.of(pHs).summaryStatistics();
        DoubleSummaryStatistics nitriteStats = DoubleStream.of(nitrites).summaryStatistics();

    }

    public Object[][] getMatrix () {
        Object[] pHsObjects = new Object[locations.size()];
        Object[] nitriteObjects = new Object[locations.size()];
        for (int i = 0; i < locations.size(); i++) {
            pHsObjects[i] = (Object)pHs[i];
        }
        for (int i = 0; i < locations.size(); i++) {
            nitriteObjects[i] = (Object)nitrites[i];
        }
        return new Object[][]{location, year, pHsObjects, nitriteObjects};
    }

    public double getPHAverage () {
        return pHStats.getAverage();
    }

    public double getNitriteAverage () {
        return nitriteStats.getAverage();
    }
    
    public double[] getPHRange () {
        return new double[] {pHStats.getMin(), pHStats.getMax()};
    }

    public double[] getNitriteRange () {
        return new double[] {nitriteStats.getMin(), nitriteStats.getMax()};
    }

    public ArrayList<Location> getLocations() {
        return locations;
    }

    //From https://www.geeksforgeeks.org/program-find-correlation-coefficient/
    public double getCorrelationCoefficient () {
        int n = pHs.length;
        double[] X = pHs;
        double[] Y = nitrites;

        double sum_X = 0, sum_Y = 0, sum_XY = 0;
        double squareSum_X = 0, squareSum_Y = 0;
       
        for (int i = 0; i < n; i++)
        {
            // sum of elements of array X.
            sum_X = sum_X + X[i];
       
            // sum of elements of array Y.
            sum_Y = sum_Y + Y[i];
       
            // sum of X[i] * Y[i].
            sum_XY = sum_XY + X[i] * Y[i];
       
            // sum of square of array elements.
            squareSum_X = squareSum_X + X[i] * X[i];
            squareSum_Y = squareSum_Y + Y[i] * Y[i];
        }
       
        // use formula for calculating correlation 
        // coefficient.
        float corr = (float)(n * sum_XY - sum_X * sum_Y)/
                     (float)(Math.sqrt((n * squareSum_X -
                     sum_X * sum_X) * (n * squareSum_Y - 
                     sum_Y * sum_Y)));
       
        return corr;
    }

    // public double getPHAverage () {
    //     double total = 0;
    //     for (Location item : locations) {
    //         total += item.getPH();
    //     }
    //     return total / (double)locations.size();
    // }

    // public double getNitriteAverage () {
    //     double total = 0;
    //     for (Location item : locations) {
    //         total += item.getNitrite();
    //     }
    //     return total / (double)locations.size();
    // }

    // public double[] getPHRange () {
    //     double min = Double.MAX_VALUE;
    //     for (Location item : locations) {
    //         if (item.getPH() < min) {
    //             min = item.getPH();
    //         }
    //     }

    //     double max = Double.MIN_VALUE;
    //     for (Location item : locations) {
    //         if (item.getPH() > min) {
    //             max = item.getPH();
    //         }
    //     }
    //     return new double[]{min, max};
    // }

    // public double[] getNitriteRange () {
    //     double min = Double.MAX_VALUE;
    //     for (Location item : locations) {
    //         if (item.getNitrite() < min) {
    //             min = item.getNitrite();
    //         }
    //     }

    //     double max = Double.MIN_VALUE;
    //     for (Location item : locations) {
    //         if (item.getNitrite() > min) {
    //             max = item.getNitrite();
    //         }
    //     }
    //     return new double[]{min, max};
    // }


    public void main (String[] args) throws IOException {
        Scanner dataIn = new Scanner(new File("src/main/resources/data/AllTheDataCorrected.txt"));
        PrintWriter dataOut = new PrintWriter(new BufferedWriter(new FileWriter(new File("src/main/resources/data/Nitrite_vs_pH.txt"))));
        while (dataIn.hasNextLine()) {
            Location data = new Location(dataIn.nextLine());
            locations.add(data);
            dataOut.println(data.getLocation() + " " + data.getYear() + " " + data.getNitrite() + " " + data.getPH());
        }
        dataOut.flush();
        dataOut.close();
    }

}
