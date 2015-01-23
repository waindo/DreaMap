package id.net.iconpln.dreamap.api.dao.security;

import id.net.iconpln.dreamap.api.model.security.SecMenuPermission;

import java.util.List;

/**
 * Created by Syakuru Hadi on 12/22/2014.
 */
public interface ISecMenuPermissionDao {

    public List<SecMenuPermission> findAll();

    public List<SecMenuPermission> findAll(int firstRecord, int lastRecord);

    public List<SecMenuPermission> findAllByUserGroup(String userGroupNo);

    public List<SecMenuPermission> findAllByUserGroup(String userGroupNo, int firstRecord, int lastRecord);

    public List<SecMenuPermission> findAllByUserGroup();

    public List<SecMenuPermission> findAllByFilter(String filter);

    public List<SecMenuPermission> findAllByFilter(int firstRecord, int lastRecord, String filter);

    public List<SecMenuPermission> findAllByParentMenu(String userGroupNo, String menuNo);

    public SecMenuPermission findById(Long menuPermissionId);

    public int delete(Long menuPermissionId);

    public int delete(String userGroupNo, String menuNo);

    public int save(SecMenuPermission menuPermission);

    public int count();

    public int countByFilter(String filter);

}
