package edu.usm.cos420.health.consultingregister.view;

import javax.swing.JPanel;  
import javax.swing.JLabel;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.text.AbstractDocument;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import java.util.Date;
import java.text.SimpleDateFormat;

import edu.usm.cos420.health.consultingregister.service.NameFieldValidator;
import edu.usm.cos420.health.consultingregister.service.NumberFieldValidator;
import edu.usm.cos420.health.consultingregister.service.DateFieldValidator;
import edu.usm.cos420.health.consultingregister.service.FloatingPointFieldValidator;
import edu.usm.cos420.health.consultingregister.service.BloodPressureFieldValidator;

import edu.usm.cos420.health.consultingregister.domain.RegisterItem;
import edu.usm.cos420.health.view.HealthView;

/**
 * 
 * This class represents the View for RegisterItem objects, which represent
 * clinic visits.
 *
 * This class generates the JPanel used by the View.UIPanel object to represent
 * RegisterItem objects for the project.
 * 
 * @author Thomas Schofield, who refactored initial code from Daniel Dusabimana 
 * with clear inspiration from the PersonView code of Samuel Barton.
 * 
 */
public class RegisterItemView implements HealthView {
	// the "master" panels
	private JPanel visit_panel;
	private JPanel content_panel;
	private JPanel status_panel;
	private JPanel ADD_panel;
	
	//private JPanel ve
	private JPanel bottom_panel; // holds status panel and button panel

	// difference contexts the content panel may be in.
	private JPanel add_panel;
    private JPanel view_panel;
    private JPanel search_panel;
	
	// The listener object used for the RegisterItem class.
	private ActionListener listener;

	// what goes in the status panel.
	private JLabel status_label;
	// what goes in the ADD panel
	private JButton ADD_button;
	private JButton add_button;
	private JButton view_button;
	private JButton search_button;
	
    private JButton edit_button;

	// Components for visit info
	private JLabel date_label;
	private JFormattedTextField date_tf;
	private JLabel year_label;
	private JFormattedTextField year_tf;
	private JLabel facility_label;
	private JFormattedTextField facility_tf;
	private JLabel district_label;
	private JFormattedTextField district_tf;
	private JLabel subDist_label;
	private JFormattedTextField subDist_tf;
	private JPanel newCase_panel;
	private JLabel newCase_label;
	private JRadioButton yes_rb;
	private JRadioButton no_rb;
	private ButtonGroup newCase_selection;
	private JLabel princ_diag_label;
	private JFormattedTextField princ_diag_tf;
	private JLabel add_diag_label;
	private JFormattedTextField add_diag_tf;
	private JLabel treatment_label;
	private JFormattedTextField treatment_tf;
	private JPanel referred_panel;
	private JLabel referred_label;
	private JRadioButton refYes_rb;
	private JRadioButton refNo_rb;
	private ButtonGroup referred_selection;
	private JTextField ref_outcome_tf;
	private JLabel remarks_label;
	private JTextField remarks_tf;
	private JLabel blood_press_label;
	private JFormattedTextField blood_press_tf;
	private JLabel pulse_label;
	private JFormattedTextField pulse_tf;
	private JLabel temp_label;
	private JFormattedTextField temp_tf;
	private JLabel weight_label;
	private JFormattedTextField weight_tf;
	private JLabel resp_label;
	private JFormattedTextField resp_tf;

	/**
	 * Default Constructor.
	 *
	 * No arguments are needed as all the work is done by the initPanel() helper
	 * method.
	 *
	 */
	public RegisterItemView( ActionListener l ) {
		listener = l;
		initPanel();
	}

	/**
	 * Get the info from the data fields to make a search term.
	 *
	 * This method pulls out the information from the data fields and then puts
	 * them into a RegisterItem.Info object which is then used by the
	 * RegisterItemService class to search the RegisterItem Database for visits
	 * with similar info, or add a visit to the database if there is no one with
	 * this info.
	 *
	 * @return the information contained in the data fields
	 */
	public RegisterItem.Info getInfo() {
		String newCase = "";

		if (yes_rb.isSelected())
			newCase = "yes";
		else if (no_rb.isSelected())
			newCase = "no";

		String referred = "";

		if (refYes_rb.isSelected())
			referred = "yes";
		else if (refNo_rb.isSelected())
			referred = "no";

		RegisterItem.Info info = new RegisterItem.Info(date_tf.getText(), 
                                                       year_tf.getText(), 
                                                       facility_tf.getText(),
				                                       subDist_tf.getText(), 
                                                       district_tf.getText(), 
                                                       newCase, 
                                                       princ_diag_tf.getText(), 
                                                       add_diag_tf.getText(),
				                                       treatment_tf.getText(), 
                                                       referred, 
                                                       ref_outcome_tf.getText(), 
                                                       remarks_tf.getText());

		return info;
	}

