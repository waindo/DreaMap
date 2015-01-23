package id.net.iconpln.dreamap.api.dao.master.impl;

import id.net.iconpln.dreamap.api.dao.master.IAlatBantuAppDao;
import id.net.iconpln.dreamap.api.model.master.AlatBantuApp;
import id.net.iconpln.dreamap.api.support.DatabaseSupport;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by UwieSilent on 1/20/2015.
 */
@Repository("alatBantuAppDao")
@Transactional(readOnly = true)
public class AlatBantuAppDao extends DatabaseSupport<AlatBantuApp> implements IAlatBantuAppDao {

    public AlatBantuAppDao() {
        tablename = "ALAT_BANTU_APP";
    }

    @Override
    public List<AlatBantuApp> findAll(int start, int end) {
        getDatabaseSupport().setOrderBy("ID_ALAT_BANTU_APP");
        return getDatabaseSupport().findAll(start, end, new AlatBantuAppMapper());
    }

    @Override
    public List<AlatBantuApp> findByFilter(int start, int end, String filter) {
        getDatabaseSupport().setOrderBy("ID_ALAT_BANTU_APP");
        String[] columns = {"KODE_PERALATAN"};
        return getDatabaseSupport().findByFilter(start, end, filter, columns, new AlatBantuAppMapper());
    }

    @Override
    public AlatBantuApp findById(String idAlatBantuApp) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM ALAT_BANTU_APP WHERE ID_ALAT_BANTU_APP = ?", new AlatBantuAppMapper(), idAlatBantuApp);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Transactional(readOnly = false)
    @Override
    public int save(AlatBantuApp alatBantuApp) {
        int status = 0;
        Map<String, Object> maps = new HashMap<String, Object>();
        maps.put("ID_KELAS", alatBantuApp.getIdKelas());
        maps.put("KODE_PERALATAN", alatBantuApp.getKodePeralatan());
        maps.put("KD_PEMILIK", alatBantuApp.getKdPemilik());
        maps.put("KD_PENGELOLA", alatBantuApp.getKdPengelola());
        maps.put("KODE_ITEM", alatBantuApp.getKodeItem());
        maps.put("TINGKAT_RESIKO", alatBantuApp.getTingkatResiko());
        maps.put("STATUS", alatBantuApp.getStatus());
        maps.put("TGL_PASANG", alatBantuApp.getTglPasang());
        maps.put("TGL_OPERASI", alatBantuApp.getTglOperasi());
        maps.put("UMUR_EKONOMIS", alatBantuApp.getUmurEkonomis());
        maps.put("UMUR_MANFAAT", alatBantuApp.getUmurManfaat());
        maps.put("NILAI_PEROLEHAN", alatBantuApp.getNilaiPerolehan());
        maps.put("NILAI_BUKU", alatBantuApp.getNilaiBuku());
        maps.put("LOKASI_PENEMPATAN", alatBantuApp.getLokasiPenempatan());
        maps.put("NAMA_ALAT", alatBantuApp.getNamaAlat());
        maps.put("MERK", alatBantuApp.getMerk());
        maps.put("NO_SERI", alatBantuApp.getNoSeri());
        maps.put("KELAS_KETELITIAN", alatBantuApp.getKelasKetelitian());
        maps.put("RASIO_IN_OUT", alatBantuApp.getRasioInOut());
        if(findById(alatBantuApp.getIdAlatBantu()) != null) {
            String[] primaryKeys = {"ID_ALAT_BANTU"};
            Object[] keyValues = {alatBantuApp.getIdAlatBantu()};
            status = getDatabaseSupport().updateGlobal(primaryKeys, keyValues, maps.keySet().toArray(new String[]{}), maps.values().toArray());
        } else {
            maps.put("ID_ALAT_BANTU", alatBantuApp.getIdAlatBantu());
            status = getDatabaseSupport().saveGlobal(maps.keySet().toArray(new String[]{}), maps.values().toArray());
        }
        return status;
    }

    @Transactional(readOnly = false)
    @Override
    public int delete(String idAlatBantuApp) {
        String[] primaryKeys = {"ID_ALAT_BANTU_APP"};
        Object[] keyValues = {idAlatBantuApp};
        return getDatabaseSupport().deleteGlobal(primaryKeys, keyValues);
    }

    @Override
    public int count() {
        return getDatabaseSupport().count(tablename);
    }

    @Override
    public int countByFilter(String filter) {
        String[] columns = {"KODE_PERALATAN"};
        return getDatabaseSupport().countByFilter(tablename, filter, columns);
    }

    private class AlatBantuAppMapper implements ParameterizedRowMapper<AlatBantuApp> {
        @Override
        public AlatBantuApp mapRow(ResultSet resultSet, int i) throws SQLException {
            AlatBantuApp alatBantuApp = new AlatBantuApp();
            alatBantuApp.setIdAlatBantu(resultSet.getString("ID_ALAT_BANTU"));
            alatBantuApp.setIdKelas(resultSet.getString("ID_KELAS"));
            alatBantuApp.setKodePeralatan(resultSet.getString("KODE_PERALATAN"));
            alatBantuApp.setKdPemilik(resultSet.getString("KD_PEMILIK"));
            alatBantuApp.setKdPengelola(resultSet.getString("KD_PENGELOLA"));
            alatBantuApp.setKodeItem(resultSet.getString("KODE_ITEM"));
            alatBantuApp.setTingkatResiko(resultSet.getString("TINGKAT_RESIKO"));
            alatBantuApp.setStatus(resultSet.getString("STATUS"));
            alatBantuApp.setTglPasang(resultSet.getTimestamp("TGL_PASANG"));
            alatBantuApp.setTglOperasi(resultSet.getTimestamp("TGL_OPERASI"));
            alatBantuApp.setUmurEkonomis(resultSet.getInt("UMUR_EKONOMIS"));
            alatBantuApp.setUmurManfaat(resultSet.getInt("UMUR_MANFAAT"));
            alatBantuApp.setNilaiPerolehan(resultSet.getInt("NILAI_PEROLEHAN"));
            alatBantuApp.setNilaiBuku(resultSet.getInt("NILAI_BUKU"));
            alatBantuApp.setLokasiPenempatan(resultSet.getString("LOKASI_PENEMPATAN"));
            alatBantuApp.setNamaAlat(resultSet.getString("NAMA_ALAT"));
            alatBantuApp.setMerk(resultSet.getString("MERK"));
            alatBantuApp.setNoSeri(resultSet.getString("NO_SERI"));
            alatBantuApp.setKelasKetelitian(resultSet.getFloat("KELAS_KETELITIAN"));
            alatBantuApp.setRasioInOut(resultSet.getString("RASIO_IN_OUT"));
            return alatBantuApp;
        }
    }

}
