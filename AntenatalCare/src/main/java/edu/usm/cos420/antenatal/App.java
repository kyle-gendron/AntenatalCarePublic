package edu.usm.cos420.antenatal;

import edu.usm.cos420.antenatal.controller.AntenatalController;

import java.awt.*;

/**
 * Top level application class that coordinates the calls to view and Controller
 */
public class App {
	/**
	 * Entry point for application : calls {@link AntenatalController}
	 *
	 * @param args
	 *            main program arguments, currently not used
	 */
	public static void main(String[] args) {
	  
      AntenatalController controller = new AntenatalController();
      EventQueue.invokeLater(controller::displayGUI);
	}
}
