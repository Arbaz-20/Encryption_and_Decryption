package guipro;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MainFrame extends javax.swing.JFrame {

    private javax.swing.JMenuItem manageCollections;

    public MainFrame() {
        initComponents();
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        jMenu2.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                int input = JOptionPane.showConfirmDialog(null, "Do you like to exit?");
                // 0=yes, 1=no, 2=cancel
                if (0 == input) {
                    System.exit(0);
                }
            }

            @Override
            public void menuDeselected(MenuEvent e) {
            }

            @Override
            public void menuCanceled(MenuEvent e) {
            }
        });

        manageCollections = new javax.swing.JMenuItem();
        manageCollections.setText("Manage Collections");
        manageCollections.setActionCommand("ManageCollections");
        manageCollections.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(manageCollections);

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Private Messaging");

        jLabel1.setText("Select Name");

        jLabel2.setText("Type Message");

        jLabel3.setText("Errors");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Encrypt");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Select if you want to decrypt");
        jCheckBox1.setActionCommand("jCheckBox1");
        jCheckBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jCheckBox1ItemStateChanged(evt);
            }
        });
        jCheckBox1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jCheckBox1StateChanged(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jMenu1.setText("File");

        jMenuItem1.setText("Initialize Database");
        jMenuItem1.setActionCommand("initDB");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem4.setText("Import Collection");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Export Collection");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Collections");

        jMenuItem3.setText("Add Collection");
        jMenuItem3.setActionCommand("AddCollection");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem2.setText("Add Collection Items");
        jMenuItem2.setActionCommand("AddItems");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem6.setText("ManageCollectionItems");
        jMenuItem6.setActionCommand("ManageItems");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem6);

        jMenuBar1.add(jMenu3);

        jMenu2.setText("Exit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2))
                                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 519, Short.MAX_VALUE))
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))
                        .addGap(32, 32, 32))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed

        if (evt.getActionCommand().equals("initDB")) {
            try {
                stmt = con.createStatement();
                stmt.executeUpdate("create table IF NOT EXISTS collections(ID int NOT NULL PRIMARY KEY auto_increment,leftc char,rightc char,name varchar(64));");
                stmt.executeUpdate("create table IF NOT EXISTS users(ID int NOT NULL PRIMARY KEY auto_increment,name varchar(64),password varchar(1024));");
                stmt.executeUpdate("create table IF NOT EXISTS collection_names(ID int NOT NULL PRIMARY KEY auto_increment,name varchar(64));");
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (evt.getActionCommand().equals("AddCollection")) {
            new AddCollection().setVisible(true);
        }
        if (evt.getActionCommand().equals("AddItems")) {
            new AddCollectionItems().setVisible(true);
        }
        if (evt.getActionCommand().equals("ManageCollections")) {
            new ManageCollections().setVisible(true);
        }
        if (evt.getActionCommand().equals("ManageItems")) {
            new ManageCollectionItems().setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (evt.getActionCommand().equals("Clear")) {
            jTextArea1.setText("");
            jTextArea2.setText("");
        }
        if (evt.getSource() == jButton1) {

            String collectionName = jComboBox1.getSelectedItem().toString();
            String userInput = jTextArea1.getText();

            if (userInput.equals("")) {
                JOptionPane.showMessageDialog(this, "Please input text to encrypt or decrypt...");
                return;
            }
            PreparedStatement pStmt = null;
            ResultSet rs = null;
            String[] itemsLeft = null;
            String[] itemsRight = null;
            int itemSize = 0;
            try {
                pStmt = con.prepareStatement("select * from collections where name=?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                pStmt.setString(1, collectionName);
                rs = pStmt.executeQuery();
                if (rs != null) {
                    rs.last();

                    itemSize = rs.getRow();
                    itemsLeft = new String[itemSize];
                    itemsRight = new String[itemSize];
                    rs.beforeFirst();
                    int i = 0;
                    while (rs.next()) {
                        itemsLeft[i] = rs.getString("leftc");
                        itemsRight[i] = rs.getString("rightc");
                        i++;
                    }
                    i = 0;
                    //System.out.println(Arrays.toString(itemsLeft));
                    //System.out.println(Arrays.toString(itemsRight));

                } else {
                    JOptionPane.showMessageDialog(this, "Selected collection has no items...");
                    return;
                }
            } catch (SQLException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (jCheckBox1.isSelected()) {
                //Decrypt
                char[] inputArray = userInput.toCharArray();
                StringBuffer decrypted = new StringBuffer();

                for (int i = 0; i < inputArray.length; i++) {

                    for (int j = 0; j < itemsRight.length; j++) {

                        if (inputArray[i] == itemsRight[j].charAt(0)) {
                            decrypted.append(itemsLeft[j]);
                            break;
                        }
                    }

                    if (!this.check(itemsRight, String.valueOf(inputArray[i]))) {
                        decrypted.append(String.valueOf(inputArray[i]));
                    }
                }

                jTextArea2.setText(decrypted.toString());

            } else {
                //Encrypt
                char[] inputArray = userInput.toCharArray();
                StringBuffer encrypted = new StringBuffer();

                for (int i = 0; i < inputArray.length; i++) {

                    for (int j = 0; j < itemsLeft.length; j++) {

                        if (inputArray[i] == itemsLeft[j].charAt(0)) {
                            encrypted.append(itemsRight[j]);
                            break;
                        }

                    }

                    if (!this.check(itemsLeft, String.valueOf(inputArray[i]))) {
                        encrypted.append(String.valueOf(inputArray[i]));
                    }
                }

                jTextArea2.setText(encrypted.toString());
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        if (evt.getActionCommand().equals("ManageItems")) {
            new ManageCollectionItems().setVisible(true);
        }
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        //EXPORT
        try {

            JFrame collectionFrame = new JFrame("Export Collection");
            collectionFrame.setResizable(false);
            final JComboBox collectionBox = new JComboBox();
            JButton buttonCollection = new JButton("Export");

            buttonCollection.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {

                        JFileChooser j = new JFileChooser(new java.io.File("."));
                        j.setDialogTitle("Select a folder");
                        j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                        j.setAcceptAllFileFilterUsed(false);
                        if (j.showOpenDialog(collectionFrame) == JFileChooser.APPROVE_OPTION) {
                            String folder_path = j.getSelectedFile().toString();
                            stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery("select * from collections where name='" + collectionBox.getSelectedItem().toString() + "'");
                            try (PrintWriter writer = new PrintWriter(
                                    folder_path + "//" + collectionBox.getSelectedItem().toString() + "__" + System.currentTimeMillis() + ".txt", "UTF-8")) {
                                while (rs.next()) {
                                    writer.println(rs.getString("leftc") + "==" + rs.getString("rightc"));
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No Selection ");
                        }
                    } catch (Exception ex) {

                    }
                }

            });

        } catch (Exception e) {
            e.printStackTrace();
        }


    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed

        //Import Collections......
        try {

            JFrame collectionFrame = new JFrame("Import Collection");
            collectionFrame.setResizable(false);
            final JComboBox collectionBox = new JComboBox();
            JButton buttonCollection = new JButton("Import");

            buttonCollection.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        JFileChooser j = new JFileChooser(new java.io.File("."));
                        j.setDialogTitle("Select a folder");
                        j.setFileSelectionMode(JFileChooser.FILES_ONLY);
                        j.setAcceptAllFileFilterUsed(false);

                        j.addChoosableFileFilter(new javax.swing.filechooser.FileFilter() {
                            @Override
                            public boolean accept(File f) {
                                return f.isDirectory() || f.getName().toLowerCase().endsWith(".txt");
                            }

                            @Override
                            public String getDescription() {
                                return "Text Files that you have exported (*.txt)";
                            }
                        });

                        if (j.showOpenDialog(collectionFrame) == JFileChooser.APPROVE_OPTION) {
                            String txt_file = j.getSelectedFile().toString();

                            try {
                                BufferedReader br = new BufferedReader(new FileReader(txt_file));
                                String text = null;
                                PreparedStatement pStmt = null;
                                while ((text = br.readLine()) != null) {
                                    String[] items = text.split("==");
                                    String left = items[0].trim();
                                    String right = items[1].trim();
                                    String name = collectionBox.getSelectedItem().toString().trim();

                                    stmt = con.createStatement();
                                    ResultSet rs = stmt.executeQuery("select * from collections where BINARY leftc='" + left + "' and name='" + name + "'");
                                    if (rs.next()) {
                                        //jLabel3.setText("The provided left character already exits." + left);
                                        continue;
                                    }

                                    rs = stmt.executeQuery("select * from collections where BINARY leftc='" + right + "' and name='" + name + "'");
                                    if (rs.next()) {
                                        //jLabel3.setText("The provided right character already has left record." + right);
                                        continue;
                                    }

                                    rs = stmt.executeQuery("select * from collections where BINARY rightc='" + right + "' and name='" + name + "'");
                                    if (rs.next()) {
                                        //jLabel3.setText("The provided right character already exits." + right);
                                        continue;
                                    }

                                    rs = stmt.executeQuery("select * from collections where BINARY rightc='" + left + "' and name='" + name + "'");
                                    if (rs.next()) {
                                        //jLabel3.setText("The provided right character already has left record." + left);
                                        continue;
                                    }

                                    rs = stmt.executeQuery("select * from collections where BINARY leftc='" + left + "' and BINARY rightc='" + right + "' and name='" + name + "'");
                                    if (rs.next()) {
                                        //jLabel3.setText("The provided combination already exits." + left + ":" + right);
                                        continue;
                                    }

                                    rs = stmt.executeQuery("select * from collections where BINARY leftc='" + right + "' and BINARY rightc='" + left + "' and name='" + name + "'");
                                    if (rs.next()) {
                                        //jLabel3.setText("The provided combination already exits." + right + ":" + left);
                                        continue;
                                    }

                                    pStmt = con.prepareStatement("insert into collections(leftc,rightc,name) values(?,?,?)");
                                    pStmt.setString(1, left);
                                    pStmt.setString(2, right);
                                    pStmt.setString(3, name);
                                    pStmt.executeUpdate();

                                }

                            } catch (Exception exp) {
                                exp.printStackTrace();
                                JOptionPane.showMessageDialog(null, "Failed to read file", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No Selection");
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            });
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from collection_names");
            collectionBox.removeAllItems();
            while (rs.next()) {
                collectionBox.addItem(rs.getString("name"));
            }
            collectionFrame.add(collectionBox, BorderLayout.NORTH);
            collectionFrame.add(buttonCollection, BorderLayout.SOUTH);
            collectionFrame.setSize(300, 300);
            collectionFrame.setVisible(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jCheckBox1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jCheckBox1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1StateChanged

    private void jCheckBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jCheckBox1ItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            jButton1.setText("Decrypt");
        } else {
            jButton1.setText("Encrypt");
        }
    }//GEN-LAST:event_jCheckBox1ItemStateChanged
    private Connection con = null;
    private Statement stmt = null;

    static boolean check(String[] list, String value) {
        for (String temp : list) {
            if (temp.charAt(0) == value.charAt(0)) {
                return true;
            }
        }
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
