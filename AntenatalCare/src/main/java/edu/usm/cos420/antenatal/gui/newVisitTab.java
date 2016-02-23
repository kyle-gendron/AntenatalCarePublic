package edu.usm.cos420.antenatal.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class newVisitTab extends JPanel {
	String NAME = "Ross"; //REPLACE WITH PERSON OBJECT NAME.
	JTabbedPane tabbedPane;
	JPanel oldEntry,newEntry;
	public newVisitTab(){
		
		getConsultingInfo();
		getNewInfo();
		
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, oldEntry, newEntry);
		splitPane.setResizeWeight(0.25);
		
		tabbedPane = new JTabbedPane();
		setLayout(new BorderLayout());
		tabbedPane.addTab("New Visit", splitPane);	
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		
		add(tabbedPane, BorderLayout.CENTER);
	}
	private void getNewInfo() {
		newEntry = new JPanel();
		JTextField nameText = new JTextField(10);
		newEntry.add(nameText);
		
		JButton submit = new JButton("Submit");
		newEntry.add(submit);
		
		submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
				
			}
		});
		
	}
	private void getConsultingInfo() {
		oldEntry = new JPanel();
		JLabel name = new JLabel("Name: "+NAME);
		oldEntry.add(name);
	}
}
