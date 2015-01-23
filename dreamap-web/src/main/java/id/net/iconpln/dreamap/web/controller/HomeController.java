package id.net.iconpln.dreamap.web.controller;

import id.net.iconpln.dreamap.api.authentication.SessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by UwieSilent on 1/8/2015.
 */
@Controller
public class HomeController {

    @Autowired
    SessionManager sessionManager;

    @RequestMapping(value = "/", method = {RequestMethod.GET, RequestMethod.POST})
    public String redirect() {
        if(sessionManager.getUser() != null) {
            return "redirect:/home";
        } else {
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

}
