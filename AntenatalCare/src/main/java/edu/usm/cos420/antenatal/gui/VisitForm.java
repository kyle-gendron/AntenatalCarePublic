package edu.usm.cos420.antenatal.gui;

import javax.swing.*;


import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


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
public class VisitForm extends JPanel {

	private final JPanel panel;
	private final JTextField parityInput;
	private final JTextField systolicInput;
	private final JTextField diastolicInput;
	private final JTextField heightInput;
	private final JTextField weightInput;
	private final JTextField gestationInput;
	private final JTextField fundalHeightInput;
	private final JTextField eedInput;
	private final JTextField hbaAt36WeeksInput;
	private final JTextField urineTestSugarInput;
	private final JTextField urineTestProteinInput;
	private final JComboBox bloodTypeGroup;
	private final JComboBox sicklingStatusInput;
	private final JComboBox sicklingTypeInput;
	private final JCheckBox resultsVDLabInput;
	private final JCheckBox preTestCounselInput;
	private final JRadioButton hivPositiveInput;
	private final JRadioButton hivNegativeInput;
	private final JCheckBox postTestCounselInput;
	private final JCheckBox bloodFilmInput;
	private final JCheckBox malePresentInput;
	private final JComboBox trimesterInput;
	private final JComboBox subVisitsInput;
	private final JComboBox ttDosesInput;
	private final JCheckBox iptThree;
	private final JCheckBox iptOne;
	private final JCheckBox iptTwo;
	private final JCheckBox itpOne;
	private final JCheckBox itpTwo;
	private final JCheckBox itpThree;
	private final JCheckBox itnInput;
	private final JTextArea complaints;
	private final JTextArea remarks;
  private final JTextField hbaAtRegInput;

