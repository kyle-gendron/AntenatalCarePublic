package edu.usm.cos420.antenatal.service;

/**
 * 
 *  The Example1 Service Interface is based a design pattern
 *      which aims to organize the functionality of the application into logical units 
 *      that are typically layered on top of much of the low level functionality of the 
 *      application. This organization helps support service oriented architectures. 
 *
 */
public interface AntenatalService {
	
	/**
	 * Add a randomly generated CItem element to the repository
	 */
    public void addACItem();
    /**
     * Calculate the maximum ID value of elements in the repository     
     * @return the maximum id of a CItem in the repository
     */
	public Long maxCItemId();
   public Long maxAntenatalVisitId();
   public void addAAntenatalVisit();
	
}
