package edu.umuc.cmsc495.trackit.controllers;

import edu.umuc.cmsc495.trackit.models.DatastoreSingleton;
import edu.umuc.cmsc495.trackit.models.Item;
import org.springframework. stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author Matthew
 */
@Controller
@RequestMapping("/inventory/view")
public class ViewItemController {
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String viewItem(@PathVariable("id") int id, ModelMap map) {
        // Must return name of file (minus .jsp) under /views
        Item item = DatastoreSingleton.getItemByID(id);
        map.addAttribute("item", item);
        return "view-item";
    }
    
}
