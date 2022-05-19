import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Scraper {

    private double nitrite;
    private double pHMin;
    private double pHMax;

    final String nitriteSite = "https://www.atsdr.cdc.gov/csem/nitrate-nitrite/standards.html";
    final Pattern nitritePattern = Pattern.compile("and for nitrites at (.*?) ppm");

    final String pHSite = "https://www.epa.gov/caddis-vol2/ph";
    final Pattern pHPattern = Pattern.compile("falling between pH (.*?)-(.*?) U.S.");

    public Scraper() {
        try {

            // Nitrite
            URL url = new URL(nitriteSite);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().contains("and for nitrites at")) {
                    Matcher matcher = nitritePattern.matcher(line.trim());
                    if (matcher.find()) {
                        nitrite = Double.parseDouble(matcher.group(1));
                    }
                }
            }
            is.close();

            // pH
            url = new URL(pHSite);
            conn = url.openConnection();
            is = conn.getInputStream();

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                if (line.trim().contains("the optima for most aquatic organisms falling between")) {
                    Matcher matcher = pHPattern.matcher(line.trim());
                    if (matcher.find()) {
                        pHMin = Double.parseDouble(matcher.group(1));
                        pHMax = Double.parseDouble(matcher.group(2));
                    }
                }
            }
            is.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public double getAcceptableNitrite() {
        return nitrite;
    }

    public double getMinAcceptablePH() {
        return pHMin;
    }

    public double getMaxAcceptablePH() {
        return pHMax;
    }

    /*public static void main(String[] args) {
        Scraper scraper = new Scraper();
        System.out.println(scraper.getAcceptableNitrite());
        System.out.println(scraper.getMinAcceptablePH());
        System.out.println(scraper.getMaxAcceptablePH());
    }*/
}
