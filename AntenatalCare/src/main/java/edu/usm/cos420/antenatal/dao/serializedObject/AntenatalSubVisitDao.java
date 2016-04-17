package edu.usm.cos420.antenatal.dao.serializedObject;

import java.util.List;

import edu.usm.cos420.antenatal.dao.GenericDao;
import edu.usm.cos420.antenatal.dao.ObjectStreamDao;
import edu.usm.cos420.antenatal.dao.interfaces.IAntenatalSubVisit;
import edu.usm.cos420.antenatal.domain.PregnancySubVisit;

/**
 *
 *  A Data Access Object specifically for AntenatalSubVisit entities
 *
 */
public class AntenatalSubVisitDao implements IAntenatalSubVisit
{
   private GenericDao<String,PregnancySubVisit> genDao;

   /**
    * Default constructor creates an ObjectStream file called subvisits.ser
    */
   public AntenatalSubVisitDao()
   {
      genDao = new ObjectStreamDao<>("subvisits.ser");
   }

   /**
    * Constructor where the filename is provided
    */
   public AntenatalSubVisitDao(String fileName)
   {
      genDao = new ObjectStreamDao<>(fileName);;
   }

   /**
    * Support for other DAOs is provided
    * @param dao a Data Access Object class that implements GenericDao<Long,AntenatalSubVisit>
    */
   public AntenatalSubVisitDao(GenericDao<String,PregnancySubVisit> dao)
   {
      genDao = dao;
   }

   /**
    * Returns the DAO used in the class
    * @return a DAO that implements GenericDao<Long,AntenatalSubVisit>
    */
   public GenericDao<String,PregnancySubVisit> getGenDao() {
      return genDao;
   }

   /**
    * Add a AntenatalSubVisit to the DAO repository
    * @param entity any AntenatalSubVisit object
    */
   public int add(PregnancySubVisit entity)
   {
      genDao.add(entity.getID(), entity);
	return 1;
   }

   /**
    * Update a AntenatalSubVisit in the DAO repository
    * @param entity any AntenatalSubVisit object
    */
   public int update(PregnancySubVisit entity)
   {
      genDao.update(entity.getID(), entity);
	return 1;
   }

   /**
    * Remove a AntenatalSubVisit in the DAO repository
    * @param id of the AntenatalSubVisit object to remove
    */

   public int remove(String id)
   {
      genDao.remove(id);
	return 1;
   }

   /**
    * Find a AntenatalSubVisit in the DAO repository
    * @param key of the AntenatalSubVisit object to locate
    * @return the AntenatalSubVisit with id field equal to key
    */
   public PregnancySubVisit find(String key)
   {
      return genDao.find(key);
   }

   /**
    * Generate a list of AntenatalSubVisits in the DAO repository
    * @return List of AntenatalSubVisits
    */

   public List<PregnancySubVisit> list() {
      return genDao.list();
   }

}

