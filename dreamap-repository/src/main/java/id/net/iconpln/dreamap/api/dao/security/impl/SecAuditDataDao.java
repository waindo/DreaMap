package id.net.iconpln.dreamap.api.dao.security.impl;

import id.net.iconpln.dreamap.api.dao.security.ISecAuditDataDao;
import id.net.iconpln.dreamap.api.dao.security.ISecAuditLogDao;
import id.net.iconpln.dreamap.api.dao.security.ISecTableDao;
import id.net.iconpln.dreamap.api.model.security.SecAuditData;
import id.net.iconpln.dreamap.api.support.DatabaseSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Syakuru Hadi on 12/23/2014.
 */
@Repository("secAuditDataDao")
@Transactional(readOnly = true)
public class SecAuditDataDao extends DatabaseSupport<SecAuditData> implements ISecAuditDataDao {

    @Autowired
    private ISecTableDao secTableDao;

    @Autowired
    private ISecAuditLogDao secAuditLogDao;

    public SecAuditDataDao() {
        tablename = "SEC_AUDIT_DATA";
    }

    private class SecAuditDataMapper implements ParameterizedRowMapper<SecAuditData> {
        public SecAuditData mapRow(ResultSet resultSet, int index) throws SQLException {
            SecAuditData auditData = new SecAuditData();
            auditData.setAuditDataId(resultSet.getLong("AUDIT_DATA_ID"));
            auditData.setSecAuditLog(secAuditLogDao.findById(resultSet.getLong("AUDIT_LOG_ID")));
            auditData.setSecTable(secTableDao.findById(resultSet.getLong("TABLE_ID")));
            auditData.setColumnName(resultSet.getString("COLUMN_NAME"));
            auditData.setOldValue(resultSet.getString("OLD_VALUE"));
            auditData.setNewValue(resultSet.getString("NEW_VALUE"));
            auditData.setLastUpdated(resultSet.getTimestamp("LAST_UPDATED"));
            auditData.setUpdater(resultSet.getString("UPDATER"));
            return auditData;
        }
    }

}
