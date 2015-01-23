package id.net.iconpln.dreamap.api.dao.master;

import id.net.iconpln.dreamap.api.model.master.BangunanSipilGardu;

import java.util.List;

/**
 * Created by UwieSilent on 1/20/2015.
 */
public interface IBangunanSipilGarduDao {

    public List<BangunanSipilGardu> findAll(int start, int end);

    public List<BangunanSipilGardu> findByFilter(int start, int end, String filter);

    public BangunanSipilGardu findById(String idBangunanSipilGardu);

    public int save(BangunanSipilGardu bangunanSipilGardu);

    public int delete(String idBangunanSipilGardu);

    public int count();

    public int countByFilter(String filter);

}
