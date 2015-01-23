package id.net.iconpln.dreamap.api.support;

import id.net.iconpln.dreamap.api.util.CommonUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSupport<T> {	//NOPMD

    private static final Logger _log = Logger.getLogger(DatabaseSupport.class);

    /** Result: ' */
    protected static final String str_apostrophe = "'";
    /** Result: '' */
    protected static final String str_apostrophes_2 = "''";
    /** Result: '''' */
    protected static final String str_apostrophes_4 = "''''";
    /** Result: \ */
    protected static final String str_backslash = "\\";
    /** Result: \\ */
    protected static final String str_backslashes_2 = "\\\\";
    /** Result: \\\\ */
    protected static final String str_backslashes_4 = "\\\\\\\\";
    /** Result: \\\\\\\\\\\\\\\\ */
    protected static final String str_backslashes_16 = "\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\";
    /** Result: _ */
    protected static final String str_underscore = "_";
    /** Result: \\_ */
    protected static final String str_backslashes_2_underscore = "\\\\_";
    /** Result: % */
    protected static final String str_percentSign = "%";
    /** Result: \\% */
    protected static final String str_backslashes_2_percentSign = "\\\\%";
    /** Result: " */
    protected static final String str_quoteMark = "\"";
    /** Result: \\\\" */
    protected static final String str_backslashes_4_quoteMark = "\\\\\\\\\"";

    public String tablename = "";
    private String orderBy;
    private String where;
    private String updater;

    protected JdbcTemplate jdbcTemplate;
    protected SimpleJdbcInsert jdbcInsert;
    protected SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate);

    @Autowired
    public void setDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcInsert = new SimpleJdbcInsert(dataSource);
    }

    public DatabaseSupport<T> getDatabaseSupport() {
        return this;
    }

    protected final String sandwichString(String innerString, String outerString) {
        String inner = innerString != null ? innerString : "";
        String outer = outerString != null ? outerString : "";
        int outerLength = outer.length();

        return new StringBuilder(inner.length() + (2 * outerLength)).append(outer).append(inner).append(outerLength > 1 ? new StringBuilder(outerLength).append(outer).reverse().toString() : outer).toString();
    }

    protected final String arrBuilder(String prefix, Object arr[]) {
        StringBuilder result = new StringBuilder();
        result.append(prefix).append("(");
        if (arr.length > 0) {
            result.append(sandwichString(arr[0].toString(), str_apostrophe));
            for (int i = 1; i < arr.length; i++)
                result.append(",").append(sandwichString(arr[i].toString(), str_apostrophe));
        }
        result.append(")");

        return result.toString();
    }

    protected final String arrBuilderValue(String prefix, Object arr[]) {
        StringBuilder result = new StringBuilder(8 * arr.length);

        result.append(prefix).append("(");
        if (arr.length > 0) {
            result.append(str_apostrophe).append(arr[0] != null ? arr[0].toString().replaceAll(str_backslashes_2, str_backslashes_16).replaceAll(str_apostrophe, str_apostrophes_4).replaceAll(str_quoteMark, str_backslashes_4_quoteMark) : null).append(str_apostrophe);
            for (int i = 1; i < arr.length; i++)
                result.append(",").append(str_apostrophe).append(arr[i] != null ? arr[i].toString().replaceAll(str_backslashes_2, str_backslashes_16).replaceAll(str_apostrophe, str_apostrophes_4).replaceAll(str_quoteMark, str_backslashes_4_quoteMark) : null).append(str_apostrophe);
        }
        result.append(")");

        return result.toString();
    }

    /*findAll*/
    public List<T> findAll(final RowMapper<T> mapper) {
        return findAll(-1, -1, mapper);
    }

    public List<T> findAll(final RowMapper<T> mapper, final boolean active) {
        return findAll(-1, -1, mapper, active);
    }

    public List<T> findAll(final RowMapper<T> mapper, final String[] columnNames, final Object[] columnValues) {
        return findAll(-1, -1, mapper, columnNames, columnValues, false);
    }

    public List<T> findAll(final RowMapper<T> mapper, final String[] columnNames, final Object[] columnValues, final boolean active) {
        return findAll(-1, -1, mapper, columnNames, columnValues, active);
    }

    public List<T> findAll(final int firstRecord, final int lastRecord, final RowMapper<T> mapper) {
        return findAll(firstRecord, lastRecord, mapper, null, null);
    }

    public List<T> findAll(final int firstRecord, final int lastRecord, final RowMapper<T> mapper, final boolean active) {
        return findAll(firstRecord, lastRecord, mapper, null, null, active);
    }

    public List<T> findAll(final int firstRecord, final int lastRecord, final RowMapper<T> mapper, final String[] columnNames, final Object[] columnValues) {
        return findAll(firstRecord, lastRecord, mapper, columnNames, columnValues, false);
    }

    public List<T> findAll(// NOPMD
                           final int firstRecord, final int lastRecord,
                           final RowMapper<T> rowMapper, final String[] columnNames,
                           final Object[] columnValues, final boolean active) {
        try {
            StringBuilder buffer = new StringBuilder();

            if (firstRecord != -1 && lastRecord != -1) {
                buffer = new StringBuilder();
                buffer.append("SELECT * FROM ");//NOPMD
                buffer.append("(SELECT ROW_NUMBER() OVER (ORDER BY "//NOPMD
                        + tablename + "." + this.orderBy + ") AS CINDEX, "//NOPMD
                        + tablename + ".* FROM " + tablename);//NOPMD

                if (columnNames != null) {
                    for (int i = 0; i < columnNames.length; i++) {
                        if(i==0) buffer.append(" WHERE ");
                        else buffer.append(" AND ");
                        buffer.append(columnNames[i] + "='"
                                + columnValues[i] + "'");
                    }
                }

                if (active) {
                    if (columnNames != null)
                        buffer.append(" AND active='TRUE'");
                    else
                        buffer.append(" WHERE active='TRUE'");// NOPMD
                }

                if(CommonUtils.isNotNullOrEmpty(this.where))
                    buffer.append(this.where);

                buffer.append(") WHERE CINDEX >= " + firstRecord//NOPMD
                        + " AND CINDEX <= " + lastRecord);//NOPMD

            } else {
                buffer.append("SELECT * FROM " + tablename); // NOPMD

                if (columnNames != null) {
                    for (int i = 0; i < columnNames.length; i++) {
                        if(i==0) buffer.append(" WHERE ");
                        else buffer.append(" AND ");
                        buffer.append(columnValues[i] + "='"
                                + columnValues[i] + "'");
                    }
                }

                if (active) {
                    if (columnNames != null)
                        buffer.append(" AND active='TRUE'");
                    else
                        buffer.append(" WHERE active='TRUE'");
                }

                if(CommonUtils.isNotNullOrEmpty(this.where))
                    buffer.append(this.where);

            }

            if (orderBy != null) {
                buffer.append(" ORDER BY " + this.orderBy); // NOPMD
            }
            return jdbcTemplate.query(buffer.toString(), rowMapper);
        } catch (Exception e) {
            _log.warn("Error findAll(int, int, RowMapper): ", e);
        }

        return null;
    }

    /*start findByFilter*/
    public List<T> findByFilter(final String filter, final String[] columns, final RowMapper<T> rowMapper) {
        return findByFilter(-1, -1, filter, columns, rowMapper);
    }

    public List<T> findByFilter(final int firstRecord, final int lastRecord,
                                final String filter, final String[] columns,
                                final RowMapper<T> rowMapper) {
        return findByFilter(firstRecord, lastRecord, filter, columns,
                rowMapper, null, null, false, null);
    }

    public List<T> findByFilter(final int firstRecord, final int lastRecord,
                                final String filter, final String[] columns,
                                final RowMapper<T> rowMapper, final String[] pKeys, final Object[] pVals, final boolean active) {
        return findByFilter(firstRecord, lastRecord, filter, columns,
                rowMapper, pKeys, pVals, active, null);
    }

    public List<T> findByFilter(// NOPMD
                                final int firstRecord, // From record
                                final int lastRecord, // To record
                                final String filter, // String to find
                                final String[] columns, // Columns that filter by
                                final RowMapper<T> rowMapper, // Structure table
                                final String[] pKeys, // Primary Keys
                                final Object[] pVals, // Primary Key values
                                final boolean active, // To find only active record
                                boolean[] checks) { // Check the column if integer
        StringBuilder query = new StringBuilder();

        query.append("SELECT * FROM ");
        query.append("(SELECT ROW_NUMBER() OVER (ORDER BY " + tablename + "."
                + this.orderBy + ") AS CINDEX, " + tablename + ".* FROM "
                + tablename);

        if (pKeys != null) {
            for (int i = 0; i < pKeys.length; i++) {
                if(i==0) query.append(" WHERE ");
                else query.append(" AND ");
                query.append(pKeys[i] + "='"
                        + pVals[i] + "'");
            }
        }

        if (active) {
            if(pKeys!=null)
                query.append(" AND ");
            else
                query.append(" WHERE ");

            query.append("active='TRUE' ");
        }

        for (int i = 0; i < columns.length; i++) {
            if (i == 0){
                if(active || pKeys!=null)
                    query.append(" AND (");
                else
                    query.append(" WHERE (");
            }


            try {
                query.append("LOWER(" + columns[i] + ") LIKE LOWER('%" + filter + "%')");
            } catch(NullPointerException npe) { // NOPMD
                query.append("LOWER(" + columns[i] + ") LIKE LOWER('%" + filter + "%')");
                _log.warn(npe.getMessage());
            }

            if (i < columns.length - 1)
                query.append(" OR "); //NOPMD

            if (i == columns.length - 1)
                query.append(")");//NOPMD

        }
        query.append(") WHERE CINDEX >= " + firstRecord
                + " AND CINDEX <= " + lastRecord);

        if(pKeys != null) {
            for (int i = 0; i < pKeys.length; i++) {
                query.append(" AND ");
                query.append(pKeys[i] + "='"
                        + pVals[i] + "'");
            }
        }

        if (orderBy != null) {
            query.append(" ORDER BY " + this.orderBy); // NOPMD
        }

        _log.info("Query [findByFilter]: " + query.toString());

        return jdbcTemplate.query(query.toString(), rowMapper);
    }

    public List<T> findByFilter(// NOPMD
                                final int firstRecord, // From record
                                final int lastRecord, // To record
                                final String filter, // String to find
                                final String[] columns, // Columns that filter by
                                final RowMapper<T> rowMapper, // Structure table
                                final String[] pKeys, // Primary Keys
                                final Object[] pVals, // Primary Key values
                                final boolean active, // To find only active record
                                boolean[] checks, // Check the column if integer
                                boolean multiple, // Check if multiple filter
                                final Object[] filters) { // Multiple Filter
        StringBuilder query = new StringBuilder();

        query.append("SELECT * FROM ");
        query.append("(SELECT row_number() OVER (ORDER BY " + tablename + "."
                + this.orderBy + ") AS rowno, " + tablename + ".* FROM "
                + tablename);

        if (pKeys != null) {
            for (int i = 0; i < pKeys.length; i++) {
                if(i==0) query.append(" WHERE ");
                else query.append(" AND ");
                query.append(pKeys[i] + "='"
                        + pVals[i] + "'");
            }
        }

        if (active) {
            if(pKeys!=null)
                query.append(" AND ");
            else
                query.append(" WHERE ");

            query.append("active='TRUE' ");
        }

        for (int i = 0; i < columns.length; i++) {
            if (i == 0){
                if(active || pKeys!=null)
                    query.append(" AND ");
                else
                    query.append(" WHERE ");
            }

            if(multiple){
                try {
                    query.append("LOWER(" + columns[i] + ") LIKE LOWER('%" + filters[i] + "%')");
                } catch(NullPointerException npe) { // NOPMD
                    query.append("LOWER(" + columns[i] + ") LIKE LOWER('%" + filters[i] + "%')");
                }
            }else{
                try {
                    query.append("LOWER(" + columns[i] + ") LIKE LOWER('%" + filter	+ "%')");
                } catch(NullPointerException npe) { // NOPMD
                    query.append("LOWER(" + columns[i] + ") LIKE LOWER('%" + filter + "%')");
                }
            }

            if (i < columns.length - 1)
                query.append(" OR ");
        }
        query.append(") WHERE rowno >= " + firstRecord
                + " AND rowno <= " + lastRecord);

        if (orderBy != null) {
            query.append(" ORDER BY " + this.orderBy); // NOPMD
        }

        return jdbcTemplate.query(query.toString(), rowMapper);
    }
    /*end findByFilter*/

    public List<String> getPrimaryKeys() {
        return jdbcTemplate.query("SELECT * FROM TABLE(FN_GET_PK(?))", new RowMapper<String>() {
            public String mapRow(ResultSet rSet, int index) throws SQLException {
                return rSet.getString(1);
            }
        }, tablename);
    }

    public int saveGlobal(final String[] columns, final Object[] values) {
        return saveGlobal(columns, values, true);
    }

    public int saveGlobal(final String[] columns, final Object[] values, final boolean lastUpdated) {
        if(_log.isDebugEnabled())
            _log.debug("Begin method saveGlobal()");
        StringBuilder query = new StringBuilder();
        query.append("SELECT DREAMAP.FN_SAVE_GLOBAL(")
                .append(sandwichString(tablename, str_apostrophe)).append(", ")
                .append(arrBuilder("DREAMAP.COL_NAME", columns)).append(", ")
                .append(arrBuilderValue("DREAMAP.COL_VALUE", values))
                .append(") FROM DUAL");
        int status = jdbcTemplate.queryForInt(query.toString());
        if (_log.isDebugEnabled())
            _log.debug("End method 'saveGlobal'. Returns: " + status);
        return status;
    }

    public int updateGlobal(final String[] pkeyNames, final Object[] pkeyValues, final String[] columns, final Object[] values) {
        return updateGlobal(pkeyNames, pkeyValues, columns, values, true);
    }

    public int updateGlobal(final String[] pkeyNames, final Object[] pkeyValues, final String[] columns, final Object[] values, final boolean lastUpdated) {
        if(_log.isDebugEnabled())
            _log.debug("Begin method updateGlobal()");
        StringBuilder query = new StringBuilder();
        query.append("SELECT DREAMAP.FN_UPDATE_GLOBAL(")
                .append(sandwichString(tablename, str_apostrophe)).append(", ")
                .append(arrBuilder("DREAMAP.PKEY_NAME", columns)).append(", ")
                .append(arrBuilderValue("DREAMAP.PKEY_VALUE", values))
                .append(arrBuilder("DREAMAP.COL_NAME", columns)).append(", ")
                .append(arrBuilderValue("DREAMAP.COL_VALUE", values))
                .append(") FROM DUAL");
        int status = jdbcTemplate.queryForInt(query.toString());
        if (_log.isDebugEnabled())
            _log.debug("End method 'updateGlobal'. Returns: " + status);
        return status;
    }

    public int deleteGlobal(final String[] columns, final Object[] values) {
        if(_log.isDebugEnabled())
            _log.debug("Begin method deleteGlobal()");
        StringBuilder query = new StringBuilder();
        query.append("SELECT DREAMAP.FN_DELETE_GLOBAL(")
                .append(sandwichString(tablename, str_apostrophe)).append(", ")
                .append(arrBuilder("DREAMAP.COL_NAME", columns)).append(", ")
                .append(arrBuilderValue("DREAMAP.COL_VALUE", values))
                .append(") FROM DUAL");
        int status = jdbcTemplate.queryForInt(query.toString());
        if (_log.isDebugEnabled())
            _log.debug("End method 'deleteGlobal'. Returns: " + status);
        return status;
    }

    /*counter start*/
    public int count(final String tableName) {
        String[] pKeys = null;
        String[] vals = null;
        return count(tableName, pKeys, vals, false);
    }

    public int count(final String tableName, final String pKey, final Object val) {
        String[] pKeys = { pKey };
        Object[] vals = { val };
        return count(tableName, pKeys, vals, false);
    }

    public int count(final String tableName, final String[] pKeys, final Object[] vals) {
        return count(tableName, pKeys, vals, false);
    }

    public int count(final String tableName, final String[] pKeys, final Object[] vals, final boolean active) {
        if (pKeys != null) {
            StringBuilder query = new StringBuilder();

            query.append("SELECT COUNT(1) FROM " + tableName + " WHERE "); // NOPMD

            for (int i = 0; i < pKeys.length; i++) {
                if (i < pKeys.length - 1)
                    query.append(pKeys[i] + "='" + vals[i].toString()
                            + "' AND ");
                else
                    query.append(pKeys[i] + "='" + vals[i].toString() + "'");
            }
            if (active)
                query.append(" AND active='TRUE'"); // NOPMD
            return jdbcTemplate.queryForInt(query.toString()); // NOPMD
        } else
            return jdbcTemplate
                    .queryForInt("SELECT COUNT(*) FROM " + tableName);
    }

    public int countByFilter(final String tableName, final String filter,
                             final String[] columns) {
        return countByFilter(tableName, filter, columns, null, null, false);
    }

    public int countByFilter(final String tableName, final String filter, final String[] columns,
                             final String[] pKeys, final Object[] pVals, final boolean active) {
        return countByFilter(tableName, filter, columns, pKeys, pVals, active, null);
    }

    public int countByFilter(final String tableName, final String filter, //NOPMD
                             final String[] columns, final String[] pKeys, final Object[] pVals,
                             final boolean active, boolean[] checks) {
        StringBuilder query = new StringBuilder();

        query.append("SELECT COUNT(*) FROM " + tableName);

        for (int i = 0; i < columns.length; i++) {
            if (i == 0)
                query.append(" WHERE (");//NOPMD

            try {
                query.append(" LOWER(" + columns[i] + ") LIKE LOWER('%" + filter + "%')");
            } catch (NullPointerException npe) {//NOPMD
                query.append(" LOWER(" + columns[i] + ") LIKE LOWER('%" + filter + "%')");
                _log.warn(npe.getMessage());
            }

            if (i < columns.length - 1)
                query.append(" OR "); //NOPMD

        }
        query.append(")");

        if (active) {
            query.append(" AND active='TRUE'");
        }
        if(pKeys!=null){
            for (int i = 0; i < pKeys.length; i++) {
                query.append(" AND " + pKeys[i] + "='" + pVals[i] + "'"); // NOPMD
            }
        }
        return jdbcTemplate.queryForInt(query.toString());
    }

    public int countByFilter(final String tableName, final String filter, //NOPMD
                             final String[] columns, final String[] pKeys, final Object[] pVals,
                             final boolean active, boolean[] checks, boolean multiple, Object[] filters) {
        StringBuilder query = new StringBuilder();

        query.append("SELECT COUNT(*) FROM " + tableName);

        for (int i = 0; i < columns.length; i++) {
            if (i == 0)
                query.append(" WHERE (");

            if(multiple){
                try {
                    query.append(" LOWER(" + columns[i] + ") LIKE LOWER('%" + filters[i] + "%')");
                } catch (NullPointerException npe) {//NOPMD
                    query.append(" LOWER(" + columns[i] + ") LIKE LOWER('%" + filters[i] + "%')");
                }
            }else{
                try {
                    query.append(" LOWER(" + columns[i] + ") LIKE LOWER('%" + filter + "%')");
                } catch (NullPointerException npe) {//NOPMD
                    query.append(" LOWER(" + columns[i] + ") LIKE LOWER('%" + filter + "%')");
                }
            }

            if (i < columns.length - 1)
                query.append(" OR ");

        }
        query.append(")");

        if (active) {
            query.append(" AND active='TRUE'");
        }
        if(pKeys!=null){
            for (int i = 0; i < pKeys.length; i++) {
                query.append(" AND " + pKeys[i] + "='" + pVals[i] + "'"); // NOPMD
            }
        }

        return jdbcTemplate.queryForInt(query.toString());
    }
    /*counter end*/

    @SuppressWarnings("unused")
    private String insertAudit(String auditType, String[] columns, Object[] values) {
        if(_log.isDebugEnabled())
            _log.debug("Begin method insertAudit.");

        String primaryReffId;
//		StringBuilder query = new StringBuilder();
        StringBuilder query;
        List<String> primaryKeys = getPrimaryKeys();
        int totalKey = primaryKeys.size();
        if(totalKey > 0 && columns.length > 0) {
            query = new StringBuilder();
            for (int i = 0; i < columns.length; i++) {
                if (primaryKeys.get(0).equals(columns[i])) {
                    query.append(columns[i]).append('=').append(values[i]);
                    break;
                }
            }
            for (int i = 1; i < totalKey; i++) {
                for (int j = 0; j < columns.length; j++) {
                    if (primaryKeys.get(i).equals(columns[j])) {
                        query.append(" AND ").append(columns[j]).append('=').append(values[j]);
                        break;
                    }
                }
            }
            primaryReffId = query.toString();
        } else {
            primaryReffId = "";
        }

        query = new StringBuilder();
//		query.append(b)
        query.append("SELECT DREAMAP.FN_SAVE_GLOBAL(")
                .append(sandwichString(tablename, str_apostrophe)).append(", ")
                .append(arrBuilder("DREAMAP.COL_NAME", columns)).append(", ")
                .append(arrBuilderValue("DREAMAP.COL_VALUE", values))
                .append(") FROM DUAL");
		
		/*
		sql = new StringBuilder(128 + primaryReffId.length());
		sql.append("SELECT * FROM save_glob('tsappauditlog',");
		sql.append("'{\"audittype\",\"tableid\",\"primaryreffid\",\"updater\",\"ip_address\"}',");
		sql.append("'{\"").append(auditType).append("\",\"").append(tableid).append("\",\"").append(primaryReffId).append("\",\"").append(updater).append("\",\"").append(ip_address).append("\"}',"); // NOPMD
		sql.append("'true','tsalid')");
		*/

        if(_log.isDebugEnabled())
            _log.debug("End method of 'insertAudit'. Returns: " + query.toString());


        return query.toString();
    }

    private void insertAuditData(int lastNo, String keyNames[], Object keyValues[], String columns[], Object values[]) {
        if(_log.isDebugEnabled())
            _log.debug("Begin method of 'insertAuditData'.");

        StringBuilder query;
        List<String> columnList = null;
        List<String> oldValues = null;
        List<String> newValues = null;

        query = new StringBuilder().append("SELECT * FROM ").append(tablename);
        if(keyNames.length > 0) {
            query.append(" WHERE ").append(keyNames[0]).append('=').append(getSqlValueString(keyValues[0].toString()));
            for(int i = 1; i < keyNames.length; i++)
                query.append(" AND ").append(keyNames[0]).append('=').append(getSqlValueString(keyValues[0].toString()));
        }

        try {
            Connection connection = jdbcTemplate.getDataSource().getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery(query.toString());

            if (resultSet.next()) {
                columnList = new ArrayList<String>(columns.length);
                oldValues = new ArrayList<String>(columns.length);
                newValues = new ArrayList<String>(columns.length);

                String oldValue;
                String newValue;

                for (int i = 0; i < columns.length; i++) {
                    oldValue = String.valueOf(resultSet.getObject(columns[i]));
                    newValue = String.valueOf(values[i]);

                    if (!newValue.equals(oldValue)) {
                        columnList.add(columns[i]);
                        oldValues.add(oldValue);
                        newValues.add(newValue);
                    }
                }
            }
        } catch (SQLException e) {
            _log.error(e.getMessage(), e);
        }

        if (columnList != null && !columnList.isEmpty()) {
            int size = columnList.size();

            query = new StringBuilder(49 + tablename.length()).append("SELECT TABLE_ID FROM SEC_TABLE WHERE TABLE_NAME='").append(tablename).append('\'');
            int tableid = ((Integer) getItem(query.toString())).intValue();

            for (int i = 0; i < size; i++) {
                query = new StringBuilder(128)
                        .append("SELECT * FROM save_glob('SEC_AUDIT_DATA','{\"AUDIT_LOG_ID\",\"TABLE_ID\",\"COLUMN_NAME\",\"OLD_VALUE\",\"NEW_VALUE\",\"UPDATER\"}','{\"")
                        .append(lastNo).append("\",\"").append(tableid).append("\",\"").append(columnList.get(i)).append("\",\"").append(oldValues.get(i).replaceAll(str_backslashes_2, str_backslashes_16).replaceAll(str_apostrophe, str_apostrophes_4).replaceAll(str_quoteMark, str_backslashes_4_quoteMark) + "\",\"").append(newValues.get(i).replaceAll(str_backslashes_2, str_backslashes_16).replaceAll(str_apostrophe, str_apostrophes_4).replaceAll(str_quoteMark, str_backslashes_4_quoteMark)).append("\",\"").append(updater).append("\"}','false','')");

                if (_log.isDebugEnabled())
                    _log.debug(query.toString());

                jdbcTemplate.queryForInt(query.toString());
            }
        }

        if (_log.isDebugEnabled())
            _log.debug("End method 'insertAuditData'.");
    }

    public Long getNextVal(String seqName) {
        try {
            return jdbcTemplate.queryForLong("SELECT DREAMAP." + seqName + ".NEXTVAL FROM DUAL");
        } catch(EmptyResultDataAccessException e) {

        } catch(Exception e) {
            _log.warn("Error [getNextVal]:", e);
        }
        return null;
    }

    protected Timestamp getTimestamp() {
        return jdbcTemplate.queryForObject("SELECT LOCALTIMESTAMP FROM DUAL", Timestamp.class);
    }

    protected final String getSqlValueString(String string) {
        return sandwichString(string.replaceFirst(str_backslashes_2, str_backslashes_4).replaceAll(str_apostrophe, str_apostrophes_2), str_apostrophe);
    }

    public Object getItem(String query) {
        return jdbcTemplate.queryForObject(query, null, Object.class);
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

}
