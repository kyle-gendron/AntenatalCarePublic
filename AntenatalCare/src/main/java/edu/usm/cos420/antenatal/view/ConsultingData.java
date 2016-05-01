package edu.usm.cos420.antenatal.view;

import edu.usm.cos420.antenatal.domain.interfaces.IPerson;

import javax.swing.*;
import java.awt.*;

public class ConsultingData extends JPanel{
	private IPerson p;
	private JPanel hold;
	private JPanel jTab;
	public ConsultingData(){
		hold = new JPanel();
		jTab = new JPanel();

	}
	/**
	 * Creates a consulting tab with the consulting data of a person
	 * this currently uses a DummyPerson class
	 *
	 * @param p the person that is currently selected
	 * @return the new Jtab with the consulting data
	 */
	public JPanel getPanel(IPerson p){
		this.p=p;
		setLayout(new BorderLayout());
		jTab= getConsultingInfo();
		return jTab;

	}
	/**
	 * Creates the panel to put the consulting info in the panel
	 * @return returns the filled in panel
	 */
	private JPanel getConsultingInfo() {
		JPanel data = new JPanel();
		GridLayout layout = new GridLayout(6,2);
		layout.setHgap(20);
		data.setLayout(layout);


		/////////////////////////////////////////////////////List of variables coming in from consulting registry
		JLabel Facility = new JLabel("Facility: ");
		JTextField facInput = new JTextField(10);
		facInput.setText(p.getFacZone());
		facInput.setEnabled(false);


		JLabel SubDistrict = new JLabel("SubDistrict: ");
		JTextField subInput = new JTextField(10);
		subInput.setText(p.getSubDistrict());
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

		JLabel name = new JLabel("Name: ");
		JTextField nameText = new JTextField(10);
		nameText.setText(p.getName());
		nameText.setEnabled(false);


		JLabel Location = new JLabel("Community: ");
		JTextField locInput = new JTextField(10);
		locInput.setText("n/a");
		locInput.setEnabled(false);


		JLabel HouseNumber = new JLabel("House Number: ");
		JTextField hNumInput = new JTextField(3);
		hNumInput.setText("n/a");
		hNumInput.setEnabled(false);


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
		data.add(name);
		data.add(nameText);



		data.add(Location);
		data.add(locInput);
		data.add(Age);
		data.add(ageInput);
		data.add(HouseNumber);
		data.add(hNumInput);

		data.setMinimumSize(new Dimension(600,125));
		hold.add(data);

		FlowLayout flow = new FlowLayout();
		hold.setLayout(flow);
		flow.setHgap(30);

		return hold;


	}
}
