package edu.usm.cos420.antenatal.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by aaron on 2/27/2016.
 */

/**
 * A public class that creates the new antenatal visit.
 * Which consists of several fields that are used to
 * enter data necessary to the antenatal appointment.
 * (Height, weight, fundalHeight, gestation etc.)
 * 
 */
public class NewVisitForm extends JPanel {

  private final JPanel panel;
  private final JTextField parInput;
  private final JTextField bloInput1;
  private final JTextField bloInput2;
  private final JTextField heiInput;
  private final JTextField weiInput;
  private final JTextField gesInput;
  private final JTextField fInput;
  private final JTextField hb36Input;
  private final JTextField eedInput;
  private final JTextField hbatInput;
  private final JTextField uriInput1;
  private final JTextField uriInput2;
  private final JComboBox bg;
  private final JComboBox sb;
  private final JComboBox sbt;
  private final JRadioButton react;
  private final JRadioButton nReact;
  private final JRadioButton pmctYes;
  private final JRadioButton pmctNo;
  private final JRadioButton positive;
  private final JRadioButton negative;
  private final JRadioButton postYes;
  private final JRadioButton postNo;
  private final JRadioButton bloodPresent;
  private final JRadioButton bloodNotPresent;
  private final JRadioButton malePresent;
  private final JRadioButton maleNotPresent;
  private final JComboBox tb;
  private final JComboBox sg;
  private final JComboBox ttb;
  private final JCheckBox iptThree;
  private final JCheckBox iptOne;
  private final JCheckBox iptTwo;
  private final JCheckBox itpOne;
  private final JCheckBox itpTwo;
  private final JCheckBox itpThree;
  private final JRadioButton itnNo;
  private final JRadioButton itnYes;

