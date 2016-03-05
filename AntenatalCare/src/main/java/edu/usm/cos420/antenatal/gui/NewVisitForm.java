package edu.usm.cos420.antenatal.gui;

import javax.swing.*;


import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.Properties;


/**
 * Created by aaron on 2/27/2016.
 */

/**
 * A public class that creates the new antenatal visit.
 * Which consists of several fields that are used to
 * enter data necessary to the antenatal appointment.
 * (Height, weight, fundalHeight, gestation etc.)
 * 
 */
public class NewVisitForm extends JPanel {

	private final JPanel panel;
	private final JTextField parInput;
	private final JTextField bloInput1;
	private final JTextField bloInput2;
	private final JTextField heiInput;
	private final JTextField weiInput;
	private final JTextField gesInput;
	private final JTextField fInput;
	private final JTextField hb36Input;
	private final JTextField eedInput;
	private final JTextField hbatInput;
	private final JTextField uriInput1;
	private final JTextField uriInput2;
	private final JComboBox bg;
	private final JComboBox sb;
	private final JComboBox sbt;
	private final JCheckBox react;
	private final JCheckBox pmctYes;
	private final JRadioButton positive;
	private final JRadioButton negative;
	private final JCheckBox postYes;
	private final JCheckBox bloodPresent;
	private final JCheckBox malePresent;
	private final JComboBox tb;
	private final JComboBox sg;
	private final JComboBox ttb;
	private final JCheckBox iptThree;
	private final JCheckBox iptOne;
	private final JCheckBox iptTwo;
	private final JCheckBox itpOne;
	private final JCheckBox itpTwo;
	private final JCheckBox itpThree;
	private final JCheckBox itnYes;
	private final JTextArea complaints;
	private final JTextArea remarks;

