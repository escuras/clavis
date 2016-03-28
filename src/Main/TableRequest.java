/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Clavis.Request;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author toze
 */
public class TableRequest {
    
    private final javax.swing.JTable tabela;
    private final Langs.Locale lingua;
    public TableRequest(RequestList requisicao, Langs.Locale lingua){
  
        this.lingua = lingua;
        tabela = new javax.swing.JTable(); 
        tabela.setModel(new javax.swing.table.DefaultTableModel(new Object [][] {},new String [] {lingua.translate("Nome"), lingua.translate("Recurso"), lingua.translate("Data"), lingua.translate("Horário")}));
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        for (Iterator<Request> it = requisicao.getRequests().iterator(); it.hasNext();) {
            Clavis.Request req = it.next(); 
            Object [] ob = {req.getPerson().getName(),req.getMaterial().getDescription(),req.getDate().toString(),req.getTimeBegin().toString(0)+" - "+req.getTimeEnd().toString(0)};
            modelo.addRow(ob);
        }
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer) tabela.getTableHeader().getDefaultRenderer();
        renderer.setHorizontalTextPosition(SwingConstants.CENTER);
        renderer.setVerticalTextPosition(SwingConstants.CENTER);
        renderer.setPreferredSize(new Dimension(40,40));
        tabela.setRowHeight(30);
        tabela.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 45));
        tabela.setBackground(Color.WHITE);
        tabela.getColumnModel().getColumn(0).setPreferredWidth(250);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(110);
        DefaultTableCellRenderer rend= ((DefaultTableCellRenderer)tabela.getTableHeader().getDefaultRenderer());
        rend.setHorizontalAlignment(javax.swing.JLabel.CENTER);
        
        JTableHeader th = tabela.getTableHeader();
        th.setFont(new Font("Cantarell", Font.BOLD,13));
        tabela.setSelectionBackground(Color.black);
        tabela.setToolTipText(lingua.translate("Lista_de_requisições"));
        
        
        // Alinhamento do texto na tabela
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment( javax.swing.JLabel.CENTER );
        tabela.getColumnModel().getColumn(2).setCellRenderer(center);
        tabela.getColumnModel().getColumn(3).setCellRenderer(center);
        center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment( javax.swing.JLabel.RIGHT );
        tabela.getColumnModel().getColumn(1).setCellRenderer(center);
        
        /* Método para sort
        List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabela.getModel());
        tabela.setRowSorter(sorter);
        sorter.setSortKeys(sortKeys);
        */
    }
    
    public javax.swing.JTable getTable(){
        return this.tabela;
    }
    
    
}
