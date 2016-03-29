/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Clavis.Request;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.EventObject;
import java.util.Iterator;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author toze
 */
public class TableRequest {

    private final javax.swing.JTable tabela;
    private final Langs.Locale lingua;
    private int[] selecionado;

    public TableRequest(RequestList requisicao, Langs.Locale lingua) {
        this.lingua = lingua;
        this.selecionado = new int[]{0};
        tabela = new javax.swing.JTable();
        tabela.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new Object[]{lingua.translate("Nome"), lingua.translate("Recurso"), lingua.translate("Data"), lingua.translate("Horário"), lingua.translate("Detalhes")}));
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        for (Iterator<Request> it = requisicao.getRequests().iterator(); it.hasNext();) {
            Clavis.Request req = it.next();
            Object[] ob = {req.getPerson().getName(), req.getMaterial().getDescription(), req.getDate().toString(), req.getTimeBegin().toString(0) + " - " + req.getTimeEnd().toString(0)};
            modelo.addRow(ob);
        }

        tabela.getColumn(lingua.translate("Detalhes")).setCellRenderer(new ButtonRenderer());
        tabela.getColumn(lingua.translate("Detalhes")).setCellEditor(new ButtonEditor(new JCheckBox(), tabela));
        tabela.getColumn(lingua.translate("Detalhes")).setMaxWidth(130);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tabela.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalTextPosition(SwingConstants.CENTER);
        renderer.setVerticalTextPosition(SwingConstants.CENTER);
        renderer.setPreferredSize(new Dimension(40, 40));
        tabela.setRowHeight(30);
        tabela.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 45));
        tabela.setBackground(Color.WHITE);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(250);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(110);
        DefaultTableCellRenderer rend = ((DefaultTableCellRenderer) tabela.getTableHeader().getDefaultRenderer());
        rend.setHorizontalAlignment(javax.swing.JLabel.CENTER);

        JTableHeader th = tabela.getTableHeader();
        th.setFont(new Font("Cantarell", Font.BOLD, 13));
        tabela.setSelectionBackground(Color.black);
        tabela.setBackground(Color.DARK_GRAY);
        tabela.setForeground(Color.WHITE);
        tabela.setToolTipText(lingua.translate("Lista_de_requisições"));

        // Alinhamento do texto na tabela
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        tabela.getColumnModel().getColumn(2).setCellRenderer(center);
        tabela.getColumnModel().getColumn(3).setCellRenderer(center);
        center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        tabela.getColumnModel().getColumn(1).setCellRenderer(center);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tabela.setRowSelectionAllowed(true);
        tabela.setRowSelectionInterval(0, 0);
        tabela.setShowGrid(true);
        tabela.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            this.selecionado = tabela.getSelectedRows();
        });
        EditorCell cel = new EditorCell();
        for (int i=0; i< tabela.getColumnCount()-1; i++) {
            tabela.getColumnModel().getColumn(i).setCellEditor(cel);       
        }
        
        /* Método para sort
         List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
         sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
         TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabela.getModel());
         tabela.setRowSorter(sorter);
         sorter.setSortKeys(sortKeys);
         */
    
    }
    
    public javax.swing.JTable getTable() {
        return this.tabela;

    }

    /**
     * @return the selecionado
     */
    public int[] getSelectedRows() {
        return selecionado;
    }

}

class ButtonRenderer extends JToggleButton implements TableCellRenderer {

    public ButtonRenderer() {
        setOpaque(false);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        InputStream st = this.getClass().getResourceAsStream("Images/search2.png");
        if (st != null) {
            try {
                Image im = ImageIO.read(st);
                ImageIcon icon = new ImageIcon(im);
                this.setIcon(icon);
            } catch (IOException ex) {
            }
        } else {
            this.setFont(new Font("Cantarell", Font.BOLD, 9));
            this.setText("Ver");
        }
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
            this.setOpaque(true);
        } else {
            setForeground(table.getForeground());
            setBackground(Color.BLACK);
            this.setOpaque(false);
        }
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {

    protected JButton button;
    private int selecionado;

    public ButtonEditor(JCheckBox checkBox, JTable table) {
        super(checkBox);
        button = new JButton();
        button.setPreferredSize(new Dimension(30, 40));
        button.setMaximumSize(new Dimension(30, 40));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setOpaque(true);
        button.addActionListener((ActionEvent e) -> {
            table.setRowSelectionAllowed(true);
            int tamanho = table.getSelectedRowCount() - 1;
            int escolhido = table.getSelectedRow();
            if (escolhido < selecionado) {
                selecionado = escolhido;
            } else {
                selecionado = escolhido + tamanho;
            }
            table.getSelectionModel().setSelectionInterval(selecionado, selecionado);
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getForeground());
            button.setBackground(Color.BLACK);
        }
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        InputStream st = this.getClass().getResourceAsStream("Images/search1.png");
        if (st != null) {
            try {
                Image im = ImageIO.read(st);
                ImageIcon icon = new ImageIcon(im);
                button.setIcon(icon);
            } catch (IOException ex) {
            }
        } else {
            button.setText("Ver");
        }
        return button;
    }

    public int getSelect() {
        return selecionado;
    }
}

class EditorCell implements TableCellEditor {

    JComponent component = new JTextField();

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            ((JTextField) component).selectAll();
            ((JTextField) component).setText((String) value);
            ((JTextField) component).setHorizontalAlignment(SwingConstants.CENTER);
            ((JTextField) component).setBackground(table.getBackground());
        }
        return component;
    }

    @Override
    public Object getCellEditorValue() {
        return ((JTextField) component).getText();
    }

    @Override
    public boolean isCellEditable(EventObject anEvent) {
        return false;
    }

    @Override
    public boolean shouldSelectCell(EventObject anEvent) {
        return true;
    }

    @Override
    public boolean stopCellEditing() {
        return true;
    }

    @Override
    public void cancelCellEditing() {
    }

    @Override
    public void addCellEditorListener(CellEditorListener l) {
    }

    @Override
    public void removeCellEditorListener(CellEditorListener l) {
    }

}