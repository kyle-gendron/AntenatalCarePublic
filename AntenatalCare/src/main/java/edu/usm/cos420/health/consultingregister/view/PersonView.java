package edu.usm.cos420.health.consultingregister.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.ButtonGroup;
import javax.swing.text.AbstractDocument;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import edu.usm.cos420.health.consultingregister.controller.PersonController;
import edu.usm.cos420.health.consultingregister.service.NameFieldValidator;
import edu.usm.cos420.health.consultingregister.service.NumberFieldValidator;
import edu.usm.cos420.health.consultingregister.service.DateFieldValidator;
import edu.usm.cos420.health.view.HealthView;
import edu.usm.cos420.health.domain.Person;

/** 
 * 
 * This class represents the View for Person objects.
 *
 * This class generates the JPanel used by the View.UIPanel object to
 * represent People objects for the project.
 * 
 * @author Samuel Barton
 * 
 * The view panel should have first, last, date of birth, and gender
 */
public class PersonView implements HealthView
{
    // the overarching panels
    private JPanel person_panel;
    private JPanel content_panel;
    private JPanel status_panel;
    private JPanel submit_panel;
    private JPanel bottom_panel; // holds status panel and button panel

    // difference contexts the content panel may be in.
    private JPanel add_panel;
    private JPanel view_panel;
    private JPanel edit_panel;

    // The listener object used for the Person class.
    private ActionListener listener;

    // what goes not in the status panel.
    private JLabel status_label;
    // what goes in the submit panel
    private JButton submit_button;
    private JButton edit_button;
    private JButton view_button;
    private JButton cancel_button;
    private JButton add_button;

    // Components for person info
    private JLabel first_name_label;
    private JFormattedTextField first_name_tf;
    private JLabel last_name_label;
    private JFormattedTextField last_name_tf;
    private JLabel village_label;
    private JFormattedTextField village_tf;
    private JLabel tribe_label;
    private JFormattedTextField tribe_tf;
    private JLabel house_number_label;
    private JFormattedTextField house_number_tf;
    private JLabel date_of_birth_label;
    private JFormattedTextField date_of_birth_tf;
    private JLabel insurance_number_label;
    private JFormattedTextField insurance_number_tf;
    private JLabel national_id_label;
    private JFormattedTextField national_id_tf;
    private JPanel gender_panel;
    private JLabel gender_label;
    private JLabel gender_value_label;
    private JRadioButton male_rb;
    private JRadioButton female_rb;
    private JRadioButton neither_rb;
    private ButtonGroup gender_selection;

    /** 
     * Default Constructor.
     *
     * No arguments are needed as all the work is done by the initPanel()
     * helper method.
     *
     */
    public PersonView(ActionListener l)
    {
        listener = l;
        initPanel();
    }

    /** 
     * Get the info from the data fields to make a search term.
     *
     * This method pulls out the information from the data fields and then
     * puts them into a Person.Info object which is then used by the 
     * PersonService class to search the PeopleDatabase for people with 
     * similar info, or add a Person to the database if there is no one with
     * this info.
     *
     * @return the information contained in the data fields
     */
    public Person.Info getInfo()
    {
        String gender = "";

        if (male_rb.isSelected())
            gender = "male";
        else if (female_rb.isSelected())
            gender = "female";
        else
            gender = "";

        Person.Info info = new Person.Info(first_name_tf.getText(),
                                           last_name_tf.getText(),
                                           village_tf.getText(),
                                           tribe_tf.getText(),
                                           house_number_tf.getText(),
                                           formatDateOfBirth(),
                                           insurance_number_tf.getText(),
                                           national_id_tf.getText(),
                                           gender);

        return info;
    }

