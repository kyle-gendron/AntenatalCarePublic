package edu.usm.cos420.antenatal.dao.domain;
import java.util.List;

import edu.usm.cos420.antenatal.dao.GenericDao;
import edu.usm.cos420.antenatal.dao.ObjectStreamDao;
import edu.usm.cos420.antenatal.domain.DummyPerson;
import edu.usm.cos420.antenatal.domain.Person;

/**
 * 
 *  A Data Access Object specifically for DummyPerson entities 
 *     
 */
public class PersonDao {

      private GenericDao<Long, Person> genDao;

      /**
       * Default constructor creates an ObjectStream file called person.ser
       */
      public PersonDao()
      {
         genDao = new ObjectStreamDao<Long, Person>("person.ser");
      }

      /**
       * Constructor where the filename is provided 
       */
      public PersonDao(String fileName)
      {
         genDao = new ObjectStreamDao<Long, Person>(fileName);
      }

      /**
       * Support for other DAOs is provided
       * @param dao a Data Access Object class that implements GenericDao<Long,DummyPerson> 
       */
      public PersonDao(GenericDao<Long, Person> dao)
      {
         genDao = dao;
      }
      
      /**
       * Returns the DAO used in the class
       * @return a DAO that implements GenericDao<Long,DummyPerson> 
       */
      public GenericDao<Long, Person> getGenDao() {
         return genDao;
      }

      /**
       * Add a DummyPerson to the DAO repository
       * @param entity any DummyPerson object
       */
      public void add(Person entity)
      {
         genDao.add(Long.valueOf(entity.getId()), entity);
      }
      
      /**
       * Update a DummyPerson in the DAO repository
       * @param entity any DummyPerson object
       */
      public void update(Person entity)
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
      public Person find(Long key)
      {
         return genDao.find(key);
      }
       
      /**
       * Generate a list of DummyPersons in the DAO repository
       * @return List of DummyPersons 
       */

      public List<Person> list() {
         return genDao.list();
      }

   }



