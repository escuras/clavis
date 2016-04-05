/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.InputStream;
import java.util.EventObject;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
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
    private static final Color DEFAULT_BACKGROUND_COLOR = Color.orange;
    private static final Color DEFAULT_FOREGROUND_COLOR = Color.black;
    private static final Color DEFAULT_SELECT_COLOR = Color.DARK_GRAY;
    private final javax.swing.JTable tabela;
    private final Langs.Locale lingua;
    private int selecionado;
    private RequestList lista;
    private Color backColor;
    private Color foreColor;
    private Color selectColor;

    public TableRequest(RequestList requisicao, Langs.Locale lingua) {
        this.lingua = lingua;
        this.selecionado = 0;
        this.lista = requisicao;
        backColor = TableRequest.DEFAULT_BACKGROUND_COLOR;
        foreColor = TableRequest.DEFAULT_FOREGROUND_COLOR;
        selectColor = TableRequest.DEFAULT_SELECT_COLOR;
        tabela = new javax.swing.JTable();
        tabela.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new Object[]{lingua.translate("Nome"), lingua.translate("Recurso"), lingua.translate("Horário"), lingua.translate("Detalhes")}));
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        if (modelo.getColumnCount() > 0) {
            for (Clavis.Request req : requisicao.getRequests()) {
                Object[] ob = {req.getPerson().getName(), req.getMaterial().getDescription(), req.getTimeBegin().toString(0) + " - " + req.getTimeEnd().toString(0)};
                modelo.addRow(ob);
            }
        } else {
            tabela.setModel(new javax.swing.table.DefaultTableModel(new Object[][]{}, new Object[]{lingua.translate("Situação")}));
            modelo = (DefaultTableModel) tabela.getModel();
            Object[] ob = {lingua.translate("Houve um problema na ligação à base de dados!")};
            modelo.addRow(ob);
        }
        tabela.getColumn(lingua.translate("Detalhes")).setCellRenderer(new ButtonRenderer(lingua));
        tabela.getColumn(lingua.translate("Detalhes")).setCellEditor(new ButtonEditor(new JCheckBox(), tabela, lingua));
        tabela.getColumn(lingua.translate("Detalhes")).setMaxWidth(100);
        tabela.getColumn(lingua.translate("Detalhes")).setMinWidth(70);
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tabela.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalTextPosition(SwingConstants.CENTER);
        renderer.setVerticalTextPosition(SwingConstants.CENTER);
        renderer.setPreferredSize(new Dimension(40, 40));
        tabela.setRowHeight(45);
        
        tabela.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 45));
        tabela.setFocusable(false);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(250);
        tabela.getColumnModel().getColumn(1).setMinWidth(85);
        tabela.getColumnModel().getColumn(2).setMinWidth(115);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(70);
        DefaultTableCellRenderer rend = ((DefaultTableCellRenderer) tabela.getTableHeader().getDefaultRenderer());
        rend.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        JTableHeader th = tabela.getTableHeader();
        th.setFont(new Font("Cantarell", Font.BOLD, 13));
        
        // remoção do contorno da célula
        Border border = BorderFactory.createEmptyBorder(0,5,0,5);
        UIManager.put("Table.focusCellHighlightBorder", border);
        
        tabela.setBackground(TableRequest.DEFAULT_BACKGROUND_COLOR);
        tabela.setForeground(TableRequest.DEFAULT_FOREGROUND_COLOR);
        tabela.setSelectionBackground(TableRequest.DEFAULT_SELECT_COLOR);
        tabela.setToolTipText(lingua.translate("Lista_de_requisições"));

        // Alinhamento do texto na tabela
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        tabela.getColumnModel().getColumn(2).setCellRenderer(center);
        center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(javax.swing.JLabel.RIGHT);
        tabela.getColumnModel().getColumn(1).setCellRenderer(center);
        tabela.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tabela.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            this.selecionado = tabela.getSelectedRow();
            if (!e.getValueIsAdjusting()) {
                ButtonEditor editor = (ButtonEditor) tabela.getColumn(lingua.translate("Detalhes")).getCellEditor();
                editor.setActive(false);
                editor.setSelect(-1);
                editor.button.doClick();
            }
        });
        tabela.setShowGrid(false);
        tabela.setShowHorizontalLines(true);
        tabela.setFocusable(true);
        tabela.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int aponta = tabela.columnAtPoint(e.getPoint());
                ButtonEditor editor = (ButtonEditor) tabela.getColumn(lingua.translate("Detalhes")).getCellEditor();
                if (!tabela.getColumnName(aponta).equals(lingua.translate("Detalhes"))) {
                    editor.setActive(false);
                    editor.setSelect(-1);
                    editor.button.doClick();
                }
            }
        });
        
        tabela.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
        tabela.getActionMap().put("Enter", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (tabela.getSelectedRowCount() == 0)tabela.setRowSelectionInterval(0, 0);
                
            }
        });
        tabela.getActionMap().put("cancel", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ButtonEditor editor = (ButtonEditor) tabela.getColumn(lingua.translate("Detalhes")).getCellEditor();
                editor.button.doClick();
                tabela.clearSelection();
            }
        });
        Object [] b  = tabela.getActionMap().allKeys();
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i].toString());
        }
        /*tabela.addKeyListener(new KeyAdapter(){
            @Override
            public void keyTyped(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (tabela.getSelectedRow() <= tabela.getRowCount()) {
                        tabela.setRowSelectionInterval(selecionado+1, selecionado+1);
                        ButtonEditor editor = (ButtonEditor) tabela.getColumn(lingua.translate("Detalhes")).getCellEditor();
                        editor.setActive(false);
                        editor.setSelect(-1);
                        editor.button.doClick();
              */
        
        EditorCell cel = new EditorCell();
        for (int i = 0; i < tabela.getColumnCount() - 1; i++) {
            tabela.getColumnModel().getColumn(i).setCellEditor(cel);
             tabela.getColumnModel().getColumn(i).sizeWidthToFit();
        }

        /* Método para sort
         List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
         sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
         TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabela.getModel());
         tabela.setRowSorter(sorter);
         sorter.setSortKeys(sortKeys);
         */
    }

    public void addButtonListener(javax.swing.JSplitPane spanel) {
        ButtonEditor editor = (ButtonEditor) tabela.getColumn(lingua.translate("Detalhes")).getCellEditor();
        PanelDetails panel = new PanelDetails(lingua, Color.WHITE);
        panel.setInterval(2);
        panel.create();
        spanel.setLeftComponent(panel.alternativePanel());
        spanel.setDividerLocation(0.5); 
        editor.button.addActionListener((ActionEvent e) -> {
            tabela.setRowSelectionAllowed(true);
            editor.setActive(true);
            if (editor.getSelect() == this.selecionado) {
                editor.setActive(false);
            }
            if (!editor.isActive()) {
                editor.setSelect(-2);
                selecionado = -1;
                tabela.clearSelection();
                editor.stopCellEditing();
            } else {
                editor.setSelect(selecionado);
                editor.stopCellEditing();
            }
            System.out.println("digo: " + selecionado);
            System.out.println(editor.isActive());
            tabela.getSelectionModel().setSelectionInterval(selecionado, selecionado);
            String titulo = "Informações";
            String[] titulos = {"Utilizador", "Recurso", "Data"};
            int select = editor.getSelect();
            System.out.println("select:" + select);
            if (select >= 0) {
                Object[] baux = lista.getRequests().toArray();
                Clavis.Request req = (Clavis.Request) baux[select];
                String[] results = {req.getPerson().getName(), req.getMaterial().getTypeOfMaterialName() + " " + req.getMaterial().getDescription(), req.getDate().toStringWithMonthWord()};
                PanelDetails panel2 = new PanelDetails(Color.WHITE, titulo, titulos, results, lingua);
                panel2.setInterval(2);
                panel2.create();
                spanel.setLeftComponent(panel2);
                spanel.setDividerLocation(0.5);
            } else {
                PanelDetails panel2 = new PanelDetails(lingua, Color.WHITE);
                panel.setInterval(2);
                panel.create();
                spanel.setLeftComponent(panel.alternativePanel());
                spanel.setDividerLocation(0.5); 
            }
        });
    }

    public javax.swing.JTable getTable() {
        return this.tabela;

    }

    public Clavis.Request getSelectedRequest() {
        return this.lista.getSelectedRequest(selecionado);
    }

    /**
     * @return the selecionado
     */
    public int getSelectedRows() {
        return selecionado;
    }

    /**
     * @return the lista
     */
    public RequestList getList() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setList(RequestList lista) {
        this.lista = lista;

    }

    /**
     * @return the color
     */
    public Color getBackGroundColor() {
        return backColor;
    }

    /**
     * @param color the color to set
     */
    public void setBackGroundColor(Color color) {
        this.backColor = color;
        tabela.repaint();
    }

    /**
     * @return the forecolor
     */
    public Color getForegroundcolor() {
        return foreColor;
    }

    /**
     * @param forecolor the forecolor to set
     */
    public void setForegroundcolor(Color forecolor) {
        this.foreColor = forecolor;
        tabela.repaint();
    }

    /**
     * @return the selectColor
     */
    public Color getSelectColor() {
        return selectColor;
    }

    /**
     * @param selectColor the selectColor to set
     */
    public void setSelectColor(Color selectColor) {
        this.selectColor = selectColor;
        tabela.repaint();
    }

}

