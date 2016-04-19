package edu.usm.cos420.health.consultingregister.controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.util.ArrayList;

import edu.usm.cos420.health.consultingregister.view.PersonView;
import edu.usm.cos420.health.consultingregister.view.RegisterItemView;
import edu.usm.cos420.health.consultingregister.service.RegisterItemService;

import edu.usm.cos420.health.consultingregister.domain.RegisterItem;
import edu.usm.cos420.health.controller.Controller;
import edu.usm.cos420.health.controller.HealthController;
import edu.usm.cos420.health.domain.Person;

public class RegisterItemController implements ActionListener, HealthController
{
    private RegisterItemService service;
    
    private Controller controller;

    private RegisterItemView visit_view;
    private PersonView person_view;

    public RegisterItemController(Controller c)
    {
        controller = c;
        visit_view = new RegisterItemView(this);
        service = new RegisterItemService();
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getActionCommand().equals("yes"))
        {
            service.addVisit(new RegisterItem(person_view.getInfo(), 
                             visit_view.getInfo(), visit_view.getVitals()));
            visit_view.display("Visit added.");
            //controller.removePersonManagementTab();
        }
        else if (e.getActionCommand().equals("no"))
        {
            visit_view.display("Enter visit information.");
            //controller.removePersonManagementTab();
            visit_view.addVisit();
        }
        else if (e.getActionCommand().equals("Use this visit"))
        {
            visit_view.displayVisit();
            //controller.removePersonManagementTab();
        }
        else if (e.getActionCommand().equals("edit"))
        {
            visit_view.display("Editing visit info.");
            visit_view.editVisit();
        }
        else if (e.getActionCommand().equals("submit"))
        {
            visit_view.display("Searching...");
            ArrayList<RegisterItem> result = service.findVisits(
                                             visit_view.getInfo(), 
                                             new Person(person_view.getInfo()));

            visit_view.displayVisit();
            //controller.submitPersonSearchResults(result);
            
            visit_view.display(result.size()+" results found.");
        }
        
        controller.refreshPersonPanel();
    }

    public void displayVisit(RegisterItem r)
    {
        visit_view.displayVisit(r);
        //controller.refreshPersonPanel();
    }

    public RegisterItemView getView()
    {
        return visit_view;
    }
}
