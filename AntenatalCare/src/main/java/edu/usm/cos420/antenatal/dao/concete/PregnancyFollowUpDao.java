package edu.usm.cos420.antenatal.dao.concete;

import com.jcraft.jsch.JSchException;
import edu.usm.cos420.antenatal.dao.interfaces.IAntenatalRecord;
import edu.usm.cos420.antenatal.daoFactory.DaoFactory;
import edu.usm.cos420.antenatal.domain.PregnancyFollowUp;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by aaron on 4/16/2016.
 */
@SuppressWarnings("ALL")
public class PregnancyFollowUpDao implements IAntenatalRecord<PregnancyFollowUp> {

  private static final String
    INSERT = "INSERT INTO subvisit_record (subid, pregnancyid,"
    + "systolicbp,diastolicbp,weight,fh,apptdate,bloodfilm,refer,created ) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
  private static final String
    ALL = "SELECT * FROM subvisit_record";
  private static final String
    ALLKEY = "SELECT * FROM subvisit_record WHERE pregnancyid = ?";
  private static final String
    FIND_BY_ID = "SELECT * FROM subvisit_record WHERE subid = ?";
  private static final String
    DELETE = "DELETE FROM subvisit_record WHERE subid = ?";
  private static final String
    UPDATE = "Update subvisit_record SET " +
    "systolicbp = ? " +
    "diastolicbp = ? " +
    "weight = ? " +
    "fh = ? " +
    "apptdate = ? " +
    "bloodfilm =  ? " +
    "refer = ? " +
    "updated = ? " +
    "WHERE subid = ?";

  public PregnancyFollowUpDao() {
  }

  @Override
  public int add(String id, PregnancyFollowUp record) {
    PreparedStatement query;
    try {
      Connection c = DaoFactory.getDatabase().openConnection();
      query = c.prepareStatement(INSERT);
      query.setObject(1, UUID.fromString(record.getId()));
      query.setObject(2, UUID.fromString(record.getInitialID()));
      query.setInt(3, record.getSystolicBP());
      query.setInt(4, record.getDiastolicBP());
      query.setDouble(5, record.getWeight());
      query.setDouble(6, record.getFundalHeight());
      Date apptDate = null;
      if (record.getApptDate() != null) {
        apptDate = Date.valueOf(record.getApptDate());
      }
      query.setDate(7, apptDate);
      query.setString(8, record.getBloodFilm());
      query.setString(9, record.getReferral());
      Calendar date = Calendar.getInstance();
      query.setTimestamp(10, new Timestamp(date.getTime().getTime()));
      int result = query.executeUpdate();
      DaoFactory.getDatabase().closeConnection();
      return result;
    } catch (SQLException | IllegalAccessException | JSchException | ClassNotFoundException | InstantiationException e) {
      e.printStackTrace();
    }

    return -1;
  }

  @Override
  public int update(String id, PregnancyFollowUp record) {
    PreparedStatement query;
    try {
      Connection c = DaoFactory.getDatabase().openConnection();
      query = c.prepareStatement(UPDATE);
      Date aptDate = null;
      if (record.getApptDate() != null) {
        aptDate = Date.valueOf(record.getApptDate());
      }

      query.setInt(1, record.getSystolicBP());
      query.setInt(2, record.getDiastolicBP());
      query.setDouble(3, record.getWeight());
      query.setDouble(4, record.getFundalHeight());
      query.setDate(5, aptDate);
      query.setString(6, record.getBloodFilm());
      query.setString(7, record.getReferral());
      Calendar date = Calendar.getInstance();
      query.setTimestamp(8, new Timestamp(date.getTime().getTime()));
      query.setObject(9, record.getId());
      int result = query.executeUpdate();
      DaoFactory.getDatabase().closeConnection();
      return result;
    } catch (SQLException | IllegalAccessException | JSchException | ClassNotFoundException | InstantiationException e) {
      e.printStackTrace();
    }
    return -1;
  }

  @Override
  public int remove(String id) {
    PreparedStatement query;
    try {
      Connection c = DaoFactory.getDatabase().openConnection();
      query = c.prepareStatement(DELETE);
      query.setObject(1, UUID.fromString(id));
      int result = query.executeUpdate();
      DaoFactory.getDatabase().closeConnection();
      return result;
    } catch (SQLException | ClassNotFoundException | JSchException | InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return -1;

  }

  @Override
  public PregnancyFollowUp find(String key) {
    PreparedStatement query;
    try {
      Connection c = DaoFactory.getDatabase().openConnection();
      query = c.prepareStatement(FIND_BY_ID);
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
  public List<PregnancyFollowUp> list() {
    PreparedStatement query;
    try {
      Connection c = DaoFactory.getDatabase().openConnection();
      query = c.prepareStatement(ALL);
      ResultSet rs = query.executeQuery();

      List<PregnancyFollowUp> results = new ArrayList<>();
      while (rs.next()) results.add(createRecord(rs));
      DaoFactory.getDatabase().closeConnection();
      return results;
    } catch (SQLException | IllegalAccessException | JSchException | ClassNotFoundException | InstantiationException e) {
      e.printStackTrace();
    }
    return null;
  }

  public List<PregnancyFollowUp> pregList(String key) throws SQLException {
    try {
      Connection c = DaoFactory.getDatabase().openConnection();
      PreparedStatement query = c.prepareStatement(ALLKEY);
      query.setObject(1, UUID.fromString(key));
      ResultSet rs = query.executeQuery();

      List<PregnancyFollowUp> results = new ArrayList<>();
      while (rs.next()) results.add(createRecord(rs));
      DaoFactory.getDatabase().closeConnection();
      return results;
    } catch (ClassNotFoundException | JSchException | InstantiationException | IllegalAccessException e) {
      e.printStackTrace();
    }
    return null;
  }

  private PregnancyFollowUp createRecord(ResultSet rs) throws SQLException {
    return new PregnancyFollowUp(rs);
  }
}
