/*
 * PregnancyRecord.java
 *
 * Created on February 22, 2016
 */

package edu.usm.cos420.antenatal.domain;

import edu.usm.cos420.antenatal.gui.VisitForm;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


/**
 *
 *  The Antenatal Visit class represents two things:
 *  a first visit and the initial information taken down
 *  on said visit -- and also all the general information
 *  associated with antenatal care at this facility that can
 *  be taken down during any visit (for example, diagnosis
 *  of HIV or Venereal Disease).  All Subsequent Visits will
 *  be recorded in order and linked to this initial visit object.
 *
 */
public class PregnancyRecord implements Serializable {

	private static final long serialVersionUID = 7526472295622776147L;

	int parity, systolicBP, diastolicBP, trimester, subVisits;
	int gestation; //num weeks of pregnancy, calculated from last period
	String iPTDoses;
  String TTDoses; //added together from tick marks
	double height, weight; //height in cm, weight in kg
	double fundalHeight; //in cm
	double hBAtReg, hBAt36Weeks; //Hemoglobin (hB) in grams/deciliter
	double urineTestSugar, urineTestProtein; // sug in mmol/Liter, prot in mg/dL
	LocalDate EDD; //Estimated day of delivery
	String bloodGroup, sicklingStatus, sicklingType;
	String vDLabResults, preTestCounsel, hIVResults, postTestCounsel, ARV;
	String bloodFilm;  //results of malaria blood film test
	String iTN;
	String id;  //id used to identify a particular set of antenatal visits
  String maleInvolvement;
  String remarks;
  String complaints;
  List<String> subIDs = new ArrayList<String>();


  public PregnancyRecord(String id){
		this.id = id;
	}

  public PregnancyRecord() {}

  public PregnancyRecord(VisitForm form) {
    setParity(form.getParity());
    setHIVResults(form.getHIVTestResults());
    setHeight(form.getPatientHeight());
    setWeight(form.getPatientWeight());
    setvDLabResults(form.getVDLabResults());
    setEDD(form.getEDD());
    setSystolicBP(form.getSystolicBP());
    setDiastolicBP(form.getDiastolicBP());
    setTrimester(form.getTrimester());
    setSubVisits(form.getSubVisitsInput());
    setGestation(form.getGestation());
    setIPTDoses(form.getIPTDoses());
    setTTDoses(form.getTTDoses());
    setFundalHeight(form.getFundalHeight());
    sethBAtReg(form.getHBAtReg());
    sethBAt36Weeks(form.getHBAt36Weeks());
    setUrineTestSugar(form.getUrineTestSugar());
    setUrineTestProtein(form.getUrineTestProtein());
    setBloodGroup(form.getBloodGroup());
    setBloodFilm(form.getBloodFilm());
    setSicklingStatus(form.getSicklingStatus());
    setSicklingType(form.getSicklingType());
    setPreTestCounsel(form.getPreTestCounsel());
    setPostTestCounsel(form.getPostTestCounsel());
    setITN(form.getITN()); 
    setARV(form.getARV());
    setMaleInvolvement(form.getMaleInvolvement());
    setComplaints(form.getComplaints());
    setRemarks(form.getRemarks());
  }

  @Override
  public String toString() {
    return "PregnancyRecord{" +
      "id='" + id + '\'' +
      ", parity=" + parity +
      ", systolicBP=" + systolicBP +
      ", diastolicBP=" + diastolicBP +
      ", trimester=" + trimester +
      ", subVisits=" + subVisits +
      ", gestation=" + gestation +
      ", iPTDoses=" + iPTDoses +
      ", TTDoses=" + TTDoses +
      ", height=" + height +
      ", weight=" + weight +
      ", fundalHeight=" + fundalHeight +
      ", hBAtReg=" + hBAtReg +
      ", hBAt36Weeks=" + hBAt36Weeks +
      ", urineTestSugar=" + urineTestSugar +
      ", urineTestProtein=" + urineTestProtein +
      ", EDD=" + EDD +
      ", bloodGroup='" + bloodGroup + '\'' +
      ", sicklingStatus='" + sicklingStatus + '\'' +
      ", sicklingType='" + sicklingType + '\'' +
      ", vDLabResults=" + vDLabResults +
      ", preTestCounsel=" + preTestCounsel +
      ", hIVResults=" + hIVResults +
      ", postTestCounsel=" + postTestCounsel +
      ", ARV=" + ARV +
      ", bloodFilm=" + bloodFilm +
      ", iTN=" + iTN +
      ", maleInvolvement=" + maleInvolvement +
      ", complaints=" + complaints +
      ", remarks=" + remarks +
      ", subVisits='" + subVisits + '\'' +
      '}';
  }

  /**
     * Returns ID of Antenatal Visit
     * @return id
     */
    public String getID(){
    	return id;
    }

