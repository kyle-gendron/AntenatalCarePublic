package edu.usm.cos420.antenatal.service.impl;

import edu.usm.cos420.antenatal.dao.interfaces.IAntenatalSubVisit;
import edu.usm.cos420.antenatal.dao.postgres.PregnancySubVisitDao;
import edu.usm.cos420.antenatal.dao.serializedObject.AntenatalSubVisitDao;
import edu.usm.cos420.antenatal.daoFactory.DaoFactory;
import edu.usm.cos420.antenatal.daoFactory.PostgresDao;
import edu.usm.cos420.antenatal.domain.PregnancySubVisit;
import edu.usm.cos420.antenatal.service.SubVisitService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * The Example1 Service Layer Implementation is based a design pattern
 * which aims to organize the functionality of the application into logical units
 * that are typically layered on top of much of the low level functionality of the
 * application. This organization helps support service oriented architectures.
 */
public class SubVisitService1 implements SubVisitService {

 IAntenatalSubVisit dao;

  /**
   * Default Constructor creates a default CItemDao object
   */
  public SubVisitService1() {
	  PostgresDao p = DaoFactory.getDatabase();
	  Connection c = p.getConnection();
    this.dao = new PregnancySubVisitDao(c);
  }

  /**
   * Constructor with the DAO provided
   *
   * @param dao Data Access Object to use in the service
   */
  public SubVisitService1(AntenatalSubVisitDao dao) {
    this.dao = dao;
  }

  @Override
  public void addSubVisit(PregnancySubVisit visit) throws SQLException {
    dao.add(visit);
  }

  @Override
  public void updateSubVisit(PregnancySubVisit visit) throws SQLException{
     dao.update(visit);
  }

  @Override
  public PregnancySubVisit getSubVisitById(String id) throws SQLException {
    return dao.find(id);
  }

  @Override
  public List<PregnancySubVisit> getAllSubVisits() throws SQLException {
    return dao.list();
  }
}
