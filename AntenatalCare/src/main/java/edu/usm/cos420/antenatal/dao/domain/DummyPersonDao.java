package edu.usm.cos420.antenatal.dao.domain;
import java.util.List;

import edu.usm.cos420.antenatal.dao.GenericDao;
import edu.usm.cos420.antenatal.dao.ObjectStreamDao;
import edu.usm.cos420.antenatal.domain.DummyPerson;

/**
 * 
 *  A Data Access Object specifically for DummyPerson entities 
 *     
 */
public class DummyPersonDao {

      private GenericDao<Long, DummyPerson> genDao;

      /**
       * Default constructor creates an ObjectStream file called person.ser
       */
      public DummyPersonDao()
      {
         genDao = new ObjectStreamDao<Long, DummyPerson>("person.ser");
      }

      /**
       * Constructor where the filename is provided 
       */
      public DummyPersonDao(String fileName)
      {
         genDao = new ObjectStreamDao<Long, DummyPerson>(fileName);
      }

      /**
       * Support for other DAOs is provided
       * @param dao a Data Access Object class that implements GenericDao<Long,DummyPerson> 
       */
      public DummyPersonDao(GenericDao<Long, DummyPerson> dao)
      {
         genDao = dao;
      }
      
      /**
       * Returns the DAO used in the class
       * @return a DAO that implements GenericDao<Long,DummyPerson> 
       */
      public GenericDao<Long, DummyPerson> getGenDao() {
         return genDao;
      }

      /**
       * Add a DummyPerson to the DAO repository
       * @param entity any DummyPerson object
       */
      public void add(DummyPerson entity)
      {
         genDao.add(Long.valueOf(entity.getId()), entity);
      }
      
      /**
       * Update a DummyPerson in the DAO repository
       * @param entity any DummyPerson object
       */
      public void update(DummyPerson entity)
      {
         genDao.update(Long.valueOf(entity.getId()), entity);
      }
      
      /**
       * Remove a DummyPerson in the DAO repository
       * @param id of the DummyPerson object to remove
       */

      public void remove(Long id)
      {
         genDao.remove(id);
      }
      
      /**
       * Find a DummyPerson in the DAO repository
       * @param key of the DummyPerson object to locate
       * @return the DummyPerson with id field equal to key
       */
      public DummyPerson find(Long key)
      {
         return genDao.find(key);
      }
       
      /**
       * Generate a list of DummyPersons in the DAO repository
       * @return List of DummyPersons 
       */

      public List<DummyPerson> list() {
         return genDao.list();
      }

   }



