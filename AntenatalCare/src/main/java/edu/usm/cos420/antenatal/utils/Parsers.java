package edu.usm.cos420.antenatal.utils;

/**
 * Created by aaron on 3/11/2016.
 */
public class Parsers {
  public static int parseInteger(String string, int defaultValue) {
    try {
      return Integer.parseInt(string);
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }

  public static double parseDouble(String string, double defaultValue) {
    try {
      return Double.parseDouble(string);
    } catch (NumberFormatException e) {
      return defaultValue;
    }
  }

  public static int parseInteger(String string) {
    return parseInteger(string, 0);
  }

  public static double parseDouble(String string) {
    return parseDouble(string, 0.0);
  }
}
