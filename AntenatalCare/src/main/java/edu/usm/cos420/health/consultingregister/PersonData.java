package edu.usm.cos420.health.consultingregister;

import edu.usm.cos420.health.domain.Person;

/** 
 * Singleton Data class for Person Information.
 *
 * This class contains the information relavent to the currently selected
 * Person (if they exist), or the Person.Info object which will eventually 
 * become a Person.
 *
 * This class will be used to reduce coupling between the other classes. It 
 * will do this by having all of them reference this class for the current
 * state of the Person they are referencing.
 * 
 * @author Samuel Barton
 */
public class PersonData
{
    private Person person;
    private Person.Info info;

    private static PersonData instance = null;

    protected PersonData() 
    {
        person = new Person();
        info = new Person.Info();
    }

    public static PersonData getInstance()
    {
        if (instance == null)
            instance = new PersonData();

        return instance;
    }

    public Person getPerson()
    {
        return person;
    }

    public void setPerson(Person p)
    {
        person = p;
    }

    public Person.Info getInfo()
    {
        return info;
    }

    public void setInfo(Person.Info i)
    {
        info = i;
    }
}
