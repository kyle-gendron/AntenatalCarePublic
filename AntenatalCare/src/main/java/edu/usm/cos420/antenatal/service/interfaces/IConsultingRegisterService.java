package edu.usm.cos420.antenatal.service.interfaces;


import edu.usm.cos420.antenatal.domain.DummyPerson;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

/**
 * Created by Kyle on 7/14/2016.
 */
public interface IConsultingRegisterService {

    void addSubVisit(DummyPerson visit) throws SQLException;

    void updateSubVisit(DummyPerson visit) throws SQLException;

    DummyPerson getSubVisitById(String id) throws SQLException;

    List<DummyPerson> getAllSubVisits() throws SQLException;

    List<DummyPerson> getSubVisitsByPregnancy(String key) throws SQLException;

    static String getNextID() {
      return UUID.randomUUID().toString();
    }

}
