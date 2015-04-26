package edu.umuc.cmsc495.trackit.models;

//import java.util.Map;
//import java.util.HashMap;
import java.time.LocalDateTime;
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
        
        //Employee(String f_name, String l_name, int iD, Department department)
        //Item(Type itemType, String location, Employee p_o_c, Department owner, LocalDateTime entered)
        
        Calendar calendar = new GregorianCalendar();
        
        calendar.set(2011, 6, 16, 10, 12);
        Employee admin = new Employee("Christian", "Nickel", 1001, 1);
        logins.add(new Login("admin", "admin", "admin@admin.com", calendar.getTime()));
        
        calendar.set(2011, 6, 16, 10, 12);
        Employee guest = new Employee("Denise", "Rivers", 1002, 2);
        logins.add(new Login("guest", "guest", "guest@guest.com", calendar.getTime()));
        
        calendar.set(2012, 3, 24, 22, 33);
        Employee user1 = new Employee("Matt", "Thompson", 1003, 3);
        logins.add(new Login("user1", "user1", "user1@user1.com", calendar.getTime()));
        
        calendar.set(2014, 10, 1, 4, 49);
        Employee user2 = new Employee("Jacob", "Poage", 1004, 4);
        logins.add(new Login("user2", "user2", "user2@user2.com", calendar.getTime()));
        
        items = new ArrayList<>();
        
        items.add(new Item(1, "ROOM 101", admin, 1, LocalDateTime.now()));
        items.add(new Item(2, "ROOM 101", guest, 2, LocalDateTime.now()));
        items.add(new Item(3, "ROOM 101", user1, 3, LocalDateTime.now()));
        items.add(new Item(4, "ROOM 101", user2, 3, LocalDateTime.now()));
    }
    
    //We should change this to a HashMap if we have time.
    //It's lookup is constant O(1) vs O(n) for List.
    //private HashMap<email, Employee> logins;
    //Email should be enforced to be unique already so a hash should have very few collisions.
    //We want to return the username once we've found it.
    private List<Login> logins;
    
    private List<Item> items;
    
    public static DatastoreSingleton getInstance() {
        return DatastoreSingletonHolder.INSTANCE;
    }
    
    
    private static class DatastoreSingletonHolder {
        private static final DatastoreSingleton INSTANCE = new DatastoreSingleton();
    }
    
    
    public static List<Login> getAllLogins() {
        return getInstance().logins;
    }
    
    
     public static List<Item> getAllItems() {
        return getInstance().items;
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
        getInstance().items.add(item);
    }
    
    public static void removeItem(Item item) {
        getInstance().items.remove(item);
    }
}
