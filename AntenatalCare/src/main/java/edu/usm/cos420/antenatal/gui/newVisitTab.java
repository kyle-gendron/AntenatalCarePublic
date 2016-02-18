package edu.usm.cos420.antenatal.gui;

import java.awt.BorderLayout;

import javax.swing.*;

public class newVisitTab extends JPanel {
	JTabbedPane tabbedPane;
	JPanel firstPanel;
	JLabel firstLabel;
	public newVisitTab(){
		tabbedPane = new JTabbedPane();
		firstPanel = new JPanel();
		firstLabel = new JLabel("NEW VISIT");
		
		tabbedPane.addTab("New Visit", firstPanel);	
		
		
		firstPanel.add(firstLabel);
		setLayout(new BorderLayout());
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		
		add(tabbedPane, BorderLayout.CENTER);
	}
}