	public RegisterItem.Vitals getVitals() 
    {
		RegisterItem.Vitals vitals = new RegisterItem.Vitals(blood_press_tf.getText(), 
                                                             pulse_tf.getText(),
				                                             temp_tf.getText(), 
                                                             weight_tf.getText(), 
                                                             resp_tf.getText());

		return vitals;
	}

	/**
	 * Create the add/edit and view JPanels.
	 *
	 * This method is used to generate the add/edit and view JPanels which
	 * represent the modes of interacting with RegisterItem objects.
	 *
	 * @return JPanel visit_panel
	 */
	private void initPanel() {
		visit_panel = new JPanel();
		visit_panel.setLayout(new BorderLayout());

		status_panel = new JPanel();
		status_label = new JLabel("");
		//status_label.setHorizontalAlignment(JLabel.LEFT);
		status_panel.add(status_label);

		bottom_panel = new JPanel();
		bottom_panel.setLayout(new BoxLayout(bottom_panel, BoxLayout.X_AXIS));
		bottom_panel.add(status_panel);

		initAddPanel();

		// The first view shown to the user is the add/edit view.
		content_panel = add_panel;

		visit_panel.add(content_panel, BorderLayout.CENTER);
		visit_panel.add(bottom_panel, BorderLayout.SOUTH);
		visit_panel.setName("add mode");
	}

