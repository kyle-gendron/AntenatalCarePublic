package edu.usm.cos420.antenatal.dao.postgres;

import edu.usm.cos420.antenatal.dao.interfaces.IAntenatalSubVisit;
import edu.usm.cos420.antenatal.dao.interfaces.IAntenatalVisit;
import edu.usm.cos420.antenatal.domain.PregnancySubVisit;
import edu.usm.cos420.antenatal.domain.PregnancyRecord;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * Created by aaron on 4/16/2016.
 */
public class PregnancySubVisitDao implements IAntenatalSubVisit {

	private static final String
	INSERT = "INSERT INTO subvisit_record (subid, pregnancyid,"
			+ "systolicbp,diastolicbp,weight,fh,apptdate,bloodfilm,refer,created ) VALUES (?, ?)";
	private static final String
	ALL = "SELECT * FROM subvisit_record";
	private static final String
	FIND_BY_ID = "SELECT * FROM subvisit_record WHERE subid = ?";
	private static final String
	DELETE =  "DELETE FROM subvisit_record WHERE subid = ?";
	private static final String
	UPDATE = "Update subvisit_record SET "+
			"systolicbp = ? "+
			"diastolicbp = ? "+
			"weight = ? "+
			"fh = ? "+
			"apptdate = ? "+
			"bloodfilm =  ? "+
			"refer = ? "+
			"updated = ? "+
			"WHERE id = ?";



	private final Connection connection;

	public PregnancySubVisitDao(Connection connection) {
		this.connection = connection;
	}
	@Override
	public int add(PregnancySubVisit record) throws SQLException {
		PreparedStatement query = connection.prepareStatement(INSERT);
		query.setObject(1, UUID.fromString(record.getID()));
		query.setObject(2, UUID.fromString(record.getInitialID()));
		query.setInt(3, record.getSystolicBP());
		query.setInt(4, record.getDiastolicBP());
		query.setDouble(5, record.getWeight());
		query.setDouble(6, record.getFundalHeight());
		Date apptdate = null;
		if (record.getApptDate() != null) {
			apptdate = Date.valueOf(record.getApptDate());
		}
		query.setDate(7, apptdate);
		query.setString(8, record.bloodFilmResults());
		query.setString(9, record.getReferral());
		Calendar date = Calendar.getInstance();
		query.setTimestamp(10, new Timestamp(date.getTime().getTime()));
		
		return query.executeUpdate();
	}

	@Override
	public int update(PregnancySubVisit record) throws SQLException {
		PreparedStatement query  =  connection.prepareStatement(UPDATE);
		
		query.setInt(1, record.getSystolicBP());
		query.setInt(2, record.getDiastolicBP());
		query.setDouble(3, record.getWeight());
		query.setDouble(4, record.getFundalHeight());
		Date apptdate = null;
		if (record.getApptDate() != null) {
			apptdate = Date.valueOf(record.getApptDate());
		}
		query.setDate(5, apptdate);
		query.setString(6, record.bloodFilmResults());
		query.setString(7, record.getReferral());
		Calendar date = Calendar.getInstance();
		query.setTimestamp(8, new Timestamp(date.getTime().getTime()));
		return query.executeUpdate();
		
	}

	@Override
	public int remove(String id) throws SQLException {
		PreparedStatement query  =  connection.prepareStatement(DELETE);
		query.setObject(1, UUID.fromString(id));
		return query.executeUpdate();
		
	}

	@Override
	public PregnancySubVisit find(String key) throws SQLException {
		PreparedStatement query = connection.prepareStatement(FIND_BY_ID);
		query.setObject(1, UUID.fromString(key));
		ResultSet rs= query.executeQuery();
		rs.next();
		return createRecord(rs);
	}

	@Override
	public List<PregnancySubVisit> list() throws SQLException {
		PreparedStatement query = connection.prepareStatement(ALL);
		ResultSet rs = query.executeQuery();
		
		List<PregnancySubVisit> results = new ArrayList<>();
		while(rs.next()) results.add(createRecord(rs));
		return results;
	}
	private PregnancySubVisit createRecord(ResultSet rs) throws SQLException {
		return new PregnancySubVisit(rs);
	}
}
