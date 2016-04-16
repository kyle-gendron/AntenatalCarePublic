package edu.usm.cos420.antenatal.dao.postgres;

import edu.usm.cos420.antenatal.dao.interfaces.IAntenatalVisit;
import edu.usm.cos420.antenatal.domain.PregnancyRecord;

import java.sql.Connection;
import java.util.List;

/**
 * Created by aaron on 4/16/2016.
 */
public class AntenatalSubVisitDao implements IAntenatalVisit {
  private final Connection connection;

  public AntenatalSubVisitDao(Connection connection) {
    this.connection = connection;
  }

  @Override
  public int add(PregnancyRecord record) {
    return 0;
  }

  @Override
  public int update(PregnancyRecord record) {
    return 0;

  }

  @Override
  public int remove(String id) {
    return 0;
  }

  @Override
  public PregnancyRecord find(String key) {
    return null;
  }

  @Override
  public List<PregnancyRecord> list() {
    return null;
  }
}
