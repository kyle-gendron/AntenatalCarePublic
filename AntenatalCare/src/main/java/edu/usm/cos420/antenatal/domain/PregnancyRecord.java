package edu.usm.cos420.antenatal.domain;

import edu.usm.cos420.antenatal.domain.interfaces.IPerson;
import edu.usm.cos420.antenatal.domain.interfaces.IPregnancyRecord;

import javax.ejb.Local;
import java.time.LocalDate;

/**
 * Created by aaron on 4/26/2016.
 */
public abstract class PregnancyRecord implements IPregnancyRecord {
  protected int systolicBP;
  protected int diastolicBP;
  protected double weight; //weight in kg
  protected double fundalHeight; //in cm
  protected LocalDate apptDate; //date of subsequent visit
  protected String id;
  private LocalDate updatedDate;
  private LocalDate createdDate;
  private String personId;

  /**
   * Returns ID of Antenatal Visit
   *
   * @return id
   */
  public String getId() {
    return id;
  }

  /**
   * Sets the id of the Antenatal Visit
   *
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }

  public int getSystolicBP() {
    return systolicBP;
  }

  public void setSystolicBP(int systolicBP) {
    this.systolicBP = systolicBP;
  }

  public int getDiastolicBP() {
    return diastolicBP;
  }

  public void setDiastolicBP(int diastolicBP) {
    this.diastolicBP = diastolicBP;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public double getFundalHeight() {
    return fundalHeight;
  }

  public void setFundalHeight(double fundalHeight) {
    this.fundalHeight = fundalHeight;
  }

  public LocalDate getApptDate() {
    return apptDate;
  }

  public void setApptDate(LocalDate apptDate) {
    this.apptDate = apptDate;
  }

  public LocalDate getUpdatedDate() {
    return updatedDate;
  }

  public void setUpdatedDate(LocalDate date) {
    this.updatedDate = date;
  }


  public LocalDate getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(LocalDate date) {
    this.createdDate = date;
  }

  public String getPersonId() {
    return personId;
  }

  public void setPersonId(String id) {
    this.personId = id;
  }

}
