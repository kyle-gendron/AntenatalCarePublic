package edu.usm.cos420.antenatal;

import edu.usm.cos420.antenatal.controller.AntenatalController;
import edu.usm.cos420.antenatal.controller.SubController;
import edu.usm.cos420.antenatal.domain.PregnancyFollowUp;
import edu.usm.cos420.antenatal.view.SubsequentVisit;
import org.junit.*;

import java.time.LocalDate;

public class SubVisitTest {

   SubsequentVisit visit;
   PregnancyFollowUp subVisit;
   AntenatalController control;
   SubController subController;

   @BeforeClass
   public static void setUpBeforeClass() throws Exception {
   }

   @AfterClass
   public static void tearDownAfterClass() throws Exception {
   }

   @Before
   public void setUp() throws Exception {
      control = new AntenatalController();
      subController = new SubController(control);
      visit = new SubsequentVisit(subController);
      subVisit = new PregnancyFollowUp(null, null, 0, 0, 0, 0, LocalDate.now(), null, null);
      //visit.changeForm(subVisit);

   }

   @After
   public void tearDown() throws Exception {
   }

   @Test
   public void testSubsequentVisit() {
      SubsequentVisit sub = new SubsequentVisit(subController);

   }

   @Test
   public void testGetTitle() {
      visit.getTitle();
   }

   @Test
   public void testGetPanel() {
      visit.getPanel();
   }

   @Test
   public void testSetForm() {
      visit.setForm(subVisit);
   }

   @Test
   public void testGetApptDate() {
      visit.getApptDate();
   }

   @Test
   public void testGetFundalHeight() {
      visit.getFundalHeight();
   }

   @Test
   public void testGetPatientWeight() {
      visit.getPatientWeight();
   }

   @Test
   public void testGetSystolicBP() {
      int sys = visit.getSystolicBP();
      Assert.assertTrue(sys == 0);
   }

   @Test
   public void testGetDiastolicBP() {
      visit.getDiastolicBP();
   }

   @Test
   public void testGetBloodFilm() {
      visit.getBloodFilm();
   }

   @Test
   public void testGetRefer() {
      visit.getRefer();
   }

   @Test
   public void testSetApptDate() {
      subVisit.setApptDate(LocalDate.now());
   }

   @Test
   public void testSetFundalHeight() {
      subVisit.setApptDate(LocalDate.now());
   }

   @Test
   public void testSetWeight() {
      subVisit.setWeight(0);
   }

   @Test
   public void testSetSystolicBP() {
      subVisit.setSystolicBP(0);
   }

   @Test
   public void testSetDiastolicBP() {
      subVisit.setDiastolicBP(0);
   }

   @Test
   public void testSetBloodFilm() {
      subVisit.setBloodFilm("Positive");
   }

   @Test
   public void testSetReferral() {
      subVisit.setReferral("No");
   }

}
