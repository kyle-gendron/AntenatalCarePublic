package edu.usm.cos420.antenatal.dao.serializedObject;

import java.util.List;

import edu.usm.cos420.antenatal.dao.GenericDao;
import edu.usm.cos420.antenatal.dao.ObjectStreamDao;
import edu.usm.cos420.antenatal.dao.interfaces.IAntenatalVisit;
import edu.usm.cos420.antenatal.domain.PregnancyRecord;

/**
 *
 *  A Data Access Object specifically for PregnancyRecord entities
 *
 */
public class AntenatalVisitDao implements IAntenatalVisit
{
	private GenericDao<String,PregnancyRecord> genDao;

	/**
	 * Default constructor creates an ObjectStream file called antenatalvisits.ser
	 */
	public AntenatalVisitDao()
	{
		genDao = new ObjectStreamDao<>("antenatalvisits.ser");
	}

	/**
	 * Constructor where the filename is provided
	 */
	public AntenatalVisitDao(String fileName)
	{
		genDao = new ObjectStreamDao<>(fileName);
	}

	/**
	 * Support for other DAOs is provided
	 * @param dao a Data Access Object class that implements GenericDao<Long,PregnancyRecord>
	 */
	public AntenatalVisitDao(GenericDao<String,PregnancyRecord> dao)
	{
		genDao = dao;
	}

	/**
	 * Returns the DAO used in the class
	 * @return a DAO that implements GenericDao<Long,PregnancyRecord>
	 */
	public GenericDao<String,PregnancyRecord> getGenDao() {
		return genDao;
	}

	/**
	 * Add a PregnancyRecord to the DAO repository
   * @param entity any PregnancyRecord object
   */
	public int add(PregnancyRecord entity)
	{
		genDao.add(entity.getID(), entity);
    return 1;
	}

	/**
	 * Update a PregnancyRecord in the DAO repository
   * @param entity any PregnancyRecord object
   */
	public int update(PregnancyRecord entity)
	{
		genDao.update(entity.getID(), entity);
    return 1;
	}

	/**
	 * Remove a PregnancyRecord in the DAO repository
   * @param id of the PregnancyRecord object to remove
   */

	public int remove(String id)
	{
		genDao.remove(id);
    return 1;
  }

	/**
	 * Find a PregnancyRecord in the DAO repository
	 * @param key of the PregnancyRecord object to locate
	 * @return the PregnancyRecord with id field equal to key
	 */
	public PregnancyRecord find(String key)
	{
		return genDao.find(key);
	}

	/**
	 * Generate a list of AntenatalVisits in the DAO repository
	 * @return List of AntenatalVisits
	 */

	public List<PregnancyRecord> list() {
		return genDao.list();
	}

}

