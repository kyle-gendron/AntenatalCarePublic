package edu.usm.cos420.antenatal.dao.domain;

import java.util.List;

import edu.usm.cos420.antenatal.dao.GenericDao;
import edu.usm.cos420.antenatal.dao.ObjectStreamDao;
import edu.usm.cos420.antenatal.domain.CItem;

/**
 * 
 *  A Data Access Object specifically for CItem entities 
 *     
 */
public class CItemDao
{
	private GenericDao<Long,CItem> cItemDao;

	/**
	 * Default constructor creates an ObjectStream file called citem.ser
	 */
	public CItemDao()
	{
		cItemDao = new ObjectStreamDao<Long,CItem>("citem.ser");;
	}

	/**
	 * Constructor where the filename is provided 
	 */
	public CItemDao(String fileName)
	{
		cItemDao = new ObjectStreamDao<Long,CItem>(fileName);;
	}

	/**
	 * Support for other DAOs is provided
	 * @param dao a Data Access Object class that implements GenericDao<Long,CItem> 
	 */
	public CItemDao(GenericDao<Long,CItem> dao)
	{
		cItemDao = dao;
	}
	
	/**
	 * Returns the DAO used in the class
	 * @return a DAO that implements GenericDao<Long,CItem> 
	 */
	public GenericDao<Long,CItem> getCItemDao() {
		return cItemDao;
	}

	/**
	 * Add a CItem to the DAO repository
	 * @param entity any CItem object
	 */
	public void add(CItem entity)
	{
		cItemDao.add(entity.getId(), entity);
	}
	
	/**
	 * Update a CItem in the DAO repository
	 * @param entity any CItem object
	 */
	public void update(CItem entity) 
	{
		cItemDao.update(entity.getId(), entity);
	}
	
	/**
	 * Remove a CItem in the DAO repository
	 * @param id of the CItem object to remove
	 */

	public void remove(Long id)
	{
		cItemDao.remove(id);
	}
	
	/**
	 * Find a CItem in the DAO repository
	 * @param id of the CItem object to locate
	 * @return the CItem with id field equal to key
	 */
	public CItem find(Long key)
	{
		return cItemDao.find(key);
	}
    
	/**
	 * Generate a list of CItems in the DAO repository
	 * @return List of CItems 
	 */

	public List<CItem> list() {
		return cItemDao.list();
	}

}

