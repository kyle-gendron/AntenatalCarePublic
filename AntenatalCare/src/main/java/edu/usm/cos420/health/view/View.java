package edu.usm.cos420.health.view;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.GraphicsEnvironment;

import edu.usm.cos420.health.consultingregister.view.PersonView;
import edu.usm.cos420.health.consultingregister.view.RegisterItemView;
import edu.usm.cos420.antenatal.controller.AntenatalController;
import edu.usm.cos420.antenatal.view.impl.AntenatalView;
import edu.usm.cos420.health.consultingregister.controller.PersonController;
import edu.usm.cos420.health.consultingregister.controller.RegisterItemController;
import edu.usm.cos420.health.controller.Controller;

/*=============================================================================
 *
 * Class name: View
 *
 * Project: Consulting Register
 *
 * Creator: Samuel Barton 
 *
 * Implemented interfaces: ChangeListener
 *
 * Description: This class encapsulates the bounding window which holds the 
 *              UI for adding/searching Persons, and the UI for adding a
 *              register item.
 *
 *===========================================================================*/

/** 
 * The main user interface View object.
 *
 * @author Samuel Barton
 */
public class View implements ChangeListener
{
    private JFrame user_interface;
    private JTabbedPane application_pane;

    private PersonView person_view;
    private PersonController person_controller;

    private RegisterItemView register_view;
    private RegisterItemController register_controller;

    private AntenatalController anteControl;
    private AntenatalView anteView;
    
    private Controller controller;

    // these need to be set relative to the computer and not statically
    public static final int WINDOW_WIDTH;
    public static final int WINDOW_HEIGHT;
    
    // Set window width and height to the screen size
    static
    {
        Rectangle screen_size = GraphicsEnvironment.
                                getLocalGraphicsEnvironment().
                                getMaximumWindowBounds();

        WINDOW_WIDTH = screen_size.width;
        WINDOW_HEIGHT = screen_size.height;
    }

    /** 
     * This class is used to have both Person information, and each projects 
     * information.
     *
     * Each tab in the main interface is an instance of this class. 
     *
     * This class is only used within the context of the maine user interface.
     * @author Samuel Barton
     */
    private class UIPanel extends JPanel
    {
        private JPanel person_panel;
        private JPanel content_panel;
        private final int PANEL_WIDTH;
        private final int PANEL_HEIGHT;

        /** 
         * Create a JPanel and set its size to fit within the window as needed,
         * and then initialize the panel with the Person Panel and the Content
         * Panel.
         * 
         * @param cp each projects content.
         */
        private UIPanel(JPanel cp)
        {
            super();
            /* These sizing values are based off of the Mac OSX default look
             * and feel, they may not work on a windows environment. */
            PANEL_WIDTH = WINDOW_WIDTH - 22;
            PANEL_HEIGHT = WINDOW_HEIGHT - 60;

            // Use absolute positioning
            setLayout(null);

            init(cp);
        }

        /** 
         * Initialize the UIPanel.
         *
         * The relative sizes of each panel depends on the mode the person
         * panel is in.
         *
         * @param cp the content panel
         */
        private void init(JPanel cp)
        {
            // Clear the panel
            this.removeAll();

            // Get the current version of the Person Panel
            person_panel = person_view.getPanel();
            
            /* Set the ratio between the amount of screen space used by the 
             * Person Panel and the Content Panel. If we are adding a Person, 
             * then the Person Panel should take up 1/6th of the UIPanel, 
             * otherwise the Person Panel should take up 1/12th of the UIPanel.
             */
            int height_fraction = 1;
            String name = person_panel.getName();
            if (name.equals("add mode"))
                height_fraction = 6;
            else if (name.equals("view mode"))
                height_fraction = 12;
            else
                height_fraction = 8;

            // add the Person Panel, using absolute coordinates.
            person_panel.setSize(PANEL_WIDTH, PANEL_HEIGHT/height_fraction);
            this.add(person_panel);

            // add the content panel using absolute coordinates.
            content_panel = cp;
            content_panel.setSize(PANEL_WIDTH, 
            (height_fraction - 1)*(PANEL_HEIGHT/height_fraction));
            content_panel.setLocation(1, PANEL_HEIGHT/height_fraction);
            this.add(content_panel);
            // refresh the UIPanel
            this.repaint();
        }

