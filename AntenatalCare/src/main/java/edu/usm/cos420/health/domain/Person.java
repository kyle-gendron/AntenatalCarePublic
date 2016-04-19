package edu.usm.cos420.health.domain;

import java.util.UUID;
import java.util.TreeMap;
import java.util.Map;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;

/**
 *
 * Storage class encasulating the notion of a Person. This class contains the
 * information for uniquely identifying a Person. It will be used accross all
 * class projects.
 *
 */
public class Person implements Serializable
{
	private static final long serialVersionUID = 1L;
	private String person_id;
    private Info info;

    /**
     *
     * The identifying information for a Person. This class exists so that we
     * can have a compact way of representing the informaiton associated with
     * a person without having to create a person themselves. We use a map 
     * object because we do not know what information someone will enter about
     * a Person. 
     *
     * TODO: Date formatting needs to be handled, probably use Date class from
     *       assignment one.
     */
    public static class Info implements Serializable
    {
		private static final long serialVersionUID = 1L;

        /** {@value #FIRST_NAME} : first name */
		public static final int FIRST_NAME = 0;
        /** {@value #LAST_NAME} : last name */
        public static final int LAST_NAME = 1;
        /** {@value #VILLAGE} : village */
	    public static final int VILLAGE = 2;
        /** {@value #TRIBE} : tribe */ 
        public static final int TRIBE = 3;
        /** {@value #HOUSE_NUMBER} : house number */ 
	    public static final int HOUSE_NUMBER = 4;
        /** {@value #DATE_OF_BIRTH} : date-of-birth */ 
	    public static final int DATE_OF_BIRTH = 5;
        /** {@value #INSURANCE_NUMBER} : insurance number */ 
        public static final int INSURANCE_NUMBER = 6;
        /** {@value #NATIONAL_ID} : national ID */ 
        public static final int NATIONAL_ID = 7;
        /** {@value #GENDER} : gender */ 
	    public static final int GENDER = 8;

        private TreeMap<Integer, String> keyed_info;

        /** 
         * Default Constructor :
         *
         * Create an Info object with all of the fields unset.
         */
        public Info()
        {
            keyed_info = new TreeMap<Integer, String>();
        }

        /** 
         * Nine-argument construtor : 
         *
         * This constructor takes in as parameters each value which we need to
         * completely define a Person. 
         *
         * @param f first name
         * @param l last name
         * @param v village
         * @param t tribe
         * @param h house number
         * @param dob date of birth
         * @param i insurance number
         * @param n national ID
         * @param g gender
         */
        public Info(String f, String l, String v, String t, String h,
                    String dob, String i, String n, String g)
        {
            keyed_info = new TreeMap<Integer, String>();
            keyed_info.put(FIRST_NAME, f);
            keyed_info.put(LAST_NAME, l);
            keyed_info.put(VILLAGE, v);
            keyed_info.put(TRIBE, t);
            keyed_info.put(HOUSE_NUMBER, h);
            keyed_info.put(DATE_OF_BIRTH, dob);
            keyed_info.put(INSURANCE_NUMBER, i);
            keyed_info.put(NATIONAL_ID, n);
            keyed_info.put(GENDER, g);
        }

        /** 
         * One-argument constructor :
         * 
         * This constructor puts the informaiton in its parameter into this 
         * Info object. If there are fields in the map which are not
         * represented by fields in the info object, then throw an exception
         *
         * @param info the information to identify this Person
         * @throws InputMismatchException improper info passed in
         */
        public Info(Map<Integer, String> info) throws InputMismatchException
        {
            keyed_info = new TreeMap<Integer, String>();

            for (Integer key : info.keySet())
            {
                switch (key.intValue())
                {
                    case FIRST_NAME: 
                        keyed_info.put(key, info.get(key));
                        break;
                    case LAST_NAME: 
                        keyed_info.put(key, info.get(key));
                        break;
                    case VILLAGE: 
                        keyed_info.put(key, info.get(key));
                        break;
                    case TRIBE: 
                        keyed_info.put(key, info.get(key));
                        break;
                    case HOUSE_NUMBER: 
                        keyed_info.put(key, info.get(key));
                        break;
                    case DATE_OF_BIRTH: 
                        keyed_info.put(key, info.get(key));
                        break;
                    case INSURANCE_NUMBER: 
                        keyed_info.put(key, info.get(key));
                        break;
                    case NATIONAL_ID: 
                        keyed_info.put(key, info.get(key));
                        break;
                    case GENDER: 
                        keyed_info.put(key, info.get(key));
                        break;
                    default:
                        throw new InputMismatchException();
                }
            }
        }

