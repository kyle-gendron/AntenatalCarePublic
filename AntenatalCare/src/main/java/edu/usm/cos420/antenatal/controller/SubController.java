package edu.usm.cos420.antenatal.controller;

/**
 * Created by aaron on 3/11/2016.
 */

import edu.usm.cos420.antenatal.domain.PregnancyVisit;
import edu.usm.cos420.antenatal.domain.PregnancyFollowUp;
import edu.usm.cos420.antenatal.gui.SubsequentVisit;
import edu.usm.cos420.antenatal.service.SubVisitService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * A controller class for the antenatal forms.
 * It listens for the submit button to be pressed and than grabs
 * the information from the view, and sends it on to be stored.
 */
public class SubController implements ActionListener {

  //private SubVisitService1 service;
  private final AntenatalController controller;
  private final SubsequentVisit panel;
  private String id = null;

  /**
   * Constructor initialized the service and GUI
   */
  public SubController(AntenatalController controller) {
    this.controller = controller;
    this.panel = new SubsequentVisit(this);
    //this.service = new SubVisitService1();
  }


  public JPanel getTitle() {
    return panel.getTitle();
  }

  public JPanel getPanel() {
    return panel.getPanel();
  }

  public JPanel setPanel(PregnancyFollowUp subVisit) {
    return panel.setForm(subVisit);
  }

  public void setId(String ID) {
    id = ID;
  }

  @Override
  /**
   * listens for the form to quit or be submitted
   * @params e : an ActionEvent that it lists to
   */
  public void actionPerformed(ActionEvent e) {

    switch (e.getActionCommand()) {
      case "Save": {
        LocalDate date = panel.getApptDate();
        int sysBP = panel.getSystolicBP();
        int diaBP = panel.getDiastolicBP();
        double fH = panel.getFundalHeight();
        double weight = panel.getPatientWeight();
        String bloodFilm = panel.getBloodFilm();
        String refer = panel.getRefer();
        String subId = SubVisitService.getNextID();

        // Create a new Visit object to pass to the service class.
        PregnancyFollowUp visit = new PregnancyFollowUp(subId, id, sysBP, diaBP,
          weight, fH, date, bloodFilm, refer);

        PregnancyVisit initVisit = controller.getVisit(id);
        initVisit.setSubID(subId);
        controller.updateVisit(initVisit);
        controller.submitNewSubVisit(visit);
        System.out.println("Inserted New SubVisit (" + subId + ")");

      }
    }
  }
}
