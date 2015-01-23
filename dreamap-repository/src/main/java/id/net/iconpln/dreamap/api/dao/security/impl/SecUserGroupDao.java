package id.net.iconpln.dreamap.api.dao.security.impl;

import id.net.iconpln.dreamap.api.dao.security.ISecUserGroupDao;
import id.net.iconpln.dreamap.api.model.security.SecUserGroup;
import id.net.iconpln.dreamap.api.support.DatabaseSupport;
import id.net.iconpln.dreamap.api.util.CommonModule;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Syakuru Hadi on 12/23/2014.
 */
@Repository("secUserGroupDao")
@Transactional(readOnly = true)
public class SecUserGroupDao extends DatabaseSupport<SecUserGroup> implements ISecUserGroupDao {

    private final String USER_GROUP_NO = "USER_GROUP_NO";
    public SecUserGroupDao() {
        tablename = "SEC_USER_GROUP";
    }

    @Override
    public List<SecUserGroup> findAll(int start, int end) {
        getDatabaseSupport().setOrderBy(USER_GROUP_NO);
        return getDatabaseSupport().findAll(start, end, new SecUserGroupMapper());
    }

    @Override
    public List<SecUserGroup> findByFilter(int start, int end, String filter) {
        getDatabaseSupport().setOrderBy("USER_GROUP_NO");
        String[] columns = {"USER_GROUP_NO","USER_GROUP_NAME"};
        return getDatabaseSupport().findByFilter(start, end, filter, columns, new SecUserGroupMapper());
    }

    @Override
    public SecUserGroup findById(String userGroupNo) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM SEC_USER_GROUP WHERE USER_GROUP_NO = ?", new SecUserGroupMapper(), userGroupNo);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<SecUserGroup> getUserGroups() {
//        getDatabaseSupport().setOrderBy(USER_GROUP_NO);
//        return getDatabaseSupport().findAll(new SecUserGroupMapper());
        return jdbcTemplate.query("SELECT * FROM SEC_USER_GROUP ORDER BY USER_GROUP_NO ASC", new SecUserGroupMapper());
    }

    @Override
    public List<SecUserGroup> getUserGroups(int firstRecord, int lastRecord) {
        return null;
    }

    @Override
    public List<SecUserGroup> getUserGroupsByFilter(int firstRecord, int lastRecord, String filter) {
        return null;
    }

    @Override
    public SecUserGroup getUserGroupById(String userGroupNo) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM SEC_USER_GROUP WHERE USER_GROUP_NO = ?", new SecUserGroupMapper(), userGroupNo);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public int count() {
        return getDatabaseSupport().count(tablename);
    }

    @Override
    public int countByFilter(String filter) {
        String[] columns = {"USER_GROUP_NO","USER_GROUP_NAME"};
        return getDatabaseSupport().countByFilter(tablename, filter, columns);
    }

    @Transactional(readOnly = false)
    @Override
    public int saveUserGroup(SecUserGroup secUserGroup) {
        int status = 0;
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("USER_GROUP_NAME", secUserGroup.getUserGroupName());
        maps.put("USER_GROUP_DESC", secUserGroup.getUserGroupDesc());
        maps.put("ACTIVE", secUserGroup.isActive());
        maps.put("LAST_UPDATED", secUserGroup.getLastUpdated());
        maps.put("UPDATER", secUserGroup.getUpdater());
        if(findById(secUserGroup.getUserGroupNo()) != null) {
            String[] primaryKeys = {"USER_GROUP_NO"};
            Object[] keyValues = {secUserGroup.getUserGroupNo()};
            status = getDatabaseSupport().updateGlobal(primaryKeys, keyValues, maps.keySet().toArray(new String[]{}), maps.values().toArray());
        }  else {
            maps.put("USER_GROUP_NO", secUserGroup.getUserGroupNo());
            status = getDatabaseSupport().saveGlobal(maps.keySet().toArray(new String[]{}), maps.values().toArray());
        }
        return 0;
    }

    @Transactional(readOnly = false)
    @Override
    public int deleteUserGroup(String userGroupNo) {
        String[] primaryKeys = {"USER_GROUP_NO"};
        Object[] keyValues = {userGroupNo};
        return getDatabaseSupport().deleteGlobal(primaryKeys, keyValues);
    }

    private class SecUserGroupMapper implements ParameterizedRowMapper<SecUserGroup> {
        public SecUserGroup mapRow(ResultSet resultSet, int index) throws SQLException {
            SecUserGroup userGroup = new SecUserGroup();
            userGroup.setUserGroupNo(resultSet.getString(USER_GROUP_NO));
            userGroup.setUserGroupName(resultSet.getString("USER_GROUP_NAME"));
            userGroup.setUserGroupDesc(resultSet.getString("USER_GROUP_DESC"));
            userGroup.setActive(resultSet.getBoolean("ACTIVE"));
            userGroup.setLastUpdated(resultSet.getTimestamp("LAST_UPDATED"));
            userGroup.setUpdater(resultSet.getString("UPDATER"));
            return userGroup;
        }
    }

//    public List<SecUserGroup> getUserGroups() {
//        getDatabaseSupport().setOrderBy(USER_GROUP_NO);
//        return getDatabaseSupport().findAll(new SecUserGroupMapper());
//    }
//
//    public List<SecUserGroup> getUserGroups(int firstRecord, int lastRecord) {
//        getDatabaseSupport().setOrderBy(USER_GROUP_NO);
//        return getDatabaseSupport().findAll(firstRecord, lastRecord, new SecUserGroupMapper());
//    }
//
//    public List<SecUserGroup> getUserGroupsByFilter(int firstRecord,
//                                                    int lastRecord, String filter) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    public SecUserGroup getUserGroupById(String userGroupNo) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//    public int countUserGroup() {
//        // TODO Auto-generated method stub
//        return 0;
//    }
//
//    public int countUserGroupByFilter(String filter) {
//        // TODO Auto-generated method stub
//        return 0;
//    }
//
//    @Transactional(readOnly = false)
//    public int saveUserGroup(SecUserGroup secUserGroup) {
//        int status = 0;
//        Map<String, Object> maps = new HashMap<String, Object>();
//        maps.put("USER_GROUP_NAME", secUserGroup.getUserGroupName());
//        maps.put("USER_GROUP_DESC", secUserGroup.getUserGroupDesc() == null ? "" : secUserGroup.getUserGroupDesc());
//        maps.put("ACTIVE", secUserGroup.isActive());
//        maps.put("LAST_UPDATED", secUserGroup.getLastUpdated());
//        maps.put("UPDATER", secUserGroup.getUpdater());
//        if(getUserGroupById(secUserGroup.getUserGroupNo()) != null) {
//            String[] keyNames = {USER_GROUP_NO};
//            Object[] keyValues = {secUserGroup.getUserGroupNo()};
//            status = getDatabaseSupport().updateGlobal(keyNames, keyValues, maps.keySet().toArray(new String[]{}), maps.values().toArray());
//        } else {
//            maps.put(USER_GROUP_NO, secUserGroup.getUserGroupNo());
//            status = getDatabaseSupport().saveGlobal(maps.keySet().toArray(new String[]{}), maps.values().toArray());
//        }
//        return status;
//    }
//
//    @Transactional(readOnly = false)
//    public int deleteUserGroup(String userGroupNo) {
//        String[] keyNames = {USER_GROUP_NO};
//        Object[] keyValues = {userGroupNo};
//        return getDatabaseSupport().deleteGlobal(keyNames, keyValues);
//    }

}
