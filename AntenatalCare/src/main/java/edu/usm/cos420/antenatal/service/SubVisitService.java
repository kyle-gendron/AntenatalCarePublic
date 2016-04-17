package edu.usm.cos420.antenatal.service;

import java.util.List;
import java.util.UUID;

import edu.usm.cos420.antenatal.domain.PregnancySubVisit;

public interface SubVisitService {
   
   void addSubVisit(PregnancySubVisit visit);
   
   void updateSubVisit(PregnancySubVisit visit);
   
   PregnancySubVisit getSubVisitById(String id);
   
   List<PregnancySubVisit> getAllSubVisits();
   
   static String getNextID() {
      return UUID.randomUUID().toString();
  }

}
