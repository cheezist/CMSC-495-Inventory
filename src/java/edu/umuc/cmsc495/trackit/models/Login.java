package edu.umuc.cmsc495.trackit.models;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * POJO for the Login.
 * @author CMSC 495 Web Inventory Team
 */
public class Login implements Serializable {
    
    
    public static final int MAX_LOGIN_ATTEMPTS = 5;
    public static final int ACCOUNT_LOCKOUT_MINUTES = 5;
    
    private String username;
    private String password;
    private String email;
    private int invalidLoginCount;
    private boolean locked;
    private LocalDate lastInvalidLogin;
    private LocalDate lastLogin;
    
    /**
     * @param username
     * @param password
     * @param email
     * @param lastLogin
     */    
    public Login(String username, String password, String email, LocalDate lastLogin) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.lastLogin = lastLogin;
        this.invalidLoginCount = 0;
        this.locked = false;
    }

    /**
     * Get the last logged in date
     * @return Date
     */
    public LocalDate getLastLogin() {
        return lastLogin;
    }

    /**
     * Set the last login date
     * @param lastLogin 
     */
    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Get the value of password
     *
     * @return the value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    

    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the value of username
     *
     * @param username new value of username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public int getInvalidLoginCount() {
        return invalidLoginCount;
    }

    public void setInvalidLoginCount(int invalidLoginCount) {
        this.invalidLoginCount = invalidLoginCount;
    }

    public LocalDate getLastInvalidLogin() {
        return lastInvalidLogin;
    }

    public void setLastInvalidLogin(LocalDate lastInvalidLogin) {
        this.lastInvalidLogin = lastInvalidLogin;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }
    
        

    @Override
    public String toString() {
        return String.format("Username: %s, Email: %s, Last Login: %s", 
                username,
                email,
                lastLogin);
    }
    
    

    
}
