import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.Vector;

public class GUI extends JFrame {

    private final JLabel acceptablePH;
    private final JLabel acceptableNitrite;
    final String pHLabel = "Acceptable pH: ";
    final String nitriteLabel = "Acceptable Nitrite: ";
    private final JTable table;
    private final JTextArea infoArea;
    private final JButton loadButton;
    private final JButton graphButton;

    private Object[][] data;
    final static String[] columnNames = {
            "Location", "Year", "pH", "Nitrite"
    };

    public GUI() {
        super("BARB: Nitrite & pH Analysis");

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(7,7,7,7);

        c.anchor = GridBagConstraints.BASELINE_LEADING;
        c.gridwidth = 1;
        acceptablePH = new JLabel(pHLabel + "Searching...");
        acceptableNitrite = new JLabel(nitriteLabel + "Searching...");
        add(acceptablePH, c);
        c.anchor = GridBagConstraints.BASELINE_LEADING;
        c.gridwidth = GridBagConstraints.REMAINDER;
        add(acceptableNitrite, c);

        c.gridwidth = 2;
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        table = new JTable(model) {
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component c = super.prepareRenderer(renderer, row, column);
                boolean valid = Double.parseDouble(String.valueOf(model.getValueAt(row, 3))) <= Scraper.nitrite
                        && Double.parseDouble(String.valueOf(model.getValueAt(row, 2))) >= Scraper.pHMin
                        && Double.parseDouble(String.valueOf(model.getValueAt(row, 2))) <= Scraper.pHMax;
                if (valid) {
                    c.setBackground(new Color(0x9cfcaa));
                } else {
                    c.setBackground(new Color(0xfc9c9c));
                }
                return c;
            }
        };
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, c);

        c.gridwidth = GridBagConstraints.REMAINDER;
        infoArea = new JTextArea(26, 26);
        add(infoArea, c);

        c.anchor = GridBagConstraints.BASELINE_LEADING;
        c.gridwidth = 1;
        loadButton = new JButton("Load");
        add(loadButton, c);

        c.gridwidth = GridBagConstraints.REMAINDER;
        graphButton = new JButton("Graph");
        graphButton.setEnabled(false);
        add(graphButton, c);

        // Fit content to frame
        pack();

        // Center window on screen
        setLocationRelativeTo(null);

        // Close the entire program when the window is closed
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Make window not resizeable
        setResizable(false);

        // Display the frame
        setVisible(true);
    }

    public JTextArea getInfoArea() {
        return this.infoArea;
    }

    public JButton getLoadButton() {
        return this.loadButton;
    }

    public JButton getGraphButton() {
        return this.graphButton;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        for (int i = 0; i < data[0].length; i++) {
            Vector<Object> row = new Vector<>();
            row.add(data[0][i]);
            row.add(data[1][i]);
            row.add(data[2][i]);
            row.add(data[3][i]);
            model.addRow(row);
        }
    }

    public void setAcceptablePH(String s) {
        acceptablePH.setText(pHLabel + s);
    }

    public void setAcceptableNitrite(String s) {
        acceptableNitrite.setText(nitriteLabel + s);
    }
}
