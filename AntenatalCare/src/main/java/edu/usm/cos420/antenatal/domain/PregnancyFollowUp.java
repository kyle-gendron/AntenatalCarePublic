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
import java.util.UUID;


/**
 * The PregnancyFollowUp class represents a follow up visit
 * of the initial visit with the id given. These visits record
 * only a subset of the information from the initial visit,
 * including date, blood pressure, weight, fundal height,
 * blood film, and referred.
 */
public class PregnancyFollowUp extends PregnancyRecord {
	
  private String initialVisitID;
  private String referred;
  private String bloodFilm;
  
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
  public PregnancyFollowUp(String subVisitID, String initialVisitID, int systolicBP, int diastolicBP,
                           double weight, double fundalHeight, LocalDate apptDate, String bloodFilm,
                           String referred) {
    setId(subVisitID);
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
  public PregnancyFollowUp(String subVisitID, String initialVisitID, int systolicBP, int diastolicBP,
                           double weight, double fundalHeight, String bloodFilm, String referred) {
    setId(subVisitID);
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
  public PregnancyFollowUp(ResultSet rs) throws SQLException {
    Date apptdate = rs.getDate("apptdate");
    LocalDate apDate = null;
    if (apptdate != null) {
      apDate = apptdate.toLocalDate();
    }

    setId(rs.getString("subid"));
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

  public PregnancyFollowUp() {
    setId(UUID.randomUUID().toString());
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

    return "PregnancyFollowUp{" +
      "InitVisitID=" + initialVisitID +
      ", systolicBP=" + systolicBP +
      ", diastolicBP=" + diastolicBP +
      ", weight=" + weight +
      ", fundalHeight=" + fundalHeight +
      ", SubVisit Date=" + (apptDate != null ? apptDate.toString() : "None") +
      ", bloodFilm=" + bloodFilm +
      ", referred=" + referred +
      '}';
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

  public String getBloodFilm() {
    return bloodFilm;
  }

  public void setBloodFilm(String bloodFilm) {
    this.bloodFilm = bloodFilm;
  }

}
