package id.net.iconpln.dreamap.api.dao.security.impl;

import id.net.iconpln.dreamap.api.dao.security.ISecMenuDao;
import id.net.iconpln.dreamap.api.dao.security.ISecProgramDao;
import id.net.iconpln.dreamap.api.model.security.SecMenu;
import id.net.iconpln.dreamap.api.model.security.SecProgram;
import id.net.iconpln.dreamap.api.support.DatabaseSupport;
import org.springframework.beans.factory.annotation.Autowired;
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
@Repository("secMenuDao")
@Transactional(readOnly = true)
public class SecMenuDao extends DatabaseSupport<SecMenu> implements ISecMenuDao {

    private final String MENU_NO = "MENU_NO";

    @Autowired
    private ISecProgramDao programDao;

    public SecMenuDao() {
        tablename = "SEC_MENU";
    }

    private class SecMenuMapper implements ParameterizedRowMapper<SecMenu> {
        public SecMenu mapRow(ResultSet resultSet, int index) throws SQLException {
            SecMenu menu = new SecMenu();
            menu.setMenuNo(resultSet.getString(MENU_NO));
            menu.setMenuDesc(resultSet.getString("MENU_DESC"));

            SecMenu parentMenu = findById(resultSet.getString("PARENT_MENU_ID"));
            if(parentMenu != null)
                menu.setParentMenu(parentMenu);

            SecProgram program = programDao.getProgramByNo(resultSet.getString("PROGRAM_NO"));
            if(program != null)
                menu.setProgram(program);

            menu.setActive(resultSet.getBoolean("ACTIVE"));
            menu.setLastUpdated(resultSet.getTimestamp("LAST_UPDATED"));
            menu.setUpdater(resultSet.getString("UPDATER"));
            return menu;
        }
    }

    public List<SecMenu> findAll() {
        getDatabaseSupport().setOrderBy(MENU_NO);
        return getDatabaseSupport().findAll(new SecMenuMapper());
    }

    public List<SecMenu> findAll(int firstRecord, int lastRecord) {
        getDatabaseSupport().setOrderBy(MENU_NO);
        return getDatabaseSupport().findAll(firstRecord, lastRecord, new SecMenuMapper());
    }

    public List<SecMenu> findAllByFilter(int firstRecord, int lastRecord,
                                         String filter) {
        // TODO Auto-generated method stub
        return null;
    }

    public int countExcludeByUserGroup(String userGroupNo) {
        Object[] values = {userGroupNo};
        return jdbcTemplate.queryForInt("SELECT COUNT(*) FROM TABLE(FN_GET_EX_MENU_BY_USER_GROUP(?))", values);
    }

    public List<SecMenu> findExcludeByUserGroup(String userGroupNo) {
        Object[] values = {userGroupNo};
        return jdbcTemplate.query("SELECT * FROM TABLE(DREAMAP.FN_GET_EX_MENU_BY_USER_GROUP(?))", values, new SecMenuMapper());
    }

    public List<SecMenu> findExcludeByUserGroup(String userGroupNo,
                                                int firstRecord, int lastRecord) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecMenu> findTopMenu(String userGroupNo) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecMenu> findByParent(String userGroupNo, String menuNo) {
        Object[] values = {userGroupNo, menuNo};
        return jdbcTemplate.query("SELECT * FROM TABLE( DREAMAP.FN_GET_MENU_BY_PARENT_ID(?,?))", values, new SecMenuMapper());
    }

    public List<SecMenu> findAllByUserGroup(String userGroupNo) {
        Object[] values = {userGroupNo};
        return jdbcTemplate.query("SELECT * FROM TABLE(DREAMAP.FN_GET_MENU_BY_USER_GROUP(?))", values, new SecMenuMapper());
    }

    public List<SecMenu> findAllByUserGroup(String userGroupNo,
                                            int firstRecord, int lastRecord) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecMenu> findAllByUserGroupAndFilter(String userGroupNo,
                                                     int firstRecord, int lastRecord, String filter) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecMenu> findAllByUrlAddress(String userGroupNo,
                                             String urlAddress) {
        Object[] values = {userGroupNo, urlAddress};
        return jdbcTemplate.query("SELECT * FROM TABLE(DREAMAP.FN_GET_MENU_BY_URL_ADDRESS(?, ?))", values, new SecMenuMapper());
    }

    public List<SecMenu> findAllByParent(String userGroupNo) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecMenu> findParentMenuIsNull() {
        // TODO Auto-generated method stub
        return null;
    }

    public int countByUserGroup(String userGroupNo) {
        // TODO Auto-generated method stub
        return 0;
    }

    public SecMenu findById(String menuNo) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecMenu findByProgram(String programNo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Transactional(readOnly = false)
    public int save(SecMenu menu) {
        int status = 0;
        Map<String, Object> maps = new HashMap<String, Object>();
        if(findById(menu.getMenuNo()) != null) {
            String[] keyNames = {MENU_NO};
            Object[] keyValues = {menu.getMenuNo()};
            status = getDatabaseSupport().updateGlobal(keyNames, keyValues, maps.keySet().toArray(new String[]{}), maps.values().toArray());
        } else {
            maps.put(MENU_NO, menu.getMenuNo());
            status = getDatabaseSupport().saveGlobal(maps.keySet().toArray(new String[]{}), maps.values().toArray());
        }
        return status;
    }

    public int delete(String menuNo) {
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

    public SecMenu findByFirstRecord(String keyName) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecMenu findByPrevRecord(String keyName, Object keyValue) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecMenu findByNextRecord(String keyName, Object keyValue) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecMenu findByLastRecord(String keyName) {
        // TODO Auto-generated method stub
        return null;
    }

}
