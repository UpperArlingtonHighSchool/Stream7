package src.main.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.DoubleStream;
import java.util.DoubleSummaryStatistics;

public class DataSet {
    
    private ArrayList<Location> locations = new ArrayList<Location>();

    private double[] pHs = new double[locations.size()];
    private double[] nitrites = new double[locations.size()];

    private double[][] data = new double[][]{pHs, nitrites};
    
    private DoubleSummaryStatistics pHStats;
    private DoubleSummaryStatistics nitriteStats;

    public DataSet (String pathname) throws FileNotFoundException {
        Scanner lineChopper = new Scanner(new File(pathname));
        while (lineChopper.hasNextLine()) {
            locations.add(new Location(lineChopper.nextLine()));
        }

        for (int i = 0; i < locations.size(); i++) {
            pHs[i] = locations.get(i).getPH();
            nitrites[i] = locations.get(i).getNitrite();
        }

        DoubleSummaryStatistics pHStats = DoubleStream.of(pHs).summaryStatistics();
        DoubleSummaryStatistics nitriteStats = DoubleStream.of(nitrites).summaryStatistics();

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


    public static void main (String[] args) throws IOException {
        Scanner dataIn = new Scanner(new File("AllTheDataCorrected.txt"));
        PrintWriter dataOut = new PrintWriter(new BufferedWriter(new FileWriter(new File("Nitrite_vs_pH.txt"))));
        while (dataIn.hasNextLine()) {
            Location data = new Location(dataIn.nextLine());
            dataOut.println(data.getLocation() + " " + data.getNitrite() + " " + data.getPH());
        }
        dataOut.flush();
        dataOut.close();
    }

}
