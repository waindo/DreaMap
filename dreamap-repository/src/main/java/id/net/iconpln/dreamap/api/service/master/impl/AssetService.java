package id.net.iconpln.dreamap.api.service.master.impl;

import id.net.iconpln.dreamap.api.dao.master.*;
import id.net.iconpln.dreamap.api.model.master.*;
import id.net.iconpln.dreamap.api.service.master.IAssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by UwieSilent on 1/20/2015.
 */
@Service("assetService")
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class AssetService implements IAssetService {

    @Autowired
    private IAlatBantuAppDao alatBantuAppDao;

    @Autowired
    private IAlatPembatasDao alatPembatasDao;

    @Autowired
    private IAlatPengukurDao alatPengukurDao;

    @Autowired
    private IArresterDao arresterDao;

    @Autowired
    private IBangunanSipilGarduDao bangunanSipilGarduDao;

    /*alat bantu app*/
    @Override
    public List<AlatBantuApp> findAllAlatBantuApps(int start, int end) {
        return alatBantuAppDao.findAll(start, end);
    }

    @Override
    public List<AlatBantuApp> findAlatBantuAppsByFilter(int start, int end, String filter) {
        return alatBantuAppDao.findByFilter(start, end, filter);
    }

    @Override
    public AlatBantuApp findAlatBantuAppById(String idAlatBantuApp) {
        return alatBantuAppDao.findById(idAlatBantuApp);
    }

    @Transactional(readOnly = false)
    @Override
    public int saveAlatBantuApp(AlatBantuApp alatBantuApp) {
        return alatBantuAppDao.save(alatBantuApp);
    }

    @Transactional(readOnly = false)
    @Override
    public int deleteAlatBantuApp(String idAlatBantuApp) {
        return alatBantuAppDao.delete(idAlatBantuApp);
    }

    @Override
    public int countAlatBantuApp() {
        return alatBantuAppDao.count();
    }

    @Override
    public int countAlatBantuAppByFilter(String filter) {
        return alatBantuAppDao.countByFilter(filter);
    }

    /*alat pembatas*/
    @Override
    public List<AlatPembatas> findAllAlatPembatases(int start, int end) {
        return alatPembatasDao.findAll(start, end);
    }

    @Override
    public List<AlatPembatas> findAlatPembatasesByFilter(int start, int end, String filter) {
        return alatPembatasDao.findByFilter(start, end, filter);
    }

    @Override
    public AlatPembatas findAlatPembatasById(String idAlatPembatas) {
        return alatPembatasDao.findById(idAlatPembatas);
    }

    @Transactional(readOnly = false)
    @Override
    public int saveAlatPembatas(AlatPembatas alatPembatas) {
        return alatPembatasDao.save(alatPembatas);
    }

    @Transactional(readOnly = false)
    @Override
    public int deleteAlatPembatas(String idAlatPembatas) {
        return alatPembatasDao.delete(idAlatPembatas);
    }

    @Override
    public int countAlatPembatas() {
        return alatPembatasDao.count();
    }

    @Override
    public int countAlatPembatasByFilter(String filter) {
        return alatPembatasDao.countByFilter(filter);
    }

    /*alat pengukur*/
    @Override
    public List<AlatPengukur> findAllAlatPengukurs(int start, int end) {
        return alatPengukurDao.findAll(start, end);
    }

    @Override
    public List<AlatPengukur> findAlatPengukursByFilter(int start, int end, String filter) {
        return alatPengukurDao.findByFilter(start, end, filter);
    }

    @Override
    public AlatPengukur findAlatPengukurById(String idAlatPengukur) {
        return alatPengukurDao.findById(idAlatPengukur);
    }

    @Transactional(readOnly = false)
    @Override
    public int saveAlatPengukur(AlatPengukur alatPengukur) {
        return alatPengukurDao.save(alatPengukur);
    }

    @Transactional(readOnly = false)
    @Override
    public int deleteAlatPengukur(String idAlatPengukur) {
        return alatPengukurDao.delete(idAlatPengukur);
    }

    @Override
    public int countAlatPengukur() {
        return alatPengukurDao.count();
    }

    @Override
    public int countAlatPengukurByFilter(String filter) {
        return alatPengukurDao.countByFilter(filter);
    }

//    arrester
    @Override
    public List<Arrester> findAllArresters(int start, int end) {
        return arresterDao.findAll(start, end);
    }

    @Override
    public List<Arrester> findArrestersByFilter(int start, int end, String filter) {
        return arresterDao.findByFilter(start, end, filter);
    }

    @Override
    public Arrester findArresterById(String idArrester) {
        return arresterDao.findById(idArrester);
    }

    @Transactional(readOnly = false)
    @Override
    public int saveArrester(Arrester arrester) {
        return arresterDao.save(arrester);
    }

    @Transactional(readOnly = false)
    @Override
    public int deleteArrester(String idArrester) {
        return arresterDao.delete(idArrester);
    }

    @Override
    public int countArrester() {
        return arresterDao.count();
    }

    @Override
    public int countArresterByFilter(String filter) {
        return arresterDao.countByFilter(filter);
    }

    /*bangunan gardu*/
    @Override
    public List<BangunanSipilGardu> findAllBangunanSipilGardus(int start, int end) {
        return bangunanSipilGarduDao.findAll(start, end);
    }

    @Override
    public List<BangunanSipilGardu> findBangunanSipilGardusByFilter(int start, int end, String filter) {
        return bangunanSipilGarduDao.findByFilter(start, end, filter);
    }

    @Override
    public BangunanSipilGardu findBangunanSipilGarduById(String idBangunanSipilGardu) {
        return bangunanSipilGarduDao.findById(idBangunanSipilGardu);
    }

    @Transactional(readOnly = false)
    @Override
    public int saveBangunanSipilGardu(BangunanSipilGardu bangunanSipilGardu) {
        return bangunanSipilGarduDao.save(bangunanSipilGardu);
    }

    @Transactional(readOnly = false)
    @Override
    public int deleteBangunanSipilGardu(String idBangunanSipilGardu) {
        return bangunanSipilGarduDao.delete(idBangunanSipilGardu);
    }

    @Override
    public int countBangunanSipilGardu() {
        return bangunanSipilGarduDao.count();
    }

    @Override
    public int countBangunanSipilGarduByFilter(String filter) {
        return bangunanSipilGarduDao.countByFilter(filter);
    }

}
