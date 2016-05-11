package edu.usm.cos420.antenatal.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.itextpdf.text.DocumentException;

import edu.usm.cos420.antenatal.domain.DummyPerson;
import edu.usm.cos420.antenatal.domain.PregnancyFollowUp;
import edu.usm.cos420.antenatal.domain.PregnancyRecord;
import edu.usm.cos420.antenatal.domain.PregnancyVisit;
import edu.usm.cos420.antenatal.utils.ReportGenerator;
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
  private ReportGenerator reportGen;

  /**
   * Standard controller constructor
   */
  public ReportingController(DummyPerson person, 
      ArrayList<PregnancyFollowUp> followUps,
      ArrayList<PregnancyVisit> records){
    
    this.person = person;
    this.followUps = followUps;
    this.records = records;
    
    //throw up the form
    report = new ReportingForm(this);
    
    //create a new report generator
    reportGen = new ReportGenerator(person, followUps, records);    
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
      
      JFileChooser fc = getFileName();
      
      //make sure they selected a file
      if(fc == null){
        break;
      }
     
      //get a file name from there
      //save it there
      File file = fc.getSelectedFile();
      fileName = file.getAbsolutePath();
      
      //test if it ends w/ .pdf
      //if not add it on
      if(fileName != null || fileName.equals("") == false){
          if(fileName.substring(fileName.length() - 4).equals(".pdf") != true){
            //add .pdf at the end of the filename
            fileName = fileName + ".pdf";            
          }        
      }else{
        break;
      }
      
      //generate the report      
      try {
        reportGen.createPdf(fileName, year, month);
      } catch (DocumentException e1) {
        e1.printStackTrace();
      } catch (IOException e1) {
        e1.printStackTrace();
      }
      report.close(); 
    }
    }
  }
  
  /**
   * create a window to save the file somewhere with a simple picker
   * @return JFileChooser on success, null on failure
   */

  public JFileChooser getFileName(){
    JFileChooser fc = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter(
        "PDF", "pdf");
    fc.setFileFilter(filter);
    Component temp = null;
    int ret = fc.showSaveDialog(temp);
    if(ret == JFileChooser.APPROVE_OPTION){
      //the selected a file name
      return fc;
    }
    return null;
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
