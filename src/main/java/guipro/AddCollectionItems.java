package guipro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddCollectionItems extends javax.swing.JFrame {

    public AddCollectionItems() {
        initComponents();

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/mycollections", "root", "roottoor");
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        populateCollection();
    }

    public void populateCollection() {
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from collection_names");
            jComboBox1.removeAllItems();
            while (rs.next()) {
                jComboBox1.addItem(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            jLabel3.setText(ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Collections Items");
        setResizable(false);

        jLabel1.setText("Left Character");

        jLabel2.setText("Right Character");

        jTextField1.setToolTipText("Left Character");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField2.setToolTipText("Right Character");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Error");

        jLabel4.setText("Collection");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(39, 39, 39)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2))
                            .addComponent(jTextField1))))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (evt.getActionCommand().equals("Clear")) {
            jTextField1.setText("");
            jTextField2.setText("");
        }
        if (evt.getActionCommand().equals("Add")) {

            if (jTextField1.getText().equals("")) {
                jLabel3.setText("Left Character is required...");
                return;
            } else if (jTextField2.getText().equals("")) {
                jLabel3.setText("Right Character is required...");
                return;
            }

            String left = jTextField1.getText();
            String right = jTextField2.getText();
            String name = jComboBox1.getItemAt(jComboBox1.getSelectedIndex());

            if (left.length() != 1 || right.length() != 1) {
                jLabel3.setText("You can't use more than one character in either fields...");
                return;
            }
            if (left.equals(right)) {
                jLabel3.setText("You can't use same character in both the fields.");
                return;
            }

            try {
                stmt = con.createStatement();
                PreparedStatement pStmt = null;

                pStmt = con.prepareStatement("select * from collections where BINARY leftc=? and name=?");
                pStmt.setString(1, left);
                pStmt.setString(2, name);
                ResultSet rs = pStmt.executeQuery();
                if (rs.next()) {
                    jLabel3.setText("The provided left character already exits." + left);
                    return;
                }

//                pStmt = con.prepareStatement("select * from collections where BINARY leftc= ? and name= ?");
//                pStmt.setString(1, left);
//                pStmt.setString(2, name);
//                rs = pStmt.executeQuery();
//                if (rs.next()) {
//                    jLabel3.setText("The provided right character already has left record." + right);
//                    return;
//                }

//                pStmt = con.prepareStatement("select * from collections where BINARY rightc= ? and name=?");
//                pStmt.setString(1, right);
//                pStmt.setString(2, name);
//                rs = pStmt.executeQuery();
//                if (rs.next()) {
//                    jLabel3.setText("The provided right character already exits." + right);
//                    return;
//                }

//                pStmt = con.prepareStatement("select * from collections where BINARY rightc = ? and name = ?");
//                pStmt.setString(1, left);
//                pStmt.setString(2, name);
//                
//                rs = pStmt.executeQuery();
//                if (rs.next()) {
//                    jLabel3.setText("The provided right character already has left record." + left);
//                    return;
//                }

                pStmt = con.prepareStatement("select * from collections where BINARY leftc= ? and BINARY rightc= ? and name= ?");
                pStmt.setString(1, left);
                pStmt.setString(2, right);
                pStmt.setString(3, name);
                rs = pStmt.executeQuery();
                if (rs.next()) {
                    jLabel3.setText("The provided combination already exits." + left + ":" + right);
                    return;
                }

//                pStmt = con.prepareStatement("select * from collections where BINARY leftc= ? and BINARY rightc= ? and name= ?");
//                pStmt.setString(1, right);
//                pStmt.setString(2, left);
//                pStmt.setString(3, name);
//                rs = pStmt.executeQuery();
//                if (rs.next()) {
//                    jLabel3.setText("The provided combination already exits." + right + ":" + left);
//                    return;
//                }

                pStmt = con.prepareStatement("insert into collections(leftc,rightc,name) values(?,?,?)");
                pStmt.setString(1, left);
                pStmt.setString(2, right);
                pStmt.setString(3, name);
                int i = pStmt.executeUpdate();
                if (i >= 1) {
                    jLabel3.setText("Entry added successfully...." + i);
                } else {
                    jLabel3.setText("There was error while inserting into database...." + i);
                }

                // <editor-fold defaultstate="collapsed" desc="Commented Code">     
//                while (rs.next()) {
//
//                    int id = rs.getInt("id");
//                    String leftc = rs.getString("leftc");
//                    String rightc = rs.getString("rightc");
//
//                    if (leftc.equals(left) && rightc.equals(right)) {
//                        System.out.println("The provided combination already exits." + leftc + ":" + rightc);
//                        return;
//                    } else if (leftc.equals(left) && !rightc.equals(right)) {
//                        System.out.println("The left character already has a record in database:" + leftc + ":" + rightc);
//                        return;
//                    } else if (!leftc.equals(left) && rightc.equals(right)) {
//                        System.out.println("The right character already has a record in database:" + rightc + ":" + leftc);
//                        return;
//                    }
//
//                    if (rightc.equals(right) && leftc.equals(left)) {
//                        System.out.println("The provided combination already exits." + rightc + ":" + leftc);
//                        return;
//                    } else if (rightc.equals(right) && !leftc.equals(left)) {
//                        System.out.println("The right character already has a record in database:" + rightc + ":" + leftc);
//                        return;
//                    } else if (!rightc.equals(right) && leftc.equals(left)) {
//                        System.out.println("The left character already has a record in database:" + rightc + ":" + leftc);
//                        return;
//                    }
//
//                    boolean insert = true;
//                    if (!leftc.equals(left) && !rightc.equals(right)) {
//                        insert = false;
//                    } else if (!rightc.equals(right) && !leftc.equals(left)) {
//                        insert = false;
//                    }
//
//                    if (insert) {
//
//                        PreparedStatement pStmt = con.prepareStatement("insert into collections values(?,?)");
//                        pStmt.setString(1, left);
//                        pStmt.setString(2, right);
//                        int i = pStmt.executeUpdate();
//                        System.out.println("Entry added successfully....");
//
//                    } else {
//                        System.out.println("Sorry, Your input is correct, but you entries are not allowed...");
//                        return;
//                    }
//                }
// </editor-fold> 
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
                jLabel3.setText(ex.getMessage());
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed

    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCollectionItems().setVisible(true);
            }
        });
    }
    private Statement stmt = null;
    private Connection con = null;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
