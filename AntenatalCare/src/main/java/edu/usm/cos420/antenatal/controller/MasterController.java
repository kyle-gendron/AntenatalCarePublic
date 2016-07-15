package edu.usm.cos420.antenatal.controller;

import edu.usm.cos420.antenatal.view.MasterView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kyle on 7/14/2016.
 */
public class MasterController implements ActionListener{

  MasterView view;

  /**
   * displays the main GUI
   */
  public void displayGUI() {
    this.view.setVisible(true);
  }

  public MasterController(){
    view = new MasterView(this);
  }

  public void actionPerformed(ActionEvent e){

    switch(e.getActionCommand()){
      case "Exit": {
        System.exit(0);
        break;
      }
    }

  }

}
