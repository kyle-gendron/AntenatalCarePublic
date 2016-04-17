package edu.usm.cos420.antenatal.dao.interfaces;

import edu.usm.cos420.antenatal.domain.PregnancyRecord;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by aaron on 4/16/2016.
 */
public interface IAntenatalVisit {
  /**
   * Add a PregnancyRecord to the DAO repository
   * @param record any PregnancyRecord object
   */
  int add(PregnancyRecord record) throws Exception;

  /**
   * Update a PregnancyRecord in the DAO repository
   * @param record any PregnancyRecord object
   */
  int update(PregnancyRecord record) throws Exception;

  /**
   * Remove a PregnancyRecord in the DAO repository
   * @param id of the PregnancyRecord object to remove
   */
  int remove(String id) throws Exception;

  /**
   * Find a PregnancyRecord in the DAO repository
   * @param key of the PregnancyRecord object to locate
   * @return the PregnancyRecord with id field equal to key
   */
  PregnancyRecord find(String key) throws Exception;

  /**
   * Generate a list of AntenatalVisits in the DAO repository
   * @return List of AntenatalVisits
   */

  List list() throws Exception;
}


