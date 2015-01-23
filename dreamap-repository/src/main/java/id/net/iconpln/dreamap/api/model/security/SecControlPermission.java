package id.net.iconpln.dreamap.api.model.security;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Syakuru Hadi on 12/22/2014.
 */
public class SecControlPermission implements Serializable {

    private Long controlPermissionId;
    private SecUser user;
    private SecProgram program;
    private boolean allowView = false;
    private boolean allowEntry = false;
    private boolean allowEdit = false;
    private boolean allowDelete = false;
    private boolean allowPrint = false;
    private boolean allowExport = false;
    private boolean allowAuditLog = false;
    private boolean allowValidate = false;
    private boolean allowUnvalidate = false;
    private boolean allowApprove = false;
    private boolean allowUnapprove = false;
    private boolean allowRelease = false;
    private boolean allowUnrelease = false;
    private boolean active = true;
    private Date lastUpdated;
    private String updater;

    public Long getControlPermissionId() {
        return controlPermissionId;
    }

    public void setControlPermissionId(Long controlPermissionId) {
        this.controlPermissionId = controlPermissionId;
    }

    public SecUser getUser() {
        return user;
    }

    public void setUser(SecUser user) {
        this.user = user;
    }

    public SecProgram getProgram() {
        return program;
    }

    public void setProgram(SecProgram program) {
        this.program = program;
    }

    public boolean isAllowView() {
        return allowView;
    }

    public void setAllowView(boolean allowView) {
        this.allowView = allowView;
    }

    public boolean isAllowEntry() {
        return allowEntry;
    }

    public void setAllowEntry(boolean allowEntry) {
        this.allowEntry = allowEntry;
    }

    public boolean isAllowEdit() {
        return allowEdit;
    }

    public void setAllowEdit(boolean allowEdit) {
        this.allowEdit = allowEdit;
    }

    public boolean isAllowDelete() {
        return allowDelete;
    }

    public void setAllowDelete(boolean allowDelete) {
        this.allowDelete = allowDelete;
    }

    public boolean isAllowPrint() {
        return allowPrint;
    }

    public void setAllowPrint(boolean allowPrint) {
        this.allowPrint = allowPrint;
    }

    public boolean isAllowExport() {
        return allowExport;
    }

    public void setAllowExport(boolean allowExport) {
        this.allowExport = allowExport;
    }

    public boolean isAllowAuditLog() {
        return allowAuditLog;
    }

    public void setAllowAuditLog(boolean allowAuditLog) {
        this.allowAuditLog = allowAuditLog;
    }

    public boolean isAllowValidate() {
        return allowValidate;
    }

    public void setAllowValidate(boolean allowValidate) {
        this.allowValidate = allowValidate;
    }

    public boolean isAllowUnvalidate() {
        return allowUnvalidate;
    }

    public void setAllowUnvalidate(boolean allowUnvalidate) {
        this.allowUnvalidate = allowUnvalidate;
    }

    public boolean isAllowApprove() {
        return allowApprove;
    }

    public void setAllowApprove(boolean allowApprove) {
        this.allowApprove = allowApprove;
    }

    public boolean isAllowUnapprove() {
        return allowUnapprove;
    }

    public void setAllowUnapprove(boolean allowUnapprove) {
        this.allowUnapprove = allowUnapprove;
    }

    public boolean isAllowRelease() {
        return allowRelease;
    }

    public void setAllowRelease(boolean allowRelease) {
        this.allowRelease = allowRelease;
    }

    public boolean isAllowUnrelease() {
        return allowUnrelease;
    }

    public void setAllowUnrelease(boolean allowUnrelease) {
        this.allowUnrelease = allowUnrelease;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