	/**
	 * Fills in the jFrame with all of the field that need to be filled in
	 * and adds the to a FlowLayout element.
	 * 
	 * @param layout
	 */
	public NewVisitForm(FlowLayout layout) {
		panel = new JPanel();
		panel.setLayout(layout);
		layout.setHgap(10);

		JLabel parity = new JLabel("Parity: "); //integer
		parInput = new JTextField(2);
		JLabel BloodPressure = new JLabel("Blood Pressure: ");
		bloInput1 = new JTextField(2);//ADD TWO Fields int/int
		JLabel fill = new JLabel("/");
		bloInput2 = new JTextField(2);

		JPanel bloInput = new JPanel();
		bloInput.add(BloodPressure);
		bloInput.add(bloInput1);
		bloInput.add(fill);
		bloInput.add(bloInput2);
		bloInput.setLayout(new FlowLayout());


		JLabel Height = new JLabel("Height: ");//double
		heiInput = new JTextField(3);
		JLabel Weight = new JLabel("Weight: ");//double
		weiInput = new JTextField(3);

		JPanel size = new JPanel();
		size.add(Height);
		size.add(heiInput);
		size.add(new JLabel(" (cm)"));
		size.add(Weight);
		size.add(weiInput);
		size.add(new JLabel(" (kg)"));
		size.setLayout(new GridLayout(2,3));

		//number of weeks pregnant
		JLabel Gestation = new JLabel("Gestation: ");//int
		gesInput = new JTextField(3);//How to Calculate

		//measurement of uterus in CM
		JLabel FHeight = new JLabel("Fundal Height: ");//Double
		fInput = new JTextField(3);
		JPanel FundalHeight = new JPanel();
		FundalHeight.add(FHeight);
		FundalHeight.add(fInput);
		FundalHeight.add(new JLabel(" (cm)"));

		//date baby is due
		JLabel EEDL = new JLabel("Due Date: ");
		eedInput = new JTextField(3); //Determine how we want date entered.
		JPanel EED = new JPanel();
		EED.add(EEDL);
		EED.add(eedInput);
		EED.add(new JLabel("(mm/dd/yyyy)"));

		//test hemoglobin
		JLabel HBatR = new JLabel("HBatReg: ");//Double grams/deciliter
		hbatInput = new JTextField(3);//how to calculate
		JPanel HBatReg = new JPanel();
		HBatReg.add(HBatR);
		HBatReg.add(hbatInput);
		HBatReg.add(new JLabel("(Grams/Deciliter)"));

		// test Hemoglobin @ 36 weeks
		JLabel HBat6 = new JLabel("HBat36: ");//double g/dl
		hb36Input = new JTextField(3);
		JPanel HBat36 = new JPanel();
		HBat36.add(HBat6);
		HBat36.add(hb36Input);
		HBat36.add(new JLabel("(Grams/Deciliter)"));

		//testing for sugar & protein in urine
		JLabel UrineTes = new JLabel("Urine Test: ");//Sugar/Protein- double mmol/L / double mg/dL
		uriInput1 = new JTextField(3);
		uriInput2 = new JTextField(3);
		JPanel UrineTest = new JPanel();
		UrineTest.add(UrineTes);
		UrineTest.add(uriInput1);
		UrineTest.add(new JLabel("/"));
		UrineTest.add(uriInput2);
		UrineTest.add(new JLabel("(Sugar/Protein)"));

		//blood type/group
		JLabel BloodG = new JLabel("Blood Group: ");//String, Drop down with options
		JPanel BloodGroup = new JPanel();
		String[] bt = {" ","O","A","B","AB"};
		bg = new JComboBox(bt);
		BloodGroup.add(BloodG);
		BloodGroup.add(bg);

		//sickle cell anemia testing
		JLabel Sicklin = new JLabel("Sickling: ");//Status/Type string/string (drop down)
		JPanel Sickling = new JPanel();
		String[] ss = {" ","Positive","Negative"};
		sb = new JComboBox(ss);
		String[] st = {" ","N/a","Hemoglobin SS","Hemoglobin SC","Hemoglobin SB+ (Beta) Thalassemia","Beta-Zero Thalassemia"};
		sbt = new JComboBox(st);
		Sickling.add(Sicklin);
		Sickling.add(sb);
		Sickling.add(sbt);

		//veneral disease testing
		JLabel VDLa = new JLabel("VDLab: ");//button group reactive or non-reactive
		JPanel VDLab = new JPanel();
		react = new JCheckBox("Reactive");
		VDLab.add(VDLa);
		VDLab.add(react);


		//pre VD test consoling
		JLabel PMTC = new JLabel("PMTCT: ");//yes 
		JPanel PMTCT = new JPanel();
		pmctYes = new JCheckBox("");
		PMTCT.add(PMTC);
		PMTCT.add(pmctYes);

		//VD test result
		JLabel TestResul = new JLabel("Test-Result: ");//positive vs negative
		JPanel TestResult = new JPanel();
		positive = new JRadioButton("Positive");
		negative = new JRadioButton("Negative");
		ButtonGroup t = new ButtonGroup();
		t.add(positive);
		t.add(negative);
		TestResult.add(TestResul);
		TestResult.add(positive);
		TestResult.add(negative);

		//Post VD test counseling
		JLabel PostTes = new JLabel("Post-Test Counseling: ");//yess
		JPanel PostTest = new JPanel();
		postYes = new JCheckBox("");
		PostTest.add(PostTes);
		PostTest.add(postYes);

		//malaria testing p/np
		JLabel BloodFil = new JLabel("Blood Film: ");//bloodPresent or not bloodPresent
		JPanel BloodFilm = new JPanel();
		bloodPresent = new JCheckBox("Present");
		BloodFilm.add(BloodFil);
		BloodFilm.add(bloodPresent);

		//men involvement y/n
		JLabel MaleInvolve = new JLabel("Male Involvement: ");//bloodPresent or not
		JPanel MaleInvolved = new JPanel();
		malePresent = new JCheckBox("Present");
		MaleInvolved.add(MaleInvolve);
		MaleInvolved.add(malePresent);

		//what trimester they are at
		JLabel Trimeste = new JLabel("Trimester: ");//int 1-3
		JPanel Trimester = new JPanel();
		String[] tr = {" ","1","2","3"};
		tb = new JComboBox(tr);
		Trimester.add(Trimeste);
		Trimester.add(tb);

		//sub visits
		JLabel SV = new JLabel("Subsequent Visits: ");//int 2-12
		JPanel Sub = new JPanel();
		String[] sr = {" ","2","3","4","5","6","7","8","9","10","11","12"};
		sg = new JComboBox(sr);
		Sub.add(SV);
		Sub.add(sg);

		//Tetanus shot give,boster, & protected
		JLabel TTl = new JLabel("TT: ");//given, booster, protected
		JPanel TT = new JPanel();
		String[] ttr = {" ","given","booster","protected"};
		ttb = new JComboBox(ttr);
		TT.add(TTl);
		TT.add(ttb);

		//ipt/doses
		JLabel IPTl = new JLabel("IPT: ");//check 1,2, or 3 doses
		JPanel IPT = new JPanel();
		iptOne = new JCheckBox("1");
		iptTwo = new JCheckBox("2");
		iptThree = new JCheckBox("3");
		IPT.add(IPTl);
		IPT.add(iptOne);
		IPT.add(iptTwo);
		IPT.add(iptThree);
		IPT.add(new JLabel(" Doses"));

		//ITP doses
		JLabel ITPl = new JLabel("ITP: ");//3 doses tick for each
		JPanel ITP = new JPanel();
		itpOne = new JCheckBox("1");
		itpTwo = new JCheckBox("2");
		itpThree = new JCheckBox("3");
		ITP.add(ITPl);
		ITP.add(itpOne);
		ITP.add(itpTwo);
		ITP.add(itpThree);
		ITP.add(new JLabel(" Doses"));

		//stuff of ITN
		JLabel ITNl = new JLabel("ITN: ");//Yes 
		JPanel ITN = new JPanel();
		itnYes = new JCheckBox("");
		ITN.add(ITNl);
		ITN.add(itnYes);
		
		//add complaints field
		JLabel complaint = new JLabel("Complaints: ");
		JLabel remarked = new JLabel("Remarks: ");
		JPanel texthold = new JPanel();
		complaints = new JTextArea(2,12);
		remarks = new JTextArea(2,12);
		texthold.add(complaint);
		texthold.add(complaints);
		
		//add remarks field
		texthold.add(remarked);
		texthold.add(remarks);
		
		//add data to frame
		panel.add(parity);
		panel.add(parInput);
		panel.add(bloInput);
		panel.add(size);
		panel.add(Gestation);
		panel.add(gesInput);
		panel.add(FundalHeight);
		panel.add(EED);
		panel.add(HBatReg);
		panel.add(HBat36);
		panel.add(UrineTest);
		panel.add(BloodGroup);
		panel.add(Sickling);
		panel.add(VDLab);
		panel.add(PMTCT);
		panel.add(TestResult);
		panel.add(PostTest);
		panel.add(BloodFilm);
		panel.add(MaleInvolved);
		panel.add(Trimester);
		panel.add(Sub);
		panel.add(TT);
		panel.add(IPT);
		panel.add(ITP);
		panel.add(ITN);
		panel.add(texthold);
		
	}

