package edu.usm.cos420.antenatal.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class newVisitTab extends JPanel {
	String NAME = "Ross"; //REPLACE WITH PERSON OBJECT NAME.
	JTabbedPane tabbedPane;
	private JPanel oldEntry ,newEntry;
	public newVisitTab(){
		oldEntry = new JPanel();
		newEntry = new JPanel();

		getConsultingInfo();
		getNewInfo();

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, oldEntry, newEntry);
		splitPane.setResizeWeight(0.30);	
		oldEntry.setMinimumSize(new Dimension(400,160));

		tabbedPane = new JTabbedPane();
		setLayout(new BorderLayout());
		tabbedPane.addTab("Consulting Registry", splitPane);	

		tabbedPane.setTabPlacement(JTabbedPane.TOP);

		tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);

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
		
		

		JLabel Facility = new JLabel("Facility: ");
		JTextField facInput = new JTextField(10);
		JLabel SubDistrict = new JLabel("SubDistrict: ");
		JTextField subInput = new JTextField(10);
		JLabel District = new JLabel("District: ");
		JTextField disInput = new JTextField(10);
		JLabel Year = new JLabel("Year: ");
		JTextField yearInput = new JTextField(4);
		JLabel SerialNumber = new JLabel("Serial Number: ");
		JTextField serInput = new JTextField(10);
		JLabel Date = new JLabel("Date: ");
		JTextField datInput = new JTextField(10);
		JLabel RegNumber = new JLabel("Registration Number: ");
		JTextField regInput = new JTextField(10);
		JLabel HININumber = new JLabel("HI/NI Number: ");
		JTextField HINIInput = new JTextField(10);
		JLabel Age = new JLabel("Age: ");
		JTextField ageInput = new JTextField(3);

		JPanel address = new JPanel();
		address.setLayout(new GridLayout(2,2));

		JLabel Location = new JLabel("Community: ");
		JTextField locInput = new JTextField(10);
		JLabel HouseNumber = new JLabel("House Number: ");
		JTextField hnumInput = new JTextField(3);
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
				System.exit(1);//MAKE IT SUBMIT

			}
		});
		buttonPane.add(quitButton);
		buttonPane.add(submit);
		return buttonPane;
	}
}
