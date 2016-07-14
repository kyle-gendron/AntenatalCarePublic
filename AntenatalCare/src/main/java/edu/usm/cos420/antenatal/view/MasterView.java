package edu.usm.cos420.antenatal.view;

import javax.swing.*;

/**
 * Created by Kyle on 7/14/2016.
 */
public class MasterView{
  JTabbedPane tabs;

  public MasterView(JFrame consultingFrame, JFrame antenatalFrame){
    tabs.addTab("Consulting Register",consultingFrame);
    tabs.addTab("Antenatal Care", antenatalFrame);
  }

}
