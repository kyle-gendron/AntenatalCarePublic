package edu.usm.cos420.antenatal.view.impl;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.Objects;

import javax.swing.*;

import edu.usm.cos420.antenatal.controller.AntenatalController;
import edu.usm.cos420.antenatal.controller.SubController;
import edu.usm.cos420.antenatal.gui.consultingData;

/**
 * Creates the simple consulting view across the top
 * adds a place for the antenatal visit tab
 * and puts them together in one frame
 */
public class AntenatalView extends JFrame {

	private AntenatalController controller;
	private static JTabbedPane tPain;
	private static JScrollPane sPain;
	private static JPanel newPane;
	private static JPanel subPane;
	private static JSplitPane split;
	private SubController subController;
	private JMenuItem findPreviousVisitsMenuItem;
	private JMenuItem showSubVisitsMenuItem;

	/**
	 * Adds the controller so that it can be accessed by the panel
	 *
	 * @param antenatalController : the antenatal controller
	 */
	public AntenatalView(AntenatalController antenatalController) {
		this.controller = antenatalController;
		initUI();
	}

	public AntenatalView(SubController subController) {
		this.subController = subController;
	}

	/**
	 * initializes the user interface
	 */
	private void initUI() {


		Container pane = getContentPane();
		createMenuBar();

		newPane = new JPanel();
		subPane = new JPanel();

		BorderLayout border = new BorderLayout();
		newPane.setLayout(border);
		BorderLayout subBorder = new BorderLayout();
		subPane.setLayout(subBorder);
		newPane.setMinimumSize(new Dimension(600,500));




		JButton quitButton = new JButton();
		quitButton = makeQuitButton(newPane);


		makeTabbedDisplay(newPane);
		newPane.add(quitButton, BorderLayout.SOUTH);

		JPanel panel = new JPanel();

		makeScrollDisplay(panel);
		JTabbedPane title = new JTabbedPane();
		title.addTab("Subsequent Visits", sPain);
		subPane.add(title);

		split = new JSplitPane(JSplitPane.VERTICAL_SPLIT,newPane,subPane);
		split.setDividerLocation(getHeight()-300);
		pane.add(split);


		setTitle("Antenatal Care");
		setMinimumSize(new Dimension(750, 700));
		setSize(1170,750);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

	private void makeScrollDisplay(JPanel panel) {
		sPain = new JScrollPane(panel);
		JLabel sub = new JLabel("SubSequent Visits:");
		sub.setFont(new Font("Courier New",Font.BOLD, 14));


		sPain.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		sPain.setViewportBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

		//panel.setBackground(Color.LIGHT_GRAY);
		panel.validate();
	}

	private JButton makeQuitButton(Container newPane) {
		JButton quitButton = new JButton("Quit");
		quitButton.setSize(newPane.getWidth() / 2, 20);
		quitButton.setToolTipText("Quit button");
		quitButton.setMnemonic(KeyEvent.VK_Q);
		quitButton.addActionListener(controller);
		return quitButton;
	}

	private void makeTabbedDisplay(Container pane) {
		tPain = new JTabbedPane();

		fillEmpty();

		tPain.setTabPlacement(JTabbedPane.TOP);
		tPain.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);

		pane.setBackground(Color.LIGHT_GRAY);

		consultingData holdData = new consultingData();
		holdData.setMinimumSize(new Dimension(600,600));
		pane.add(createSplitData(holdData), BorderLayout.CENTER);

	}

	/**
	 * Creates a divider between the consulting data and other data
	 *
	 * @param holdData current person data panel
	 * @return returns a divider in the form
	 */
	private Component createSplitData(consultingData holdData) {
		JSplitPane split = new JSplitPane(JSplitPane.VERTICAL_SPLIT, holdData.getPanel(controller.getPerson()), tPain);
		split.setResizeWeight(0.30);
		split.setDividerLocation(130);
		return split;
	}

	/**
	 * Files in empty space with a color and "--------"
	 */
	private static void fillEmpty() {
		JPanel fill = new JPanel();
		fill.setBackground(Color.LIGHT_GRAY);
		tPain.addTab("-------", fill);
	}

	private int count = 1;

	/**
	 * Creates the menu bar across the top of the screen to give selectable options
	 */
	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();

		JMenu file = new JMenu("Antenatal");
		file.setMnemonic(KeyEvent.VK_F);

		JMenuItem createNewVisitMenuItem = new JMenuItem("Create New Visit");
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		findPreviousVisitsMenuItem = new JMenuItem("Find Previous Visits");

		exitMenuItem.setMnemonic(KeyEvent.VK_E);
		exitMenuItem.setToolTipText("Exit application");

		createNewVisitMenuItem.addActionListener(controller);
		findPreviousVisitsMenuItem.addActionListener(controller);
		exitMenuItem.addActionListener(controller);

		file.add(createNewVisitMenuItem);
		file.add(findPreviousVisitsMenuItem);
		file.add(exitMenuItem);
		menuBar.add(file);

		setJMenuBar(menuBar);
	}

	/**
	 * Removes the current selected tab and fills it with the color gray
	 */
	public static void removeCurrentTab() {
		tPain.removeTabAt(tPain.getSelectedIndex());
		if (tPain.getTabCount() == 0) {
			fillEmpty();
		}
	}

	/**
	 * Adds the given panel to the tabbed pane.
	 * @param title tab name
	 * @param panel panel to attach to the pane.
	 */
	public void addTab(String title, JPanel panel) {
		if (count == 1) {
			newPane.remove(newPane.getComponentCount() - 1);
		}

		count++;
		if (Objects.equals(tPain.getTitleAt(0), "-------")) {
			tPain.remove(0);
		}
		//if(!controller.getPregnancy()){//if they don't have an open pregnancy session ###CODE THIS###
		panel.setMinimumSize(new Dimension(600,650));
		tPain.addTab(title, panel);
		validate();
		//}else{
		//get previous tabs to display and make new subsequent tab
		//}
	}
	public void addSub(String title,JPanel panel){
	   if(split.getDividerLocation()==0){
         split.setDividerLocation(300);
         subPane.setMinimumSize(new Dimension(200,600));
         subPane.setSize(new Dimension(225,600));
      }
      JPanel subView = panel;
      JLabel name = new JLabel(title);
      JPanel P = ((JPanel) sPain.getViewport().getView());
      P.setLayout(new BoxLayout(P,BoxLayout.PAGE_AXIS));
      P.add(name);
      P.add(subView);
	  P.add( new Box.Filler(new Dimension(800,10),new Dimension(800,10),new Dimension(800,10)));
	  subPane.validate();
	}

	public void setHasPreviousVisits(boolean hasPreviousVisits) {
		findPreviousVisitsMenuItem.setEnabled(hasPreviousVisits);
	}
}
