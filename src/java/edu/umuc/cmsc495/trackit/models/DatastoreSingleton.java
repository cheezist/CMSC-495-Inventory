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
        item = new ArrayList<>();
        
        Calendar calendar = new GregorianCalendar();
        calendar.set(2011, 6, 16, 10, 12);
        logins.add(new Login("admin", "admin", "admin@admin.com", calendar.getTime()));
        calendar.set(2011, 6, 16, 10, 12);
        logins.add(new Login("guest", "guest", "guest@guest.com", calendar.getTime()));
        calendar.set(2012, 3, 24, 22, 33);
        logins.add(new Login("user1", "user1", "user1@user1.com", calendar.getTime()));
        calendar.set(2014, 10, 1, 4, 49);
        logins.add(new Login("user2", "user2", "user2@user2.com", calendar.getTime()));
        
        calendar.set(2015, 1, 15, 3, 24);
        item.add(new Item("ASUS","Chromebook", calendar.getTime(), 6, "Silver laptop/ultrabook that runs the Chrome OS."
                + "Used for simple web browsing and testing of pages. Very stable but not recommended as a development "
                + "or word processing machine"));
        calendar.set(2014, 0, 24, 3, 24);
        item.add(new Item("Dell","Latitude E6530", calendar.getTime(), 10, ""));
        calendar.set(2012, 8, 15, 3, 24);
        item.add(new Item("Dell","22 inch Monitor", calendar.getTime(), 5, ""));
        calendar.set(2013, 3, 26, 3, 24);
        item.add(new Item("Dell","WebCam", calendar.getTime(), 3, ""));
        calendar.set(2010, 6, 07, 3, 24);
        item.add(new Item("Logitech","Ergo Mouse", calendar.getTime(), 23, ""));
        calendar.set(2014, 10, 14, 3, 24);
        item.add(new Item("Apple","Macbook", calendar.getTime(), 1, ""));
        
        
    }
    
    //We should change this to a HashMap if we have time.
    //It's lookup is constant O(1) vs O(n) for List.
    //private HashMap<email, Employee> logins;
    //Email should be enforced to be unique already so a hash should have very few collisions.
    //We want to return the username once we've found it.
    private List<Login> logins;
    private List<Item> item;
    
    public static DatastoreSingleton getInstance() {
        return DatastoreSingletonHolder.INSTANCE;
    }
    
    private static class DatastoreSingletonHolder {
        private static final DatastoreSingleton INSTANCE = new DatastoreSingleton();
    }
    
    
    public static List<Login> getAllLogins() {
        return getInstance().logins;
    }
   
    public static List<Item> getAllItem() {
        return getInstance().item;
        
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
    
    public static void addItem(Item item) {
        getInstance().item.add(item);
    }
    
    public static void removeItem(Item item) {
        getInstance().item.remove(item);
    }
    
    
}
