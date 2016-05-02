package edu.usm.cos420.antenatal.view;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import edu.usm.cos420.antenatal.controller.ReportingController;

/*
 * Small GUI Form class meant to contain input data and represent the window and form
 * popping up to take in the data regarding where to pull data from on the Antenatal 
 * portion of the Midwife Report
 * 
 * created by Kyle on 4/17/2016
 */
public class ReportingForm {

	private final JFrame frame;
	private final JPanel panel;
	private final JSpinner reportYear;
	private final JSpinner reportMonth;
	private final JButton submitButton;

	/*
	 * Standard constructor for Reporting form window
	 */
	public ReportingForm(ReportingController controller){

		//init window basics
		frame = new JFrame();
		frame.setLayout(new GridLayout(3,1));

		//init panel basics
		panel = new JPanel(new FlowLayout());

		//Window title
		JLabel windowMessage = new JLabel("Please enter the month"
				+ " and year of the Midwife Report you'd like to see");

		//year to be selected
		JLabel yearLabel = new JLabel("Year: ");
		SpinnerModel year =  new SpinnerNumberModel(1970,1970,LocalDate.now().getYear(),1);
		reportYear = new JSpinner(year);

		//month to be selected
		JLabel monthLabel = new JLabel("Month: ");
		SpinnerModel month =  new SpinnerNumberModel(1,1,12,1);
		reportMonth = new JSpinner(month);

		//make submit button
		submitButton = new JButton("Submit");
		submitButton.addActionListener(controller);
		
		//bundle year and month labels/inputs together
		panel.add(yearLabel);
		panel.add(reportYear);
		panel.add(monthLabel);
		panel.add(reportMonth);

		//add components to frame
		frame.add(windowMessage);
		frame.add(panel);
		frame.add(submitButton);
		frame.pack();
		
		
	}

	/**
	 * Get report year
	 * @return the return year selected
	 */
	public int getReportYear(){
		return (int) reportYear.getValue();
	}

	/**
	 * Get report month
	 * @return the return month selected
	 */
	public int getReportMonth(){
		return (int) reportMonth.getValue();
	}
	
	public void display(){
		frame.setVisible(true);
	}
}