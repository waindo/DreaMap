package id.net.iconpln.dreamap.api.dao.master;

import id.net.iconpln.dreamap.api.model.master.AlatPengukur;

import java.util.List;

/**
 * Created by UwieSilent on 1/20/2015.
 */
public interface IAlatPengukurDao {

    public List<AlatPengukur> findAll(int start, int end);

    public List<AlatPengukur> findByFilter(int start, int end, String filter);

    public AlatPengukur findById(String idAlatPengukur);

    public int save(AlatPengukur alatPengukur);

    public int delete(String idAlatPengukur);

    public int count();

    public int countByFilter(String filter);

}