        /** 
         * Determine if this Info object contians the other one.
         *
         * This method implements the notion of containment from set theory, 
         * where set A contains set B iff for all elements b in B, b is an 
         * element of A. More simply put for all b, b in B implies b in A.
         *
         * This method is needed to enable searching of the Person Database for
         * all Person's with certain information.
         *
         * @param other the person to compare to
         * @return whether or not this Info object contains the other one
         */
        public boolean contains(Person.Info other)
        {
            for (Integer key : other.keyed_info.keySet())
            {
                String other_value = other.keyed_info.get(key);
            	if (!other_value.equals("") &&
                    !this.keyed_info.get(key).equals(other_value))
            		  return false;	
            }
            return true;
        }

        /** 
         * Get the first name.
         * @return the first name
         */
        public String getFirstName()
        {
            return keyed_info.get(FIRST_NAME);
        }

        /** 
         * Set the first name.
         * @param f the first name
         */
        public void setFirstName(String f)
        {
            keyed_info.put(FIRST_NAME, f);
        }

        /** 
         * Get the last name.
         * @return the last name
         */
        public String getLastName()
        {
            return keyed_info.get(LAST_NAME);
        }

        /** 
         * Set the last name.
         * @param l the last name
         */
        public void setLastName(String l)
        {
            keyed_info.put(LAST_NAME, l);
        }

        /** 
         * Get the village.
         * @return the village
         */
        public String getVillage()
        {
            return keyed_info.get(VILLAGE);
        }

        /** 
         * Set the village.
         * @param v the village
         */
        public void setVillage(String v)
        {
            keyed_info.put(VILLAGE, v);
        }

        /** 
         * Get the tribe.
         * @return the tribe
         */
        public String getTribe()
        {
            return keyed_info.get(TRIBE);
        }

        /** 
         * Set the tribe.
         * @param t the tribe
         */
        public void setTribe(String t)
        {
            keyed_info.put(TRIBE, t);
        }

        /** 
         * Get the house number.
         * @return the house number
         */
        public String getHouseNumber()
        {
            return keyed_info.get(HOUSE_NUMBER);
        }

        /** 
         * Set the house number.
         * @param h the house number
         */
        public void setHouseNumber(String h)
        {
            keyed_info.put(HOUSE_NUMBER, h);
        }

        /** 
         * Get the date-of-birth.
         * @return the date-of-birth
         */
        public String getDateOfBirth()
        {
            return keyed_info.get(DATE_OF_BIRTH);
        }

        /** 
         * Set the date-of-birth.
         * @param dob the date-of-birth
         */
        public void setDateOfBirth(String dob)
        {
            keyed_info.put(DATE_OF_BIRTH, dob); 
        }

        /** 
         * Get the insurance number.
         * @return the insurance number
         */
        public String getInsuranceNumber()
        {
            return keyed_info.get(INSURANCE_NUMBER);
        }

        /** 
         * Set the insurance number.
         * @param i the insurance number
         */
        public void setInsuranceNumber(String i)
        {
            keyed_info.put(INSURANCE_NUMBER, i);
        }

        /** 
         * Get the national ID.
         * @return the national ID.
         */
        public String getNationalID()
        {
            return keyed_info.get(NATIONAL_ID);
        }

        /** 
         * Set the national ID.
         * @param i the national ID
         */
        public void setNationalID(String i)
        {
            keyed_info.put(NATIONAL_ID, i); 
        }

        /** 
         * Get the gender.
         * @return the gender
         */
        public String getGender()
        {
            return keyed_info.get(GENDER);
        }

        /** 
         * Set the gender. 
         * @param g the gender
         */
        public void setGender(String g)
        {
            keyed_info.put(GENDER, g); 
        }
    }


	/** 
	 * This method generates this Person's ID. 
     *
     * This method is not up to par yet. 
     * 
     * TODO - testing
     *
	 * creates and returns the patients identification number
	 * this will return the last 12 digits
	 * 4 738 381 338 321 616 896 possible permutations 
	 * this will make it very unlikely to have a duplicate
     * 
	 * @return the Clinic ID of the patient
	 */
	public String generateID(){
		return UUID.randomUUID().toString().substring(24,36);	
	}

	/** 
	 * Default constructor : 
     * 
     * Create a Person with no information.
	 */
	public Person()
    {
		person_id = generateID();
        info = new Info();
        
	}

    /** 
     * Single-argument constructor : 
     *
     * Create a Person based on a Person.Info object.
     * @param i the Info object to use
     */
    public Person(Info i)
    {
		person_id = generateID();
        info = i;
    }

	/** 
	 * Nine-argument constructor : 
     *
     * Create a Person with all of the information needed to fill out the Info
     * object.
     *
	 * @param f first name
	 * @param l last name
	 * @param v village
	 * @param t tribe
	 * @param h house number
	 * @param d date-of-birth
	 * @param n national ID
	 * @param i insurance number
	 * @param g gender
	 */
	public Person(String f, 
                  String l,
                  String v, 
                  String t, 
                  String h, 
                  String d, 
                  String n,
                  String i,
                  String g)
    {
        info = new Info();
		person_id = generateID();

		info.setFirstName(f);
		info.setLastName(l);
		info.setVillage(v);
		info.setTribe(t);
		info.setHouseNumber(h);
        info.setInsuranceNumber(i);
        info.setNationalID(n);
		info.setDateOfBirth(d);
		info.setGender(g);
	}