	/**
	 * 
	 * @return the JPanel created
	 */
	public JPanel getPanel() {
		return panel;
	}

	/**
	 * 
	 * @return String of the parity field, or -1 if invalid 
	 */
	public int getParity() {
		Integer parity = 0;
		try{
			parity = Integer.valueOf(parInput.getText());
			return (int) parity;
		}catch(NumberFormatException e){
			return -1;
		}
	}

	/**
	 * 
	 * @return returns 1 if the test results are "positive" or -1 for "negative". 
	 * 0 is returned if neither are selected
	 */
	public Integer getTestResult() {
		if (positive.isSelected()) return 1;
		if (negative.isSelected()) return -1;
		return 0;
	}

	/**
	 * 
	 * @return Returns double of the patients height, or -1 if invalid
	 */
	public Double getPatientHeight() {		
		Double hei = 0.0;
		try{
			hei = Double.valueOf(heiInput.getText());
			return hei;
		}catch(NumberFormatException e){
			return -1.0;
		}
	}

	/**
	 * 
	 * @return Returns double of the patients weight, or -1 if invalid
	 */
	public Double getPatientWeight() {
		Double wei = 0.0;
		try{
			wei = Double.valueOf(weiInput.getText());
			return wei;
		}catch(NumberFormatException e){
			return -1.0;
		}
	}

	/**
	 * 
	 * @return Returns int val of the patients Systollic blood pressue
	 */
	public int getSystolicBP(){
		Integer sBP = 0;
		try{
			sBP = Integer.valueOf(bloInput1.getText());
			return (int) sBP;
		}catch(NumberFormatException e){
			return -1;
		}		
	}
	/**
	 * 
	 * @return returns int val of the patients Diastolic blood pressure
	 */
	public int getDiastolicBP(){
		Integer dBP = 0;
		try{
			dBP = Integer.valueOf(bloInput2.getText());
			return (int) dBP;
		}catch(NumberFormatException e){
			return -1;
		}
	}

	/**
	 * 
	 * @return returns int val of the trimester, or -1 if error
	 */
	public int getTrimester(){
		try{
			int gest = Integer.valueOf(gesInput.getText());

			if(gest <= 13 ){//tri 1
				return 1;
			}else if(gest <= 26){//tri2
				return 2;
			}else{
				return 3;
			}
		}catch(NumberFormatException e){
			return -1;
		}
	}

	public int getSubVisits(){
		Object selectedSubVis = sg.getSelectedItem();
		//TODO: may or not be correct val
		int st = (int) Integer.valueOf(selectedSubVis.toString());
		return st;
	}

	public int getGestation(){
		Integer ges = 0;
		try{
			ges = Integer.valueOf(gesInput.getText());
			return (int) ges;
		}catch(NumberFormatException e){
			return -1;
		}
	}

