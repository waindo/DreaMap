package id.net.iconpln.dreamap.api.model.security;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Syakuru Hadi on 12/22/2014.
 */
public class SecMenu implements Serializable {

    private String menuNo;
    private String menuDesc;
    private SecMenu parentMenu;
    private SecProgram program;
    private boolean active = true;
    private Date lastUpdated;
    private String updater;

    public String getMenuNo() {
        return menuNo;
    }

    public void setMenuNo(String menuNo) {
        this.menuNo = menuNo;
    }

    public String getMenuDesc() {
        return menuDesc;
    }

    public void setMenuDesc(String menuDesc) {
        this.menuDesc = menuDesc;
    }

    public SecMenu getParentMenu() {
        return parentMenu;
    }

    public void setParentMenu(SecMenu parentMenu) {
        this.parentMenu = parentMenu;
    }

    public SecProgram getProgram() {
        return program;
    }

    public void setProgram(SecProgram program) {
        this.program = program;
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
