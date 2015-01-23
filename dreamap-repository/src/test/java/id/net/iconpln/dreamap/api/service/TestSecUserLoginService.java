package id.net.iconpln.dreamap.api.service;

import id.net.iconpln.dreamap.api.dao.security.ISecUserLoginDao;
import id.net.iconpln.dreamap.api.model.security.SecUserLogin;
import id.net.iconpln.dreamap.api.service.security.ISecUserLoginService;
import id.net.iconpln.dreamap.api.service.security.ISecurityService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by UwieSilent on 1/20/2015.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/applicationContext.xml")
public class TestSecUserLoginService {

//    @Autowired
//    private ISecUserLoginDao secUserLoginDao;

    @Autowired
    private ISecurityService securityService;

    @Test
    public void testFindAll() {
        List<SecUserLogin> userLogins = securityService.findAllUserLogins(0, 5);
//        Assert.assertNotNull(userLogins.size());
        Assert.assertEquals(5, userLogins.size());
    }
}