	public int getIPTDoses(){
		//TODO: make this better?
		int doses = 0;
		int tmp = -1;
		
		if(iptOne.isSelected()){
			doses = 1;
		}
		if(iptTwo.isSelected()){
			doses = 2;
		}
		
		if(iptThree.isSelected()){
			doses = 3;
		}
		
		return doses;		
	}
	/**
	 * 
	 * @return Returns the number of doses
	 */
	public int getTTDoses(){
		Object TTdoses = ttb.getSelectedItem();
		//TODO: may or not be correct val
		int st = (int) Integer.valueOf(TTdoses.toString());
		return st;
		
	}
	/**
	 * 
	 * @return Double value of the fundal height
	 */
	public double getFundalHeight(){
		Integer fun = 0;
		try{
			fun = Integer.valueOf(fInput.getText());
			return (int) fun;
		}catch(NumberFormatException e){
			return -1;
		}
	}

	/**
	 * 
	 * @return Double value of the hemoglobin levels at registration
	 */
	public double gethBAtReg(){
		Double hb = 0.0;
		try{
			hb = Double.valueOf(hb36Input.getText());
			return hb;
		}catch(NumberFormatException e){
			return -1;
		}
	}

	/**
	 * 
	 * @return Double value of the hemoglobin levels at 36 weeks
	 */
	public double gethBAt36Weeks(){
		Double hb = 0.0;
		try{
			hb = Double.valueOf(hbatInput.getText());
			return hb;
		}catch(NumberFormatException e){
			return -1;
		}
	}

	/**
	 * 
	 * @return Double val of the urine sugar test results
	 */
	public double getUrineTestSugar(){
		Double sp = 0.0; //sugar pee
		try{
			sp = Double.valueOf(uriInput1.getText());
			return sp;
		}catch(NumberFormatException e){
			return -1;
		}
	}
	/**
	 * 
	 * @return Doubleval of the urine protein test results
	 */
	public double getUrineTestProtein(){
		Double pp = 0.0; //protein pee
		try{
			pp = Double.valueOf(uriInput2.getText());
			return pp;
		}catch(NumberFormatException e){
			return -1;
		}
	}

	/**
	 * 
	 * @return a GregorianCalendar of the estimated due date
	 */
	public LocalDate getEDD(){
		//TODO: calculate from gestation 
		//TODO: not use gregorian Cal
		  
		   try{
			String date = eedInput.getText();
			date = date.replaceAll("\\D", "");
			System.out.println(date);
			DateTimeFormatter formatter = null;
			if(date.length() == 8){
			formatter = DateTimeFormatter.ofPattern("MMddyyyy");
			}
			
			return LocalDate.parse(date, formatter);
			//String[] spDate = date.split("/");
			
			//int day = Integer.parseInt(spDate[1]);
			//int month = Integer.parseInt(spDate[0]);
			//int year = Integer.parseInt(spDate[2]);


			//return edd;
		}catch(Exception e){
			return null;
		}
	}

	/**
	 * 
	 * @return String representation of blood group
	 */
	public String getBloodGroup(){
		Object blood = bg.getSelectedItem();

		//TODO: may or not be correct val
		String bt = blood.toString();

		return bt;
	}

	/**
	 * 
	 * @return String representation of sickling status
	 */
	public String getSicklingStatus(){
		Object sickStat = bg.getSelectedItem();

		//TODO: may or not be correct val
		String st = sickStat.toString();

		return st;
	}

	/** 
	 * 
	 * @return String representation of sickling type
	 */
	public String getSicklingType(){
		Object sickStat = bg.getSelectedItem();

		//TODO: may or not be correct val
		String st = sickStat.toString();

		return st;
	}
	/**
	 * 
	 * @return Returns true if reactive, else false
	 */
	public boolean getVDLabResults(){
		return react.isSelected();
	}
	/**
	 * 
	 * @return Returns True if yes, else returns false
	 */
	public boolean getPreTestCounsel(){
		 return pmctYes.isSelected();
	}

	/**
	 * 
	 * @return Returns true is yes, else returns false
	 */
	public boolean getPostTestCounsel(){
		return postYes.isSelected();
	}

	/**
	 * 
	 * @return Returns true if malaria pos, else false
	 */
	public boolean getBloodFilm(){
		return bloodPresent.isSelected();	
	}
	/**
	 * 
	 * @return Returns true if male involved, else false
	 */
	public boolean getMaleInvolvement(){
		return malePresent.isSelected();		
	}
	
	/**
	 * 
	 * @return returns true if yes, returns false otherwise
	 */
	public boolean getITN(){
		return itnYes.isSelected();		
	}
}