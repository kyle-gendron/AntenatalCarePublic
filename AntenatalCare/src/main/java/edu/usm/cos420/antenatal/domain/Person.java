package edu.usm.cos420.antenatal.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface Person extends Serializable {

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
