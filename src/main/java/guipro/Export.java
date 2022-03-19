/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipro;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author arbaz
 */
public class Export extends javax.swing.JFrame {
    
    Statement stmt = null;
    Connection con = null;

    public Export() {
        initComponents();
        jcombobox();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setText("Export");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 247, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser j = new JFileChooser(new java.io.File("."));
                    j.setDialogTitle("Select a folder");
                    j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    j.setAcceptAllFileFilterUsed(false);
                    if (j.showOpenDialog(new Export()) == JFileChooser.APPROVE_OPTION) {
                        try {
                            String folder_path = j.getSelectedFile().toString();
                            stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery("select * from collections where name='" + jComboBox1.getSelectedItem().toString() + "'");
                            try (PrintWriter writer = new PrintWriter(
                                    folder_path + "//" + jComboBox1.getSelectedItem().toString() + "__" + System.currentTimeMillis() + ".txt", "UTF-8")) {
                                while (rs.next()) {
                                    writer.println(rs.getString("leftc") + "==" + rs.getString("rightc"));
                                }
                            } catch (FileNotFoundException | UnsupportedEncodingException ex) {
                                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }   catch (SQLException ex) {
                            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No Selection ");
                    }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Export().setVisible(true);
            }
        });
    }
    
    
    public void jcombobox(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/mycollections", "root", "roottoor");

            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from collection_names");
            jComboBox1.removeAllItems();
            while (rs.next()) {
                jComboBox1.addItem(rs.getString("name"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    // End of variables declaration//GEN-END:variables
}