        /** 
         * Refresh the Person Panel.
         *
         * This does not change the content panel.
         *
         */
        private void enablePersonPanel()
        {
            init(content_panel);
        }

        /** 
         * Refresh the entire window.
         *
         * This changes the content panel.
         *
         * @param cp content_panel to update
         */
        private void updateContentPanel(JPanel cp)
        {
            init(cp);
        }
    }

    /** 
     * Build the main user interface.
     *
     * @param c main controller
     * @param pc person controller
     */
    public View(Controller c, PersonController pc, RegisterItemController rc, AntenatalController ac)
    {
        controller = c;
        person_controller = pc;
        person_view = pc.getView();
        anteControl = ac;
        anteView = ac.getView();
        register_controller = rc;
        register_view = rc.getView();
        init();
    }

    /** 
     * Add a tab to the UI.
     *
     * @param name the name of the tab
     * @param c_p the content to put in the tab
     *
     */
    public void addTab(String name, JPanel c_p)
    {
        UIPanel panel = new UIPanel(c_p);

        application_pane.addTab(name, panel);
    }

    /** 
     * Add a tab to the UI, specifying its index.
     *
     * @param name the name of the tab
     * @param c_p the content to put in the tab
     * @param n the index of the tab.
     */
    public void addTab(String name, JPanel c_p, int n)
    {
        UIPanel panel = new UIPanel(c_p);
        panel.setName(name);

        application_pane.add(panel, n);
        application_pane.setSelectedIndex(n);
    }

    /** 
     * Remove a tab from the UI.
     *
     * The specified index will be removed.
     *
     * @param n the indx to remove.
     */
    public void removeTab(int n)
    {
        application_pane.remove(n);
    }

    /** 
     * Get the title of a tab.
     * @param n the index of the tab
     * @return the title of the tab referenced by index n
     */
    public String getTabTitle(int n)
    {
        return application_pane.getTitleAt(n);
    }

    /** 
     * Initialize the main user interface.
     */
    private void init()
    {
        // Initialize the main Frame for the UI.
        user_interface = new JFrame("Register");
        user_interface.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        user_interface.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        user_interface.setResizable(false);
  

        // In this pane will be the team code pane, and the person pane
        application_pane = new JTabbedPane();
        application_pane.addChangeListener((ChangeListener)this);
        application_pane.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        // Make the the frame's content pane the application pane
        user_interface.setContentPane(application_pane);

        // Make blank content panels for the other projects.
        JPanel antenatal_panel = new JPanel();
        antenatal_panel.add(anteView);
        JPanel disease_panel = new JPanel();
        disease_panel.setBackground(Color.green);
        JPanel birth_panel = new JPanel();
        birth_panel.setBackground(Color.yellow);
        JPanel family_panel = new JPanel();
        family_panel.setBackground(Color.blue);
        JPanel childhood_panel = new JPanel();
        childhood_panel.setBackground(Color.cyan);

        // Add tabs for all the projects, including ours
        addTab("Register", register_view.getPanel());
        addTab("Antenatal Care", antenatal_panel);
        addTab("Disease Surveillance", disease_panel);
        addTab("Birth and Deliveries", birth_panel);
        addTab("Family Planning", family_panel);
        addTab("Childhood Immunizations", childhood_panel);

        // need a header pane for the PersonView stuff 
        refreshPersonPanel();
        user_interface.setVisible(true);
    }

    /** 
     * Refresh the currently visible tab.
     */
    public void refreshPersonPanel()
    {
        ((UIPanel)application_pane.getSelectedComponent()).enablePersonPanel();
        user_interface.repaint();
    }

    /** 
     * Refresh the currently visible tab, changing the content panel.
     *
     * @param cp 
     */
    public void refreshContentPanel(JPanel cp)
    {
        ((UIPanel)application_pane.getSelectedComponent())
                                  .updateContentPanel(cp);
        user_interface.repaint();
    }

    /** 
     * Implementing the ChangeListener interface 
     * @param e 
     */
    public void stateChanged(ChangeEvent e)
    {
        refreshPersonPanel();
    }
}
