package edu.usm.cos420.antenatal.service.impl;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.usm.cos420.antenatal.dao.GenericDao;
import edu.usm.cos420.antenatal.dao.ObjectStreamDao;
import edu.usm.cos420.antenatal.dao.domain.AntenatalVisitDao;
import edu.usm.cos420.antenatal.domain.AntenatalVisit;
import edu.usm.cos420.antenatal.service.AntenatalService;
import edu.usm.cos420.antenatal.service.impl.AntenatalService1;

public class IntegrationTestAntenatalService {
	GenericDao<Long, AntenatalVisit> dao;
	AntenatalVisitDao AntenatalVisitDao;
    AntenatalService testService;
    
	@Before
	public void setupData() {
	   dao = new ObjectStreamDao<Long, AntenatalVisit>("_test.ser");
	   AntenatalVisitDao = new AntenatalVisitDao(dao);
	   testService = new AntenatalService1(AntenatalVisitDao);
	}
	
	@Test
    public void testaddAAntenatalVisit() {
        AntenatalVisit retrievedItem;
        List<AntenatalVisit> clist;
        
        testService.addAAntenatalVisit();
        
        clist = AntenatalVisitDao.list();
        
        retrievedItem = clist.get(0);
        
        assertNotNull("Dao returns a null item.", retrievedItem);
	}

	@Test
    public void testmaxId() {
        Long id, newMax; 
        List<AntenatalVisit> clist;
                
        id = testService.maxAntenatalVisitId();
        
	    AntenatalVisit oneItem = new AntenatalVisit(2, "test string"); 
        oneItem.setId(id + 5);
        AntenatalVisitDao.add(oneItem);
        newMax = testService.maxAntenatalVisitId();
        clist = AntenatalVisitDao.list();
        
        AntenatalVisit retrievedItem = clist.get(0);
        System.out.println(retrievedItem);
        
        assertEquals("Stored Id and original Id are not equal ", newMax.longValue(), id.longValue() + 5);
	}
	
	/** 
	 * Need to delete the file for next test
	 */
	@After
	public void tearDown()
	{

		Path path = FileSystems.getDefault().getPath(".", "_test.ser");
		try {
		    Files.delete(path);
		} catch (NoSuchFileException x) {
		    System.err.format("%s: no such" + " file or directory%n", path);
		} catch (DirectoryNotEmptyException x) {
		    System.err.format("%s not empty%n", path);
		} catch (IOException x) {
		    // File permission problems are caught here.
		    System.err.println(x);
		}


	}
}

