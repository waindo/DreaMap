package id.net.iconpln.dreamap.api.service.security.impl;

import id.net.iconpln.dreamap.api.model.security.SecUserGroup;
import id.net.iconpln.dreamap.api.service.security.ISecUserGroupService;
import id.net.iconpln.dreamap.api.support.DatabaseSupport;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by UwieSilent on 1/16/2015.
 */
@Service
public class SecUserGroupService extends DatabaseSupport<SecUserGroup> implements ISecUserGroupService {

    public SecUserGroupService() {
        tablename = "SEC_USER_GROUP";
    }

    @Override
    public List<SecUserGroup> getUserGroups() {
        getDatabaseSupport().setOrderBy("USER_GROUP_NO");
        return getDatabaseSupport().findAll(new SecUserGroupMapper());
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
    public int countUserGroup() {
        return 0;
    }

    @Override
    public int countUserGroupByFilter(String filter) {
        return 0;
    }

    @Override
    public int saveUserGroup(SecUserGroup secUserGroup) {
        return 0;
    }

    @Override
    public int deleteUserGroup(String userGroupNo) {
        return 0;
    }

    private class SecUserGroupMapper implements ParameterizedRowMapper<SecUserGroup> {
        public SecUserGroup mapRow(ResultSet resultSet, int index) throws SQLException {
            SecUserGroup userGroup = new SecUserGroup();
            userGroup.setUserGroupNo(resultSet.getString("USER_GROUP_NO"));
            userGroup.setUserGroupName(resultSet.getString("USER_GROUP_NAME"));
            userGroup.setUserGroupDesc(resultSet.getString("USER_GROUP_DESC"));
            userGroup.setActive(resultSet.getBoolean("ACTIVE"));
            userGroup.setLastUpdated(resultSet.getTimestamp("LAST_UPDATED"));
            userGroup.setUpdater(resultSet.getString("UPDATER"));
            return userGroup;
        }
    }

}
