/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Members;
import Classes.Single;
import Utilities.ConnectionDetails;
import Utilities.MemberTableModel;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author ppunme
 */
public class SearchForm extends javax.swing.JFrame {

    /**
     * Creates new form SearchForm
     */
    MainMenu parentMenu;
    
    Color myColor1 = new Color(45,81,142);
    
    String searchLoad;
    int indexSearch;
    private int selectedRow;
    private boolean found;
    
    MemberTableModel memberModel = new MemberTableModel();
    ArrayList<Members> list = new ArrayList<>();
    
    public SearchForm(MainMenu menu) {
        initComponents();
   
        this.setTitle("Search Form");
        this.setVisible(true);
        this.setBounds(400, 100, 680, 668); // (x,y,width,height)
     
        parentMenu = menu;
        
        //System.out.println(list);
        
        searchLoad = (String) cboSearch.getSelectedItem();
        System.out.println(searchLoad);
        
        memberModel = new MemberTableModel();
        resultTable.setModel(memberModel);
        
        resultTable.setSelectionMode(selectedRow);
        
        //the following uses an anonymous inner class
        ListSelectionModel rowSM = resultTable.getSelectionModel();
        rowSM.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e){
                ListSelectionModel lsm = (ListSelectionModel) e.getSource();
                selectedRow = lsm.getMinSelectionIndex();
            }
        });
        
        //all columns displayed at the preferred widths
        resultTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        //resultTable.setGridColor(Color.gray);
        
    }
    
    private void GetDataFromAll() {  
                   
    }
    
    private void GetDataFromID() {

    }
    
    private void GetDataFromName() {
        ArrayList<Members> searchList = new ArrayList<>();
        
        MemberTableModel memberModel = new MemberTableModel();
        Utilities.DataAccessLayer.getDataFromDatabase(list);
        
        System.out.println("Search List: " + searchList);
        for(Members m : list) {
            System.out.println(m.getName());
            if(m == null) {
                break;
            } else {
                if(m.getName().equalsIgnoreCase(txfSearch.getText())){
                    found = true;
                    searchList.add(m);
                }
            }
        }
        
        if(found == true) {
            System.out.println("Found ");
            memberModel = new MemberTableModel(searchList);
            resultTable.setModel(memberModel);
        } else {
            JOptionPane.showMessageDialog(null, "Member does not exist");
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

        pnlAll = new javax.swing.JPanel();
        pnlHead = new javax.swing.JPanel();
        lblHead = new javax.swing.JLabel();
        pnlSearch = new javax.swing.JPanel();
        lblSearchBy = new javax.swing.JLabel();
        btnBack = new javax.swing.JLabel();
        btnDelete = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JLabel();
        btnSearch = new javax.swing.JPanel();
        lblSearch = new javax.swing.JLabel();
        txfSearch = new javax.swing.JTextField();
        cboSearch = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane(resultTable);
        resultTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        pnlAll.setBackground(new java.awt.Color(88, 89, 96));

        pnlHead.setBackground(new java.awt.Color(88, 89, 96));

        lblHead.setBackground(new java.awt.Color(255, 255, 255));
        lblHead.setFont(new java.awt.Font("Adobe Caslon Pro", 0, 40)); // NOI18N
        lblHead.setForeground(new java.awt.Color(243, 243, 243));
        lblHead.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHead.setText("Search Form");

        javax.swing.GroupLayout pnlHeadLayout = new javax.swing.GroupLayout(pnlHead);
        pnlHead.setLayout(pnlHeadLayout);
        pnlHeadLayout.setHorizontalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeadLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHead)
                .addGap(234, 234, 234))
        );
        pnlHeadLayout.setVerticalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlHeadLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addComponent(lblHead)
                .addGap(23, 23, 23))
        );

        lblSearchBy.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        lblSearchBy.setText("Search from");

        btnBack.setBackground(new java.awt.Color(136, 132, 130));
        btnBack.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnBack.setText("Back");
        btnBack.setOpaque(true);
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBackMousePressed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(220, 161, 56));
        btnDelete.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnDelete.setText("Delete");
        btnDelete.setOpaque(true);
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeleteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeleteMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnDeleteMousePressed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(220, 161, 56));
        btnUpdate.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUpdate.setText("Update");
        btnUpdate.setOpaque(true);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUpdateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUpdateMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUpdateMousePressed(evt);
            }
        });

        btnSearch.setBackground(new java.awt.Color(34, 70, 96));
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSearchMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSearchMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSearchMousePressed(evt);
            }
        });

        lblSearch.setFont(new java.awt.Font("Helvetica", 0, 20)); // NOI18N
        lblSearch.setForeground(new java.awt.Color(255, 255, 255));
        lblSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearch.setText("Search");

        javax.swing.GroupLayout btnSearchLayout = new javax.swing.GroupLayout(btnSearch);
        btnSearch.setLayout(btnSearchLayout);
        btnSearchLayout.setHorizontalGroup(
            btnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
        );
        btnSearchLayout.setVerticalGroup(
            btnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnSearchLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        cboSearch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Member ID", "First Name", "Last Name", "Phone", "Address", "Sales Agent", " " }));
        cboSearch.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSearchItemStateChanged(evt);
            }
        });
        cboSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSearchActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        resultTable.setFont(new java.awt.Font("Helvetica", 0, 14)); // NOI18N
        resultTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Membere ID", "First Name", "Last Name", "Gender", "Email", "Phone", "Address"
            }
        ));
        resultTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        jScrollPane1.setViewportView(resultTable);

        javax.swing.GroupLayout pnlSearchLayout = new javax.swing.GroupLayout(pnlSearch);
        pnlSearch.setLayout(pnlSearchLayout);
        pnlSearchLayout.setHorizontalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSearchLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlSearchLayout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(199, 199, 199)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlSearchLayout.createSequentialGroup()
                        .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSearchLayout.createSequentialGroup()
                                .addComponent(lblSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        pnlSearchLayout.setVerticalGroup(
            pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSearchLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlSearchLayout.createSequentialGroup()
                        .addComponent(txfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSearchBy, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cboSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlAllLayout = new javax.swing.GroupLayout(pnlAll);
        pnlAll.setLayout(pnlAllLayout);
        pnlAllLayout.setHorizontalGroup(
            pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlAllLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        pnlAllLayout.setVerticalGroup(
            pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAllLayout.createSequentialGroup()
                .addComponent(pnlHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Font fn = null;
        try{
            fn = Font.createFont(Font.TRUETYPE_FONT,getClass().getResourceAsStream("../Font/Roboto-Regular.ttf"));
            Font f1 = fn.deriveFont(Font.PLAIN,40);
            Font f2 = fn.deriveFont(Font.PLAIN,20);
            Font f3 = fn.deriveFont(Font.PLAIN,14);
            
            lblHead.setFont(f1);
            lblSearchBy.setFont(f3);
            btnSearch.setFont(f2);
            btnBack.setFont(f3);
            btnDelete.setFont(f3);
            btnUpdate.setFont(f3);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_formWindowActivated

    private void btnSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMousePressed
        
        if(txfSearch.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Enter data to search");
        }
        else if (searchLoad == "All") {
            GetDataFromAll();
        }
        else if (searchLoad == "First Name") {
            GetDataFromName();
        }
        else if(searchLoad == "Member ID") {
            GetDataFromID();
        }
    }//GEN-LAST:event_btnSearchMousePressed

    private void cboSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSearchActionPerformed
        if(evt.getSource() == cboSearch){
            searchLoad = (String) cboSearch.getSelectedItem();
            System.out.println("string: " + searchLoad);
        }
    }//GEN-LAST:event_cboSearchActionPerformed

    private void cboSearchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSearchItemStateChanged
        if(evt.getSource() == cboSearch){
            indexSearch = cboSearch.getSelectedIndex();
            System.out.println("index: " + indexSearch);
        }
    }//GEN-LAST:event_cboSearchItemStateChanged

    private void btnBackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMousePressed
        parentMenu.setVisible(true);	
        this.dispose(); 
    }//GEN-LAST:event_btnBackMousePressed

    private void btnDeleteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMousePressed
        Members m = memberModel.getRow(selectedRow);
        System.out.println(m.getId());
        
        Connection con = null;
        Statement stmt = null;
        
        
        try{
            con = ConnectionDetails.getConnection();
            stmt = con.createStatement();
            
            if(m instanceof Single)
            {
                String sql = "Delete from tblSingle where memberId=" + m.getId();
                System.out.println(sql);
                stmt.executeUpdate(sql);

                sql = "Delete from tblAddress where memberId=" + m.getId();
                stmt.executeUpdate(sql);

                sql = "Delete from tblMember where memberId=" + m.getId();
                stmt.executeUpdate(sql);

                stmt.close();
            } 
            else 
            {
                String sql = "Delete from tblFamily where memberId=" + m.getId();
                System.out.println(sql);
                stmt.executeUpdate(sql);

                sql = "Delete from tblAddress where memberId=" + m.getId();
                stmt.executeUpdate(sql);

                sql = "Delete from tblMember where memberId=" + m.getId();
                stmt.executeUpdate(sql);

                stmt.close();
            }
           
            con.close();
        } catch (SQLException ex){
            ex.printStackTrace();
        } finally {
            
        }
        //Utilities.DataAccessLayer.getDataFromDatabase();
        memberModel.fireTableRowsDeleted(selectedRow, selectedRow); //check
    }//GEN-LAST:event_btnDeleteMousePressed

    private void btnUpdateMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMousePressed
        Members m = memberModel.getRow(selectedRow);
        Update updateFrame = new Update(this,memberModel,m); 
        this.setVisible(false);
        
    }//GEN-LAST:event_btnUpdateMousePressed

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered
        btnSearch.setBackground(new java.awt.Color(102,102,102)); 
    }//GEN-LAST:event_btnSearchMouseEntered

    private void btnBackMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseEntered
        setColor(btnBack);
    }//GEN-LAST:event_btnBackMouseEntered

    private void btnDeleteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseEntered
        setColor(btnDelete);
    }//GEN-LAST:event_btnDeleteMouseEntered

    private void btnUpdateMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseEntered
        setColor(btnUpdate);
    }//GEN-LAST:event_btnUpdateMouseEntered

    private void btnSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseExited
        btnSearch.setBackground(new java.awt.Color(34,70,96));
    }//GEN-LAST:event_btnSearchMouseExited

    private void btnBackMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMouseExited
        btnBack.setBackground(new java.awt.Color(255,255,255));
    }//GEN-LAST:event_btnBackMouseExited

    private void btnDeleteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseExited
        btnDelete.setBackground(new java.awt.Color(133,160,168));
    }//GEN-LAST:event_btnDeleteMouseExited

    private void btnUpdateMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseExited
        btnUpdate.setBackground(new java.awt.Color(34,70,96));
    }//GEN-LAST:event_btnUpdateMouseExited

    public void setColor(JLabel label){
        label.setBackground(new java.awt.Color(102,102,102)); 
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>
        
        

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchForm().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnBack;
    private javax.swing.JLabel btnDelete;
    private javax.swing.JPanel btnSearch;
    private javax.swing.JLabel btnUpdate;
    private javax.swing.JComboBox<String> cboSearch;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHead;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSearchBy;
    private javax.swing.JPanel pnlAll;
    private javax.swing.JPanel pnlHead;
    private javax.swing.JPanel pnlSearch;
    private javax.swing.JTable resultTable;
    private javax.swing.JTextField txfSearch;
    // End of variables declaration//GEN-END:variables
}
