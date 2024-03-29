import javax.swing.*;

public class CustomTable extends JTable {
    public static final int WIDTH_COLUMN_SLANG_WORD = 120;
    public static final int MAX_WIDTH_COLUMN_SLANG_WORD = 180;
    public CustomTable(CustomTableModel cTableModel) {
        setModel(cTableModel);
        setEnabled(false);
        setFont(App.SMALL_FONT);

        getTableHeader().setFont(App.SMALL_FONT);
        getColumnModel().getColumn(0).setPreferredWidth(WIDTH_COLUMN_SLANG_WORD);
        getColumnModel().getColumn(0).setMaxWidth(MAX_WIDTH_COLUMN_SLANG_WORD);
        getColumnModel().getColumn(1).setCellRenderer(new MyCellRenderer());
    }
}
