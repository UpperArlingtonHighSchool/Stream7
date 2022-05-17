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
    private double pH;

    final String site = "https://www.atsdr.cdc.gov/csem/nitrate-nitrite/standards.html";
    final Pattern nitritePattern = Pattern.compile("and for nitrites at (.*?) ppm");

    public Scraper() {
        try {
            URL url = new URL(site);
            URLConnection conn = url.openConnection();
            InputStream is = conn.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.trim().contains("and for nitrites at")) {
                    Matcher matcher = nitritePattern.matcher(line.trim());
                    if (matcher.find()) {
                        nitrite = Double.parseDouble(matcher.group(1));
                    }
                }
            }

        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public double getAcceptableNitrite() {
        return nitrite;
    }

    public double getAcceptablePH() {
        return 0;
    }
}