	/**
	 * 
	 * Initialize the add/edit JPanel.
	 *
	 * This panel is laid out in two rows, with the content in each row evenly
	 * spaced so as to be visually appealing. To make this work, each JLabel and
	 * associated text field (or radio button) is put within a JPanel, and then
	 * each JPanel is added to a JPanel for the row. Each row's JPanel uses the
	 * X_AXIS layout mode of BoxLayout to enable even spacing of the components
	 * across the screen.
	 *
	 */
	private void initAddPanel() {
		add_panel = new JPanel();
		add_panel.setLayout(new BoxLayout(add_panel, BoxLayout.Y_AXIS));
		// ADD button....
		ADD_panel = new JPanel();
		ADD_button = new JButton("ADD");
		ADD_button.addActionListener(listener);
		ADD_panel.add(ADD_button);
		view_panel = new JPanel();
		view_button = new JButton("VIEW LIST");
		view_button.add(ADD_button);
		view_panel.add(view_button);
		search_panel = new JPanel();
		search_button = new JButton("SEARCH");
		search_button.add(ADD_button);
		search_panel.add(search_button);
		
		
		// First row, visit logistics
		date_label = new JLabel("Date: ");
        date_tf = new JFormattedTextField();
        date_tf.setColumns(10);
        date_tf.setInputVerifier(DateFieldValidator.getInstance());
        date_tf.setText((new SimpleDateFormat("MM/dd/yyyy")).format(new Date()));

		year_label = new JLabel("Year: ");
		year_tf = new JFormattedTextField();
        year_tf.setColumns(10);
        setValidator(year_tf, "number");
		facility_label = new JLabel("Facility: ");
        facility_tf = new JFormattedTextField();
        facility_tf.setColumns(10);
        setValidator(facility_tf, "name");
		district_label = new JLabel("District: ");
        district_tf = new JFormattedTextField();
        district_tf.setColumns(10);
        setValidator(district_tf, "name");
		subDist_label = new JLabel("Sub-District: ");
		subDist_tf = new JFormattedTextField();
        subDist_tf.setColumns(10);
        setValidator(subDist_tf, "name");

		newCase_label = new JLabel("New Case: ");
		newCase_selection = new ButtonGroup();
		yes_rb = new JRadioButton("Yes");
		no_rb = new JRadioButton("No");
		newCase_selection.add(yes_rb);
		newCase_selection.add(no_rb);

		newCase_panel = new JPanel();
		newCase_panel.add(newCase_label);
		newCase_panel.add(yes_rb);
		newCase_panel.add(no_rb);

		referred_label = new JLabel("Referred: ");
		referred_selection = new ButtonGroup();
		refYes_rb = new JRadioButton("Yes");
		refNo_rb = new JRadioButton("No");
		referred_selection.add(refYes_rb);
		referred_selection.add(refNo_rb);

		referred_panel = new JPanel();
		referred_panel.add(referred_label);
		referred_panel.add(refYes_rb);
		referred_panel.add(refNo_rb);

		JPanel date_panel = new JPanel();
		date_panel.add(date_label);
		date_panel.add(date_tf);
		JPanel year_panel = new JPanel();
		year_panel.add(year_label);
		year_panel.add(year_tf);
		JPanel facility_panel = new JPanel();
		facility_panel.add(facility_label);
		facility_panel.add(facility_tf);
		JPanel district_panel = new JPanel();
		district_panel.add(district_label);
		district_panel.add(district_tf);
		JPanel subDist_panel = new JPanel();
		subDist_panel.add(subDist_label);
		subDist_panel.add(subDist_tf);

		JPanel row1 = new JPanel();
		row1.setLayout(new BoxLayout(row1, BoxLayout.Y_AXIS));
		row1.add(Box.createVerticalStrut(30));
		row1.add(new JSeparator(JSeparator.HORIZONTAL));
		row1.add(new JSeparator(JSeparator.HORIZONTAL));
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.add(date_panel);
		horizontalBox.add(year_panel);
		horizontalBox.add(facility_panel);
		horizontalBox.add(district_panel);
		horizontalBox.add(subDist_panel);
		horizontalBox.add(referred_panel);
		horizontalBox.add(newCase_panel);
		row1.add(horizontalBox);

		// Second row: vitals
		JPanel weight_panel = new JPanel();
		weight_label = new JLabel("Weight: ");
		weight_tf = new JFormattedTextField();
        weight_tf.setColumns(10);
        setValidator(weight_tf, "float");
		weight_panel.add(weight_label);
		weight_panel.add(weight_tf);
		JPanel blood_press_panel = new JPanel();
		blood_press_label = new JLabel("Blood Pressure: ");
		blood_press_tf = new JFormattedTextField();
        blood_press_tf.setColumns(10);
        setValidator(blood_press_tf, "bp");
		blood_press_panel.add(blood_press_label);
		blood_press_panel.add(blood_press_tf);
		JPanel pulse_panel = new JPanel();
		pulse_label = new JLabel("Pulse: ");
		pulse_tf = new JFormattedTextField();
        pulse_tf.setColumns(10);
        setValidator(pulse_tf, "number");
		pulse_panel.add(pulse_label);
		pulse_panel.add(pulse_tf);
		JPanel temp_panel = new JPanel();
		temp_label = new JLabel("Temperature: ");
        temp_tf = new JFormattedTextField();
        temp_tf.setColumns(10);
        setValidator(temp_tf, "float");
        setValidator(weight_tf, "float");
		temp_panel.add(temp_label);
		temp_panel.add(temp_tf);
		JPanel resp_panel = new JPanel();
		resp_label = new JLabel("Respiratory Rate: ");
		resp_tf = new JFormattedTextField();
        resp_tf.setColumns(10);
        setValidator(resp_tf, "number");
		resp_panel.add(resp_label);
		resp_panel.add(resp_tf);

		horizontalBox = Box.createHorizontalBox();
		horizontalBox.add(weight_panel);
		horizontalBox.add(blood_press_panel);
		horizontalBox.add(pulse_panel);
		horizontalBox.add(temp_panel);
		horizontalBox.add(resp_panel);
		row1.add(horizontalBox);

		// Row 3, diagnoses information and remarks
		JPanel princ_diag_panel = new JPanel();
		princ_diag_label = new JLabel("Principal Diagnosis: ");
		princ_diag_tf = new JFormattedTextField();
        princ_diag_tf.setColumns(10);
        setValidator(princ_diag_tf, "name");
		princ_diag_panel.add(princ_diag_label);
		princ_diag_panel.add(princ_diag_tf);
		JPanel add_diag_panel = new JPanel();
		add_diag_label = new JLabel("Additional Diagnoses: ");
		add_diag_tf = new JFormattedTextField();
        add_diag_tf.setColumns(10);
        setValidator(add_diag_tf, "name");
		add_diag_panel.add(add_diag_label);
		add_diag_panel.add(add_diag_tf);
		JPanel treatment_panel = new JPanel();
		treatment_label = new JLabel("Treatment: ");
		treatment_tf = new JFormattedTextField();
        treatment_tf.setColumns(10);
        setValidator(treatment_tf, "name");
		treatment_panel.add(treatment_label);
		treatment_panel.add(treatment_tf);
		JPanel remarks_panel = new JPanel();
		remarks_label = new JLabel("Remarks: ");
		remarks_tf = new JTextField(10);
		remarks_panel.add(remarks_label);
		remarks_panel.add(remarks_tf);
		//.
		ADD_panel.add(ADD_button);
		bottom_panel.add(ADD_panel);
		//.
		view_panel.add(view_button);
		search_panel.add(search_button);
		//view_panel.add(view_panel);

		horizontalBox = Box.createHorizontalBox();
		horizontalBox.add(princ_diag_panel);
		horizontalBox.add(add_diag_panel);
		horizontalBox.add(treatment_panel);
		horizontalBox.add(remarks_panel);
		row1.add(horizontalBox);
		
		horizontalBox = Box.createHorizontalBox();
		horizontalBox.add(ADD_panel);
		horizontalBox.add(view_panel);
		horizontalBox.add(search_panel);
		
		row1.add(horizontalBox);
		
		row1.add(new JSeparator(JSeparator.HORIZONTAL));
		row1.add(new JSeparator(JSeparator.HORIZONTAL));
		//Adjust this number to adjust squashing
		row1.add(Box.createVerticalStrut(150));
		
		add_panel.add(row1);
		
	}

