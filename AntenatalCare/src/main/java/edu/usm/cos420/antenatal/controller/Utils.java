package edu.usm.cos420.antenatal.controller;

/**
 * Created by aaron on 3/11/2016.
 */
public class Utils {
  public static int parseInteger( String string, int defaultValue ) {
    try {
      return Integer.parseInt(string);
    }
    catch (NumberFormatException e ) {
      return defaultValue;
    }
  }

  public static double parseDouble( String string, double defaultValue ) {
    try {
      return Double.parseDouble(string);
    }
    catch (NumberFormatException e ) {
      return defaultValue;
    }
  }
}
