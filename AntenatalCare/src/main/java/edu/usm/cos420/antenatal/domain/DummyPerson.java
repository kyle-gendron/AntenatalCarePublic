package edu.usm.cos420.antenatal.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DummyPerson implements Serializable{
   
   /**
    * Stub person object to populate fields in GUI coming from the consulting register
    * this will be removed later once we get the actually dummy from the consulting register
    */
   private static final long serialVersionUID = -1931254923689371768L;
  private String dateOfBirth = "1/1/1970";
  private String id;
   private static Long COUNTER = 0L;
   private String FacZone = "A Facility";
   private String Subdistrict = "A Subdistrict";
   private String District = "A District";
   private String Year = "2016";
   private int SerialNumber = 1;
   private LocalDate Date = LocalDate.now();
   private int RegNumber = 1234;
   private int HININumber = 564532;
   private String name = "Hello, my name is...";
   private String Address = "2nd on right";
   private int Age = 21;
   private List<Long> visitID = new ArrayList<Long>();
   

   public DummyPerson(){
      id = String.valueOf(generateId());
   }

  public DummyPerson(String id, String dateOfBirth, String firstName, String gender, String houseNumber, String lastName, String village) {
    this.id = id;
    this.name = lastName + ", " + firstName;
    this.dateOfBirth = dateOfBirth;
    System.out.println("Name: " + name + " DOB: " + dateOfBirth);
  }

  public String getFacZone(){
      return FacZone;
   }
   public String getSubdistrict(){
      return Subdistrict;
   }
   public String getDistrict(){
      return District; 
   }
   public String getYear(){
      return Year; 
   }
   public int getSerialNumber(){
      return SerialNumber;
   }
   public LocalDate getDate(){
      return Date; 
   }
   public int getRegNumber(){
      return RegNumber; 
   }
   public int getHININumber(){
      return HININumber; 
   }
   public String getName(){
      return name;
   }
   public String getAddress(){
      return Address;
   }
   public int getAge(){
      return Age;
   }
   public List<Long> getVisitIDs(){
      return visitID;
   }
   public String getId() {
      return id;
   }
   // for autogeneration of ids
   private Long generateId()
   {
     return COUNTER++;
   }

   
   
   

}
