package edu.umuc.cmsc495.trackit.models;

//import java.util.Map;
//import java.util.HashMap;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Used to store all data, every set method should write to disk.
 * @author Christian
 */
public class DatastoreSingleton {
    
    private DatastoreSingleton() {
        logins = new ArrayList<>();
        
        Calendar calendar = new GregorianCalendar();
        calendar.set(2011, 6, 16, 10, 12);
        logins.add(new Login("admin", "admin", "admin@admin.com", calendar.getTime()));
        calendar.set(2011, 6, 16, 10, 12);
        logins.add(new Login("guest", "guest", "guest@guest.com", calendar.getTime()));
        calendar.set(2012, 3, 24, 22, 33);
        logins.add(new Login("user1", "user1", "user1@user1.com", calendar.getTime()));
        calendar.set(2014, 10, 1, 4, 49);
        logins.add(new Login("user2", "user2", "user2@user2.com", calendar.getTime()));
    }
    
    //We should change this to a HashMap if we have time.
    //It's lookup is constant O(1) vs O(n) for List.
    //private HashMap<email, Employee> logins;
    //Email should be enforced to be unique already so a hash should have very few collisions.
    //We want to return the username once we've found it.
    private List<Login> logins;
    
    public static DatastoreSingleton getInstance() {
        return DatastoreSingletonHolder.INSTANCE;
    }
    
    private static class DatastoreSingletonHolder {
        private static final DatastoreSingleton INSTANCE = new DatastoreSingleton();
    }
    
    
    public static List<Login> getAllLogins() {
        return getInstance().logins;
    }
    
    public static Login getLoginByCredentials(String username, String password) {
        Login found = null;
        for(Login login : getInstance().logins) {
            // Match on username and password
            if (username.equals(login.getUsername()) && 
                    password.equals(login.getPassword())) {
                found = login;
                break;
            }
        }
        return found;
    }
    
    public static void addLogin(Login login) {
        getInstance().logins.add(login);
    }
    
    public static void removeLogin(Login login) {
        getInstance().logins.remove(login);
    }
    
    
}
