package edu.usm.cos420.antenatal.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.util.Properties;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


import edu.usm.cos420.antenatal.controller.SubController;

public class subsequentVisit{

	private JLabel sBP;
	private JLabel dBP;
	private JLabel weight;
	private JLabel fundalHeight;
	private JLabel Date;
	private JLabel bloodFilm;
	private JLabel referred;
	private JTextField sysBP;
	private JTextField diaBP;
	private JTextField weigh;
	private JTextField fundalH;
	private JDatePickerImpl apptDate;
	private UtilDateModel dateModel;
	private JCheckBox bloodF;
	private JCheckBox refer;
	private SubController subC;
	
	private JPanel subVisit;
	
	public subsequentVisit(SubController subC){
		subVisit = new JPanel();
		this.subC = subC;
		//GridLayout layout = new GridLayout();
		//FlowLayout layout = new FlowLayout();
		//subVisit.setLayout(layout);
		//int systolicBP, int diastolicBP,
        //double weight, double fundalHeight, LocalDate apptDate, boolean bloodFilm, boolean referred
		
	}
	public JPanel getPanel(){
		subVisit = addForm();
		subVisit.setMinimumSize(new Dimension(600,200));
		subVisit.setBackground(Color.LIGHT_GRAY);
		return subVisit;
		
	}
	private JPanel addForm() {
	   
		JPanel data = new JPanel();
	    GridLayout layout = new GridLayout(2, 8);
	      layout.setHgap(20);
	      data.setLayout(layout);
		
		sBP = new JLabel("Systolic Blood Pressure: ");
		dBP = new JLabel("Diastolic Blood Pressure: ");
		weight = new JLabel("Weight: ");
		fundalHeight = new JLabel("Fundal Height: ");
		Date = new JLabel("Appointment Date: ");
		bloodFilm = new JLabel("Blood Film: ");
		referred = new JLabel("Referred? ");
		sysBP = new JTextField(6);
		diaBP = new JTextField(6);
		weigh = new JTextField(3);
		fundalH = new JTextField(4);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		dateModel = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, p);
	    apptDate = new JDatePickerImpl(datePanel, new DateLabelFormatter());
	    bloodF = new JCheckBox();
	    refer = new JCheckBox();
	    
	    //JPanel data = new JPanel();
	     data.add(Date);
	    data.add(sBP);
	    data.add(dBP);
	    data.add(weight);
	    data.add(fundalHeight);
	    data.add(bloodFilm);
	    data.add(referred);

	    //JPanel data = new JPanel();

       data.add(apptDate);
	     data.add(sysBP);
	       data.add(diaBP);
	       data.add(weigh);
	       data.add(fundalH);
	       data.add(bloodF);
	       data.add(refer);
	   
	    
		return data;
	}
}
