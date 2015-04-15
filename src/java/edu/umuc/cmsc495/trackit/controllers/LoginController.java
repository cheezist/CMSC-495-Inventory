package edu.umuc.cmsc495.trackit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Christian
 */
@Controller
public class LoginController {
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(ModelMap map) {
        // Must return name of file (minus .jsp) under /views
        return "login";
    }
    
    @RequestMapping(value = "/loginError", method = RequestMethod.GET)
    public String loginError(ModelMap map) {
        map.addAttribute("error", "true");
        // Must return name of file (minus .jsp) under /views
        return "login";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginSuccess(ModelMap map) {
        return "inventory";
    }
    
}