    /** 
     * Set the state of the fields in the View to match the Info object passed
     * in. 
     *
     * @param info the info object to update the fields with
     */
    public void setInfo(Person.Info info)
    {
        first_name_tf.setText(info.getFirstName());
        last_name_tf.setText(info.getLastName());
        village_tf.setText(info.getVillage());
        tribe_tf.setText(info.getTribe());
        house_number_tf.setText(info.getHouseNumber());
        try
        {
            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            date_of_birth_tf.setValue(df.parse(info.getDateOfBirth()));
        }
        catch (Exception ignore) {}
        insurance_number_tf.setText(info.getInsuranceNumber());
        national_id_tf.setText(info.getNationalID());
        String gender = info.getGender();
        if (gender != null)
        {
            if (gender.equals("male"))
                male_rb.setSelected(true);
            else if (gender.equals("female"))
                female_rb.setSelected(true);
            else
                neither_rb.setSelected(true);
        }
        else 
            neither_rb.setSelected(true);
    }
    /** 
     * Create the add/edit and view JPanels.
     *
     * This method is used to generate the add/edit and view JPanels which 
     * represent the modes of interacting with Person objects. 
     *
     * @return JPanel person_panel
     */
    private void initPanel()
    {
        person_panel = new JPanel();
        person_panel.setLayout(new BorderLayout());

        status_panel = new JPanel();
        status_label = new JLabel("Search for a Person.");
        status_label.setHorizontalAlignment(JLabel.LEFT);
        status_panel.add(status_label);

        bottom_panel = new JPanel();
        bottom_panel.setLayout(new BoxLayout(bottom_panel, BoxLayout.X_AXIS));
        bottom_panel.add(status_panel);

        initAddPanel();

        // The first view shown to the user is the add/edit view.
        content_panel = add_panel;

        person_panel.add(content_panel, BorderLayout.CENTER);
        person_panel.add(bottom_panel, BorderLayout.SOUTH);

        // This is used by the main View to set the size of the Person Panel.
        person_panel.setName("add mode");
    }

    /** 
     * 
     * Initialize the add/edit JPanel.
     *
     * This panel is laid out in two rows, wth the content in each row evenly
     * spaced so as to be visually appealing. To make this work, each 
     * JLabel and associted text field (or radio button) is put within a 
     * JPanel, and then each JPanel is added to a JPanel for the row. Each 
     * row's JPanel uses the X_AXIS layout mode of BoxLayout to enable even
     * spacing of the components across the screen.
     *
     */
    private void initAddPanel()
    {
        add_panel = new JPanel();
        add_panel.setLayout(new BoxLayout(add_panel, 
                                              BoxLayout.Y_AXIS));

        submit_panel = new JPanel();
        submit_button = new JButton("search");
        view_button = new JButton("view person list");
        submit_button.addActionListener(listener);
        view_button.addActionListener(listener);
        submit_panel.add(submit_button);
        submit_panel.add(view_button);
        bottom_panel.add(submit_panel);

        // First row, basic identity information
        first_name_label = new JLabel("First name: ");
        first_name_tf = new JFormattedTextField();
        first_name_tf.setColumns(10);
        AbstractDocument fn_doc = (AbstractDocument)first_name_tf.getDocument();
        fn_doc.setDocumentFilter(NameFieldValidator.getInstance());
        last_name_label = new JLabel("Last name: ");
        last_name_tf = new JFormattedTextField();
        last_name_tf.setColumns(10);;
        AbstractDocument ln_doc = (AbstractDocument)last_name_tf.getDocument();
        ln_doc.setDocumentFilter(NameFieldValidator.getInstance());
        date_of_birth_label = new JLabel("Date-of-birth: ");
        date_of_birth_tf = new JFormattedTextField();
        date_of_birth_tf.setColumns(10);
        date_of_birth_tf.setInputVerifier(DateFieldValidator.getInstance());
        JPanel first_name_panel = new JPanel();
        first_name_panel.add(first_name_label);
        first_name_panel.add(first_name_tf);
        JPanel last_name_panel = new JPanel();
        last_name_panel.add(last_name_label);
        last_name_panel.add(last_name_tf);
        JPanel date_of_birth_panel = new JPanel();
        date_of_birth_panel.add(date_of_birth_label);
        date_of_birth_panel.add(date_of_birth_tf);

        gender_label = new JLabel("Gender: ");
        gender_selection = new ButtonGroup();
        male_rb = new JRadioButton("male");
        female_rb = new JRadioButton("female");
        neither_rb = new JRadioButton("neither");
        gender_selection.add(male_rb);
        gender_selection.add(female_rb);
        gender_selection.add(neither_rb);

        gender_panel = new JPanel();
        gender_panel.add(gender_label);
        gender_panel.add(male_rb);
        gender_panel.add(female_rb);
        gender_panel.add(neither_rb);

        JPanel row1 = new JPanel();
        row1.setLayout(new BoxLayout(row1, BoxLayout.X_AXIS));
        row1.add(first_name_panel);
        row1.add(last_name_panel);
        row1.add(date_of_birth_panel);
        row1.add(gender_panel);

        add_panel.add(row1);

        // Second row: broader demographic information
        village_label = new JLabel("Village: ");
        village_tf = new JFormattedTextField();
        village_tf.setColumns(10);
        AbstractDocument v_doc = (AbstractDocument)village_tf.getDocument();
        v_doc.setDocumentFilter(NameFieldValidator.getInstance());
        tribe_label = new JLabel("Tribe: ");
        tribe_tf = new JFormattedTextField();
        tribe_tf.setColumns(10);
        AbstractDocument t_doc = (AbstractDocument)tribe_tf.getDocument();
        t_doc.setDocumentFilter(NameFieldValidator.getInstance());
        JPanel village_panel = new JPanel();
        JPanel tribe_panel = new JPanel();
        village_panel.add(village_label);
        village_panel.add(village_tf);
        tribe_panel.add(tribe_label);
        tribe_panel.add(tribe_tf);

        house_number_label = new JLabel("House number: ");
        house_number_tf = new JFormattedTextField();
        house_number_tf.setColumns(10);
        AbstractDocument house_n_doc = 
                         (AbstractDocument)house_number_tf.getDocument();
        house_n_doc.setDocumentFilter(NumberFieldValidator.getInstance());
        insurance_number_label = new JLabel("Insurance number: ");
        insurance_number_tf = new JFormattedTextField();
        insurance_number_tf.setColumns(10);
        AbstractDocument ins_n_doc = 
                         (AbstractDocument)insurance_number_tf.getDocument();
        ins_n_doc.setDocumentFilter(NumberFieldValidator.getInstance());
        national_id_label = new JLabel("National ID: ");
        national_id_tf = new JFormattedTextField();
        national_id_tf.setColumns(10);
        AbstractDocument nat_id_doc = 
                         (AbstractDocument)national_id_tf.getDocument();
        nat_id_doc.setDocumentFilter(NumberFieldValidator.getInstance());
        JPanel house_number_panel = new JPanel();
        JPanel insurance_number_panel = new JPanel();
        JPanel national_id_panel = new JPanel();
        house_number_panel.add(house_number_label);
        house_number_panel.add(house_number_tf);
        insurance_number_panel.add(insurance_number_label);
        insurance_number_panel.add(insurance_number_tf);
        national_id_panel.add(national_id_label);
        national_id_panel.add(national_id_tf);

        JPanel row2 = new JPanel();
        row2.setLayout(new BoxLayout(row2, BoxLayout.X_AXIS));
        row2.add(village_panel);
        row2.add(tribe_panel);
        row2.add(house_number_panel);
        row2.add(insurance_number_panel);
        row2.add(national_id_panel);

        add_panel.add(row2);
    }

