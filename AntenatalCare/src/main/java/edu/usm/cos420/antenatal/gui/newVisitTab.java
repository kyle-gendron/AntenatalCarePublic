package edu.usm.cos420.antenatal.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class newVisitTab extends JPanel {
	JTabbedPane tabbedPane;
	JPanel firstPanel;
	JLabel firstLabel;
	public newVisitTab(){
		firstPanel = new JPanel();
		
		firstPanel.setLayout(new FlowLayout());
		
		tabbedPane = new JTabbedPane();
		
		firstLabel = new JLabel("Name:");
		firstPanel.add(firstLabel);
		
		JTextField firstText = new JTextField(10);
		firstPanel.add(firstText);
		
		JButton submit = new JButton("Submit");
		firstPanel.add(submit);
		submit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
				
			}
			
		});
		
		setLayout(new BorderLayout());
		tabbedPane.addTab("New Visit", firstPanel);	
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		
		add(tabbedPane, BorderLayout.CENTER);
	}
}
