package id.net.iconpln.dreamap.api.dao.security;

import id.net.iconpln.dreamap.api.model.security.SecUserGroup;

import java.util.List;
import java.util.Map;

/**
 * Created by Syakuru Hadi on 12/22/2014.
 */
public interface ISecUserGroupDao {

    public List<SecUserGroup> findAll(int start, int end);

    public List<SecUserGroup> findByFilter(int start, int end, String filter);

    public SecUserGroup findById(String userGroupNo);

    public List<SecUserGroup> getUserGroups();

    public List<SecUserGroup> getUserGroups(int firstRecord, int lastRecord);

    public List<SecUserGroup> getUserGroupsByFilter(int firstRecord, int lastRecord, String filter);

    public SecUserGroup getUserGroupById(String userGroupNo);

    public int count();

    public int countByFilter(String filter);

    public int saveUserGroup(SecUserGroup secUserGroup);

    public int deleteUserGroup(String userGroupNo);

//    public Map<String, Object> getUserGroups();
//
//    public Map<String, Object> getUserGroups(int firstRecord, int lastRecord);
//
//    public Map<String, Object> getUserGroupsByFilter(int firstRecord, int lastRecord, String filter);
//
//    public SecUserGroup getUserGroupById(String userGroupNo);
//
//    public Map<String, Object> countUserGroup();
//
//    public Map<String, Object> countUserGroupByFilter(String filter);
//
//    public Map<String, Object> saveUserGroup(SecUserGroup secUserGroup);
//
//    public Map<String, Object> deleteUserGroup(String userGroupNo);

}
