package edu.usm.cos420.antenatal.dao.domain;

import java.util.List;

import edu.usm.cos420.antenatal.dao.GenericDao;
import edu.usm.cos420.antenatal.dao.ObjectStreamDao;
import edu.usm.cos420.antenatal.domain.PregnancyRecord;

/**
 *
 *  A Data Access Object specifically for PregnancyRecord entities
 *
 */
public class AntenatalVisitDao
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
		genDao = new ObjectStreamDao<>(fileName);;
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
	public void add(PregnancyRecord entity)
	{
		genDao.add(entity.getID(), entity);
	}

	/**
	 * Update a PregnancyRecord in the DAO repository
	 * @param entity any PregnancyRecord object
	 */
	public void update(PregnancyRecord entity)
	{
		genDao.update(entity.getID(), entity);
	}

	/**
	 * Remove a PregnancyRecord in the DAO repository
	 * @param id of the PregnancyRecord object to remove
	 */

	public void remove(String id)
	{
		genDao.remove(id);
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

