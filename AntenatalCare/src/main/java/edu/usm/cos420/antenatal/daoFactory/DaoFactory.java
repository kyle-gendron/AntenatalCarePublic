package edu.usm.cos420.antenatal.daoFactory;

import com.jcraft.jsch.JSchException;
import edu.usm.cos420.antenatal.dao.concete.PostgresPersonDao;
import edu.usm.cos420.antenatal.dao.concete.PostgresVisitDao;
import edu.usm.cos420.antenatal.dao.concete.PregnancyFollowUpDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by aaron on 4/16/2016.
 */
public abstract class DaoFactory {
  private static Postgres P = null;
  public Properties properties;

  public abstract Connection openConnection() throws Exception;

  public abstract void closeConnection();

  public abstract PostgresPersonDao getPersonDao();

  public abstract PostgresVisitDao getAntenatalVisitDao();

  public abstract PregnancyFollowUpDao getAntenatalSubVisitDao();

  public static Postgres getDatabase() {
    if (P == null) {
      try {
        P = new Postgres();
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
