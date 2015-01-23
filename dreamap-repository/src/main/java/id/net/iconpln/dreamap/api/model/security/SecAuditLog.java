package id.net.iconpln.dreamap.api.model.security;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Syakuru Hadi on 12/22/2014.
 */
public class SecAuditLog implements Serializable {

    private Long auditLogId;
    private SecTable secTable;
    private String auditType;
    private String primaryReffId;
    private String ipAddress;
    private Date lastUpdated;
    private String updater;

    public Long getAuditLogId() {
        return auditLogId;
    }

    public void setAuditLogId(Long auditLogId) {
        this.auditLogId = auditLogId;
    }

    public SecTable getSecTable() {
        return secTable;
    }

    public void setSecTable(SecTable secTable) {
        this.secTable = secTable;
    }

    public String getAuditType() {
        return auditType;
    }

    public void setAuditType(String auditType) {
        this.auditType = auditType;
    }

    public String getPrimaryReffId() {
        return primaryReffId;
    }

    public void setPrimaryReffId(String primaryReffId) {
        this.primaryReffId = primaryReffId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
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