	/**
	 * Update the add/edit panel.
	 *
	 * Reconstruct the add/edit panel
	 */
	private void updateAddPanel() {
		add_panel.removeAll();

		// First row, visit logistics
		date_label = new JLabel("Date: ");
        date_tf = new JFormattedTextField();
        date_tf.setColumns(10);
        date_tf.setInputVerifier(DateFieldValidator.getInstance());
        date_tf.setText((new SimpleDateFormat("MM/dd/yyyy")).format(new Date()));
		year_label = new JLabel("Year: ");
		year_tf = new JFormattedTextField();
        year_tf.setColumns(10);
        setValidator(year_tf, "number");
		facility_label = new JLabel("Facility: ");
        facility_tf = new JFormattedTextField();
        facility_tf.setColumns(10);
        setValidator(facility_tf, "name");
		district_label = new JLabel("District: ");
        district_tf = new JFormattedTextField();
        district_tf.setColumns(10);
        setValidator(district_tf, "name");
		subDist_label = new JLabel("Sub-District: ");
		subDist_tf = new JFormattedTextField();
        subDist_tf.setColumns(10);
        setValidator(subDist_tf, "name");

		newCase_label = new JLabel("New Case: ");
		newCase_selection = new ButtonGroup();
		yes_rb = new JRadioButton("Yes");
		no_rb = new JRadioButton("No");
		newCase_selection.add(yes_rb);
		newCase_selection.add(no_rb);

		newCase_panel = new JPanel();
		newCase_panel.add(newCase_label);
		newCase_panel.add(yes_rb);
		newCase_panel.add(no_rb);

		referred_label = new JLabel("Referred: ");
		referred_selection = new ButtonGroup();
		refYes_rb = new JRadioButton("Yes");
		refNo_rb = new JRadioButton("No");
		referred_selection.add(refYes_rb);
		referred_selection.add(refNo_rb);

		referred_panel = new JPanel();
		referred_panel.add(referred_label);
		referred_panel.add(refYes_rb);
		referred_panel.add(refNo_rb);

		JPanel date_panel = new JPanel();
		date_panel.add(date_label);
		date_panel.add(date_tf);
		JPanel year_panel = new JPanel();
		year_panel.add(year_label);
		year_panel.add(year_tf);
		JPanel facility_panel = new JPanel();
		facility_panel.add(facility_label);
		facility_panel.add(facility_tf);
		JPanel district_panel = new JPanel();
		district_panel.add(district_label);
		district_panel.add(district_tf);
		JPanel subDist_panel = new JPanel();
		subDist_panel.add(subDist_label);
		subDist_panel.add(subDist_tf);

		JPanel row1 = new JPanel();
		row1.setLayout(new BoxLayout(row1, BoxLayout.X_AXIS));
		row1.add(date_panel);
		row1.add(year_panel);
		row1.add(facility_panel);
		row1.add(district_panel);
		row1.add(subDist_panel);
		row1.add(referred_panel);
		row1.add(newCase_panel);

		add_panel.add(row1);

		// Second row: vitals
		JPanel weight_panel = new JPanel();
		weight_label = new JLabel("Weight: ");
		weight_tf = new JFormattedTextField();
        weight_tf.setColumns(10);
        setValidator(weight_tf, "float");
		weight_panel.add(weight_label);
		weight_panel.add(weight_tf);
		JPanel blood_press_panel = new JPanel();
		blood_press_label = new JLabel("Blood Pressure: ");
		blood_press_tf = new JFormattedTextField();
        blood_press_tf.setColumns(10);
        setValidator(blood_press_tf, "bp");
		blood_press_panel.add(blood_press_label);
		blood_press_panel.add(blood_press_tf);
		JPanel pulse_panel = new JPanel();
		pulse_label = new JLabel("Pulse: ");
		pulse_tf = new JFormattedTextField();
        pulse_tf.setColumns(10);
        setValidator(pulse_tf, "number");
		pulse_panel.add(pulse_label);
		pulse_panel.add(pulse_tf);
		JPanel temp_panel = new JPanel();
		temp_label = new JLabel("Temperature: ");
		temp_tf = new JFormattedTextField();
        temp_tf.setColumns(10);
        setValidator(temp_tf, "float");
		temp_panel.add(temp_label);
		temp_panel.add(temp_tf);
		JPanel resp_panel = new JPanel();
		resp_label = new JLabel("Respiratory Rate: ");
		resp_tf = new JFormattedTextField();
        resp_tf.setColumns(10);
        setValidator(resp_tf, "number");
		resp_panel.add(resp_label);
		resp_panel.add(resp_tf);

		JPanel row2 = new JPanel();
		row2.setLayout(new BoxLayout(row2, BoxLayout.X_AXIS));
		row2.add(weight_panel);
		row2.add(blood_press_panel);
		row2.add(pulse_panel);
		row2.add(temp_panel);
		row2.add(resp_panel);

		add_panel.add(row2);

		// Row 3, diagnoses information and remarks
		JPanel princ_diag_panel = new JPanel();
		princ_diag_label = new JLabel("Principal Diagnosis: ");
		princ_diag_tf = new JFormattedTextField();
        princ_diag_tf.setColumns(10);
        setValidator(princ_diag_tf, "name");
		princ_diag_panel.add(princ_diag_label);
		princ_diag_panel.add(princ_diag_tf);
		JPanel add_diag_panel = new JPanel();
		add_diag_label = new JLabel("Additional Diagnoses: ");
		add_diag_panel.add(add_diag_label);
		add_diag_panel.add(add_diag_tf);
		
		JPanel treatment_panel = new JPanel();
		treatment_label = new JLabel("Treatment: ");
		treatment_tf = new JFormattedTextField();
        treatment_tf.setColumns(10);
        setValidator(treatment_tf, "name");
		treatment_panel.add(treatment_label);
		treatment_panel.add(treatment_tf);
		
		JPanel remarks_panel = new JPanel();
		remarks_label = new JLabel("Remarks: ");
		remarks_tf = new JTextField(10);
		remarks_panel.add(remarks_label);
		remarks_panel.add(remarks_tf);

		JPanel row3 = new JPanel();
		row3.setLayout(new BoxLayout(row3, BoxLayout.X_AXIS));
	
		
		row3.add(princ_diag_panel);
		row3.add(add_diag_panel);
		row3.add(treatment_panel);
		row3.add(remarks_panel);

		add_panel.add(row3);
        
		//.
		
		JPanel row4 = new JPanel();
		row4.setLayout(new BoxLayout(row4, BoxLayout.X_AXIS));
	    row4.add(bottom_panel);
	     
	    //.
		bottom_panel.removeAll();
		bottom_panel.add(status_panel);
		bottom_panel.add(ADD_panel);
		//view_panel.add(view_panel);
		ADD_panel.removeAll();
		//view_panel.removeAll();
		
		ADD_panel.add(ADD_button);
		//view_panel.add(view_button);
		//add_panel.add(view_panel);
		add_panel.add(bottom_panel);

		visit_panel = add_panel;
		visit_panel.setName("Adding a Visit");
	}

