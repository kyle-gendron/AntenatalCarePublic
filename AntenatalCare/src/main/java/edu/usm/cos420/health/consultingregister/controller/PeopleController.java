package edu.usm.cos420.health.consultingregister.controller;

import java.util.ArrayList;

import javax.swing.JList;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import edu.usm.cos420.health.consultingregister.view.PeopleView;
import edu.usm.cos420.health.consultingregister.controller.PersonController;
import edu.usm.cos420.health.consultingregister.PersonData;

import edu.usm.cos420.health.controller.HealthController;
import edu.usm.cos420.health.domain.Person;

/**
 * Controller for People domain object.
 *
 */
public class PeopleController implements ListSelectionListener, HealthController
{
    PeopleView people_view;
    PersonController person_controller;
    PersonData person_data;

    public PeopleController(PersonController c, ArrayList<Person> people)
    {
        people_view = new PeopleView(c, this, people);
        person_controller = c;
        person_data = PersonData.getInstance();
    }

    public void updateResults(ArrayList<Person> results)
    {
        people_view.updateResults(results);
    }

    public void valueChanged(ListSelectionEvent e)
    { 
        if(e.getValueIsAdjusting())
        {
            Person person = ((JList<Person>)e.getSource()).getSelectedValue();
            person_controller.displayPerson(person);
            person_data.setPerson(person);
        }
    }

    public PeopleView getView()
    {
        return people_view;
    }
}
