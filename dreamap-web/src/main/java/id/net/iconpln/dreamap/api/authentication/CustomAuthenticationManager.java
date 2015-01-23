package id.net.iconpln.dreamap.api.authentication;

import id.net.iconpln.dreamap.api.model.security.SecUser;
import id.net.iconpln.dreamap.api.model.security.SecUserLogin;
import id.net.iconpln.dreamap.api.service.security.ISecurityService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by Syakuru Hadi on 12/23/2014.
 */
public class CustomAuthenticationManager implements AuthenticationManager, Serializable {

    protected static Logger _log = Logger.getLogger(CustomAuthenticationManager.class);

    @Autowired
    private ISecurityService securityService;
    @Autowired
    private SessionManager sessionManager;

    private BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        if(StringUtils.isBlank(authentication.getName()) || StringUtils.isBlank((String) authentication.getCredentials())) {
            _log.error("Username or/and password may not empty.");
            throw new BadCredentialsException("Username or/and password may not empty.");
        }

        SecUser secUser = securityService.findUserByName(authentication.getName().toUpperCase());
        if(secUser == null) {
            _log.error("User does not exists!");
            throw new BadCredentialsException("User does not exists!");
        }

        // Check what is this user multiple login or no?
        if(!securityService.isMultipleLogin(secUser)) {
            _log.error("This user is not multiple login");
            throw new BadCredentialsException("Maaf, anda tidak bisa login. Login anda sedang dipakai.");
        }

        if(!passwordEncryptor.checkPassword(((String) authentication.getCredentials()).toLowerCase(), secUser.getPassword())) {
            _log.error("Wrong password!");
            throw new BadCredentialsException("Wrong password!");
        }

        // Here's the main logic of this custom authentication manager
        // Username and password must be the same to authenticate
        if (authentication.getName().equals(authentication.getCredentials()) == true) {
            _log.debug("Entered username and password are the same!");
            throw new BadCredentialsException("Entered username and password are the same!");

        } else {

            try {
                _log.debug("User details are good and ready to go");

                Authentication tempAuth = new UsernamePasswordAuthenticationToken(authentication.getName().toUpperCase(), authentication.getCredentials(), getAuthorities(1));

                SecUserLogin userLogin = new SecUserLogin();
                userLogin.setUser(secUser);
                userLogin.setUsername(secUser.getUserName());
                userLogin.setPassword(secUser.getPassword());
                userLogin.setDescription("Login");
                userLogin.setLoginDate(new Timestamp(new Date().getTime()));
//                userLogin.setLoginDate(databaseManager.);
                userLogin.setNotes("Successful");


                int save = securityService.saveUserLogin(userLogin);
                Long uLoginId = Long.valueOf(save);

                if( uLoginId > 0) {
                    sessionManager.setUser(secUser);
                    sessionManager.setUserLogin(securityService.findUserLoginById(uLoginId));
                }

                sessionManager.setUser(secUser);

                return tempAuth;
            } catch (Exception e) {
                _log.warn("Error authentication: ", e);
            }
            writeSession();
            return null;
        }
    }

    public void writeSession() {
        System.out.print("USER SESSION AS: " + sessionManager.getUser().getUserName());
    }

    public Collection<GrantedAuthority> getAuthorities(Integer access) {
        // Create a list of grants for this user
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>(2);

        // All users are granted with ROLE_USER access
        // Therefore this user gets a ROLE_USER by default
        _log.debug("Grant ROLE_USER to this user");
        authList.add(new GrantedAuthorityImpl("ROLE_USER"));

        // Check if this user has admin access
        // We interpret Integer(1) as an admin user
        if (access.compareTo(1) == 0) {
            // User has admin access
            _log.debug("Grant ROLE_ADMIN to this user");
            authList.add(new GrantedAuthorityImpl("ROLE_ADMIN"));
        }

        // Return list of granted authorities
        return authList;
    }

}
