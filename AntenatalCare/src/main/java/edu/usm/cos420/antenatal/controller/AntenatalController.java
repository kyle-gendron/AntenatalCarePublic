package edu.usm.cos420.antenatal.controller;

import edu.usm.cos420.antenatal.domain.AntenatalSubVisit;
import edu.usm.cos420.antenatal.domain.PregnancyRecord;
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

import javax.swing.JFrame;
import javax.swing.JPanel;

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

		// Debug Test
		System.out.println("Sub Visit Table:");
		subService.getAllSubVisits().forEach(System.out::println);

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
			this.view.addNewPregnancy(date, newVisit.getPanel());
			break;
		}
		case "Find Previous Visits": {
			List<String> options = getVisitList();
			if(!options.isEmpty()){
				String visitId = this.findPrevious.showDialog(options);
				if (visitId != null && !visitId.isEmpty()) {
					PregnancyRecord prevVisit = service.getAntenatalVisitById(visitId);
					System.out.println("Loading: " + prevVisit);
					NewVisitController newVisit = new NewVisitController(this, prevVisit);
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String date = sdf.format(new Date());
					this.view.addNewPregnancy(date, newVisit.getPanel());

					SubController subController = new SubController(this);
					subController.setId(visitId);
					AntenatalView.clearSub();

					if(prevVisit.getSubIDs().isEmpty()){
						this.view.addSub("", subController.getTitle());
						this.view.addSub("", subController.getPanel());
						break;
					} else {
						List<String> subIDs = prevVisit.getSubIDs();
						this.view.addSub("", subController.getTitle());
						for(String id: subIDs){
							AntenatalSubVisit subVisit = subService.getSubVisitById(id);
							this.view.addSub("", subController.setPanel(subVisit));
						}
						this.view.addSub("", subController.getPanel());

					}


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

	public void submitNewVisit(PregnancyRecord visit) {
		System.out.println("Inserting New Visit (" + visit.getID() + ")");
		service.addAntenatalVisit(visit);
    AntenatalView.removeCurrentTab();

		// Update the find previous menu option
		this.view.setHasPreviousVisits(getVisitList().size() > 0);
	}

	public void updateVisit(PregnancyRecord visit) {
		System.out.println("Updating Visit (" + visit.getID() + ")");
		service.updateAntenatalVisit(visit);
    AntenatalView.removeCurrentTab();
	}

	public String getNextId() {
		return AntenatalService.getNextID();
	}

	public PregnancyRecord getVisit(String id){
		return service.getAntenatalVisitById(id);
	}

	public void submitNewSubVisit(AntenatalSubVisit subVisit) {
		System.out.println("Inserting New SubVisit (" + subVisit.getID() + ")");
		subService.addSubVisit(subVisit);
    AntenatalView.removeCurrentTab();
	}

	public void updateSubVisit(AntenatalSubVisit subVisit) {
		System.out.println("Updating SubVisit (" + subVisit.getID() + ")");
		subService.updateSubVisit(subVisit);
    AntenatalView.removeCurrentTab();
	}

	public AntenatalSubVisit getSubVisit(String id){
		return subService.getSubVisitById(id);
	}

	public String getNextSubId() {
		return SubVisitService.getNextID();
	}

	public List<String> getVisitList() {
		return service.getAllVisits().stream().map(PregnancyRecord::getID).collect(Collectors.toList());
	}
	
	public AntenatalView getView(){
	   return this.view;
	}
}
