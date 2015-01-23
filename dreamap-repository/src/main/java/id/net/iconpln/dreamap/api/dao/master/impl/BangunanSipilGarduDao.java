package id.net.iconpln.dreamap.api.dao.master.impl;

import id.net.iconpln.dreamap.api.dao.master.IBangunanSipilGarduDao;
import id.net.iconpln.dreamap.api.model.master.BangunanSipilGardu;
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
@Repository("bangunanSipilGarduDao")
@Transactional(readOnly = true)
public class BangunanSipilGarduDao extends DatabaseSupport<BangunanSipilGardu> implements IBangunanSipilGarduDao {

    public BangunanSipilGarduDao() {
        tablename = "BANGUNAN_SIPIL_GARDU";
    }

    @Override
    public List<BangunanSipilGardu> findAll(int start, int end) {
        getDatabaseSupport().setOrderBy("ID_BANGUNAN_GARDU");
        return getDatabaseSupport().findAll(start, end, new BangunanSipilGarduMapper());
    }

    @Override
    public List<BangunanSipilGardu> findByFilter(int start, int end, String filter) {
        getDatabaseSupport().setOrderBy("ID_BANGUNAN_GARDU");
        String[] columns = {"KODE_PERALATAN"};
        return getDatabaseSupport().findByFilter(start, end, filter, columns, new BangunanSipilGarduMapper());
    }

    @Override
    public BangunanSipilGardu findById(String idBangunanSipilGardu) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM ALAT_PEMBATAS WHERE ID_BANGUNAN_GARDU = ?", new BangunanSipilGarduMapper(), idBangunanSipilGardu);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Transactional(readOnly = false)
    @Override
    public int save(BangunanSipilGardu bangunanSipilGardu) {
        int status = 0;
        Map<String, Object> maps = new HashMap<String, Object>();

        maps.put("ID_JTM", bangunanSipilGardu.getIdJTM());
        maps.put("KODE_PERALATAN", bangunanSipilGardu.getKodePeralatan());
        maps.put("KD_PEMILIK", bangunanSipilGardu.getKdPemilik());
        maps.put("KD_PENGELOLA", bangunanSipilGardu.getKdPengelola());
        maps.put("KODE_KONSTRUKSI", bangunanSipilGardu.getKodeKonstruksi());
        maps.put("TINGKAT_RESIKO", bangunanSipilGardu.getTingkatResiko());
        maps.put("JUMLAH_TRAFO", bangunanSipilGardu.getJumlahTrafo());
        maps.put("STATUS", bangunanSipilGardu.getStatus());
        maps.put("TGL_PASANG", bangunanSipilGardu.getTglPasang());
        maps.put("TGL_OPERASI", bangunanSipilGardu.getTglOperasi());
        maps.put("UMUR_EKONOMIS", bangunanSipilGardu.getUmurEkonomis());
        maps.put("UMUR_MANFAAT", bangunanSipilGardu.getUmurManfaat());
        maps.put("NILAI_PEROLEHAN", bangunanSipilGardu.getNilaiPerolehan());
        maps.put("NILAI_BUKU", bangunanSipilGardu.getNilaiBuku());

        maps.put("NO_BANGUNAN_GARDU", bangunanSipilGardu.getNoBangunanGardu());
        maps.put("TYPE_GARDU", bangunanSipilGardu.getTypeGardu());
        maps.put("TYPE_BANGUNAN_GARDU", bangunanSipilGardu.getTypeBangunanGardu());
        maps.put("X", bangunanSipilGardu.getX());
        maps.put("Y", bangunanSipilGardu.getY());
        if(findById(bangunanSipilGardu.getIdBangunanGardu()) != null) {
            String[] primaryKeys = {"ID_BANGUNAN_GARDU"};
            Object[] keyValues = {bangunanSipilGardu.getIdBangunanGardu()};
            status = getDatabaseSupport().updateGlobal(primaryKeys, keyValues, maps.keySet().toArray(new String[]{}), maps.values().toArray());
        } else {
            maps.put("ID_BANGUNAN_GARDU", bangunanSipilGardu.getIdBangunanGardu());
            status = getDatabaseSupport().saveGlobal(maps.keySet().toArray(new String[]{}), maps.values().toArray());
        }
        return status;
    }

    @Transactional(readOnly = false)
    @Override
    public int delete(String idBangunanSipilGardu) {
        String[] primaryKeys = {"ID_BANGUNAN_GARDU"};
        Object[] keyValues = {idBangunanSipilGardu};
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

    private class BangunanSipilGarduMapper implements ParameterizedRowMapper<BangunanSipilGardu> {
        @Override
        public BangunanSipilGardu mapRow(ResultSet resultSet, int i) throws SQLException {
            BangunanSipilGardu bangunanSipilGardu = new BangunanSipilGardu();
            bangunanSipilGardu.setIdBangunanGardu(resultSet.getString("ID_BANGUNAN_GARDU"));
            bangunanSipilGardu.setIdJTM(resultSet.getString("ID_JTM"));
            bangunanSipilGardu.setKodePeralatan(resultSet.getString("KODE_PERALATAN"));
            bangunanSipilGardu.setKdPemilik(resultSet.getString("KD_PEMILIK"));
            bangunanSipilGardu.setKdPengelola(resultSet.getString("KD_PENGELOLA"));
            bangunanSipilGardu.setTingkatResiko(resultSet.getString("TINGKAT_RESIKO"));
            bangunanSipilGardu.setJumlahTrafo(resultSet.getInt("JUMLAH_TRAFO"));
            bangunanSipilGardu.setStatus(resultSet.getString("STATUS"));
            bangunanSipilGardu.setTglPasang(resultSet.getTimestamp("TGL_PASANG"));
            bangunanSipilGardu.setTglOperasi(resultSet.getTimestamp("TGL_OPERASI"));
            bangunanSipilGardu.setUmurEkonomis(resultSet.getInt("UMUR_EKONOMIS"));
            bangunanSipilGardu.setUmurManfaat(resultSet.getInt("UMUR_MANFAAT"));
            bangunanSipilGardu.setNilaiPerolehan(resultSet.getFloat("NILAI_PEROLEHAN"));
            bangunanSipilGardu.setNilaiBuku(resultSet.getFloat("NILAI_BUKU"));
            bangunanSipilGardu.setNoBangunanGardu(resultSet.getString("NO_BANGUNAN_GARDU"));
            bangunanSipilGardu.setTypeGardu(resultSet.getString("TYPE_GARDU"));
            bangunanSipilGardu.setTypeBangunanGardu(resultSet.getString("TYPE_BANGUNAN_GARDU"));
            bangunanSipilGardu.setX(resultSet.getFloat("X"));
            bangunanSipilGardu.setY(resultSet.getFloat("Y"));
            return bangunanSipilGardu;
        }
    }

}
