package edu.usm.cos420.antenatal.gui;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Properties;

import static edu.usm.cos420.antenatal.controller.Utils.parseDouble;
import static edu.usm.cos420.antenatal.controller.Utils.parseInteger;


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
	private final JDatePickerImpl eedInput;
	private final JTextField hbaAt36WeeksInput;
	private final JTextField urineTestSugarInput;
	private final JTextField urineTestProteinInput;
	private final JComboBox bloodTypeGroup;
	private final JComboBox sicklingStatusInput;
	private final JComboBox sicklingTypeInput;
	private final JComboBox resultsVDLabInput;
	private final JComboBox preTestCounselInput;
	private final JComboBox postTestCounselInput;
	private final JComboBox bloodFilmInput;
	private final JComboBox malePresentInput;
	private final JComboBox trimesterInput;
	private final JComboBox subVisitsInput;
	private final JComboBox ttDosesInput;
	private final JComboBox iptInput;
	private final JComboBox itnInput;
	private final JTextArea complaints;
	private final JTextArea remarks;
	private final JTextField hbaAtRegInput;
	private final JComboBox hivTestInput;
	private final JComboBox ARVInput;
	private UtilDateModel dateModel;
	private final JLabel errorFields;
	private final JPanel errorField;

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

		errorField = new JPanel();
		errorFields = new JLabel("");
		errorField.add(errorFields);

		JLabel parity = new JLabel("Parity:"); //integer
		parityInput = new JTextField(2);
		JLabel BloodPressure = new JLabel("Blood Pressure:");
		systolicInput = new JTextField(2);//ADD TWO Fields int/int
		JLabel fill = new JLabel("/");
		diastolicInput = new JTextField(2);

		JPanel bloInput = new JPanel();
		bloInput.add(BloodPressure);
		bloInput.add(systolicInput);
		bloInput.add(fill);
		bloInput.add(diastolicInput);
		bloInput.setLayout(new FlowLayout());

		JLabel Height = new JLabel("Height (cm): ");//double
		heightInput = new JTextField(3);
		JLabel Weight = new JLabel("Weight (kg): ");//double
		weightInput = new JTextField(3);

		JPanel size = new JPanel();
		size.add(Height);
		size.add(heightInput);
		size.add(Weight);
		size.add(weightInput);
		size.setLayout(new GridLayout(2,3));

		//number of weeks pregnant
		JLabel Gestation = new JLabel("Gestation:");//int
		gestationInput = new JTextField(3);//How to Calculate

		//measurement of uterus in CM
		JLabel FHeight = new JLabel("Fundal Height (cm):");//Double
		fundalHeightInput = new JTextField(3);
		JPanel FundalHeight = new JPanel();
		FundalHeight.add(FHeight);
		FundalHeight.add(fundalHeightInput);

		//date baby is due
		JLabel EEDL = new JLabel("Due Date:");
		//    eedInput = new JTextField(10); //Determine how we want date entered.

		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		dateModel = new UtilDateModel();
		JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, p);
		eedInput = new JDatePickerImpl(datePanel, new DateLabelFormatter());

		JPanel EED = new JPanel();
		EED.add(EEDL);
		EED.add(eedInput);

		//test hemoglobin
		JLabel HBatR = new JLabel("HBatReg (g/dL):");//Double grams/deciliter
		hbaAtRegInput = new JTextField(3);//how to calculate
		JPanel HBatReg = new JPanel();
		HBatReg.add(HBatR);
		HBatReg.add(hbaAtRegInput);

		// test Hemoglobin @ 36 weeks
		hbaAt36WeeksInput = new JTextField(3);
		JPanel HBat36 = new JPanel();
		HBat36.add(new JLabel("HBat36 (g/dL):"));//double g/dl
		HBat36.add(hbaAt36WeeksInput);

		//testing for sugar & protein in urine
		urineTestSugarInput = new JTextField(3);
		urineTestProteinInput = new JTextField(3);
		JPanel UrineTest = new JPanel();
		UrineTest.add(new JLabel("Urine Test (Sugar):"));//Sugar/Protein- double mmol/L / double mg/dL
		UrineTest.add(urineTestSugarInput);
		UrineTest.add(new JLabel("Urine Test (Protein):"));
		UrineTest.add(urineTestProteinInput);

		//blood type/group
		JPanel BloodGroup = new JPanel();
		bloodTypeGroup = new JComboBox<>(new String[] {"","O","A","B","AB"});
		BloodGroup.add(new JLabel("Blood Group:")); //String, Drop down with options
		BloodGroup.add(bloodTypeGroup);

		//sickle cell anemia testing
		JLabel Sicklin = new JLabel("Sickling:");//Status/Type string/string (drop down)
		JPanel Sickling = new JPanel();
		sicklingStatusInput = new JComboBox<>(new String[] {"","Positive","Negative"});
		sicklingTypeInput = new JComboBox<>(new String[] {"","N/a","Hemoglobin SS","Hemoglobin SC","Hemoglobin SB+ (Beta) Thalassemia","Beta-Zero Thalassemia"});
		Sickling.add(Sicklin);
		Sickling.add(sicklingStatusInput);
		Sickling.add(sicklingTypeInput);

		//venereal disease testing
		JLabel VDLa = new JLabel("VD Lab:");//button group reactive or non-reactive
		JPanel VDLab = new JPanel();
		resultsVDLabInput = new JComboBox<>(new String[] {"", "Non-Reactive", "Reactive"});
		VDLab.add(VDLa);
		VDLab.add(resultsVDLabInput);


		//pre VD test consoling
		JLabel PMTC = new JLabel("Pre-Test Counseling:");//yes
		JPanel PMTCT = new JPanel();
		preTestCounselInput = new JComboBox<>(new String[] {"", "Yes", "No"});
		PMTCT.add(PMTC);
		PMTCT.add(preTestCounselInput);

		//VD test result
		JPanel TestResult = new JPanel();
		hivTestInput = new JComboBox<>(new String[] {"", "Positive", "Negative"});
		TestResult.add(new JLabel("Test-Result:"));
		TestResult.add(hivTestInput);

		//Post VD test counseling
		JPanel PostTest = new JPanel();
		postTestCounselInput = new JComboBox<>(new String[] {"", "Yes", "No"});
		PostTest.add(new JLabel("Post-Test Counseling:"));
		PostTest.add(postTestCounselInput);

		//ARV Drug Prescription
		JPanel ARV =new JPanel();
		ARVInput =  new JComboBox<>(new String[] {"", "Yes", "No"});
		ARV.add(new JLabel("ARV Drug Use:"));
		ARV.add(ARVInput);
		
		//malaria testing p/np
		JPanel BloodFilm = new JPanel();
		bloodFilmInput = new JComboBox<>(new String[] {"", "Not Present", "Present"});
		BloodFilm.add(new JLabel("Blood Film:"));
		BloodFilm.add(bloodFilmInput);

		//men involvement y/n
		JPanel MaleInvolved = new JPanel();
		malePresentInput = new JComboBox<>(new String[] {"", "Not Present", "Present"});
		MaleInvolved.add(new JLabel("Male Involvement:"));
		MaleInvolved.add(malePresentInput);

		//what trimester they are at
		JPanel Trimester = new JPanel();
		trimesterInput = new JComboBox<>(new String[] {"", "1", "2", "3"});
		Trimester.add(new JLabel("Trimester:"));
		Trimester.add(trimesterInput);

		//sub visits
		JPanel Sub = new JPanel();
		subVisitsInput = new JComboBox<>(new String[] {"","2","3","4","5","6","7","8","9","10","11","12"});
		Sub.add(new JLabel("Subsequent Visits:"));
		Sub.add(subVisitsInput);

		//Tetanus shot give,boster, & protected
		JPanel TT = new JPanel();
		ttDosesInput = new JComboBox<>(new String[] {"","given","booster","protected"});
		TT.add(new JLabel("TT:"));
		TT.add(ttDosesInput);

		//ipt/doses
		JPanel IPT = new JPanel();
		iptInput = new JComboBox<>(new String[] {"","1","2","3"});
		IPT.add(new JLabel("IPT Doses:"));
		IPT.add(iptInput);
		
		//stuff of ITN
		JPanel ITN = new JPanel();
		itnInput = new JComboBox<>(new String[] {"", "Yes", "No"});
		ITN.add(new JLabel("ITN:"));
		ITN.add(itnInput);

		//add complaints field
		JPanel textHold = new JPanel();
		complaints = new JTextArea(2,12);
		remarks = new JTextArea(2,12);
		complaints.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		remarks.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		textHold.add(new JLabel("Complaints:"));
		textHold.add(complaints);

		//add remarks field
		textHold.add(new JLabel("Remarks:"));
		textHold.add(remarks);

		//add change listeners
		sicklingStatusInput.addActionListener(new formListener());
		bloodFilmInput.addActionListener(new formListener());getInsets();
		hivTestInput.addActionListener(new formListener());

		//add data to frame
		panel.add(errorFields);
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
		panel.add(ARV);
		panel.add(BloodFilm);
		panel.add(MaleInvolved);
		panel.add(Trimester);
		panel.add(Sub);
		panel.add(TT);
		panel.add(IPT);
		panel.add(ITN);
		panel.add(textHold);

		//disables fields where others are required
		sicklingTypeInput.setEnabled(false);
		ARVInput.setEnabled(false);
	}

	/**
	 *
	 * @return the JPanel created
	 */
	public JPanel getPanel() {
		return panel;
	}

	class formListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO: Verify all Fields
			//TODO: update error label(s) / add red around erroneous things

			if(getSicklingStatus().equals("Positive") == true){
				sicklingTypeInput.setEnabled(true);
			}else{
				sicklingTypeInput.setEnabled(false);
			}	

			if(getHIVTestResults().equals("Positive"))
				ARVInput.setEnabled(true);
			else
				ARVInput.setEnabled(false);

		}
	}

	public void errorMessage(String errorMessage) {
		if(errorMessage != null){
			errorFields.setBorder(BorderFactory.createLineBorder(Color.red));
			errorFields.setText(errorMessage);
			Dimension size = errorFields.getPreferredSize();
			size.setSize(size.getWidth() + 10, size.getHeight() + 10);
			errorField.setSize(size);
			errorFields.setSize(size);
		}else{
			errorField.setToolTipText("");
		}
	}

	/**
	 *
	 * @return String of the parity field, or -1 if invalid
	 */
	public int getParity() {
		return parseInteger(parityInput.getText(), -1);
	}

	/**
	 *
	 * @return Returns double of the patients height, or -1 if invalid
	 */
	public Double getPatientHeight() {
		return parseDouble(heightInput.getText());
	}

	/**
	 *
	 * @return Returns double of the patients weight, or -1 if invalid
	 */
	public Double getPatientWeight() {
		return parseDouble(weightInput.getText());
	}

	/**
	 *
	 * @return Returns int val of the patients Systollic blood pressue
	 */
	public int getSystolicBP(){
		return parseInteger(systolicInput.getText());
	}
	/**
	 *
	 * @return returns int val of the patients Diastolic blood pressure
	 */
	public int getDiastolicBP(){
		return parseInteger(diastolicInput.getText());
	}

	/**
	 *
	 * @return returns int val of the trimester, or -1 if error
	 */
	public int getTrimester(){
		int gest = getGestation();
		if(gest <= 13 ){//tri 1
			return 1;
		}else if(gest <= 26){//tri2
			return 2;
		}else{
			return 3;
		}
	}

	public int getSubVisitsInput(){
		Object selectedSubVis = subVisitsInput.getSelectedItem();
		//TODO: may or not be correct val
		String subvis = selectedSubVis.toString();
		if(subvis.equals("") == false){
			return Integer.valueOf(subvis);
		}
		return 0;
	}

	public int getGestation(){
		return parseInteger(gestationInput.getText());
	}

	public String getIPTDoses(){
		return String.valueOf(iptInput.getSelectedItem());
	}
	/**
	 *
	 * @return Returns the number of doses
	 */
	public String getTTDoses(){
		return String.valueOf(ttDosesInput.getSelectedItem());
	}
	/**
	 *
	 * @return Double value of the fundal height
	 */
	public double getFundalHeight(){
		return parseDouble(fundalHeightInput.getText());
	}

	/**
	 *
	 * @return Double value of the hemoglobin levels at registration
	 */
	public double getHBAtReg(){
		return parseDouble(hbaAtRegInput.getText());
	}

	/**
	 *
	 * @return Double value of the hemoglobin levels at 36 weeks
	 */
	public double getHBAt36Weeks(){
		return parseDouble(hbaAt36WeeksInput.getText());
	}

	/**
	 *
	 * @return Double val of the urine sugar test results
	 */
	public double getUrineTestSugar(){
		return parseDouble(urineTestSugarInput.getText());
	}
	/**
	 *
	 * @return Doubleval of the urine protein test results
	 */
	public double getUrineTestProtein(){
		return parseDouble(urineTestProteinInput.getText());
	}

	/**
	 *
	 * @return a GregorianCalendar of the estimated due date
	 */
	public LocalDate getEDD(){
		Date pickerDate = (Date) eedInput.getModel().getValue();
		LocalDate date = null;
		if (pickerDate != null) {
			date = pickerDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		}
		return date;
	}

	/**
	 *
	 * @return String representation of blood group
	 */
	public String getBloodGroup(){
		Object blood = bloodTypeGroup.getSelectedItem();

		String bt = blood.toString();

		return bt;
	}

	/**
	 *
	 * @return String representation of sickling status
	 */
	public String getSicklingStatus(){
		Object sickStat = sicklingStatusInput.getSelectedItem();

		String st = sickStat.toString();

		return st;
	}

	/**
	 *
	 * @return String representation of sickling type
	 */
	public String getSicklingType(){
		Object sickStat = sicklingTypeInput.getSelectedItem();

		String st = sickStat.toString();

		return st;
	}
	/**
	 *
	 * @return Returns true if reactive, else false
	 */
	public String getVDLabResults(){
		return String.valueOf(resultsVDLabInput.getSelectedItem());
	}
	/**
	 *
	 * @return Returns True if yes, else returns false
	 */
	public String getPreTestCounsel(){
		return String.valueOf(preTestCounselInput.getSelectedItem());
	}

	/**
	 *
	 * @return Returns true is yes, else returns false
	 */
	public String getPostTestCounsel(){
		return String.valueOf(postTestCounselInput.getSelectedItem());
	}

	/**
	 *
	 * @return Returns true is yes, else returns false
	 */
	public String getARV(){
		return String.valueOf(ARVInput.getSelectedItem());
	}
	
	/**
	 *
	 * @return Returns true if malaria pos, else false
	 */
	public String getBloodFilm(){
		return String.valueOf(bloodFilmInput.getSelectedItem());
	}
	/**
	 *
	 * @return Returns true if male involved, else false
	 */
	public String getMaleInvolvement(){
		return String.valueOf(malePresentInput.getSelectedItem());
	}

	/**
	 *
	 * @return returns true if yes, returns false otherwise
	 */
	public String getITN(){
		return String.valueOf(itnInput.getSelectedItem());
	}


	public String getHIVTestResults() {
		return String.valueOf(this.hivTestInput.getSelectedItem());
	}

	public String getComplaints() {
		return complaints.getText();
	}

	public String getRemarks() {
		return remarks.getText();
	}

	public void setParity(int parity) {
		this.parityInput.setText(String.valueOf(parity));
	}

	public void setSystolicBP(int systolicBP) {
		this.systolicInput.setText(String.valueOf(systolicBP));
	}

	public void setDiastolicBP(int diastolicBP) {
		this.diastolicInput.setText(String.valueOf(diastolicBP));
	}

	public void setTrimester(int trimester) {
		this.trimesterInput.setSelectedIndex(trimester);
	}

	public void setGestation(int gestation) {
		this.gestationInput.setText(String.valueOf(gestation));
	}

	public void setIPTDoses(String IPTDoses) {
		this.iptInput.setSelectedItem(IPTDoses);
	}

	public void setTTDoses(String TTDoses) {
		this.ttDosesInput.setSelectedItem(TTDoses);
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
		if (EDD != null) {
			this.dateModel.setDate(EDD.getYear(), EDD.getMonthValue()-1, EDD.getDayOfMonth());
			this.dateModel.setSelected(true);
		}
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodTypeGroup.setSelectedItem(bloodGroup);
	}

	public void setSicklingStatus(String sicklingStatus) {
		this.sicklingStatusInput.setSelectedItem(sicklingStatus);
	}

	public void setSicklingType(String sicklingType) {
		this.sicklingTypeInput.setSelectedItem(sicklingType);
	}

	public void setVDLabResults(String VDLabResults) {
		this.resultsVDLabInput.setSelectedItem(VDLabResults);
	}

	public void setPreTestCounsel(String preTestCounsel) {
		this.preTestCounselInput.setSelectedItem(preTestCounsel);
	}

	public void setHIVResults(String HIVResults) {
		this.hivTestInput.setSelectedItem(HIVResults);
	}

	public void setPostTestCounsel(String postTestCounsel) {
		this.postTestCounselInput.setSelectedItem(postTestCounsel);
	}

	public void setARV(String ARV) {
		this.ARVInput.setSelectedItem(ARV);
	}

	public void setBloodFilm(String bloodFilm) {
		this.bloodFilmInput.setSelectedItem(bloodFilm);
	}

	public void setITN(String itn) {
		this.itnInput.setSelectedItem(itn);
	}

	public void setMaleInvolvement(String maleInvolvement) {
		this.malePresentInput.setSelectedItem(maleInvolvement);
	}

	public void setComplaints(String complaints) {
		this.complaints.setText(complaints);
	}

	public void setRemarks(String remarks) {
		this.remarks.setText(remarks);
	}

	public void setSubVisits(int subVisits) {
		this.subVisitsInput.setSelectedItem(String.valueOf(subVisits));
	}
}