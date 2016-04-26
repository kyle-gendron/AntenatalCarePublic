package edu.usm.cos420.antenatal.dao.interfaces;

import edu.usm.cos420.antenatal.dao.GenericDao;
import edu.usm.cos420.antenatal.domain.PregnancyRecord;

import java.util.List;

/**
 * Created by aaron on 4/16/2016.
 */
public interface IAntenatalRecord<T> extends GenericDao<String, T> {
  /**
   * Add a PregnancyRecord to the DAO repository
   *
   * @param record any PregnancyRecord object
   */
  @Override
  int add(String id, T record);

  /**
   * Update a PregnancyRecord in the DAO repository
   *
   * @param record any PregnancyRecord object
   */
  @Override
  int update(String id, T record);

  /**
   * Remove a PregnancyRecord in the DAO repository
   *
   * @param id of the PregnancyRecord object to remove
   */
  @Override
  int remove(String id);

  /**
   * Find a PregnancyRecord in the DAO repository
   *
   * @param key of the PregnancyRecord object to locate
   * @return the PregnancyRecord with id field equal to key
   */
  @Override
  T find(String key);

  /**
   * Generate a list of AntenatalVisits in the DAO repository
   *
   * @return List of AntenatalVisits
   */
  @Override
  List<T> list();
}


