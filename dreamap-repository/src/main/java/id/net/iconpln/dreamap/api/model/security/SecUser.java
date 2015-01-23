package id.net.iconpln.dreamap.api.model.security;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Syakuru Hadi on 12/22/2014.
 */
public class SecUser implements Serializable {

    private Long userId;
    private String userName;
    private String password;
    private SecUserGroup userGroup;
    private boolean isMultipleLogin = false;
    private boolean active = true;
    private Date lastUpdated;
    private String updater;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public SecUserGroup getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(SecUserGroup userGroup) {
        this.userGroup = userGroup;
    }

    public boolean isMultipleLogin() {
        return isMultipleLogin;
    }

    public void setMultipleLogin(boolean isMultipleLogin) {
        this.isMultipleLogin = isMultipleLogin;
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
