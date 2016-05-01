package edu.usm.cos420.antenatal.domain.interfaces;

import java.time.LocalDate;

/**
 * Created by aaron on 4/26/2016.
 */
public interface IPregnancyRecord {
  String getId();

  void setId(String id);

  int getSystolicBP();

  void setSystolicBP(int systolicBP);

  int getDiastolicBP();

  void setDiastolicBP(int diastolicBP);

  double getWeight();

  void setWeight(double weight);

  double getFundalHeight();

  void setFundalHeight(double fundalHeight);

  LocalDate getApptDate();

  void setApptDate(LocalDate date);
}
