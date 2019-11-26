
package GUI;

import Classes.Agent;
import Classes.Members;
import Utilities.ReadWrite;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 *
 * @author ppunme
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    //input and output file
    final static String fileName = "Members.bin";
    
    public static ArrayList<Members> list = new ArrayList<Members>();
    public static ArrayList<Agent> agentList = new ArrayList<Agent>();
    public static ArrayList<Members> restoredList = new ArrayList<>();
    
    //open OutputFile
    private static FileOutputStream fos; 
    private static ObjectOutputStream oos; 
    
    Color myColor = new Color(163, 186, 195); 
    
    public MainMenu() {
        initComponents();
        
        this.setVisible(true);
        this.setTitle("Main Menu");
        this.setBounds(500, 100, 528, 580); // (x,y,width,height)
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
        lblHead1 = new javax.swing.JLabel();
        lblHead2 = new javax.swing.JLabel();
        btnBackup = new javax.swing.JPanel();
        lblBackup = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnRestore = new javax.swing.JPanel();
        lblRestore = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnAddMember = new javax.swing.JPanel();
        lblAddMember = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSearch = new javax.swing.JPanel();
        lblSearch = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnAddAgent = new javax.swing.JPanel();
        lblAddAgent = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btnHelp = new javax.swing.JPanel();
        lblHelp = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnExit = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        pnlAll.setBackground(new java.awt.Color(234, 234, 234));
        pnlAll.setForeground(new java.awt.Color(66, 75, 84));

        pnlHead.setBackground(new java.awt.Color(34, 70, 96));

        lblHead1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
        lblHead1.setForeground(new java.awt.Color(255, 255, 255));
        lblHead1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHead1.setText("Health Insurance");

        lblHead2.setFont(new java.awt.Font("Lucida Grande", 0, 20)); // NOI18N
        lblHead2.setForeground(new java.awt.Color(255, 255, 255));
        lblHead2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblHead2.setText("Member Registration");

        javax.swing.GroupLayout pnlHeadLayout = new javax.swing.GroupLayout(pnlHead);
        pnlHead.setLayout(pnlHeadLayout);
        pnlHeadLayout.setHorizontalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeadLayout.createSequentialGroup()
                .addGroup(pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlHeadLayout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(lblHead2))
                    .addGroup(pnlHeadLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(lblHead1, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlHeadLayout.setVerticalGroup(
            pnlHeadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlHeadLayout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(lblHead1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHead2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        btnBackup.setBackground(new java.awt.Color(255, 255, 255));
        btnBackup.setToolTipText("Backup All data to Binary file named 'Members.bin'");
        btnBackup.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBackupMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBackupMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBackupMousePressed(evt);
            }
        });

        lblBackup.setForeground(new java.awt.Color(102, 102, 102));
        lblBackup.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBackup.setText("Backup");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-database-50orange 02.37.28.png"))); // NOI18N

        javax.swing.GroupLayout btnBackupLayout = new javax.swing.GroupLayout(btnBackup);
        btnBackup.setLayout(btnBackupLayout);
        btnBackupLayout.setHorizontalGroup(
            btnBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBackup, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
            .addGroup(btnBackupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        btnBackupLayout.setVerticalGroup(
            btnBackupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnBackupLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblBackup)
                .addGap(12, 12, 12))
        );

        btnRestore.setBackground(new java.awt.Color(255, 255, 255));
        btnRestore.setToolTipText("Restored the data from binary file");
        btnRestore.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRestoreMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRestoreMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnRestoreMousePressed(evt);
            }
        });

        lblRestore.setForeground(new java.awt.Color(102, 102, 102));
        lblRestore.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRestore.setText("Restore");

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-update_left_rotation_filled.png"))); // NOI18N

        javax.swing.GroupLayout btnRestoreLayout = new javax.swing.GroupLayout(btnRestore);
        btnRestore.setLayout(btnRestoreLayout);
        btnRestoreLayout.setHorizontalGroup(
            btnRestoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRestoreLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnRestoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRestore, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap())
        );
        btnRestoreLayout.setVerticalGroup(
            btnRestoreLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnRestoreLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRestore)
                .addGap(12, 12, 12))
        );

        btnAddMember.setBackground(new java.awt.Color(255, 255, 255));
        btnAddMember.setToolTipText("Add Membership details to the system");
        btnAddMember.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddMemberMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddMemberMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAddMemberMousePressed(evt);
            }
        });

        lblAddMember.setForeground(new java.awt.Color(102, 102, 102));
        lblAddMember.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddMember.setText("Add Member");

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-user-green 02.37.28 02.37.28.png"))); // NOI18N

        javax.swing.GroupLayout btnAddMemberLayout = new javax.swing.GroupLayout(btnAddMember);
        btnAddMember.setLayout(btnAddMemberLayout);
        btnAddMemberLayout.setHorizontalGroup(
            btnAddMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAddMemberLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnAddMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAddMember, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        btnAddMemberLayout.setVerticalGroup(
            btnAddMemberLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAddMemberLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAddMember)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSearch.setBackground(new java.awt.Color(255, 255, 255));
        btnSearch.setToolTipText("Search for member in the system");
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

        lblSearch.setForeground(new java.awt.Color(102, 102, 102));
        lblSearch.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSearch.setText("Search");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-search_filled.png"))); // NOI18N

        javax.swing.GroupLayout btnSearchLayout = new javax.swing.GroupLayout(btnSearch);
        btnSearch.setLayout(btnSearchLayout);
        btnSearchLayout.setHorizontalGroup(
            btnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap())
        );
        btnSearchLayout.setVerticalGroup(
            btnSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSearchLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        btnAddAgent.setBackground(new java.awt.Color(255, 255, 255));
        btnAddAgent.setToolTipText("Add Sales Agent details to the system");
        btnAddAgent.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAddAgent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAddAgentMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAddAgentMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAddAgentMousePressed(evt);
            }
        });

        lblAddAgent.setForeground(new java.awt.Color(102, 102, 102));
        lblAddAgent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAddAgent.setText("Add Agent");

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-business-red 02.37.28 02.37.28 02.37.28.png"))); // NOI18N

        javax.swing.GroupLayout btnAddAgentLayout = new javax.swing.GroupLayout(btnAddAgent);
        btnAddAgent.setLayout(btnAddAgentLayout);
        btnAddAgentLayout.setHorizontalGroup(
            btnAddAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAddAgentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblAddAgent, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        btnAddAgentLayout.setVerticalGroup(
            btnAddAgentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnAddAgentLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblAddAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

        btnHelp.setBackground(new java.awt.Color(255, 255, 255));
        btnHelp.setForeground(new java.awt.Color(255, 255, 255));
        btnHelp.setToolTipText("Help Document");
        btnHelp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHelpMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHelpMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnHelpMousePressed(evt);
            }
        });

        lblHelp.setForeground(new java.awt.Color(102, 102, 102));
        lblHelp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHelp.setText("Help");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-help-50grey 02.37.28 02.37.28 02.37.28.png"))); // NOI18N

        javax.swing.GroupLayout btnHelpLayout = new javax.swing.GroupLayout(btnHelp);
        btnHelp.setLayout(btnHelpLayout);
        btnHelpLayout.setHorizontalGroup(
            btnHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHelpLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblHelp, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        btnHelpLayout.setVerticalGroup(
            btnHelpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHelpLayout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHelp)
                .addGap(12, 12, 12))
        );

        btnExit.setBackground(new java.awt.Color(153, 153, 153));
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnExit.setText("Exit");
        btnExit.setOpaque(true);
        btnExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExitMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnExitMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pnlAllLayout = new javax.swing.GroupLayout(pnlAll);
        pnlAll.setLayout(pnlAllLayout);
        pnlAllLayout.setHorizontalGroup(
            pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlHead, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlAllLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddAgent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHelp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(39, 39, 39)
                .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlAllLayout.createSequentialGroup()
                        .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnBackup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRestore, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        pnlAllLayout.setVerticalGroup(
            pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAllLayout.createSequentialGroup()
                .addComponent(pnlHead, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddMember, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddAgent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(pnlAllLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnHelp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBackup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRestore, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(btnExit, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMemberMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMemberMousePressed
        AddMember addMember = new AddMember(this, list);
        this.setVisible(false);	
    }//GEN-LAST:event_btnAddMemberMousePressed

    private void btnBackupMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackupMousePressed
        writeData();
    }//GEN-LAST:event_btnBackupMousePressed

    private void btnHelpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHelpMousePressed
        //This pdf document is located in the root directory of this NetBeans project
        String document = "User Documentation.pdf";  //could also have a file path here to another directory
        try{
            File f = new File(document);
            Desktop.getDesktop().open(f);
        }
        catch(IOException ioE){
            System.err.print(ioE.getMessage());
        } 
    }//GEN-LAST:event_btnHelpMousePressed

    private void btnRestoreMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRestoreMousePressed
        
        
        int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to restore from file backup?"
                + "\nRestoring will erase all members from the database and save the data from the backup file."
                + "\nPlease make sure you have recently made a backup file before you continue.",
                "Select an Option",JOptionPane.YES_NO_OPTION);
        // 0=yes, 1=no
        
        if(option == 0){
            System.out.println("option: " + option);
            try{
                readData();
                System.out.println(restoredList.size());
                Utilities.DataAccessLayer.restoreData(restoredList);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());	
            }
        }
    }//GEN-LAST:event_btnRestoreMousePressed

    private void btnAddMemberMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMemberMouseEntered
        setColor(btnAddMember);
    }//GEN-LAST:event_btnAddMemberMouseEntered

    private void btnHelpMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHelpMouseEntered
        setColor(btnHelp);
    }//GEN-LAST:event_btnHelpMouseEntered

    private void btnBackupMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackupMouseEntered
        setColor(btnBackup);
    }//GEN-LAST:event_btnBackupMouseEntered

    private void btnRestoreMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRestoreMouseEntered
        setColor(btnRestore);
    }//GEN-LAST:event_btnRestoreMouseEntered

    private void btnAddMemberMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMemberMouseExited
        resetColor(btnAddMember);
    }//GEN-LAST:event_btnAddMemberMouseExited

    private void btnHelpMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHelpMouseExited
        resetColor(btnHelp);
    }//GEN-LAST:event_btnHelpMouseExited

    private void btnBackupMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackupMouseExited
        resetColor(btnBackup);
    }//GEN-LAST:event_btnBackupMouseExited

    private void btnRestoreMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRestoreMouseExited
        resetColor(btnRestore);
    }//GEN-LAST:event_btnRestoreMouseExited

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Font fn = null;
        try{
            fn = Font.createFont(Font.TRUETYPE_FONT,getClass().getResourceAsStream("../Font/Roboto-Regular.ttf"));
            Font f1 = fn.deriveFont(Font.PLAIN,40);
            Font f2 = fn.deriveFont(Font.PLAIN,22);
            Font f3 = fn.deriveFont(Font.PLAIN,14);
            
            lblHead1.setFont(f1);
            lblHead2.setFont(f2);
            lblAddAgent.setFont(f3);
            lblAddMember.setFont(f3);
            lblSearch.setFont(f3);
            lblHelp.setFont(f3);
            lblBackup.setFont(f3);
            lblRestore.setFont(f3);
            btnExit.setFont(f3);
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_formWindowActivated

    private void btnAddAgentMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddAgentMousePressed
        AddAgent addAgent = new AddAgent(this, agentList);
        this.setVisible(false);	
        
    }//GEN-LAST:event_btnAddAgentMousePressed

    private void btnAddAgentMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddAgentMouseExited
        resetColor(btnAddAgent);
    }//GEN-LAST:event_btnAddAgentMouseExited

    private void btnAddAgentMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddAgentMouseEntered
        setColor(btnAddAgent);
    }//GEN-LAST:event_btnAddAgentMouseEntered

    private void btnExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseEntered
        btnExit.setBackground(new java.awt.Color(181,177,178));
    }//GEN-LAST:event_btnExitMouseEntered

    private void btnExitMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMouseExited
        btnExit.setBackground(new java.awt.Color(153,153,153));
    }//GEN-LAST:event_btnExitMouseExited

    private void btnExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExitMousePressed
        int w = 200;
        
        String exit = "<html><body width='%1s'>"
                + "<p>Do you want to backup the data to binary file "
                + "before you close the program?";
        int optionExit = JOptionPane.showConfirmDialog(null, String.format(exit, w, w),"Exit the program",JOptionPane.YES_NO_OPTION);
        
        if(optionExit == 0){
            try{
                System.out.println("saved");
                writeData();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());	
            }
        } 
        else {
            System.exit(0);
        }
        System.exit(0);
    }//GEN-LAST:event_btnExitMousePressed

    private void btnSearchMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMousePressed
        SearchForm search = new SearchForm(this);
        this.setVisible(false);

    }//GEN-LAST:event_btnSearchMousePressed

    private void btnSearchMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseExited
        resetColor(btnSearch);
    }//GEN-LAST:event_btnSearchMouseExited

    private void btnSearchMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseEntered
        setColor(btnSearch);
    }//GEN-LAST:event_btnSearchMouseEntered

    public void setColor(JPanel panel){
        panel.setBackground(new java.awt.Color(181,177,178)); 
    }
    
    public void resetColor(JPanel panel){
        panel.setBackground(new java.awt.Color(255,255,255));
    }
    
    public static void writeData(){
        
        Utilities.DataAccessLayer.getDataFromDatabase(list);
        System.out.println("Backup list" + list);

        try{
            ReadWrite.writeData(fileName, list);
            JOptionPane.showMessageDialog(null, "All Members records stored to file \"Members.bin\"");
        }
        catch(FileNotFoundException fnfEx){
            System.err.println("Problem with the binary file");
        }
        catch(ClassNotFoundException cnfEx){
            System.err.println("Problem with the Patient class");
        }
        catch(NotSerializableException nsEx){
            System.err.println("A class has not been serialised");
        }
        catch (IOException ioEx){
            System.err.println("Issue(s) with saving data to file");
        }
    }
    
    public static void readData(){
        System.out.println("Restored List:" + restoredList);
        try{
            restoredList = ReadWrite.readData(fileName);
            System.out.println("Restored List after:" + restoredList);
            JOptionPane.showMessageDialog(null, restoredList.size() + " student records have been loaded from file");
        }
        catch(FileNotFoundException fnfEx){
            System.err.println("Problem with the binary file");
        }
        catch(ClassNotFoundException cnfEx){
            System.err.println("Problem with the Patient class");
        }
        catch(NotSerializableException nsEx){
            System.err.println("A class has not been serialised");
        }
        catch (IOException ioEx){
            System.err.println("Issue(s) with saving data to file");
        }
    }
    
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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        
        //</editor-fold>

        /* Create and display the form */
    /*    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });*/
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnAddAgent;
    private javax.swing.JPanel btnAddMember;
    private javax.swing.JPanel btnBackup;
    private javax.swing.JLabel btnExit;
    private javax.swing.JPanel btnHelp;
    private javax.swing.JPanel btnRestore;
    private javax.swing.JPanel btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblAddAgent;
    private javax.swing.JLabel lblAddMember;
    private javax.swing.JLabel lblBackup;
    private javax.swing.JLabel lblHead1;
    private javax.swing.JLabel lblHead2;
    private javax.swing.JLabel lblHelp;
    private javax.swing.JLabel lblRestore;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JPanel pnlAll;
    private javax.swing.JPanel pnlHead;
    // End of variables declaration//GEN-END:variables
}
