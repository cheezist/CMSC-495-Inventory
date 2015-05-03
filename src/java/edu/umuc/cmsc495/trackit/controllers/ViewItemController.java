package edu.umuc.cmsc495.trackit.controllers;

import edu.umuc.cmsc495.trackit.models.DatastoreSingleton;
import edu.umuc.cmsc495.trackit.models.Item;
<<<<<<< HEAD
import edu.umuc.cmsc495.trackit.models.Login;
import java.util.List;
=======
>>>>>>> e65eed8e48efbba429c992590abd19961a4ec15b
import org.springframework. stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.portlet.ModelAndView;
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
<<<<<<< HEAD
        List<Item> item = DatastoreSingleton.getAllItem();
        map.addAttribute("test", "test message");
=======
        Item item = DatastoreSingleton.getItemByID(id);
>>>>>>> e65eed8e48efbba429c992590abd19961a4ec15b
        map.addAttribute("item", item);
        return "view-item";
    }
    
}
