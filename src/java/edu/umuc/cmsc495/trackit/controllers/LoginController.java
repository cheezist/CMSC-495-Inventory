package edu.umuc.cmsc495.trackit.controllers;

import java.security.Principal;
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
    
    @RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
    public String loginSuccess(ModelMap map, Principal principal) {
        String name = principal.getName();
        map.addAttribute("username", name);
        // Must return name of file (minus .jsp) under /views
        return "inventory";
    }
    
}
