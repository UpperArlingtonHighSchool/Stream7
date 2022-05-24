import java.io.File;

import org.jfree.chart.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

public class chartRunner extends ApplicationFrame {

    JFreeChart barChart;
    DefaultCategoryDataset data;
    File BarChart;

    public chartRunner(Object[][] dataIn) {
        super("Application");
        data = getData(dataIn);
        createChart();
    }

    public void createChart() {
        barChart = ChartFactory.createBarChart("pH vs Nitrite", "pH / Nitrie", "Value", data, PlotOrientation.VERTICAL,
                true, true, false);
        int width = 640;
        int height = 480;
        BarChart = new File("BarChart.jpeg");
        ChartUtilities.saveChartAsJPEG(BarChart, barChart, width, height);
    }

    public File getChart() {
        return BarChart;
    }

    public DefaultCategoryDataset getData(Object[][] dat) {
        DefaultCategoryDataset info = new DefaultCategoryDataset();
        for (int i = 0; i < dat.length; i++) {
            info.addValue((int) dat[2][i], "pH", (String) dat[0][i] + " " + (String) dat[1][i]);
            info.addValue((int) dat[3][i], "Nitrite", (String) dat[0][i] + " " + (String) dat[1][i]);
        }
        return info;
    }

}
