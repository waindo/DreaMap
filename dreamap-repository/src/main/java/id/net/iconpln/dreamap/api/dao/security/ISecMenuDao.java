package id.net.iconpln.dreamap.api.dao.security;

import id.net.iconpln.dreamap.api.model.security.SecMenu;

import java.util.List;

/**
 * Created by Syakuru Hadi on 12/22/2014.
 */
public interface ISecMenuDao {

    public List<SecMenu> findAll();

    public List<SecMenu> findAll(int firstRecord, int lastRecord);

    public List<SecMenu> findAllByFilter(int firstRecord, int lastRecord, String filter);

    /*exclude*/
    public int countExcludeByUserGroup(String userGroupNo);

    public List<SecMenu> findExcludeByUserGroup(String userGroupNo);

    public List<SecMenu> findExcludeByUserGroup(String userGroupNo, int firstRecord, int lastRecord);
	/*exclude*/

    /*other*/
    public List<SecMenu> findTopMenu(String userGroupNo);

    public List<SecMenu> findByParent(String userGroupNo, String menuNo);

    public List<SecMenu> findAllByUserGroup(String userGroupNo);

    public List<SecMenu> findAllByUserGroup(String userGroupNo, int firstRecord, int lastRecord);

    public List<SecMenu> findAllByUserGroupAndFilter(String userGroupNo, int firstRecord, int lastRecord, String filter);

    public List<SecMenu> findAllByUrlAddress(String userGroupNo, String urlAddress);

    public List<SecMenu> findAllByParent(String userGroupNo);

    public List<SecMenu> findParentMenuIsNull();

    public int countByUserGroup(String userGroupNo);
	/*other*/

    public SecMenu findById(String menuNo);

    public SecMenu findByProgram(String programNo);

    public int save(SecMenu menu);

    public int delete(String menuNo);

    public int count();

    public int countByFilter(String filter);

    public SecMenu findByFirstRecord(String keyName);

    public SecMenu findByPrevRecord(String keyName, Object keyValue);

    public SecMenu findByNextRecord(String keyName, Object keyValue);

    public SecMenu findByLastRecord(String keyName);

}
