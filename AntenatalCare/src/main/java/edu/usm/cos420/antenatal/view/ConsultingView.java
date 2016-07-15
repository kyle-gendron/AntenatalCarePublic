package edu.usm.cos420.antenatal.view;

import edu.usm.cos420.antenatal.controller.ConsultingController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Kyle on 7/14/2016.
 */
public class ConsultingView extends JPanel {

  ConsultingController controller;

  /*
  Standard Consttructor
   */
  public ConsultingView(ConsultingController controller){

    this.controller = controller;
    initUI();
  }

  public void initUI() {

    setSize(900, 900);
    setMinimumSize(new Dimension(750, 700));
    JPanel pane = new JPanel();
    pane.setLayout(new BorderLayout());
    pane.setSize(this.getSize());
    createMenuBar(pane);

    setMinimumSize(new Dimension(750, 700));

    add(pane, BorderLayout.NORTH);
  }

  /**
   * Creates the menu bar across the top of the screen to give selectable options
   */
  private void createMenuBar(Container pane) {
    JMenuBar menuBar = new JMenuBar();

    JMenu file = new JMenu("Consulting Options");
    file.setMnemonic(KeyEvent.VK_F);

    JMenuItem createNewPersonMenuItem = new JMenuItem("Add New Client");
    JMenuItem exitMenuItem = new JMenuItem("Exit");
    JMenuItem findPreviousVisitsMenuItem = new JMenuItem("Find Previous Client");

    exitMenuItem.setMnemonic(KeyEvent.VK_E);
    exitMenuItem.setToolTipText("Exit application");

    createNewPersonMenuItem.addActionListener(controller);
    findPreviousVisitsMenuItem.addActionListener(controller);
    exitMenuItem.addActionListener(controller);

    file.add(createNewPersonMenuItem);
    file.add(findPreviousVisitsMenuItem);
    file.addSeparator();
    file.add(exitMenuItem);
    menuBar.add(file);

    pane.add(menuBar, BorderLayout.WEST);
    pane.validate();
  }

}
