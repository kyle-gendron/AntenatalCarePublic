package edu.usm.cos420.antenatal.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.*;

import edu.usm.cos420.antenatal.controller.NewVisitController;
import edu.usm.cos420.antenatal.domain.AntenatalVisit;
import edu.usm.cos420.antenatal.view.impl.AntenatalView;

/**
 * Sets up the basics of the new empty antenatal visit frame
 * and sends it to create a new visit form which ads in the necessary fields
 * and then displays it within the existing frame as a new tabbed named
 * after todays date
 */
public class newVisitTab extends JPanel {

	JPanel Pane;
	private VisitForm form;
	private JButton submitButton;

	/**
	 * Creates a new tab for the visit and adds in the antenatal fields
	 *
	 * @param controller : the controller for antenatal
	 */
	public newVisitTab(NewVisitController controller){
		Pane = new JPanel();

		FlowLayout layout = new FlowLayout();
		form = new VisitForm(layout);

		submitButton = new JButton("Submit");
		submitButton.addActionListener(controller);

		Pane = form.getPanel();

	}

	/**
	 * Sets up the empty tabbed panel
	 * sets minimum size to 600,600
	 *
	 * @return the new jPanel that is set up
	 */
	public JPanel getPanel(){
		JPanel data = new JPanel();
		data.setLayout(new BorderLayout());
		data.add(Pane, BorderLayout.CENTER);
		data.add(bottomButtons(),BorderLayout.SOUTH);
		data.setMinimumSize(new Dimension(600,600));

		return data;
	}

	/**
	 * creates the Quit and Submit buttons on the bottle of the gui
	 *
	 * @return returns the frame on the bottom of the gui that holds Quit and Submit buttons
	 */
	private JPanel bottomButtons(){
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout());


		JButton cancelButton = new JButton("Cancel");
		cancelButton.addActionListener(arg0 -> AntenatalView.removeCurrentTab());
		
		//**Naomi marked out to ensure visit DOESN'T when submit is hit, unless completed
		//this.submitButton.addActionListener(arg0 -> AntenatalView.removeCurrentTab());

		buttonPane.add(cancelButton);
		buttonPane.add(submitButton);
		return buttonPane;
	}

	/**
	 * Returns the new form generated in the class
	 *
	 * @return a new form
	 */
	public VisitForm getForm() {
		return form;
	}

	public void setFormData(AntenatalVisit visit) {
		form.setParity(visit.getParity());
		form.setHIVResults(visit.getHIVResults());
		form.setHeight(visit.getHeight());
		form.setWeight(visit.getWeight());
		form.setVDLabResults(visit.getVDLabResults());
		form.setEDD(visit.getEDD());
		form.setSystolicBP(visit.getSystolicBP());
		form.setDiastolicBP(visit.getDiastolicBP());
		form.setTrimester(visit.getTrimester());
		form.setGestation(visit.getGestation());
		form.setIPTDoses(visit.getIPTDoses());
		form.setTTDoses(visit.getTTDoses());
		form.setFundalHeight(visit.getFundalHeight());
		form.setHBAtReg(visit.getHBAtReg());
		form.setHBAt36Weeks(visit.gethBAt36Weeks());
		form.setUrineTestSugar(visit.getUrineTestSugar());
		form.setUrineTestProtein(visit.getUrineTestProtein());
		form.setBloodGroup(visit.getBloodGroup());
		form.setBloodFilm(visit.getBloodFilm());
		form.setSicklingStatus(visit.getSicklingStatus());
		form.setSicklingType(visit.getSicklingType());
		form.setPreTestCounsel(visit.getPreTestCounsel());
		form.setPostTestCounsel(visit.getPostTestCounsel());
		//    form.setARV(visit.getARV());
		form.setITN(String.valueOf(visit.getITN()));
		form.setMaleInvolvement(visit.getMaleInvolvement());
		form.setComplaints(visit.getComplaints());
		form.setRemarks(visit.getRemarks());
		form.setSubVisits(visit.getSubVisits());
	}
}
