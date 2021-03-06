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
//import org.junit.Before;
//import org.junit.Test;
//
//import edu.usm.cos420.antenatal.domain.PregnancyFollowUp;
//
//public class TestAntenatalSubVisitDAO {
//	private static AntenatalSubVisitDao dao;
//
//	@Before
//	public void setUp() throws Exception {
//		dao = new AntenatalSubVisitDao("_antenatalsubvisittest.ser");
//	}
//
//	@After
//	public void tearDown() throws Exception {
//		//tear down first file
//				Path path1 = FileSystems.getDefault().getPath(".", "_antenatalsubvisittest.ser");
//				try {
//					Files.delete(path1);
//				} catch (NoSuchFileException x) {
//					System.err.format("%s: no such" + " file or directory%n", path1);
//				} catch (DirectoryNotEmptyException x) {
//					System.err.format("%s not empty%n", path1);
//				} catch (IOException x) {
//					// File permission problems are caught here.
//					System.err.println(x);
//				}
//	}
//
//	@Test
//	public final void testAdd() {
//
//		//create data
//		PregnancyFollowUp a = new PregnancyFollowUp("01", "01", 120, 80,
//		         100, 20, LocalDate.now(), "Non-Reactive", "No");
//
//		dao.add(a);
//
//		//get and test values to confirm.
//		PregnancyFollowUp b = dao.find(a.getId());
//
//		assertEquals("The retrieved ID is different from the original ID.", a.getId(), b.getId());
//		assertEquals("The retrieved Initial ID is different from the original Initial ID.", a.getInitialID(), b.getInitialID());
//		assertEquals("The retrieved Systolic BP is different from the original Systolic BP.", a.getSystolicBP(), b.getSystolicBP());
//		assertEquals("The retrieved Diastolic BP is different from the original Diastolic BP.", a.getDiastolicBP(), b.getDiastolicBP());
//		//assertEquals("The retrieved Weight is different from the original Weight.", a.getWeight(), b.getWeight());
//		//assertEquals("The retrieved Fundal Height is different from the original Fundal Height.", a.getFundalHeight(), b.getFundalHeight());
//		assertEquals("The retrieved Date is different from the original Date.", a.getApptDate(), b.getApptDate());
//		assertEquals("The retrieved Blood Reactivity is different from the original Blood Reactivity.", a.bloodFilmResults(), b.bloodFilmResults());
//		assertEquals("The retrieved Referral is different from the original Referral.", a.getReferral(), b.getReferral());
//	}
//
//	@Test
//	public final void testUpdate() {
//		//create data
//				PregnancyFollowUp c = new PregnancyFollowUp("02", "02", 120, 80,
//				         100, 20, LocalDate.now(), "Non-Reactive", "No");
//
//				dao.add(c);
//
//				//update, retrieve, and check values
//				c.setReferral("Yes");
//				dao.update(c);
//				PregnancyFollowUp d = dao.find(c.getId());
//
//				assertEquals("The retrieved ID is different from the original ID.", c.getId(), d.getId());
//				assertEquals("The retrieved Initial ID is different from the original Initial ID.", c.getInitialID(), d.getInitialID());
//				assertEquals("The retrieved Systolic BP is different from the original Systolic BP.", c.getSystolicBP(), d.getSystolicBP());
//				assertEquals("The retrieved Diastolic BP is different from the original Diastolic BP.", c.getDiastolicBP(), d.getDiastolicBP());
//				//assertEquals("The retrieved Weight is different from the original Weight.", a.getWeight(), b.getWeight());
//				//assertEquals("The retrieved Fundal Height is different from the original Fundal Height.", a.getFundalHeight(), b.getFundalHeight());
//				assertEquals("The retrieved Date is different from the original Date.", c.getApptDate(), d.getApptDate());
//				assertEquals("The retrieved Blood Reactivity is different from the original Blood Reactivity.", c.bloodFilmResults(), d.bloodFilmResults());
//				assertEquals("The retrieved Referral is different from the original Referral.", c.getReferral(), d.getReferral());
//	}
//
//	@Test
//	public final void testRemove() {
//		//create data
//		PregnancyFollowUp e = new PregnancyFollowUp("03", "03", 120, 80,
//		         100, 20, LocalDate.now(), "Non-Reactive", "No");
//
//		dao.add(e);
//		dao.remove(e.getId());
//		PregnancyFollowUp f = dao.find(e.getId());
//
//		assertNull("The PostgresDatabase returned a value that was supposed to be removed.", f);
//	}
//
//	@Test
//	public final void testFind() {
//		//create data
//				PregnancyFollowUp g = new PregnancyFollowUp("03", "03", 120, 80,
//				         100, 20, LocalDate.now(), "Non-Reactive", "No");
//
//
//				//get and test values to confirm.
//				dao.add(g);
//				PregnancyFollowUp h = dao.find(g.getId());
//
//				assertEquals("The retrieved ID is different from the original ID.", g.getId(), h.getId());
//				assertEquals("The retrieved Initial ID is different from the original Initial ID.", g.getInitialID(), h.getInitialID());
//				assertEquals("The retrieved Systolic BP is different from the original Systolic BP.", g.getSystolicBP(), h.getSystolicBP());
//				assertEquals("The retrieved Diastolic BP is different from the original Diastolic BP.", g.getDiastolicBP(), h.getDiastolicBP());
//				//assertEquals("The retrieved Weight is different from the original Weight.", a.getWeight(), b.getWeight());
//				//assertEquals("The retrieved Fundal Height is different from the original Fundal Height.", a.getFundalHeight(), b.getFundalHeight());
//				assertEquals("The retrieved Date is different from the original Date.", g.getApptDate(), h.getApptDate());
//				assertEquals("The retrieved Blood Reactivity is different from the original Blood Reactivity.", g.bloodFilmResults(), h.bloodFilmResults());
//				assertEquals("The retrieved Referral is different from the original Referral.", g.getReferral(), h.getReferral());
//	}
//
//}
