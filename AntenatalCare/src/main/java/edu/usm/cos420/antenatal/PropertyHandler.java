package edu.usm.cos420.antenatal;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by aaron on 4/25/2016.
 */
public class PropertyHandler {
  private static PropertyHandler instance = null;
  private static Properties props;

  private PropertyHandler() {
    try {
      props = new Properties();
      InputStream in = PropertyHandler.class.getClassLoader().getResourceAsStream("config.properties");
      props.load(in);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static synchronized PropertyHandler getInstance() {
    if (instance == null) {
      instance = new PropertyHandler();
    }
    return instance;
  }

  public Properties getProps() {
    return props;
  }

  public void setPort(int port) {
    props.setProperty("local.port", String.valueOf(port));
  }
}
