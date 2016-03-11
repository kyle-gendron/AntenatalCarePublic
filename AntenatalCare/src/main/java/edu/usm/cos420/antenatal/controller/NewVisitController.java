package edu.usm.cos420.antenatal.controller;

import edu.usm.cos420.antenatal.gui.NewVisitForm;
import edu.usm.cos420.antenatal.gui.newVisitTab;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by aaron on 3/11/2016.
 */
public class NewVisitController implements ActionListener {
  private final AntenatalController controller;
  private final newVisitTab panel;

  public NewVisitController(AntenatalController controller) {
    this.controller = controller;
    this.panel = new newVisitTab(this);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    switch (e.getActionCommand()) {
      case "Submit": {
        controller.submitForm(this.getForm());
      }
    }
  }

  public JPanel getPanel() {
    return panel.getPanel();
  }

  public NewVisitForm getForm() {
    return panel.getForm();
  }
}
