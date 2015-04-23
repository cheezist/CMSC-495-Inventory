package edu.umuc.cmsc495.trackit.models;

import java.util.Date;

/**
 *
 * @author Christian
 */
public class Login {
    
    private String username;
    private String password;
    private String email;
    private Date lastLogin;
    
    public Login(String username, String password, String email, Date lastLogin) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.lastLogin = lastLogin;
    }

    /**
     * Get the last logged in date
     * @return Date
     */
    public Date getLastLogin() {
        return lastLogin;
    }

    /**
     * Set the last login date
     * @param lastLogin 
     */
    public void setLastLogin(Date lastLogin) {
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

    @Override
    public String toString() {
        return String.format("Username: %s, Email: %s, Last Login: %s", 
                username,
                email,
                lastLogin);
    }

    
}
