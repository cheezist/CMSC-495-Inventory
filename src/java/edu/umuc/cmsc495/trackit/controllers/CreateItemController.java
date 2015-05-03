/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
/**
 *
 * @author Matthew
 */
@Controller
@RequestMapping("/inventory/new")
public class CreateItemController extends AbstractApplicationController {
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView createItem(ModelMap map, HttpSession session) {
        
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
        
        // Getting item
        Item item = new Item();
        
        // Creating model and setting view
        ModelAndView modAndView = new ModelAndView();
        modAndView.setViewName("create-item");
        modAndView.addObject("item", item);
        modAndView.addObject("types", types);
        modAndView.addObject("people", employees);
        modAndView.addObject("departments", departments);
        return modAndView;
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String createItem(Item newItem, BindingResult result, ModelMap model) {
        // finding the original in the list and replacing it with this
        int newId = newItem.incrementId();
        DatastoreSingleton.addItem(newItem);
        return String.format("redirect:../inventory/view/%s", newId);
    }
    
}