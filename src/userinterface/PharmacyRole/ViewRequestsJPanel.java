/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.PharmacyRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DrugWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author venu0
 */
public class ViewRequestsJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ViewRequestsJPanel
     */
    
     private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private Organization organization;
    private Enterprise enterprise;
     private static Logger log = Logger.getLogger(ViewRequestsJPanel.class);
    private static final String CLASS_NAME = ViewRequestsJPanel.class.getName();
    public ViewRequestsJPanel(JPanel userProcessContainer,UserAccount userAccount,Enterprise enterprise,Organization organization) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.userAccount=userAccount;
        this.enterprise=enterprise;
        this.organization= organization;
        populateTable();
        log.debug(userAccount+" "+"viewed the drug requests");
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)drugRequestsTable.getModel();
        
        model.setRowCount(0);
        
        
      // for(WorkRequest request : opOrganization.getWorkQueue().getWorkRequestList())
      
        
        model.setRowCount(0);
        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[5];
            row[0] = ((DrugWorkRequest) request).getDrugName();
            row[1] = ((DrugWorkRequest) request).getQuantity();
            row[2] = request.getReceiver();
            String result = ((DrugWorkRequest) request).getStatus();
            row[3] = result == null ? "Waiting" : result;
            if(((DrugWorkRequest) request).getDeliveryTime()==null){
                row[4]="Details yet to be updated by supplier";
            }
            else{
            row[4]  = "Expected delivery time " +((DrugWorkRequest) request).getDeliveryTime();
                    }
            
            model.addRow(row);
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

        jScrollPane = new javax.swing.JScrollPane();
        drugRequestsTable = new javax.swing.JTable();
        backBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        reqmedicineLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        drugRequestsTable.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 0, 20)); // NOI18N
        drugRequestsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MEDICINE NAME", "REQUIRED QUANTITY", "RECIEVER", "STATUS", "DELIVERY DATE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        drugRequestsTable.setRowHeight(25);
        jScrollPane.setViewportView(drugRequestsTable);

        add(jScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(132, 208, 1045, 277));

        backBtn.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 24)); // NOI18N
        backBtn.setForeground(new java.awt.Color(0, 0, 102));
        backBtn.setIcon(new javax.swing.ImageIcon("C:\\Users\\vgout\\AED_ASSIGNMENT\\AED_ASSIGNMENT_LAB\\biogen_finalproject\\BioGen_FinalProject\\src\\Image\\backbtn")); // NOI18N
        backBtn.setText(" BACK");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });
        add(backBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 590, 136, -1));

        refreshBtn.setFont(new java.awt.Font("Microsoft YaHei UI Light", 0, 24)); // NOI18N
        refreshBtn.setForeground(new java.awt.Color(0, 0, 102));
        refreshBtn.setText("REFRESH");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });
        add(refreshBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(694, 590, 136, -1));

        reqmedicineLbl.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 48)); // NOI18N
        reqmedicineLbl.setForeground(new java.awt.Color(0, 0, 102));
        reqmedicineLbl.setText("Requested Medicine Details");
        add(reqmedicineLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/MedicineRequest.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 50, -1, 110));
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
       userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        PharmacyWorkArea dw = (PharmacyWorkArea) component;
        dw.reorderTable();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
        
       
    }//GEN-LAST:event_refreshBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTable drugRequestsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JLabel reqmedicineLbl;
    // End of variables declaration//GEN-END:variables
}
