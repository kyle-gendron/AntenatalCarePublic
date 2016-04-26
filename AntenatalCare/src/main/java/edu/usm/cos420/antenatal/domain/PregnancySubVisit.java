/*
 * PregnancySubVisit.java
 *
 * Created on March 5, 2016
 */

package edu.usm.cos420.antenatal.domain;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


/**
 * The PregnancySubVisit class represents a follow up visit
 * of the initial visit with the id given. These visits record
 * only a subset of the information from the initial visit,
 * including date, blood pressure, weight, fundal height,
 * blood film, and referred.
 */
public class PregnancySubVisit extends PregnancyRecord {

  /**
   *
   */
  private static final long serialVersionUID = -1091510392443704764L;
  private String subVisitID;

  private String initialVisitID;
  private int systolicBP, diastolicBP;
  private double weight; //weight in kg
  private double fundalHeight; //in cm
  private LocalDate apptDate; //date of subsequent visit
  private String bloodFilm;  //results of malaria blood film test
  private String referred;

  /**
   * Eight-Field Constructor: The constructor to be used when all fields are being set
   *
   * @param subVisitID     the id of this subsequent visit
   * @param initialVisitID the id of the initial visit for the pregnancy
   * @param systolicBP     the systolic blood pressure
   * @param diastolicBP    the diastolic blood pressure
   * @param weight         the weight of the patient
   * @param fundalHeight   the height of pregnancy
   * @param apptDate       the date of the subsequent appointment
   * @param bloodFilm      whether the malaria parasite is present
   * @param referred       whether the patient was referred
   */
  public PregnancySubVisit(String subVisitID, String initialVisitID, int systolicBP, int diastolicBP,
                           double weight, double fundalHeight, LocalDate apptDate, String bloodFilm, String referred) {
    this.subVisitID = subVisitID;
    this.initialVisitID = initialVisitID;
    this.systolicBP = systolicBP;
    this.diastolicBP = diastolicBP;
    this.weight = weight;
    this.fundalHeight = fundalHeight;
    this.apptDate = apptDate;
    this.bloodFilm = bloodFilm;
    this.referred = referred;
  }

  /**
   * Seven-Field Constructor: The constructor to be used when the appointment date
   * is defaulted to today's date
   *
   * @param initialVisitID the id of the initial visit for the pregnancy
   * @param systolicBP     the systolic blood pressure
   * @param diastolicBP    the diastolic blood pressure
   * @param weight         the weight of the patient
   * @param fundalHeight   the height of pregnancy
   * @param bloodFilm      whether the malaria parasite is present
   * @param referred       whether the patient was referred
   */
  public PregnancySubVisit(String subVisitID, String initialVisitID, int systolicBP, int diastolicBP,
                           double weight, double fundalHeight, String bloodFilm, String referred) {
    this.subVisitID = subVisitID;
    this.initialVisitID = initialVisitID;
    this.systolicBP = systolicBP;
    this.diastolicBP = diastolicBP;
    this.weight = weight;
    this.fundalHeight = fundalHeight;
    this.apptDate = LocalDate.now();
    this.bloodFilm = bloodFilm;
    this.referred = referred;
  }

  /**
   * @param rs is a resultset from the sql database containing all values.
   * @throws SQLException
   */
  public PregnancySubVisit(ResultSet rs) throws SQLException {
    Date apptdate = rs.getDate("apptdate");
    LocalDate apDate = null;
    if (apptdate != null) {
      apDate = apptdate.toLocalDate();
    }

    setID(rs.getString("subid"));
    setInitialID(rs.getString("pregnancyid"));
    setSystolicBP(rs.getInt("systolicbp"));
    setDiastolicBP(rs.getInt("diastolicBP"));
    setWeight(rs.getDouble("weight"));
    setFundalHeight(rs.getDouble("fh"));
    setApptDate(apDate);
    setBloodFilm(rs.getString("bloodfilm"));
    setReferral(rs.getString("refer"));

    //ADD timestamp
  }

