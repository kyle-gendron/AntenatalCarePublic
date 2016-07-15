package edu.usm.cos420.antenatal.domain;

import edu.usm.cos420.antenatal.domain.interfaces.IPerson;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DummyPerson implements IPerson {

  /**
   * Stub person object to populate fields in GUI coming from the consulting register
   * this will be removed later once we get the actually dummy from the consulting register
   */
  private String dateOfBirth;
  private String id;
  private static Long COUNTER;
  private String FacZone;
  private String Subdistrict;
  private String District;
  private String Year;
  private int SerialNumber;
  private LocalDate Date;
  private int RegNumber;
  private int HININumber;
  private String name;
  private String Address;
  private int Age;
  private List<Long> visitID;


  public DummyPerson() {
    id = String.valueOf(generateId());
  }

  public DummyPerson(String id, String dateOfBirth, String firstName, String gender, String houseNumber, String lastName, String village) {
    this.id = id;
    this.name = lastName + ", " + firstName;
    this.dateOfBirth = dateOfBirth;
    System.out.println("Name: " + name + " DOB: " + dateOfBirth);
  }

  public String getFacZone() {
    return FacZone;
  }

  public String getSubDistrict() {
    return Subdistrict;
  }

  public String getDistrict() {
    return District;
  }

  public String getYear() {
    return Year;
  }

  public int getSerialNumber() {
    return SerialNumber;
  }

  public LocalDate getDate() {
    return Date;
  }

  public int getRegNumber() {
    return RegNumber;
  }

  public int getHININumber() {
    return HININumber;
  }

  public String getName() {
    return name;
  }

  public String getAddress() {
    return Address;
  }

  public int getAge() {
    return Age;
  }

  public List<Long> getVisitIDs() {
    return visitID;
  }

  public String getId() {
    return id;
  }

  // for autogeneration of ids
  private Long generateId() {
    return COUNTER++;
  }


}
