package edu.usm.cos420.antenatal.daoFactory;

import edu.usm.cos420.antenatal.dao.postgres.AntenatalVisitDao;
import edu.usm.cos420.antenatal.dao.postgres.AntenatalSubVisitDao;
import edu.usm.cos420.antenatal.dao.serializedObject.PersonDao;

import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * Created by aaron on 4/16/2016.
 */
public abstract class DaoFactory {
  public Properties properties;

  public abstract Connection openConnection() throws Exception;
  public abstract void closeConnection();
  public abstract PersonDao getPersonDao();
  public abstract AntenatalVisitDao getAntenatalVisitDao();
  public abstract AntenatalSubVisitDao getAntenatalSubVisitDao();

  public static DaoFactory getDatabase() throws Exception {
    return new PostgresDao();
  }

}
