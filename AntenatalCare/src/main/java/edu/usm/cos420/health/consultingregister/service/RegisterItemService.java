package edu.usm.cos420.health.consultingregister.service;

import edu.usm.cos420.health.consultingregister.data.RegisterDao;
import edu.usm.cos420.health.consultingregister.domain.RegisterItem;
import edu.usm.cos420.health.domain.Person;

import java.util.ArrayList;

/** 
 * Service class providing access to the Register DAO
 *
 * This class has methods for finding Visits in the DAO, and adding Visits to
 * the DAO.
 *
 * @author Thomas Schofield, Samuel Barton
 */
public class RegisterItemService
{
    private RegisterDao dao;

    /** 
     * Default Constructor : 
     *
     */
    public RegisterItemService()
    {
        dao = new RegisterDao();
    }

    /** 
     * Single-argument Constructor : 
     * 
     * @param d the DAO object 
     */
    public RegisterItemService(RegisterDao d)
    {
        dao = d;
    }

    /** 
     * Find the visits in the RegisterDatabase with matching info.
     *
     * @param info the info to search for
     * @param per the patient
     * @return The list of visits with the same patient as the parameter
     */
    public ArrayList<RegisterItem> findVisits(RegisterItem.Info info, Person per)
    {
        return dao.findRegistries(info, per);
    }
    
    public void generateReport(String fromDate, String toDate)
    {
       dao.generateReport(fromDate, toDate);
    }

    /** 
     * Add a visit to the RegisterDatabase
     * @param r the visit to add
     */
    public void addVisit(RegisterItem r)
    {
        dao.addRegistry(r);
    }
}