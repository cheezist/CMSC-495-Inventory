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
 * Controller for the home page, maps to /home. The single method maps to the
 * GET request and returns some information about logins and latest items.
 * @author CMSC 495 Web Inventory Team
 */
@Controller
@RequestMapping("/home")
public class HomeController extends AbstractApplicationController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap map, HttpSession session) {
        
        // valid session check.. there must be a better way of doing this
        if (!this.checkUserLogin(session)) {
            return "redirect:login?msg=invalid_session";
        }
        
        // Must return name of file (minus .jsp) under /views
        List<Login> users = DatastoreSingleton.getAllLogins();
        List<Item> items = DatastoreSingleton.getLatestItems(5);
        
        map.addAttribute("users", users);
        map.addAttribute("items", items);
        
        return "home";
    }
    
}
