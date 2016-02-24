package edu.usm.cos420.antenatal.view.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import edu.usm.cos420.antenatal.domain.DummyPerson;
import edu.usm.cos420.antenatal.gui.consultingData;
import edu.usm.cos420.antenatal.gui.newVisitTab;
import edu.usm.cos420.antenatal.service.AntenatalService;
import edu.usm.cos420.antenatal.service.impl.AntenatalService1;


public class AntenatalView extends JFrame{

	private AntenatalService1 example1Service;
	private DummyPerson p;
	public AntenatalView()
	{
		this.example1Service = new AntenatalService1();
		p = new DummyPerson();

		initUI();
	}

	public AntenatalView(AntenatalService1 example1Service)
	{
		this.example1Service = example1Service;
		p = new DummyPerson();
		initUI();
	}

	private static JTabbedPane TPAIN;
	private void initUI(){
		Container pane = getContentPane();
		BorderLayout border = new BorderLayout();
		pane.setLayout(border);

		createMenuBar();

		JButton quitButton = new JButton("Quit");
		quitButton.setSize(pane.getWidth()/2,20);
		quitButton.setToolTipText("Quit button");
		quitButton.setMnemonic(KeyEvent.VK_Q);

		quitButton.addActionListener(l -> System.exit(0));


		TPAIN = new JTabbedPane();
		
		fillEmpty();
		
		TPAIN.setTabPlacement(JTabbedPane.TOP);
		TPAIN.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		
		
		pane.setBackground(Color.LIGHT_GRAY);
		
		consultingData holdData = new consultingData();
		
		pane.add(createSplitData(holdData), BorderLayout.CENTER);
		pane.add(quitButton, BorderLayout.SOUTH);

		setTitle("MoTech");
		setSize(800, 600);
		setMinimumSize(new Dimension(600,400));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);



	}
	private Component createSplitData(consultingData holdData) {
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, holdData.getPanel(p), TPAIN);
		split.setResizeWeight(0.30);
		split.setDividerLocation(130);
		
		return split;
	}

	private static void fillEmpty() {
		JPanel fill = new JPanel();
		fill.setBackground(Color.LIGHT_GRAY);
		TPAIN.addTab("-------", fill);
		
	}

	private int count = 1;
	private void createMenuBar(){
		JMenuBar menuBar = new JMenuBar();

		JMenu file = new JMenu("Antenatal");
		file.setMnemonic(KeyEvent.VK_F);

		JMenuItem eMenuItemOne = new JMenuItem("Create New Visit");
		eMenuItemOne.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(count==1){
					getContentPane().remove(getContentPane().getComponentCount()-1);
				}
				newVisitTab panel1 = new newVisitTab(p);
				count++;
				if(TPAIN.getTitleAt(0)=="-------"){
					TPAIN.remove(0);
					
				}
				TPAIN.addTab(panel1.getTitle(), panel1.getPanel());
				
				validate();
				
				
				


			}
		});
		
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
	public static void removeTab(String s){
		TPAIN.remove(TPAIN.indexOfTab(s));// make a remove 
		if(TPAIN.getTabCount()==0){
			fillEmpty();
		}
	}
}