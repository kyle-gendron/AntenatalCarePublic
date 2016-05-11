package edu.usm.cos420.antenatal.utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;



import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.awt.Color;
import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

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
	static DummyPerson person;
	static ArrayList<PregnancyFollowUp> followUps;
	static ArrayList<PregnancyVisit> records;

	//collected data
	static int numReg, numAttendances, num4thVisits, numTT2ndDoses,
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
	public static ArrayList<Integer> collect(){

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
		/* currently broken don't look
		//collect IPT dose numbers
		for(PregnancyVisit p: records){
			if(Double.valueOf(p.getIPTDoses()) > 0){
				numIPTFirstDose++;
				if(Double.valueOf(p.getIPTDoses()) > 1){
					numIPTSecondDose++;
					if(Double.valueOf(p.getIPTDoses()) > 2)
						numIPTThirdDose++;
				}
			}
		}
		*/
		
	      //collect first-visit ITN usages
        for(PregnancyVisit p: records)
            if(p.getITN().equals("Yes"))
                numITNFirstVisit++;
        /*
        //collect second-visit ITN usages  
        PregnancyFollowUp fol = null;
        for(PregnancyVisit r: records){
            
            //cycle through followup visits looking for earliest
            for(PregnancyFollowUp f: followUps){
                if(!fol.equals(null)){
                    if(fol.getApptDate().isAfter(f.getApptDate())
                            && fol.getInitialID().equals(f.getInitialID())){
                        fol = f;
                    }
                }
                else{
                    if(f.getInitialID().equals(r.getId()))
                        fol = f;
                }
            }
        }
        */
		
		//collect number of positive malaria lab reactions
		for(PregnancyVisit p: records)
			if(p.getBloodFilm().equals("Reactive"))
				numReactions++;
		for(PregnancyFollowUp f: followUps)
			if(f.getBloodFilm().equals("Reactive"))
				numReactions++;
		
		//collect the number of patients counseled for HIV testing
        for(PregnancyVisit p: records){
            if(p.getPreTestCounsel().equals("Yes")
                    || p.getPostTestCounsel().equals("Yes")){
                numHIVCounseled++;
            }
        }
        
        //collect the number of HIV tests conducted
        String result;
        for(PregnancyVisit p: records){
            result = p.getHIVResults();
            if(!result.equals(null))
                numHIVTested++;
        }
        
        //collect the number of positive HIV results
        for(PregnancyVisit p: records){
            if(p.getHIVResults().equals("Positive"))
                numHIVPos++;
        }
            
        //collect the number of babies on ARV
        for(PregnancyVisit p: records)
            if(p.getARV().equals("Yes"))
                numARVBabies++;
        
        //collect the number of mothers on ARV drugs
        for(PregnancyVisit p: records){
            if(p.getARV().equals("Yes")){
                numARVMothers++;
                break;
            }
        }
        
        //collect data into arraylist
        ArrayList<Integer> results = new ArrayList<Integer>();
        results.add(numReg);
        results.add(numAttendances);
        results.add(num4thVisits);
        results.add(numTT2ndDoses);
        results.add(numMothers10To14);
        results.add(numMothers15To19);
        results.add(numMothers20To24);
        results.add(numMothers25To29);
        results.add(numMothers30To34);
        results.add(numMothers35AndUp);
        results.add(numMothers150OrLess);
        results.add(numParity0);
        results.add(numParity1To2);
        results.add(numParity3To4);
        results.add(numParity5AndMore);
        results.add(numFirstTri);
        results.add(numSecondTri);
        results.add(numThirdTri);
        results.add(numHBAtReg);
        results.add(numHBUnder11AtReg);
        results.add(numHBUnder7AtReg);
        results.add(numHBAt36);
        results.add(numHBUnder11At36);
        results.add(numHBUnder7At36);
        results.add(numIPTFirstDose);
        results.add(numIPTSecondDose);
        results.add(numIPTThirdDose);
        results.add(numReactions);
        results.add(numITNFirstVisit);
        results.add(numITNSecondVisit);
        results.add(numHIVCounseled);
        results.add(numHIVTested);
        results.add(numHIVPos);
        results.add(numARVBabies);
        results.add(numARVMothers);
        
        return results;
	}
	
    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @param year the year of the report
     * @param month the month of the report
     */
	public static void createPdf(String filename, int year, int month) throws DocumentException, IOException {	  
	  
	  //get data from stuff
	  ArrayList<Integer> results = collect();
	  
	  //open the form
	  Document doc = new Document(PageSize.A4);
	  PdfWriter.getInstance(doc, new FileOutputStream(filename));
	  doc.open();	  
	  
	  //just a temp thing
      PdfPTable table = new PdfPTable(11);
      // the cell object
      PdfPCell cell;
      
      cell = new PdfPCell(new Phrase("Monthly Midwife Report"
          + "Name of Insitution:\t\t" + " Antenatal Office\n"
          + "Type of Facility:\t\t"  + " Antenatal\n"
          + "Sub Dist:\t\t"          +  person.getSubDistrict() + "\n"
          + "District:\t"          +  person.getDistrict() + "\n"
          + "Region:\t\t"            +  "Here\n"
          + "Year:\t\t"              +  year + "\n"
          + "Month:\t\t"             +  month + "\n" ));
      cell.setColspan(11);
      table.addCell(cell);
           
      cell = new PdfPCell(new Phrase("# of Registrants"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(0) + ""));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("Attendances"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(1)+ ""));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("# making 4th visists"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(2)+ ""));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("TT 2+ vaccination"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(3)+ ""));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("AGE OF MOTHER AT REGISTRATION"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("10 - 14"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(4)+ ""));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("15 - 19"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(5)+ ""));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("20 - 24"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(6)+ ""));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("25 - 29"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(7)+ ""));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("30 - 34"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(8)+ ""));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("35+"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(9)+ ""));
      table.addCell(cell);      
      cell = new PdfPCell(new Phrase("Mothers below 150cm"));
      table.addCell(cell); 
      cell = new PdfPCell(new Phrase(results.get(10)+ ""));
      table.addCell(cell); 
      
      cell = new PdfPCell(new Phrase("Parity:"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("0"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(11)+ ""));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("1 - 2"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(12)+ ""));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("3 - 4"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(13)+ ""));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("5+"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(14)+ ""));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("Trimester at Registration"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("First"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(15)+ ""));
      table.addCell(cell);      
      cell = new PdfPCell(new Phrase("Second"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(16)+ ""));
      table.addCell(cell); 
      cell = new PdfPCell(new Phrase("Third"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(17)+ ""));
      table.addCell(cell); 
      cell = new PdfPCell(new Phrase("HB at reg:"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(18)+ ""));
      table.addCell(cell); 
      cell = new PdfPCell(new Phrase("HB <11"));
      table.addCell(cell);      
      cell = new PdfPCell(new Phrase(results.get(19)+ ""));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("HB <7"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(20)+ ""));
      table.addCell(cell); 
      cell = new PdfPCell(new Phrase("HB @ 36"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(21)+ ""));
      table.addCell(cell); 
      cell = new PdfPCell(new Phrase("HB < 11"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(22)+ ""));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase("HB < 7"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(23)+ ""));
      table.addCell(cell); 
      cell = new PdfPCell(new Phrase("IPT 1st Dose"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(24)+ ""));
      table.addCell(cell); 
      cell = new PdfPCell(new Phrase("IPT 2nd Dose"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(25)+ ""));
      table.addCell(cell);      
      cell = new PdfPCell(new Phrase("IPT 3rd Dose"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(26)+ ""));
      table.addCell(cell); 
      cell = new PdfPCell(new Phrase("Reactions"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(27)+ ""));
      table.addCell(cell); 
      cell = new PdfPCell(new Phrase("ITN 1st Visit"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(28)+ ""));
      table.addCell(cell); 
      cell = new PdfPCell(new Phrase("ITN 2nd Visit"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(29)+ ""));
      table.addCell(cell);       
      cell = new PdfPCell(new Phrase("HIV Consouled"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(30)+ ""));
      table.addCell(cell); 
      cell = new PdfPCell(new Phrase("HIV Tested"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(31)+ ""));
      table.addCell(cell); 
      cell = new PdfPCell(new Phrase("HIV+"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(32)+ ""));
      table.addCell(cell); 
      cell = new PdfPCell(new Phrase("ARV Babies"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(33)+ ""));
      table.addCell(cell); 
      cell = new PdfPCell(new Phrase("ARV Mothers"));
      table.addCell(cell);
      cell = new PdfPCell(new Phrase(results.get(34)+ ""));
      table.addCell(cell);       
	  
	  doc.add(table);
	  doc.close();
	}
}
