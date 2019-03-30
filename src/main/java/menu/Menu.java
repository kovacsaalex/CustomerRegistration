package menu;


import ltp.LtpAdd;
import loan.LoanAdd;
import client.ClientAdd;
import database.dataBaseSql;

import java.sql.Connection;
import java.sql.SQLException;
import lists.*;


/**
 *
 * @author ali
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        ujUgyfelAdd = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        hiteladd = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        ltpadd = new javax.swing.JMenuItem();
        ListOut = new javax.swing.JMenu();
        clientListMenu = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        LoanListMenu = new javax.swing.JMenuItem();
        jSeparator5 = new javax.swing.JPopupMenu.Separator();
        ltpListMenu = new javax.swing.JMenuItem();
        jSeparator6 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("jRadioButtonMenuItem1");

        jMenu3.setText("jMenu3");

        jMenu4.setText("File");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("Edit");
        jMenuBar2.add(jMenu5);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 24)); // NOI18N
        jLabel1.setText("Hitel - Ügyfélnyílvántartás");

        jMenu1.setText("Fájl");

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/error.png"))); // NOI18N
        jMenuItem2.setText("Kilepes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Hozzáadás");

        ujUgyfelAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user.png"))); // NOI18N
        ujUgyfelAdd.setText("Új ügyfél felvitele");
        ujUgyfelAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ujUgyfelAddActionPerformed(evt);
            }
        });
        jMenu2.add(ujUgyfelAdd);
        jMenu2.add(jSeparator1);

        hiteladd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bank.png"))); // NOI18N
        hiteladd.setText("Új Hitel felvitele");
        hiteladd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hiteladdActionPerformed(evt);
            }
        });
        jMenu2.add(hiteladd);
        jMenu2.add(jSeparator3);

        ltpadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/money.png"))); // NOI18N
        ltpadd.setText("Új LTP felvitele");
        ltpadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ltpaddActionPerformed(evt);
            }
        });
        jMenu2.add(ltpadd);

        jMenuBar1.add(jMenu2);

        ListOut.setText("Listázás");

        clientListMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-budget-48.png"))); // NOI18N
        clientListMenu.setText("Ügyfél lista");
        clientListMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientListMenuActionPerformed(evt);
            }
        });
        ListOut.add(clientListMenu);
        ListOut.add(jSeparator4);

        LoanListMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-debt-48.png"))); // NOI18N
        LoanListMenu.setText("Hitel lista");
        LoanListMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoanListMenuActionPerformed(evt);
            }
        });
        ListOut.add(LoanListMenu);
        ListOut.add(jSeparator5);

        ltpListMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-hand-receiving-money-48.png"))); // NOI18N
        ltpListMenu.setText("LTP lista");
        ltpListMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ltpListMenuActionPerformed(evt);
            }
        });
        ListOut.add(ltpListMenu);
        ListOut.add(jSeparator6);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons8-coins-48.png"))); // NOI18N
        jMenuItem1.setText("Összevont lista");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        ListOut.add(jMenuItem1);

        jMenuBar1.add(ListOut);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addComponent(jLabel1)
                .addContainerGap(185, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new dataBaseSql().getCloseConnetcion();
        System.exit(0);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void ujUgyfelAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ujUgyfelAddActionPerformed
       
        new ClientAdd().setVisible(true);
        
        
    }//GEN-LAST:event_ujUgyfelAddActionPerformed

    private void hiteladdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hiteladdActionPerformed
        new LoanAdd().setVisible(true);
      
    }//GEN-LAST:event_hiteladdActionPerformed

    private void ltpaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ltpaddActionPerformed
        new LtpAdd().setVisible(rootPaneCheckingEnabled);
       
    }//GEN-LAST:event_ltpaddActionPerformed

    private void ltpListMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ltpListMenuActionPerformed
        new LtpLists().setVisible(true);
    }//GEN-LAST:event_ltpListMenuActionPerformed

    private void clientListMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientListMenuActionPerformed
       new CLientList().setVisible(true);
    }//GEN-LAST:event_clientListMenuActionPerformed

    private void LoanListMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoanListMenuActionPerformed
        new LoanList().setVisible(true);
    }//GEN-LAST:event_LoanListMenuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new AllList().setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException{
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
   
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu ListOut;
    private javax.swing.JMenuItem LoanListMenu;
    private javax.swing.JMenuItem clientListMenu;
    private javax.swing.JMenuItem hiteladd;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JPopupMenu.Separator jSeparator5;
    private javax.swing.JPopupMenu.Separator jSeparator6;
    private javax.swing.JMenuItem ltpListMenu;
    private javax.swing.JMenuItem ltpadd;
    private javax.swing.JMenuItem ujUgyfelAdd;
    // End of variables declaration//GEN-END:variables
}
