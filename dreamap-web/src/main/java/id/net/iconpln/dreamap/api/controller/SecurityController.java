package id.net.iconpln.dreamap.api.controller;

import id.net.iconpln.dreamap.api.model.security.SecUserGroup;
import id.net.iconpln.dreamap.api.service.security.ISecUserGroupService;
import id.net.iconpln.dreamap.api.service.security.ISecurityService;
import id.net.iconpln.dreamap.api.service.security.impl.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by UwieSilent on 1/8/2015.
 */
@Controller
public class SecurityController {

    @Autowired
    private ISecurityService securityService;

    @Autowired
    private ISecUserGroupService secUserGroupService;

    /*@RequestMapping(value = "/usergrouplist")
    public List<SecUserGroup> getUserGroups() {
        return securityService.getUserGroups();
//        return null;
    }*/

    @RequestMapping(value = "/usergrouplist.do", method = {RequestMethod.GET}, produces = "application/json")
    @ResponseBody
    public Map<String, Object> getUserGroups() {
        Map<String, Object> maps = new HashMap<String, Object>();
        List<SecUserGroup> list = securityService.getUserGroups();
//        maps.put("total", list.size());
        maps.put("data", list);
        maps.put("success", true);
        return maps;
//        return null;
    }


}
