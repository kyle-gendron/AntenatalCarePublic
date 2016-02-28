package edu.usm.cos420.antenatal.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

import edu.usm.cos420.antenatal.controller.AntenatalController;
import edu.usm.cos420.antenatal.domain.DummyPerson;
import edu.usm.cos420.antenatal.view.impl.AntenatalView;

/**
 * Sets up the basics of the new empty antenatal visit frame
 * and sends it to create a new visit form which ads in the necessary fields
 * and then displays it within the existing frame as a new tabbed named
 * after todays date
 */
public class newVisitTab extends JPanel {

	DummyPerson p;//REPLACE
	JTabbedPane tabbedPane;
	private NewVisitForm form;
	private JButton submitButton;

	/**
	 * Creates a new tab for the visit and adds in the antenatal fields
	 * 
	 * @param p : a person class to get consulting information from
	 * @param controller : the controller for antenatal
	 */
	public newVisitTab(DummyPerson p, AntenatalController controller){
		this.p = p;

		tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);	

		FlowLayout layout = new FlowLayout();
		form = new NewVisitForm(layout);

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


		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(l -> System.exit(1));

		this.submitButton.addActionListener(arg0 -> AntenatalView.removeCurrentTab());

		buttonPane.add(quitButton);
		buttonPane.add(submitButton);
		return buttonPane;
	}

	/**
	 * Sets the title of the tab
	 * for now it returns today's date
	 * 
	 * @return a date string (for now)
	 */
	public String getTitle() {
		return p.getDate().toString();
	}

	/**
	 * Returns the new form generated in the class
	 * 
	 * @return a new form
	 */
	public NewVisitForm getForm() {
		return form;
	}
}
