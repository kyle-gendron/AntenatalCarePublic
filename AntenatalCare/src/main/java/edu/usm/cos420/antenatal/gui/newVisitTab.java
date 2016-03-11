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

	JTabbedPane tabbedPane;
	private VisitForm form;
	private JButton submitButton;

	/**
	 * Creates a new tab for the visit and adds in the antenatal fields
	 *
   * @param controller : the controller for antenatal
   */
	public newVisitTab(NewVisitController controller){
		tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);

		FlowLayout layout = new FlowLayout();
		form = new VisitForm(layout);

		submitButton = new JButton("Submit");
		submitButton.addActionListener(controller);

		tabbedPane.addTab("Antenatal Care Input", form.getPanel());

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
		data.add(tabbedPane, BorderLayout.CENTER);
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

		this.submitButton.addActionListener(arg0 -> AntenatalView.removeCurrentTab());

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

  public void setFormData(AntenatalVisit formData) {
    form.setParity(formData.getParity());
    form.setSystolicBP(formData.getSystolicBP());
    form.setDiastolicBP(formData.getDiastolicBP());
    form.setTrimester(formData.getTrimester());
    form.setGestation(formData.getGestation());
    form.setIPTDoses(formData.getIPTDoses());
    form.setITPDoses(formData.getITPDoses());
    form.setTTDoses(formData.getTTDoses());
    form.setHeight(formData.getHeight());
    form.setWeight(formData.getWeight());
    form.setFundalHeight(formData.getFundalHeight());
    form.setHBAtReg(formData.getHBAtReg());
    form.setHBAt36Weeks(formData.gethBAt36Weeks());
    form.setUrineTestSugar(formData.getUrineTestSugar());
    form.setUrineTestProtein(formData.getUrineTestProtein());
    form.setEDD(formData.getEDD());
    form.setBloodGroup(formData.getBloodGroup());
    form.setSicklingStatus(formData.getSicklingStatus());
    form.setSicklingType(formData.getSicklingType());
    form.setVDLabResults(formData.getVDLabresults());
    form.setPreTestCounsel(formData.getPreTestCounsel());
    form.setHIVResults(formData.getHIVResults());
    form.setPostTestCounsel(formData.getPostTestCounsel());
    form.setARV(formData.getARV());
    form.setBloodFilm(formData.getBloodFilm());
    form.setITN(formData.getITN());
  }
}
