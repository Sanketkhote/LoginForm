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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author root
 */
public class updateprofile extends javax.swing.JFrame {

    /**
     * Creates new form updateprofile
     */
    int id;
    public updateprofile() throws SQLException {
        initComponents();
        dob.setDateFormatString("yyyy-MM-dd");
        fetch();
        
    }
    
    public updateprofile(int id1) throws SQLException{
        initComponents();
        dob.setDateFormatString("yyyy-MM-dd");
        id=id1;
        fetch();
    }
String s1,s2;
    void fetch() throws SQLException
    {
        String str=null;
        Date date1=null;
            
        try{
         ResultSet rs=null;
         Connection conn=null;
         conn=Login.guicon();
         String q="select fname,lname,email,DOB,address,username,password from person where pid=?";
         PreparedStatement stmt=null;
         stmt=conn.prepareStatement(q);
         stmt.setInt(1,id);
         rs=stmt.executeQuery();
         while(rs.next())
         {
            fname.setText(rs.getString("fname"));
            lname.setText(rs.getString("lname"));
            email.setText(rs.getString("email"));
            address.setText(rs.getString("address"));
            password.setText(rs.getString("password"));
            username.setText(rs.getString("username"));
            str=rs.getString("DOB");
             try {
                 date1=new SimpleDateFormat("yyyy-MM-dd").parse(str);
             } catch (ParseException ex) {
                 Logger.getLogger(updateprofile.class.getName()).log(Level.SEVERE, null, ex);
             }
            dob.setDate(date1);
         }
         q="select contact from p_contact where pid=?";
         stmt=conn.prepareStatement(q);
         stmt.setInt(1,id);
         rs=stmt.executeQuery();
         rs.first();
         mob1.setText(rs.getString("contact"));
         s1=rs.getString("contact");
         rs.last();
         mob2.setText(rs.getString("contact")); 
         s2=rs.getString("contact");
        }
         catch (SQLException ex) {
         Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fname = new javax.swing.JTextField();
        lname = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        dob = new com.toedter.calendar.JDateChooser();
        address = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        mob1 = new javax.swing.JTextField();
        mob2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 130));
        setMinimumSize(new java.awt.Dimension(535, 496));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel1.setText("First Name :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(64, 43, 118, 18);

        jLabel2.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel2.setText("Last Name :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(64, 81, 117, 18);

        jLabel3.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel3.setText("Email ID :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(64, 119, 118, 18);

        jLabel4.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel4.setText("Date of Birth :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(64, 160, 118, 18);

        jLabel5.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel5.setText("Address :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(64, 196, 118, 18);

        jLabel6.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel6.setText("Username :");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(64, 235, 118, 18);

        jLabel7.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel7.setText("Password :");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(64, 274, 118, 18);

        fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fnameActionPerformed(evt);
            }
        });
        getContentPane().add(fname);
        fname.setBounds(282, 41, 142, 20);

        lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lnameActionPerformed(evt);
            }
        });
        getContentPane().add(lname);
        lname.setBounds(282, 79, 142, 20);
        getContentPane().add(email);
        email.setBounds(282, 120, 142, 20);
        getContentPane().add(dob);
        dob.setBounds(282, 158, 142, 20);
        getContentPane().add(address);
        address.setBounds(282, 197, 142, 20);
        getContentPane().add(username);
        username.setBounds(282, 236, 142, 20);
        getContentPane().add(password);
        password.setBounds(282, 275, 142, 20);

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(282, 420, 79, 23);

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(112, 420, 85, 23);

        jLabel8.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel8.setText("Mobile 1 :");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(64, 313, 118, 18);

        jLabel9.setFont(new java.awt.Font("Meiryo UI", 1, 14)); // NOI18N
        jLabel9.setText("Mobile  2 :");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(64, 352, 118, 18);
        getContentPane().add(mob1);
        mob1.setBounds(282, 314, 142, 20);
        getContentPane().add(mob2);
        mob2.setBounds(282, 350, 142, 20);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Secure/2.jpg"))); // NOI18N
        getContentPane().add(jLabel10);
        jLabel10.setBounds(0, 0, 520, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fnameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try{
         ResultSet rs=null;
         Connection conn=null;
         conn=Login.guicon();
         String q="update person set fname=?,lname=?,email=?,DOB=?,address=?,username=?,password=? where pid=?";
         PreparedStatement stmt=null;
         stmt=conn.prepareStatement(q);
         stmt.setString(1,fname.getText());
         stmt.setString(2,lname.getText());
         stmt.setString(3,email.getText());
         stmt.setString(5,address.getText());
         stmt.setString(6,username.getText());
         stmt.setString(7,password.getText());
         stmt.setString(4,((JTextField)dob.getDateEditor().getUiComponent()).getText());
         stmt.setInt(8,id);
         stmt.executeUpdate();
         q="call p1";
         stmt=conn.prepareStatement(q);
         stmt.executeUpdate();
         q="update p_contact set contact=? where contact=?";
         stmt=conn.prepareStatement(q);
         stmt.setString(1, mob1.getText());
         stmt.setString(2,s1);
         stmt.executeUpdate();
         if(mob2.getText().equals(""))
         {   
             q="delete from p_contact where contact=?";
             stmt=conn.prepareStatement(q);
             stmt.setString(1,s2);
             stmt.executeUpdate();
         }
         else{
         stmt.setString(1, mob2.getText());
         stmt.setString(2,s2);
         stmt.executeUpdate();
         }
         JOptionPane.showMessageDialog(null, "Update Succesfull");
         
         }
         catch (SQLException ex) {
         Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new custlogin().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lnameActionPerformed

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
            java.util.logging.Logger.getLogger(updateprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(updateprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(updateprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(updateprofile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new updateprofile().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(updateprofile.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private com.toedter.calendar.JDateChooser dob;
    private javax.swing.JTextField email;
    private javax.swing.JTextField fname;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lname;
    private javax.swing.JTextField mob1;
    private javax.swing.JTextField mob2;
    private javax.swing.JTextField password;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}