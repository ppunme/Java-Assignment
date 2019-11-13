/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Classes.Family;
import Classes.Members;
import Classes.Single;
import Utilities.ConnectionDetails;
import Utilities.MemberTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author ppunme
 */
public class UpdateMember extends JFrame implements ActionListener, ItemListener
{
    public static ArrayList<Members> list;
    
    //Buttons
    private JButton btnAdd, btnClear, btnExit;

    //TextFields
    private JTextField txfID, txfFirst, txfLast, txfEmail, txfPhone;
    private JTextField txfAddress, txfSuburb, txfPostcode;

    //Radio Buttons
    private JRadioButton rbtMale, rbtFemale;
    private JRadioButton rbtSingle, rbtFamily;

    //Combo Box
    private JComboBox cboStateLoad;
    private JComboBox cboPackLoad;
    private JComboBox cboAgentLoad;

    //Labels
    private JLabel lblHeading, lblID, lblFirst, lblLast, lblGender, lblEmail, lblPhone;
    
    //Image
    private JLabel lblImage;
    private ImageIcon image;
    
    //set a color object using RGB
    Color myColor1 = new Color(255, 255, 255); //white
    Color myColor2 = new Color(234, 235, 237); //grey
    Color myColor3 = new Color(45,81,142);     //blue
    
    Font f1 = new Font("Helvetica", Font.BOLD,30);
    Font f2 = new Font("Helvetica", Font.PLAIN,16);
    
    private boolean validate = true;
    private final static double BASE_FEE = 50.00; 
    private int nextAvailableID;
    
    private String gender;
    private String type;
    private int indexState, indexPack, indexAgent;
    private String stateLoad, packLoad, agentLoad;

