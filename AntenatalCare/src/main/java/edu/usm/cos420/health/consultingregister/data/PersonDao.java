package edu.usm.cos420.health.consultingregister.data;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import edu.usm.cos420.health.domain.*;

public class PersonDao 
{
    private ObjectStreamDao<String, Person> dataBase = 
                      new ObjectStreamDao<String, Person>("PeopleDatabase.ser");

    public ArrayList<Person> findPeople(Person.Info info)
    {
        ArrayList<Person> result = new ArrayList<Person>();

        for (Person p : dataBase.map().values())
        {
            if (p.getInfo().contains(info))
                result.add(p);
        }

        return result;
    }

    public void addPerson(Person p)
    {
    	Person s = dataBase.find(p.getID());
    	if(s == null) // Nobody with that ID in Database, we'll add them
    	{
    		dataBase.add(p.getID(), p);
    	}
    }
    
    public Person findPerson(String id)
    {
    	Person test = dataBase.find(id);
    	if(test == null)
    	{
    		System.out.println("Nobody found with Provided ID");
    		return null;
    	}
    	else
    		return test;	
    }

    /** 
     * Update the info of a Person in the database.
     *
     * This method will ignore a Person who doesn't exist within the database.
     *
     * @param p the Person whose info is being updated
     */
    public void updatePerson(Person p)
    {
        try
        {
            dataBase.update(p.getID(), p);
        }
        catch (Exception ignore) {}
    }

    /** 
     * Get all the Persons in the PeopleDatabase
     * @return people in the database
     */
    public ArrayList<Person> getPeople()
    {
        ArrayList<Person> result = new ArrayList<Person>();

        for (Person p : dataBase.map().values())
            result.add(p);

        return result;
    }
}
