package id.net.iconpln.dreamap.api.dao.security.impl;

import id.net.iconpln.dreamap.api.dao.security.ISecUserDao;
import id.net.iconpln.dreamap.api.dao.security.ISecUserGroupDao;
import id.net.iconpln.dreamap.api.model.security.SecUser;
import id.net.iconpln.dreamap.api.support.DatabaseSupport;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Syakuru Hadi on 12/23/2014.
 */
@Repository("secUserDao")
@Transactional(readOnly = true)
public class SecUserDao extends DatabaseSupport<SecUser> implements ISecUserDao {

    private static final Logger _log = Logger.getLogger(SecUserDao.class);

    @Autowired
    private ISecUserGroupDao userGroupDao;

    public SecUserDao() {
        tablename = "SEC_USER";
    }

    private class SecUserMapper implements ParameterizedRowMapper<SecUser> {
        public SecUser mapRow(ResultSet resultSet, int index) throws SQLException {
            SecUser user = new SecUser();
            user.setUserId(resultSet.getLong("USER_ID"));
            user.setUserName(resultSet.getString("USER_NAME"));
            user.setPassword(resultSet.getString("PASSWORD"));

            user.setUserGroup(userGroupDao.getUserGroupById(resultSet.getString("USER_GROUP_NO")));

            user.setMultipleLogin(resultSet.getBoolean("IS_MULTIPLE_LOGIN"));

            user.setActive(resultSet.getBoolean("ACTIVE"));
            user.setLastUpdated(resultSet.getTimestamp("LAST_UPDATED"));
            user.setUpdater(resultSet.getString("UPDATER"));
            return user;
        }
    }

    public List<SecUser> findAll() {
        getDatabaseSupport().setOrderBy("USER_ID");
        return getDatabaseSupport().findAll(new SecUserMapper());
    }

    public List<SecUser> findAll(int firstRecord, int lastRecord) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecUser> findAllByFilter(String filter) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecUser> findAllByFilter(int firstRecord, int lastRecord,
                                         String filter) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecUser findById(Long userId) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM SEC_USER WHERE USER_ID = ?", new SecUserMapper(), userId);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    public SecUser findByName(String userName) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM SEC_USER WHERE USER_NAME = ?", new SecUserMapper(), userName);
        } catch(EmptyResultDataAccessException e) {

        } catch(Exception e) {
            _log.warn("Error: ", e);
        }
        return null;
    }

    public int save(SecUser user) {
        // TODO Auto-generated method stub
        return 0;
    }

    public int delete(Long userId) {
        // TODO Auto-generated method stub
        return 0;
    }

    public int count() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countByFilter(String filter) {
        // TODO Auto-generated method stub
        return 0;
    }

    public SecUser findByFirstRecord(String keyName) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecUser findByPrevRecord(String keyName, String keyValue) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecUser findByNextRecord(String keyName, String keyValue) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecUser findByLastRecord(String keyName) {
        // TODO Auto-generated method stub
        return null;
    }

}
