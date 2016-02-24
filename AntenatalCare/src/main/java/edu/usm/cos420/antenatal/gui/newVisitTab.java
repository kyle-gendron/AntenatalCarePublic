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
		
		getNewInfo();
		
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
