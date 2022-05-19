import org.jfree.chart.*;
import org.jfree.ui.*;

public class chartRunner extends ApplicationFrame {

    JFreeChart lineChart;

    public chartRunner() {
        super("Application");
        createChart();
    }

    public void createChart() {
        lineChart = ChartFactory.createLineChart("pH vs Nitrate", "pH", "Nitrate", getData());
    }

    public DataSet getData() {

    }

}
