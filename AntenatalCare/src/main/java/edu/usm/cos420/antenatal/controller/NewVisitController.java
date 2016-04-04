package edu.usm.cos420.antenatal.controller;

import edu.usm.cos420.antenatal.domain.PregnancyRecord;
import edu.usm.cos420.antenatal.gui.VisitForm;
import edu.usm.cos420.antenatal.gui.newVisitTab;
import edu.usm.cos420.antenatal.view.impl.AntenatalView;
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

	public NewVisitController(AntenatalController controller, PregnancyRecord visitInfo) {
		this(controller);
		this.id = visitInfo.getID();

		// Refactor this?
		this.panel.setFormData(visitInfo);

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Submit": {

			VisitForm form = panel.getForm();
			//verify fields
			if(verifyFields(form) == true){
				PregnancyRecord visit = getVisitObject();
				if (id == null){
					String nextId = controller.getNextId();
					visit.setId(nextId);
					controller.submitNewVisit(visit);
					AntenatalView.removeCurrentTab();
				}
				else{
					visit.setId(id);
					controller.updateVisit(visit);
				}
			}else{//if invalid
				System.out.println("Required fields are not valid.");
			}

		}
		}
	}

	public static boolean verifyFields(VisitForm form){
		//holds the window view word contents
		String errorMessage = "<html><div style='text-align=center;'>Invalid Data Entries: <br>";
		Boolean errorsExist = false;

		//test blood pressure sys/dia
		//sys
		if(form.getSystolicBP() <= 0){
			errorsExist = true;
			errorMessage += "-Invalid Systolic Blood Pressure<br>";
		}
		//dia
		if(form.getDiastolicBP() <= 0){
			errorsExist = true;
			errorMessage += "-Invalid Diastolic Blood Pressure<br>";
		}

		//test weight
		if(form.getPatientWeight() <= 0){
			errorsExist = true;
			errorMessage += "-Invalid Patient Height<br>";
		}

		//test height
		if(form.getPatientHeight() <= 0){
			errorsExist = true;
			errorMessage += "-Invalid Patient Weight<br>";
		}

		//test more specific things

		//if pos sickle cell ensure type is selected
		if(form.getSicklingStatus().equals("Positive") && form.getSicklingType().equals("")){
			errorsExist = true;
			errorMessage += "-Please Add Sickling Type, or select N/A";
		}

		//TODO: Add more error messages

		//if error found produce pop up
		if(errorsExist == true){
			//TODO: Remove once everything works okay
			//JOptionPane.showMessageDialog(null, errorMessage);

			form.errorMessage(errorMessage);
			return false;
		}
		return true;
	}

	public JPanel getPanel() {
		return panel.getPanel();
	}

	public PregnancyRecord getVisitObject() {
		VisitForm form = panel.getForm();
		return new PregnancyRecord(form);
	}
}