    /** 
     * Update the add/edit panel.
     *
     * Reconstruct the add/edit panel
     */
    private void updateAddPanel()
    {
        add_panel.removeAll();

        // First row, basic identity information
        JPanel first_name_panel = new JPanel();
        first_name_panel.add(first_name_label);
        first_name_panel.add(first_name_tf);
        JPanel last_name_panel = new JPanel();
        last_name_panel.add(last_name_label);
        last_name_panel.add(last_name_tf);
        JPanel date_of_birth_panel = new JPanel();
        date_of_birth_panel.add(date_of_birth_label);
        date_of_birth_panel.add(date_of_birth_tf);

        gender_panel = new JPanel();
        gender_panel.add(gender_label);
        gender_panel.add(male_rb);
        gender_panel.add(female_rb);
        gender_panel.add(neither_rb);

        JPanel row1 = new JPanel();
        row1.setLayout(new BoxLayout(row1, BoxLayout.X_AXIS));
        row1.add(first_name_panel);
        row1.add(last_name_panel);
        row1.add(date_of_birth_panel);
        row1.add(gender_panel);

        add_panel.add(row1);

        // Second row: broader demographic information
        JPanel village_panel = new JPanel();
        JPanel tribe_panel = new JPanel();
        village_panel.add(village_label);
        village_panel.add(village_tf);
        tribe_panel.add(tribe_label);
        tribe_panel.add(tribe_tf);

        JPanel house_number_panel = new JPanel();
        JPanel insurance_number_panel = new JPanel();
        JPanel national_id_panel = new JPanel();
        house_number_panel.add(house_number_label);
        house_number_panel.add(house_number_tf);
        insurance_number_panel.add(insurance_number_label);
        insurance_number_panel.add(insurance_number_tf);
        national_id_panel.add(national_id_label);
        national_id_panel.add(national_id_tf);

        JPanel row2 = new JPanel();
        row2.setLayout(new BoxLayout(row2, BoxLayout.X_AXIS));
        row2.add(village_panel);
        row2.add(tribe_panel);
        row2.add(house_number_panel);
        row2.add(insurance_number_panel);
        row2.add(national_id_panel);

        add_panel.add(row2);

        bottom_panel.removeAll();
        bottom_panel.add(status_panel);
        bottom_panel.add(submit_panel);
        submit_panel.removeAll();
        submit_panel.add(submit_button);
        submit_panel.add(view_button);
        add_panel.add(bottom_panel);
        
        person_panel = add_panel;
        person_panel.setName("add mode");
    }

