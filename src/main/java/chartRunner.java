import java.io.File;
import java.io.IOException;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

public class chartRunner extends ApplicationFrame {

    JFreeChart barChart;
    DefaultCategoryDataset data;
    File BarChart;

    public chartRunner(Object[][] dataIn) throws IOException {
        super("Application");
        data = getData(dataIn);
        createChart();
    }

    public void createChart() throws IOException {
        barChart = ChartFactory.createBarChart("pH vs Nitrite", "pH / Nitrite", "Value", data, PlotOrientation.VERTICAL,
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
            info.addValue((double) dat[2][i], "pH", dat[0][i] + " " + dat[1][i]);
            info.addValue((double) dat[3][i], "Nitrite", dat[0][i] + " " + dat[1][i]);
        }
        return info;
    }
}
