package edu.usm.cos420.antenatal.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

import edu.usm.cos420.antenatal.controller.AntenatalController;
import edu.usm.cos420.antenatal.domain.DummyPerson;
import edu.usm.cos420.antenatal.view.impl.AntenatalView;

public class newVisitTab extends JPanel {

	DummyPerson p;//REPLACE
	JTabbedPane tabbedPane;
	private NewVisitForm form;
  private JButton submitButton;

  public newVisitTab(DummyPerson p, AntenatalController controller){
		this.p = p;

		tabbedPane = new JTabbedPane();
		tabbedPane.setTabPlacement(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);

    FlowLayout layout = new FlowLayout();
    form = new NewVisitForm(layout);

    submitButton = new JButton("Submit");
    submitButton.addActionListener(controller);

		tabbedPane.addTab("Antenatal Care Input", form.getPanel());

	}
	public JPanel getPanel(){
		JPanel data = new JPanel();
		data.setLayout(new BorderLayout());
		data.add(tabbedPane, BorderLayout.CENTER);
		data.add(bottomButtons(),BorderLayout.SOUTH);
		data.setMinimumSize(new Dimension(600,400));

		return data;
	}

	private JPanel bottomButtons(){
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout());


		JButton quitButton = new JButton("Quit");
		quitButton.addActionListener(l -> System.exit(1));

		this.submitButton.addActionListener(arg0 -> AntenatalView.removeCurrentTab());

		buttonPane.add(quitButton);
		buttonPane.add(submitButton);
		return buttonPane;
	}
	public String getTitle() {

		return p.getDate().toString();
	}

  public NewVisitForm getForm() {
    return form;
  }
}
