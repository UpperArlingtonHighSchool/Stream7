import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.io.FileNotFoundException;

public class GUI extends JFrame {

    private JTable table;

    private Object[][] data;
    final static String[] columnNames = {
            "Location", "Year", "pH", "Nitrite"
    };

    public GUI() {
        super("BARB: Nitrite & pH Analysis");

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(7,7,7,7);

        c.gridwidth = GridBagConstraints.REMAINDER;
        table = new JTable(null, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, c);

        c.anchor = GridBagConstraints.BASELINE_LEADING;
        c.gridwidth = 1;
        JButton analyzeButton = new JButton("Analyze");
        add(analyzeButton, c);

        c.gridwidth = GridBagConstraints.REMAINDER;
        JButton saveButton = new JButton("Save");
        add(saveButton, c);

        // Fit content to frame
        pack();

        // Center window on screen
        setLocationRelativeTo(null);

        // Close the entire program when the window is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Display the frame
        setVisible(true);
    }

    public Object[][] setData(Object[][] data) {
        this.data = data;
        return this.data;
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (Object[] datum : this.data) {
            model.addRow(datum);
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        DataSet pH_vs_nitrite = new DataSet("src/main/resources/data/Nitrite_vs_pH.txt");
        GUI gui = new GUI();
        gui.setData(pH_vs_nitrite.getMatrix());
        gui.populateTable();
    }
}
