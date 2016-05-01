package edu.usm.cos420.antenatal.domain.interfaces;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface IPerson extends Serializable {

  String getFacZone();

  String getSubDistrict();

  String getDistrict();

  String getYear();

  int getSerialNumber();

  LocalDate getDate();

  int getRegNumber();

  int getHININumber();

  String getName();

  String getAddress();

  int getAge();

  List<Long> getVisitIDs();

  String getId();

}
