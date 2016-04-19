
package edu.usm.cos420.health.consultingregister.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import edu.usm.cos420.health.consultingregister.domain.RegisterItem;
import edu.usm.cos420.health.domain.Person;


public class RegisterDao 
{
	public String[] diseaseArray = {"Acute Ear Infection","Acute Eye Infection","Acute Psychosis", "Acute Urinary Tract Infection"
			,"AFP (Polio)","All Other Diseases","Anaemia","Aneamia in Pregnancy","Asthma","Buruli Ulcer","Cataract","Chicken Pox"
			,"Cholera","CSM","Dental Caries","Diabetes Mellitus","Diarrhoea Diseases","Diphtheria","Domestic Violence"
			,"Epilepsy","Genital Ulcer Disease","Gonorrhoea","Guinea worm","Gynaecological conditions","HIV/AIDS"
			,"Home Accidents and Injuries","Home Poisonings","Hypertension","Infectious Hepatitis","Intestinal worms"
			,"Kidney Related Diseases","Leprosy","Liver Diseases","Malaria in Pregnancy Lab Confirmed"
			,"Malaria in Pregnancy Non-Lab Confirmed","Malnutrition","Measles","Mumps","Neonatal Tetanus"
			,"Neurosis","Occupational Injuries","Occupational Poisonings","Onchocercaisis","Other Animal Bites"
			,"Other ARI(Acute Respiratory Infection)","Other Cardiac Diseases","Other Disease of the Female Reproductive System"
			,"Other Disease of the Male Reproductive System","Other Meningitis","Other Nutritional Diseases","Other oral Conditions"
			,"Pertussis","Pneumonia","Pregnancy and Related Complications","PUO (not Malaria)","Rheumatism and Joint Paints"
			,"Road Trafic Accidents","Schistosomiasis (Bilharzia)","Septicaemia","Severe Malaria Lab Confirmed"
			,"Severe Malaria Non-Lab Confirmed","Sexual abuse","Sickle cell Disease","Simple Malaria Lab Confirmed"
			,"Simple Malaria Non-Lab Confirmed","Skin Diseases & Ulcers","Snake Bite","Substance Abuse","Tetanus"
			,"Trachoma","Tuberculosis","Typhoid/Enteric Fever(Typhoid)","Urethral Discharge","Vaginal Discharge"
			,"Yaws","Yellow Fever"};
    private ObjectStreamDao<Person, RegisterItem> dataBase = new ObjectStreamDao<Person, RegisterItem>("RegisterDatabase.ser");
    
    public ArrayList<RegisterItem> findRegistries(RegisterItem.Info info, Person per)
    {
        ArrayList<RegisterItem> result = new ArrayList<RegisterItem>();

        for (RegisterItem r : dataBase.map().values())
        {
            if (r.getInfo().contains(info))
            {
            	if(per == null || per.getID().equals(r.getPatient().getID()))
            	{
            		result.add(r);
            	}
            }
        }

        return result;
    }

