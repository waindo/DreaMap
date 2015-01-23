package id.net.iconpln.dreamap.api.service.security;

import id.net.iconpln.dreamap.api.model.security.SecProgram;
import id.net.iconpln.dreamap.api.model.security.SecUser;
import id.net.iconpln.dreamap.api.model.security.SecUserGroup;
import id.net.iconpln.dreamap.api.model.security.SecUserLogin;

import java.util.List;

/**
 * Created by Syakuru Hadi on 12/23/2014.
 */
public interface ISecurityService {

    /*start service for SecProgram*/
    public List<SecProgram> getExcludeProgramsByUserGroupNo(String userGroupNo);

    public List<SecProgram> getProgramsByUserGroupNo(String userGroupNo);

    public List<SecProgram> getPrograms();

    public List<SecProgram> getPrograms(int firstRecord, int lastRecord);

    public List<SecProgram> getProgramsByFilter(int firstRecord, int lastRecord, String filter);

    public SecProgram getProgramByUrl(String urlAddress);

    public SecProgram getProgramByNo(String programNo);

    public int countProgram();

    public int countProgramByFilter(String filter);

    public int saveProgram(SecProgram program);

    public int deleteProgram(String programNo);
	/*end service for SecProgram*/

    /*start service for SecUser*/
    public List<SecUser> findAllUser();

    public List<SecUser> findAllUser(int firstRecord, int lastRecord);

    public List<SecUser> findAllUserByFilter(String filter);

    public List<SecUser> findAllUserByFilter(int firstRecord, int lastRecord, String filter);

    public SecUser findUserById(Long userId);

    public SecUser findUserByName(String userName);

    public int saveUser(SecUser user);

    public int deleteUser(Long userId);

    public int countUser();

    public int countUserByFilter(String filter);

    public SecUser findUserByFirstRecord(String keyName);

    public SecUser findUserByPrevRecord(String keyName, String keyValue);

    public SecUser findUserByNextRecord(String keyName, String keyValue);

    public SecUser findUserByLastRecord(String keyName);

    public boolean isMultipleLogin(SecUser secUser);
	/*end service for SecUser*/

    /*start service for SecUserGroup*/
    public List<SecUserGroup> findAllUserGroups(int start, int end);

    public List<SecUserGroup> findAllUserGroupsByFilter(int start, int end, String filter);

    public List<SecUserGroup> getUserGroups();

    public List<SecUserGroup> getUserGroups(int firstRecord, int lastRecord);

    public List<SecUserGroup> getUserGroupsByFilter(int firstRecord, int lastRecord, String filter);

    public SecUserGroup getUserGroupById(String userGroupNo);

    public int countUserGroup();

    public int countUserGroupByFilter(String filter);

    public int saveUserGroup(SecUserGroup secUserGroup);

    public int deleteUserGroup(String userGroupNo);
	/*end service for SecUserGroup*/

    /*start service for SecUserLogin*/
    public List<SecUserLogin> findAllUserLogins(int start, int end);

    public SecUserLogin findUserLoginById(Long idUserLogin);

    public int saveUserLogin(SecUserLogin userLogin);
	/*end service for SecUserLogin*/

}