  /**
   * Fills in the jFrame with all of the field that need to be filled in
   * and adds the to a FlowLayout element.
   * 
   * @param layout
   */
  public NewVisitForm(FlowLayout layout) {
    panel = new JPanel();
    panel.setLayout(layout);
    layout.setHgap(10);

    JLabel parity = new JLabel("Parity: "); //integer
    parInput = new JTextField(2);
    JLabel BloodPressure = new JLabel("Blood Pressure: ");
    bloInput1 = new JTextField(2);//ADD TWO Fields int/int
    JLabel fill = new JLabel("/");
    bloInput2 = new JTextField(2);

    JPanel bloInput = new JPanel();
    bloInput.add(BloodPressure);
    bloInput.add(bloInput1);
    bloInput.add(fill);
    bloInput.add(bloInput2);
    bloInput.setLayout(new FlowLayout());


    JLabel Height = new JLabel("Height: ");//double
    heiInput = new JTextField(3);
    JLabel Weight = new JLabel("Weight: ");//double
    weiInput = new JTextField(3);

    JPanel size = new JPanel();
    size.add(Height);
    size.add(heiInput);
    size.add(new JLabel(" (cm)"));
    size.add(Weight);
    size.add(weiInput);
    size.add(new JLabel(" (kg)"));
    size.setLayout(new GridLayout(2,3));

    //number of weeks pregnant
    JLabel Gestation = new JLabel("Gestation: ");//int
    gesInput = new JTextField(3);//How to Calculate

    //measurement of uterus in CM
    JLabel FHeight = new JLabel("Fundal Height: ");//Double
    fInput = new JTextField(3);
    JPanel FundalHeight = new JPanel();
    FundalHeight.add(FHeight);
    FundalHeight.add(fInput);
    FundalHeight.add(new JLabel(" (cm)"));

    //date baby is due
    JLabel EEDL = new JLabel("Due Date: ");
    eedInput = new JTextField(3); //Determine how we want date entered.
    JPanel EED = new JPanel();
    EED.add(EEDL);
    EED.add(eedInput);
    EED.add(new JLabel("(mm/dd/yyyy)"));

    //test hemoglobin
    JLabel HBatR = new JLabel("HBatReg: ");//Double grams/deciliter
    hbatInput = new JTextField(3);//how to calculate
    JPanel HBatReg = new JPanel();
    HBatReg.add(HBatR);
    HBatReg.add(hbatInput);
    HBatReg.add(new JLabel("(Grams/Deciliter)"));

    // test Hemoglobin @ 36 weeks
    JLabel HBat6 = new JLabel("HBat36: ");//double g/dl
    hb36Input = new JTextField(3);
    JPanel HBat36 = new JPanel();
    HBat36.add(HBat6);
    HBat36.add(hb36Input);
    HBat36.add(new JLabel("(Grams/Deciliter)"));

    //testing for sugar & protein in urine
    JLabel UrineTes = new JLabel("Urine Test: ");//Sugar/Protein- double mmol/L / double mg/dL
    uriInput1 = new JTextField(3);
    uriInput2 = new JTextField(3);
    JPanel UrineTest = new JPanel();
    UrineTest.add(UrineTes);
    UrineTest.add(uriInput1);
    UrineTest.add(new JLabel("/"));
    UrineTest.add(uriInput2);
    UrineTest.add(new JLabel("(Sugar/Protein)"));

    //blood type/group
    JLabel BloodG = new JLabel("Blood Group: ");//String, Drop down with options
    JPanel BloodGroup = new JPanel();
    String[] bt = {" ","O","A","B","AB"};
    bg = new JComboBox(bt);
    BloodGroup.add(BloodG);
    BloodGroup.add(bg);

    //sickle cell anemia testing
    JLabel Sicklin = new JLabel("Sickling: ");//Status/Type string/string (drop down)
    JPanel Sickling = new JPanel();
    String[] ss = {" ","Positive","Negative"};
    sb = new JComboBox(ss);
    String[] st = {" ","N/a","Hemoglobin SS","Hemoglobin SC","Hemoglobin SB+ (Beta) Thalassemia","Beta-Zero Thalassemia"};
    sbt = new JComboBox(st);
    Sickling.add(Sicklin);
    Sickling.add(sb);
    Sickling.add(sbt);

    //veneral disease testing
    JLabel VDLa = new JLabel("VDLab: ");//button group reactive or non-reactive
    JPanel VDLab = new JPanel();
    react = new JRadioButton("Reactive");
    nReact = new JRadioButton("Non-Reactive");
    ButtonGroup r = new ButtonGroup();
    r.add(react);
    r.add(nReact);
    VDLab.add(VDLa);
    VDLab.add(react);
    VDLab.add(nReact);

    //pre VD test consoling
    JLabel PMTC = new JLabel("PMTCT: ");//yes or no
    JPanel PMTCT = new JPanel();
    pmctYes = new JRadioButton("Yes");
    pmctNo = new JRadioButton("No");
    ButtonGroup p = new ButtonGroup();
    p.add(pmctYes);
    p.add(pmctNo);
    PMTCT.add(PMTC);
    PMTCT.add(pmctYes);
    PMTCT.add(pmctNo);

    //VD test result
    JLabel TestResul = new JLabel("Test-Result: ");//positive vs negative
    JPanel TestResult = new JPanel();
    positive = new JRadioButton("Positive");
    negative = new JRadioButton("Negative");
    ButtonGroup t = new ButtonGroup();
    t.add(positive);
    t.add(negative);
    TestResult.add(TestResul);
    TestResult.add(positive);
    TestResult.add(negative);

    //Post VD test counseling
    JLabel PostTes = new JLabel("Post-Test Counseling: ");
    JPanel PostTest = new JPanel();
    postYes = new JRadioButton("Yes");
    postNo= new JRadioButton("No");
    ButtonGroup p1 = new ButtonGroup();
    p1.add(postYes);
    p1.add(postNo);
    PostTest.add(PostTes);
    PostTest.add(postYes);
    PostTest.add(postNo);

    //malaria testing p/np
    JLabel BloodFil = new JLabel("Blood Film: ");//bloodPresent or not bloodPresent
    JPanel BloodFilm = new JPanel();
    bloodPresent = new JRadioButton("Present");
    bloodNotPresent = new JRadioButton("Not-Present");
    ButtonGroup b = new ButtonGroup();
    b.add(bloodPresent);
    b.add(bloodNotPresent);
    BloodFilm.add(BloodFil);
    BloodFilm.add(bloodPresent);
    BloodFilm.add(bloodNotPresent);

    //men involvement y/n
    JLabel MaleInvolve = new JLabel("Male Involvement: ");//bloodPresent or not
    JPanel MaleInvolved = new JPanel();
    malePresent = new JRadioButton("Present");
    maleNotPresent = new JRadioButton("Not-Present");
    ButtonGroup m = new ButtonGroup();
    m.add(malePresent);
    m.add(maleNotPresent);
    MaleInvolved.add(MaleInvolve);
    MaleInvolved.add(malePresent);
    MaleInvolved.add(maleNotPresent);

    //what trimester they are at
    JLabel Trimeste = new JLabel("Trimester: ");//int 1-3
    JPanel Trimester = new JPanel();
    String[] tr = {" ","1","2","3"};
    tb = new JComboBox(tr);
    Trimester.add(Trimeste);
    Trimester.add(tb);

    //sub visits
    JLabel SV = new JLabel("Subsequent Visits: ");//int 2-12
    JPanel Sub = new JPanel();
    String[] sr = {" ","2","3","4","5","6","7","8","9","10","11","12"};
    sg = new JComboBox(sr);
    Sub.add(SV);
    Sub.add(sg);

    //Tetanus shot give,boster, & protected
    JLabel TTl = new JLabel("TT: ");//given, booster, protected
    JPanel TT = new JPanel();
    String[] ttr = {" ","given","booster","protected"};
    ttb = new JComboBox(ttr);
    TT.add(TTl);
    TT.add(ttb);

    //ipt/doses
    JLabel IPTl = new JLabel("IPT: ");//check 1,2, or 3 doses
    JPanel IPT = new JPanel();
    iptOne = new JCheckBox("1");
    iptTwo = new JCheckBox("2");
    iptThree = new JCheckBox("3");
    ButtonGroup ipt = new ButtonGroup();
    ipt.add(iptOne);
    ipt.add(iptTwo);
    ipt.add(iptThree);
    IPT.add(IPTl);
    IPT.add(iptOne);
    IPT.add(iptTwo);
    IPT.add(iptThree);
    IPT.add(new JLabel(" Doses"));

    //ITP doses
    JLabel ITPl = new JLabel("ITP: ");//3 doses tick for each
    JPanel ITP = new JPanel();
    itpOne = new JCheckBox("1");
    itpTwo = new JCheckBox("2");
    itpThree = new JCheckBox("3");
    ButtonGroup itp = new ButtonGroup();
    itp.add(itpOne);
    itp.add(itpTwo);
    itp.add(itpThree);
    ITP.add(ITPl);
    ITP.add(itpOne);
    ITP.add(itpTwo);
    ITP.add(itpThree);
    ITP.add(new JLabel(" Doses"));

    //stuff of ITN
    JLabel ITNl = new JLabel("ITN: ");//Yes or no
    JPanel ITN = new JPanel();
    itnYes = new JRadioButton("Yes");
    itnNo= new JRadioButton("No");
    ButtonGroup p2 = new ButtonGroup();
    p2.add(itnYes);
    p2.add(itnNo);
    ITN.add(ITNl);
    ITN.add(itnYes);
    ITN.add(itnNo);

    //add data to frame
    panel.add(parity);
    panel.add(parInput);
    panel.add(bloInput);
    panel.add(size);
    panel.add(Gestation);
    panel.add(gesInput);
    panel.add(FundalHeight);
    panel.add(EED);
    panel.add(HBatReg);
    panel.add(HBat36);
    panel.add(UrineTest);
    panel.add(BloodGroup);
    panel.add(Sickling);
    panel.add(VDLab);
    panel.add(PMTCT);
    panel.add(TestResult);
    panel.add(PostTest);
    panel.add(BloodFilm);
    panel.add(MaleInvolved);
    panel.add(Trimester);
    panel.add(Sub);
    panel.add(TT);
    panel.add(IPT);
    panel.add(ITP);
    panel.add(ITN);
  }

  /**
   * 
   * @return the JPanel created
   */
  public JPanel getPanel() {
    return panel;
  }

  /**
   * 
   * @return String of the parity field 
   */
  public String getParity() {
    return parInput.getText();
  }

  /**
   * 
   * @return returns 1 if the test results are "positive" or -1 for "negative". 
   * 0 is returned if neither are selected
   */
  public Integer getTestResult() {
    if (positive.isSelected()) return 1;
    if (negative.isSelected()) return -1;
    return 0;
  }

  /**
   * 
   * @return Returns string of the patients height
   */
  public String getPatientHeight() {
    return heiInput.getText();
  }

  /**
   * 
   * @return Returns string of the patients weight
   */
  public String getPatientWeight() {
    return weiInput.getText();
  }
}