package edu.usm.cos420.antenatal.gui;

import static edu.usm.cos420.antenatal.controller.Utils.parseDouble;
import static edu.usm.cos420.antenatal.controller.Utils.parseInteger;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;


import edu.usm.cos420.antenatal.controller.SubController;
import edu.usm.cos420.antenatal.domain.PregnancySubVisit;

public class subsequentVisit{

	private JLabel sBP;
	private JLabel dBP;
	private JLabel weight;
	private JLabel fundalHeight;
	private JLabel Date;
	private JLabel bloodFilm;
	private JLabel referred;
	private JLabel saved;
	private JSpinner sysBP;
	private JSpinner diaBP;
	private JSpinner weigh;
	private JSpinner fundalH;
	private JDatePickerImpl apptDate;
	private UtilDateModel dateModel;
	private JComboBox<String> bloodF;
	private JComboBox<String> refer;
	private SubController subC;
	private JButton saveButton;

	private JPanel container;
	private JPanel title;
	private JPanel subVisit;

	public subsequentVisit(SubController subC){
		subVisit = new JPanel();
		this.subC = subC;

	}

	public JPanel getTitle(){
		return title = addTitle();
	}


	public JPanel getPanel(){
		subVisit = addForm();
		subVisit.setMinimumSize(new Dimension(600,200));
		subVisit.setBackground(Color.LIGHT_GRAY);
		return subVisit;

	}

	public JPanel setForm(PregnancySubVisit sVisit){

		subVisit = changeForm(sVisit);
		subVisit.setMinimumSize(new Dimension(600,200));
		subVisit.setBackground(Color.LIGHT_GRAY);
		return subVisit;

	}

	private JPanel addTitle() {

		JPanel data = new JPanel();
		data.setPreferredSize(new Dimension(800, 25));

		GridLayout layout = new GridLayout(1, 9);
		//layout.setHgap(20);
		data.setLayout(layout);

		sBP = new JLabel("Systolic BP");
		sBP.setHorizontalAlignment(SwingConstants.CENTER);
		dBP = new JLabel("Diastolic BP");
		dBP.setHorizontalAlignment(SwingConstants.CENTER);
		weight = new JLabel("Weight");
		weight.setHorizontalAlignment(SwingConstants.CENTER);
		fundalHeight = new JLabel("Fundal Height");
		fundalHeight.setHorizontalAlignment(SwingConstants.CENTER);
		Date = new JLabel("Appointment Date");
		Date.setHorizontalAlignment(SwingConstants.CENTER);
		bloodFilm = new JLabel("Blood Film");
		bloodFilm.setHorizontalAlignment(SwingConstants.CENTER);
		referred = new JLabel("Referred?");
		referred.setHorizontalAlignment(SwingConstants.CENTER);
		saved = new JLabel("Save");
		saved.setHorizontalAlignment(SwingConstants.CENTER);

		//JPanel data = new JPanel();
		data.add(Date);
		data.add(sBP);
		data.add(dBP);
		data.add(weight);
		data.add(fundalHeight);
		data.add(bloodFilm);
		data.add(referred);
		data.add(saved);

		return data;
	}

	private JPanel changeForm(PregnancySubVisit sVisit) {

		JPanel data = new JPanel();
		data.setPreferredSize(new Dimension(800, 25));

		GridLayout layout = new GridLayout(1, 9);
		//layout.setHgap(20);
		data.setLayout(layout);


		SpinnerModel sysSpin= new SpinnerNumberModel(0,0,200,1);
		sysBP = new JSpinner(sysSpin);
		SpinnerModel diaSpin = new SpinnerNumberModel(0,0,200,1);
		diaBP = new JSpinner(diaSpin);
		SpinnerModel weighSpin = new SpinnerNumberModel(0.0,0.0,500.0,1.0);
		weigh = new JSpinner(weighSpin);
		SpinnerModel fundalSpin = new SpinnerNumberModel(0.0,0.0,500.0,1.0);
		fundalH = new JSpinner(fundalSpin);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		dateModel = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, p);
		apptDate = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		bloodF = new JComboBox<>(new String[] {"", "Not Present", "Present"});
		refer = new JComboBox<>(new String[] {"", "No", "Yes"});


		//JPanel data = new JPanel();
		this.setApptDate(sVisit.getApptDate());
		this.setFundalHeight(sVisit.getFundalHeight());
		this.setWeight(sVisit.getWeight());
		this.setSystolicBP(sVisit.getSystolicBP());
		this.setDiastolicBP(sVisit.getDiastolicBP());
		this.setBloodFilm(sVisit.bloodFilmResults());
		this.setReferral(sVisit.getReferral());

