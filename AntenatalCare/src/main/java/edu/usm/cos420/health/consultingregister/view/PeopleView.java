package edu.usm.cos420.health.consultingregister.view;

import java.util.ArrayList;
import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

import edu.usm.cos420.health.consultingregister.controller.PersonController;
import edu.usm.cos420.health.domain.Person;
import edu.usm.cos420.health.view.HealthView;

/** 
 * This class encapsulate the user interface for people management.
 * 
 * This is used in combination with the PersonView class to provide the entire 
 * Person management piece of the project. The panel produced by this class is 
 * put in the content panel of the main UI. 
 *
 * This panel has two modes, the first is displaying a list of matching People
 * entries as a list, and the other is displaying the diaolog to add a new 
 * Person to the PeopleDatabase.
 *
 * @author Samuel Barton
 */
public class PeopleView implements HealthView
{
    private JPanel people_panel;
    private JList<Person> people_list;
    private JScrollPane list_scroll_pane;

    private ActionListener action_l;
    private ListSelectionListener list_l;;

    /** 
     * Constructor :
     * 
     * Create a new PeopleView object passing in the listeners to use for its 
     * various JComponents, and the list of People to display. This list may
     * be empty.
     *
     * @param a the listener for the JComponents
     * @param l the listener for the JList
     * @param people the list of People to display
     */
    public PeopleView(ActionListener a, 
                      ListSelectionListener l, ArrayList<Person> people)
    {
        action_l = a;
        list_l = l;
        showPeople(people);
    }

    private void showPeople(ArrayList<Person> people)
    {
        JPanel list_panel = new JPanel(new BorderLayout());

        if (people.isEmpty())
        {
            JPanel msg_panel = new JPanel();
            JLabel message = new JLabel("No results found.\n"+
                                        "Would you like to add this Person?");
            JButton yes_button = new JButton("yes");
            yes_button.addActionListener(action_l);
            JButton no_button = new JButton("no");
            no_button.addActionListener(action_l);
            msg_panel.add(message);
            JPanel button_panel = new JPanel();
            button_panel.add(yes_button);
            button_panel.add(no_button);
            
            JPanel dialog_panel = new JPanel();
            dialog_panel.setLayout(new BoxLayout(dialog_panel, 
                                                 BoxLayout.Y_AXIS));
            dialog_panel.add(msg_panel);
            dialog_panel.add(button_panel);
            list_panel.add(dialog_panel, BorderLayout.CENTER);
            list_panel.setName("Empty");
        }
        else
        {
            people_list = new JList<Person>(new Vector<Person>(people));
            people_list.addListSelectionListener(list_l);
            people_list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            list_scroll_pane = new JScrollPane(people_list);
            list_panel.add(list_scroll_pane, BorderLayout.CENTER);
            list_panel.setName("Not Empty");
        }

        people_panel = list_panel;
    }

    /** 
     * Update the list of people to display.
     *
     * @param results the list of people to display
     */
    public void updateResults(ArrayList<Person> results)
    {
        showPeople(results);
    }

    /** 
     * Get the JPanel to use in the main View's UIPanel for Person management.
     *
     * @return the People JPanel
     */
    public JPanel getPanel()
    {
        return people_panel;
    }
}
