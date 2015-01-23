package id.net.iconpln.dreamap.api.dao.security.impl;

import id.net.iconpln.dreamap.api.dao.security.ISecAuditLogDao;
import id.net.iconpln.dreamap.api.dao.security.ISecTableDao;
import id.net.iconpln.dreamap.api.model.security.SecAuditLog;
import id.net.iconpln.dreamap.api.support.DatabaseSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Syakuru Hadi on 12/23/2014.
 */
@Repository("secAuditLogDao")
@Transactional(readOnly = true)
public class SecAuditLogDao extends DatabaseSupport<SecAuditLog> implements ISecAuditLogDao {

    @Autowired
    private ISecTableDao secTableDao;

    public SecAuditLogDao() {
        tablename = "SEC_AUDIT_LOG";
    }

    private class SecAuditLogMapper implements ParameterizedRowMapper<SecAuditLog> {
        public SecAuditLog mapRow(ResultSet resultSet, int index) throws SQLException {
            SecAuditLog auditLog = new SecAuditLog();
            auditLog.setAuditLogId(resultSet.getLong("AUDIT_LOG_ID"));
            auditLog.setSecTable(secTableDao.findById(resultSet.getLong("TABLE_ID")));
            auditLog.setAuditType(resultSet.getString("AUDIT_TYPE"));
            auditLog.setPrimaryReffId(resultSet.getString("PRIMARY_REFF_ID"));
            auditLog.setIpAddress(resultSet.getString("IP_ADDRESS"));
            auditLog.setLastUpdated(resultSet.getTimestamp("LAST_UPDATER"));
            auditLog.setUpdater(resultSet.getString("UPDATER"));
            return auditLog;
        }
    }

    public SecAuditLog findById(Long auditLogId) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM SEC_AUDIT_LOG WHERE AUDIT_LOG_ID = ?", new SecAuditLogMapper(), auditLogId);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

}