		data.add(apptDate);
		data.add(sysBP);
		data.add(diaBP);
		data.add(weigh);
		data.add(fundalH);
		data.add(bloodF);
		data.add(refer);
		//container.add(data, BorderLayout.CENTER);
		saveButton = new JButton("Update");
		saveButton.addActionListener(subC);
		//JPanel buttonPane = new JPanel();
		//buttonPane.setLayout(new FlowLayout());
		//buttonPane.add(saveButton);
		//container.add(buttonPane, BorderLayout.SOUTH);

		data.add(saveButton);
		return data;
		//return container;
	}
	private JPanel addForm() {

		JPanel data = new JPanel();
		data.setPreferredSize(new Dimension(800, 25));

		GridLayout layout = new GridLayout(1, 9);
		//layout.setHgap(20);
		data.setLayout(layout);

		SpinnerModel sysSpin= new SpinnerNumberModel(0,0,200,1);
		sysBP = new JSpinner(sysSpin);
		SpinnerModel diaSpin = new SpinnerNumberModel(0,0,200,1);
		diaBP = new JSpinner(diaSpin);
		SpinnerModel weighSpin = new SpinnerNumberModel(0.0,0.0,500.0,1.0);
		weigh = new JSpinner(weighSpin);
		SpinnerModel fundalSpin = new SpinnerNumberModel(0.0,0.0,500.0,1.0);
		fundalH = new JSpinner(fundalSpin);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		dateModel = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, p);
		apptDate = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		bloodF = new JComboBox<>(new String[] {"", "Not Present", "Present"});
		refer = new JComboBox<>(new String[] {"", "No", "Yes"});

		//JPanel data = new JPanel();

		data.add(apptDate);
		data.add(sysBP);
		data.add(diaBP);
		data.add(weigh);
		data.add(fundalH);
		data.add(bloodF);
		data.add(refer);
		saveButton = new JButton("Save");
		saveButton.addActionListener(subC);
		data.add(saveButton);

		return data;
	}

	public LocalDate getApptDate(){
		//TODO: calculate from gestation

		
		Date pickerDate = (Date) apptDate.getModel().getValue();
		if(pickerDate != null){
		LocalDate date = pickerDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		return date;
		}
		return null;
	}

	/**
	 *
	 * @return Double value of the fundal height
	 */
	public double getFundalHeight(){
		return (double) (fundalH.getValue());
	}

	/**
	 *
	 * @return Returns double of the patients weight, or -1 if invalid
	 */
	public Double getPatientWeight() {
		return (double) (weigh.getValue());
	}

	/**
	 *
	 * @return Returns int val of the patients Systollic blood pressue
	 */
	public int getSystolicBP(){
		return (int) (sysBP.getValue());
	}
	/**
	 *
	 * @return returns int val of the patients Diastolic blood pressure
	 */
	public int getDiastolicBP(){
		return (int) (diaBP.getValue());
	}

	/**
	 *
	 * @return Returns true if malaria pos, else false
	 */
	public String getBloodFilm(){
		return String.valueOf(bloodF.getSelectedItem());
	}
	/**
	 *
	 * @return Returns true if male involved, else false
	 */
	public String getRefer(){
		return String.valueOf(refer.getSelectedItem());
	}

	/**
	 * @param date is entered into datepicker
	 */
	public void setApptDate(LocalDate date) {
		if (date != null) {
			this.dateModel.setDate(date.getYear(), date.getMonthValue()-1, date.getDayOfMonth());
			this.dateModel.setSelected(true);
		}
	}

	/**
	 * @param fundalHeight is set to the text of Label fundalH
	 */
	public void setFundalHeight(double fundalHeight) {
		this.fundalH.setValue(fundalHeight);
	}

	/**
	 * @param weight is set to the text of Label weigh
	 */
	public void setWeight(double weight) {
		this.weigh.setValue(weight);
	}

	/**
	 * @param systolicBP
	 */
	public void setSystolicBP(int systolicBP) {
		this.sysBP.setValue(systolicBP);
	}

	public void setDiastolicBP(int diastolicBP) {
		this.diaBP.setValue(diastolicBP);
	}

	public void setBloodFilm(String film) {
		this.bloodF.setSelectedItem(film);
	}


	public void setReferral(String reference) {
		this.refer.setSelectedItem(reference);
	}


}
