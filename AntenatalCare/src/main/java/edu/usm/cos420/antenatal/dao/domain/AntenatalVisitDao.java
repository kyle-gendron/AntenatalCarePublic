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
	private GenericDao<Long,AntenatalVisit> genDao;

	/**
	 * Default constructor creates an ObjectStream file called citem.ser
	 */
	public AntenatalVisitDao()
	{
		genDao = new ObjectStreamDao<Long,AntenatalVisit>("antenatalvisits.ser");;
	}

	/**
	 * Constructor where the filename is provided 
	 */
	public AntenatalVisitDao(String fileName)
	{
		genDao = new ObjectStreamDao<Long,AntenatalVisit>(fileName);;
	}

	/**
	 * Support for other DAOs is provided
	 * @param dao a Data Access Object class that implements GenericDao<Long,CItem> 
	 */
	public AntenatalVisitDao(GenericDao<Long,AntenatalVisit> dao)
	{
		genDao = dao;
	}
	
	/**
	 * Returns the DAO used in the class
	 * @return a DAO that implements GenericDao<Long,CItem> 
	 */
	public GenericDao<Long,AntenatalVisit> getGenDao() {
		return genDao;
	}

	/**
	 * Add a CItem to the DAO repository
	 * @param entity any CItem object
	 */
	public void add(AntenatalVisit entity)
	{
		genDao.add(entity.getId(), entity);
	}
	
	/**
	 * Update a CItem in the DAO repository
	 * @param entity any CItem object
	 */
	public void update(AntenatalVisit entity) 
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
	public AntenatalVisit find(Long key)
	{
		return genDao.find(key);
	}
    
	/**
	 * Generate a list of CItems in the DAO repository
	 * @return List of CItems 
	 */

	public List<AntenatalVisit> list() {
		return genDao.list();
	}

}

