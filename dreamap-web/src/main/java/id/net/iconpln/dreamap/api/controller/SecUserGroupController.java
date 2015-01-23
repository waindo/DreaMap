package id.net.iconpln.dreamap.api.controller;

import id.net.iconpln.dreamap.api.model.security.SecUserGroup;
import id.net.iconpln.dreamap.api.service.security.ISecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by UwieSilent on 1/20/2015.
 */
@Controller
public class SecUserGroupController {

    @Autowired
    private ISecurityService securityService;

    @RequestMapping(value = "/usergroup.action")
    public @ResponseBody Map<String, ? extends Object> findAllUserGroups(@RequestParam int start, @RequestParam int limit) {
        Map<String, Object> modelMap = new HashMap<String, Object>(3);
        try {
            modelMap.put("total", securityService.countUserGroup());
            modelMap.put("data", securityService.findAllUserGroups(start, start + limit));
            modelMap.put("success", true);
            return modelMap;
        } catch(Exception e) {
            e.printStackTrace();
            modelMap.put("success", false);
            return modelMap;
        }
    }

}