    /** 
     * Get this Person's age.
     *
     * This method calculates this Person's age from their date-of-birth,
     * if that field is filled in. If it is not, then -1 is returned to 
     * signify that no age exists for this Person. 
     *
     * @return this Person's age
     */
    public int getAge()
    {
        /* Get a new Calendar instance and create a new date formatting
         * object with the same format used by the date-of-birth text
         * field. Try to parse the date-of-birth field, and if that parse
         * fails then return null. The parse will fail if the date is invalid,
         * or if no date is entered (the date-of-birth string is empty). */
        Calendar birth = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date birthday = null;
		try 
        {
			birthday = dateFormat.parse(getDateOfBirth());
		} 
        catch (Exception ignore) {}

        if (birthday == null)
            return -1;
        
        /* Get the year this Person was born in, and the current year, and then
         * return the difference between the two, as it is their age. */
		birth.setTime(birthday);
        int birth_year = birth.get(Calendar.YEAR);
        Calendar today = Calendar.getInstance();
        int this_year = today.get(Calendar.YEAR);

        return this_year - birth_year;
    }

    /** 
     * Get the Info object associated with this Person
     * 
     * @return this Person's Person.Info object
     */
    public Person.Info getInfo()
    {
        return info;
    }

    /** 
     * Set the identifying info for this Person.
     * @param i new info
     */
    public void setInfo(Person.Info i)
    {
        info = i;
    }

	/** 
	 * Get the Clinic ID for this Person
	 * @return the Clinic ID
	 */
	public String getID(){
		return person_id;
	}

    /** 
     * Get the first name.
     * @return the first name
     */
    public String getFirstName()
    {
        return info.getFirstName();
    }

    /** 
     * Set the first name.
     * @param f the first name
     */
    public void setFirstName(String f)
    {
        info.setFirstName(f);
    }

    /** 
     * Get the last name.
     * @return the last name
     */
    public String getLastName()
    {
        return info.getLastName();
    }
    
    /** 
     * Set the last name.
     * @param l the last name
     */
    public void setLastName(String l)
    {
        info.setLastName(l);
    }
    
    /** 
     * Get the village.
     * @return the village
     */
    public String getVillage()
    {
        return info.getVillage();
    }
    
    /** 
     * Set the village
     * @param v the village
     */
    public void setVillage(String v)
    {
        info.setVillage(v);
    }

    /** 
     * Get the tribe.
     * @return the tribe
     */
    public String getTribe()
    {
        return info.getTribe();
    }
    
    /** 
     * Set the tribe.
     * @param t the tribe
     */
    public void setTribe(String t)
    {
        info.setTribe(t);
    }
    
    /** 
     * Get the house number.
     * @return the house number
     */
    public String getHouseNumber()
    {
        return info.getHouseNumber();
    }
    
    /** 
     * Set the house number
     * @param h the house number
     */
    public void setHouseNumber(String h)
    {
        info.setHouseNumber(h);
    }
    
    /** 
     * Get the date-of-birth.
     * @return the date-of-birht
     */
    public String getDateOfBirth()
    {
        return info.getDateOfBirth();
    }
    
    /** 
     * Set the date-of-birht.
     * @param dob the date-of-birth
     */
    public void setDateOfBirth(String dob)
    {
        info.setDateOfBirth(dob); 
    }
    
    /** 
     * Get the insurance number.
     * @return the insurance number
     */
    public String getInsuranceNumber()
    {
        return info.getInsuranceNumber();
    }
    
    /** 
     * Set the insurance number.
     * @param i the insurance number
     */
    public void setInsuranceNumber(String i)
    {
        info.setInsuranceNumber(i);
    }
    
    /** 
     * Get the national ID.
     * @return the national ID.
     */
    public String getNationalID()
    {
        return info.getNationalID();
    }
    
    /** 
     * set the national ID.
     * @param i the national ID
     */
    public void setNationalID(String i)
    {
        info.setNationalID(i); 
    }
    
    /** 
     * Get the gender.
     * @return the gender
     */
    public String getGender()
    {
        return info.getGender();
    }
    
    /** 
     * Set the gender.
     * @param g the gender
     */
    public void setGender(String g)
    {
        info.setGender(g); 
    }
    
	/** 
	 * Create the String representation of this Person.
	 * @return the String representation of this Person
	 */
	public String toString()
    {
		return "Clinic ID: "+getID()
               +" "+getFirstName()
               +" "+getLastName()
               +" "+getDateOfBirth()
               +" "+getGender()
               +" Village: "+getVillage()
               +" Tribe: "+getTribe()
               +" House #: "+getHouseNumber()
               +" Insurance #: "+getInsuranceNumber()
               +" National ID: "+getNationalID();
	}
}
