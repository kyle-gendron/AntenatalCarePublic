package edu.usm.cos420.antenatal.service.impl;

import java.util.Iterator;
import java.util.List;

import edu.usm.cos420.antenatal.dao.domain.AntenatalVisitDao;
import edu.usm.cos420.antenatal.domain.AntenatalVisit;
import edu.usm.cos420.antenatal.service.AntenatalService;

/**
 * 
 *  The Example1 Service Layer Implementation is based a design pattern
 *      which aims to organize the functionality of the application into logical units 
 *      that are typically layered on top of much of the low level functionality of the 
 *      application. This organization helps support service oriented architectures. 
 *
 */
public class AntenatalService1 implements AntenatalService {

	AntenatalVisitDao dao;
	
	/**
	 * Default Constructor creates a default CItemDao object 
	 */
    public AntenatalService1()
    {
        this.dao = new AntenatalVisitDao();	
    }

    /**
     * Constructor with the DAO provided 
     * @param dao Data Access Object to use in the service
     */
    public AntenatalService1(AntenatalVisitDao dao)
    {
        this.dao = dao;	
    }

	/**
	 * Add a randomly generated CItem element to the repository
	 */
    public void add(AntenatalVisit entity) 
    {
        dao.add(entity);
    }
    /**
     * Calculate the maximum ID value of elements in the repository     
     * @return the maximum id of a CItem in the repository
     */

	public Long maxCItemId() {
    	 List<AntenatalVisit> list = dao.list();
    	 Long max = 0L;
    	 if (list.isEmpty())
    		 return max;
    	 else 
    	 {
    		 Iterator<AntenatalVisit> iter = list.iterator();
    		 max = iter.next().getID();
    		 while (iter.hasNext())
    		 {
    			 AntenatalVisit anItem = iter.next();
    			 if (anItem.getID() > max)
    			     max = anItem.getID();
    		 }
    		 return max;
    	 }
     }

   @Override
   public Long maxAntenatalVisitId() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public void addAAntenatalVisit() {
      // TODO Auto-generated method stub
      
   }
}
