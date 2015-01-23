package id.net.iconpln.dreamap.api.model.security;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Syakuru Hadi on 12/22/2014.
 */
public class SecAuditData implements Serializable {

    private Long auditDataId;
    private SecAuditLog secAuditLog;
    private SecTable secTable;
    private String columnName;
    private String oldValue;
    private String newValue;
    private Date lastUpdated;
    private String updater;

    public Long getAuditDataId() {
        return auditDataId;
    }

    public void setAuditDataId(Long auditDataId) {
        this.auditDataId = auditDataId;
    }

    public SecAuditLog getSecAuditLog() {
        return secAuditLog;
    }

    public void setSecAuditLog(SecAuditLog secAuditLog) {
        this.secAuditLog = secAuditLog;
    }

    public SecTable getSecTable() {
        return secTable;
    }

    public void setSecTable(SecTable secTable) {
        this.secTable = secTable;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }
}
