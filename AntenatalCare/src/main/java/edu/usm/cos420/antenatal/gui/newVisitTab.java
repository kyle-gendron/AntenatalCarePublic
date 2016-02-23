package edu.usm.cos420.antenatal.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
		splitPane.setResizeWeight(0.25);
		
		
		JPanel buttonPane = bottomButtons();
		
		
		tabbedPane = new JTabbedPane();
		setLayout(new BorderLayout());
		tabbedPane.addTab("New Visit", splitPane);	
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
		
		tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		
		add(tabbedPane, BorderLayout.CENTER);
		add(buttonPane,BorderLayout.SOUTH);
	}
	private void getNewInfo() {
		
		JTextField firstText = new JTextField(10);
		newEntry.add(firstText);
		
		
		
	}
	
	private void getConsultingInfo() {
		
		JLabel name = new JLabel("Name: ");
		JTextField nameText = new JTextField(10);
		nameText.setText(NAME);
		nameText.setEnabled(false);
		oldEntry.add(name);
		oldEntry.add(nameText);
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
