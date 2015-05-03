/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.umuc.cmsc495.trackit.controllers;

import edu.umuc.cmsc495.trackit.models.DatastoreSingleton;
import edu.umuc.cmsc495.trackit.models.Item;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author Matthew
 */
@Controller
@RequestMapping("/inventory/delete")
public class DeleteItemController extends AbstractApplicationController {
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String deleteItem(
            HttpSession session,
            @PathVariable("id") int id, 
            ModelMap map) {
        
        // valid session check.. there must be a better way of doing this
        if (!this.checkUserLogin(session)) {
            return "redirect:../../login?msg=invalid_session";
        }
        
        // Must return name of file (minus .jsp) under /views
        Item item = DatastoreSingleton.getItemByID(id);
        map.addAttribute("item", item);
        return "delete-item";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String deleteItem(Item item, BindingResult result, ModelMap model) {
        // finding the original in the list and replacing it with this
        int id = item.getId();
        DatastoreSingleton.deleteItem(item);
        return "redirect:../../inventory";
    }
    
}
