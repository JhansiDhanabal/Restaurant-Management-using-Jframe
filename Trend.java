/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package restaurant;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nanda
 */
public class Trend extends javax.swing.JFrame {

    /**
     * Creates new form Trend
     */
    public Trend() {
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

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        table3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        customtable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Daily Invoice");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DeliveryDate", "Item Name", "CustomerName", "Sales"
            }
        ));
        jScrollPane1.setViewportView(table1);

        jButton2.setText("Most Sales Items");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Item Name", "Total Sales"
            }
        ));
        jScrollPane2.setViewportView(table2);

        table3.setText("Customer Items");
        table3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                table3ActionPerformed(evt);
            }
        });

        customtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CustomerName", "number of Days"
            }
        ));
        jScrollPane3.setViewportView(customtable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(table3)
                    .addComponent(jButton2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(64, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(table3)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        table1.setVisible(true);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","First1002@d");
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("Select * from invoic");
            DefaultTableModel model=(DefaultTableModel)table1.getModel();
            model.getDataVector().removeAllElements();
            while(rs.next()){
                String name = rs.getString("DeliveryDate");
                String description = rs.getString("ItemName");
                String type = rs.getString("CustomerName");
                String sales = String.valueOf(rs.getDouble("Sales"));
                String data[]={name, description, type, sales};
                model.addRow(data);
            }
        }
        catch(Exception e){
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void table3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_table3ActionPerformed
        HashMap<String, Integer>map = new HashMap<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","First1002@d");
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("Select * from invoic");
            while(rs.next()){
                map.put(rs.getString("CustomerName"), map.getOrDefault(rs.getString("CustomerName"), 0)+1);
            }
            /*
            LinkedList<Map.Entry<String, Integer> > list= new LinkedList<Map.Entry<String, Integer> >(map.entrySet());
 
            // Sort the list using lambda expression
            Collections.sort(list,(i1, i2) -> i1.getValue().compareTo(i2.getValue()));
           */
            DefaultTableModel model=(DefaultTableModel)customtable.getModel();
            model.getDataVector().removeAllElements();
            for(Map.Entry<String, Integer>m : map.entrySet()){
                String name = m.getKey();
                String type = String.valueOf(m.getValue());
                String data[]={name, type};
                model.addRow(data);
            }
        }
        catch(Exception e){
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_table3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        HashMap<String, Integer>map = new HashMap<>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL","root","First1002@d");
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery("Select * from invoic");
            while(rs.next()){
                int sales = (int)rs.getDouble("Sales");
                map.put(rs.getString("ItemName"), (map.getOrDefault(rs.getString("ItemName"), 0)+sales));
            }
            /*
            LinkedList<Map.Entry<String, Integer> > list= new LinkedList<Map.Entry<String, Integer> >(map.entrySet());
 
            // Sort the list using lambda expression
            Collections.sort(list,(i1, i2) -> i1.getValue().compareTo(i2.getValue()));
           */
            DefaultTableModel model=(DefaultTableModel)table2.getModel();
            model.getDataVector().removeAllElements();
            for(Map.Entry<String, Integer>m : map.entrySet()){
                String name = m.getKey();
                String type = String.valueOf(m.getValue());
                String data[]={name, type};
                model.addRow(data);
            }
        }
        catch(Exception e){
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Trend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Trend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Trend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Trend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Trend().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable customtable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JButton table3;
    // End of variables declaration//GEN-END:variables
}
