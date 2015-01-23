package id.net.iconpln.dreamap.api.dao.master.impl;

import id.net.iconpln.dreamap.api.dao.master.IArresterDao;
import id.net.iconpln.dreamap.api.model.master.Arrester;
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
@Repository("arresterDao")
@Transactional(readOnly = true)
public class ArresterDao extends DatabaseSupport<Arrester> implements IArresterDao {

    public ArresterDao() {
        tablename = "ARRESTER";
    }

    @Override
    public List<Arrester> findAll(int start, int end) {
        getDatabaseSupport().setOrderBy("ID_ARRESTER");
        return getDatabaseSupport().findAll(start, end, new ArresterMapper());
    }

    @Override
    public List<Arrester> findByFilter(int start, int end, String filter) {
        getDatabaseSupport().setOrderBy("ID_ARRESTER");
        String[] columns = {"KODE_PERALATAN"};
        return getDatabaseSupport().findByFilter(start, end, filter, columns, new ArresterMapper());
    }

    @Override
    public Arrester findById(String idArrester) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM ALAT_PEMBATAS WHERE ID_ARRESTER = ?", new ArresterMapper(), idArrester);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Transactional(readOnly = false)
    @Override
    public int save(Arrester arrester) {
        int status = 0;
        Map<String, Object> maps = new HashMap<String, Object>();

        maps.put("ID_KELAS", arrester.getIdKelas());
        maps.put("KODE_PERALATAN", arrester.getKodePeralatan());
        maps.put("KD_PEMILIK", arrester.getKdPemilik());
        maps.put("KD_PENGELOLA", arrester.getKdPengelola());
        maps.put("TINGKAT_RESIKO", arrester.getTingkatResiko());
        maps.put("STATUS", arrester.getStatus());
        maps.put("TGL_PASANG", arrester.getTglPasang());
        maps.put("TGL_OPERASI", arrester.getTglOperasi());
        maps.put("UMUR_EKONOMIS", arrester.getUmurEkonomis());
        maps.put("UMUR_MANFAAT", arrester.getUmurManfaat());
        maps.put("LOKASI_PENEMPATAN", arrester.getLokasiPenempatan());
        maps.put("MERK", arrester.getMerk());
        maps.put("TYPE", arrester.getType());
        maps.put("JENIS", arrester.getJenis());
        if(findById(arrester.getIdArrester()) != null) {
            String[] primaryKeys = {"ID_ARRESTER"};
            Object[] keyValues = {arrester.getIdArrester()};
            status = getDatabaseSupport().updateGlobal(primaryKeys, keyValues, maps.keySet().toArray(new String[]{}), maps.values().toArray());
        } else {
            maps.put("ID_ARRESTER", arrester.getIdArrester());
            status = getDatabaseSupport().saveGlobal(maps.keySet().toArray(new String[]{}), maps.values().toArray());
        }
        return status;
    }

    @Transactional(readOnly = false)
    @Override
    public int delete(String idArrester) {
        String[] primaryKeys = {"ID_ARRESTER"};
        Object[] keyValues = {idArrester};
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

    private class ArresterMapper implements ParameterizedRowMapper<Arrester> {
        @Override
        public Arrester mapRow(ResultSet resultSet, int i) throws SQLException {
            Arrester arrester = new Arrester();
            arrester.setIdArrester(resultSet.getString("ID_ARRESTER"));
            arrester.setIdKelas(resultSet.getString("ID_KELAS"));
            arrester.setKodePeralatan(resultSet.getString("KODE_PERALATAN"));
            arrester.setKdPemilik(resultSet.getString("KD_PEMILIK"));
            arrester.setKdPengelola(resultSet.getString("KD_PENGELOLA"));
            arrester.setTingkatResiko(resultSet.getString("TINGKAT_RESIKO"));
            arrester.setStatus(resultSet.getString("STATUS"));
            arrester.setTglPasang(resultSet.getTimestamp("TGL_PASANG"));
            arrester.setTglOperasi(resultSet.getTimestamp("TGL_OPERASI"));
            arrester.setUmurEkonomis(resultSet.getInt("UMUR_EKONOMIS"));
            arrester.setUmurManfaat(resultSet.getInt("UMUR_MANFAAT"));
            arrester.setLokasiPenempatan(resultSet.getString("LOKASI_PENEMPATAN"));
            arrester.setMerk(resultSet.getString("MERK"));
            arrester.setType(resultSet.getString("TYPE"));
            arrester.setJenis(resultSet.getString("JENIS"));
            return arrester;
        }
    }

}
