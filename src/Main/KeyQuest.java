/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import com.sun.glass.events.KeyEvent;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSplitPane;
import javax.swing.KeyStroke;

/**
 *
 * @author toze
 */
public class KeyQuest extends javax.swing.JFrame {

    /**
     * Creates new form KeyQuest
     */
    public KeyQuest() {
        initComponents();
        initAnotherComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanelEsquerda = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanelDireita = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(900, 700));

        jPanel1.setBackground(new java.awt.Color(25, 25, 25));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(222, 222, 222)));
        jPanel1.setForeground(new java.awt.Color(246, 246, 246));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 700));

        jSplitPane1.setBackground(new java.awt.Color(1, 1, 1));
        jSplitPane1.setDividerLocation(400);
        jSplitPane1.setDividerSize(20);
        jSplitPane1.setToolTipText("");
        jSplitPane1.setMinimumSize(new java.awt.Dimension(600, 400));
        jSplitPane1.setOneTouchExpandable(true);
        jSplitPane1.setPreferredSize(new java.awt.Dimension(800, 600));

        jPanelEsquerda.setBackground(new java.awt.Color(158, 163, 199));
        jPanelEsquerda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelEsquerdaMouseClicked(evt);
            }
        });

        jLabel1.setText("dddddddddddddddd");

        jButton2.setText("jButton2");

        javax.swing.GroupLayout jPanelEsquerdaLayout = new javax.swing.GroupLayout(jPanelEsquerda);
        jPanelEsquerda.setLayout(jPanelEsquerdaLayout);
        jPanelEsquerdaLayout.setHorizontalGroup(
            jPanelEsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEsquerdaLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel1)
                .addContainerGap(222, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEsquerdaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(52, 52, 52))
        );
        jPanelEsquerdaLayout.setVerticalGroup(
            jPanelEsquerdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEsquerdaLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel1)
                .addGap(102, 102, 102)
                .addComponent(jButton2)
                .addContainerGap(346, Short.MAX_VALUE))
        );

        jSplitPane1.setLeftComponent(jPanelEsquerda);

        jPanelDireita.setBackground(new java.awt.Color(40, 40, 40));
        jPanelDireita.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanelDireitaMouseClicked(evt);
            }
        });

        jLabel2.setText("Teste dddddddddddd");

        jButton1.setText("jButton1");

        javax.swing.GroupLayout jPanelDireitaLayout = new javax.swing.GroupLayout(jPanelDireita);
        jPanelDireita.setLayout(jPanelDireitaLayout);
        jPanelDireitaLayout.setHorizontalGroup(
            jPanelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDireitaLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(205, 205, 205))
            .addGroup(jPanelDireitaLayout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelDireitaLayout.setVerticalGroup(
            jPanelDireitaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDireitaLayout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel2)
                .addGap(119, 119, 119)
                .addComponent(jButton1)
                .addContainerGap(341, Short.MAX_VALUE))
        );

        jSplitPane1.setRightComponent(jPanelDireita);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 613, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
        );

        jPanel1.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanelDireitaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelDireitaMouseClicked
        Component[] componentes = null;
        if (evt.getClickCount() == 2){
            componentes = jPanelEsquerda.getComponents();
            jPanelEsquerda.removeAll();
            //jPanelEsquerda.repaint();
            jSplitPane1.setDividerLocation(0);
        }
        if (componentes != null) {
            int i = 0;
            while (i < componentes.length) {
                jPanelEsquerda.add(componentes[i]);
                i++;
            }
        }
    }//GEN-LAST:event_jPanelDireitaMouseClicked

    private void jPanelEsquerdaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelEsquerdaMouseClicked
         Component[] componentes = null;
        if (evt.getClickCount() == 2){
            componentes = jPanelDireita.getComponents();
            jPanelDireita.removeAll();
            //jPanelDireita.repaint();
            jSplitPane1.setDividerLocation(jSplitPane1.getWidth());
        }
        if (componentes != null) {
            int i = 0;
            while (i < componentes.length) {
                jPanelDireita.add(componentes[i]);
                i++;
            }
        }
    }//GEN-LAST:event_jPanelEsquerdaMouseClicked

    public final void initAnotherComponents(){
        Menu menu = new Menu();
        JMenu menuFicheiro = new JMenu();
        JMenu jMenu2 = new JMenu();
        menuFicheiro.setText("Ficheiro");
        menuFicheiro.setMnemonic('F');
        menuFicheiro.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JMenuItem itemSair = new JMenuItem();
        itemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.ALT_MASK));
        //itemSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, Event.ALT_MASK | Event.CTRL_MASK));
        itemSair.setText("Sair");
        itemSair.setMnemonic('S');
        itemSair.setCursor(new Cursor(Cursor.HAND_CURSOR));
        itemSair.addActionListener((ActionEvent e) -> {
            sair(e);
        });
        
        menuFicheiro.add(itemSair);
        menu.add(menuFicheiro);
        jMenu2.setText("Editar");
        menu.add(jMenu2);
        this.setJMenuBar(menu);
        
        
    }
    
    public void sair(ActionEvent e) {
        this.dispose();
        System.exit(0);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(KeyQuest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KeyQuest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KeyQuest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KeyQuest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KeyQuest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelDireita;
    private javax.swing.JPanel jPanelEsquerda;
    private javax.swing.JSplitPane jSplitPane1;
    // End of variables declaration//GEN-END:variables
}