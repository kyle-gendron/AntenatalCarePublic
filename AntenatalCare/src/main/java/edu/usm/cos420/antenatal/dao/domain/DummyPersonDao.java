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
       * Default constructor creates an ObjectStream file called citem.ser
       */
      public DummyPersonDao()
      {
         genDao = new ObjectStreamDao<Long, DummyPerson>("person.ser");;
      }

      /**
       * Constructor where the filename is provided 
       */
      public DummyPersonDao(String fileName)
      {
         genDao = new ObjectStreamDao<Long, DummyPerson>(fileName);;
      }

      /**
       * Support for other DAOs is provided
       * @param dao a Data Access Object class that implements GenericDao<Long,CItem> 
       */
      public DummyPersonDao(GenericDao<Long, DummyPerson> dao)
      {
         genDao = dao;
      }
      
      /**
       * Returns the DAO used in the class
       * @return a DAO that implements GenericDao<Long,CItem> 
       */
      public GenericDao<Long, DummyPerson> getGenDao() {
         return genDao;
      }

      /**
       * Add a CItem to the DAO repository
       * @param entity any CItem object
       */
      public void add(DummyPerson entity)
      {
         genDao.add(entity.getId(), entity);
      }
      
      /**
       * Update a CItem in the DAO repository
       * @param entity any CItem object
       */
      public void update(DummyPerson entity) 
      {
         genDao.update(entity.getId(), entity);
      }
      
      /**
       * Remove a CItem in the DAO repository
       * @param id of the CItem object to remove
       */

      public void remove(Long id)
      {
         genDao.remove(id);
      }
      
      /**
       * Find a CItem in the DAO repository
       * @param id of the CItem object to locate
       * @return the CItem with id field equal to key
       */
      public DummyPerson find(Long key)
      {
         return genDao.find(key);
      }
       
      /**
       * Generate a list of CItems in the DAO repository
       * @return List of CItems 
       */

      public List<DummyPerson> list() {
         return genDao.list();
      }

   }