    /**
     * Sets the id of the Antenatal Visit
     * @param id the id to set
     */
    public void setId(String id){
    	this.id = id;
    }

	/**
	 * returns the parity of the client
	 * @return the parity
	 */
	public int getParity() {
		return parity;
	}

	/**sets the parity of the client
	 * @param parity the parity to set
	 */
	public void setParity(int parity) {
		this.parity = parity;
	}

	/**returns systolic Blood Pressure
	 * @return the systolicBP
	 */
	public int getSystolicBP() {
		return systolicBP;
	}

	/**sets systolic Blood Pressure
	 * @param systolicBP the systolicBP to set
	 */
	public void setSystolicBP(int systolicBP) {
		this.systolicBP = systolicBP;
	}

	/**Return Diastolic Blood Pressure
	 * @return the diastolicBP
	 */
	public int getDiastolicBP() {
		return diastolicBP;
	}

	/**Sets the Diastolic Blood Pressure
	 * @param diastolicBP the diastolicBP to set
	 */
	public void setDiastolicBP(int diastolicBP) {
		this.diastolicBP = diastolicBP;
	}

	/**Returns the current trimester of the client.
	 * @return the trimester
	 */
	public int getTrimester() {
		return trimester;
	}

	/**Sets the current trimester of the client.
	 * @param trimester the trimester to set
	 */
	public void setTrimester(int trimester) {
		this.trimester = trimester;
	}

	/**Returns the number of subsequent visits
	 * @return the subVisits
	 */
	public int getSubVisits() {
		return subVisits;
	}

	/**Sets the number of subsequent visits
	 * @param subVisits the subVisits to set
	 */
	public void setSubVisits(int subVisits) {
		this.subVisits = subVisits;
	}

	/**Returns the gestation period of the pregnancy
	 * @return the gestation
	 */
	public int getGestation() {
		return gestation;
	}

	/**Sets the Gestation period of the pregnancy
	 * @param gestation the gestation to set
	 */
	public void setGestation(int gestation) {
		this.gestation = gestation;
	}

	/**Returns the number of IPT Doses given
	 * @return the iPTDoses
	 */
	public String getIPTDoses() {
		return iPTDoses;
	}

	/** Sets the number of IPT Doses given
	 * @param iPTDoses the iPTDoses to set
	 */
	public void setIPTDoses(String iPTDoses) {
		this.iPTDoses = iPTDoses;
	}

	/**Returns the number of ITP doses given
	 * @return the iTPDoses
	 */
	public String getTTDoses() {
		return TTDoses;
	}

	/**Sets the number of ITP Doses given
   * @param TTDoses the iTPDoses to set
   */
	public void setTTDoses(String TTDoses) {
		this.TTDoses = TTDoses;
	}

	/**Returns the height of the client
	 * @return the height
	 */
	public double getHeight() {
		return height;
	}

	/**Sets the height of the client
	 * @param height the height to set
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**Returns the weight of the client
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**Sets the weight of the client
	 * @param weight the weight to set
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**Returns the Fundal Height of the pregnancy
	 * @return the fundalHeight
	 */
	public double getFundalHeight() {
		return fundalHeight;
	}

	/**Sets the Fundal Height of the pregnancy
	 * @param fundalHeight the fundalHeight to set
	 */
	public void setFundalHeight(double fundalHeight) {
		this.fundalHeight = fundalHeight;
	}

	/**Returns the Hemoglobin at Registration of the client
	 * @return the hBAtReg
	 */
	public double getHBAtReg() {
		return hBAtReg;
	}

	/**Sets the Hemoglobin at Registration of the client
	 * @param hBAtReg the hBAtReg to set
	 */
	public void sethBAtReg(double hBAtReg) {
		this.hBAtReg = hBAtReg;
	}

	/**Returns the Hemoglobin at 36 weeks of pregnancy
	 * @return the hBAt36Weeks
	 */
	public double gethBAt36Weeks() {
		return hBAt36Weeks;
	}

	/**Sets the Hemoglobin at 36 weeks of pregnancy
	 * @param hBAt36Weeks the hBAt36Weeks to set
	 */
	public void sethBAt36Weeks(double hBAt36Weeks) {
		this.hBAt36Weeks = hBAt36Weeks;
	}

	/**Returns the sugar portion of the urine test results
	 * @return the urineTestSugar
	 */
	public double getUrineTestSugar() {
		return urineTestSugar;
	}

	/**Sets the sugar portion of the urine test results
	 * @param urineTestSugar the urineTestSugar to set
	 */
	public void setUrineTestSugar(double urineTestSugar) {
		this.urineTestSugar = urineTestSugar;
	}

