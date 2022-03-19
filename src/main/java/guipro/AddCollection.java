package guipro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;



public class AddCollection extends javax.swing.JFrame {

    public AddCollection() {
        initComponents();

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/mycollections", "root", "roottoor");
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Collections");
        setResizable(false);

        jLabel1.setText("Name");

        jTextField1.setToolTipText("Left Character");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
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

        jLabel3.setText("JLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTextField1))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(47, 47, 47)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
        }

        if (evt.getActionCommand().equals("Add")) {

            if (jTextField1.getText().equals("")) {
                jLabel3.setText("Collection Name is required...");
                return;
            }

            String name = jTextField1.getText();
            if (name.length() > 32) {
                jLabel3.setText("You can't use more than 32 character in either fields...");
                return;
            }

            try {
                stmt = con.createStatement();
                PreparedStatement pStmt = null;
                pStmt = con.prepareStatement("select * from collection_names where name=?");
                pStmt.setString(1, name);
                ResultSet rs = pStmt.executeQuery();
                if (rs.next()) 
                {
                    jLabel3.setText("The provided name is already exits." + name);
                    return;
                } 
                else 
                {
                    pStmt = con.prepareStatement("insert into collection_names(name) values(?)");
                    pStmt.setString(1, name);
                    int i = pStmt.executeUpdate();
                    if (i >= 1) {
                        jLabel3.setText("Entry added successfully...." + i);
                    } else {
                        jLabel3.setText("There was error while inserting into database...." + i);
                    }
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

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCollection().setVisible(true);
            }
        });
    }
    private Statement stmt = null;
    private Connection con = null;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
