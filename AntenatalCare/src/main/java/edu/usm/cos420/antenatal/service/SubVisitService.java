package edu.usm.cos420.antenatal.service;

import edu.usm.cos420.antenatal.domain.PregnancySubVisit;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface SubVisitService {

  void addSubVisit(PregnancySubVisit visit) throws SQLException;

  void updateSubVisit(PregnancySubVisit visit) throws SQLException;

  PregnancySubVisit getSubVisitById(String id) throws SQLException;

  List<PregnancySubVisit> getAllSubVisits() throws SQLException;

  List<PregnancySubVisit> getSubVisitsByPregnancy(String key) throws SQLException;

  static String getNextID() {
    return UUID.randomUUID().toString();
  }
}
