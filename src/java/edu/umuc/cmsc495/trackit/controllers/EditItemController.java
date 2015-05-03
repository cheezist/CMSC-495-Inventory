package edu.umuc.cmsc495.trackit.controllers;

import edu.umuc.cmsc495.trackit.models.DatastoreSingleton;
import edu.umuc.cmsc495.trackit.models.Department;
import edu.umuc.cmsc495.trackit.models.Employee;
import edu.umuc.cmsc495.trackit.models.Item;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 * Controller for editing an inventory item, maps to /inventory/edit/{id} with
 * separate methods for POST and GET requests
 * @author CMSC 495 Web Inventory Team
 */
@Controller
@RequestMapping("/inventory/edit")
public class EditItemController extends AbstractApplicationController {
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView editItem(
            HttpSession session,
            @PathVariable("id") int id, 
            ModelMap map) {
        
        // valid session check.. there must be a better way of doing this
        if (!this.checkUserLogin(session)) {
            return new ModelAndView("redirect:../../login?msg=invalid_session");
        }
        
        // For item types
        Map<Item.Type, String> types = new HashMap();
        types.put(Item.Type.ACCESSORY, "Accessory");
        types.put(Item.Type.LAPTOP, "Laptop");
        types.put(Item.Type.MONITOR, "Montior");
        types.put(Item.Type.PRINTER, "Printer");
        types.put(Item.Type.TOWER, "Tower");
        types.put(Item.Type.OTHER, "Other");
        
        // For item departments
        Map<Department, String> departments = new HashMap();
        departments.put(Department.NONE, "None");
        departments.put(Department.ACCOUNTING, "Accounting");
        departments.put(Department.HUMAN_RESOURCES, "Human Resources");
        departments.put(Department.IT, "IT");
        departments.put(Department.OPERATIONS, "Operations");
        departments.put(Department.PUBLIC_RELATIONS, "Public Relations");
        
        // for employees
        List<Employee> employees = DatastoreSingleton.getAllEmployees();
//        Map<Employee, String> people = new HashMap();
//        for(Employee employee : employees) {
//            people.put(employee, 
//                    String.format("%s, %s - %s", 
//                            employee.getLastName(),
//                            employee.getFirstName(), 
//                            employee.getDepartment()));
//        }
        
        // Getting item
        Item item = DatastoreSingleton.getItemByID(id);
        
        // Creating model and setting view
        ModelAndView modAndView = new ModelAndView();
        modAndView.setViewName("edit-item");
        modAndView.addObject("item", item);
        modAndView.addObject("types", types);
        modAndView.addObject("people", employees);
        modAndView.addObject("departments", departments);
        return modAndView;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String editItem(
            @PathVariable("id") int id, 
            Item newItem, 
            BindingResult result, 
            ModelMap model) {
        // finding the original in the list and replacing it with this
        DatastoreSingleton.setUpdatedItem(newItem);
        return String.format("redirect:../view/%s", id);
    }
    
}
