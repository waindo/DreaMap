package id.net.iconpln.dreamap.api.authentication;

import id.net.iconpln.dreamap.api.model.security.SecProgram;
import id.net.iconpln.dreamap.api.model.security.SecUser;
import id.net.iconpln.dreamap.api.model.security.SecUserLogin;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

/**
 * Created by Syakuru Hadi on 12/23/2014.
 */
@Repository("sessionManager")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionManager {

    private SecUser user;
    private SecUserLogin userLogin;
    private SecProgram program;

    public SecUser getUser() {
        return user;
    }

    public void setUser(SecUser user) {
        this.user = user;
    }

    public SecUserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(SecUserLogin userLogin) {
        this.userLogin = userLogin;
    }

    public SecProgram getProgram() {
        return program;
    }

    public void setProgram(SecProgram program) {
        this.program = program;
    }
}
