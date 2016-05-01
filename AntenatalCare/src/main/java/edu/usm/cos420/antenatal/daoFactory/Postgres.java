package edu.usm.cos420.antenatal.daoFactory;

import com.jcraft.jsch.JSchException;
import edu.usm.cos420.antenatal.PropertyHandler;
import edu.usm.cos420.antenatal.SSHTunnelHandler;
import edu.usm.cos420.antenatal.dao.concete.PostgresPersonDao;
import edu.usm.cos420.antenatal.dao.concete.PostgresVisitDao;
import edu.usm.cos420.antenatal.dao.concete.PregnancyFollowUpDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by aaron on 4/16/2016.
 */
public class Postgres extends DaoFactory {
  protected Connection connection = null;

  private PostgresVisitDao visitDao;
  private PregnancyFollowUpDao subVisitDao;
  private PostgresPersonDao personDao;

  public Postgres() throws IOException, ClassNotFoundException, SQLException, InstantiationException, JSchException, IllegalAccessException {
    this(5670);
  }

  public Postgres(int port) throws IOException, ClassNotFoundException, SQLException, InstantiationException, JSchException, IllegalAccessException {

    PropertyHandler.getInstance().setPort(port);
    properties = PropertyHandler.getInstance().getProps();
    visitDao = new PostgresVisitDao();
    subVisitDao = new PregnancyFollowUpDao();
    personDao = new PostgresPersonDao();
  }

  @Override
  public Connection openConnection() throws SQLException, ClassNotFoundException, JSchException, IllegalAccessException, InstantiationException {
    // Create a SSH tunnel first
    SSHTunnelHandler tunnel = SSHTunnelHandler.getInstance();

    if (tunnel != null) {

      String database = properties.getProperty("database");
      String driver = properties.getProperty("jdbc.driver");

      String username = properties.getProperty("jdbc.username");
      String password = properties.getProperty("jdbc.password");

      Class.forName(driver).newInstance();
      connection = DriverManager.getConnection("jdbc:postgresql://localhost:" + tunnel.getPort() + "/" + database, username, password);

      if (!connection.isClosed()) {
        System.out.println("Successfully connected to postgres @ " + tunnel.getTunnel().getRemoteHost());
      }

      return connection;
    }
    return null;
  }

  @Override
  public void closeConnection() {
    try {
      if (!connection.isClosed()) {
        connection.close();
        System.out.println("Closing connection.");
        connection = null;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  public Connection getConnection() {
    return connection;
  }

  @Override
  public PostgresPersonDao getPersonDao() {
    return personDao;
  }

  @Override
  public PostgresVisitDao getAntenatalVisitDao() {
    return visitDao;
  }

  @Override
  public PregnancyFollowUpDao getAntenatalSubVisitDao() {
    return subVisitDao;
  }
}
