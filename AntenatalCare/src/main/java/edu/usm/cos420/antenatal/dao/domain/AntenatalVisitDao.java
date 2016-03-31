package edu.usm.cos420.antenatal.dao.domain;

import java.util.List;

import edu.usm.cos420.antenatal.dao.GenericDao;
import edu.usm.cos420.antenatal.dao.ObjectStreamDao;
import edu.usm.cos420.antenatal.domain.AntenatalVisit;

/**
 *
 *  A Data Access Object specifically for AntenatalVisit entities
 *
 */
public class AntenatalVisitDao
{
	private GenericDao<String,AntenatalVisit> genDao;

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
	 * @param dao a Data Access Object class that implements GenericDao<Long,AntenatalVisit>
	 */
	public AntenatalVisitDao(GenericDao<String,AntenatalVisit> dao)
	{
		genDao = dao;
	}

	/**
	 * Returns the DAO used in the class
	 * @return a DAO that implements GenericDao<Long,AntenatalVisit>
	 */
	public GenericDao<String,AntenatalVisit> getGenDao() {
		return genDao;
	}

	/**
	 * Add a AntenatalVisit to the DAO repository
	 * @param entity any AntenatalVisit object
	 */
	public void add(AntenatalVisit entity)
	{
		genDao.add(entity.getID(), entity);
	}

	/**
	 * Update a AntenatalVisit in the DAO repository
	 * @param entity any AntenatalVisit object
	 */
	public void update(AntenatalVisit entity)
	{
		genDao.update(entity.getID(), entity);
	}

	/**
	 * Remove a AntenatalVisit in the DAO repository
	 * @param id of the AntenatalVisit object to remove
	 */

	public void remove(String id)
	{
		genDao.remove(id);
	}

	/**
	 * Find a AntenatalVisit in the DAO repository
	 * @param key of the AntenatalVisit object to locate
	 * @return the AntenatalVisit with id field equal to key
	 */
	public AntenatalVisit find(String key)
	{
		return genDao.find(key);
	}

	/**
	 * Generate a list of AntenatalVisits in the DAO repository
	 * @return List of AntenatalVisits
	 */

	public List<AntenatalVisit> list() {
		return genDao.list();
	}

}