	/**
	 * Edit the information for this Person.
	 *
	 * This method enables the editing of a Person's info.
	 */
	public void editVisit() {
		updateAddPanel();
	}

	/**
	 * Display the UI for adding a visit.
	 *
	 * This method enables the adding of a new visit.
	 */
	public void addVisit() {
		initPanel();
	}
	
    /** 
     * 
     * Create the View mode of the Visit Panel.
     * 
     * The view mode does not allow editing of fields without pressing the
     * edit button.
     *
     * This method will only be called the first time displayVisit(...) is 
     * called.
     * 
     */
    private void initViewPanel()
    {
        JPanel year_panel = new JPanel();
        year_panel.add(year_label);
        year_panel.add(new JLabel(year_tf.getText()));

        JPanel facility_panel = new JPanel();
        facility_panel.add(facility_label);
        facility_panel.add(new JLabel(facility_tf.getText()));
        
        JPanel district_panel = new JPanel();
        district_panel.add(district_label);
        district_panel.add(new JLabel(district_tf.getText()));
        
        JPanel subDist_panel = new JPanel();
        subDist_panel.add(subDist_label);
        subDist_panel.add(new JLabel(subDist_tf.getText()));

        JPanel newCase_panel = new JPanel();
        newCase_panel.add(newCase_label);
        if (newCase_selection.getSelection() != null)
        {
            if (yes_rb.isSelected())
                newCase_panel.add(new JLabel("New Case"));
            else if (no_rb.isSelected())
                newCase_panel.add(new JLabel("Not a New Case"));
        }
        
        JPanel referred_panel = new JPanel();
        referred_panel.add(referred_label);
        if (referred_selection.getSelection() != null)
        {
            if (refYes_rb.isSelected())
                referred_panel.add(new JLabel("Referred"));
            else if (refNo_rb.isSelected())
                referred_panel.add(new JLabel("Not Referred"));
        }

        JPanel date_panel = new JPanel();
        date_panel.add(date_label);
        date_panel.add(new JLabel(date_tf.getText()));
        
        JPanel blood_press_panel = new JPanel();
        blood_press_panel.add(blood_press_label);
        blood_press_panel.add(new JLabel(blood_press_tf.getText()));
        
        JPanel pulse_panel = new JPanel();
        pulse_panel.add(pulse_label);
        pulse_panel.add(new JLabel(pulse_tf.getText()));
        
        JPanel weight_panel = new JPanel();
        weight_panel.add(weight_label);
        weight_panel.add(new JLabel(weight_tf.getText()));
        
        JPanel temp_panel = new JPanel();
        temp_panel.add(temp_label);
        temp_panel.add(new JLabel(temp_tf.getText()));
        
        JPanel resp_panel = new JPanel();
        resp_panel.add(resp_label);
        resp_panel.add(new JLabel(resp_tf.getText()));
        
        JPanel princ_diag_panel = new JPanel();
        princ_diag_panel.add(princ_diag_label);
        princ_diag_panel.add(new JLabel(princ_diag_tf.getText()));
        
        JPanel add_diag_panel = new JPanel();
        add_diag_panel.add(add_diag_label);
        add_diag_panel.add(new JLabel(add_diag_tf.getText()));
        
        JPanel treatment_panel = new JPanel();
        treatment_panel.add(treatment_label);
        treatment_panel.add(new JLabel(treatment_tf.getText()));
        
        JPanel remarks_panel = new JPanel();
        remarks_panel.add(remarks_label);
        remarks_panel.add(new JLabel(remarks_tf.getText()));

        JPanel row1 = new JPanel();
		row1.setLayout(new BoxLayout(row1, BoxLayout.X_AXIS));
		row1.add(date_panel);
		row1.add(year_panel);
		row1.add(facility_panel);
		row1.add(district_panel);
		row1.add(subDist_panel);
		row1.add(referred_panel);
		row1.add(newCase_panel);
		
		JPanel row2 = new JPanel();
		row2.setLayout(new BoxLayout(row2, BoxLayout.X_AXIS));
		row2.add(weight_panel);
		row2.add(blood_press_panel);
		row2.add(pulse_panel);
		row2.add(temp_panel);
		row2.add(resp_panel);
		
		JPanel row3 = new JPanel();
		row3.setLayout(new BoxLayout(row3, BoxLayout.X_AXIS));
		row3.add(princ_diag_panel);
		row3.add(add_diag_panel);
		row3.add(treatment_panel);
		row3.add(remarks_panel);
		//.
		JPanel row4 = new JPanel();
		row4.setLayout(new BoxLayout(row4, BoxLayout.X_AXIS));
		row4.add(bottom_panel);
		//.
        view_panel = new JPanel();
        view_panel.setLayout(new BorderLayout());
        view_panel.add(row1, BorderLayout.CENTER);
        view_panel.add(row2, BorderLayout.CENTER);
        view_panel.add(row3, BorderLayout.CENTER);
        view_panel.add(row4, BorderLayout.CENTER);
        view_panel.add(bottom_panel, BorderLayout.SOUTH);

        ADD_panel.removeAll();
        edit_button = new JButton("edit");
        edit_button.addActionListener(listener);
        ADD_panel.add(edit_button);

        visit_panel = view_panel;
        visit_panel.setName("view mode");
    }

