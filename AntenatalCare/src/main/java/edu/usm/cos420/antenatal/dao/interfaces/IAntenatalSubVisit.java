package edu.usm.cos420.antenatal.dao.interfaces;

import edu.usm.cos420.antenatal.domain.PregnancySubVisit;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by aaron on 4/16/2016.
 */
public interface IAntenatalSubVisit {

  /**
   * Add a AntenatalSubVisit to the DAO repository
   * @param record any AntenatalSubVisit object
 * @throws SQLException 
   */
  int add(PregnancySubVisit record) throws SQLException;

  /**
   * Update a AntenatalSubVisit in the DAO repository
   * @param entity any AntenatalSubVisit object
   */
  int update(PregnancySubVisit record) throws SQLException;

  /**
   * Remove a AntenatalSubVisit in the DAO repository
   * @param id of the AntenatalSubVisit object to remove
   */

  int remove(String id) throws SQLException;

  /**
   * Find a AntenatalSubVisit in the DAO repository
   * @param key of the AntenatalSubVisit object to locate
   * @return the AntenatalSubVisit with id field equal to key
   */
  PregnancySubVisit find(String key)throws SQLException;

  /**
   * Generate a list of AntenatalSubVisits in the DAO repository
   * @return List of AntenatalSubVisits
   */

  List<PregnancySubVisit> list()throws SQLException;
}
