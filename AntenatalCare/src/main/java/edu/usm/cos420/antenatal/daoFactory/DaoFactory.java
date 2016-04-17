package edu.usm.cos420.antenatal.daoFactory;

import edu.usm.cos420.antenatal.dao.postgres.PregnancyRecordDao;
import edu.usm.cos420.antenatal.dao.postgres.PregnancySubVisitDao;
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
  public abstract PregnancyRecordDao getAntenatalVisitDao();
  public abstract PregnancySubVisitDao getAntenatalSubVisitDao();

  public static PostgresDao getDatabase() throws Exception {
    return new PostgresDao();
  }

}
