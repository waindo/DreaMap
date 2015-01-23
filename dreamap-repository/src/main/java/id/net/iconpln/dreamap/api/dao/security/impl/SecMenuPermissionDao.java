package id.net.iconpln.dreamap.api.dao.security.impl;

import id.net.iconpln.dreamap.api.dao.security.ISecMenuDao;
import id.net.iconpln.dreamap.api.dao.security.ISecMenuPermissionDao;
import id.net.iconpln.dreamap.api.dao.security.ISecUserGroupDao;
import id.net.iconpln.dreamap.api.model.security.SecMenuPermission;
import id.net.iconpln.dreamap.api.support.DatabaseSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Syakuru Hadi on 12/23/2014.
 */
@Repository("secMenuPermission")
@Transactional(readOnly = true)
public class SecMenuPermissionDao extends DatabaseSupport<SecMenuPermission> implements ISecMenuPermissionDao {

    @Autowired
    private ISecUserGroupDao userGroupDao;

    @Autowired
    private ISecMenuDao menuDao;

    public SecMenuPermissionDao() {
        tablename = "SEC_MENU_PERMISSION";
    }

    private class SecMenuPermissionMapper implements ParameterizedRowMapper<SecMenuPermission> {
        public SecMenuPermission mapRow(ResultSet resultSet, int index) throws SQLException {
            SecMenuPermission menuPermission = new SecMenuPermission();
            menuPermission.setMenuPermissionId(resultSet.getLong("MENU_PERMISSION_ID"));
//            menuPermission.setUserGroup(userGroupDao.getUserGroupById(resultSet.getString("USER_GROUP_NO")));
            menuPermission.setMenu(menuDao.findById(resultSet.getString("MENU_NO")));
            menuPermission.setActive(resultSet.getBoolean("ACTIVE"));
            menuPermission.setLastUpdated(resultSet.getTimestamp("LAST_UPDATED"));
            menuPermission.setUpdater(resultSet.getString("UPDATER"));
            return menuPermission;
        }
    }

    public List<SecMenuPermission> findAll() {
        getDatabaseSupport().setOrderBy("MENU_PERMISSION_ID");
        return getDatabaseSupport().findAll(new SecMenuPermissionMapper());
    }

    public List<SecMenuPermission> findAll(int firstRecord, int lastRecord) {
        getDatabaseSupport().setOrderBy("MENU_PERMISSION_ID");
        return getDatabaseSupport().findAll(firstRecord, lastRecord, new SecMenuPermissionMapper());
    }

    public List<SecMenuPermission> findAllByUserGroup(String userGroupNo) {
        Object[] values = {userGroupNo};
        return jdbcTemplate.query("SELECT * FROM TABLE(DREAMAP.FN_GET_MENU_PERMISSION(?))", values, new SecMenuPermissionMapper());
    }

    public List<SecMenuPermission> findAllByUserGroup(String userGroupNo,
                                                      int firstRecord, int lastRecord) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecMenuPermission> findAllByUserGroup() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecMenuPermission> findAllByFilter(String filter) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecMenuPermission> findAllByFilter(int firstRecord,
                                                   int lastRecord, String filter) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecMenuPermission> findAllByParentMenu(String userGroupNo,
                                                       String menuNo) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecMenuPermission findById(Long menuPermissionId) {
        // TODO Auto-generated method stub
        return null;
    }

    public int delete(Long menuPermissionId) {
        // TODO Auto-generated method stub
        return 0;
    }

    public int delete(String userGroupNo, String menuNo) {
        // TODO Auto-generated method stub
        return 0;
    }

    public int save(SecMenuPermission menuPermission) {
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

}
