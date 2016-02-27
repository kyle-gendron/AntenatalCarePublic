package edu.usm.cos420.antenatal.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import edu.usm.cos420.antenatal.domain.DummyPerson;
import edu.usm.cos420.antenatal.view.impl.AntenatalView;

public class newVisitTab extends JPanel {
	
	DummyPerson p;//REPLACE
	JTabbedPane tabbedPane;
	private JPanel newEntry;
	public newVisitTab(DummyPerson p){
		this.p = p;
		
		tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		
		
		newEntry = new JPanel();
		
		newEntry = getNewInfo();
		
		tabbedPane.addTab("Antenatal Care Input", newEntry);
		
	}
	public JPanel getPanel(){
		JPanel data = new JPanel();
		data.setLayout(new BorderLayout());
		data.add(tabbedPane, BorderLayout.CENTER);
		data.add(bottomButtons(),BorderLayout.SOUTH);
		data.setMinimumSize(new Dimension(600,400));
		
		return data;
	}
	private JPanel getNewInfo() {
		JPanel data = new JPanel();
		FlowLayout layout = new FlowLayout();
		data.setLayout(layout);
		layout.setHgap(10);
		
		JLabel Parity = new JLabel("Parity: ");//integer
		JTextField parInput = new JTextField(2);
		
		
		JLabel BloodPressure = new JLabel("Blood Pressure: ");
		JTextField bloInput1 = new JTextField(2);//ADD TWO Fields int/int
		JLabel fill = new JLabel("/");
		JTextField bloInput2 = new JTextField(2);
		
		JPanel bloInput = new JPanel();
		bloInput.add(BloodPressure);
		bloInput.add(bloInput1);
		bloInput.add(fill);
		bloInput.add(bloInput2);
		bloInput.setLayout(new FlowLayout());
		
		
		JLabel Height = new JLabel("Height: ");//double
		JTextField heiInput = new JTextField(3);
		JLabel Weight = new JLabel("Weight: ");//double
		JTextField weiInput = new JTextField(3);
		
		JPanel size = new JPanel();
		size.add(Height);
		size.add(heiInput);
		size.add(new JLabel(" (cm)"));
		size.add(Weight);
		size.add(weiInput);
		size.add(new JLabel(" (kg)"));
		size.setLayout(new GridLayout(2,3));

		JLabel Gestation = new JLabel("Gestation: ");//int
		JTextField gesInput = new JTextField(3);//How to Calulate
		
		JLabel FHeight = new JLabel("Fundal Height: ");//Double
		JTextField fInput = new JTextField(3);
		JPanel FundalHeight = new JPanel();
		FundalHeight.add(FHeight);
		FundalHeight.add(fInput);
		FundalHeight.add(new JLabel(" (cm)"));
		
		JLabel EEDL = new JLabel("Expectation Date: ");
		JTextField eedInput = new JTextField(3); //Determine how we want date entered.
		JPanel EED = new JPanel();
		EED.add(EEDL);
		EED.add(eedInput);
		EED.add(new JLabel("(mm/dd/yyyy)"));
		
		JLabel HBatR = new JLabel("HBatReg: ");//Double grams/decileter
		JTextField hbatInput = new JTextField(3);//how to calculate
		JPanel HBatReg = new JPanel();
		HBatReg.add(HBatR);
		HBatReg.add(hbatInput);
		HBatReg.add(new JLabel("(Grams/Decileter)"));
		
		JLabel HBat6 = new JLabel("HBat36: ");//double g/dl
		JTextField hb36Input = new JTextField(3);
		JPanel HBat36 = new JPanel();
		HBat36.add(HBat6);
		HBat36.add(hb36Input);
		HBat36.add(new JLabel("(Grams/Decileter)"));
		
		JLabel UrineTes = new JLabel("Urine Test: ");//Sugar/Protein- double mmol/L / double mg/dL
		JTextField uriInput1 = new JTextField(3);
		JTextField uriInput2 = new JTextField(3);
		JPanel UrineTest = new JPanel();
		UrineTest.add(UrineTes);
		UrineTest.add(uriInput1);
		UrineTest.add(new JLabel("/"));
		UrineTest.add(uriInput2);
		UrineTest.add(new JLabel("(Sugar/Protein)"));
		
		JLabel BloodG = new JLabel("Blood Group: ");//String, Drop down with options
		JPanel BloodGroup = new JPanel();
		String[] bt = {" ","O","A","B","AB"};
		JComboBox bg = new JComboBox(bt);
		BloodGroup.add(BloodG);
		BloodGroup.add(bg);
		
		
		JLabel Sicklin = new JLabel("Sickling: ");//Status/Type string/string (drop down)
		JPanel Sickling = new JPanel();
		String[] ss = {" ","Positive","Negative"};
		JComboBox sb = new JComboBox(ss);
		String[] st = {"N/a","Hemoglobin SS","Hemoglobin SC","Hemoglobin SB+ (Beta) Thalassemia","Beta-Zero Thalassemia"};
		JComboBox sbt = new JComboBox(st);
		Sickling.add(Sicklin);
		Sickling.add(sb);
		Sickling.add(sbt);
		
		JLabel VDLa = new JLabel("VDLab: ");//button group reactive or non-reactive
		JPanel VDLab = new JPanel();
		JRadioButton react = new JRadioButton("Reactive");
		JRadioButton nReact = new JRadioButton("Non-Reactive");
		ButtonGroup r = new ButtonGroup();
		r.add(react);
		r.add(nReact);
		VDLab.add(VDLa);
		VDLab.add(react);
		VDLab.add(nReact);
		
		
		JLabel PMTC = new JLabel("PMTCT: ");//yes or no
		JPanel PMTCT = new JPanel();
		JRadioButton yes = new JRadioButton("Yes");
		JRadioButton no= new JRadioButton("No");
		ButtonGroup p = new ButtonGroup();
		p.add(yes);
		p.add(no);
		PMTCT.add(PMTC);
		PMTCT.add(yes);
		PMTCT.add(no);
		
		JLabel TestResul = new JLabel("Test-Result: ");//positive vs negative
		JPanel TestResult = new JPanel();
		JRadioButton positive = new JRadioButton("Positive");
		JRadioButton negative = new JRadioButton("Negative");
		ButtonGroup t = new ButtonGroup();
		t.add(positive);
		t.add(negative);
		TestResult.add(TestResul);
		TestResult.add(positive);
		TestResult.add(negative);
		
		JLabel PostTes = new JLabel("Post-Test Counseling: ");
		JPanel PostTest = new JPanel();
		JRadioButton yes1 = new JRadioButton("Yes");
		JRadioButton no1= new JRadioButton("No");
		ButtonGroup p1 = new ButtonGroup();
		p1.add(yes1);
		p1.add(no1);
		PostTest.add(PostTes);
		PostTest.add(yes1);
		PostTest.add(no1);
		
		JLabel BloodFil = new JLabel("Blood Film: ");//present or not present
		JPanel BloodFilm = new JPanel();
		JRadioButton present = new JRadioButton("Present");
		JRadioButton nPresent = new JRadioButton("Not-Present");
		ButtonGroup b = new ButtonGroup();
		b.add(present);
		b.add(nPresent);
		BloodFilm.add(BloodFil);
		BloodFilm.add(present);
		BloodFilm.add(nPresent);
		
		JLabel MaleInvolve = new JLabel("Male Involvement: ");//present or not
		JPanel MaleInvolved = new JPanel();
		JRadioButton present1 = new JRadioButton("Present");
		JRadioButton nPresent1 = new JRadioButton("Not-Present");
		ButtonGroup m = new ButtonGroup();
		m.add(present1);
		m.add(nPresent1);
		MaleInvolved.add(MaleInvolve);
		MaleInvolved.add(present1);
		MaleInvolved.add(nPresent1);
		
		JLabel Trimeste = new JLabel("Trimester: ");//int 1-3
		JPanel Trimester = new JPanel();
		String[] tr = {" ","1","2","3"};
		JComboBox tb = new JComboBox(tr);
		Trimester.add(Trimeste);
		Trimester.add(tb);
		
		JLabel SV = new JLabel("Subsequent Visits: ");//int 2-12
		JPanel Sub = new JPanel();
		String[] sr = {" ","2","3","4","5","6","7","8","9","10","11","12"};
		JComboBox sg = new JComboBox(sr);
		Sub.add(SV);
		Sub.add(sg);
		
		JLabel TTl = new JLabel("TT: ");//given, boster, protected
		JPanel TT = new JPanel();
		String[] ttr = {" ","given","booster","protected"};
		JComboBox ttb = new JComboBox(ttr);
		TT.add(TTl);
		TT.add(ttb);
		
		JLabel IPTl = new JLabel("IPT: ");//check 1,2, or 3 doses
		JPanel IPT = new JPanel();
		JCheckBox one = new JCheckBox("1");
		JCheckBox two = new JCheckBox("2");
		JCheckBox three = new JCheckBox("3");
		ButtonGroup ipt = new ButtonGroup();
		ipt.add(one);
		ipt.add(two);
		ipt.add(three);
		IPT.add(IPTl);
		IPT.add(one);
		IPT.add(two);
		IPT.add(three);
		IPT.add(new JLabel(" Doses"));
		//doses
		
		JLabel ITPl = new JLabel("ITP: ");//3 doses tick for each
		JPanel ITP = new JPanel();
		JCheckBox one1 = new JCheckBox("1");
		JCheckBox two1 = new JCheckBox("2");
		JCheckBox three1 = new JCheckBox("3");
		ButtonGroup itp = new ButtonGroup();
		itp.add(one1);
		itp.add(two1);
		itp.add(three1);
		ITP.add(ITPl);
		ITP.add(one1);
		ITP.add(two1);
		ITP.add(three1);
		ITP.add(new JLabel(" Doses"));
		
		JLabel ITNl = new JLabel("ITN: ");//Yes or no
		JPanel ITN = new JPanel();
		JRadioButton yes2 = new JRadioButton("Yes");
		JRadioButton no2= new JRadioButton("No");
		ButtonGroup p2 = new ButtonGroup();
		p2.add(yes2);
		p2.add(no2);
		ITN.add(ITNl);
		ITN.add(yes2);
		ITN.add(no2);
		
		
		
		data.add(Parity);
		data.add(parInput);
		data.add(bloInput);
		data.add(size);
		data.add(Gestation);
		data.add(gesInput);
		data.add(FundalHeight);
		data.add(EED);
		data.add(HBatReg);
		data.add(HBat36);
		data.add(UrineTest);
		data.add(BloodGroup);
		data.add(Sickling);
		data.add(VDLab);
		data.add(PMTCT);
		data.add(TestResult);
		data.add(PostTest);
		data.add(BloodFilm);
		data.add(MaleInvolved);
		data.add(Trimester);
		data.add(Sub);
		data.add(TT);
		data.add(IPT);
		data.add(ITP);
		data.add(ITN);
		return data;
	}	

	private JPanel bottomButtons(){
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout());


		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(l -> System.exit(1));
		JButton submit = new JButton("Submit");
		submit.addActionListener(arg0 -> AntenatalView.removeTab(getTitle()));
		newEntry.add(submit);

		buttonPane.add(quitButton);
		buttonPane.add(submit);
		return buttonPane;
	}
	public String getTitle() {
		
		return p.getDate().toString();
	}
}
