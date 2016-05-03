package edu.usm.cos420.antenatal.service;

import edu.usm.cos420.antenatal.dao.concete.PregnancyFollowUpDao;
import edu.usm.cos420.antenatal.domain.PregnancyFollowUp;
import edu.usm.cos420.antenatal.service.interfaces.IPregnacyFollowUpService;

import java.sql.SQLException;
import java.util.List;

/**
 * The Example1 Service Layer Implementation is based a design pattern
 * which aims to organize the functionality of the application into logical units
 * that are typically layered on top of much of the low level functionality of the
 * application. This organization helps support service oriented architectures.
 */
public class PregnancyFollowUpService implements IPregnacyFollowUpService {

  PregnancyFollowUpDao dao;

  /**
   * Default Constructor creates a default CItemDao object
   */
  public PregnancyFollowUpService() {
    this.dao = new PregnancyFollowUpDao();
  }

  @Override
  public void addSubVisit(PregnancyFollowUp visit) throws SQLException {
    dao.add(visit.getId(), visit);
  }

  @Override
  public void updateSubVisit(PregnancyFollowUp visit) throws SQLException {
    dao.update(visit.getId(), visit);
  }

  @Override
  public PregnancyFollowUp getSubVisitById(String id) throws SQLException {
    return dao.find(id);
  }

  @Override
  public List<PregnancyFollowUp> getAllSubVisits() throws SQLException {
    return dao.list();
  }

  public List<PregnancyFollowUp> getSubVisitsByPregnancy(String key) {
    try {
      return dao.pregList(key);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;

  }
}
