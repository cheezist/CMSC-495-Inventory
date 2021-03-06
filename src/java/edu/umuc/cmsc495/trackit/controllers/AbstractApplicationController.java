package edu.umuc.cmsc495.trackit.controllers;

import edu.umuc.cmsc495.trackit.models.Login;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

/**
 * Abstract controller meant to be used for utility functions
 * @author CMSC 495 Web Inventory Team
 */
@Controller
public abstract class AbstractApplicationController {
    
    /**
     * Checks for the user's login session
     * @param session 
     * @return true if valid
     */
    protected boolean checkUserLogin(HttpSession session) {
        
        boolean valid = false;
        try {
            Login currentLogin = (Login) session.getAttribute("userLogin");
            
            if (currentLogin != null) {
                valid = true;
            }
            
        } catch (Exception ex) {
            // eh
        }
        
        return valid;
    }
    
}
