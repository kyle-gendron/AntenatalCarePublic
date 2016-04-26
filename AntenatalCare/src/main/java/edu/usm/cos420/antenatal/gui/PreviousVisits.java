package edu.usm.cos420.antenatal.gui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by aaron on 3/11/2016.
 */
public class PreviousVisits {

  private Component frame;

  public PreviousVisits(Container frame) {
    this.frame = frame;
  }

  /**
   * Shows the Find Previous Visits dialog with a set of options.
   *
   * @param options a list of menu options.
   * @return the selected item as a string.
   */
  public String showDialog(List<String> options) {
    // Add an empty option to the beginning of the list.
    options.add(0, "");

    return (String) JOptionPane.showInputDialog(
      frame,
      "Please pick a previous visit to load:\n",
      "Find Previous Visit",
      JOptionPane.PLAIN_MESSAGE,
      null,
      options.toArray(),
      null);
  }
}
