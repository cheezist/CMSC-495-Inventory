package edu.umuc.cmsc495.trackit.controllers;

import edu.umuc.cmsc495.exceptions.InvalidLoginException;
import edu.umuc.cmsc495.exceptions.LockedAccountException;
import edu.umuc.cmsc495.trackit.models.DatastoreSingleton;
import edu.umuc.cmsc495.trackit.models.Login;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Represents the login view
 * @author Christian
 */
@Controller
@RequestMapping({"/", "/login"})
public class LoginController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String login(ModelMap map, HttpSession session) {
        session.setAttribute("user-login", null);
        // Must return name of file (minus .jsp) under /views
        return "login";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String login(@RequestParam("username") String username, 
            @RequestParam("password") String password, ModelMap map,
            HttpSession session) {
        
        // Finding user by their credentials
        Login login;
        try {
            login = DatastoreSingleton.getLoginByCredentials(username, password);
        } catch (LockedAccountException ex) {
            map.addAttribute("msg", "This account is locked, please try again later!");
            return "login";
        } catch (InvalidLoginException ex) {
            map.addAttribute("msg", "Incorrect username or password, please try again!");
            return "login";
        }
        boolean authenticated = (login != null);
        
        if (authenticated) {
            // Authenticated gets redirected to the home page
            map.addAttribute("from", "login");
            map.addAttribute("msg", "Thanks for signing in!");
            // Adding user's session
            session.setAttribute("user-login", login);
            return "redirect:home";
        } else {
            // No authentication exists, refreshing page with error
            map.addAttribute("msg", "Incorrect username or password, please try again!");
            return "login";
        }
        
    }
    
}
