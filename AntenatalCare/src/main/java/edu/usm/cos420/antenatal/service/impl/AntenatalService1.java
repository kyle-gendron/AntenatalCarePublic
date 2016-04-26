package edu.usm.cos420.antenatal.service.impl;

import edu.usm.cos420.antenatal.dao.postgres.PregnancyRecordDao;
import edu.usm.cos420.antenatal.daoFactory.DaoFactory;
import edu.usm.cos420.antenatal.daoFactory.PostgresDao;
import edu.usm.cos420.antenatal.domain.PregnancyVisit;
import edu.usm.cos420.antenatal.service.AntenatalService;

import java.util.List;

/**
 * The Example1 Service Layer Implementation is based a design pattern
 * which aims to organize the functionality of the application into logical units
 * that are typically layered on top of much of the low level functionality of the
 * application. This organization helps support service oriented architectures.
 */
public class AntenatalService1 implements AntenatalService {

  PregnancyRecordDao dao;

  /**
   * Default Constructor creates a default CItemDao object
   */
  public AntenatalService1() {
    PostgresDao p = null;
    try {
      p = DaoFactory.getDatabase();
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    if (p != null) {
      this.dao = new PregnancyRecordDao();
    } else {
      System.out.println("Could not Initialize DAO");
    }
  }

  @Override
  public void addAntenatalVisit(PregnancyVisit visit) {
    if (dao.add(visit.getId(), visit) == 1) {
      System.out.println("Inserted: " + visit.getId() + " Into Database");
    }
  }

  @Override
  public PregnancyVisit getAntenatalVisitById(String id) {
    return dao.find(id);
  }

  @Override
  public List<PregnancyVisit> getAllVisits() {
    return dao.list();
  }

  public void updateAntenatalVisit(PregnancyVisit visit) {
    dao.update(visit.getId(), visit);
  }
}
