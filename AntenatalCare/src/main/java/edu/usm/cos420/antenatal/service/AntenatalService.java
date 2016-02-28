package edu.usm.cos420.antenatal.service;

import edu.usm.cos420.antenatal.domain.AntenatalVisit;

import java.util.List;
import java.util.UUID;

public interface AntenatalService {
  void addAntenatalVisit(AntenatalVisit visit);
  AntenatalVisit getAntenatalVisitById(String id);
  List<AntenatalVisit> getAllVisits();

  static String getNextID() {
      return UUID.randomUUID().toString();
  }
}
