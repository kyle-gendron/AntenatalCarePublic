package edu.usm.cos420.antenatal.utils;

import java.util.ArrayList;

import edu.usm.cos420.antenatal.domain.DummyPerson;
import edu.usm.cos420.antenatal.domain.PregnancyFollowUp;
import edu.usm.cos420.antenatal.domain.PregnancyRecord;
import edu.usm.cos420.antenatal.domain.PregnancyVisit;

/**
 * 
 * @author Kyle
 *
 *Helper class built to collect data for .pdf generation
 */
public class ReportGenerator {
	//input data
	DummyPerson person;
	ArrayList<PregnancyFollowUp> followUps;
	ArrayList<PregnancyVisit> records;

	//collected data
	int numReg, numAttendances, num4thVisits, numTT2ndDoses,
	numMothers10To14, numMothers15To19, numMothers20To24,
	numMothers25To29, numMothers30To34, numMothers35AndUp,
	numMothers150OrLess, numParity0, numParity1To2,
	numParity3To4, numParity5AndMore, numFirstTri,
	numSecondTri, numThirdTri, numHBAtReg, numHBUnder11AtReg,
	numHBUnder7AtReg, numHBAt36, numHBUnder11At36, 
	numHBUnder7At36, numIPTFirstDose, numIPTSecondDose,
	numIPTThirdDose, numReactions, numITNFirstVisit,
	numITNSecondVisit, numHIVCounseled, numHIVTested,
	numHIVPos, numARVBabies, numARVMothers;

	/*
	 * Standard 3-variable constructor
	 */
	public ReportGenerator(DummyPerson person, 
			ArrayList<PregnancyFollowUp> followUps,
			ArrayList<PregnancyVisit> records){
		this.person = person;
		this.followUps = followUps;
		this.records = records;
	}

	/**
	 * Returns the results of examining all the data given
	 * to this object in the constructor.
	 * @return the resulting collected data in the form of an 
	 * arraylist.
	 */
	public ArrayList<Integer> collect(){

		//collect number of registers
		numReg = records.size();

		//collect number of attendances
		numAttendances = records.size() + followUps.size();

		//collect the number of pregnancies that had a 4th visit
		int sumSubs = 0;
		for(PregnancyVisit p: records){

			//search through followups, finding up to four visits
			for(PregnancyFollowUp f: followUps){
				if(p.getId().equals(f.getInitialID()))
					sumSubs++;
				if(sumSubs == 4){
					num4thVisits++;
					break;
				}
			}

			//reset each iteration
			sumSubs = 0;
		}

		//collect the number of patients given a second TT dose
		for(PregnancyVisit p: records){
			if(p.getTTDoses().equals("booster"))
				numTT2ndDoses++;
		}

		//TODO: Make this collect ALL the people's ages
		//collects the age of the person
		int age = person.getAge();
		if(age > 34)
			numMothers35AndUp++;
		else if(age > 29)
			numMothers30To34++;
		else if(age > 24)
			numMothers25To29++;
		else if(age > 19)
			numMothers20To24++;
		else if(age > 14)
			numMothers15To19++;
		else //our catch-all for all pregnancies under 14
			numMothers10To14++;

		//collect the number of mothers who are less than 150 cm tall
		for(PregnancyVisit p: records)
			if(p.getHeight() <= 150)
				numMothers150OrLess++;

		//collect the parity of each patient's record
		for(PregnancyVisit p: records){
			if(p.getParity() == 0)
				numParity0++;
			else if(p.getParity() <= 2)
				numParity1To2++;
			else if(p.getParity() <= 4)
				numParity3To4++;
			else
				numParity5AndMore++;
		}

		//collect the trimester of each record
		for(PregnancyVisit p: records){
			if(p.getTrimester() == 1)
				numFirstTri++;
			else if(p.getTrimester() == 2)
				numSecondTri++;
			else
				numThirdTri++;
		}

		//collect checked HBs at reg
		for(PregnancyVisit p: records){

			//we have a non-empty HB
			if(p.getHBAtReg() > 0.0){
				numHBAtReg++;
				if(p.getHBAtReg() < 11.0){
					numHBUnder11AtReg++;
					if(p.getHBAtReg() < 7.0)
						numHBUnder7AtReg++;
				}
			}
		}

		//collect checked HBs at 36 weeks
		for(PregnancyVisit p: records){

			//we have a non-empty HB
			if(p.gethBAt36Weeks() > 0.0){
				numHBAt36++;
				if(p.gethBAt36Weeks() < 11.0){
					numHBUnder11At36++;
					if(p.gethBAt36Weeks() < 7.0)
						numHBUnder7At36++;
				}
			}
		}
		
		//collect IPT dose numbers
		for(PregnancyVisit p: records){
			if(p.getIPTDoses() > 0){
				numIPTFirstDose++;
				if(p.getIPTDoses() > 1){
					numIPTSecondDose++;
					if(p.getIPTDoses() > 2)
						numIPTThirdDose++;
				}
			}
		}
		
		//collect number of positive malaria lab reactions
		for(PregnancyVisit p: records)
			if(p.getBloodFilm().equals("Reactive"))
				numReactions++;
		for(PregnancyFollowUp f: followUps)
			if(f.getBloodFilm().equals("Reactive"))
				numReactions++;
		
		//collect first-visit ITN usages
		for(PregnancyVisit p: records){
			if(p.getITN().equals("Yes"))
				numITNFirstVisit++;
			
			Boolean secondAppointmentFound = false;
			
			//collect second-visit ITN usages  
			for(PregnancyFollowUp f: followUps)		  
			  //second appt not found
			  if(secondAppointmentFound == true){
			    break;
		      }else{
		        //id == records id
		        if(p.getId().equals(f.getInitialID()))      
	              //appt is after this first one
		          if(f.getApptDate().isAfter(p.getApptDate()) == true)
		            numITNSecondVisit++;
		      }
		}
		
		//collect PMTCT data?
		//did we even collect that from the get go?
			  
		return new ArrayList<Integer>();
	}	
}
