package id.net.iconpln.dreamap.api.dao.security.impl;

import id.net.iconpln.dreamap.api.dao.security.ISecProgramDao;
import id.net.iconpln.dreamap.api.model.security.SecProgram;
import id.net.iconpln.dreamap.api.support.DatabaseSupport;
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
@Repository("secProgramDao")
@Transactional(readOnly = true)
public class SecProgramDao extends DatabaseSupport<SecProgram> implements ISecProgramDao {

    private final String PROGRAM_NO = "PROGRAM_NO";

    public SecProgramDao() {
        tablename = "SEC_PROGRAM";
    }

    private class SecProgramMapper implements ParameterizedRowMapper<SecProgram> {
        public SecProgram mapRow(ResultSet resultSet, int index) throws SQLException {
            SecProgram program = new SecProgram();
            program.setProgramNo(resultSet.getString(PROGRAM_NO));
            program.setProgramDesc(resultSet.getString("PROGRAM_DESC"));
            program.setFileName(resultSet.getString("FILE_NAME"));
            program.setUseView(resultSet.getBoolean("IS_USE_VIEW"));
            program.setUseEntry(resultSet.getBoolean("IS_USE_ENTRY"));
            program.setUseEdit(resultSet.getBoolean("IS_USE_EDIT"));
            program.setUseDelete(resultSet.getBoolean("IS_USE_DELETE"));
            program.setUseExport(resultSet.getBoolean("IS_USE_EXPORT"));
            program.setUsePrint(resultSet.getBoolean("IS_USE_PRINT"));
            program.setUseAuditLog(resultSet.getBoolean("IS_USE_AUDIT_LOG"));
            program.setUseApprove(resultSet.getBoolean("IS_USE_APPROVE"));
            program.setUseUnapprove(resultSet.getBoolean("IS_USE_UNAPPROVE"));
            program.setUseValidate(resultSet.getBoolean("IS_USE_VALIDATE"));
            program.setUseUnvalidate(resultSet.getBoolean("IS_USE_UNVALIDATE"));
            program.setUseRelease(resultSet.getBoolean("IS_USE_RELEASE"));
            program.setUseUnrelease(resultSet.getBoolean("IS_USE_UNRELEASE"));
            program.setActive(resultSet.getBoolean("ACTIVE"));
            program.setLastUpdated(resultSet.getTimestamp("LAST_UPDATED"));
            program.setUpdater(resultSet.getString("UPDATER"));
            return program;
        }
    }

    public List<SecProgram> getExcludeProgramsByUserGroupNo(String userGroupNo) {
        // TODO Auto-generated method stub
        return null;
    }

	/*@Override
	public List<SecProgram> getProgramsByUserGroupNo(String userGroupNo) {
		// TODO Auto-generated method stub
		return null;
	}*/

    public List<SecProgram> getProgramsByUserId(Long userId) {
        Object[] values = {userId};
        return jdbcTemplate.query("SELECT * FROM TABLE(DREAMAP.FN_GET_PROGRAM_BY_USER_ID(?))", values, new SecProgramMapper());
    }

    public List<SecProgram> getPrograms() {
        return getDatabaseSupport().findAll(new SecProgramMapper());
    }

    public List<SecProgram> getPrograms(int firstRecord, int lastRecord) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecProgram> getProgramsByFilter(int firstRecord,
                                                int lastRecord, String filter) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecProgram getProgramByUrl(String urlAddress) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecProgram getProgramByNo(String programNo) {
        // TODO Auto-generated method stub
        return null;
    }

    public int countProgram() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countProgramByFilter(String filter) {
        // TODO Auto-generated method stub
        return 0;
    }

    public int saveProgram(SecProgram program) {
        int status = 0;
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("PROGRAM_DESC", program.getProgramDesc() == null ? "" : program.getProgramDesc());
        maps.put("DISPLAY_NAME", program.getDisplayName());
        maps.put("URL_ADDRESS", program.getUrlAddress());
        maps.put("FILE_NAME", program.getFileName());
        maps.put("IS_USE_VIEW", program.isUseView());
        maps.put("IS_USE_ENTRY", program.isUseEntry());
        maps.put("IS_USE_EDIT", program.isUseEdit());
        maps.put("IS_USE_DELETE", program.isUseDelete());
        maps.put("IS_USE_PRINT", program.isUsePrint());
        maps.put("IS_USE_EXPORT", program.isUseExport());
        maps.put("IS_USE_AUDIT_LOG", program.isUseAuditLog());
        maps.put("IS_USE_APPROVE", program.isUseApprove());
        maps.put("IS_USE_UNAPPROVE", program.isUseUnapprove());
        maps.put("IS_USE_VALIDATE", program.isUseValidate());
        maps.put("IS_USE_UNVALIDATE", program.isUseUnvalidate());
        maps.put("IS_USE_RELEASE", program.isUseRelease());
        maps.put("IS_USE_UNRELEASE", program.isUseUnrelease());
        maps.put("ACTIVE", program.isActive());
        maps.put("LAST_UPDATED", program.getLastUpdated());
        maps.put("UPDATER", program.getUpdater());
        if(getProgramByNo(program.getProgramNo()) != null) {
            String[] keyNames = {PROGRAM_NO};
            Object[] keyValues = {program.getProgramNo()};
            status = getDatabaseSupport().updateGlobal(keyNames, keyValues, maps.keySet().toArray(new String[]{}), maps.values().toArray());
        } else {
            maps.put(PROGRAM_NO, program.getProgramNo());
            status = getDatabaseSupport().saveGlobal(maps.keySet().toArray(new String[]{}), maps.values().toArray());
        }
        return status;
    }

    public int deleteProgram(String programNo) {
        String[] keyNames = {PROGRAM_NO};
        Object[] keyValues = {programNo};
        return getDatabaseSupport().deleteGlobal(keyNames, keyValues);
    }

    public SecProgram findByFirstRecord(String keyName) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecProgram findByPrevRecord(String keyName, String keyValue) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecProgram findByNextRecord(String keyName, String keyValue) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecProgram findByLastRecord(String keyName) {
        // TODO Auto-generated method stub
        return null;
    }

}
