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
import edu.umuc.cmsc495.trackit.models.Login;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author Matthew
 */
@Controller
@RequestMapping("/reports")
public class ReportsController extends AbstractApplicationController {
    
    @RequestMapping(method = RequestMethod.GET)
    public String reports(ModelMap map, HttpSession session) {
        
        // valid session check.. there must be a better way of doing this
        if (!this.checkUserLogin(session)) {
            return "redirect:login?msg=invalid_session";
        }
        
        // Getting all items to use here
        int index = 0;
        List<Item> items = DatastoreSingleton.getAllItems();
        List<Employee> employees = DatastoreSingleton.getAllEmployees();
        List<Login> logins = DatastoreSingleton.getAllLogins();
        
        map.addAttribute("totalItems", items.size());
        map.addAttribute("totalEmployees", employees.size());
        map.addAttribute("totalLogins", logins.size());
        
        // Creating a list of stats by owner
        Map<Department, Long> byOwnerMap;
        byOwnerMap = items.stream()
                .collect(Collectors.groupingBy((Item o) -> {
                    return o.getOwner();
                }, Collectors.counting()));
        map.addAttribute("itemsByOwners", byOwnerMap);
        
        // Creating a list of stats by bake
        Map<String, Long> byMakeMap;
        byMakeMap = items.stream()
                .collect(Collectors.groupingBy((Item o) -> {
                    return o.getMake();
                }, Collectors.counting()));
        map.addAttribute("itemsByMakes", byMakeMap);
        
        // Must return name of file (minus .jsp) under /views
        return "reports";
    }
    
    private class ReportStat {
        public String name;
        public long count;
        public ReportStat(String name, long count) {
            this.name = name;
            this.count = count;
        }
    }
    
}
