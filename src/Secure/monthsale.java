/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secure;

import static Secure.custlogin.name1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author root
 */
public class monthsale extends javax.swing.JFrame {

    /**
     * Creates new form monthsale
     */
    public monthsale() {
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

        monthis = new com.toedter.calendar.JMonthChooser();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        totsal = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 170));
        setMinimumSize(new java.awt.Dimension(606, 433));
        getContentPane().setLayout(null);
        getContentPane().add(monthis);
        monthis.setBounds(191, 44, 98, 24);

        jLabel1.setFont(new java.awt.Font("Meiryo UI", 0, 13)); // NOI18N
        jLabel1.setText("Select Month :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 40, 100, 30);

        jButton1.setText("Check");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(361, 44, 86, 23);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "First name", "Last name", "Age", "Address", "Product Name", "Quantity", "Total price"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 107, 576, 201);

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(516, 44, 70, 23);

        jLabel2.setFont(new java.awt.Font("Meiryo UI", 1, 13)); // NOI18N
        jLabel2.setText("Total Monthly Sale :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(292, 341, 143, 27);

        totsal.setFont(new java.awt.Font("Meiryo UI", 1, 13)); // NOI18N
        getContentPane().add(totsal);
        totsal.setBounds(440, 340, 60, 27);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Secure/2.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 610, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    int month;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        month=monthis.getMonth();
        month++;
        fetch();
        
    }
        public void fetch()
        {
         try{
         ResultSet rs=null;
         Connection conn=null;
         conn=Login.guicon();
         String q="select fname,lname,age,address,p_name,orders.quantity,orders.total_price from person,orders,product where person.pid=orders.pid and orders.prid=product.prid and month(sale_date)=?";
         PreparedStatement stmt=null;
         stmt=conn.prepareStatement(q);
         stmt.setInt(1,month);
         rs=stmt.executeQuery();
         jTable1.setModel(DbUtils.resultSetToTableModel(rs));
         
        }
         catch (SQLException ex) {
         Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
         try{
            Connection conn;
            ResultSet rs;
            conn = Login.guicon();
            PreparedStatement stmt;
            String query="select sum(total_price) from orders where month(sale_date)=?";
            stmt=conn.prepareStatement(query);
            stmt.setInt(1, month);
            rs=stmt.executeQuery();
            while(rs.next())
                totsal.setText(Integer.toString(rs.getInt("sum(total_price)")));
            
        }catch (SQLException ex) {
            Logger.getLogger(custlogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }//GEN-LAST:event_jButton1ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
        new adminlogin().setVisible(true);
    }//GEN-LAST:event_backActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(monthsale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(monthsale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(monthsale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(monthsale.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new monthsale().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private com.toedter.calendar.JMonthChooser monthis;
    private javax.swing.JLabel totsal;
    // End of variables declaration//GEN-END:variables
}
