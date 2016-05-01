package edu.usm.cos420.antenatal.utils;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.util.Properties;

public class SSHTunnel {
  private String shhUsername;            // SSH login username
  private String sshPassword;         // SSH login password
  private String sshHostname;             // hostname or ip or SSH server
  private int sshPort;                  // remote SSH host port number
  private String remoteHost;          // hostname or ip of your database server
  private int localPort;                // local port number use to bind SSH tunnel
  private int remotePort;               // remote port number of your database
  private Session session;

  public SSHTunnel(Properties properties) {
    this.shhUsername = properties.getProperty("ssh.user");
    this.sshPassword = properties.getProperty("ssh.password");
    this.sshHostname = properties.getProperty("ssh.host");
    this.sshPort = Integer.parseInt(properties.getProperty("ssh.port"));
    this.remoteHost = properties.getProperty("remote.host");
    this.localPort = Integer.parseInt(properties.getProperty("local.port"));
    this.remotePort = Integer.parseInt(properties.getProperty("remote.port"));
  }

  public int doSshTunnel() throws JSchException
  {
    final Properties sshConfig = new Properties();
    sshConfig.put( "StrictHostKeyChecking", "no" );

    final JSch jsch = new JSch();
    session = jsch.getSession(shhUsername, sshHostname, 22 );
    session.setPassword(sshPassword);

    session.setConfig( sshConfig );

    session.connect();
    System.out.println("Secure Connection");

    session.setPortForwardingL(localPort, "127.0.0.1", remotePort);
    System.out.println("localhost:"+ localPort +" -> "+ remoteHost +":"+ remotePort);
    System.out.println("Port Forwarded");
    return localPort;
  }

  public void closeSession()
  {
    if(session !=null && session.isConnected()){
      System.out.println("Closing SSH Connection");
      session.disconnect();
    }
  }

  public String getSshUsername() {
    return shhUsername;
  }
  public void setSshUsername(String shhUsername) {
    this.shhUsername = shhUsername;
  }
  public String getSshPassword() {
    return sshPassword;
  }
  public void setSshPassword(String sshPassword) {
    this.sshPassword = sshPassword;
  }
  public String getSshHostname() {
    return sshHostname;
  }
  public void setSshHostname(String sshHostname) {
    this.sshHostname = sshHostname;
  }
  public int getSshPort() {
    return sshPort;
  }
  public void setSshPort(int sshPort) {
    this.sshPort = sshPort;
  }
  public String getRemoteHost() {
    return remoteHost;
  }
  public void setRemoteHost(String remoteHost) {
    this.remoteHost = remoteHost;
  }
  public int getLocalPort() {
    return localPort;
  }
  public void setLocalPort(int localPort) {
    this.localPort = localPort;
  }
  public int getRemotePort() {
    return remotePort;
  }
  public void setRemotePort(int remotePort) {
    this.remotePort = remotePort;
  }

}
