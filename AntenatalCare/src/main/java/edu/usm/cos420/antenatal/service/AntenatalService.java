package edu.usm.cos420.antenatal.service;

import edu.usm.cos420.antenatal.domain.PregnancyRecord;

import java.util.List;
import java.util.UUID;

public interface AntenatalService {
  void addAntenatalVisit(PregnancyRecord visit);

  PregnancyRecord getAntenatalVisitById(String id);

  List<PregnancyRecord> getAllVisits();

  static String getNextID() {
    return UUID.randomUUID().toString();
  }
}
