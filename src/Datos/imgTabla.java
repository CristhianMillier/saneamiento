package Datos;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class imgTabla extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof JLabel) {
            JLabel lbl = (JLabel) value;
            return lbl;
        }

        if (value instanceof JButton) {
            JButton button = (JButton) value;
            button.setBackground(new java.awt.Color(255, 204, 204));
            button.setFont(new java.awt.Font("Tahoma", 0, 12));
            button.setForeground(new java.awt.Color(0, 0, 0));
            button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

            return button;
        }

        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    }
}
