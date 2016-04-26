package edu.usm.cos420.antenatal.dao.interfaces;

import edu.usm.cos420.antenatal.dao.GenericDao;
import edu.usm.cos420.antenatal.domain.PregnancySubVisit;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by aaron on 4/16/2016.
 */
public interface IAntenatalSubVisit extends GenericDao<String, PregnancySubVisit> {

  /**
   * Add a AntenatalSubVisit to the DAO repository
   *
   * @param record any AntenatalSubVisit object
   */
  @Override
  int add(String id, PregnancySubVisit record);

  /**
   * Update a AntenatalSubVisit in the DAO repository
   *
   * @param record any AntenatalSubVisit object
   */
  @Override
  int update(String id, PregnancySubVisit record);

  /**
   * Remove a AntenatalSubVisit in the DAO repository
   *
   * @param id of the AntenatalSubVisit object to remove
   */
  @Override
  int remove(String id);

  /**
   * Find a AntenatalSubVisit in the DAO repository
   *
   * @param key of the AntenatalSubVisit object to locate
   * @return the AntenatalSubVisit with id field equal to key
   */
  @Override
  PregnancySubVisit find(String key);

  /**
   * Generate a list of AntenatalSubVisits in the DAO repository
   *
   * @return List of AntenatalSubVisits
   */
  @Override
  List<PregnancySubVisit> list();

  List<PregnancySubVisit> pregList(String key) throws SQLException;
}
