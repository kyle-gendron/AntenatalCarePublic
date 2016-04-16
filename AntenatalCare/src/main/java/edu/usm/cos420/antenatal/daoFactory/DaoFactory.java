package edu.usm.cos420.antenatal.daoFactory;

import edu.usm.cos420.antenatal.dao.serializedObject.AntenatalSubVisitDao;
import edu.usm.cos420.antenatal.dao.serializedObject.AntenatalVisitDao;
import edu.usm.cos420.antenatal.dao.serializedObject.PersonDao;

import java.sql.Connection;
import java.util.Properties;

/**
 * Created by aaron on 4/16/2016.
 */
public abstract class DaoFactory {
  public Properties properties;

  public abstract Connection openConnection();
  public abstract PersonDao getPersonDao();
  public abstract AntenatalVisitDao getAntenatalVisitDao();
  public abstract AntenatalSubVisitDao getAntenatalSubVisitDao();

  public static DaoFactory getDatabase() {
    return new Postgres();
  }

}
