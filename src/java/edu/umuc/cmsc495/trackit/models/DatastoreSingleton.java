package edu.umuc.cmsc495.trackit.models;

//import java.util.Map;
//import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Used to store all data, every set method should write to disk.
 * @author Christian
 */
public class DatastoreSingleton {
    
    private DatastoreSingleton() {
        logins = new ArrayList<>();
        
        logins.add(new Login("Admin", "Admin", "admin@admin.com"));
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
    
    public static void addLogin(Login login) {
        getInstance().logins.add(login);
    }
    
    public static void removeLogin(Login login) {
        getInstance().logins.remove(login);
    }
    
    
}
