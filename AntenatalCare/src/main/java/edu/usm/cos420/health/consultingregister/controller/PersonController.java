package edu.usm.cos420.health.consultingregister.controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

import edu.usm.cos420.health.consultingregister.view.PersonView;
import edu.usm.cos420.health.consultingregister.service.PersonService;
import edu.usm.cos420.health.consultingregister.PersonData;

import edu.usm.cos420.health.domain.Person;
import edu.usm.cos420.health.controller.Controller;
import edu.usm.cos420.health.controller.HealthController;

/** 
 * Controller object for the PersonView class
 * 
 * This class is the controller for the PersonView, which is the view object
 * responsible for the top portion of the main UI where person information is
 * added, edited, and viewed.
 *
 * @author Samuel Barton
 */
public class PersonController implements ActionListener, HealthController
{
    private PersonService service;
    private Controller controller;
    private PersonView person_view;
    private PersonData person_data;

    /** 
     * Single-argument Constructor
     *
     * This constructor builds the PersonView object, passing in a reference to
     * this controller. It also creates the service class used to gain access
     * to the DAO.
     *
     * @param c the Controller for the main UI
     */
    public PersonController(Controller c)
    {
        controller = c;
        person_view = new PersonView(this);
        service = new PersonService();
        person_data = PersonData.getInstance();
    }

    /** 
     * Handle ActionEvents
     *
     * This method handles the ActionEvents sent out by the UI.
     *
     * @param e the event to handle
     */
    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("yes"))
        {
            Person person = new Person(person_view.getInfo());
            person_data.setPerson(person);
            service.addPerson(person);
            person_view.display("Person added.");
            controller.removePersonManagementTab();
        }
        else if (e.getActionCommand().equals("no"))
        {
            person_view.display("Enter Person information.");
            controller.removePersonManagementTab();
            person_view.addPerson();
        }
        else if (e.getActionCommand().equals("Use this Person"))
        {
            person_view.displayPerson();
            person_view.display("Person selected.");
            controller.removePersonManagementTab();
        }
        else if (e.getActionCommand().equals("edit"))
        {
            if (controller.inPersonManagement())
                person_view.updateSearch(); 
            else
                person_view.editPerson();
        }
        else if (e.getActionCommand().equals("search"))
        {
            person_view.display("Searching...");
            ArrayList<Person> result = 
                              service.findPeople(person_view.getInfo());

            person_view.displayPersonWithCancel();
            controller.submitPersonSearchResults(result);
            
            person_view.display(result.size()+" results found.");
        }
        else if (e.getActionCommand().equals("update"))
        {
            /* update the info about this Person before sending the changes to
             the DAO. */
            person_data.getPerson().setInfo(person_view.getInfo());
            service.updatePerson(person_data.getPerson());
            person_view.display("Information updated");
            person_view.displayPerson();
        }
        else if (e.getActionCommand().equals("view person list"))
        {
            person_view.display("Showing Person list.");
            controller.submitPersonSearchResults(service.getPeople());
            person_view.displayPersonWithCancel();
        }
        else if (e.getActionCommand().equals("cancel"))
        {
            /* this is dangerous, it begins to break down the MVC separation
             * principle. */
            if (controller.inPersonManagement() && 
                person_view.getPanel().getName().equals("view mode"))
            {
                controller.removePersonManagementTab();
                person_view.displayPerson();
                person_view.display("Search for or view Person list.");
            }
            else if (controller.inPersonManagement())
                person_view.displayPersonWithCancel();
            else 
            {
                person_view.displayPerson();
                person_view.display("Search for or view Person list.");
            }

            person_view.setInfo(person_data.getPerson().getInfo());
        }
        else if (e.getActionCommand().equals("add another Person"))
        {
            person_view.addPerson();
        }

        controller.refreshPersonPanel();
    }

    /** 
     * Display the information associated with the Person
     *
     * @param p the Person whose information is being displayed
     */
    public void displayPerson(Person p)
    {
        person_view.displayPerson(p);
        controller.refreshPersonPanel();
    }

    /** 
     * Return the PersonView object.
     *
     * This method is used by the main UI to get the PersonView object.
     *
     * @return the PersonView object
     */
    public PersonView getView()
    {
        return person_view;
    }
}
