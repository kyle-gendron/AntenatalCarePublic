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
	
	private String NAME = "Ross"; //REPLACE WITH PERSON OBJECT NAME.
	DummyPerson p;//REPLACE
	JTabbedPane tabbedPane;
	private JPanel oldEntry ,newEntry;
	public newVisitTab(){
		p = new DummyPerson();//REPLACE WITH DAO OBJECT OF PERSON
		NAME = p.getName();
		
		tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		setLayout(new BorderLayout());
		
		
		oldEntry = new JPanel();
		newEntry = new JPanel();
		
		
		getConsultingInfo();
		getNewInfo();
		JTabbedPane newTab = new JTabbedPane();
		newTab.setTabPlacement(JTabbedPane.TOP);
		newTab.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);

		newTab.addTab("Antenatal Care Input", newEntry);
		
		oldEntry.setMinimumSize(new Dimension(400,160));
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, oldEntry, newTab);
		splitPane.setResizeWeight(0.30);	
		splitPane.setDividerLocation(160);

		tabbedPane.addTab("Consulting Registry", splitPane);	

		add(putNameAtTop(), BorderLayout.NORTH);
		add(tabbedPane, BorderLayout.CENTER);
		add(bottomButtons(),BorderLayout.SOUTH);
	}
	private void getNewInfo() {




	}

	private JPanel putNameAtTop(){
		JPanel nameTop = new JPanel();
		JLabel name = new JLabel("Name: ");
		JTextField nameText = new JTextField(10);
		nameText.setText(NAME);
		nameText.setEnabled(false);
		nameTop.setLayout(new FlowLayout());
		nameTop.add(name);
		nameTop.add(nameText);
		return nameTop;
	}

	private void getConsultingInfo() {
		JPanel data = new JPanel();
		GridLayout layout = new GridLayout(5,2);
		layout.setHgap(20);
		data.setLayout(layout);
		
		
/////////////////////////////////////////////////////List of variables coming in from consulting registry
		JLabel Facility = new JLabel("Facility: ");
		JTextField facInput = new JTextField(10);
		facInput.setText(p.getFacZone());
		facInput.setEnabled(false);
		
		
		JLabel SubDistrict = new JLabel("SubDistrict: ");
		JTextField subInput = new JTextField(10);
		subInput.setText(p.getSubdistrict());
		subInput.setEnabled(false);
		
		
		JLabel District = new JLabel("District: ");
		JTextField disInput = new JTextField(10);
		disInput.setText(p.getDistrict());
		disInput.setEnabled(false);
		
		
		JLabel Year = new JLabel("Year: ");
		JTextField yearInput = new JTextField(4);
		yearInput.setText(p.getYear());
		yearInput.setEnabled(false);
		
		
		JLabel SerialNumber = new JLabel("Serial Number: ");
		JTextField serInput = new JTextField(10);
		serInput.setText(""+p.getSerialNumber());
		serInput.setEnabled(false);
		
		
		JLabel Date = new JLabel("Date: ");
		JTextField datInput = new JTextField(10);
		datInput.setText(""+p.getDate());
		datInput.setEnabled(false);
		
		
		JLabel RegNumber = new JLabel("Registration Number: ");
		JTextField regInput = new JTextField(10);
		regInput.setText(""+p.getRegNumber());
		regInput.setEnabled(false);
		
		
		JLabel HININumber = new JLabel("HI/NI Number: ");
		JTextField HINIInput = new JTextField(10);
		HINIInput.setText(p.getHININumber()+"");
		HINIInput.setEnabled(false);
		
		
		JLabel Age = new JLabel("Age: ");
		JTextField ageInput = new JTextField(3);
		ageInput.setText(p.getAge()+"");
		ageInput.setEnabled(false);
		
/////////////////////////////////////////Seperate Panel for these data inputs
		JPanel address = new JPanel();
		address.setLayout(new GridLayout(2,2));

		JLabel Location = new JLabel("Community: ");
		JTextField locInput = new JTextField(10);
		locInput.setText("n/a");
		locInput.setEnabled(false);
		
		
		JLabel HouseNumber = new JLabel("House Number: ");
		JTextField hnumInput = new JTextField(3);
		hnumInput.setText("n/a");
		hnumInput.setEnabled(false);
		
		
		address.add(Location);
		address.add(locInput);
		address.add(HouseNumber);
		address.add(hnumInput);
		
		data.add(Facility);
		data.add(facInput);
		data.add(SubDistrict);
		data.add(subInput);
		data.add(District);
		data.add(disInput);
		data.add(Year);
		data.add(yearInput);
		data.add(SerialNumber);
		data.add(serInput);
		data.add(Date);
		data.add(datInput);
		data.add(RegNumber);
		data.add(regInput);
		data.add(HININumber);
		data.add(HINIInput);
		data.add(Age);
		data.add(ageInput);
		
		oldEntry.add(data);
		oldEntry.add(address);
		
		FlowLayout flow = new FlowLayout();
		oldEntry.setLayout(flow);
		flow.setHgap(30);


	}

	private JPanel bottomButtons(){
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout());


		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(l -> System.exit(1));
		JButton submit = new JButton("Submit");
		newEntry.add(submit);

		submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		buttonPane.add(quitButton);
		buttonPane.add(submit);
		return buttonPane;
	}
	public String getTitle() {
		
		return NAME;
	}
}
