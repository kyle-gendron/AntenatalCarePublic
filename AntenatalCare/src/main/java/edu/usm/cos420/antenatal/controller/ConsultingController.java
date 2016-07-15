package edu.usm.cos420.antenatal.controller;

import edu.usm.cos420.antenatal.view.ConsultingView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kyle on 7/14/2016.
 */
public class ConsultingController implements ActionListener {

  ConsultingView view;

  public ConsultingController(){
    view = new ConsultingView(this);
  }

  /**
   * displays the main GUI
   */
  public void displayGUI() {
    this.view.setVisible(true);
  }

  public void actionPerformed(ActionEvent e){

    switch(e.getActionCommand()){

    }

  }

}
