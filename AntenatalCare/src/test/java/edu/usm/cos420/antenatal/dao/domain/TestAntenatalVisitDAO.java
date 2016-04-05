package edu.usm.cos420.antenatal.dao.domain;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.time.LocalDate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.usm.cos420.antenatal.dao.GenericDao;
import edu.usm.cos420.antenatal.dao.ObjectStreamDao;
import edu.usm.cos420.antenatal.domain.PregnancyRecord;

public class TestAntenatalVisitDAO {
	private GenericDao<String,PregnancyRecord> dao;

	@Before
	public void setUp() throws Exception {
		dao = new ObjectStreamDao<String,PregnancyRecord>("antenataltest.ser");
	}

	@After
	public void tearDown() throws Exception {
		//tear down first file
		Path path1 = FileSystems.getDefault().getPath(".", "antenataltest.ser");
		try {
			Files.delete(path1);
		} catch (NoSuchFileException x) {
			System.err.format("%s: no such" + " file or directory%n", path1);
		} catch (DirectoryNotEmptyException x) {
			System.err.format("%s not empty%n", path1);
		} catch (IOException x) {
			// File permission problems are caught here.
			System.err.println(x);
		}
	}

	@Test
	public final void testAdd() {

		//create record and fill with data
		PregnancyRecord p = new PregnancyRecord("01");

		p.setParity(1);
		p.setHIVResults("Negative");
		p.setHeight(150.00);
		p.setWeight(100.00);
		p.setvDLabResults("Reactive");
		p.setEDD(LocalDate.now());
		p.setSystolicBP(120);
		p.setDiastolicBP(80);
		p.setTrimester(1);
		p.setSubVisits(2);
		p.setGestation(2);
		p.setIPTDoses("1");
		p.setTTDoses("protected");
		p.setFundalHeight(15);
		p.sethBAtReg(32.4);
		p.sethBAt36Weeks(34.6);
		p.setUrineTestSugar(32.4);
		p.setUrineTestProtein(32.7);
		p.setBloodGroup("O");
		p.setBloodFilm("Reactive");
		p.setSicklingStatus("Positive");
		p.setSicklingType("Hemoglobin SS");
		p.setPreTestCounsel("Yes");
		p.setPostTestCounsel("No");
		p.setITN("Yes"); 
		p.setARV("No");
		p.setMaleInvolvement("Present");
		p.setComplaints("None");
		p.setRemarks("None");

		//add to database, retrieve, and test values to ensure correctness
		dao.add(p.getID(), p);

		PregnancyRecord retrievedRecord = dao.find(p.getID());

		assertEquals("Stored ID and original ID are not equal", p.getID(), retrievedRecord.getID());
		assertEquals("Stored HIVResults and original HIVResults are not equal", p.getHIVResults(), retrievedRecord.getHIVResults());
		assertEquals("Stored Height and original Height are not equal", p.getHeight(), retrievedRecord.getHeight());
		assertEquals("Stored Weight and original Weight are not equal", p.getWeight(), retrievedRecord.getWeight());
		assertEquals("Stored VDLabResults and original VDLabResults are not equal", p.getVDLabResults(), retrievedRecord.getVDLabResults());
		assertEquals("Stored EDD and original EDD are not equal", p.getEDD(), retrievedRecord.getEDD());
		assertEquals("Stored SystolicBP and original SystolicBP are not equal", p.getSystolicBP(), retrievedRecord.getSystolicBP());
		assertEquals("Stored DiastolicBP and original DiastolicBP are not equal", p.getDiastolicBP(), retrievedRecord.getDiastolicBP());
		assertEquals("Stored Trimester and original Trimester are not equal", p.getTrimester(), retrievedRecord.getTrimester());
		assertEquals("Stored SubVisits and original SubVisits are not equal", p.getSubVisits(), retrievedRecord.getSubVisits());
		assertEquals("Stored Gestation and original Gestation are not equal", p.getGestation(), retrievedRecord.getGestation());
		assertEquals("Stored IPT Doses and original IPT Doses are not equal", p.getIPTDoses(), retrievedRecord.getIPTDoses());
		assertEquals("Stored Tetanus Toxoid Doses and original Tetanus Toxoid Doses are not equal", p.getTTDoses(), retrievedRecord.getTTDoses());
		assertEquals("Stored Fundal Height and original Fundal Height are not equal", p.getFundalHeight(), retrievedRecord.getFundalHeight());
		assertEquals("Stored Hemoglobin at Reg and original Hemoglobin at Reg are not equal", p.getHBAtReg(), retrievedRecord.getHBAtReg());
		assertEquals("Stored Hemoglobin at 36 weeks and original Hemoglobin at 36 weeks are not equal", p.gethBAt36Weeks(), retrievedRecord.gethBAt36Weeks());
		assertEquals("Stored Sugar Urine Test and original Sugar Urine Test are not equal", p.getUrineTestSugar(), retrievedRecord.getUrineTestSugar());
		assertEquals("Stored Blood Group and original Blood Group are not equal", p.getBloodGroup(), retrievedRecord.getBloodGroup());
		assertEquals("Stored Blood Film and original  are not equal", p.getBloodFilm(), retrievedRecord.getBloodFilm());
		assertEquals("Stored Sickling Status and original Sickling Status are not equal", p.getSicklingStatus(), retrievedRecord.getSicklingStatus());
		assertEquals("Stored Sickling Type and original Sickling Type are not equal", p.getSicklingType(), retrievedRecord.getSicklingType());
		assertEquals("Stored Pretest Counsel and original Pretest Counsel are not equal", p.getPreTestCounsel(), retrievedRecord.getPreTestCounsel());
		assertEquals("Stored Posttest Counsel and original Posttest Counsels are not equal", p.getPostTestCounsel(), retrievedRecord.getPostTestCounsel());
		assertEquals("Stored ITN and original ITN are not equal", p.getITN(), retrievedRecord.getITN());
		assertEquals("Stored ARV and original ARV are not equal", p.getARV(), retrievedRecord.getARV());
		assertEquals("Stored Male Involvement and original Male Involvement are not equal", p.getMaleInvolvement(), retrievedRecord.getMaleInvolvement());
		assertEquals("Stored Complaints and original Complaints are not equal", p.getComplaints(), retrievedRecord.getComplaints());
		assertEquals("Stored Remarks and original Remarks are not equal", p.getRemarks(), retrievedRecord.getRemarks());
	}

