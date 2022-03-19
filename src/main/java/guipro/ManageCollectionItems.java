package guipro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ManageCollectionItems extends javax.swing.JFrame {

    private Connection con = null;
    private Statement stmt = null;
    private PreparedStatement pStmt = null;
    private String id = "";
    private String name = "";
    private String leftc = "";
    private String rightc = "";
    private ResultSet rs = null;

    public ManageCollectionItems() {
        try {
            initComponents();
            con = DriverManager.getConnection("jdbc:mysql://localhost/mycollections", "root", "roottoor");
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select*from collections");
            DefaultTableModel mytable = (DefaultTableModel) jTable2.getModel();
            int rowCount = mytable.getRowCount();
            for (int i = rowCount - 1; i >= 0; i--) {
                mytable.removeRow(i);
                ResultSetMetaData rsdm = rs.getMetaData();
                while (rs.next()) {
                    mytable.addRow(new Object[]{rs.getInt("id"), rs.getString("Leftc"), rs.getString("rightc"), rs.getString("name")});

                }
                jTable2.setModel(mytable);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManageCollectionItems.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Encryption & Decryption System");
        setResizable(false);

        jLabel1.setText("COLLECTION ITEM");

        jTextField1.setActionCommand("<Not Set>");

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "LEFT", "RIGHT", "NAME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jLabel2.setText("ERROR :");

        jLabel3.setText("Search");

        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Search");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton3)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2))
                .addContainerGap(244, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jButton4)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        id = jTable2.getValueAt(jTable2.getSelectedRow(), 0).toString();
        leftc = jTable2.getValueAt(jTable2.getSelectedRow(), 1).toString();
        rightc = jTable2.getValueAt(jTable2.getSelectedRow(), 2).toString();
        name = jTable2.getValueAt(jTable2.getSelectedRow(), 3).toString();
        jTextField1.setText(leftc);
        jTextField2.setText(rightc);

    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (getActionCommand().equals("Clear")) {
            jTextField1.setText("");
            jTextField2.setText("");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (evt.getActionCommand().equals("Update") && jTextField1.getText().equals("") && jTextField2.getText().equals("")) {
            jLabel2.setText("plz enter the values to replace in the text box");
            return;
        }
        if (evt.getActionCommand().equals("Update")) {
            jLabel2.setText("");
            
            String left = jTextField1.getText();
            String right = jTextField2.getText();
            if (leftc.equals(left) && rightc.equals(right)) {
                jLabel2.setText("Updated Succesfully.");
                return;
            }

            try {

                stmt = con.createStatement();

                pStmt = con.prepareStatement("select * from collections where BINARY leftc= ? and name= ? and id!= ?");
                pStmt.setString(1, left);
                pStmt.setString(2, name);
                pStmt.setString(3, id);
                ResultSet rs = pStmt.executeQuery();
                if (rs.next()) {
                    jLabel2.setText("The provided left character:"+left+" of collection:" + name + " already exits.");
                    return;
                }
                pStmt = con.prepareStatement("select * from collections where BINARY rightc= ? and name= ? and id!= ?");
                pStmt.setString(1, right);
                pStmt.setString(2, name);
                pStmt.setString(3, id);
                rs = pStmt.executeQuery();
                if (rs.next()) {
                    jLabel2.setText("The provided left character:"+right+" of collection:" + name + " already exits.");
                    return;
                }
                

                pStmt = con.prepareStatement("select * from collections where BINARY leftc= ? and name= ?");
                pStmt.setString(1, left);
                pStmt.setString(2, name);
                rs = pStmt.executeQuery();
                if (rs.next()) {
                    jLabel2.setText("The provided left character already exits." + left);
                    return;
                }

                pStmt = con.prepareStatement("select * from collections where BINARY leftc= ? and name= ?");
                pStmt.setString(1, right);
                pStmt.setString(2, name);
                rs = pStmt.executeQuery();
                if (rs.next()) {
                    jLabel2.setText("The provided right character already has left record." + right);
                    return;
                }

                pStmt = con.prepareStatement("select * from collections where BINARY rightc= ? and name= ?");
                pStmt.setString(1, right);
                pStmt.setString(2, name);
                rs = pStmt.executeQuery();
                if (rs.next()) {
                    jLabel2.setText("The provided right character already exits." + right);
                    return;
                }

                pStmt = con.prepareStatement("select * from collections where BINARY rightc= ? and name= ?");
                pStmt.setString(1, left);
                pStmt.setString(2, name);
                rs = pStmt.executeQuery();
                if (rs.next()) {
                    jLabel2.setText("The provided right character already has left record." + left);
                    return;
                }

                pStmt = con.prepareStatement("select * from collections where BINARY leftc= ? and BINARY rightc= ? and name= ?");
                pStmt.setString(1, left);
                pStmt.setString(1, right);
                pStmt.setString(1, name);
                
                rs = pStmt.executeQuery();
                if (rs.next()) {
                    jLabel2.setText("The provided combination already exits." + left + ":" + right);
                    return;
                }

                pStmt = con.prepareStatement("select * from collections where BINARY leftc= ? and BINARY rightc= ? and name= ?");
                pStmt.setString(1, right);
                pStmt.setString(1, left);
                pStmt.setString(1, name);
                rs = pStmt.executeQuery();
                if (rs.next()) {
                    jLabel2.setText("The provided combination already exits." + right + ":" + left);
                    return;
                }

            } catch (SQLException ex) {
                Logger.getLogger(ManageCollectionItems.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (evt.getActionCommand().equals("Search") && jTextField3.getText().equals("")&& jTextField3.getText().equals("")) 
        {
            jLabel2.setText("please type inputs for both the field to search");
            return;
        }
        if (evt.getActionCommand().equals("Search")) 
        {
            try {
                stmt = con.createStatement();
                rs = stmt.executeQuery("select * from collections where leftc like '%" + jTextField3.getText() + "%' or rightc like '%"+jTextField3.getText()+"%'");
                if (rs != null) 
                {
                    DefaultTableModel aModel = (DefaultTableModel) jTable2.getModel();
                    int rowCount = aModel.getRowCount();
                    for (int i = rowCount - 1; i >= 0; i--) {
                        aModel.removeRow(i);
                    }
                    
                    while (rs.next()) {
                        aModel.addRow(new Object[]{rs.getInt("id"),rs.getString("leftc"), rs.getString("rightc"),rs.getString("name")});
                    }
                    jTable2.setModel(aModel);
                } else {
                    jLabel2.setText("No result found...");
                }
            } catch (SQLException ex) {
                Logger.getLogger(ManageCollections.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(evt.getActionCommand().equals("Refresh"))
        {
            try {
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery("select * from collections");
                DefaultTableModel aModel = (DefaultTableModel) jTable2.getModel();
                int rowCount = aModel.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    aModel.removeRow(i);
                }
                while (rs.next()) {
                    aModel.addRow(new Object[]{rs.getInt("id"), rs.getString("leftc"), rs.getString("rightc"), rs.getString("name")});
                }
                jTable2.setModel(aModel);
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageCollectionItems().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    private Object getActionCommand() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
