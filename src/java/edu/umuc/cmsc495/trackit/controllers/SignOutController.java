package edu.umuc.cmsc495.trackit.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Christian
 */
@Controller
@RequestMapping({"/sign-out"})
public class SignOutController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String login(HttpSession session) {
        
        // Killing user's session
        session.setAttribute("userLogin", null);
        return "redirect:login";
        
    }
    
}