  public PregnancySubVisit() {
    this.subVisitID = null;
    this.initialVisitID = null;
    this.systolicBP = 0;
    this.diastolicBP = 0;
    this.weight = 0;
    this.fundalHeight = 0;
    this.apptDate = null;
    this.bloodFilm = null;
    this.referred = null;
  }

  @Override
  public String toString() {
    return "PregnancySubVisit{" +
      "InitVisitID=" + initialVisitID +
      ", systolicBP=" + systolicBP +
      ", diastolicBP=" + diastolicBP +
      ", weight=" + weight +
      ", fundalHeight=" + fundalHeight +
      ", SubVisit Date=" + apptDate.toString() +
      ", bloodFilm=" + bloodFilm +
      ", referred=" + referred +
      '}';
  }

  /**
   * Returns ID of Subsequent Visit
   *
   * @return id
   */
  public String getID() {
    return subVisitID;
  }

  /**
   * Sets the id of the Subsequent Visit
   *
   * @param id the id to set
   */
  public void setID(String id) {
    this.subVisitID = id;
  }

  /**
   * Returns ID of initial Antenatal Visit
   *
   * @return id
   */
  public String getInitialID() {
    return initialVisitID;
  }

  /**
   * Sets the id of the initial Antenatal Visit
   *
   * @param id the id to set
   */
  public void setInitialID(String id) {
    this.initialVisitID = id;
  }

  /**
   * returns systolic Blood Pressure
   *
   * @return the systolicBP
   */
  public int getSystolicBP() {
    return systolicBP;
  }

  /**
   * sets systolic Blood Pressure
   *
   * @param systolicBP the systolicBP to set
   */
  public void setSystolicBP(int systolicBP) {
    this.systolicBP = systolicBP;
  }

  /**
   * Return Diastolic Blood Pressure
   *
   * @return the diastolicBP
   */
  public int getDiastolicBP() {
    return diastolicBP;
  }

  /**
   * Sets the Diastolic Blood Pressure
   *
   * @param diastolicBP the diastolicBP to set
   */
  public void setDiastolicBP(int diastolicBP) {
    this.diastolicBP = diastolicBP;
  }

  /**
   * Returns the weight of the client
   *
   * @return the weight
   */
  public double getWeight() {
    return weight;
  }

  /**
   * Sets the weight of the client
   *
   * @param weight the weight to set
   */
  public void setWeight(double weight) {
    this.weight = weight;
  }

  /**
   * Returns the Fundal Height of the pregnancy at visit
   *
   * @return the fundalHeight
   */
  public double getFundalHeight() {
    return fundalHeight;
  }

  /**
   * Sets the Fundal Height of the pregnancy at visit
   *
   * @param fundalHeight the fundalHeight to set
   */
  public void setFundalHeight(double fundalHeight) {
    this.fundalHeight = fundalHeight;
  }

  /**
   * Returns the Estimated Date of Delivery
   *
   * @return the eDD
   */
  public LocalDate getApptDate() {
    return apptDate;
  }

  /**
   * Sets the Estimated Date of Delivery
   *
   * @param date the eDD to set
   */
  public void setApptDate(LocalDate date) {
    apptDate = date;
  }

  /**
   * Returns the results of the blood film test for Malaria
   *
   * @return the bloodFilm
   */
  public String bloodFilmResults() {
    return bloodFilm;
  }

  /**
   * Sets the results of the blood film test for Malaria
   *
   * @param bloodFilm the bloodFilm to set
   */
  public void setBloodFilm(String bloodFilm) {
    this.bloodFilm = bloodFilm;
  }

  public String getReferral() {
    return referred;
  }

  /**
   * Sets the results of the blood film test for Malaria
   *
   * @param refer the bloodFilm to set
   */
  public void setReferral(String refer) {
    this.referred = refer;
  }

}
