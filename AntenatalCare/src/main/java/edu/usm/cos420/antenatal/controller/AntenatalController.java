package edu.usm.cos420.antenatal.controller;

import edu.usm.cos420.antenatal.gui.NewVisitForm;
import edu.usm.cos420.antenatal.service.impl.AntenatalService1;
import edu.usm.cos420.antenatal.view.impl.AntenatalView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A Controller class
 */
public class AntenatalController implements ActionListener {

  private AntenatalService1 service;
  private AntenatalView view;

  /**
   * Constructor initialized the service and GUI
   */
  public AntenatalController() {
    this.service = new AntenatalService1();
    this.view = new AntenatalView(this);
  }

  /**
   * display the GUI
   */
  public void displayGUI() {
    this.view.setVisible(true);
  }

  @Override
  /**
   * listens for the form to quit or be submitted
   * @params e : an ActionEvent that it lists to
   */
  public void actionPerformed(ActionEvent e) {

    switch (e.getActionCommand()) {
      case "Exit": {
        System.exit(0);
        break;
      }
      case "Submit": {

        NewVisitForm form = this.view.getVisitPanel().getForm();

        String parity = form.getParity();
        System.out.println("Parity: " + parity);

        String testResult = form.getTestResult();
        System.out.println("Test-Result: " + testResult);

        String height = form.getPatientHeight();
        System.out.println("Height: " + height);

        String weight = form.getPatientWeight();
        System.out.println("Weight: " + weight);

      }
    }
  }
}
