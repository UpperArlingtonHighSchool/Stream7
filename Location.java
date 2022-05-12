import java.io.FileNotFoundException;
import java.util.Scanner;

public class Location {
    
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

    public Location (String line) throws FileNotFoundException {
        Scanner dataIn = new Scanner(line);

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

        dataIn.close();
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getNitrite() {
        return this.nitrite;
    }

    public void setNitrite(Double nitrite) {
        this.nitrite = nitrite;
    }

    public Double getNitrate() {
        return this.nitrate;
    }

    public void setNitrate(Double nitrate) {
        this.nitrate = nitrate;
    }

    public Double getPhosphate() {
        return this.phosphate;
    }

    public void setPhosphate(Double phosphate) {
        this.phosphate = phosphate;
    }

    public Double getConduc() {
        return this.conduc;
    }

    public void setConduc(Double conduc) {
        this.conduc = conduc;
    }

    public Double getTurbidity() {
        return this.turbidity;
    }

    public void setTurbidity(Double turbidity) {
        this.turbidity = turbidity;
    }

    public Double getTemp() {
        return this.temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getTDS() {
        return this.TDS;
    }

    public void setTDS(Double TDS) {
        this.TDS = TDS;
    }

    public Double getPH() {
        return this.pH;
    }

    public void setPH(Double pH) {
        this.pH = pH;
    }

    public Double getAlk() {
        return this.alk;
    }

    public void setAlk(Double alk) {
        this.alk = alk;
    }

    public Double getFchlorine() {
        return this.Fchlorine;
    }

    public void setFchlorine(Double Fchlorine) {
        this.Fchlorine = Fchlorine;
    }

    public Double getTchlorine() {
        return this.Tchlorine;
    }

    public void setTchlorine(Double Tchlorine) {
        this.Tchlorine = Tchlorine;
    }

    public Double getSalinity() {
        return this.salinity;
    }

    public void setSalinity(Double salinity) {
        this.salinity = salinity;
    }

    public Double getHardness() {
        return this.hardness;
    }

    public void setHardness(Double hardness) {
        this.hardness = hardness;
    }

}
