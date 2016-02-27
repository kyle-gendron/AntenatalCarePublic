package edu.usm.cos420.antenatal.controller;

import edu.usm.cos420.antenatal.service.AntenatalService;
import edu.usm.cos420.antenatal.view.impl.AntenatalView;

/**
 *   A Controller class to execute user's menu choice.
 *
 */
public class AntenatalController {

	private AntenatalService atMyService;
	private AntenatalView view;

	/**
	 * Constructor : pass in a service class which can provide access to cItem operations.
	 * @param view
	 * @param service
	 */
	public AntenatalController(AntenatalView view, AntenatalService service)
	{
		this.view = view;
		this.atMyService = service;
	}

	/**
	 * Allow the user to access the citem collection
	 *
	 */
	public void provideCItemAccess()
	{

	}

	/**
	 *   Performs the branching logic to call appropriate functions to satisfy user choice
	 *   @param choice represents the user selection of action they want accomplished.
	 */
	public void executeChoice (int choice) {
		//ADD COMMANDS TO DO

	}
}
