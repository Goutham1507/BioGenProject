/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.ChemicalRole;

import Business.WorkQueue.ChemicalWorkRequest;
import Business.WorkQueue.DrugWorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.apache.log4j.Logger;

/**
 *
 * @author kasai
 */
public class ChemicalProcessRequestJpanel extends javax.swing.JPanel {

    /**
     * Creates new form ChemicalProcessRequestJpanel
     */
    JPanel userProcessContainer;
    ChemicalWorkRequest request;
    private static Logger log = Logger.getLogger(ChemicalProcessRequestJpanel.class);
    private static final String CLASS_NAME = ChemicalProcessRequestJpanel.class.getName();
    public ChemicalProcessRequestJpanel(JPanel userprocessContainer, ChemicalWorkRequest request) {
        initComponents();
        this.userProcessContainer = userprocessContainer;
        this.request = request;
        dateFld.setMinSelectableDate(new Date());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        processlbl = new javax.swing.JLabel();
        datedeliveryBtn = new javax.swing.JLabel();
        dateTxt = new javax.swing.JTextField();
        dateFld = new com.toedter.calendar.JDateChooser();
        backBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 204, 204));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        processlbl.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 48)); // NOI18N
        processlbl.setForeground(new java.awt.Color(0, 0, 102));
        processlbl.setText("PROCESSING DRUG SUPPLIER REQUEST ");
        add(processlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 108, -1, 53));

        datedeliveryBtn.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 24)); // NOI18N
        datedeliveryBtn.setForeground(new java.awt.Color(0, 0, 102));
        datedeliveryBtn.setText("SELECT DATE OF DELIVERY : ");
        add(datedeliveryBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 269, 375, 41));

        dateTxt.setEditable(false);
        dateTxt.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 20)); // NOI18N
        add(dateTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(502, 272, 261, 41));
        add(dateFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(835, 272, 156, 41));

        backBtn.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        backBtn.setForeground(new java.awt.Color(0, 0, 102));
        backBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\vgout\\AED_ASSIGNMENT\\AED_ASSIGNMENT_LAB\\biogen_finalproject\\BioGen_FinalProject\\src\\Image\\backbtn")); // NOI18N
        backBtn.setText("BACK");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 401, -1, 33));

        updateBtn.setFont(new java.awt.Font("Microsoft YaHei UI Light", 1, 24)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(0, 0, 102));
        updateBtn.setText("UPDATE STATUS ");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });
        add(updateBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 400, 261, 33));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/progress.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 90, 110, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:

        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        ChemicalWorkArea dwjp = (ChemicalWorkArea) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        request.setStatus("Completed");
        try{
        int year = dateFld.getCalendar().get(Calendar.YEAR);
        int month = dateFld.getCalendar().get(Calendar.MONTH);
        int day = dateFld.getCalendar().get(Calendar.DAY_OF_MONTH);
        String result = year + "-" + month + "-" + day;
        ((ChemicalWorkRequest) request).setDeliveryTime(result);
        dateTxt.setText(result);
        JOptionPane.showMessageDialog(null, "Request updated successfully!");
        log.debug("request updated successfully");
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null , "please enter the valid date");
            return;
        }
    }//GEN-LAST:event_updateBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private com.toedter.calendar.JDateChooser dateFld;
    private javax.swing.JTextField dateTxt;
    private javax.swing.JLabel datedeliveryBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel processlbl;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}