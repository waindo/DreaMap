package id.net.iconpln.dreamap.api.service.security.impl;

import id.net.iconpln.dreamap.api.dao.security.ISecUserDao;
import id.net.iconpln.dreamap.api.dao.security.ISecUserGroupDao;
import id.net.iconpln.dreamap.api.dao.security.ISecUserLoginDao;
import id.net.iconpln.dreamap.api.model.security.SecProgram;
import id.net.iconpln.dreamap.api.model.security.SecUser;
import id.net.iconpln.dreamap.api.model.security.SecUserGroup;
import id.net.iconpln.dreamap.api.model.security.SecUserLogin;
import id.net.iconpln.dreamap.api.service.security.ISecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Syakuru Hadi on 12/23/2014.
 */
@Service("securityService")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class SecurityService implements ISecurityService {

//    @Autowired
//    private ISecControlPermissionDao controlPermissionDao;    //NOPMD

//    @Autowired
//    private ISecMenuDao menuDao;    //NOPMD

//    @Autowired
//    private ISecMenuPermissionDao menuPermissionDao;    //NOPMD

//    @Autowired
//    private ISecProgramDao programDao;    //NOPMD

    @Autowired
    private ISecUserDao userDao;    //NOPMD

    @Autowired
    private ISecUserGroupDao userGroupDao;

    @Autowired
    private ISecUserLoginDao userLoginDao;

	/*start service implementation for ControlPermission*/
	/*end service implementation for ControlPermission*/

	/*start service implementation for Menu*/
	/*end service implementation for Menu*/

	/*start service implementation for MenuPermission*/
	/*end service implementation for MenuPermission*/

    /*start service implementation for Program*/
    public List<SecProgram> getExcludeProgramsByUserGroupNo(String userGroupNo) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecProgram> getProgramsByUserGroupNo(String userGroupNo) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecProgram> getPrograms() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecProgram> getPrograms(int firstRecord, int lastRecord) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecProgram> getProgramsByFilter(int firstRecord,
                                                int lastRecord, String filter) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecProgram getProgramByUrl(String urlAddress) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecProgram getProgramByNo(String programNo) {
        // TODO Auto-generated method stub
        return null;
    }

    public int countProgram() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countProgramByFilter(String filter) {
        // TODO Auto-generated method stub
        return 0;
    }

    public int saveProgram(SecProgram program) {
        // TODO Auto-generated method stub
        return 0;
    }

    public int deleteProgram(String programNo) {
        // TODO Auto-generated method stub
        return 0;
    }
	/*end service implementation for Program*/

    /*start service implementation for User*/
    public List<SecUser> findAllUser() {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecUser> findAllUser(int firstRecord, int lastRecord) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecUser> findAllUserByFilter(String filter) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<SecUser> findAllUserByFilter(int firstRecord, int lastRecord,
                                             String filter) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecUser findUserById(Long userId) {
        return userDao.findById(userId);
    }

    public SecUser findUserByName(String userName) {
        return userDao.findByName(userName);
    }

    public int saveUser(SecUser user) {
        // TODO Auto-generated method stub
        return 0;
    }

    public int deleteUser(Long userId) {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countUser() {
        // TODO Auto-generated method stub
        return 0;
    }

    public int countUserByFilter(String filter) {
        // TODO Auto-generated method stub
        return 0;
    }

    public SecUser findUserByFirstRecord(String keyName) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecUser findUserByPrevRecord(String keyName, String keyValue) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecUser findUserByNextRecord(String keyName, String keyValue) {
        // TODO Auto-generated method stub
        return null;
    }

    public SecUser findUserByLastRecord(String keyName) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean isMultipleLogin(SecUser user) {
        if(user.isMultipleLogin()) {
            return true;
        } else {
            List<SecUserLogin> userLogin = userLoginDao.findByCheckOutTimeIsNull(user);
            if(userLogin.isEmpty()) {
                return true;
            }
        }
        return false;
    }
	/*end service implementation for User*/

    /*start service implementation for UserGroup*/
    public List<SecUserGroup> findAllUserGroups(int start, int end) {
        return userGroupDao.findAll(start, end);
    }

    public List<SecUserGroup> findAllUserGroupsByFilter(int start, int end, String filter) {
        return userGroupDao.findByFilter(start, end, filter);
    }

    public List<SecUserGroup> getUserGroups() {
        return userGroupDao.getUserGroups();
    }

    public List<SecUserGroup> getUserGroups(int firstRecord, int lastRecord) {
        return userGroupDao.getUserGroups(firstRecord, lastRecord);
    }

    public List<SecUserGroup> getUserGroupsByFilter(int firstRecord, int lastRecord, String filter) {
        return userGroupDao.getUserGroupsByFilter(firstRecord, lastRecord, filter);
    }

    public SecUserGroup getUserGroupById(String userGroupNo) {
        return userGroupDao.getUserGroupById(userGroupNo);
    }

    public int countUserGroup() {
        return userGroupDao.count();
    }

    public int countUserGroupByFilter(String filter) {
        return userGroupDao.countByFilter(filter);
    }

    @Transactional(readOnly = false)
    public int saveUserGroup(SecUserGroup secUserGroup) {
        return userGroupDao.saveUserGroup(secUserGroup);
    }

    @Transactional(readOnly = false)
    public int deleteUserGroup(String userGroupNo) {
        return userGroupDao.deleteUserGroup(userGroupNo);
    }
	/*end service implementation for UserGroup*/

    /*start service implementation for UserLogin*/
    public List<SecUserLogin> findAllUserLogins(int start, int end) {
        return userLoginDao.findAll(start, end);
    }

    public SecUserLogin findUserLoginById(Long idUserLogin) {
        return userLoginDao.findById(idUserLogin);
    }

    @Transactional(readOnly = false)
    public int saveUserLogin(SecUserLogin userLogin) {
        return userLoginDao.save(userLogin);
    }
	/*end service implementation for UserLogin*/
}
