package edu.usm.cos420.health.consultingregister.data;

import edu.usm.cos420.health.consultingregister.domain.RegisterItem;
import edu.usm.cos420.health.domain.Person;

import java.util.ArrayList;

import edu.usm.cos420.health.domain.*;
public class daoDriver 
{

	public static void main(String[] args)
	{
	  PersonDao test = new PersonDao();
	  /*Person test1 = new Person("Nolan","Tanguay","Maine","Biddeford","302","00-143","423-53-1534","9/27/94","Male");
	  Person test2 = new Person("George","Washington","Maine","Biddeford","156","52-423","423-53-1534","8/27/94","Female");
	  Person test3 = new Person("Keith","Willson","Maine","Biddeford","302","56-243","423-53-1534","7/27/94","Male");
	  Person test4 = new Person("Billy","TheKid","Maine","Biddeford","153","51-673","423-53-1534","6/27/94","Female");
	  Person test5 = new Person("David","Goodwin","Maine","Orono","352","19-475","423-53-1534","5/27/94","Male");
	  Person test6 = new Person("Barack","Obama","Maine","Augusta","745","18-363","423-53-1534","4/27/94","Male");
	  Person test7 = new Person("Andrew","Miles","Maine","Arundel","684","19-256","423-53-1534","3/27/94","Female");
	  Person test8 = new Person("Joe","Dirt","Maine","Saco","302","63-564","62-538","10/2/94","Male");
	  Person test9 = new Person("Tyler","Chara","Maine","Gorham","364","53-1534","423-53-1534","10/27/94","Female");
	  Person test10 = new Person("John","Salt","Maine","Biddeford","834","53-1537","423-53-1534","1/2/94","Male");
	  test.addPerson(test1);
	  test.addPerson(test2);
	  test.addPerson(test3);
	  test.addPerson(test4);
	  test.addPerson(test5);
	  test.addPerson(test6);
	  test.addPerson(test7);
	  test.addPerson(test8);
	  test.addPerson(test9);
	  test.addPerson(test10);
	  
	  ///I edited this out as it served as the one time filling of the test database*/
	   ArrayList test1 = test.findPeople(new Person.Info("Nolan","","","","","","","",""));
	  //test.addPerson(test1);
	  //ArrayList temp1 = test.findPeople(test1.getInfo());
	  //System.out.println("\n Testing what was returned: \n"+temp1);
	  RegisterDao testRegister = new RegisterDao();
	  Person t = (Person) test1.get(0);
	  /*RegisterItem temp3 = new RegisterItem(t, "3/21/2016","2016","Biddeford","SubDistrict","New Case"
			  ,"","Liver Diseases","Treatment","Referred","Refer Outcome","Remarks","bp","pulse"
			  ,"Temp","Weight","resp","test");
	  test1 = test.findPeople(new Person.Info("Nolan","","","","","","","",""));
	  t = (Person) test1.get(0);
	  RegisterItem temp4 = new RegisterItem(t, "3/21/2016","2016","Biddeford","SubDistrict","New Case"
			  ,"","Acute Ear Infection","Treatment","Referred","Refer Outcome","Remarks","bp","pulse"
			  ,"Temp","Weight","resp","test");
	  test1 = test.findPeople(new Person.Info("Tyler","","","","","","","",""));
	  t = (Person) test1.get(0);
	  RegisterItem temp5 = new RegisterItem(t, "3/21/2016","2016","Biddeford","SubDistrict","New Case"
			  ,"","Malnutrition","Treatment","Referred","Refer Outcome","Remarks","bp","pulse"
			  ,"Temp","Weight","resp","test");
	  testRegister.addRegistry(temp3);
	  testRegister.addRegistry(temp4);
	  testRegister.addRegistry(temp5);*/
	  //RegisterItem.Info = new RegisterItem.Info("3/21/2016","2016","","","","","","","","","","");
	  RegisterItem temp2 = new RegisterItem(null, "","","","",""
			  ,"","","","","","","",""
			  ,"","","","");
	  ArrayList testing1 = testRegister.findRegistries(temp2.getInfo(), t);
	  System.out.println("\n Testing what was returned: \n"+testing1);
	  //This is the testing line, put in whatever it is you want to search in the database
	  //And it will return the array with all people with those attributes.
	  
	  		// First name, Last Name, Village, Tribe, House#, Insurance#, NationalID, DOB, Gender
	  //Person Testing = new Person("","","","","","","","6/27/94","Female");
	  
	  //Person testLoad1 = test.findPeople(test1.getID());
	  /*Person testLoad1 = test.findPeople("190199db0d4b");
	  System.out.println("Testing find 1: \n"+testLoad1);
	  //Person testLoad2 = test.findPeople(test2.getID());
	  Person testLoad2 = test.findPeople("250a3389425a");
	  System.out.println("Testing find 2: \n"+testLoad2);
	 // Person testLoad3 = test.findPeople(test3.getID());
	  Person testLoad3 = test.findPeople("4df69c89d680");
	  System.out.println("Testing find 3: \n"+testLoad3);*/
	  //Person testLoad4 = test.findPerson("Invalid ID");
	  //System.out.println("Testing invalid id search: \n"+testLoad4);
	  //System.out.println("----------");
	  //System.out.println("Testing addPerson\n");
	  //ArrayList temp1 = test.findPeople(Testing.getInfo());
	  //System.out.println("\n Testing what was returned: \n"+temp1);
	  
	}
}
