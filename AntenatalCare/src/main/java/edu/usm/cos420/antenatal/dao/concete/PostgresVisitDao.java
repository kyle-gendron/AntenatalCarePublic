package edu.usm.cos420.antenatal.dao.concete;

import com.jcraft.jsch.JSchException;
import edu.usm.cos420.antenatal.dao.interfaces.IAntenatalRecord;
import edu.usm.cos420.antenatal.daoFactory.DaoFactory;
import edu.usm.cos420.antenatal.domain.PregnancyVisit;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by aaron on 4/16/2016.
 */
public class PostgresVisitDao implements IAntenatalRecord<PregnancyVisit> {

  private static final String
    INSERT = "INSERT INTO antenatal_record (" +
    "parity, " +
    "gestation ," +
    "iPTDoses ," +
    "TTDoses ," +
    "height ," +
    "weight ," +
    "fundalHeight ," +
    "hBAtReg ," +
    "hBAt36Weeks ," +
    "urineTestSugar ," +
    "urineTestProtein ," +
    "EDD ," +
    "bloodGroup ," +
    "vDLabResults ," +
    "preTestCounsel ," +
    "postTestCounsel ," +
    "bloodFilm ," +
    "ARV ," +
    "iTN ," +
    "complaints ," +
    "remarks ," +
    "maleInvolvement ," +
    "systolicBP ," +
    "diastolicBP ," +
    "trimester ," +
    "subVisits ," +
    "hIVResults ," +
    "sicklingStatus ," +
    "sicklingType, " +
    "updated, " +
    "created, " +
    "id" +
    ") VALUES (" +
    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
    "?, ?)";

  private static final String
    ALL = "SELECT * FROM antenatal_record";

  private static final String
    FIND_BY_ID = "SELECT * FROM antenatal_record WHERE id = ?";

  private static final String
    DELETE = "DELETE FROM antenatal_record WHERE id = ?";

  private static final String
    UPDATE = "UPDATE antenatal_record SET " +
    "parity = ?, " +
    "gestation = ?, " +
    "iPTDoses = ?, " +
    "TTDoses = ?, " +
    "height = ?, " +
    "weight = ?, " +
    "fundalHeight = ?, " +
    "hBAtReg = ?, " +
    "hBAt36Weeks = ?, " +
    "urineTestSugar = ?, " +
    "urineTestProtein = ?, " +
    "EDD = ?, " +
    "bloodGroup = ?, " +
    "vDLabResults = ?, " +
    "preTestCounsel = ?, " +
    "postTestCounsel = ?, " +
    "bloodFilm = ?, " +
    "ARV = ?, " +
    "iTN = ?, " +
    "complaints = ?, " +
    "remarks = ?, " +
    "maleInvolvement = ?, " +
    "systolicBP = ?, " +
    "diastolicBP = ?, " +
    "trimester = ?, " +
    "subVisits = ?, " +
    "hIVResults = ?, " +
    "sicklingStatus = ?, " +
    "sicklingType = ?, " +
    "updated = ? " +
    "WHERE id = ?";

  public PostgresVisitDao() {
  }