    SearchForm parentMenu;
    MemberTableModel memberModel;
    
	
    public UpdateMember(SearchForm menu, MemberTableModel model, Members m) 
    {  	
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Add a new Member");
        this.setVisible(true);
        this.setBounds(550,100,485,625);
        
        
        //re-create the main menu when this frame is closed
    	parentMenu = menu;
        memberModel = model;

        nextAvailableID = list.size() + 1;
        
        //create panel for Heading
        JPanel pnlHeading = new JPanel();
        pnlHeading.setBackground(myColor3);
        pnlHeading.add(lblHeading = new JLabel());
        lblHeading.setForeground(Color.white);
        lblHeading.setFont(f1);
        lblHeading.setText("Add a new Member");

        //Create ButtonGroup for the radio buttons
        //Make only one radio button can be selected
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(rbtMale);
        genderGroup.add(rbtFemale);
        
        //create panal for Gender
        JPanel pnlGender = new JPanel();
        pnlGender.setLayout(new GridLayout(1, 2));
        pnlGender.setBackground(myColor1);
        pnlGender.add(rbtMale = new JRadioButton("Male"));
        pnlGender.add(rbtFemale = new JRadioButton("Female"));
        
        //create panel for type of membership
        JPanel pnlTypeRadio = new JPanel();
        pnlTypeRadio.setLayout(new GridLayout(1, 2));
        pnlTypeRadio.setBackground(myColor1);
        pnlTypeRadio.add(rbtSingle = new JRadioButton("Single"));
        pnlTypeRadio.add(rbtFamily = new JRadioButton("Family"));
        
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(rbtSingle);
        typeGroup.add(rbtFamily);

        //create panel for the Main
    	JPanel pnlData = new JPanel(new GridBagLayout());
        pnlData.setBorder(new EmptyBorder(10, 10, 10, 10)); //padding
        pnlData.setBackground(myColor1);
        GridBagConstraints g = new GridBagConstraints();
        g.weightx = 3;
        g.fill = GridBagConstraints.HORIZONTAL;
        
        lblID = new JLabel("ID  ", SwingConstants.RIGHT);
        g.gridx = 0;
        g.gridy = 0;
        pnlData.add(lblID, g);
        
        g.gridx = 1;
        g.gridy = 0;
    	pnlData.add(txfID = new JTextField(Integer.toString(nextAvailableID)), g);
    	txfID.setEnabled(false); //make this field not interactive
        
        g.gridx = 0;
        g.gridy = 1;
    	pnlData.add(lblFirst = new JLabel("First name  ", SwingConstants.RIGHT), g);
        
        g.gridx = 1;
        g.gridy = 1;
    	pnlData.add(txfFirst = new JTextField(), g);
        
        g.gridx = 0;
        g.gridy = 2;
    	pnlData.add(lblLast = new JLabel("Last name  ", SwingConstants.RIGHT), g);
        
        g.gridx = 1;
        g.gridy = 2;
        pnlData.add(txfLast = new JTextField(), g);
        
        g.gridx = 0;
        g.gridy = 3;
    	pnlData.add(lblGender = new JLabel("Gender  ", SwingConstants.RIGHT), g);
        
        g.gridx = 1;
        g.gridy = 3;
        pnlData.add(pnlGender, g);
        
        g.gridx = 0;
        g.gridy = 4;
        pnlData.add(lblGender = new JLabel("Email  ", SwingConstants.RIGHT), g);
        
        g.gridx = 1;
        g.gridy = 4;
        pnlData.add(txfEmail = new JTextField(10), g);
        
        g.gridx = 0;
        g.gridy = 5;
        pnlData.add(lblPhone = new JLabel("Phone  ", SwingConstants.RIGHT), g);
        
        g.gridx = 1;
        g.gridy = 5;
        pnlData.add(txfPhone = new JTextField(10), g);
        
        //Create panal for Address
        //Combo box
        String sLoad[] = {"New South Wales", "Western Australia", "Queensland", "South Australia", "Victoria", "Tasmania", "Make a Selection"};
        cboStateLoad = new JComboBox(sLoad);
        cboStateLoad.setSelectedItem("Make a Selection");
        
        //Panel
        JPanel pnlAddress = new JPanel(new GridLayout(0,2,5,5)); // row,col,hgap,vgap
        pnlAddress.setBorder(new EmptyBorder(10, 10, 10, 10)); //padding
        pnlAddress.setBackground(myColor2);

        pnlAddress.add(new JLabel());
        pnlAddress.add(new JLabel("ADDRESS", SwingConstants.CENTER));
        pnlAddress.add(new JLabel("Address   ", SwingConstants.RIGHT));
        pnlAddress.add(txfAddress = new JTextField());    
        pnlAddress.add(new JLabel("Suburb   ", SwingConstants.RIGHT));
        pnlAddress.add(txfSuburb = new JTextField());
        pnlAddress.add(new JLabel("State   ", SwingConstants.RIGHT));
        pnlAddress.add(cboStateLoad);
        pnlAddress.add(new JLabel("Postcode   ", SwingConstants.RIGHT));
        pnlAddress.add(txfPostcode = new JTextField());
        
        //Create panel for the type detail
        String pLoad[] = {"Saver", "Bronze", "Ultimate", "Make a Selection"};
        cboPackLoad = new JComboBox(pLoad);
        cboPackLoad.setSelectedItem("Make a Selection");
        
        String aLoad[] = {"Make a Selection"};
        cboAgentLoad = new JComboBox(aLoad);
        cboAgentLoad.setSelectedItem("Maka a Selection");
        
    	JPanel pnlType = new JPanel();
        pnlType.setBackground(myColor1);
        pnlType.setBorder(new EmptyBorder(10, 10, 10, 10));
        pnlType.setLayout(new GridLayout(0,2));
        pnlType.add(new JLabel("Type     ", SwingConstants.RIGHT));
        pnlType.add(pnlTypeRadio);
        pnlType.add(new JLabel("Package     ", SwingConstants.RIGHT));
    	pnlType.add(cboPackLoad);
        pnlType.add(new JLabel("Agent     ", SwingConstants.RIGHT));
    	pnlType.add(cboAgentLoad);
        
        //Create panel for the buttons
    	JPanel pnlButtons = new JPanel();
        pnlButtons.setBorder(new EmptyBorder(10, 10, 10, 10));
        pnlButtons.add(btnExit = new JButton("Main menu"));
    	pnlButtons.add(btnAdd = new JButton("Add"));
    	pnlButtons.add(btnClear = new JButton("Clear"));
        
        //Create panal for combine all panel
        JPanel pnlAll = new JPanel();
        pnlAll.setLayout(new GridLayout(3, 0));
        pnlAll.add(pnlData);
        pnlAll.add(pnlAddress);
        pnlAll.add(pnlType);
        
        //Add panels to the JFrame container
    	Container c = this.getContentPane();
    	c.add(pnlHeading, BorderLayout.NORTH);
        c.add(pnlAll, BorderLayout.CENTER);
    	c.add(pnlButtons, BorderLayout.SOUTH);
        
        //register buttons to accept events
        btnAdd.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);
        rbtMale.addActionListener(this);
        rbtFemale.addActionListener(this);
        rbtSingle.addActionListener(this);
        rbtFamily.addActionListener(this);
        cboStateLoad.addActionListener(this);
        cboPackLoad.addActionListener(this);
        cboAgentLoad.addActionListener(this);
        //addItemListener
        cboStateLoad.addItemListener(this);
        cboPackLoad.addItemListener(this);
        cboAgentLoad.addItemListener(this);
    }	
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnAdd)
        {
            addNewMember();
        }
        if(e.getSource() == btnClear)
        {
            clearForm();
        }
        if(e.getSource() == btnExit)
        {
            mainMenu();
        }
        if (e.getSource() == rbtMale)
        {
            gender = "Male"; //retrieve value from RadioButtons
        }
        if (e.getSource() == rbtFemale)
        {
            gender = "Female"; //retrieve value from RadioButtons
        }
        if (e.getSource() == rbtSingle)
        {
            type = "Single"; //retrieve value from RadioButtons
        }
        if (e.getSource() == rbtFamily)
        {
            type = "Family"; //retrieve value from RadioButtons
        }
        if(e.getSource() == cboStateLoad)
        {
            stateLoad = (String) cboStateLoad.getSelectedItem();
        }
        if(e.getSource() == cboPackLoad)
        {
            packLoad = (String) cboPackLoad.getSelectedItem();
        }
        if(e.getSource() == cboAgentLoad)
        {
            agentLoad = (String) cboAgentLoad.getSelectedItem();
        }
    }
	
    public void itemStateChanged(ItemEvent e)
    {
        if(e.getSource()==cboStateLoad)
        {
            indexState = cboStateLoad.getSelectedIndex();
        }
        if(e.getSource()== cboPackLoad)
        {
            indexPack = cboPackLoad.getSelectedIndex();
        }
        if(e.getSource()== cboAgentLoad)
        {
            indexAgent = cboAgentLoad.getSelectedIndex();
        }
    }
	
    //add Single member to the array
    public void addNewMember()
    {
  
    }
    
    //add Family member to the array
    public void addFamily()
    {

    }
	
    // clear the Frame
    private void clearForm()  
    {
        //re-set all components
        txfID.setText(Integer.toString(nextAvailableID));
        txfFirst.setText("");	
        txfLast.setText("");		
        rbtMale.setSelected(false);
        rbtFemale.setSelected(false);
        txfEmail.setText("");
        txfPhone.setText("");
        txfAddress.setText("");
        txfSuburb.setText("");
        cboStateLoad.setSelectedItem("Make a Selection");	
        txfPostcode.setText("");
        rbtSingle.setSelected(false);
        rbtFamily.setSelected(false);
        cboPackLoad.setSelectedItem("Make a Selection");	
        cboAgentLoad.setSelectedItem("Make a Selection");	
    }
 
    public void addToDatabase(){
        //Insert into database
    }
    
    // close addSingle frame and return to main menu
    public void mainMenu() 
    {
        parentMenu.setVisible(true);	
        this.dispose(); 
    }
}