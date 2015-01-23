package id.net.iconpln.dreamap.api.dao.security;

import id.net.iconpln.dreamap.api.model.security.SecControlPermission;

import java.util.List;

/**
 * Created by Syakuru Hadi on 12/23/2014.
 */
public interface ISecControlPermissionDao {

    public List<SecControlPermission> findAll();

    public List<SecControlPermission> findAll(int firstRecord, int lastRecord);

    public List<SecControlPermission> findAllByFilter(int firstRecord, int lastRecord, String filter);

    public List<SecControlPermission> findAllByUser();

    public List<SecControlPermission> findAllByUser(Long userId);

    public SecControlPermission findById(Long controlPermissionId);

    public int save(SecControlPermission controlPermission);

    public int delete(Long controlPermissionId);

    public int count();

    public int countByFilter(String filter);

    public int countByUser(Long userId);

}
