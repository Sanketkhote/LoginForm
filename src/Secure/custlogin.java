/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Secure;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author abc
 */
public class custlogin extends javax.swing.JFrame {
    /**
     * Creates new form custlogin
     */
    public custlogin() {
        initComponents();
        fetch();
        cust_name.setText(pas);
    } 
    
    public custlogin(String para,int id)
    {
           initComponents();
           fetch();
           cust_name.setText(para);
           we(para);
           we1(id);
    }
    public static int id1;
    public static String pas;
    public static String name1,exp;
    public static int pri;
    public void we(String par){
            pas=par;
    }
    public void we1(int id12)
    {
            id1=id12;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cust_name = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        add = new javax.swing.JButton();
        quan = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        log = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 180));
        setMinimumSize(new java.awt.Dimension(669, 405));
        setPreferredSize(new java.awt.Dimension(680, 430));
        getContentPane().setLayout(null);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product Name", "Price", "Quantity", "Expiry"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(21, 121, 452, 220);

        jLabel1.setFont(new java.awt.Font("Sitka Small", 2, 18)); // NOI18N
        jLabel1.setText("Customer Login Panel");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(21, 11, 421, 32);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Welcome,");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(61, 49, 61, 24);

        cust_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(cust_name);
        cust_name.setBounds(132, 49, 127, 24);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Enter Quantity :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(491, 124, 100, 17);

        add.setText("Add To Cart");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        getContentPane().add(add);
        add.setBounds(561, 162, 98, 23);

        quan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        quan.setText("0");
        getContentPane().add(quan);
        quan.setBounds(607, 121, 52, 23);

        jButton2.setText("Go To Cart");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(491, 318, 168, 23);

        log.setText("Log Out");
        log.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logActionPerformed(evt);
            }
        });
        getContentPane().add(log);
        log.setBounds(491, 352, 168, 23);

        jButton1.setText("Update Profile");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(491, 284, 168, 23);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Secure/2.jpg"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 670, 410);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new cart(id1).setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int selectedRow=jTable1.getSelectedRow();
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        name1=(model.getValueAt(selectedRow, 0).toString());
        pri=Integer.parseInt(model.getValueAt(selectedRow, 1).toString());
        exp=(model.getValueAt(selectedRow, 3).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        // TODO add your handling code here:
        int flag=0,flag1=0,temp=0;
        int qu;
        qu=Integer.parseInt(quan.getText());
        Connection conn;
        if(qu<=0)
        {
            JOptionPane.showMessageDialog(null, "Please enter a valid value");
        }
        else{
        try{
        conn = Login.guicon();
        ResultSet rs;
        PreparedStatement stmt;
        String query="Select name,price,quantity from cart";
        stmt=conn.prepareStatement(query);
        rs=stmt.executeQuery();
        while(rs.next())
        {
           if(name1.equals(rs.getString("name")))
           {
               flag=1;
               temp=rs.getInt("quantity");
               System.out.println(temp);
           }
        }
        }catch (SQLException ex) {
            Logger.getLogger(custlogin.class.getName()).log(Level.SEVERE, null, ex);
           
        }
        
        if(flag==1)
        {
            try{
            conn = Login.guicon();
            PreparedStatement stmt;
            String query="Update cart set quantity=? where name=?";
            stmt=conn.prepareStatement(query);
            temp=temp+qu;
            stmt.setInt(1, temp);
            stmt.setString(2, name1);
            stmt.executeUpdate();
            flag1=1;
            }catch (SQLException ex) {
            Logger.getLogger(custlogin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
        try {
             int temp1=0;
             ResultSet rs;
             conn = Login.guicon();
             PreparedStatement stmt;
             PreparedStatement stmt1;
             String q="select prid from product where p_name=?";
             stmt1=conn.prepareStatement(q);
             stmt1.setString(1, name1);
             rs=stmt1.executeQuery();
             while(rs.next())
                 temp1=rs.getInt("prid");
             
             String query="Insert into cart(name,prid,price,quantity) values(?,?,?,?)";
             stmt=conn.prepareStatement(query);
             stmt.setString(1, name1);
             stmt.setInt(3, pri);
             stmt.setInt(2,temp1);
             stmt.setInt(4, qu);
             
             stmt.executeUpdate();
             flag1=1;
        }catch (SQLException ex) {
            Logger.getLogger(custlogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        if(flag1==1)
        {
            try{
                
            ResultSet rs;
            conn = Login.guicon();
            PreparedStatement stmt;
            String query="select quantity from product where p_name=?";
            stmt=conn.prepareStatement(query);
            stmt.setString(1, name1);
            rs=stmt.executeQuery();
            while(rs.next())
            {
                temp=rs.getInt("quantity");
            }
            temp=temp-qu;
            query="update product set quantity=? where p_name=?";
            stmt=conn.prepareStatement(query);
            stmt.setInt(1, temp);
            stmt.setString(2, name1);
            stmt.executeUpdate();
            fetch();
            JOptionPane.showMessageDialog(null, "Product Added Successfully to the Cart");
        }catch (SQLException ex) {
            Logger.getLogger(custlogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        }
    }//GEN-LAST:event_addActionPerformed

    private void logActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logActionPerformed
        // TODO add your handling code here:
        try { 
            Connection conn;
            conn = Login.guicon();
            PreparedStatement stmt;
            String query="truncate table cart";
            stmt=conn.prepareStatement(query);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Logged out Successfully");
            this.setVisible(false);
            new Login().setVisible(true);
        }catch (SQLException ex) {
            Logger.getLogger(custlogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
        try {
            new updateprofile(id1).setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(custlogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
     public void fetch()
        {
         try{
         ResultSet rs=null;
         Connection conn=null;
         conn=Login.guicon();
         String q="select p_name,price,quantity,man_date,exp_date from product";
         PreparedStatement stmt=null;
         stmt=conn.prepareStatement(q);
         rs=stmt.executeQuery();
         jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
         catch (SQLException ex) {
         Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
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
            java.util.logging.Logger.getLogger(custlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(custlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(custlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(custlogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new custlogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JLabel cust_name;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton log;
    private javax.swing.JTextField quan;
    // End of variables declaration//GEN-END:variables
}