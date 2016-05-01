package edu.usm.cos420.antenatal.controller;

import edu.usm.cos420.antenatal.domain.PregnancyVisit;
import edu.usm.cos420.antenatal.view.NewVisitTab;
import edu.usm.cos420.antenatal.view.VisitForm;
import edu.usm.cos420.antenatal.view.AntenatalView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aaron on 3/11/2016.
 */
public class NewVisitController implements ActionListener {
  private final AntenatalController controller;
  private final NewVisitTab panel;
  private String id = null;

  public NewVisitController(AntenatalController controller) {
    this.controller = controller;
    this.panel = new NewVisitTab(this);
  }

  public NewVisitController(AntenatalController controller, PregnancyVisit visitInfo) {
    this(controller);
    this.id = visitInfo.getId();

    // Refactor this?
    this.panel.setFormData(visitInfo);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "Submit": {

        VisitForm form = panel.getForm();
        //verify fields
          PregnancyVisit visit = getVisitObject();
          if (id == null) {
            String nextId = controller.getNextId();
            visit.setId(nextId);
            controller.submitNewVisit(visit);
            AntenatalView.removeCurrentTab();
          } else {
            visit.setId(id);
            controller.updateVisit(visit);
          }
      }
    }
  }

  public JPanel getPanel() {
    return panel.getPanel();
  }

  public PregnancyVisit getVisitObject() {
    VisitForm form = panel.getForm();
    return new PregnancyVisit(form);
  }
}
