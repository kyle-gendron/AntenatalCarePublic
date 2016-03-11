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
import edu.usm.cos420.antenatal.gui.consultingData;

/**
 * Creates the simple consulting view across the top
 * adds a place for the antenatal visit tab
 * and puts them together in one frame
 */
public class AntenatalView extends JFrame {

  private AntenatalController controller;
  private static JTabbedPane tPain;

  /**
   * Adds the controller so that it can be accessed by the panel
   *
   * @param antenatalController : the antenatal controller
   */
  public AntenatalView(AntenatalController antenatalController) {
    this.controller = antenatalController;
    initUI();
  }

  /**
   * initializes the user interface
   */
  private void initUI() {
    Container pane = getContentPane();
    BorderLayout border = new BorderLayout();
    pane.setLayout(border);

    createMenuBar();

    JButton quitButton = new JButton("Quit");
    quitButton.setSize(pane.getWidth() / 2, 20);
    quitButton.setToolTipText("Quit button");
    quitButton.setMnemonic(KeyEvent.VK_Q);
    quitButton.addActionListener(controller);

    tPain = new JTabbedPane();

    fillEmpty();

    tPain.setTabPlacement(JTabbedPane.TOP);
    tPain.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);

    pane.setBackground(Color.LIGHT_GRAY);

    consultingData holdData = new consultingData();

    pane.add(createSplitData(holdData), BorderLayout.CENTER);
    pane.add(quitButton, BorderLayout.SOUTH);

    setTitle("MoTech");
    setSize(800, 700);
    setMinimumSize(new Dimension(800, 625));
    setLocationRelativeTo(null);
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
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
    split.setDividerLocation(160);
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

    JMenuItem eMenuItemOne = new JMenuItem("Create New Visit");
    JMenuItem eMenuItemTwo = new JMenuItem("Find Previous Visits");
    JMenuItem eMenuItemThree = new JMenuItem("Exit");

    eMenuItemThree.setMnemonic(KeyEvent.VK_E);
    eMenuItemThree.setToolTipText("Exit application");

    eMenuItemOne.addActionListener(controller);
    eMenuItemTwo.addActionListener(controller);
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
      getContentPane().remove(getContentPane().getComponentCount() - 1);
    }

    count++;
    if (Objects.equals(tPain.getTitleAt(0), "-------")) {
      tPain.remove(0);
    }
    //if(!controller.getPregnancy()){//if they don't have an open pregnancy session ###CODE THIS###
    tPain.addTab(title, panel);
    validate();
    //}else{
    //get previous tabs to display and make new subsequent tab
    //}
  }
}
