package edu.usm.cos420.antenatal.service.interfaces;

import edu.usm.cos420.antenatal.domain.PregnancyVisit;

import java.util.List;
import java.util.UUID;

public interface IPregnacyVisitService {
  void addAntenatalVisit(PregnancyVisit visit);

  PregnancyVisit getAntenatalVisitById(String id);

  List<PregnancyVisit> getAllVisits();

  static String getNextID() {
    return UUID.randomUUID().toString();
  }
}
