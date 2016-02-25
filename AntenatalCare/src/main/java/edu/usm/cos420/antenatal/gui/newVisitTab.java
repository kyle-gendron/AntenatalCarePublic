package edu.usm.cos420.antenatal.gui;

import java.awt.BorderLayout;
import java.awt.Container;
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
		JTextField uriInput = new JTextField(3);
		JPanel UrineTest = new JPanel();
		UrineTest.add(UrineTes);
		UrineTest.add(uriInput);
		UrineTest.add(new JLabel("(Sugar/Protein)"));
		
		JLabel BloodGroup = new JLabel("Blood Group: ");//String, Drop down with options
		JTextField blgInput = new JTextField(3);
		
		JLabel Sickling = new JLabel("Sickling: ");//Status/Type string/string (drop down)
		JTextField sicInput = new JTextField(3);
		
		JLabel VDLab = new JLabel("VDLab: ");//button group reactive or non-reactive
		JTextField vdlInput = new JTextField(3);
		
		JLabel PMTCT = new JLabel("PMTCT: ");//yes or no
		JTextField pmtInput = new JTextField(3);
		
		JLabel TestResult = new JLabel("Test-Result: ");//positive vs negative
		JTextField testInput = new JTextField(3);
		
		JLabel PostTest = new JLabel("Post-Test Counseling: ");
		JTextField posInput = new JTextField(3);
		
		JLabel BloodFilm = new JLabel("Blood Film: ");//present or not present
		JTextField blfInput = new JTextField(3);
		
		JLabel MaleInvolved = new JLabel("Male Involvement: ");//present or not
		JTextField malInput = new JTextField(3);
		
		JLabel Trimester = new JLabel("Trimester: ");//int 1-3
		JTextField triInput = new JTextField(3);
		
		JLabel SubsequentVisits = new JLabel("Subsequent Visits: ");//int 2-12
		JTextField subInput = new JTextField(3);
		
		JLabel TT = new JLabel("TT: ");//given, boster, protected
		JTextField ttInput = new JTextField(3);
		
		JLabel IPT = new JLabel("IPT: ");//check 1,2, or 3 doses
		JTextField iptInput = new JTextField(3);
		//doses
		
		JLabel ITP = new JLabel("ITP: ");//3 doses tick for each
		JTextField itpInput = new JTextField(3);
		
		JLabel ITN = new JLabel("ITN: ");//Yes or no
		JTextField itnInput = new JTextField(3);
		
		
		
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
		data.add(blgInput);
		data.add(Sickling);
		data.add(sicInput);
		data.add(VDLab);
		data.add(vdlInput);
		data.add(PMTCT);
		data.add(pmtInput);
		data.add(TestResult);
		data.add(testInput);
		data.add(PostTest);
		data.add(posInput);
		data.add(BloodFilm);
		data.add(blfInput);
		data.add(MaleInvolved);
		data.add(malInput);
		data.add(Trimester);
		data.add(triInput);
		data.add(SubsequentVisits);
		data.add(subInput);
		data.add(TT);
		data.add(ttInput);
		data.add(IPT);
		data.add(iptInput);
		data.add(ITP);
		data.add(itpInput);
		data.add(ITN);
		data.add(itnInput);
		return data;
	}	

	private JPanel bottomButtons(){
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout());


		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(l -> System.exit(1));
		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AntenatalView.removeTab(getTitle());
			}
		});
		newEntry.add(submit);

		buttonPane.add(quitButton);
		buttonPane.add(submit);
		return buttonPane;
	}
	public String getTitle() {
		
		return p.getDate().toString();
	}
}
