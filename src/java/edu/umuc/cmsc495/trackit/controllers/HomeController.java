/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umuc.cmsc495.trackit.controllers;

import edu.umuc.cmsc495.trackit.models.DatastoreSingleton;
import edu.umuc.cmsc495.trackit.models.Item;
import edu.umuc.cmsc495.trackit.models.Login;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Christian
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap map, HttpSession session) {
        // Must return name of file (minus .jsp) under /views
        List<Login> users = DatastoreSingleton.getAllLogins();
        List<Item> items = DatastoreSingleton.getLatestItems(5);
        
        map.addAttribute("login", session.getAttribute("user-login"));
        map.addAttribute("users", users);
        map.addAttribute("items", items);
        
        return "home";
    }
    
}
