package id.net.iconpln.dreamap.api.dao.master;

import id.net.iconpln.dreamap.api.model.master.AlatBantuApp;

import java.util.List;

/**
 * Created by UwieSilent on 1/20/2015.
 */

public interface IAlatBantuAppDao {

    public List<AlatBantuApp> findAll(int start, int end);

    public List<AlatBantuApp> findByFilter(int start, int end, String filter);

    public AlatBantuApp findById(String idAlatBantuApp);

    public int save(AlatBantuApp alatBantuApp);

    public int delete(String idAlatBantuApp);

    public int count();

    public int countByFilter(String filter);

}
