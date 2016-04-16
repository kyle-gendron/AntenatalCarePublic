package edu.usm.cos420.antenatal.dao.interfaces;

import edu.usm.cos420.antenatal.domain.AntenatalSubVisit;

import java.util.List;

/**
 * Created by aaron on 4/16/2016.
 */
public interface IAntenatalSubVisit {

  /**
   * Add a AntenatalSubVisit to the DAO repository
   * @param entity any AntenatalSubVisit object
   */
  void add(AntenatalSubVisit entity);

  /**
   * Update a AntenatalSubVisit in the DAO repository
   * @param entity any AntenatalSubVisit object
   */
  void update(AntenatalSubVisit entity);

  /**
   * Remove a AntenatalSubVisit in the DAO repository
   * @param id of the AntenatalSubVisit object to remove
   */

  void remove(String id);

  /**
   * Find a AntenatalSubVisit in the DAO repository
   * @param key of the AntenatalSubVisit object to locate
   * @return the AntenatalSubVisit with id field equal to key
   */
  AntenatalSubVisit find(String key);

  /**
   * Generate a list of AntenatalSubVisits in the DAO repository
   * @return List of AntenatalSubVisits
   */

  List<AntenatalSubVisit> list();
}
