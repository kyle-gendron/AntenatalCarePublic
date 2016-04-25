package edu.usm.cos420.antenatal;

import edu.usm.cos420.antenatal.controller.AntenatalController;
import edu.usm.cos420.antenatal.view.impl.AntenatalView;

import java.awt.*;

import javax.swing.JFrame;

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
//		JFrame test = new JFrame("ANTENATAL");
//		

		AntenatalController anteController = new AntenatalController();
//		AntenatalView view = new AntenatalView(anteController);
//		view.setVisible(true);
//		
		EventQueue.invokeLater(anteController::displayGUI);
//		BorderLayout layout = new BorderLayout();
//		test.setLayout(layout);
//		view.setSize(view.getPreferredSize());
//		test.getContentPane().add(view, BorderLayout.CENTER);
//		test.getContentPane().setSize(800, 900);
//		test.setSize(900, 1000);
//		
//		test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		test.setVisible(true);
//		test.validate();
//		
		

	}
}
