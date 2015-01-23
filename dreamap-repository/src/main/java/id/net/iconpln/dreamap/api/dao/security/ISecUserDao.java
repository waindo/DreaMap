package id.net.iconpln.dreamap.api.dao.security;

import id.net.iconpln.dreamap.api.model.security.SecUser;

import java.util.List;

/**
 * Created by Syakuru Hadi on 12/23/2014.
 */
public interface ISecUserDao {

    public List<SecUser> findAll();

    public List<SecUser> findAll(int firstRecord, int lastRecord);

    public List<SecUser> findAllByFilter(String filter);

    public List<SecUser> findAllByFilter(int firstRecord, int lastRecord, String filter);

    public SecUser findById(Long userId);

    public SecUser findByName(String userName);

    public int save(SecUser user);

    public int delete(Long userId);

    public int count();

    public int countByFilter(String filter);

    public SecUser findByFirstRecord(String keyName);

    public SecUser findByPrevRecord(String keyName, String keyValue);

    public SecUser findByNextRecord(String keyName, String keyValue);

    public SecUser findByLastRecord(String keyName);

}
