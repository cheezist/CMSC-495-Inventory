package edu.umuc.cmsc495.trackit.components;

import edu.umuc.cmsc495.trackit.models.Login;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *  Used for the session state
 * @author CMSC 495 Web Inventory Team
 */
@Component
@Scope("session")
public class CurrentUser {
    
    private Login login;

    /**
     * Get the value of login
     *
     * @return the value of login
     */
    public Login getLogin() {
        return login;
    }

    /**
     * Set the value of login
     *
     * @param login new value of login
     */
    public void setLogin(Login login) {
        this.login = login;
    }

}
