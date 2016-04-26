package edu.usm.cos420.antenatal.daoFactory;

import com.jcraft.jsch.JSchException;
import edu.usm.cos420.antenatal.dao.postgres.PersonDao;
import edu.usm.cos420.antenatal.dao.postgres.PregnancyRecordDao;
import edu.usm.cos420.antenatal.dao.postgres.PregnancySubVisitDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by aaron on 4/16/2016.
 */
public abstract class DaoFactory {
  private static PostgresDao P = null;
  public Properties properties;

  public abstract Connection openConnection() throws Exception;

  public abstract void closeConnection();

  public abstract PersonDao getPersonDao();

  public abstract PregnancyRecordDao getAntenatalVisitDao();

  public abstract PregnancySubVisitDao getAntenatalSubVisitDao();

  public static PostgresDao getDatabase() {
    if (P == null) {
      try {
        P = new PostgresDao();
      } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | IOException
        | SQLException | JSchException e) {
        e.printStackTrace();
      }
      return P;
    } else {
      return P;
    }

  }

}
