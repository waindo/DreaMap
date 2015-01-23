package id.net.iconpln.dreamap.api.dao.master.impl;

import id.net.iconpln.dreamap.api.dao.master.IAlatPengukurDao;
import id.net.iconpln.dreamap.api.model.master.AlatPengukur;
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
@Repository("alatPengukurDao")
@Transactional(readOnly = true)
public class AlatPengukurDao extends DatabaseSupport<AlatPengukur> implements IAlatPengukurDao {

    public AlatPengukurDao() {
        tablename = "ALAT_PEMBATAS";
    }

    @Override
    public List<AlatPengukur> findAll(int start, int end) {
        getDatabaseSupport().setOrderBy("ID_ALAT_PENGUKUR");
        return getDatabaseSupport().findAll(start, end, new AlatPengukurMapper());
    }

    @Override
    public List<AlatPengukur> findByFilter(int start, int end, String filter) {
        getDatabaseSupport().setOrderBy("ID_ALAT_PENGUKUR");
        String[] columns = {"KODE_PERALATAN"};
        return getDatabaseSupport().findByFilter(start, end, filter, columns, new AlatPengukurMapper());
    }

    @Override
    public AlatPengukur findById(String idAlatPengukur) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM ALAT_PEMBATAS WHERE ID_ALAT_PENGUKUR = ?", new AlatPengukurMapper(), idAlatPengukur);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Transactional(readOnly = false)
    @Override
    public int save(AlatPengukur alatPengukur) {
        int status = 0;
        Map<String, Object> maps = new HashMap<String, Object>();

        maps.put("ID_SUPPLY", alatPengukur.getIdSupply());
        maps.put("KODE_PERALATAN", alatPengukur.getKodePeralatan());
        maps.put("KD_PEMILIK", alatPengukur.getKdPemilik());
        maps.put("KD_PENGELOLA", alatPengukur.getKdPengelola());
        maps.put("TINGKAT_RESIKO", alatPengukur.getTingkatResiko());
        maps.put("STATUS", alatPengukur.getStatus());
        maps.put("TGL_PASANG", alatPengukur.getTglPasang());
        maps.put("TGL_OPERASI", alatPengukur.getTglOperasi());
        maps.put("UMUR_EKONOMIS", alatPengukur.getUmurEkonomis());
        maps.put("UMUR_MANFAAT", alatPengukur.getUmurManfaat());
        maps.put("LOKASI_PENEMPATAN", alatPengukur.getLokasiPenempatan());
        maps.put("NO_SERI", alatPengukur.getNoSeri());
        maps.put("KETERANGAN", alatPengukur.getKeterangan());
        maps.put("NAMA_ALAT", alatPengukur.getNamaAlat());
        maps.put("MERK_AP", alatPengukur.getMerkAP());
        maps.put("TYPE_AP", alatPengukur.getTypeAP());
        maps.put("NO_SERI", alatPengukur.getNoSeri());
        maps.put("CARA_PENGUKURAN", alatPengukur.getCaraPengukuran());
        maps.put("FAKTOR_KALI", alatPengukur.getFaktorKali());
        maps.put("X", alatPengukur.getX());
        maps.put("Y", alatPengukur.getY());
        if(findById(alatPengukur.getIdAlatPengukur()) != null) {
            String[] primaryKeys = {"ID_ALAT_PENGUKUR"};
            Object[] keyValues = {alatPengukur.getIdAlatPengukur()};
            status = getDatabaseSupport().updateGlobal(primaryKeys, keyValues, maps.keySet().toArray(new String[]{}), maps.values().toArray());
        } else {
            maps.put("ID_ALAT_PENGUKUR", alatPengukur.getIdAlatPengukur());
            status = getDatabaseSupport().saveGlobal(maps.keySet().toArray(new String[]{}), maps.values().toArray());
        }
        return status;
    }

    @Transactional(readOnly = false)
    @Override
    public int delete(String idAlatPengukur) {
        String[] primaryKeys = {"ID_ALAT_PENGUKUR"};
        Object[] keyValues = {idAlatPengukur};
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

    private class AlatPengukurMapper implements ParameterizedRowMapper<AlatPengukur> {
        @Override
        public AlatPengukur mapRow(ResultSet resultSet, int i) throws SQLException {
            AlatPengukur alatPengukur = new AlatPengukur();
            alatPengukur.setIdAlatPengukur(resultSet.getString("ID_ALAT_PENGUKUR"));
            alatPengukur.setIdSupply(resultSet.getString("ID_SUPPLY"));
            alatPengukur.setKodePeralatan(resultSet.getString("KODE_PERALATAN"));
            alatPengukur.setKdPemilik(resultSet.getString("KD_PEMILIK"));
            alatPengukur.setKdPengelola(resultSet.getString("KD_PENGELOLA"));
            alatPengukur.setTingkatResiko(resultSet.getString("TINGKAT_RESIKO"));
            alatPengukur.setStatus(resultSet.getString("STATUS"));
            alatPengukur.setTglPasang(resultSet.getTimestamp("TGL_PASANG"));
            alatPengukur.setTglOperasi(resultSet.getTimestamp("TGL_OPERASI"));
            alatPengukur.setUmurEkonomis(resultSet.getInt("UMUR_EKONOMIS"));
            alatPengukur.setUmurManfaat(resultSet.getInt("UMUR_MANFAAT"));
            alatPengukur.setLokasiPenempatan(resultSet.getString("LOKASI_PENEMPATAN"));
            alatPengukur.setKeterangan(resultSet.getString("KETERANGAN"));
            alatPengukur.setNamaAlat(resultSet.getString("NAMA_ALAT"));
            alatPengukur.setMerkAP(resultSet.getString("MERK_AP"));
            alatPengukur.setTypeAP(resultSet.getString("TYPE_AP"));
            alatPengukur.setNoSeri(resultSet.getString("NO_SERI"));
            alatPengukur.setCaraPengukuran(resultSet.getInt("CARA_PENGUKURAN"));
            alatPengukur.setFaktorKali(resultSet.getInt("FAKTOR_KALI"));
            alatPengukur.setX(resultSet.getInt("X"));
            alatPengukur.setY(resultSet.getInt("Y"));
            return alatPengukur;
        }
    }

}
