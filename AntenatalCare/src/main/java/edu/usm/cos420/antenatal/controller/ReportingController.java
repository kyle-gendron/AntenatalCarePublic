package edu.usm.cos420.antenatal.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import edu.usm.cos420.antenatal.domain.DummyPerson;
import edu.usm.cos420.antenatal.domain.PregnancyFollowUp;
import edu.usm.cos420.antenatal.domain.PregnancyRecord;
import edu.usm.cos420.antenatal.domain.PregnancyVisit;
import edu.usm.cos420.antenatal.view.ReportingForm;
import edu.usm.cos420.antenatal.view.VisitForm;
import edu.usm.cos420.antenatal.view.AntenatalView;

/**
 * 4/17/2016
 * @author Kyle
 *
 *Small controller class accompanying Midwife Report functionality
 */
public class ReportingController implements ActionListener {

  private ReportingForm report;
  private DummyPerson person;
  private ArrayList<PregnancyFollowUp> followUps;
  private ArrayList<PregnancyVisit> records;

  /**
   * Standard controller constructor
   */
  public ReportingController(){}
  public ReportingController(DummyPerson person, 
      ArrayList<PregnancyFollowUp> followUps,
      ArrayList<PregnancyVisit> records){
    
    this.person = person;
    this.followUps = followUps;
    this.records = records;
    
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    int year;
    int month;
    String fileName;
    
    switch (e.getActionCommand()) {
    case "Submit": {

      //pass on the information
      year = report.getReportYear();
      month = report.getReportMonth();
      
      //TODO: add a file picker      
      //get a file name from there
      //save it there      
      fileName = "monthlyMidwifeReports";
      
      //generate the report
      
      
      
      System.out.println("Made it!");

    }
    }	
  }

  /**
   * Get report form
   * @return the report form
   */
  public ReportingForm getReportingForm(){
    return report;
  }

  /**
   * Set report form
   * @param report the report form to be changed to
   */
  public void setReportingForm(ReportingForm report){
    this.report = report;
  }
}
