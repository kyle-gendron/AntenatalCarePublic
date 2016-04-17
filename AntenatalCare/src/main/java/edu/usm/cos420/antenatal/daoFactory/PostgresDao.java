package edu.usm.cos420.antenatal.daoFactory;

import com.jcraft.jsch.JSchException;
import edu.usm.cos420.antenatal.dao.postgres.PregnancySubVisitDao;
import edu.usm.cos420.antenatal.dao.postgres.PregnancyRecordDao;
import edu.usm.cos420.antenatal.utils.SSHTunnel;
import edu.usm.cos420.antenatal.dao.serializedObject.PersonDao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by aaron on 4/16/2016.
 */
public class PostgresDao extends DaoFactory {
  protected Connection connection = null;

  private PregnancyRecordDao visitDao;
  private PregnancySubVisitDao subVisitDao;
  private PersonDao personDao;

  public PostgresDao() throws IOException, ClassNotFoundException, SQLException, InstantiationException, JSchException, IllegalAccessException {
    this(5670);

  }

  public PostgresDao(int port) throws IOException, ClassNotFoundException, SQLException, InstantiationException, JSchException, IllegalAccessException {
    properties = new Properties();

    InputStream in = PostgresDao.class.getClassLoader().getResourceAsStream("config.properties");
    properties.load(in);
    properties.setProperty("local.port", String.valueOf(port));

    connection = openConnection();

    visitDao = new PregnancyRecordDao(connection);
    subVisitDao = new PregnancySubVisitDao(connection);
    personDao = new PersonDao();
  }

  @Override
  public Connection openConnection() throws SQLException, ClassNotFoundException, JSchException, IllegalAccessException, InstantiationException {
    // Create an SSH tunnel first
    SSHTunnel pipe = new SSHTunnel(properties);
    int tunnelPort = pipe.doSshTunnel();

    String database = properties.getProperty("database");
    String driver = properties.getProperty("jdbc.driver");

    String username = properties.getProperty("jdbc.username");
    String password = properties.getProperty("jdbc.password");

    Class.forName(driver).newInstance();
    connection = DriverManager.getConnection("jdbc:postgresql://localhost:" + tunnelPort + "/" + database, username, password);

    if (!connection.isClosed()) {
      System.out.println("Successfully connected to postgres @ " + pipe.getRemoteHost());
    }

    return connection;
  }

  @Override
  public void closeConnection() {
    try {
      if (!connection.isClosed()) {
        connection.close();
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
  public PersonDao getPersonDao() {
    return personDao;
  }

  @Override
  public PregnancyRecordDao getAntenatalVisitDao() {
    return visitDao;
  }

  @Override
  public PregnancySubVisitDao getAntenatalSubVisitDao() {
    return subVisitDao;
  }
}
