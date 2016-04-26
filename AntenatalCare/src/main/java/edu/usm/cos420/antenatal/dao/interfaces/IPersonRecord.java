package edu.usm.cos420.antenatal.dao.interfaces;

import edu.usm.cos420.antenatal.domain.interfaces.IPerson;

import java.util.List;

/**
 * Created by aaron on 4/16/2016.
 */
public interface IPersonRecord {

  /**
   * Add a DummyPerson to the DAO repository
   *
   * @param entity any DummyPerson object
   */
  void add(IPerson entity);

  /**
   * Update a DummyPerson in the DAO repository
   *
   * @param entity any DummyPerson object
   */
  void update(IPerson entity);

  /**
   * Remove a DummyPerson in the DAO repository
   *
   * @param id of the DummyPerson object to remove
   */

  void remove(Long id);

  /**
   * Find a DummyPerson in the DAO repository
   *
   * @param key of the DummyPerson object to locate
   * @return the DummyPerson with id field equal to key
   */
  IPerson find(Long key);

  /**
   * Generate a list of DummyPersons in the DAO repository
   *
   * @return List of DummyPersons
   */

  List<IPerson> list();
}
