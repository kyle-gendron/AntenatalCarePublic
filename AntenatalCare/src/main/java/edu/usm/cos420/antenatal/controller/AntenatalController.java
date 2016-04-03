package edu.usm.cos420.antenatal.controller;

import edu.usm.cos420.antenatal.domain.AntenatalSubVisit;
import edu.usm.cos420.antenatal.domain.AntenatalVisit;
import edu.usm.cos420.antenatal.domain.DummyPerson;
import edu.usm.cos420.antenatal.gui.VisitForm;
import edu.usm.cos420.antenatal.gui.PreviousVisits;
import edu.usm.cos420.antenatal.gui.newVisitTab;
import edu.usm.cos420.antenatal.gui.subsequentVisit;
import edu.usm.cos420.antenatal.service.AntenatalService;
import edu.usm.cos420.antenatal.service.SubVisitService;
import edu.usm.cos420.antenatal.service.impl.AntenatalService1;
import edu.usm.cos420.antenatal.service.impl.SubVisitService1;
import edu.usm.cos420.antenatal.view.impl.AntenatalView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
	private AntenatalService1 service;
	private SubVisitService1 subService;
	private AntenatalView view;
	private DummyPerson dummyPerson;
	//private newVisitTab currentForm;

	/**
	 * Constructor initialized the service and GUI
	 */
	public AntenatalController() {
		// Dummy person object
		dummyPerson = new DummyPerson();

		this.service = new AntenatalService1();
		this.subService = new SubVisitService1();
		this.view = new AntenatalView(this);

		// Debug Test
		System.out.println("Current Visit Table:");
		service.getAllVisits().forEach(System.out::println);

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
			this.view.addTab(date, newVisit.getPanel());
			break;
		}
		case "Find Previous Visits": {
			List<String> options = getVisitList();
			if(!options.isEmpty()){
				String visitId = this.findPrevious.showDialog(options);
				if (visitId != null && !visitId.isEmpty()) {
					AntenatalVisit prevVisit = service.getAntenatalVisitById(visitId);
					System.out.println("Loading: " + prevVisit);
					NewVisitController newVisit = new NewVisitController(this, prevVisit);
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String date = sdf.format(new Date());
					this.view.addTab(date, newVisit.getPanel());
	             SubController subController = new SubController(this);
	               subController.setId(visitId);
	               this.view.addSub("", subController.getPanel());
				}
			}
			break;
		}
		case "Quit":{
			System.exit(0);
			break;
		}
		}
	}

	public DummyPerson getPerson() {
		return dummyPerson;
	}

	public void submitNewVisit(AntenatalVisit visit) {
		System.out.println("Inserting New Visit (" + visit.getID() + ")");
		service.addAntenatalVisit(visit);

    // Update the find previous menu option
    this.view.setHasPreviousVisits(getVisitList().size() > 0);
	}

	public void updateVisit(AntenatalVisit visit) {
		System.out.println("Updating Visit (" + visit.getID() + ")");
		service.updateAntenatalVisit(visit);
	}

	public String getNextId() {
		return AntenatalService.getNextID();
	}
	
	  public void submitNewSubVisit(AntenatalSubVisit subVisit) {
	      System.out.println("Inserting New SubVisit (" + subVisit.getID() + ")");
	      subService.addSubVisit(subVisit);
	  }

	   public void updateSubVisit(AntenatalSubVisit subVisit) {
	      System.out.println("Updating SubVisit (" + subVisit.getID() + ")");
	      subService.updateSubVisit(subVisit);
	   }

	   public String getNextSubId() {
	      return SubVisitService.getNextID();
	   }

  public List<String> getVisitList() {
    return service.getAllVisits().stream().map(AntenatalVisit::getID).collect(Collectors.toList());
  }
}
