package edu.usm.cos420.antenatal.controller;

import edu.usm.cos420.antenatal.domain.AntenatalVisit;
import edu.usm.cos420.antenatal.gui.NewVisitForm;
import edu.usm.cos420.antenatal.service.AntenatalService;
import edu.usm.cos420.antenatal.service.impl.AntenatalService1;
import edu.usm.cos420.antenatal.view.impl.AntenatalView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

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

    // Debug Test
    System.out.println("Current Visit Table:");
    service.getAllVisits().forEach(System.out::println);
  }

  /**
   * display the GUI
   */
  public void displayGUI() {
    this.view.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    switch (e.getActionCommand()) {
      case "Exit": {
        System.exit(0);
        break;
      }
      case "Submit": {

        NewVisitForm form = this.view.getVisitPanel().getForm();

        Integer parity = parseInteger(form.getParity(), 0);
        boolean testResult = form.getTestResult() > 0;
        Double height = parseDouble(form.getPatientHeight(), 0);
        Double weight = parseDouble(form.getPatientWeight(), 0);

        String nextId = AntenatalService.getNextID();
        // Create a new Visit object to pass to the service class.
        AntenatalVisit visit = new AntenatalVisit(nextId,
          parity, 0, 0, height, weight, 0, 0, (GregorianCalendar) GregorianCalendar.getInstance(),
          0, 0, "", "", "", testResult, false, false, false, false, 0, 0, 0, false, 0, 0);

        service.addAntenatalVisit(visit);
        System.out.println("Inserted New Visit (" + nextId + ")");
      }
    }
  }

  public static int parseInteger( String string, int defaultValue ) {
    try {
      return Integer.parseInt(string);
    }
    catch (NumberFormatException e ) {
      return defaultValue;
    }
  }

  public static double parseDouble( String string, double defaultValue ) {
    try {
      return Double.parseDouble(string);
    }
    catch (NumberFormatException e ) {
      return defaultValue;
    }
  }
}
