package id.net.iconpln.dreamap.api.service.security;

import id.net.iconpln.dreamap.api.model.security.SecUserGroup;

import java.util.List;

/**
 * Created by UwieSilent on 1/16/2015.
 */
public interface ISecUserGroupService {

    public List<SecUserGroup> getUserGroups();

    public List<SecUserGroup> getUserGroups(int firstRecord, int lastRecord);

    public List<SecUserGroup> getUserGroupsByFilter(int firstRecord, int lastRecord, String filter);

    public SecUserGroup getUserGroupById(String userGroupNo);

    public int countUserGroup();

    public int countUserGroupByFilter(String filter);

    public int saveUserGroup(SecUserGroup secUserGroup);

    public int deleteUserGroup(String userGroupNo);

}
