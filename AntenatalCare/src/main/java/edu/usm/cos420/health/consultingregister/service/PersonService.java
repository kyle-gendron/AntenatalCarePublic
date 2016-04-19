package edu.usm.cos420.health.consultingregister.service;

import edu.usm.cos420.health.consultingregister.data.PersonDao;
import edu.usm.cos420.health.domain.Person;

import java.util.ArrayList;

/** 
 * Service class providing access to the Person DAO
 *
 * This class has methods for finding People in the DAO, and adding People to
 * the DAO.
 *
 * @author Samuel Barton
 */
public class PersonService
{
    private PersonDao dao;

    /** 
     * Default Constructor : 
     *
     */
    public PersonService()
    {
        dao = new PersonDao();
    }

    /** 
     * Single-argument Canstructor : 
     * 
     * @param d the DAO object 
     */
    public PersonService(PersonDao d)
    {
        dao = d;
    }

    /** 
     * Find the people in the PeopleDatabase with matching info.
     *
     * @param info the info to search for
     * @return The list of people with the same info as the paramater
     */
    public ArrayList<Person> findPeople(Person.Info info)
    {
        return dao.findPeople(info);
    }

    /** 
     * Add a Person to the PeopleDatabase
     * @param p the Person to add
     */
    public void addPerson(Person p)
    {
        dao.addPerson(p);
    }

    /** 
     * Update this Person's information in the database.
     *
     * @param p the Person whose info is being updated.
     */
    public void updatePerson(Person p)
    {
        dao.updatePerson(p);
    }

    /** 
     * Get all of the people in the database.
     * @return people in the database
     */
    public ArrayList<Person> getPeople()
    {
        return dao.getPeople();
    }
}
