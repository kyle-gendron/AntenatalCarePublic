package edu.usm.cos420.antenatal.daoFactory;

import com.jcraft.jsch.JSchException;
import edu.usm.cos420.antenatal.utils.SSHTunnel;
import edu.usm.cos420.antenatal.dao.serializedObject.AntenatalSubVisitDao;
import edu.usm.cos420.antenatal.dao.serializedObject.AntenatalVisitDao;
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
public class Postgres extends DaoFactory {
  public Postgres() {
    properties = new Properties();

    InputStream in = Postgres.class.getClassLoader().getResourceAsStream("config.properties");
    try {
      properties.load(in);
    } catch (IOException e) {
      System.out.println( "No `config.properties` was found in the project.");
      e.printStackTrace();
    }
  }

  @Override
  public Connection openConnection() {
    Connection connection = null;
    try {
      // Create an SSH tunnel first
      SSHTunnel pipe = new SSHTunnel(properties);
      int tunnelPort = pipe.doSshTunnel();

      String database = properties.getProperty("database");
      String driver = properties.getProperty("jdbc.driver");

      String username = properties.getProperty("jdbc.username");
      String password = properties.getProperty("jdbc.password");

      Class.forName(driver).newInstance();
      connection = DriverManager.getConnection(
        "jdbc:postgresql://localhost:" + tunnelPort + "/" + database,
        username, password );

      if (!connection.isClosed()) {
        System.out.println("Successfully connected to postgres @ " + pipe.getRemoteHost());
      }

    } catch (SQLException e) {
      System.err.println("A SQL error occurred." + e.getMessage());
    } catch (IllegalAccessException | InstantiationException | ClassNotFoundException | JSchException e) {
      e.printStackTrace();
    }
    return connection;
  }

  @Override
  public PersonDao getPersonDao() {
    return new PersonDao();
  }

  @Override
  public AntenatalVisitDao getAntenatalVisitDao() {
    return new AntenatalVisitDao();
  }

  @Override
  public AntenatalSubVisitDao getAntenatalSubVisitDao() {
    return new AntenatalSubVisitDao();
  }
}
