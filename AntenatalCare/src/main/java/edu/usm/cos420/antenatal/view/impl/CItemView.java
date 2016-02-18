package edu.usm.cos420.antenatal.view.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import edu.usm.cos420.antenatal.gui.newVisitTab;
import edu.usm.cos420.antenatal.service.AntenatalService;
import edu.usm.cos420.antenatal.service.impl.AntenatalService1;


public class CItemView extends JFrame{
 
	/** {@value}  : no choice selected by user */
	public static final int NO_CHOICE = 0;
	/** {@value #ADDONE}  : Add one CItem to the collection of items */
    public static final int ADDONE = 1;
	/** {@value #EXIT}  : Exit the program */
    public static final int EXIT = 6;

    private AntenatalService1 example1Service;
 
    /**
     * This small version of the UI does not need the model or service objects but, in general, 
     *     references to these objects are needed in the UI. Default constructor
     *     creates a reference to Example1Service class to illustrate this.
     */
  public CItemView()
  {
      this.example1Service = new AntenatalService1();
      initUI();
  }
  /**
   * This small version of the UI does not need the model or service objects but, in general, 
   *     references to these objects are needed in the UI.
   * @param example1Service reference to class which provides CItem Services
   */
   public CItemView(AntenatalService1 example1Service)
   {
	  this.example1Service = example1Service;
	  initUI();
   }
   
   
   private void initUI(){
      
      createMenuBar();
      
      JButton quitButton = new JButton("Quit");
      quitButton.setToolTipText("Quit button");
      quitButton.setMnemonic(KeyEvent.VK_Q);
      
      quitButton.addActionListener(l -> System.exit(0));
      
      createLayout(quitButton);
      
      setTitle("MoTech");
      setSize(600, 400);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
   }
   
   private void createLayout(JComponent... arg){
      
      Container pane = getContentPane();
      GroupLayout grplout = new GroupLayout(pane);
      pane.setLayout(grplout);
      
      grplout.setAutoCreateContainerGaps(true);
      
      grplout.setHorizontalGroup(grplout.createSequentialGroup().addComponent(arg[0]));
      
      grplout.setVerticalGroup(grplout.createSequentialGroup().addComponent(arg [0]));
   }
   
   private void createMenuBar(){
      JMenuBar menuBar = new JMenuBar();
      
      JMenu file = new JMenu("Antenatal");
      file.setMnemonic(KeyEvent.VK_F);
      
      JMenuItem eMenuItemOne = new JMenuItem("Enter Information");
      eMenuItemOne.addActionListener(new newEntry());
      JMenuItem eMenuItemTwo = new JMenuItem("Find Previous Visits");
      
      JMenuItem eMenuItemThree = new JMenuItem("Exit");
      eMenuItemThree.setMnemonic(KeyEvent.VK_E);
      eMenuItemThree.setToolTipText("Exit application");
      eMenuItemThree.addActionListener(l -> System.exit(0));
      file.add(eMenuItemOne);
      file.add(eMenuItemTwo);
      file.add(eMenuItemThree);
      menuBar.add(file);
      
      setJMenuBar(menuBar);
   }
   private class newEntry implements ActionListener{
	   private JPanel panel1;
	   private newEntry(){
		   panel1 = new newVisitTab();
		   panel1.setBackground(Color.LIGHT_GRAY);
		   
		   
	   }
	@Override
	public void actionPerformed(ActionEvent e) {
		   getContentPane().removeAll();
		   createLayout(panel1);
		   
		
	}
	   
   }

}