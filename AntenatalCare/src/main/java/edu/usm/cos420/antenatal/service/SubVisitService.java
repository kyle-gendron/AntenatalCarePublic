package edu.usm.cos420.antenatal.service;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import edu.usm.cos420.antenatal.domain.PregnancySubVisit;

public interface SubVisitService {
   
   void addSubVisit(PregnancySubVisit visit) throws SQLException;
   
   void updateSubVisit(PregnancySubVisit visit) throws SQLException;
   
   PregnancySubVisit getSubVisitById(String id) throws SQLException;
   
   List<PregnancySubVisit> getAllSubVisits() throws SQLException;
   
   static String getNextID() {
      return UUID.randomUUID().toString();
  }

}