    /** 
     * Edit the information for this Person.
     *
     * This method enables the editing of a Person's info.
     */
    public void editPerson()
    {
        updateAddPanel();
        /* Change the title of the submit button and the status panel to make
         * it clear that we are editing a Person's info. Also add a cancel 
         * button to enable discarding these changes.*/
        display("editing information.");
        submit_button.setText("update");
        cancel_button = new JButton("cancel");
        cancel_button.addActionListener(listener);
        submit_panel.add(cancel_button);
    }

    /** 
     * Update search query.
     *
     * This method will enable the updating of a search.
     *
     */
    public void updateSearch()
    {
        updateAddPanel();
        display("update search.");
    }

    /** 
     * Display the UI for adding a Person.
     *
     * This method enables the adding of a new Person.
     */
    public void addPerson()
    {
        initPanel();
    }

    /** 
     * 
     * Create the View mode of the Person Panel.
     * 
     * The view mode does allow editing of fields without pressing the
     * edit button.
     *
     * This method will only be called the first time displayPerson(...) is 
     * called.
     * 
     * @param person Person whose information is being displayed
     */
    private void initViewPanel()
    {
        JPanel first_name_panel = new JPanel();
        first_name_panel.add(first_name_label);
        first_name_panel.add(new JLabel(first_name_tf.getText()));

        JPanel last_name_panel = new JPanel();
        last_name_panel.add(last_name_label);
        last_name_panel.add(new JLabel(last_name_tf.getText()));

        JPanel gender_panel = new JPanel();
        gender_panel.add(gender_label);
        if (gender_selection.getSelection() != null)
        {
            if (male_rb.isSelected())
                gender_panel.add(new JLabel("male"));
            else if (female_rb.isSelected())
                gender_panel.add(new JLabel("female"));
        }

        JPanel dob_panel = new JPanel();
        dob_panel.add(date_of_birth_label);
        dob_panel.add(new JLabel(formatDateOfBirth()));

        JPanel row1 = new JPanel();
        row1.setLayout(new BoxLayout(row1, BoxLayout.X_AXIS));
        row1.add(first_name_panel);
        row1.add(last_name_panel);
        row1.add(gender_panel);
        row1.add(dob_panel);

        view_panel = new JPanel();
        view_panel.setLayout(new BorderLayout());
        view_panel.add(row1, BorderLayout.CENTER);
        view_panel.add(bottom_panel, BorderLayout.SOUTH);

        submit_panel.removeAll();
        edit_button = new JButton("edit");
        edit_button.addActionListener(listener);
        submit_panel.add(edit_button);
        submit_panel.add(view_button);
        add_button = new JButton("add another Person");
        add_button.addActionListener(listener);
        submit_panel.add(add_button);

        person_panel = view_panel;
        person_panel.setName("view mode");
    }

    /** 
     * Make a 'mm/dd/yyyy' formatted String for the date-of-birth.
     *
     * This method is used to create the formatting for the view mode.
     * 
     * @return the formatted date-of-birth String
     */
    private String formatDateOfBirth()
    {
        SimpleDateFormat date_format = new SimpleDateFormat("MM/dd/yyyy");

        String dob = "";

        try
        {
            dob = date_format.format(date_of_birth_tf.getValue());
        }
        catch (Exception ignore) {}

        return dob;
    }

