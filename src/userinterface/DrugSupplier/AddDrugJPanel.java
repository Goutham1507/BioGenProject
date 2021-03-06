/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DrugSupplier;

import Business.Drug.DrugList;
import Business.Drug.Drug;
import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.DrugOrganization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.apache.log4j.Logger;

/**
 *
 * @author venu0
 */
public class AddDrugJPanel extends javax.swing.JPanel {

    /**
     * Creates new form AddDrugJPanel
     */
    private DrugList drugList;
    private JPanel userProcessContainer;
    private EcoSystem business;
    private UserAccount userAccount;
    private DrugOrganization drugOrganization;
    private Enterprise enterprise;
    private Network network;
    private static Logger log = Logger.getLogger(AddDrugJPanel.class);
    private static final String CLASS_NAME = AddDrugJPanel.class.getName();

    public AddDrugJPanel(JPanel userProcessContainer, EcoSystem business, UserAccount userAccount, DrugOrganization drugOrganization, Enterprise enterprise, Network network) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.business = business;
        this.enterprise = enterprise;
        this.network = network;
        this.drugOrganization = drugOrganization;
        populateTable();

    }

    public void populateTable() {
        DefaultTableModel model = (DefaultTableModel) drugTble.getModel();

        model.setRowCount(0);

        for (Drug d : business.getDrugList().getDrugList()) {

            Object[] row = new Object[2];
            row[0] = d.getDrugId();
            row[1] = d;
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

        jScrollPane1 = new javax.swing.JScrollPane();
        drugTble = new javax.swing.JTable();
        drugtxtField = new javax.swing.JTextField();
        addDrugBtn = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        addChemicalButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        processlbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        drugTble.setFont(new java.awt.Font("Microsoft JhengHei Light", 0, 20)); // NOI18N
        drugTble.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "DrugName"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        drugTble.setRowHeight(30);
        jScrollPane1.setViewportView(drugTble);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(176, 141, 720, 270));

        drugtxtField.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 20)); // NOI18N
        drugtxtField.setForeground(new java.awt.Color(0, 0, 102));
        drugtxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drugtxtFieldActionPerformed(evt);
            }
        });
        add(drugtxtField, new org.netbeans.lib.awtextra.AbsoluteConstraints(396, 431, 230, 40));

        addDrugBtn.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 20)); // NOI18N
        addDrugBtn.setForeground(new java.awt.Color(0, 0, 102));
        addDrugBtn.setText("ADD Drug");
        addDrugBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDrugBtnActionPerformed(evt);
            }
        });
        add(addDrugBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(643, 431, 180, -1));

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("DRUG");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(273, 431, 123, 40));

        addChemicalButton.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 20)); // NOI18N
        addChemicalButton.setForeground(new java.awt.Color(0, 0, 102));
        addChemicalButton.setText("Add Chemical");
        addChemicalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addChemicalButtonActionPerformed(evt);
            }
        });
        add(addChemicalButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 550, -1, -1));

        backButton.setFont(new java.awt.Font("Microsoft JhengHei UI Light", 1, 20)); // NOI18N
        backButton.setForeground(new java.awt.Color(0, 0, 102));
        backButton.setIcon(new javax.swing.ImageIcon("C:\\Users\\vgout\\AED_ASSIGNMENT\\AED_ASSIGNMENT_LAB\\biogen_finalproject\\BioGen_FinalProject\\src\\Image\\backbtn")); // NOI18N
        backButton.setText(" Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });
        add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 560, -1, -1));

        processlbl.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 48)); // NOI18N
        processlbl.setForeground(new java.awt.Color(0, 0, 102));
        processlbl.setText("Drug Panel");
        add(processlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 40, 300, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Drug.jpg"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void drugtxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drugtxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_drugtxtFieldActionPerformed

    private void addDrugBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addDrugBtnActionPerformed
        // TODO add your handling code here:

        String drugName = drugtxtField.getText().trim();
        if(drugName.isEmpty())
        {
            JOptionPane.showMessageDialog(null,"Drug name cannot be empty");
            return;
        }
        ArrayList<String> drugcheck= new ArrayList<>();
        for(Drug d:business.getDrugList().getDrugList())
        {
            drugcheck.add(d.getDrugName().toLowerCase());
        }
        if(drugcheck.contains(drugName.toLowerCase()))
        {
            JOptionPane.showMessageDialog(null,"Drug name already exists");
            return;
        }

        business.getDrugList().addDrugList().setDrugName(drugName);
        
        populateTable();
        log.debug(userAccount+" "+"added new drug"+" "+drugName);
        drugtxtField.setText("");

    }//GEN-LAST:event_addDrugBtnActionPerformed

    private void addChemicalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addChemicalButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = drugTble.getSelectedRow();
        if(selectedRow<0)
        {
            JOptionPane.showMessageDialog(null, "please select a row ");
            return;
        }
        Drug c = (Drug) drugTble.getValueAt(selectedRow, 1);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.add("AddChemicalsJPanel", new AddChemicalsJPanel(userProcessContainer, business, userAccount, drugOrganization, enterprise, network, c));
        log.debug(userAccount+" "+"entering add chemicals page");
        layout.next(userProcessContainer);
    }//GEN-LAST:event_addChemicalButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addChemicalButton;
    private javax.swing.JButton addDrugBtn;
    private javax.swing.JButton backButton;
    private javax.swing.JTable drugTble;
    private javax.swing.JTextField drugtxtField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel processlbl;
    // End of variables declaration//GEN-END:variables
}
