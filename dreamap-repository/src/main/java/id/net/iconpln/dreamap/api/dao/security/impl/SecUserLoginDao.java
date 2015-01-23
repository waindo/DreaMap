package id.net.iconpln.dreamap.api.dao.security.impl;

import id.net.iconpln.dreamap.api.dao.security.ISecUserDao;
import id.net.iconpln.dreamap.api.dao.security.ISecUserLoginDao;
import id.net.iconpln.dreamap.api.model.security.SecUser;
import id.net.iconpln.dreamap.api.model.security.SecUserLogin;
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
 * Created by Syakuru Hadi on 12/24/2014.
 */
@Repository("secUserLoginDao")
@Transactional(readOnly = true)
public class SecUserLoginDao extends DatabaseSupport<SecUserLogin> implements ISecUserLoginDao {

    @Autowired
    private ISecUserDao userDao;

    public SecUserLoginDao() {
        tablename = "SEC_USER_LOGIN";
    }

    private class SecUserLoginMapper implements ParameterizedRowMapper<SecUserLogin> {

        @Override
        public SecUserLogin mapRow(ResultSet resultSet, int i) throws SQLException {
            SecUserLogin userLogin = new SecUserLogin();
            userLogin.setUserLoginId(resultSet.getLong("USER_LOGIN_ID"));
            userLogin.setUsername(resultSet.getString("USER_NAME"));
            userLogin.setPassword(resultSet.getString("PASSWORD"));
            userLogin.setLoginDate(resultSet.getTimestamp("LOGIN_DATE"));
            userLogin.setCheckOutTime(resultSet.getTimestamp("CHECK_OUT_TIME"));
            userLogin.setDescription(resultSet.getString("DESCRIPTION"));
            userLogin.setNotes(resultSet.getString("NOTES"));
            userLogin.setUser(userDao.findById(resultSet.getLong("USER_ID")));
            return userLogin;
        }
    }

    @Override
    public List<SecUserLogin> findAll(int start, int end) {
        getDatabaseSupport().setOrderBy("USER_LOGIN_ID");
        return getDatabaseSupport().findAll(start, end, new SecUserLoginMapper());
    }

    @Override
    public SecUserLogin findById(Long idUserLogin) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM SEC_USER_LOGIN WHERE USER_LOGIN_ID = ?", new SecUserLoginMapper(), idUserLogin);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Transactional(readOnly = false)
    @Override
    public int save(SecUserLogin userLogin) {
        int status = 0;
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("USER_NAME", userLogin.getUsername());
        maps.put("PASSWORD", userLogin.getPassword());
//        TO_TIMESTAMP('2014-12-24 17:34:43.312', 'YYYY-MM-DD HH24:MI:SS.FF')
//        maps.put("LOGIN_DATE", userLogin.getLoginDate());
//        maps.put("LOGIN_DATE", getTimestamp());
        maps.put("DESCRIPTION", userLogin.getDescription());
        maps.put("NOTES", userLogin.getNotes());
        maps.put("USER_ID", userLogin.getUser().getUserId());
        if(findById(userLogin.getUserLoginId()) != null) {
            String[] keyNames = {"USER_LOGIN_ID"};
            Object[] keyValues = {userLogin.getUserLoginId()};
            status = getDatabaseSupport().updateGlobal(keyNames, keyValues, maps.keySet().toArray(new String[]{}), maps.values().toArray());
        } else {
//            maps.put("USER_LOGIN_ID", userLogin.getUserLoginId());
            maps.put("USER_LOGIN_ID", getNextUserLoginId());
            status = getDatabaseSupport().saveGlobal(maps.keySet().toArray(new String[]{}), maps.values().toArray());
        }
        return status;
    }

    @Override
    public List<SecUserLogin> findByCheckOutTimeIsNull(SecUser user) {
        return jdbcTemplate.query("SELECT * FROM SEC_USER_LOGIN WHERE CHECK_OUT_TIME IS NULL AND USER_ID = ?", new SecUserLoginMapper(), user.getUserId());
    }

    @Override
    public Long getNextUserLoginId() {
        return getDatabaseSupport().getNextVal("SEC_USER_LOGIN_SEQ");
    }


}
