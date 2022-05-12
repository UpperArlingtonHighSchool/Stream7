import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DataSet {
    
    private String location;
    private int year;
    private Double nitrite;
    private Double nitrate;
    private Double phosphate;
    private Double conduc;
    private Double turbidity;
    private Double temp;
    private Double TDS;
    private Double pH;
    private Double alk;
    private Double Fchlorine;
    private Double Tchlorine;
    private Double salinity;
    private Double hardness;

    public DataSet (String filename) throws FileNotFoundException {
        Scanner dataIn = new Scanner(new File (filename));
        while (dataIn.hasNext()) {
            location = dataIn.next();
            year = dataIn.nextInt();
            nitrite = dataIn.nextDouble();
            nitrate = dataIn.nextDouble();
            phosphate = dataIn.nextDouble();
            conduc = dataIn.nextDouble();
            turbidity = dataIn.nextDouble();
            temp = dataIn.nextDouble();
            TDS = dataIn.nextDouble();
            pH = dataIn.nextDouble();
            alk = dataIn.nextDouble();
            Fchlorine = dataIn.nextDouble();
            Tchlorine = dataIn.nextDouble();
            salinity = dataIn.nextDouble();
            hardness = dataIn.nextDouble();
        }
    }

}