    public void addRegistry(RegisterItem r)
    {
    	RegisterItem s = dataBase.find(r.getPatient());
    	if(s == null) 
    	{
            dataBase.add(r.getPatient(), r);
    	}
    }

//We throw ParseException because we can assume dates of Visits, fromDate and ToDate as being correct format
	public int[][] generateReport(String fromDate, String toDate) {
		int[][] reportArray = new int[77][25]; // Array for holding report table 37
		/*for(int i = 0; i<76; i++)
		{
		  reportArray[i] = new int[25];
		}*/
		//String[] diseaseArray = new String[76];        // Array for checking disease name for respective spot on array
		 SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		 System.out.println(diseaseArray.length);
		  RegisterItem temp2 = new RegisterItem(null, "","","","",""
				  ,"","","","","","","",""
				  ,"","","","");
		ArrayList<RegisterItem> allRegisters = findRegistries(temp2.getInfo(), null);
		Date fromTime = null;
		Date endTime = null;
		try {
			fromTime = dateFormat.parse(fromDate);
			endTime = dateFormat.parse(toDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(fromTime);
		int startInt = cal.get(Calendar.DAY_OF_YEAR);
		int startYear = cal.get(Calendar.YEAR);
		cal.setTime(endTime);
		int endInt = cal.get(Calendar.DAY_OF_YEAR);
		int endYear = cal.get(Calendar.YEAR);
		for(int i = 0; i< allRegisters.size(); i++) // Loop to get all register values
		{
		  RegisterItem temp = (RegisterItem) allRegisters.get(i);	
		  Person per = temp.getPatient();
		  Date currTime = null;
		try {
			if(temp.getDate()!= null){
					currTime = dateFormat.parse(temp.getDate());}
			else
				currTime = dateFormat.parse("1/1/1970");
		} catch (ParseException e) {
			System.exit(0);
			e.printStackTrace();
		}
		  cal.setTime(currTime);
		  int currInt = cal.get(Calendar.DAY_OF_YEAR);
		  int currYear = cal.get(Calendar.YEAR);
		  if(currInt >= startInt && currInt <= endInt) //If this current registry is in our date range
		  {
			  if(startYear <= currYear && endYear >= currYear) //Checks if the year range is correct
			  {								 				   // Inside this loop is where all the data from Diagnosis
				  										       // Will be handled
				 for(int z = 0; z<76; z++)
				 {
				   if(temp.getPrincDiag().equalsIgnoreCase(diseaseArray[z])) // Once it finds correct disease, add it, then
				   {														 // We can break to save computations
					   int age = per.getAge();							// Must determine age and gender for distribution
					   String gender = per.getGender();
					   int displacement = 0;
					   if(gender.equalsIgnoreCase("female"))
					   {
						  displacement = 12; // If female, we need to add to a seperate column, always 12 over
					   }
					   if(age < 1){
						   reportArray[z][0+displacement]++;
					   }
					   else if(age >=1 && age <=4){
						   reportArray[z][1+displacement]++;
					   }
					   else if(age >=5 && age <=9){
						   reportArray[z][2+displacement]++;
					   }
					   else if(age >=10 && age <=14){
						   reportArray[z][3+displacement]++;
					   }
					   else if(age >=15 && age <= 17){
						   reportArray[z][4+displacement]++;
					   }
					   else if(age >= 18 && age <= 19){
						   reportArray[z][5+displacement]++;
					   }
					   else if(age >= 20 && age <= 34){
						   //reportArray[z][6+displacement]++;
						   reportArray[z][6+displacement] = reportArray[z][6+displacement]+1;
					   }
					   else if(age >=35 && age <= 49){
						   reportArray[z][7+displacement]++;
					   }
					   else if(age >= 50 && age <= 59){
						   reportArray[z][8+displacement]++;
					   }
					   else if(age >= 60 && age <= 69){
						   reportArray[z][9+displacement]++;
					   }
					   else{ // Over 70 years old
						   reportArray[z][10+displacement]++; 
					   }
					   
				   }
				 }
			  }
		  }
		}
		int counter = 0;
		int displacement = 0;
		
		// The following code is to get the sub totals and totals of all the diseases in the report and put them in the
		// Correct part of the report
		// This first loop handles the horizontal totals
		// We need displacement because the total column is in different spots for Male and Female
		for(int b = 0; b < 2; b++)
		{	
			for(int i = 0; i < 76; i++) // Loop for doing horizontal column totals ; First loop through is male
			{							// Second time through, it counts up the female portion
				for(int a = 0; a <11; a++)// Displacement = 12 is used when referring to female part of report
				{
					counter = counter + reportArray[i][a+displacement];  
				}
				reportArray[i][11+displacement] = counter;
				counter = 0;
			}
			displacement = 12; // Set displacement here so it will loop through female part of report next
		}
		
		// Loop for calculating grand total of diseases for horizontal rows
		for(int b = 0; b<76; b++)
		{
		  reportArray[b][24] = reportArray[b][11] + reportArray[b][23];
		}
		
		// Loop for calculating vertical row totals and grand total
		for(int i = 0; i < 25; i++)
			{
				for(int b = 0; b < 76; b++)
				{
					counter = counter + reportArray[b][i]; 
				}
				reportArray[76][i] = counter;
				counter = 0;
			}
		int count = 0;
		return reportArray;
		/*
		//Loop to print out report
		for (int[] row : reportArray)
		{	
		  if(count == 76) // End of diseases, last line is TOTAL
		  {
			 System.out.println("TOTALS: "+String.format(Arrays.toString(row)));  
		  }
		  else
		  {
			System.out.print(diseaseArray[count]+" ");
		  	System.out.println(String.format(Arrays.toString(row)));
		  }
		  count++;
		}*/
		
	}
}