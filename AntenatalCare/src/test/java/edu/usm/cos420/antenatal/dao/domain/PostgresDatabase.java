package edu.usm.cos420.antenatal.dao.domain;

import edu.usm.cos420.antenatal.daoFactory.DaoFactory;
import edu.usm.cos420.antenatal.daoFactory.Postgres;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by aaron on 4/16/2016.
 */
public class PostgresDatabase {
  Postgres db;

  @Before
  public void setUp() throws Exception {
     db = new Postgres();
  }

  @Test
  public void shouldConnectToDatabase() {
    Connection connection = db.openConnection();
    Assert.assertNotNull("Should connect to remote server.", connection);
  }


}
