package id.net.iconpln.dreamap.api.dao.security.impl;

import id.net.iconpln.dreamap.api.dao.security.ISecTableDao;
import id.net.iconpln.dreamap.api.model.security.SecTable;
import id.net.iconpln.dreamap.api.support.DatabaseSupport;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Syakuru Hadi on 12/23/2014.
 */
@Repository("secTableDao")
@Transactional(readOnly = true)
public class SecTableDao extends DatabaseSupport<SecTable> implements ISecTableDao {

    public SecTableDao() {
        tablename = "SEC_TABLE";
    }

    private class SecTableMapper implements ParameterizedRowMapper<SecTable> {
        public SecTable mapRow(ResultSet resultSet, int index) throws SQLException {
            SecTable table = new SecTable();
            table.setTableId(resultSet.getLong("TABLE_ID"));
            table.setTableName(resultSet.getString("TABLE_NAME"));
            table.setTableDesc(resultSet.getString("TABLE_DESC"));
            table.setAudit(resultSet.getBoolean("IS_AUDIT"));
            table.setLastUpdated(resultSet.getTimestamp("LAST_UPDATED"));
            table.setUpdater(resultSet.getString("UPDATER"));
            return table;
        }
    }

    public SecTable findById(Long tableId) {
        try {
            return jdbcTemplate.queryForObject("SELECT SEC_TABLE.* FROM SEC_TABLE WHERE TABLE_ID = ?", new SecTableMapper(), tableId);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

}
