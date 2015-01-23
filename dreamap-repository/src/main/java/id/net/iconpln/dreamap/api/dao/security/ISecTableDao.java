package id.net.iconpln.dreamap.api.dao.security;

import id.net.iconpln.dreamap.api.model.security.SecTable;

/**
 * Created by Syakuru Hadi on 12/23/2014.
 */
public interface ISecTableDao {

    public SecTable findById(Long tableId);

}