class ButtonRenderer extends JButton implements TableCellRenderer {

    private static final long serialVersionUID = 1L;
    private final Langs.Locale lingua;

    public ButtonRenderer(Langs.Locale lingua) {
        this.lingua = lingua;

    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        InputStream st;
        if (isSelected) {
            this.setOpaque(true);
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
            st = this.getClass().getResourceAsStream("Images/search1.png");
            if (st != null) {
                try {
                    Image im = ImageIO.read(st);
                    ImageIcon icon = new ImageIcon(im);
                    this.setIcon(icon);
                } catch (IOException ex) {
                }
            } else {
                this.setFont(new Font("Cantarell", Font.BOLD, 9));
                this.setText(lingua.translate("Ver"));
            }
        } else {
            this.setOpaque(false);
            setForeground(table.getForeground());
            setBackground(Color.DARK_GRAY);
            st = this.getClass().getResourceAsStream("Images/search2.png");
            if (st != null) {
                try {
                    Image im = ImageIO.read(st);
                    ImageIcon icon = new ImageIcon(im);
                    this.setIcon(icon);
                } catch (IOException ex) {
                }
            } else {
                this.setFont(new Font("Cantarell", Font.BOLD, 9));
                this.setText(lingua.translate("Ver"));
            }
        }
        return this;
    }
}