	/**
	 * Initialize the selection mode of the Visit Panel.
	 *
	 * This method initializes the mode of the panel where one chooses whether
	 * or not to use the person they have selected. It is a glorified version of
	 * the view mode of the panel with the addition of a "use this person"
	 * button.
	 *
	 */
	private void initSelectionPanel() {
		JPanel year_panel = new JPanel();
		year_panel.add(year_label);
		year_panel.add(new JLabel(year_tf.getText()));

		JPanel facility_panel = new JPanel();
		facility_panel.add(facility_label);
		facility_panel.add(new JLabel(facility_tf.getText()));

		JPanel district_panel = new JPanel();
		district_panel.add(district_label);
		district_panel.add(new JLabel(district_tf.getText()));

		JPanel subDist_panel = new JPanel();
		subDist_panel.add(subDist_label);
		subDist_panel.add(new JLabel(subDist_tf.getText()));

		JPanel princ_diag_panel = new JPanel();
		princ_diag_panel.add(princ_diag_label);
		princ_diag_panel.add(new JLabel(princ_diag_tf.getText()));

		JPanel add_diag_panel = new JPanel();
		add_diag_panel.add(add_diag_label);
		add_diag_panel.add(new JLabel(add_diag_tf.getText()));

		JPanel treatment_panel = new JPanel();
		treatment_panel.add(treatment_label);
		treatment_panel.add(new JLabel(treatment_tf.getText()));

		JPanel remarks_panel = new JPanel();
		remarks_panel.add(remarks_label);
		remarks_panel.add(new JLabel(remarks_tf.getText()));

		JPanel newCase_panel = new JPanel();
		newCase_panel.add(newCase_label);
		if (newCase_selection.getSelection() != null) {
			if (yes_rb.isSelected())
				newCase_panel.add(new JLabel("Yes"));
			else if (no_rb.isSelected())
				newCase_panel.add(new JLabel("No"));
		}

		JPanel referred_panel = new JPanel();
		referred_panel.add(referred_label);
		if (referred_selection.getSelection() != null) {
			if (refYes_rb.isSelected())
				referred_panel.add(new JLabel("Yes"));
			else if (refNo_rb.isSelected())
				referred_panel.add(new JLabel("No"));
		}

		JPanel date_panel = new JPanel();
		date_panel.add(date_label);
		date_panel.add(new JLabel(date_tf.getText()));

		JPanel blood_press_panel = new JPanel();
		blood_press_panel.add(blood_press_label);
		blood_press_panel.add(new JLabel(blood_press_tf.getText()));

		JPanel pulse_panel = new JPanel();
		pulse_panel.add(pulse_label);
		pulse_panel.add(new JLabel(pulse_tf.getText()));

		JPanel weight_panel = new JPanel();
		weight_panel.add(weight_label);
		weight_panel.add(new JLabel(weight_tf.getText()));

		JPanel temp_panel = new JPanel();
		temp_panel.add(temp_label);
		temp_panel.add(new JLabel(temp_tf.getText()));

		JPanel resp_panel = new JPanel();
		resp_panel.add(resp_label);
		resp_panel.add(new JLabel(resp_tf.getText()));

		JPanel row1 = new JPanel();
		row1.setLayout(new BoxLayout(row1, BoxLayout.X_AXIS));
		row1.add(year_panel);
		row1.add(date_panel);
		row1.add(facility_panel);
		row1.add(district_panel);
		row1.add(subDist_panel);
		row1.add(referred_panel);
		row1.add(newCase_panel);

		JPanel row2 = new JPanel();
		row2.setLayout(new BoxLayout(row2, BoxLayout.X_AXIS));
		row2.add(weight_panel);
		row2.add(blood_press_panel);
		row2.add(pulse_panel);
		row2.add(temp_panel);
		row2.add(resp_panel);

		JPanel row3 = new JPanel();
		row3.setLayout(new BoxLayout(row3, BoxLayout.X_AXIS));
		row3.add(princ_diag_panel);
		row3.add(add_diag_panel);
		row3.add(treatment_panel);
		row3.add(remarks_panel);

		JPanel selection_panel = new JPanel();
		selection_panel.setLayout(new BoxLayout(selection_panel, BoxLayout.Y_AXIS));
		selection_panel.add(row1);
		selection_panel.add(row2);
		selection_panel.add(bottom_panel);

		ADD_panel.removeAll();

		JButton use_button = new JButton("Use this Visit");
		use_button.addActionListener(listener);
		ADD_panel.add(use_button);

		visit_panel = selection_panel;
		visit_panel.setName("Selection Mode");
	}

