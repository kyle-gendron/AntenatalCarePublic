package edu.usm.cos420.antenatal;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import edu.usm.cos420.antenatal.dao.domain.TestAntenatalSubVisitDAO;
import edu.usm.cos420.antenatal.dao.domain.TestAntenatalVisitDAO;



@RunWith(Suite.class)
@SuiteClasses({ TestAntenatalVisitDAO.class,TestAntenatalSubVisitDAO.class })
public class AllTests {

}