class ButtonEditor extends DefaultCellEditor {

    private static final long serialVersionUID = 1L;
    protected JButton button;
    private int selecionado;
    private boolean active;
    private Langs.Locale lingua;

    public ButtonEditor(JCheckBox checkBox, JTable table, Langs.Locale lingua) {
        super(checkBox);
        this.lingua = lingua;
        button = new JButton();
        button.setPreferredSize(new Dimension(30, 40));
        button.setMaximumSize(new Dimension(30, 40));
        button.setFocusPainted(false);
        active = false;
        selecionado = -1;
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        if (isSelected) {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        } else {
            button.setForeground(table.getSelectionForeground());
            button.setBackground(table.getSelectionBackground());
        }
        button.setOpaque(true);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        InputStream st = this.getClass().getResourceAsStream("Images/search2.png");
        if (st != null) {
            try {
                Image im = ImageIO.read(st);
                ImageIcon icon = new ImageIcon(im);
                button.setIcon(icon);
            } catch (IOException ex) {
            }
        } else {
            button.setText(lingua.translate("Ver"));
        }
        return button;
    }

    public int getSelect() {
        return selecionado;
    }

    public void setSelect(int select) {
        this.selecionado = select;
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return the lingua
     */
    public Langs.Locale getLanguage() {
        return lingua;
    }

    /**
     * @param lingua the lingua to set
     */
    public void setLanguage(Langs.Locale lingua) {
        this.lingua = lingua;
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
            ((JTextField) component).setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
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