	@Test
	public final void testUpdate() {
		//create record and fill with data
		PregnancyRecord p = new PregnancyRecord("02");

		p.setParity(1);
		p.setHIVResults("Negative");
		p.setHeight(150.00);
		p.setWeight(100.00);
		p.setvDLabResults("Reactive");
		p.setEDD(LocalDate.now());
		p.setSystolicBP(120);
		p.setDiastolicBP(80);
		p.setTrimester(1);
		p.setSubVisits(2);
		p.setGestation(2);
		p.setIPTDoses("1");
		p.setTTDoses("protected");
		p.setFundalHeight(15);
		p.sethBAtReg(32.4);
		p.sethBAt36Weeks(34.6);
		p.setUrineTestSugar(32.4);
		p.setUrineTestProtein(32.7);
		p.setBloodGroup("O");
		p.setBloodFilm("Reactive");
		p.setSicklingStatus("Positive");
		p.setSicklingType("Hemoglobin SS");
		p.setPreTestCounsel("Yes");
		p.setPostTestCounsel("No");
		p.setITN("Yes"); 
		p.setARV("No");
		p.setMaleInvolvement("Present");
		p.setComplaints("None");
		p.setRemarks("None");

		//add to database
		dao.add(p.getID(), p);

		//created updated version
		PregnancyRecord p2 = new PregnancyRecord("02");

		p2.setParity(2);
		p2.setHIVResults("Positive");
		p2.setHeight(155.00);
		p2.setWeight(120.00);
		p2.setvDLabResults("Non-Reactive");
		p2.setEDD(LocalDate.of(1992, 12, 28));
		p2.setSystolicBP(140);
		p2.setDiastolicBP(100);
		p2.setTrimester(2);
		p2.setSubVisits(5);
		p2.setGestation(4);
		p2.setIPTDoses("2");
		p2.setTTDoses("given");
		p2.setFundalHeight(20);
		p2.sethBAtReg(32.8);
		p2.sethBAt36Weeks(34.8);
		p2.setUrineTestSugar(32.6);
		p2.setUrineTestProtein(32.9);
		p2.setBloodGroup("A");
		p2.setBloodFilm("Non-Reactive");
		p2.setSicklingStatus("Negative");
		p2.setSicklingType("N/a");
		p2.setPreTestCounsel("No");
		p2.setPostTestCounsel("Yes");
		p2.setITN("No"); 
		p2.setARV("Yes");
		p2.setMaleInvolvement("Not Present");
		p2.setComplaints("Some");
		p2.setRemarks("Some");

		//update object, test values
		dao.update(p2.getID(), p2);

		PregnancyRecord retrievedRecord = dao.find(p2.getID());


		assertEquals("Stored ID and original ID are not equal", p2.getID(), retrievedRecord.getID());
		assertEquals("Stored HIVResults and original HIVResults are not equal", p2.getHIVResults(), retrievedRecord.getHIVResults());
		assertEquals("Stored Height and original Height are not equal", p2.getHeight(), retrievedRecord.getHeight());
		assertEquals("Stored Weight and original Weight are not equal", p2.getWeight(), retrievedRecord.getWeight());
		assertEquals("Stored VDLabResults and original VDLabResults are not equal", p2.getVDLabResults(), retrievedRecord.getVDLabResults());
		assertEquals("Stored EDD and original EDD are not equal", p2.getEDD(), retrievedRecord.getEDD());
		assertEquals("Stored SystolicBP and original SystolicBP are not equal", p2.getSystolicBP(), retrievedRecord.getSystolicBP());
		assertEquals("Stored DiastolicBP and original DiastolicBP are not equal", p2.getDiastolicBP(), retrievedRecord.getDiastolicBP());
		assertEquals("Stored Trimester and original Trimester are not equal", p2.getTrimester(), retrievedRecord.getTrimester());
		assertEquals("Stored SubVisits and original SubVisits are not equal", p2.getSubVisits(), retrievedRecord.getSubVisits());
		assertEquals("Stored Gestation and original Gestation are not equal", p2.getGestation(), retrievedRecord.getGestation());
		assertEquals("Stored IPT Doses and original IPT Doses are not equal", p2.getIPTDoses(), retrievedRecord.getIPTDoses());
		assertEquals("Stored Tetanus Toxoid Doses and original Tetanus Toxoid Doses are not equal", p2.getTTDoses(), retrievedRecord.getTTDoses());
		assertEquals("Stored Fundal Height and original Fundal Height are not equal", p2.getFundalHeight(), retrievedRecord.getFundalHeight());
		assertEquals("Stored Hemoglobin at Reg and original Hemoglobin at Reg are not equal", p2.getHBAtReg(), retrievedRecord.getHBAtReg());
		assertEquals("Stored Hemoglobin at 36 weeks and original Hemoglobin at 36 weeks are not equal", p2.gethBAt36Weeks(), retrievedRecord.gethBAt36Weeks());
		assertEquals("Stored Sugar Urine Test and original Sugar Urine Test are not equal", p2.getUrineTestSugar(), retrievedRecord.getUrineTestSugar());
		assertEquals("Stored Blood Group and original Blood Group are not equal", p2.getBloodGroup(), retrievedRecord.getBloodGroup());
		assertEquals("Stored Blood Film and original  are not equal", p2.getBloodFilm(), retrievedRecord.getBloodFilm());
		assertEquals("Stored Sickling Status and original Sickling Status are not equal", p2.getSicklingStatus(), retrievedRecord.getSicklingStatus());
		assertEquals("Stored Sickling Type and original Sickling Type are not equal", p2.getSicklingType(), retrievedRecord.getSicklingType());
		assertEquals("Stored Pretest Counsel and original Pretest Counsel are not equal", p2.getPreTestCounsel(), retrievedRecord.getPreTestCounsel());
		assertEquals("Stored Posttest Counsel and original Posttest Counsels are not equal", p2.getPostTestCounsel(), retrievedRecord.getPostTestCounsel());
		assertEquals("Stored ITN and original ITN are not equal", p2.getITN(), retrievedRecord.getITN());
		assertEquals("Stored ARV and original ARV are not equal", p2.getARV(), retrievedRecord.getARV());
		assertEquals("Stored Male Involvement and original Male Involvement are not equal", p2.getMaleInvolvement(), retrievedRecord.getMaleInvolvement());
		assertEquals("Stored Complaints and original Complaints are not equal", p2.getComplaints(), retrievedRecord.getComplaints());
		assertEquals("Stored Remarks and original Remarks are not equal", p2.getRemarks(), retrievedRecord.getRemarks());
	}

