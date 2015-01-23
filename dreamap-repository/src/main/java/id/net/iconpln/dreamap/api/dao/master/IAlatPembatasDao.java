package id.net.iconpln.dreamap.api.dao.master;

import id.net.iconpln.dreamap.api.model.master.AlatPembatas;

import java.util.List;

/**
 * Created by UwieSilent on 1/20/2015.
 */
public interface IAlatPembatasDao {

    public List<AlatPembatas> findAll(int start, int end);

    public List<AlatPembatas> findByFilter(int start, int end, String filter);

    public AlatPembatas findById(String idAlatPembatas);

    public int save(AlatPembatas alatPembatas);

    public int delete(String idAlatPembatas);

    public int count();

    public int countByFilter(String filter);

}
