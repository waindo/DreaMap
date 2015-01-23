package id.net.iconpln.dreamap.api.dao.security;

import id.net.iconpln.dreamap.api.model.security.SecUser;
import id.net.iconpln.dreamap.api.model.security.SecUserLogin;

import java.util.List;

/**
 * Created by Syakuru Hadi on 12/23/2014.
 */
public interface ISecUserLoginDao {

    public List<SecUserLogin> findAll(int start, int end);

    public SecUserLogin findById(Long idUserLogin);

    public int save(SecUserLogin userLogin);

    public List<SecUserLogin> findByCheckOutTimeIsNull(SecUser user);

    public Long getNextUserLoginId();

}
