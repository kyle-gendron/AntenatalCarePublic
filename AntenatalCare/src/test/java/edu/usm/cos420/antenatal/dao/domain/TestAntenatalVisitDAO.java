//package edu.usm.cos420.antenatal.dao.domain;
//
//import static org.junit.Assert.*;
//
//import java.io.IOException;
//import java.nio.file.DirectoryNotEmptyException;
//import java.nio.file.FileSystems;
//import java.nio.file.Files;
//import java.nio.file.NoSuchFileException;
//import java.nio.file.Path;
//import java.time.LocalDate;
//
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//
//import edu.usm.cos420.antenatal.dao.GenericDao;
//import edu.usm.cos420.antenatal.dao.ObjectStreamDao;
//import edu.usm.cos420.antenatal.domain.PregnancyRecord;
//
//public class TestAntenatalVisitDAO {
//	private static GenericDao<String,PregnancyRecord> dao;
//
//	@Before
//	public  void setUpAfterClass() throws Exception {
//		dao = new ObjectStreamDao<>("_antenataltest.ser");
//	}
//
//	@Test
//	public final void testAdd() {
//
//		//create record and fill with data
//		PregnancyRecord p = new PregnancyRecord("01");
//
//		p.setParity(1);
//		p.setHIVResults("Negative");
//		p.setHeight(150.00);
//		p.setWeight(100.00);
//		p.setvDLabResults("Reactive");
//		p.setEDD(LocalDate.now());
//		p.setSystolicBP(120);
//		p.setDiastolicBP(80);
//		p.setTrimester(1);
//		p.setSubVisits(2);
//		p.setGestation(2);
//		p.setIPTDoses("1");
//		p.setTTDoses("protected");
//		p.setFundalHeight(15);
//		p.sethBAtReg(32.4);
//		p.sethBAt36Weeks(34.6);
//		p.setUrineTestSugar(32.4);
//		p.setUrineTestProtein(32.7);
//		p.setBloodGroup("O");
//		p.setBloodFilm("Reactive");
//		p.setSicklingStatus("Positive");
//		p.setSicklingType("Hemoglobin SS");
//		p.setPreTestCounsel("Yes");
//		p.setPostTestCounsel("No");
//		p.setITN("Yes");
//		p.setARV("No");
//		p.setMaleInvolvement("Present");
//		p.setComplaints("None");
//		p.setRemarks("None");
//
//		//add to PostgresDatabase, retrieve, and test values to ensure correctness
//		dao.add(p.getID(), p);
//
//		PregnancyRecord retrievedRecord = dao.find(p.getID());
//
//		assertEquals("Stored ID and original ID are not equal", p.getID(), retrievedRecord.getID());
//		assertEquals("Stored HIVResults and original HIVResults are not equal", p.getHIVResults(), retrievedRecord.getHIVResults());
////		assertEquals("Stored Height and original Height are not equal", p.getHeight(), retrievedRecord.getHeight());
////		assertEquals("Stored Weight and original Weight are not equal", p.getWeight(), retrievedRecord.getWeight());
//		assertEquals("Stored VDLabResults and original VDLabResults are not equal", p.getVDLabResults(), retrievedRecord.getVDLabResults());
//		assertEquals("Stored EDD and original EDD are not equal", p.getEDD(), retrievedRecord.getEDD());
//		assertEquals("Stored SystolicBP and original SystolicBP are not equal", p.getSystolicBP(), retrievedRecord.getSystolicBP());
//		assertEquals("Stored DiastolicBP and original DiastolicBP are not equal", p.getDiastolicBP(), retrievedRecord.getDiastolicBP());
//		assertEquals("Stored Trimester and original Trimester are not equal", p.getTrimester(), retrievedRecord.getTrimester());
//		assertEquals("Stored SubVisits and original SubVisits are not equal", p.getSubVisits(), retrievedRecord.getSubVisits());
//		assertEquals("Stored Gestation and original Gestation are not equal", p.getGestation(), retrievedRecord.getGestation());
//		assertEquals("Stored IPT Doses and original IPT Doses are not equal", p.getIPTDoses(), retrievedRecord.getIPTDoses());
//		assertEquals("Stored Tetanus Toxoid Doses and original Tetanus Toxoid Doses are not equal", p.getTTDoses(), retrievedRecord.getTTDoses());
////		assertEquals("Stored Fundal Height and original Fundal Height are not equal", p.getFundalHeight(), retrievedRecord.getFundalHeight());
////		assertEquals("Stored Hemoglobin at Reg and original Hemoglobin at Reg are not equal", p.getHBAtReg(), retrievedRecord.getHBAtReg());
////		assertEquals("Stored Hemoglobin at 36 weeks and original Hemoglobin at 36 weeks are not equal", p.gethBAt36Weeks(), retrievedRecord.gethBAt36Weeks());
////		assertEquals("Stored Sugar Urine Test and original Sugar Urine Test are not equal", p.getUrineTestSugar(), retrievedRecord.getUrineTestSugar());
//		assertEquals("Stored Blood Group and original Blood Group are not equal", p.getBloodGroup(), retrievedRecord.getBloodGroup());
//		assertEquals("Stored Blood Film and original  are not equal", p.getBloodFilm(), retrievedRecord.getBloodFilm());
//		assertEquals("Stored Sickling Status and original Sickling Status are not equal", p.getSicklingStatus(), retrievedRecord.getSicklingStatus());
//		assertEquals("Stored Sickling Type and original Sickling Type are not equal", p.getSicklingType(), retrievedRecord.getSicklingType());
//		assertEquals("Stored Pretest Counsel and original Pretest Counsel are not equal", p.getPreTestCounsel(), retrievedRecord.getPreTestCounsel());
//		assertEquals("Stored Posttest Counsel and original Posttest Counsels are not equal", p.getPostTestCounsel(), retrievedRecord.getPostTestCounsel());
//		assertEquals("Stored ITN and original ITN are not equal", p.getITN(), retrievedRecord.getITN());
//		assertEquals("Stored ARV and original ARV are not equal", p.getARV(), retrievedRecord.getARV());
//		assertEquals("Stored Male Involvement and original Male Involvement are not equal", p.getMaleInvolvement(), retrievedRecord.getMaleInvolvement());
//		assertEquals("Stored Complaints and original Complaints are not equal", p.getComplaints(), retrievedRecord.getComplaints());
//		assertEquals("Stored Remarks and original Remarks are not equal", p.getRemarks(), retrievedRecord.getRemarks());
//	}
//
//	@Test
//	public final void testUpdate() {
//		//create record and fill with data
//		PregnancyRecord p1 = new PregnancyRecord("02");
//
//		p1.setParity(1);
//		p1.setHIVResults("Negative");
//		p1.setHeight(150.00);
//		p1.setWeight(100.00);
//		p1.setvDLabResults("Reactive");
//		p1.setEDD(LocalDate.now());
//		p1.setSystolicBP(120);
//		p1.setDiastolicBP(80);
//		p1.setTrimester(1);
//		p1.setSubVisits(2);
//		p1.setGestation(2);
//		p1.setIPTDoses("1");
//		p1.setTTDoses("protected");
//		p1.setFundalHeight(15);
//		p1.sethBAtReg(32.4);
//		p1.sethBAt36Weeks(34.6);
//		p1.setUrineTestSugar(32.4);
//		p1.setUrineTestProtein(32.7);
//		p1.setBloodGroup("O");
//		p1.setBloodFilm("Reactive");
//		p1.setSicklingStatus("Positive");
//		p1.setSicklingType("Hemoglobin SS");
//		p1.setPreTestCounsel("Yes");
//		p1.setPostTestCounsel("No");
//		p1.setITN("Yes");
//		p1.setARV("No");
//		p1.setMaleInvolvement("Present");
//		p1.setComplaints("None");
//		p1.setRemarks("None");
//
//		//add to PostgresDatabase
//		dao.add(p1.getID(), p1);
//
//
//		p1.setParity(2);
//		p1.setHIVResults("Positive");
//		p1.setHeight(155.00);
//		p1.setWeight(120.00);
//		p1.setvDLabResults("Non-Reactive");
//		p1.setEDD(LocalDate.of(1992, 12, 28));
//		p1.setSystolicBP(140);
//		p1.setDiastolicBP(100);
//		p1.setTrimester(2);
//		p1.setSubVisits(5);
//		p1.setGestation(4);
//		p1.setIPTDoses("2");
//		p1.setTTDoses("given");
//		p1.setFundalHeight(20);
//		p1.sethBAtReg(32.8);
//		p1.sethBAt36Weeks(34.8);
//		p1.setUrineTestSugar(32.6);
//		p1.setUrineTestProtein(32.9);
//		p1.setBloodGroup("A");
//		p1.setBloodFilm("Non-Reactive");
//		p1.setSicklingStatus("Negative");
//		p1.setSicklingType("N/a");
//		p1.setPreTestCounsel("No");
//		p1.setPostTestCounsel("Yes");
//		p1.setITN("No");
//		p1.setARV("Yes");
//		p1.setMaleInvolvement("Not Present");
//		p1.setComplaints("Some");
//		p1.setRemarks("Some");
//
//		//update object, test values
//		dao.update(p1.getID(), p1);
//
//		PregnancyRecord retrievedRecord = dao.find(p1.getID());
//
//
//		assertEquals("Stored ID and original ID are not equal", p1.getID(), retrievedRecord.getID());
//		assertEquals("Stored HIVResults and original HIVResults are not equal", p1.getHIVResults(), retrievedRecord.getHIVResults());
////		assertEquals("Stored Height and original Height are not equal", p2.getHeight(), retrievedRecord.getHeight());
////		assertEquals("Stored Weight and original Weight are not equal", p2.getWeight(), retrievedRecord.getWeight());
//		assertEquals("Stored VDLabResults and original VDLabResults are not equal", p1.getVDLabResults(), retrievedRecord.getVDLabResults());
//		assertEquals("Stored EDD and original EDD are not equal", p1.getEDD(), retrievedRecord.getEDD());
//		assertEquals("Stored SystolicBP and original SystolicBP are not equal", p1.getSystolicBP(), retrievedRecord.getSystolicBP());
//		assertEquals("Stored DiastolicBP and original DiastolicBP are not equal", p1.getDiastolicBP(), retrievedRecord.getDiastolicBP());
//		assertEquals("Stored Trimester and original Trimester are not equal", p1.getTrimester(), retrievedRecord.getTrimester());
//		assertEquals("Stored SubVisits and original SubVisits are not equal", p1.getSubVisits(), retrievedRecord.getSubVisits());
//		assertEquals("Stored Gestation and original Gestation are not equal", p1.getGestation(), retrievedRecord.getGestation());
//		assertEquals("Stored IPT Doses and original IPT Doses are not equal", p1.getIPTDoses(), retrievedRecord.getIPTDoses());
//		assertEquals("Stored Tetanus Toxoid Doses and original Tetanus Toxoid Doses are not equal", p1.getTTDoses(), retrievedRecord.getTTDoses());
////		assertEquals("Stored Fundal Height and original Fundal Height are not equal", p2.getFundalHeight(), retrievedRecord.getFundalHeight());
////		assertEquals("Stored Hemoglobin at Reg and original Hemoglobin at Reg are not equal", p2.getHBAtReg(), retrievedRecord.getHBAtReg());
////		assertEquals("Stored Hemoglobin at 36 weeks and original Hemoglobin at 36 weeks are not equal", p2.gethBAt36Weeks(), retrievedRecord.gethBAt36Weeks());
////		assertEquals("Stored Sugar Urine Test and original Sugar Urine Test are not equal", p2.getUrineTestSugar(), retrievedRecord.getUrineTestSugar());
//		assertEquals("Stored Blood Group and original Blood Group are not equal", p1.getBloodGroup(), retrievedRecord.getBloodGroup());
//		assertEquals("Stored Blood Film and original  are not equal", p1.getBloodFilm(), retrievedRecord.getBloodFilm());
//		assertEquals("Stored Sickling Status and original Sickling Status are not equal", p1.getSicklingStatus(), retrievedRecord.getSicklingStatus());
//		assertEquals("Stored Sickling Type and original Sickling Type are not equal", p1.getSicklingType(), retrievedRecord.getSicklingType());
//		assertEquals("Stored Pretest Counsel and original Pretest Counsel are not equal", p1.getPreTestCounsel(), retrievedRecord.getPreTestCounsel());
//		assertEquals("Stored Posttest Counsel and original Posttest Counsels are not equal", p1.getPostTestCounsel(), retrievedRecord.getPostTestCounsel());
//		assertEquals("Stored ITN and original ITN are not equal", p1.getITN(), retrievedRecord.getITN());
//		assertEquals("Stored ARV and original ARV are not equal", p1.getARV(), retrievedRecord.getARV());
//		assertEquals("Stored Male Involvement and original Male Involvement are not equal", p1.getMaleInvolvement(), retrievedRecord.getMaleInvolvement());
//		assertEquals("Stored Complaints and original Complaints are not equal", p1.getComplaints(), retrievedRecord.getComplaints());
//		assertEquals("Stored Remarks and original Remarks are not equal", p1.getRemarks(), retrievedRecord.getRemarks());
//	}
//
//	@Test
//	public final void testRemove() {
//
//		//create record and fill with data
//		PregnancyRecord p = new PregnancyRecord("03");
//
//		p.setParity(1);
//		p.setHIVResults("Negative");
//		p.setHeight(150.00);
//		p.setWeight(100.00);
//		p.setvDLabResults("Reactive");
//		p.setEDD(LocalDate.now());
//		p.setSystolicBP(120);
//		p.setDiastolicBP(80);
//		p.setTrimester(1);
//		p.setSubVisits(2);
//		p.setGestation(2);
//		p.setIPTDoses("1");
//		p.setTTDoses("protected");
//		p.setFundalHeight(15);
//		p.sethBAtReg(32.4);
//		p.sethBAt36Weeks(34.6);
//		p.setUrineTestSugar(32.4);
//		p.setUrineTestProtein(32.7);
//		p.setBloodGroup("O");
//		p.setBloodFilm("Reactive");
//		p.setSicklingStatus("Positive");
//		p.setSicklingType("Hemoglobin SS");
//		p.setPreTestCounsel("Yes");
//		p.setPostTestCounsel("No");
//		p.setITN("Yes");
//		p.setARV("No");
//		p.setMaleInvolvement("Present");
//		p.setComplaints("None");
//		p.setRemarks("None");
//
//		//add, then remove
//		dao.add(p.getID(), p);
//		dao.remove(p.getID());
//
//		//make sure it's been removed
//		PregnancyRecord foundP = dao.find(p.getID());
//
//		assertNull("DAO returns value that should've been removed.", foundP);
//
//	}
//
//	@Test
//	public final void testFind() {
//		//create record and fill with data
//		PregnancyRecord p = new PregnancyRecord("04");
//
//		p.setParity(1);
//		p.setHIVResults("Negative");
//		p.setHeight(150.00);
//		p.setWeight(100.00);
//		p.setvDLabResults("Reactive");
//		p.setEDD(LocalDate.now());
//		p.setSystolicBP(120);
//		p.setDiastolicBP(80);
//		p.setTrimester(1);
//		p.setSubVisits(2);
//		p.setGestation(2);
//		p.setIPTDoses("1");
//		p.setTTDoses("protected");
//		p.setFundalHeight(15);
//		p.sethBAtReg(32.4);
//		p.sethBAt36Weeks(34.6);
//		p.setUrineTestSugar(32.4);
//		p.setUrineTestProtein(32.7);
//		p.setBloodGroup("O");
//		p.setBloodFilm("Reactive");
//		p.setSicklingStatus("Positive");
//		p.setSicklingType("Hemoglobin SS");
//		p.setPreTestCounsel("Yes");
//		p.setPostTestCounsel("No");
//		p.setITN("Yes");
//		p.setARV("No");
//		p.setMaleInvolvement("Present");
//		p.setComplaints("None");
//		p.setRemarks("None");
//
//		//add to PostgresDatabase, retrieve, and test value
//		dao.add(p.getID(), p);
//
//		PregnancyRecord retrievedRecord = dao.find(p.getID());
//
//		assertNotNull(retrievedRecord);
//	}
//
//	@After
//	public  void tearDownAfterClass() throws Exception {
//		//tear down first file
//		Path path1 = FileSystems.getDefault().getPath(".", "_antenataltest.ser");
//		try {
//			Files.delete(path1);
//		} catch (NoSuchFileException x) {
//			System.err.format("%s: no such" + " file or directory%n", path1);
//		} catch (DirectoryNotEmptyException x) {
//			System.err.format("%s not empty%n", path1);
//		} catch (IOException x) {
//			// File permission problems are caught here.
//			System.err.println(x);
//		}
//	}
//
//}