  @Override
  public int add(String id, PregnancyVisit record) {
    try {
      Connection c = DaoFactory.getDatabase().openConnection();
      PreparedStatement query = c.prepareStatement(INSERT);

      Date edd = null;
      if (record.getEDD() != null) {
        edd = Date.valueOf(record.getEDD());
      }

      query.setInt(1, record.getParity());
      query.setInt(2, record.getGestation());
      query.setInt(3, record.getIPTDoses());
      query.setString(4, record.getTTDoses());
      query.setDouble(5, record.getHeight());
      query.setDouble(6, record.getWeight());
      query.setDouble(7, record.getFundalHeight());
      query.setDouble(8, record.getHBAtReg());
      query.setDouble(9, record.gethBAt36Weeks());
      query.setDouble(10, record.getUrineTestSugar());
      query.setDouble(11, record.getUrineTestProtein());
      query.setDate(12, edd);
      query.setString(13, record.getBloodGroup());
      query.setString(14, record.getVDLabResults());
      query.setString(15, record.getPreTestCounsel());
      query.setString(16, record.getPostTestCounsel());
      query.setString(17, record.getBloodFilm());
      query.setString(18, record.getARV());
      query.setString(19, record.getITN());
      query.setString(20, record.getComplaints());
      query.setString(21, record.getRemarks());
      query.setString(22, record.getMaleInvolvement());
      query.setInt(23, record.getSystolicBP());
      query.setInt(24, record.getDiastolicBP());
      query.setInt(25, record.getTrimester());
      query.setInt(26, record.getSubVisits());
      query.setString(27, record.getHIVResults());
      query.setString(28, record.getSicklingStatus());
      query.setString(29, record.getSicklingType());

      query.setDate(30, new Date(Calendar.getInstance().getTimeInMillis()));
      query.setDate(31, new Date(Calendar.getInstance().getTimeInMillis()));

      query.setObject(32, UUID.fromString(record.getId()));
      int result = query.executeUpdate();
      DaoFactory.getDatabase().closeConnection();
      return result;
    } catch (SQLException | IllegalAccessException | InstantiationException | JSchException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return 0;
  }

  @Override
  public int update(String id, PregnancyVisit record) {
    try {
      Connection c = DaoFactory.getDatabase().openConnection();
      PreparedStatement query = c.prepareStatement(UPDATE);

      Date edd = null;
      if (record.getEDD() != null) {
        edd = Date.valueOf(record.getEDD());
      }

      query.setInt(1, record.getParity());
      query.setInt(2, record.getGestation());
      query.setInt(3, record.getIPTDoses());
      query.setString(4, record.getTTDoses());
      query.setDouble(5, record.getHeight());
      query.setDouble(6, record.getWeight());
      query.setDouble(7, record.getFundalHeight());
      query.setDouble(8, record.getHBAtReg());
      query.setDouble(9, record.gethBAt36Weeks());
      query.setDouble(10, record.getUrineTestSugar());
      query.setDouble(11, record.getUrineTestProtein());
      query.setDate(12, edd);
      query.setString(13, record.getBloodGroup());
      query.setString(14, record.getVDLabResults());
      query.setString(15, record.getPreTestCounsel());
      query.setString(16, record.getPostTestCounsel());
      query.setString(17, record.getBloodFilm());
      query.setString(18, record.getARV());
      query.setString(19, record.getITN());
      query.setString(20, record.getComplaints());
      query.setString(21, record.getRemarks());
      query.setString(22, record.getMaleInvolvement());
      query.setInt(23, record.getSystolicBP());
      query.setInt(24, record.getDiastolicBP());
      query.setInt(25, record.getTrimester());
      query.setInt(26, record.getSubVisits());
      query.setString(27, record.getHIVResults());
      query.setString(28, record.getSicklingStatus());
      query.setString(29, record.getSicklingType());

      Calendar date = Calendar.getInstance();
      query.setTimestamp(30, new Timestamp(date.getTime().getTime()));

      query.setObject(31, UUID.fromString(record.getId()));

      int result = query.executeUpdate();
      DaoFactory.getDatabase().closeConnection();

      return result;
    } catch (SQLException | IllegalAccessException | JSchException | ClassNotFoundException | InstantiationException e) {
      e.printStackTrace();
    }
    return 0;
  }

  @Override
  public int remove(String id) {
    try {
      Connection c = DaoFactory.getDatabase().openConnection();
      PreparedStatement query = c.prepareStatement(DELETE);
      query.setObject(1, UUID.fromString(id));
      int result = query.executeUpdate();
      DaoFactory.getDatabase().closeConnection();
      return result;
    } catch (SQLException | IllegalAccessException | JSchException | InstantiationException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    return 0;
  }

  @Override
  public PregnancyVisit find(String key) {
    try {
      Connection c = DaoFactory.getDatabase().openConnection();
      PreparedStatement query = c.prepareStatement(FIND_BY_ID);
      query.setObject(1, UUID.fromString(key));
      ResultSet rs = query.executeQuery();
      rs.next();
      DaoFactory.getDatabase().closeConnection();
      return createRecord(rs);
    } catch (SQLException | IllegalAccessException | JSchException | ClassNotFoundException | InstantiationException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public List<PregnancyVisit> list() {
    try {
      Connection c = DaoFactory.getDatabase().openConnection();
      PreparedStatement query = c.prepareStatement(ALL);
      ResultSet rs = query.executeQuery();

      List<PregnancyVisit> results = new ArrayList<>();

      while (rs.next()) results.add(createRecord(rs));
      DaoFactory.getDatabase().closeConnection();
      return results;
    } catch (SQLException | IllegalAccessException | JSchException | ClassNotFoundException | InstantiationException e) {
      e.printStackTrace();
    }
    return null;
  }

  private PregnancyVisit createRecord(ResultSet rs) {
    try {
      return new PregnancyVisit(rs);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
}
