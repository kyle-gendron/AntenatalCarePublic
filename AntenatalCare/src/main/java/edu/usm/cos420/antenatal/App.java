package edu.usm.cos420.antenatal;

import java.awt.EventQueue;

import edu.usm.cos420.antenatal.controller.AntenatalController;
import edu.usm.cos420.antenatal.service.AntenatalService;
import edu.usm.cos420.antenatal.service.impl.AntenatalService1;
import edu.usm.cos420.antenatal.view.impl.AntenatalView;

/**
 * Top level application class that coordinates the calls to view and Controller
 */
public class App {
    /**
     * Entry point for application : calls {@link AntenatalView}
     *
     * @param args main program arguments, currently not used
     */
    public static void main(String[] args) {
        AntenatalService1 service = new AntenatalService1();
        AntenatalView aView = new AntenatalView(service);
        AntenatalController controller = new AntenatalController(aView, service);
        controller.provideCItemAccess();
        EventQueue.invokeLater(() -> aView.setVisible(true));
    }
}
