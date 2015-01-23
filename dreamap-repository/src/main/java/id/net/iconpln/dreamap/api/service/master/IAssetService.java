package id.net.iconpln.dreamap.api.service.master;

import id.net.iconpln.dreamap.api.model.master.*;

import java.util.List;

/**
 * Created by UwieSilent on 1/20/2015.
 */
public interface IAssetService {

    public List<AlatBantuApp> findAllAlatBantuApps(int start, int end);

    public List<AlatBantuApp> findAlatBantuAppsByFilter(int start, int end, String filter);

    public AlatBantuApp findAlatBantuAppById(String idAlatBantuApp);

    public int saveAlatBantuApp(AlatBantuApp alatBantuApp);

    public int deleteAlatBantuApp(String idAlatBantuApp);

    public int countAlatBantuApp();

    public int countAlatBantuAppByFilter(String filter);

    /*alat pembatas*/
    public List<AlatPembatas> findAllAlatPembatases(int start, int end);

    public List<AlatPembatas> findAlatPembatasesByFilter(int start, int end, String filter);

    public AlatPembatas findAlatPembatasById(String idAlatPembatas);

    public int saveAlatPembatas(AlatPembatas alatPembatas);

    public int deleteAlatPembatas(String idAlatPembatas);

    public int countAlatPembatas();

    public int countAlatPembatasByFilter(String filter);

    /*alat pengukur*/
    public List<AlatPengukur> findAllAlatPengukurs(int start, int end);

    public List<AlatPengukur> findAlatPengukursByFilter(int start, int end, String filter);

    public AlatPengukur findAlatPengukurById(String idAlatPengukur);

    public int saveAlatPengukur(AlatPengukur alatPengukur);

    public int deleteAlatPengukur(String idAlatPengukur);

    public int countAlatPengukur();

    public int countAlatPengukurByFilter(String filter);

    /*arrester*/
    public List<Arrester> findAllArresters(int start, int end);

    public List<Arrester> findArrestersByFilter(int start, int end, String filter);

    public Arrester findArresterById(String idArrester);

    public int saveArrester(Arrester arrester);

    public int deleteArrester(String idArrester);

    public int countArrester();

    public int countArresterByFilter(String filter);

    /*bangunan sipil gardu*/
    public List<BangunanSipilGardu> findAllBangunanSipilGardus(int start, int end);

    public List<BangunanSipilGardu> findBangunanSipilGardusByFilter(int start, int end, String filter);

    public BangunanSipilGardu findBangunanSipilGarduById(String idBangunanSipilGardu);

    public int saveBangunanSipilGardu(BangunanSipilGardu bangunanSipilGardu);

    public int deleteBangunanSipilGardu(String idBangunanSipilGardu);

    public int countBangunanSipilGardu();

    public int countBangunanSipilGarduByFilter(String filter);

}
