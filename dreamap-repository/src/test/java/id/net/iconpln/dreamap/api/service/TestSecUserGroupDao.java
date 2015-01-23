package id.net.iconpln.dreamap.api.service;

import id.net.iconpln.dreamap.api.model.security.SecUserGroup;
import id.net.iconpln.dreamap.api.service.security.ISecurityService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by UwieSilent on 1/20/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/applicationContext.xml")
public class TestSecUserGroupDao {

    @Autowired
    private ISecurityService securityService;

    @Test
    public void testFindAll() {
        List<SecUserGroup> userGroups = securityService.findAllUserGroups(0, 5);
        Assert.assertEquals(1, userGroups.size());
    }

    @Test
    public void testFindByFilter() {
        List<SecUserGroup> userGroups = securityService.findAllUserGroupsByFilter(0, 5, "z");
        Assert.assertEquals(0, userGroups.size());
    }

    @Test
    public void testCount() {
        Assert.assertEquals(1, securityService.countUserGroup());
    }

    @Test
    public void testCountByFilter() {
        Assert.assertEquals(0, securityService.countUserGroupByFilter("z"));
    }

}