  /**
	 * Fills in the jFrame with all of the field that need to be filled in
	 * and adds the to a FlowLayout element.
	 *
	 * @param layout
	 */
	public VisitForm(FlowLayout layout) {
		panel = new JPanel();
		panel.setLayout(layout);
		layout.setHgap(10);

		JLabel parity = new JLabel("Parity: "); //integer
		parityInput = new JTextField(2);
		JLabel BloodPressure = new JLabel("Blood Pressure: ");
		systolicInput = new JTextField(2);//ADD TWO Fields int/int
		JLabel fill = new JLabel("/");
		diastolicInput = new JTextField(2);

		JPanel bloInput = new JPanel();
		bloInput.add(BloodPressure);
		bloInput.add(systolicInput);
		bloInput.add(fill);
		bloInput.add(diastolicInput);
		bloInput.setLayout(new FlowLayout());


		JLabel Height = new JLabel("Height: ");//double
		heightInput = new JTextField(3);
		JLabel Weight = new JLabel("Weight: ");//double
		weightInput = new JTextField(3);

		JPanel size = new JPanel();
		size.add(Height);
		size.add(heightInput);
		size.add(new JLabel(" (cm)"));
		size.add(Weight);
		size.add(weightInput);
		size.add(new JLabel(" (kg)"));
		size.setLayout(new GridLayout(2,3));

		//number of weeks pregnant
		JLabel Gestation = new JLabel("Gestation: ");//int
		gestationInput = new JTextField(3);//How to Calculate

		//measurement of uterus in CM
		JLabel FHeight = new JLabel("Fundal Height: ");//Double
		fundalHeightInput = new JTextField(3);
		JPanel FundalHeight = new JPanel();
		FundalHeight.add(FHeight);
		FundalHeight.add(fundalHeightInput);
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
		hbaAtRegInput = new JTextField(3);//how to calculate
		JPanel HBatReg = new JPanel();
		HBatReg.add(HBatR);
		HBatReg.add(hbaAtRegInput);
		HBatReg.add(new JLabel("(Grams/Deciliter)"));

		// test Hemoglobin @ 36 weeks
		JLabel HBat6 = new JLabel("HBat36: ");//double g/dl
    hbaAt36WeeksInput = new JTextField(3);
		JPanel HBat36 = new JPanel();
		HBat36.add(HBat6);
		HBat36.add(hbaAt36WeeksInput);
		HBat36.add(new JLabel("(Grams/Deciliter)"));

		//testing for sugar & protein in urine
		JLabel UrineTes = new JLabel("Urine Test: ");//Sugar/Protein- double mmol/L / double mg/dL
		urineTestSugarInput = new JTextField(3);
		urineTestProteinInput = new JTextField(3);
		JPanel UrineTest = new JPanel();
		UrineTest.add(UrineTes);
		UrineTest.add(urineTestSugarInput);
		UrineTest.add(new JLabel("/"));
		UrineTest.add(urineTestProteinInput);
		UrineTest.add(new JLabel("(Sugar/Protein)"));

		//blood type/group
		JLabel BloodG = new JLabel("Blood Group: ");//String, Drop down with options
		JPanel BloodGroup = new JPanel();
		String[] bt = {" ","O","A","B","AB"};
		bloodTypeGroup = new JComboBox(bt);
		BloodGroup.add(BloodG);
		BloodGroup.add(bloodTypeGroup);

		//sickle cell anemia testing
		JLabel Sicklin = new JLabel("Sickling: ");//Status/Type string/string (drop down)
		JPanel Sickling = new JPanel();
		String[] ss = {"","Positive","Negative"};
		sicklingStatusInput = new JComboBox(ss);
		String[] st = {"","N/a","Hemoglobin SS","Hemoglobin SC","Hemoglobin SB+ (Beta) Thalassemia","Beta-Zero Thalassemia"};
		sicklingTypeInput = new JComboBox(st);
		Sickling.add(Sicklin);
		Sickling.add(sicklingStatusInput);
		Sickling.add(sicklingTypeInput);

		//veneral disease testing
		JLabel VDLa = new JLabel("VDLab: ");//button group reactive or non-reactive
		JPanel VDLab = new JPanel();
		resultsVDLabInput = new JCheckBox("Reactive");
		VDLab.add(VDLa);
		VDLab.add(resultsVDLabInput);


		//pre VD test consoling
		JLabel PMTC = new JLabel("PMTCT: ");//yes
		JPanel PMTCT = new JPanel();
		preTestCounselInput = new JCheckBox("");
		PMTCT.add(PMTC);
		PMTCT.add(preTestCounselInput);

		//VD test result
		JLabel TestResul = new JLabel("Test-Result: ");//hivPositiveInput vs hivNegativeInput
		JPanel TestResult = new JPanel();
		hivPositiveInput = new JRadioButton("Positive");
		hivNegativeInput = new JRadioButton("Negative");
		ButtonGroup t = new ButtonGroup();
		t.add(hivPositiveInput);
		t.add(hivNegativeInput);
		TestResult.add(TestResul);
		TestResult.add(hivPositiveInput);
		TestResult.add(hivNegativeInput);

		//Post VD test counseling
		JLabel PostTes = new JLabel("Post-Test Counseling: ");
		JPanel PostTest = new JPanel();
		postTestCounselInput = new JCheckBox("");
		PostTest.add(PostTes);
		PostTest.add(postTestCounselInput);

		//malaria testing p/np
		JLabel BloodFil = new JLabel("Blood Film: ");//bloodFilmInput or not bloodFilmInput
		JPanel BloodFilm = new JPanel();
		bloodFilmInput = new JCheckBox("Present");
		BloodFilm.add(BloodFil);
		BloodFilm.add(bloodFilmInput);

		//men involvement y/n
		JLabel MaleInvolve = new JLabel("Male Involvement: ");//bloodFilmInput or not
		JPanel MaleInvolved = new JPanel();
		malePresentInput = new JCheckBox("Present");
		MaleInvolved.add(MaleInvolve);
		MaleInvolved.add(malePresentInput);

		//what trimester they are at
		JLabel Trimeste = new JLabel("Trimester: ");//int 1-3
		JPanel Trimester = new JPanel();
		String[] tr = {" ","1","2","3"};
		trimesterInput = new JComboBox(tr);
		Trimester.add(Trimeste);
		Trimester.add(trimesterInput);

		//sub visits
		JLabel SV = new JLabel("Subsequent Visits: ");//int 2-12
		JPanel Sub = new JPanel();
		String[] sr = {" ","2","3","4","5","6","7","8","9","10","11","12"};
		subVisitsInput = new JComboBox(sr);
		Sub.add(SV);
		Sub.add(subVisitsInput);

		//Tetanus shot give,boster, & protected
		JLabel TTl = new JLabel("TT: ");//given, booster, protected
		JPanel TT = new JPanel();
		String[] ttr = {" ","given","booster","protected"};
		ttDosesInput = new JComboBox(ttr);
		TT.add(TTl);
		TT.add(ttDosesInput);

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
		itnInput = new JCheckBox("");
		ITN.add(ITNl);
		ITN.add(itnInput);

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
		panel.add(parityInput);
		panel.add(bloInput);
		panel.add(size);
		panel.add(Gestation);
		panel.add(gestationInput);
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
			parity = Integer.valueOf(parityInput.getText());
			return (int) parity;
		}catch(NumberFormatException e){
			return -1;
		}
	}

	/**
	 *
	 * @return returns 1 if the test results are "hivPositiveInput" or -1 for "hivNegativeInput".
	 * 0 is returned if neither are selected
	 */
	public Integer getTestResult() {
		if (hivPositiveInput.isSelected()) return 1;
		if (hivNegativeInput.isSelected()) return -1;
		return 0;
	}

	/**
	 *
	 * @return Returns double of the patients height, or -1 if invalid
	 */
	public Double getPatientHeight() {
		Double hei = 0.0;
		try{
			hei = Double.valueOf(heightInput.getText());
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
			wei = Double.valueOf(weightInput.getText());
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
			sBP = Integer.valueOf(systolicInput.getText());
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
			dBP = Integer.valueOf(diastolicInput.getText());
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
			int gest = Integer.valueOf(gestationInput.getText());

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

	public int getSubVisitsInput(){
		Object selectedSubVis = subVisitsInput.getSelectedItem();
		//TODO: may or not be correct val
		int st = (int) Integer.valueOf(selectedSubVis.toString());
		return st;
	}

	public int getGestation(){
		Integer ges = 0;
		try{
			ges = Integer.valueOf(gestationInput.getText());
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
		Object TTdoses = ttDosesInput.getSelectedItem();
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
			fun = Integer.valueOf(fundalHeightInput.getText());
			return (int) fun;
		}catch(NumberFormatException e){
			return -1;
		}
	}

	/**
	 *
	 * @return Double value of the hemoglobin levels at registration
	 */
	public double getHBAtReg(){
		Double hb = 0.0;
		try{
			hb = Double.valueOf(hbaAtRegInput.getText());
			return hb;
		}catch(NumberFormatException e){
			return -1;
		}
	}

	/**
	 *
	 * @return Double value of the hemoglobin levels at 36 weeks
	 */
	public double getHBAt36Weeks(){
		Double hb = 0.0;
		try{
			hb = Double.valueOf(hbaAt36WeeksInput.getText());
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
			sp = Double.valueOf(urineTestSugarInput.getText());
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
			pp = Double.valueOf(urineTestProteinInput.getText());
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

		   try{
			String date = eedInput.getText();
			date = date.replaceAll("\\D", "");
			System.out.println(date);
			DateTimeFormatter formatter = null;

			if(date.length() == 8){
			formatter = DateTimeFormatter.ofPattern("MMddyyyy");
			}

			return LocalDate.parse(date, formatter);

		}catch(Exception e){
			return null;
		}
	}

	/**
	 *
	 * @return String representation of blood group
	 */
	public String getBloodGroup(){
		Object blood = bloodTypeGroup.getSelectedItem();

		//TODO: may or not be correct val
		String bt = blood.toString();

		return bt;
	}

	/**
	 *
	 * @return String representation of sickling status
	 */
	public String getSicklingStatus(){
		Object sickStat = bloodTypeGroup.getSelectedItem();

		//TODO: may or not be correct val
		String st = sickStat.toString();

		return st;
	}

	/**
	 *
	 * @return String representation of sickling type
	 */
	public String getSicklingType(){
		Object sickStat = bloodTypeGroup.getSelectedItem();

		//TODO: may or not be correct val
		String st = sickStat.toString();

		return st;
	}
	/**
	 *
	 * @return Returns true if reactive, else false
	 */
	public boolean getVDLabResults(){
		return resultsVDLabInput.isSelected();
	}
	/**
	 *
	 * @return Returns True if yes, else returns false
	 */
	public boolean getPreTestCounsel(){
		 return preTestCounselInput.isSelected();
	}

	/**
	 *
	 * @return Returns true is yes, else returns false
	 */
	public boolean getPostTestCounsel(){
		return postTestCounselInput.isSelected();
	}

	/**
	 *
	 * @return Returns true if malaria pos, else false
	 */
	public boolean getBloodFilm(){
		return bloodFilmInput.isSelected();
	}
	/**
	 *
	 * @return Returns true if male involved, else false
	 */
	public boolean getMaleInvolvement(){
		return malePresentInput.isSelected();
	}

	/**
	 *
	 * @return returns true if yes, returns false otherwise
	 */
	public boolean getITN(){
		return itnInput.isSelected();
	}

  public void setParity(int parity) {
    this.parityInput.setText(String.valueOf(parity));
  }

  public void setSystolicBP(int systolicBP) {
    this.systolicInput.setText(String.valueOf(systolicBP));
  }

  public void setDiastolicBP(int diastolicBP) {
    this.systolicInput.setText(String.valueOf(diastolicBP));
  }

  public void setTrimester(int trimester) {
    this.trimesterInput.setSelectedIndex(trimester);
  }

  public void setGestation(int gestation) {
    this.gestationInput.setText(String.valueOf(gestation));
  }

  public void setIPTDoses(int IPTDoses) {
    if (IPTDoses > 0) {
      iptOne.setSelected(true);
    }
    if (IPTDoses > 1) {
      iptTwo.setSelected(true);
    }
    if (IPTDoses > 2) {
      iptThree.setSelected(true);
    }
  }

  public void setITPDoses(int ITPDoses) {
    if (ITPDoses > 0) {
      itpOne.setSelected(true);
    }
    if (ITPDoses > 1) {
      itpTwo.setSelected(true);
    }
    if (ITPDoses > 2) {
      itpThree.setSelected(true);
    }
  }

  public void setTTDoses(int TTDoses) {
    this.ttDosesInput.setSelectedIndex(TTDoses);
  }

  public void setHeight(double height) {
    this.heightInput.setText(String.valueOf(height));
  }

  public void setWeight(double weight) {
    this.weightInput.setText(String.valueOf(weight));
  }

  public void setFundalHeight(double fundalHeight) {
    this.fundalHeightInput.setText(String.valueOf(fundalHeight));
  }

  public void setHBAtReg(double HBAtReg) {
    this.hbaAtRegInput.setText(String.valueOf(HBAtReg));
  }

  public void setHBAt36Weeks(double HBAt36Weeks) {
    this.hbaAt36WeeksInput.setText(String.valueOf(HBAt36Weeks));
  }

  public void setUrineTestSugar(double urineTestSugar) {
    this.urineTestSugarInput.setText(String.valueOf(urineTestSugar));
  }

  public void setUrineTestProtein(double urineTestProtein) {
    this.urineTestProteinInput.setText(String.valueOf(urineTestProtein));
  }

  public void setEDD(LocalDate EDD) {
    this.eedInput.setText(String.valueOf(EDD));
  }

  public void setBloodGroup(String bloodGroup) {
//    this.blood
  }

  public void setSicklingStatus(String sicklingStatus) {
//    this.sick
  }

  public void setSicklingType(String sicklingType) {
//    this.setSicklingType(sicklingType);
  }

  public void setVDLabResults(boolean VDLabresults) {
    this.resultsVDLabInput.setSelected(VDLabresults);
  }

  public void setPreTestCounsel(boolean preTestCounsel) {
    this.preTestCounselInput.setSelected(preTestCounsel);
  }

  public void setHIVResults(boolean HIVResults) {
    if (HIVResults){
      hivPositiveInput.setSelected(true);
    } else {
      hivNegativeInput.setSelected(true);
    }
  }

  public void setPostTestCounsel(boolean postTestCounsel) {
    this.postTestCounselInput.setSelected(postTestCounsel);
  }

  public void setARV(boolean ARV) {
//    this.
  }

  public void setBloodFilm(boolean bloodFilm) {
    this.bloodFilmInput.setSelected(bloodFilm);
  }

  public void setITN(boolean itn) {
    this.itnInput.setSelected(itn);
  }
}
