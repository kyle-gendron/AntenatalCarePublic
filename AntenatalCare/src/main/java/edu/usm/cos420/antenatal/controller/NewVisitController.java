package edu.usm.cos420.antenatal.controller;

import edu.usm.cos420.antenatal.domain.AntenatalVisit;
import edu.usm.cos420.antenatal.gui.VisitForm;
import edu.usm.cos420.antenatal.gui.newVisitTab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

/**
 * Created by aaron on 3/11/2016.
 */
public class NewVisitController implements ActionListener {
  private final AntenatalController controller;
  private final newVisitTab panel;
  private String id = null;

  public NewVisitController(AntenatalController controller) {
    this.controller = controller;
    this.panel = new newVisitTab(this);
  }

  public NewVisitController(AntenatalController controller, AntenatalVisit visitInfo) {
    this(controller);
    this.id = visitInfo.getID();

    // Refactor this?
    this.panel.setFormData(visitInfo);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "Submit": {
        AntenatalVisit visit = getVisitObject();

        if (id == null){
          String nextId = controller.getNextId();
          visit.setId(nextId);
          controller.submitNewVisit(visit);
        }
        else{
          visit.setId(id);
          controller.updateVisit(visit);
        }
      }
    }
  }

  public JPanel getPanel() {
    return panel.getPanel();
  }

  public AntenatalVisit getVisitObject() {

    VisitForm form = panel.getForm();
    Integer parity = form.getParity();
    String testResult = form.getHIVTestResults();
    Double height = form.getPatientHeight();
    Double weight = form.getPatientWeight();
    String reactive = form.getVDLabResults();
    LocalDate EDD = form.getEDD();

    return new AntenatalVisit(null, parity, 0, 0, height, weight, 0, 0, EDD,
      0, 0, "", "", "", reactive, "", testResult, "", "", 0, 0, 0, 0, 0, 0);
  }
}
