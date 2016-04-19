package edu.usm.cos420.health.controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

import edu.usm.cos420.health.consultingregister.controller.PersonController;
import edu.usm.cos420.health.consultingregister.controller.RegisterItemController;
import edu.usm.cos420.antenatal.controller.AntenatalController;
import edu.usm.cos420.health.consultingregister.controller.PeopleController;
import edu.usm.cos420.health.consultingregister.view.PersonView;
import edu.usm.cos420.health.consultingregister.view.RegisterItemView;
import edu.usm.cos420.health.consultingregister.view.PeopleView;
import edu.usm.cos420.health.consultingregister.view.RegisterItemView;

import edu.usm.cos420.health.domain.Person;
import edu.usm.cos420.health.view.HealthView;
import edu.usm.cos420.health.view.View;

/** 
 * Main controller for View
 *
 * This class manages the entire user interface.
 *
 * @author Samuel Barton
 */
public class Controller implements ActionListener
{
    private View view;
    private PersonController person_controller;
    private PeopleController people_controller;
    private PeopleView people_view;
    private RegisterItemView register_view;
    private RegisterItemController register_controller;
    private AntenatalController antenatal_controller;
    
    /** 
     * No argument constructor
     *
     * Create controller for the Person UI, the view for the Register (no
     * controller has been written for it yet), and then create the View for
     * the main UI.
     *
     */
    public Controller()
    {
        person_controller = new PersonController(this);
        register_controller = new RegisterItemController(this);
        
        
        view = new View(this, person_controller, register_controller);
    }

    /** 
     * Refresh the user interface
     */
    public void refreshPersonPanel()
    {
        view.refreshPersonPanel();
    }
    
    /** 
     * 
     * This method creates the Person Management tab if it does not yet exist,
     * and puts the results (if any) in a list on the window. If the Person
     * Management tab already exists, then the data it's displaying is updated.
     *
     * @param results the list of Person objects found
     */
    public void submitPersonSearchResults(ArrayList<Person> results)
    {
        if (view.getTabTitle(0).equals("Person Management"))
        {
            people_controller.updateResults(results);
            view.refreshContentPanel(people_view.getPanel());
        }
        else
        {
            people_controller = new PeopleController(person_controller, 
                                                     results);
            people_view = people_controller.getView();

            view.addTab("Person Management", people_view.getPanel(), 0);
        }
    }

    /** 
     * This method removes the Person Management tab from the user interface.
     *
     * It is called by 
     * @see health.consultingregister.controller.PersonController 
     *
     */
    public void removePersonManagementTab()
    {
        if (view.getTabTitle(0).equals("Person Management"))
            view.removeTab(0);
    }

    /** 
     * This method determines whether or not we are in Person Management mode.
     *
     * @return whether or not we are in Person Management mode
     */
    public boolean inPersonManagement()
    {
        return view.getTabTitle(0).equals("Person Management");
    }

    /** 
     * Not implemented. (may be in future).
     * 
     * @param e the ActionEvent
     */
    public void actionPerformed(ActionEvent e)
    {

    }
}