    /** 
     * Initialize the selection mode of the Person Panel.
     *
     * This method initializes the mode of the panel where one chooses whether
     * or not to use the person they have selected. It is a glorified version
     * of the view mode of the panel with the addition of a "use this person"
     * button.
     *
     */
    private void initSelectionPanel()
    {
        JPanel first_name_panel = new JPanel();
        first_name_panel.add(first_name_label);
        first_name_panel.add(new JLabel(first_name_tf.getText()));

        JPanel last_name_panel = new JPanel();
        last_name_panel.add(last_name_label);
        last_name_panel.add(new JLabel(last_name_tf.getText()));

        JPanel gender_panel = new JPanel();
        gender_panel.add(gender_label);
        if (gender_selection.getSelection() != null)
        {
            if (male_rb.isSelected())
                gender_panel.add(new JLabel("male"));
            else if (female_rb.isSelected())
                gender_panel.add(new JLabel("female"));
        }

        JPanel dob_panel = new JPanel();
        dob_panel.add(date_of_birth_label);
        dob_panel.add(new JLabel(formatDateOfBirth()));

        JPanel row1 = new JPanel();
        row1.setLayout(new BoxLayout(row1, BoxLayout.X_AXIS));
        row1.add(first_name_panel);
        row1.add(last_name_panel);
        row1.add(gender_panel);
        row1.add(dob_panel);
        
        JPanel village_panel = new JPanel();
        village_panel.add(village_label);
        village_panel.add(new JLabel(village_tf.getText()));

        JPanel tribe_panel = new JPanel();
        tribe_panel.add(tribe_label);
        tribe_panel.add(new JLabel(tribe_tf.getText()));

        JPanel house_number_panel = new JPanel();
        house_number_panel.add(house_number_label);
        house_number_panel.add(new JLabel(house_number_tf.getText()));

        JPanel insurance_number_panel = new JPanel();
        insurance_number_panel.add(insurance_number_label);
        insurance_number_panel.add(new JLabel(insurance_number_tf.getText()));

        JPanel national_id_panel = new JPanel();
        national_id_panel.add(national_id_label);
        national_id_panel.add(new JLabel(national_id_tf.getText()));

        JPanel row2 = new JPanel();
        row2.setLayout(new BoxLayout(row2, BoxLayout.X_AXIS));
        row2.add(village_panel);
        row2.add(tribe_panel);
        row2.add(house_number_panel);
        row2.add(insurance_number_panel);
        row2.add(national_id_panel);

        JPanel selection_panel = new JPanel();
        selection_panel.setLayout(new BoxLayout(selection_panel, 
                                                BoxLayout.Y_AXIS));
        selection_panel.add(row1);
        selection_panel.add(row2);
        selection_panel.add(bottom_panel);

        submit_panel.removeAll();

        JButton use_button = new JButton("Use this Person");
        cancel_button = new JButton("cancel");
        cancel_button.addActionListener(listener);
        use_button.addActionListener(listener);
        submit_panel.add(use_button);
        submit_panel.add(cancel_button);

        person_panel = selection_panel;
        person_panel.setName("select mode");
    }

    /** 
     * 
     * Get a reference to the JPanel for a Person.
     * 
     * This method will give a reference to the panel where information about
     * a Person is shown and can be edited (in the right mode). 
     * 
     * @return a reference to the Person JPanel
     */
    public JPanel getPanel()
    {
        return person_panel;    
    }

    /** 
     *
     * Have the person panel display some status message.
     * 
     * @param msg the message to display
     */
    public void display(String msg)
    {
        status_label.setText(msg);
        status_label.invalidate();
    }

    /** 
     *
     * Display the info for this Person.
     *
     * This activates the View mode of the person panel, which means that one
     * can only edit the informaiton fields for the person by clicking the edit
     * button (in the bottom panel).
     * 
     */
     public void displayPerson()
     {
        initViewPanel();
     }

    /**
     * Display info for this Person, with a cancel button.
     *
     * This activates the View mode of the person panel, which means that one
     * can only edit the informaiton fields for the person by clicking the edit
     * button (in the bottom panel). It also adds a cancel button to the bottom
     * panel allowing to exit the Person Management mode at any time.
     *
     */
    public void displayPersonWithCancel()
    {
        initViewPanel();
        if (cancel_button == null)
        {
            cancel_button = new JButton("cancel");
            cancel_button.addActionListener(listener);
        }
        submit_panel.add(cancel_button);
    }

    /** 
     * Display the info of the Person passed in.
     *
     * @param p the Person whose info is to be displayed
     */
    public void displayPerson(Person p)
    {

        // set the info for all of the fields with this Person's info
        setInfo(p.getInfo());

        initSelectionPanel();
    }
}
