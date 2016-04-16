package edu.usm.cos420.antenatal.service.impl;

import edu.usm.cos420.antenatal.dao.serializedObject.AntenatalSubVisitDao;
import edu.usm.cos420.antenatal.domain.AntenatalSubVisit;
import edu.usm.cos420.antenatal.service.SubVisitService;

import java.util.List;

/**
 * The Example1 Service Layer Implementation is based a design pattern
 * which aims to organize the functionality of the application into logical units
 * that are typically layered on top of much of the low level functionality of the
 * application. This organization helps support service oriented architectures.
 */
public class SubVisitService1 implements SubVisitService {

  AntenatalSubVisitDao dao;

  /**
   * Default Constructor creates a default CItemDao object
   */
  public SubVisitService1() {
    this.dao = new AntenatalSubVisitDao();
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
  public void addSubVisit(AntenatalSubVisit visit) {
    dao.add(visit);
  }

  @Override
  public void updateSubVisit(AntenatalSubVisit visit){
     dao.update(visit);
  }

  @Override
  public AntenatalSubVisit getSubVisitById(String id) {
    return dao.find(id);
  }

  @Override
  public List<AntenatalSubVisit> getAllSubVisits() {
    return dao.list();
  }
}
