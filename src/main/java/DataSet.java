package src.main.java;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSet {
    
    private ArrayList<Location> locations = new ArrayList<Location>();

    public DataSet (String pathname) throws FileNotFoundException {
        Scanner lineChopper = new Scanner(new File(pathname));
        while (lineChopper.hasNextLine()) {
            locations.add(new Location(lineChopper.nextLine()));
        }
    }

    public double getPHAverage () {
        double total = 0;
        for (Location item : locations) {
            total += item.getPH();
        }
        return total / (double)locations.size();
    }

    public double getNitriteAverage () {
        double total = 0;
        for (Location item : locations) {
            total += item.getNitrite();
        }
        return total / (double)locations.size();
    }

    public double[] getPHRange () {
        double min = Double.MAX_VALUE;
        for (Location item : locations) {
            if (item.getPH() < min) {
                min = item.getPH();
            }
        }

        double max = Double.MIN_VALUE;
        for (Location item : locations) {
            if (item.getPH() > min) {
                max = item.getPH();
            }
        }
        return new double[]{min, max};
    }

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