	/**Returns the protein portion of the urine test results
	 * @return the urineTestProtein
	 */
	public double getUrineTestProtein() {
		return urineTestProtein;
	}

	/**Sets the protein portion of the urine test results
	 * @param urineTestProtein the urineTestProtein to set
	 */
	public void setUrineTestProtein(double urineTestProtein) {
		this.urineTestProtein = urineTestProtein;
	}

	/**Returns the Estimated Date of Delivery
	 * @return the eDD
	 */
	public LocalDate getEDD() {
		return EDD;
	}

	/**Sets the Estimated Date of Delivery
	 * @param eDD the eDD to set
	 */
	public void setEDD(LocalDate eDD) {
		EDD = eDD;
	}

	/**Returns the blood group of the client
	 * @return the bloodGroup
	 */
	public String getBloodGroup() {
		return bloodGroup;
	}

	/**Sets the blood group of the client
	 * @param bloodGroup the bloodGroup to set
	 */
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	/**Returns the Sickling Status of the client
	 * @return the sicklingStatus
	 */
	public String getSicklingStatus() {
		return sicklingStatus;
	}

	/**Sets the Sickling Status of the client
	 * @param sicklingStatus the sicklingStatus to set
	 */
	public void setSicklingStatus(String sicklingStatus) {
		this.sicklingStatus = sicklingStatus;
	}

	/**Returns the Sickling Type of the client
	 * @return the sicklingType
	 */
	public String getSicklingType() {
		return sicklingType;
	}

	/**Sets the Sickling Type of the client
	 * @param sicklingType the sicklingType to set
	 */
	public void setSicklingType(String sicklingType) {
		this.sicklingType = sicklingType;
	}

	/**Returns the Venereal Disease lab results
	 * @return the vDLabResults
	 */
	public String getVDLabResults() {
		return vDLabResults;
	}

	/**Sets the Venereal Disease lab results
   * @param vDLabResults the vDLabResults to set
   */
	public void setvDLabResults(String vDLabResults) {
		this.vDLabResults = vDLabResults;
	}

	/**Returns whether the client has had an HIV Pre-Test Counsel
	 * @return the preTestCounsel
	 */
	public String getPreTestCounsel() {
		return preTestCounsel;
	}

	/**Sets whether the client has had an HIV Pre-Test Counsel
   * @param preTestCounsel the preTestCounsel to set
   */
	public void setPreTestCounsel(String preTestCounsel) {
		this.preTestCounsel = preTestCounsel;
	}

	/**Returns the HIV test results of the client
	 * @return the hIVResults
	 */
	public String getHIVResults() {
		return hIVResults;
	}

	/**Sets the HIV test results of the client
   * @param hIVResults the hIVResults to set
   */
	public void setHIVResults(String hIVResults) {
		this.hIVResults = hIVResults;
	}

	/**Returns whether the client has had a Post-Test Counsel
	 * @return the postTestCounsel
	 */
	public String getPostTestCounsel() {
		return postTestCounsel;
	}

	/**Sets whether the client has had a Post-Test Counsel
   * @param postTestCounsel the postTestCounsel to set
   */
	public void setPostTestCounsel(String postTestCounsel) {
		this.postTestCounsel = postTestCounsel;
	}

	/**Returns whether the client is on Anti-Retroviral drugs
	 * @return the aRV
	 */
	public String getARV() {
		return ARV;
	}

	/**Sets whether the client is on Anti-Retroviral drugs
   * @param aRV the aRV to set
   */
	public void setARV(String aRV) {
		ARV = aRV;
	}

	/**Returns the results of the blood film test for Malaria
	 * @return the bloodFilm
	 */
	public String getBloodFilm() {
		return bloodFilm;
	}

	/**Sets the results of the blood film test for Malaria
   * @param bloodFilm the bloodFilm to set
   */
	public void setBloodFilm(String bloodFilm) {
		this.bloodFilm = bloodFilm;
	}

  public void setMaleInvolvement(String maleInvolvement) {
    this.maleInvolvement = maleInvolvement;
  }

  public void setComplaints(String complaints) {
    this.complaints = complaints;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

	/**Returns whether the client uses Insecticide-Treated Nets
	 * @return the iTN
	 */
	public String getITN() {
		return iTN;
	}

	/**Sets whether the client uses Insecticide-Treated Nets
   * @param iTN the iTN to set
   */
	public void setITN(String iTN) {
		this.iTN = iTN;
	}

	/**
	 * @return the serialVersionUID
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

  public String getMaleInvolvement() {
    return maleInvolvement;
  }

  public String getRemarks() {
    return remarks;
  }

  public String getComplaints() {
    return complaints;
  }
  
  public List<String> getSubIDs(){
     return subIDs;
  }
  
  public void setSubID(String subID){
     subIDs.add(subID);
  }
}
