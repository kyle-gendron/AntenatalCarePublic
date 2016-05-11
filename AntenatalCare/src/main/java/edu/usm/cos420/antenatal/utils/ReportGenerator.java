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
			if(Double.valueOf(p.getIPTDoses()) > 0){
				numIPTFirstDose++;
				if(Double.valueOf(p.getIPTDoses()) > 1){
					numIPTSecondDose++;
					if(Double.valueOf(p.getIPTDoses()) > 2)
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
     * @throws    DocumentException 
     * @throws    IOException 
     */
	public void createPdf(String filename) throws DocumentException, IOException {
	  //currently this is just a test to make sure that it works properly
	  //file selector?
	  
	  Document doc = new Document();
	  PdfWriter.getInstance(doc, new FileOutputStream(filename));
	  doc.open();
	  doc.add(new Paragraph("Hello world!"));
	  doc.close();
	  
	  
	}
}
