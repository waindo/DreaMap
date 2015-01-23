package id.net.iconpln.dreamap.api.model.security;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Syakuru Hadi on 12/22/2014.
 */
public class SecProgram implements Serializable {

    private String programNo;
    private String programDesc;
    private String displayName;
    private String urlAddress;
    private String fileName;
    private boolean useView = false;
    private boolean useEntry = false;
    private boolean useEdit = false;
    private boolean useDelete = false;
    private boolean useExport = false;
    private boolean usePrint = false;
    private boolean useAuditLog = false;
    private boolean useApprove = false;
    private boolean useUnapprove = false;
    private boolean useValidate = false;
    private boolean useUnvalidate = false;
    private boolean useRelease = false;
    private boolean useUnrelease = false;
    private boolean active = true;
    private Date lastUpdated;
    private String updater;

    public String getProgramNo() {
        return programNo;
    }

    public void setProgramNo(String programNo) {
        this.programNo = programNo;
    }

    public String getProgramDesc() {
        return programDesc;
    }

    public void setProgramDesc(String programDesc) {
        this.programDesc = programDesc;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public boolean isUseView() {
        return useView;
    }

    public void setUseView(boolean useView) {
        this.useView = useView;
    }

    public boolean isUseEntry() {
        return useEntry;
    }

    public void setUseEntry(boolean useEntry) {
        this.useEntry = useEntry;
    }

    public boolean isUseEdit() {
        return useEdit;
    }

    public void setUseEdit(boolean useEdit) {
        this.useEdit = useEdit;
    }

    public boolean isUseDelete() {
        return useDelete;
    }

    public void setUseDelete(boolean useDelete) {
        this.useDelete = useDelete;
    }

    public boolean isUseExport() {
        return useExport;
    }

    public void setUseExport(boolean useExport) {
        this.useExport = useExport;
    }

    public boolean isUsePrint() {
        return usePrint;
    }

    public void setUsePrint(boolean usePrint) {
        this.usePrint = usePrint;
    }

    public boolean isUseAuditLog() {
        return useAuditLog;
    }

    public void setUseAuditLog(boolean useAuditLog) {
        this.useAuditLog = useAuditLog;
    }

    public boolean isUseApprove() {
        return useApprove;
    }

    public void setUseApprove(boolean useApprove) {
        this.useApprove = useApprove;
    }

    public boolean isUseUnapprove() {
        return useUnapprove;
    }

    public void setUseUnapprove(boolean useUnapprove) {
        this.useUnapprove = useUnapprove;
    }

    public boolean isUseValidate() {
        return useValidate;
    }

    public void setUseValidate(boolean useValidate) {
        this.useValidate = useValidate;
    }

    public boolean isUseUnvalidate() {
        return useUnvalidate;
    }

    public void setUseUnvalidate(boolean useUnvalidate) {
        this.useUnvalidate = useUnvalidate;
    }

    public boolean isUseRelease() {
        return useRelease;
    }

    public void setUseRelease(boolean useRelease) {
        this.useRelease = useRelease;
    }

    public boolean isUseUnrelease() {
        return useUnrelease;
    }

    public void setUseUnrelease(boolean useUnrelease) {
        this.useUnrelease = useUnrelease;
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
