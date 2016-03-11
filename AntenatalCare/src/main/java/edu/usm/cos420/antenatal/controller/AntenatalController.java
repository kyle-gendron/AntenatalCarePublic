package edu.usm.cos420.antenatal.controller;

import edu.usm.cos420.antenatal.domain.AntenatalVisit;
import edu.usm.cos420.antenatal.domain.DummyPerson;
import edu.usm.cos420.antenatal.gui.NewVisitForm;
import edu.usm.cos420.antenatal.gui.PreviousVisits;
import edu.usm.cos420.antenatal.gui.newVisitTab;
import edu.usm.cos420.antenatal.service.AntenatalService;
import edu.usm.cos420.antenatal.service.impl.AntenatalService1;
import edu.usm.cos420.antenatal.view.impl.AntenatalView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A controller class for the antenatal forms.
 * It listens for the submit button to be pressed and than grabs
 * the information from the view, and sends it on to be stored.
 */
public class AntenatalController implements ActionListener {

  private final PreviousVisits findPrevious;
  private AntenatalService1 service;
  private AntenatalView view;
  private DummyPerson dummyPerson;
  private newVisitTab currentForm;

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

    // Set up the find previous dialog.
    this.findPrevious = new PreviousVisits(this.view);
  }

  private void loadPreviousVisit(String visitId) {

  }

  /**
   * displays the main GUI
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
      case "Create New Visit": {
        NewVisitController newVisit = new NewVisitController(this);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String date = sdf.format(new Date());
        this.view.addTab(date, newVisit.getPanel());
        break;
      }
      case "Find Previous Visits": {
        List<String> options = service.getAllVisits().stream().map(AntenatalVisit::getID).collect(Collectors.toList());
        String visitId = this.findPrevious.showDialog(options);
        loadPreviousVisit(visitId);
        break;
      }
    }
  }

  public DummyPerson getPerson() {
    return dummyPerson;
  }

  public void submitForm(NewVisitForm form) {
//        TODO: get the rest of the information from the gui
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

        service.addAntenatalVisit(visit);
        System.out.println("Inserted New Visit (" + nextId + ")");
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
