package edu.usm.cos420.antenatal.view.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.util.Objects;

import javax.swing.*;

import edu.usm.cos420.antenatal.controller.AntenatalController;
import edu.usm.cos420.antenatal.domain.DummyPerson;
import edu.usm.cos420.antenatal.gui.consultingData;
import edu.usm.cos420.antenatal.gui.newVisitTab;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;

/**
 * Creates the simple consulting view across the top
 * adds a place for the antenatal visit tab
 * and puts them together in one frame
 *
 */
public class AntenatalView extends JFrame{

	private AntenatalController controller;
	private DummyPerson dummyPerson;
	private newVisitTab newVisitPanel;
	private static JTabbedPane TPAIN;

	/**
	 * A simple getter that returns a new visit panel
	 * @return Returns the new visit panel/tab
	 */
	public newVisitTab getVisitPanel() {
		return newVisitPanel;
	}

	/**
	 * Adds the controller so that it can be accessed by the panel
	 * @param antenatalController : the antenatal controller
	 */
	public AntenatalView(AntenatalController antenatalController)
	{
		this.controller = antenatalController;
		dummyPerson = new DummyPerson();
		initUI();
	}

	/**
	 * initializes the user interface
	 */
	private void initUI(){
		Container pane = getContentPane();
		BorderLayout border = new BorderLayout();
		pane.setLayout(border);

		createMenuBar();

		JButton quitButton = new JButton("Quit");
		quitButton.setSize(pane.getWidth()/2,20);
		quitButton.setToolTipText("Quit button");
		quitButton.setMnemonic(KeyEvent.VK_Q);
		quitButton.addActionListener(controller);

		TPAIN = new JTabbedPane();

		fillEmpty();

		TPAIN.setTabPlacement(JTabbedPane.TOP);
		TPAIN.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);

		pane.setBackground(Color.LIGHT_GRAY);

		consultingData holdData = new consultingData();

		pane.add(createSplitData(holdData), BorderLayout.CENTER);
		pane.add(quitButton, BorderLayout.SOUTH);

		setTitle("MoTech");
		setSize(800, 700);
		setMinimumSize(new Dimension(800,625));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	/**
	 * Creates a divider between the consulting data and other data
	 * @param holdData
	 * @return returns a divider in the form 
	 */
	private Component createSplitData(consultingData holdData) {
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, holdData.getPanel(dummyPerson), TPAIN);
		split.setResizeWeight(0.30);
		split.setDividerLocation(160);
		return split;
	}

	/**
	 * Filles in empty space with a color and "--------"
	 */
	private static void fillEmpty() {
		JPanel fill = new JPanel();
		fill.setBackground(Color.LIGHT_GRAY);
		TPAIN.addTab("-------", fill);

	}

	private int count = 1;

	/**
	 * Creates the menu bar across the top of the screen to give selectable options
	 */
	private void createMenuBar(){
		JMenuBar menuBar = new JMenuBar();

		JMenu file = new JMenu("Antenatal");
		file.setMnemonic(KeyEvent.VK_F);

		JMenuItem eMenuItemOne = new JMenuItem("Create New Visit");
		eMenuItemOne.addActionListener(e -> {
			if(count==1){
				getContentPane().remove(getContentPane().getComponentCount()-1);
			}
			newVisitPanel = new newVisitTab(dummyPerson, controller);
			count++;
			if(Objects.equals(TPAIN.getTitleAt(0), "-------")){
				TPAIN.remove(0);
			}
			//if(!controller.getPregnancy()){//if they dont have an open pregnancy session ###CODE THIS###
				TPAIN.addTab(newVisitPanel.getTitle(), newVisitPanel.getPanel());
				validate();
			//}else{
				//get previous tabs to display and make new subsequent tab
			//}
		});

		JMenuItem eMenuItemTwo = new JMenuItem("Find Previous Visits");

		JMenuItem eMenuItemThree = new JMenuItem("Exit");
		eMenuItemThree.setMnemonic(KeyEvent.VK_E);
		eMenuItemThree.setToolTipText("Exit application");
		eMenuItemThree.addActionListener(controller);
		file.add(eMenuItemOne);
		file.add(eMenuItemTwo);
		file.add(eMenuItemThree);
		menuBar.add(file);

		setJMenuBar(menuBar);
	}

	/**
	 * Removes the current selected tab and fills it with the color gray
	 */
	public static void removeCurrentTab(){
		TPAIN.removeTabAt(TPAIN.getSelectedIndex());
		if(TPAIN.getTabCount()==0){
			fillEmpty();
		}
	}
}
