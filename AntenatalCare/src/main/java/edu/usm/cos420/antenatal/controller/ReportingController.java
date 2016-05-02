package edu.usm.cos420.antenatal.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.usm.cos420.antenatal.domain.PregnancyRecord;
import edu.usm.cos420.antenatal.view.ReportingForm;
import edu.usm.cos420.antenatal.view.VisitForm;
import edu.usm.cos420.antenatal.view.AntenatalView;

/**
 * 4/17/2016
 * @author Kyle
 *
 *Small controller class accompanying Midwife Report functionality
 */
public class ReportingController implements ActionListener {

	private ReportingForm report;
	
	/**
	 * Standard controller constructor
	 */
	public ReportingController(){}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Submit": {

			System.out.println("Made it!");

		}
		}
		
	}

	/**
	 * Get report form
	 * @return the report form
	 */
	public ReportingForm getReportingForm(){
		return report;
	}
	
	/**
	 * Set report form
	 * @param report the report form to be changed to
	 */
	public void setReportingForm(ReportingForm report){
		this.report = report;
	}
}
