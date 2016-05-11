package edu.usm.cos420.antenatal.controller;

import edu.usm.cos420.antenatal.domain.DummyPerson;
import edu.usm.cos420.antenatal.domain.PregnancyFollowUp;
import edu.usm.cos420.antenatal.domain.PregnancyVisit;
import edu.usm.cos420.antenatal.service.interfaces.IPregnacyVisitService;
import edu.usm.cos420.antenatal.utils.ReportGenerator;
import edu.usm.cos420.antenatal.view.PreviousVisits;
import edu.usm.cos420.antenatal.service.interfaces.IPregnacyFollowUpService;
import edu.usm.cos420.antenatal.service.PregnacyVisitService;
import edu.usm.cos420.antenatal.service.PregnancyFollowUpService;
import edu.usm.cos420.antenatal.view.AntenatalView;

import javax.swing.*;

import com.itextpdf.text.DocumentException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * A controller class for the antenatal forms.
 * It listens for the submit button to be pressed and than grabs
 * the information from the view, and sends it on to be stored.
 */
public class AntenatalController implements ActionListener {

  private final PreviousVisits findPrevious;
  private PregnacyVisitService service;
  private PregnancyFollowUpService subService;
  private AntenatalView view;
  private DummyPerson dummyPerson;
  //private NewVisitTab currentForm;

  /**
   * Constructor initialized the service and GUI
   */
  public AntenatalController() {
    // Dummy person object
    dummyPerson = new DummyPerson();
    this.service = new PregnacyVisitService();
    this.subService = new PregnancyFollowUpService();
    this.view = new AntenatalView(this);

    // Debug Test
    System.out.println("Current Visit Table:");
    service.getAllVisits().forEach(System.out::println);

    // Debug Test
    System.out.println("Sub Visit Table:");
    try {
      subService.getAllSubVisits().forEach(System.out::println);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    // Set up the find previous dialog.
    this.findPrevious = new PreviousVisits(this.view);
  }

  /**
   * displays the main GUI
   */
  public void displayGUI() {
    this.view.setHasPreviousVisits(getVisitList().size() > 0);
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
        (this.view).addNewPregnancy(date, newVisit.getPanel());
        break;
      }
      case "Find Previous Visits": {
        List<String> options = getVisitList();
        if (!options.isEmpty()) {
          String visitId = this.findPrevious.showDialog(options);
          if (visitId != null && !visitId.isEmpty()) {
            PregnancyVisit prevVisit = service.getAntenatalVisitById(visitId);
            System.out.println("Loading: " + prevVisit);
            NewVisitController newVisit = new NewVisitController(this, prevVisit);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            String date = sdf.format(new Date());
            (this.view).addNewPregnancy(date, newVisit.getPanel());

            SubController subController = new SubController(this);
            subController.setId(visitId);
            AntenatalView.clearSub();
            String pregnancyid = prevVisit.getId();

            if (subService.getSubVisitsByPregnancy(pregnancyid).isEmpty()) {
              this.view.addSub("", subController.getTitle());
              this.view.addSub("", subController.getPanel());
              break;
            } else {
              List<PregnancyFollowUp> sub = subService.getSubVisitsByPregnancy(pregnancyid);
              this.view.addSub("", subController.getTitle());
              for (PregnancyFollowUp s : sub) {
                (this.view).addSub("", subController.setPanel(s));
              }
              (this.view).addSub("", subController.getPanel());

            }


          }
        }
        break;
      }
      case "Generate Monthly Report": {
        ReportingController repController = new ReportingController();
        this.view.addReportingWindow(repController);
        break;
      }
      case "Quit": {
        System.exit(0);
        break;
      }
    }
  }

  public DummyPerson getPerson() {
    return dummyPerson;
  }

  public void submitNewVisit(PregnancyVisit visit) {
    System.out.println("Inserting New Visit (" + visit.getId() + ")");
    service.addAntenatalVisit(visit);
    AntenatalView.removeCurrentTab();

    // Update the find previous menu option
    (this.view).setHasPreviousVisits(getVisitList().size() > 0);
  }

  public void updateVisit(PregnancyVisit visit) {
    System.out.println("Updating Visit (" + visit.getId() + ")");
    service.updateAntenatalVisit(visit);
    AntenatalView.removeCurrentTab();
  }

  public String getNextId() {
    return IPregnacyVisitService.getNextID();
  }

  public PregnancyVisit getVisit(String id) {
    return service.getAntenatalVisitById(id);
  }

  public void submitNewSubVisit(PregnancyFollowUp subVisit) {
    System.out.println("Inserting New SubVisit (" + subVisit.getId() + ")");
    try {
      subService.addSubVisit(subVisit);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    AntenatalView.removeCurrentTab();
  }

  public void updateSubVisit(PregnancyFollowUp subVisit) {
    System.out.println("Updating SubVisit (" + subVisit.getId() + ")");
    try {
      subService.updateSubVisit(subVisit);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    AntenatalView.removeCurrentTab();
  }

  public PregnancyFollowUp getSubVisit(String id) {
    try {
      return subService.getSubVisitById(id);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return new PregnancyFollowUp();
  }

  public String getNextSubId() {
    return IPregnacyFollowUpService.getNextID();
  }

  public List<String> getVisitList() {
    return service.getAllVisits().stream().map(PregnancyVisit::getId).collect(Collectors.toList());
  }

  public JPanel getView() {
    return (JPanel) this.view.getContentPane();
  }
}
