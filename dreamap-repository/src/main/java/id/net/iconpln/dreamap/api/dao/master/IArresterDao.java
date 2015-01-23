package id.net.iconpln.dreamap.api.dao.master;

import id.net.iconpln.dreamap.api.model.master.Arrester;

import java.util.List;

/**
 * Created by UwieSilent on 1/20/2015.
 */
public interface IArresterDao {

    public List<Arrester> findAll(int start, int end);

    public List<Arrester> findByFilter(int start, int end, String filter);

    public Arrester findById(String idArrester);

    public int save(Arrester arrester);

    public int delete(String idArrester);

    public int count();

    public int countByFilter(String filter);

}
