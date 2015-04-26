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
import org.springframework. stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
/**
 *
 * @author Matthew
 */
@Controller
@RequestMapping("/inventory")
public class InventoryController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String inventory(ModelMap map) {
        // Must return name of file (minus .jsp) under /views
        List<Item> item = DatastoreSingleton.getAllItem();
        map.addAttribute("test", "test message");
        map.addAttribute("item", item);
        return "inventory";
    }
    
}