	@Test
	public final void testRemove() {

		//create record and fill with data
		PregnancyRecord p = new PregnancyRecord("03");

		p.setParity(1);
		p.setHIVResults("Negative");
		p.setHeight(150.00);
		p.setWeight(100.00);
		p.setvDLabResults("Reactive");
		p.setEDD(LocalDate.now());
		p.setSystolicBP(120);
		p.setDiastolicBP(80);
		p.setTrimester(1);
		p.setSubVisits(2);
		p.setGestation(2);
		p.setIPTDoses("1");
		p.setTTDoses("protected");
		p.setFundalHeight(15);
		p.sethBAtReg(32.4);
		p.sethBAt36Weeks(34.6);
		p.setUrineTestSugar(32.4);
		p.setUrineTestProtein(32.7);
		p.setBloodGroup("O");
		p.setBloodFilm("Reactive");
		p.setSicklingStatus("Positive");
		p.setSicklingType("Hemoglobin SS");
		p.setPreTestCounsel("Yes");
		p.setPostTestCounsel("No");
		p.setITN("Yes"); 
		p.setARV("No");
		p.setMaleInvolvement("Present");
		p.setComplaints("None");
		p.setRemarks("None");

		//add, then remove
		dao.add(p.getID(), p);
		dao.remove(p.getID());

		//make sure it's been removed
		PregnancyRecord foundP = dao.find(p.getID());

		assertNull("DAO returns value that should've been removed.", foundP);

	}

