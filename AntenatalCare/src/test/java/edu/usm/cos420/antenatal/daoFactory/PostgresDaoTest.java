package edu.usm.cos420.antenatal.daoFactory;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Connection;

/**
 * Created by aaron on 4/16/2016.
 */
public class PostgresDaoTest {
  private static PostgresDao db;
  private static int portCount = 5670;

  @Before
  public void setUp() throws Exception {
    db = new PostgresDao(portCount);
    portCount++;
  }

  @After
  public void tearDown() throws Exception {
    if (db.getConnection() != null)
      db.closeConnection();
  }

  @Test
  public void testOpenConnection() throws Exception {
    Assert.assertTrue("Should connect to remote server.", !db.getConnection().isClosed());
  }

  @Test
  public void testGetConnection() throws Exception {
    Assert.assertNotNull("Should return valid connection", db.getConnection());
  }

  @Test
  public void testGetPersonDao() throws Exception {
    Assert.assertNotNull("Should get PersonDAO", db.getPersonDao());
  }

  @Test
  public void testGetAntenatalVisitDao() throws Exception {
    Assert.assertNotNull("Should get AntenatalVisitDao", db.getAntenatalVisitDao());
  }

  @Test
  public void testGetAntenatalSubVisitDao() throws Exception {
    Assert.assertNotNull("Should get AntenatalSubVisitDao", db.getAntenatalVisitDao());
  }

  @Test
  public void testCloseConnection() throws Exception {

    db.closeConnection();
    Assert.assertNull(db.getConnection());
  }
}
