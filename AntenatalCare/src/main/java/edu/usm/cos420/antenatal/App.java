package edu.usm.cos420.antenatal;

import java.awt.EventQueue;

import edu.usm.cos420.antenatal.controller.CItemController;
import edu.usm.cos420.antenatal.service.AntenatalService;
import edu.usm.cos420.antenatal.service.impl.AntenatalService1;
import edu.usm.cos420.antenatal.view.impl.CItemView;

/**
 * Top level application class that coordinates the calls to view and Controller
 *
 */
public class App
{
    /**
     * Entry point for application : calls {@link #provideCItemAccess()}
     * @param args  main program arguments, currently not used
     */
	public static void main( String[] args )
    {
		AntenatalService1 service = new AntenatalService1();
		CItemView citemView = new CItemView(service);
	   CItemController controller = new CItemController(citemView,service);    
	   controller.provideCItemAccess();
		EventQueue.invokeLater(new Runnable(){
         
         @Override
         public void run(){
            
            citemView.setVisible(true);
         }
         
      });

    }
}
