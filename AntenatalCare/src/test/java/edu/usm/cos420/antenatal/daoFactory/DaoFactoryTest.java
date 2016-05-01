package edu.usm.cos420.antenatal.daoFactory;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by aaron on 4/16/2016.
 */
public class DaoFactoryTest {

  @Test
  public void testGetDatabase() throws Exception {
    DaoFactory db = DaoFactory.getDatabase();
    Assert.assertEquals("Gets Postgres Factory Object", db.getClass().getName(), "edu.usm.cos420.antenatal.daoFactory.Postgres");
  }
}
