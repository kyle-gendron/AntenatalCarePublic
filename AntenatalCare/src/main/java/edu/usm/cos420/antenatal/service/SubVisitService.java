package edu.usm.cos420.antenatal.service;

import java.util.List;
import java.util.UUID;

import edu.usm.cos420.antenatal.domain.AntenatalSubVisit;

public interface SubVisitService {
   
   void addSubVisit(AntenatalSubVisit visit);
   
   AntenatalSubVisit getAntenatalSubVisitById(String id);
   
   List<AntenatalSubVisit> getAllSubVisits();
   
   static String getNextID() {
      return UUID.randomUUID().toString();
  }

}
