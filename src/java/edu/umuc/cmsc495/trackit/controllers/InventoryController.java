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
<<<<<<< HEAD
import org.springframework.web.portlet.ModelAndView;
=======
import org.springframework.web.bind.annotation.RequestParam;
>>>>>>> e65eed8e48efbba429c992590abd19961a4ec15b
/**
 *
 * @author Matthew
 */
@Controller
@RequestMapping("/inventory")
public class InventoryController {
    
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public String inventory(
            @RequestParam(value = "term", defaultValue = "") String term, 
            @RequestParam(value = "offset", defaultValue = "0") int offset, 
            @RequestParam(value = "rowcount", defaultValue = "10") int rowcount, 
            ModelMap map) {
        
        // Getting counts so we can get the number of pages
        int total;
        if (!term.equals("")) {
            total = DatastoreSingleton.searchItems(term).size();
        } else {
            total = DatastoreSingleton.getAllItems().size();
        }
        int pages = (int)Math.ceil((double)total / (double)rowcount);
        int first = offset + 1;
        int last = ((offset + rowcount) < total) ? (offset + rowcount) : total;
        String searchTerm = "";
        
        // Must return name of file (minus .jsp) under /views
<<<<<<< HEAD
        List<Item> item = DatastoreSingleton.getAllItem();
        map.addAttribute("test", "test message");
        map.addAttribute("item", item);
=======
        List<Item> items;
        // different call if it was a search
        if (!term.equals("")) {
            items = DatastoreSingleton.searchItems(term, offset, rowcount);
            searchTerm = "&term=" + term;
        } else {
            items = DatastoreSingleton.getItems(offset, rowcount);
        }
        map.addAttribute("term", term);
        map.addAttribute("pages", pages);
        map.addAttribute("offset", offset);
        map.addAttribute("rowcount", rowcount);
        map.addAttribute("total", total);
        map.addAttribute("first", first);
        map.addAttribute("last", last);
        map.addAttribute("items", items);
        map.addAttribute("searchTerm", searchTerm);
>>>>>>> e65eed8e48efbba429c992590abd19961a4ec15b
        return "inventory";
    }
    
}
