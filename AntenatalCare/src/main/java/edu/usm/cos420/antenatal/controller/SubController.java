package edu.usm.cos420.antenatal.controller;

/**
 * Created by aaron on 3/11/2016.
 */


import edu.usm.cos420.antenatal.domain.AntenatalSubVisit;
import edu.usm.cos420.antenatal.domain.AntenatalVisit;
import edu.usm.cos420.antenatal.gui.newVisitTab;
import edu.usm.cos420.antenatal.gui.subsequentVisit;
import edu.usm.cos420.antenatal.service.SubVisitService;
import edu.usm.cos420.antenatal.service.impl.SubVisitService1;
import edu.usm.cos420.antenatal.view.impl.AntenatalView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JPanel;

/**
 * A controller class for the antenatal forms.
 * It listens for the submit button to be pressed and than grabs
 * the information from the view, and sends it on to be stored.
 */
public class SubController implements ActionListener {

  private SubVisitService1 service;
  private final AntenatalController controller;
  private subsequentVisit panel;
  private String id = null;

  /**
   * Constructor initialized the service and GUI
   */
  public SubController(AntenatalController controller) {
    this.service = new SubVisitService1();
    this.controller = controller;
    this.panel = new subsequentVisit(this);

    // Debug Test
    System.out.println("Sub Visit Table:");
    service.getAllSubVisits().forEach(System.out::println);
  }
  
  public JPanel getPanel(){
     return panel.getPanel();
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

        //NewVisitForm form = this.view.getVisitPanel().getForm();
        
        //TODO: get the rest of the information from the gui
        

        String subId = SubVisitService.getNextID();
        
        // Create a new Visit object to pass to the service class.
        AntenatalSubVisit visit = new AntenatalSubVisit(subId,"", 0, 0, 0, 0, false, false);
        
        
        
        //doesn't do anything right now
        service.addSubVisit(visit);
        System.out.println("Inserted New Visit (" + subId + ")");
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
