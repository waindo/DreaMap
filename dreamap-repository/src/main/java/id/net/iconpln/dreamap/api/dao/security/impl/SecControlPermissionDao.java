package id.net.iconpln.dreamap.api.dao.security.impl;

import id.net.iconpln.dreamap.api.dao.security.ISecControlPermissionDao;
import id.net.iconpln.dreamap.api.dao.security.ISecProgramDao;
import id.net.iconpln.dreamap.api.model.security.SecControlPermission;
import id.net.iconpln.dreamap.api.support.DatabaseSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Syakuru Hadi on 12/23/2014.
 */
@Repository("secControlPermissionDao")
@Transactional(readOnly = true)
public class SecControlPermissionDao extends DatabaseSupport<SecControlPermission> implements ISecControlPermissionDao {

    @Autowired
    private ISecProgramDao programDao;

    public SecControlPermissionDao() {
        tablename = "SEC_CONTROL_PERMISSION";
    }

    private class SecControlPermissionMapper implements ParameterizedRowMapper<SecControlPermission> {
        public SecControlPermission mapRow(ResultSet resultSet, int index) throws SQLException {
            SecControlPermission controlPermission = new SecControlPermission();
            controlPermission.setControlPermissionId(resultSet.getLong("CONTROL_PERMISSION_ID"));	//NOPMD
//			controlPermission.setUser(user);
            controlPermission.setProgram(programDao.getProgramByNo(resultSet.getString("PROGRAM_NO")));
            controlPermission.setAllowView(resultSet.getBoolean("IS_ALLOW_VIEW"));
            controlPermission.setAllowEntry(resultSet.getBoolean("IS_ALLOW_ENTRY"));
            controlPermission.setAllowEdit(resultSet.getBoolean("IS_ALLOW_EDIT"));
            controlPermission.setAllowDelete(resultSet.getBoolean("IS_ALLOW_DELETE"));
            controlPermission.setAllowPrint(resultSet.getBoolean("IS_ALLOW_PRINT"));
            controlPermission.setAllowExport(resultSet.getBoolean("IS_ALLOW_EXPORT"));
            controlPermission.setAllowAuditLog(resultSet.getBoolean("IS_ALLOW_AUDIT_LOG"));
            controlPermission.setAllowValidate(resultSet.getBoolean("IS_ALLOW_VALIDATE"));
            controlPermission.setAllowUnvalidate(resultSet.getBoolean("IS_ALLOW_UNVALIDATE"));
            controlPermission.setAllowApprove(resultSet.getBoolean("IS_ALLOW_APPROVE"));
            controlPermission.setAllowUnapprove(resultSet.getBoolean("IS_ALLOW_UNAPPROVE"));
            controlPermission.setAllowRelease(resultSet.getBoolean("IS_ALLOW_RELEASE"));
            controlPermission.setAllowUnrelease(resultSet.getBoolean("IS_ALLOW_UNRELEASE"));
            controlPermission.setActive(resultSet.getBoolean("ACTIVE"));
            controlPermission.setLastUpdated(resultSet.getTimestamp("LAST_UPDATED"));
            controlPermission.setUpdater(resultSet.getString("UPDATER"));
            return controlPermission;
        }
    }

    public List<SecControlPermission> findAll() {
        getDatabaseSupport().setOrderBy("CONTROL_PERMISSION_ID");
        return getDatabaseSupport().findAll(new SecControlPermissionMapper());
    }

    public List<SecControlPermission> findAll(int firstRecord, int lastRecord) {
        getDatabaseSupport().setOrderBy("CONTROL_PERMISSION_ID");
        return getDatabaseSupport().findAll(firstRecord, lastRecord, new SecControlPermissionMapper());
    }

    public List<SecControlPermission> findAllByFilter(int firstRecord,
                                                      int lastRecord, String filter) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecControlPermission> findAllByUser() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecControlPermission> findAllByUser(Long userId) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecControlPermission findById(Long controlPermissionId) {
        try {
            return jdbcTemplate.queryForObject("SELECT SEC_CONTROL_PERMISSION.* WHERE CONTROL_PERMISSION_ID = ?", new SecControlPermissionMapper(), controlPermissionId);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Transactional(readOnly = false)
    public int save(SecControlPermission controlPermission) {
        int status = 0;
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("USER_ID", controlPermission.getUser().getUserId());
        maps.put("PROGRAM_NO", controlPermission.getProgram().getProgramNo());
        maps.put("IS_ALLOW_VIEW", controlPermission.isAllowView());
        maps.put("IS_ALLOW_ENTRY", controlPermission.isAllowEntry());
        maps.put("IS_ALLOW_EDIT", controlPermission.isAllowEdit());
        maps.put("IS_ALLOW_DELETE", controlPermission.isAllowDelete());
        maps.put("IS_ALLOW_PRINT", controlPermission.isAllowPrint());
        maps.put("IS_ALLOW_EXPORT", controlPermission.isAllowExport());
        maps.put("IS_ALLOW_AUDIT_LOG", controlPermission.isAllowAuditLog());
        maps.put("IS_ALLOW_VALIDATE", controlPermission.isAllowValidate());
        maps.put("IS_ALLOW_UNVALIDATE", controlPermission.isAllowUnvalidate());
        maps.put("IS_ALLOW_APPROVE", controlPermission.isAllowApprove());
        maps.put("IS_ALLOW_UNAPPROVE", controlPermission.isAllowUnapprove());
        maps.put("IS_ALLOW_RELEASE", controlPermission.isAllowRelease());
        maps.put("IS_ALLOW_UNRELEASE", controlPermission.isAllowUnrelease());
        maps.put("ACTIVE", controlPermission.isActive());
        maps.put("LAST_UPDATED", controlPermission.getLastUpdated());
        maps.put("UPDATER", controlPermission.getUpdater());
        if(findById(controlPermission.getControlPermissionId()) != null) {
            String[] primaryKeys = {"CONTROL_PERMISSION_ID"};
            Object[] keyValues = {controlPermission.getControlPermissionId()};
            status = getDatabaseSupport().updateGlobal(primaryKeys, keyValues, maps.keySet().toArray(new String[]{}), maps.values().toArray());
        } else {
            maps.put("CONTROL_PERMISSION_ID", controlPermission.getControlPermissionId());
            status = getDatabaseSupport().saveGlobal(maps.keySet().toArray(new String[]{}), maps.values().toArray());
        }
        return status;
    }

    public int delete(Long controlPermissionId) {
        String[] primaryKeys = {"CONTROL_PERMISSION_ID"};
        Object[] keyValues = {controlPermissionId};
        return getDatabaseSupport().deleteGlobal(primaryKeys, keyValues);
    }

    public int count() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countByFilter(String filter) {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countByUser(Long userId) {
        // TODO Auto-generated method stub
        return 0;
    }

}
