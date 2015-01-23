package id.net.iconpln.dreamap.api.dao.master.impl;

import id.net.iconpln.dreamap.api.dao.master.IAlatPembatasDao;
import id.net.iconpln.dreamap.api.model.master.AlatPembatas;
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
@Repository("alatPembatasDao")
@Transactional(readOnly = true)
public class AlatPembatasDao extends DatabaseSupport<AlatPembatas> implements IAlatPembatasDao {

    public AlatPembatasDao() {
        tablename = "ALAT_PEMBATAS";
    }

    @Override
    public List<AlatPembatas> findAll(int start, int end) {
        getDatabaseSupport().setOrderBy("ID_ALAT_PEMBATAS");
        return getDatabaseSupport().findAll(start, end, new AlatPembatasMapper());
    }

    @Override
    public List<AlatPembatas> findByFilter(int start, int end, String filter) {
        getDatabaseSupport().setOrderBy("ID_ALAT_PEMBATAS");
        String[] columns = {"KODE_PERALATAN"};
        return getDatabaseSupport().findByFilter(start, end, filter, columns, new AlatPembatasMapper());
    }

    @Override
    public AlatPembatas findById(String idAlatPembatas) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM ALAT_PEMBATAS WHERE ID_ALAT_PEMBATAS = ?", new AlatPembatasMapper(), idAlatPembatas);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Transactional(readOnly = false)
    @Override
    public int save(AlatPembatas alatPembatas) {
        int status = 0;
        Map<String, Object> maps = new HashMap<String, Object>();

        maps.put("ID_KELAS", alatPembatas.getIdKelas());
        maps.put("KODE_PERALATAN", alatPembatas.getKodePeralatan());
        maps.put("KD_PEMILIK", alatPembatas.getKdPemilik());
        maps.put("KD_PENGELOLA", alatPembatas.getKdPengelola());
        maps.put("TINGKAT_RESIKO", alatPembatas.getTingkatResiko());
        maps.put("STATUS", alatPembatas.getStatus());
        maps.put("TGL_PASANG", alatPembatas.getTglPasang());
        maps.put("TGL_OPERASI", alatPembatas.getTglOperasi());
        maps.put("UMUR_EKONOMIS", alatPembatas.getUmurEkonomis());
        maps.put("UMUR_MANFAAT", alatPembatas.getUmurManfaat());
        maps.put("NILAI_PEROLEHAN", alatPembatas.getNilaiPerolehan());
        maps.put("NILAI_BUKU", alatPembatas.getNilaiBuku());
        maps.put("LOKASI_PENEMPATAN", alatPembatas.getLokasiPenempatan());
        maps.put("NAMA_ALATPBTS", alatPembatas.getNamaAlatPBTS());
        maps.put("MERK_PBTS", alatPembatas.getMerkPBTS());
        maps.put("TYPE_PBTS", alatPembatas.getTypePBTS());
        maps.put("NO_SERI", alatPembatas.getNoSeri());
        if(findById(alatPembatas.getIdAlatPembatas()) != null) {
            String[] primaryKeys = {"ID_ALAT_PEMBATAS"};
            Object[] keyValues = {alatPembatas.getIdAlatPembatas()};
            status = getDatabaseSupport().updateGlobal(primaryKeys, keyValues, maps.keySet().toArray(new String[]{}), maps.values().toArray());
        } else {
            maps.put("ID_ALAT_PEMBATAS", alatPembatas.getIdAlatPembatas());
            status = getDatabaseSupport().saveGlobal(maps.keySet().toArray(new String[]{}), maps.values().toArray());
        }
        return status;
    }

    @Transactional(readOnly = false)
    @Override
    public int delete(String idAlatPembatas) {
        String[] primaryKeys = {"ID_ALAT_PEMBATAS"};
        Object[] keyValues = {idAlatPembatas};
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

    private class AlatPembatasMapper implements ParameterizedRowMapper<AlatPembatas> {
        @Override
        public AlatPembatas mapRow(ResultSet resultSet, int i) throws SQLException {
            AlatPembatas alatPembatas = new AlatPembatas();
            alatPembatas.setIdAlatPembatas(resultSet.getString("ID_ALAT_PEMBATAS"));
            alatPembatas.setIdKelas(resultSet.getString("ID_KELAS"));
            alatPembatas.setKodePeralatan(resultSet.getString("KODE_PERALATAN"));
            alatPembatas.setKdPemilik(resultSet.getString("KD_PEMILIK"));
            alatPembatas.setKdPengelola(resultSet.getString("KD_PENGELOLA"));
            alatPembatas.setTingkatResiko(resultSet.getString("TINGKAT_RESIKO"));
            alatPembatas.setStatus(resultSet.getString("STATUS"));
            alatPembatas.setTglPasang(resultSet.getTimestamp("TGL_PASANG"));
            alatPembatas.setTglOperasi(resultSet.getTimestamp("TGL_OPERASI"));
            alatPembatas.setUmurEkonomis(resultSet.getInt("UMUR_EKONOMIS"));
            alatPembatas.setUmurManfaat(resultSet.getInt("UMUR_MANFAAT"));
            alatPembatas.setNilaiPerolehan(resultSet.getInt("NILAI_PEROLEHAN"));
            alatPembatas.setNilaiBuku(resultSet.getInt("NILAI_BUKU"));
            alatPembatas.setLokasiPenempatan(resultSet.getString("LOKASI_PENEMPATAN"));
            alatPembatas.setNamaAlatPBTS(resultSet.getString("NAMA_ALATPBTS"));
            alatPembatas.setMerkPBTS(resultSet.getString("MERK_PBTS"));
            alatPembatas.setTypePBTS(resultSet.getString("TYPE_PBTS"));
            alatPembatas.setNoSeri(resultSet.getString("NO_SERI"));
            return alatPembatas;
        }
    }

}
