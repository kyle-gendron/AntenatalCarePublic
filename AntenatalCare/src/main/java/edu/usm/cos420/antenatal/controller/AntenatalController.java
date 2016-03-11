package edu.usm.cos420.antenatal.controller;

import edu.usm.cos420.antenatal.domain.AntenatalVisit;
import edu.usm.cos420.antenatal.domain.DummyPerson;
import edu.usm.cos420.antenatal.gui.NewVisitForm;
import edu.usm.cos420.antenatal.service.AntenatalService;
import edu.usm.cos420.antenatal.service.impl.AntenatalService1;
import edu.usm.cos420.antenatal.view.impl.AntenatalView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.GregorianCalendar;

/**
 * A controller class for the antenatal forms.
 * It listens for the submit button to be pressed and than grabs
 * the information from the view, and sends it on to be stored.
 */
public class AntenatalController implements ActionListener {

  private AntenatalService1 service;
  private AntenatalView view;
  private DummyPerson dummyPerson;

  /**
   * Constructor initialized the service and GUI
   */
  public AntenatalController() {
    // Dummy person object
    dummyPerson = new DummyPerson();

    this.service = new AntenatalService1();
    this.view = new AntenatalView(this);

    // Debug Test
    System.out.println("Current Visit Table:");
    service.getAllVisits().forEach(System.out::println);
  }

  /**
   * displays the GUI
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

  public DummyPerson getPerson() {
    return dummyPerson;
  }

        NewVisitForm form = this.view.getVisitPanel().getForm();
        
        //TODO: get the rest of the information from the gui
        Integer parity = form.getParity();
        boolean testResult = form.getTestResult() > 0;
        Double height = form.getPatientHeight();
        Double weight = form.getPatientWeight();
        boolean reactive = form.getVDLabResults();
        LocalDate EDD = form.getEDD();

        String nextId = AntenatalService.getNextID();
        
        // Create a new Visit object to pass to the service class.
        AntenatalVisit visit = new AntenatalVisit(nextId,
          parity, 0, 0, height, weight, 0, 0, EDD,
          0, 0, "", "", "", reactive, false, testResult, false, false, 0, 0, 0, false, 0, 0);
        
        
        
        //doesn't do anything right now
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
