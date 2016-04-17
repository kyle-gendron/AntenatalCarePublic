package edu.usm.cos420.antenatal.service.impl;

import edu.usm.cos420.antenatal.dao.serializedObject.AntenatalVisitDao;
import edu.usm.cos420.antenatal.connection.impl.PostgresConnection;
import edu.usm.cos420.antenatal.dao.postgres.PregnancyRecordDao;
import edu.usm.cos420.antenatal.domain.PregnancyRecord;
import edu.usm.cos420.antenatal.service.AntenatalService;

import java.sql.Connection;
import java.util.List;

/**
 * The Example1 Service Layer Implementation is based a design pattern
 * which aims to organize the functionality of the application into logical units
 * that are typically layered on top of much of the low level functionality of the
 * application. This organization helps support service oriented architectures.
 */
public class AntenatalService1 implements AntenatalService {

  AntenatalVisitDao dao;
  PregnancyRecordDao daoPost;
  Connection connection;

  /**
   * Default Constructor creates a default CItemDao object
   */
  public AntenatalService1() {
    this.dao = new AntenatalVisitDao();
    connection= PostgresConnection.getConnection();
    this.daoPost = new PregnancyRecordDao(connection);
  }

  /**
   * Constructor with the DAO provided
   *
   * @param dao Data Access Object to use in the service
   */
  public AntenatalService1(AntenatalVisitDao dao) {
    this.dao = dao;
  }

  @Override
  public void addAntenatalVisit(PregnancyRecord visit) {
    if(dao.add(visit)==1){
    	System.out.println("Inserted: "+visit.getID()+" Into Serializable Database");
    }
  }

  @Override
  public PregnancyRecord getAntenatalVisitById(String id) {
    return dao.find(id);
  }

  @Override
  public List<PregnancyRecord> getAllVisits() {
    return dao.list();
  }

  public void updateAntenatalVisit(PregnancyRecord visit) {
    dao.update(visit);
  }
}
