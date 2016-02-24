package edu.usm.cos420.antenatal.domain;

import java.time.LocalDate;

public class DummyPerson {
   
   private String FacZone = "A Facility";
   private String Subdistrict = "A Subdistrict"; 
   private String District = "A District"; 
   private String Year = "2016"; 
   private int SerialNumber = 1; 
   private LocalDate Date = LocalDate.now(); 
   private int RegNumber = 1234; 
   private int HININumber = 564532; 
   private String Name = "Hello, my name is...";
   private String Address = "2nd on right";
   private int Age = 21;
   
   public DummyPerson(){
      
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
      return Name;
   }
   public String getAddress(){
      return Address;
   }
   public int getAge(){
      return Age;
   }
   
   
   
   

}
