package id.net.iconpln.dreamap.api.model.security;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Syakuru Hadi on 12/22/2014.
 */
public class SecMenuPermission implements Serializable {

    private Long menuPermissionId;
    private SecUserGroup userGroup;
    private SecMenu menu;
    private boolean active = true;
    private Date lastUpdated;
    private String updater;

    public Long getMenuPermissionId() {
        return menuPermissionId;
    }

    public void setMenuPermissionId(Long menuPermissionId) {
        this.menuPermissionId = menuPermissionId;
    }

    public SecUserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(SecUserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public SecMenu getMenu() {
        return menu;
    }

    public void setMenu(SecMenu menu) {
        this.menu = menu;
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
