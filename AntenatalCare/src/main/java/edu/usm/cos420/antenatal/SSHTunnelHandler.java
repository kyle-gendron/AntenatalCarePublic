package edu.usm.cos420.antenatal;


import com.jcraft.jsch.JSchException;
import edu.usm.cos420.antenatal.utils.SSHTunnel;

/**
 * Created by aaron on 4/25/2016.
 */
public class SSHTunnelHandler {
  private static SSHTunnelHandler instance = null;
  private static SSHTunnel tunnel = null;
  private int port = -1;

  private SSHTunnelHandler() {
    tunnel = new SSHTunnel(PropertyHandler.getInstance().getProps());
    try {
      port = tunnel.doSshTunnel();
    } catch (JSchException e) {
      e.printStackTrace();
    }
  }

  public static SSHTunnelHandler getInstance() {
    if (instance == null) {
      instance = new SSHTunnelHandler();
    }
    return instance;
  }

  public SSHTunnel getTunnel() {
    return tunnel;
  }

  public int getPort() {
    return port;
  }
}
