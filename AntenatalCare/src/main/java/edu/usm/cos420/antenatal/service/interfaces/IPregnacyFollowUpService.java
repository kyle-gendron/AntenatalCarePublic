package edu.usm.cos420.antenatal.service.interfaces;

import edu.usm.cos420.antenatal.domain.PregnancyFollowUp;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public interface IPregnacyFollowUpService {

  void addSubVisit(PregnancyFollowUp visit) throws SQLException;

  void updateSubVisit(PregnancyFollowUp visit) throws SQLException;

  PregnancyFollowUp getSubVisitById(String id) throws SQLException;

  List<PregnancyFollowUp> getAllSubVisits() throws SQLException;

  List<PregnancyFollowUp> getSubVisitsByPregnancy(String key) throws SQLException;

  static String getNextID() {
    return UUID.randomUUID().toString();
  }
}