	@Test
	public final void testFind() {
		//create record and fill with data
		PregnancyRecord p = new PregnancyRecord("04");

		p.setParity(1);
		p.setHIVResults("Negative");
		p.setHeight(150.00);
		p.setWeight(100.00);
		p.setvDLabResults("Reactive");
		p.setEDD(LocalDate.now());
		p.setSystolicBP(120);
		p.setDiastolicBP(80);
		p.setTrimester(1);
		p.setSubVisits(2);
		p.setGestation(2);
		p.setIPTDoses("1");
		p.setTTDoses("protected");
		p.setFundalHeight(15);
		p.sethBAtReg(32.4);
		p.sethBAt36Weeks(34.6);
		p.setUrineTestSugar(32.4);
		p.setUrineTestProtein(32.7);
		p.setBloodGroup("O");
		p.setBloodFilm("Reactive");
		p.setSicklingStatus("Positive");
		p.setSicklingType("Hemoglobin SS");
		p.setPreTestCounsel("Yes");
		p.setPostTestCounsel("No");
		p.setITN("Yes"); 
		p.setARV("No");
		p.setMaleInvolvement("Present");
		p.setComplaints("None");
		p.setRemarks("None");

		//add to database, retrieve, and test value
		dao.add(p.getID(), p);

		PregnancyRecord retrievedRecord = dao.find(p.getID());

		assertNotNull(retrievedRecord);
	}

}
