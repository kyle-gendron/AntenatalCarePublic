package edu.usm.cos420.antenatal.view;

import edu.usm.cos420.antenatal.controller.AntenatalController;
import edu.usm.cos420.antenatal.controller.ConsultingController;
import edu.usm.cos420.antenatal.controller.MasterController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kyle on 7/14/2016.
 */
public class MasterView extends JFrame{
  MasterController controller;
  JTabbedPane tabbedPane;

  public MasterView(MasterController controller){
    this.controller = controller;
    tabbedPane = new JTabbedPane();
    tabbedPane.addTab("Consulting Register", new ConsultingView(new ConsultingController()));
    //tabbedPane.addTab("Antenatal Care", new AntenatalView(new AntenatalController()));
    add(tabbedPane);

    //adjust master window settings
    windowSettings();

    setVisible(true);
  }

  /**
   * Helper method that adjust all master window settings
   */
  public void windowSettings(){
    setSize(900, 900);
    setMinimumSize(new Dimension(750, 700));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

}