	/**
	 * 
	 * Get a reference to the JPanel for a Visit.
	 * 
	 * This method will give a reference to the panel where information about a
	 * Person is shown and can be edited (in the right mode).
	 * 
	 * @return a reference to the Person JPanel
	 */
	public JPanel getPanel() {
		return visit_panel;
	}

	/**
	 *
	 * Have the person panel display some status message.
	 * 
	 * @param msg
	 *            the message to display
	 */
	public void display(String msg) {
		status_label.setText(msg);
		status_label.invalidate();
	}
	
    /** 
    *
    * Display the info for this visit.
    *
    * This activates the View mode of the visit panel, which means that one
    * can only edit the informaiton fields for the visit by clicking the edit
    * button (in the bottom panel).
    * 
    */
   public void displayVisit()
   {
       initViewPanel();
   }

	/**
	 * Display the info of the RegisterItem passed in.
	 *
	 * @param p
	 *            the Person whose info is to be displayed
	 */
	public void displayVisit(RegisterItem r) {
		// set the info for all of the fields with this Person's info
		year_tf.setText(r.getYear());
		facility_tf.setText(r.getFacility());

		if (r.getNewCase().equals("Yes"))
			yes_rb.setSelected(true);
		else
			no_rb.setSelected(true);

		if (r.getReferred().equals("Yes"))
			refYes_rb.setSelected(true);
		else
			refNo_rb.setSelected(true);

		district_tf.setText(r.getDist());
		subDist_tf.setText(r.getSubDist());
		princ_diag_tf.setText(r.getPrincDiag());
		add_diag_tf.setText(r.getAddDiag());
		treatment_tf.setText(r.getTreatment());
		ref_outcome_tf.setText(r.getReferOutcome());
		remarks_tf.setText(r.getRemarks());
		blood_press_tf.setText(r.getBloodPress());
		pulse_tf.setText(r.getPulse());
		weight_tf.setText(r.getWeight());
		temp_tf.setText(r.getTemp());
		resp_tf.setText(r.getResp());

	    date_tf.setText(r.getDate());

		initSelectionPanel();
	}

    /** 
     * Set the validator for a JFormattedTextField's input.
     *
     * This method sets the filter used on the input for out text fields so
     * that only desired input can be entered.
     *
     * @param field the textfield which needs a filter
     * @param isName the type of filter to use
     */
    private void setValidator(JFormattedTextField field, String type)
    {
        AbstractDocument doc = (AbstractDocument)field.getDocument();
        if (type.equals("name"))
            doc.setDocumentFilter(NameFieldValidator.getInstance());
        else if (type.equals("number"))
            doc.setDocumentFilter(NumberFieldValidator.getInstance());
        else if (type.equals("float"))
            doc.setDocumentFilter(FloatingPointFieldValidator.getInstance());
        else // type equals "bp"
            doc.setDocumentFilter(BloodPressureFieldValidator.getInstance());
    }
}
