package edu.usm.cos420.antenatal.service.impl;

import edu.usm.cos420.antenatal.dao.postgres.PregnancySubVisitDao;
import edu.usm.cos420.antenatal.domain.PregnancySubVisit;
import edu.usm.cos420.antenatal.service.SubVisitService;

import java.sql.SQLException;
import java.util.List;

/**
 * The Example1 Service Layer Implementation is based a design pattern
 * which aims to organize the functionality of the application into logical units
 * that are typically layered on top of much of the low level functionality of the
 * application. This organization helps support service oriented architectures.
 */
public class SubVisitService1 implements SubVisitService {

  PregnancySubVisitDao dao;

  /**
   * Default Constructor creates a default CItemDao object
   */
  public SubVisitService1() {
    this.dao = new PregnancySubVisitDao();
  }

  @Override
  public void addSubVisit(PregnancySubVisit visit) throws SQLException {
    dao.add(visit.getID(), visit);
  }

  @Override
  public void updateSubVisit(PregnancySubVisit visit) throws SQLException {
    dao.update(visit.getID(), visit);
  }

  @Override
  public PregnancySubVisit getSubVisitById(String id) throws SQLException {
    return dao.find(id);
  }

  @Override
  public List<PregnancySubVisit> getAllSubVisits() throws SQLException {
    return dao.list();
  }

  public List<PregnancySubVisit> getSubVisitsByPregnancy(String key) {
    try {
      return dao.pregList(key);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;

  }
}
