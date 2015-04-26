package edu.umuc.cmsc495.trackit.models;

//import java.util.Map;
//import java.util.HashMap;
import edu.umuc.cmsc495.exceptions.InvalidLoginException;
import edu.umuc.cmsc495.exceptions.LockedAccountException;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.format.datetime.joda.LocalDateParser;

/**
 * Used to store all data, every set method should write to disk.
 * @author Christian
 */
public class DatastoreSingleton {
    
    
    
    private DatastoreSingleton() {
        
        logins = new ArrayList<>();
        items = new ArrayList<>();
        employees = new ArrayList<>();
        
        //Employee(String f_name, String l_name, int iD, Department department)
        //Item(Type itemType, String location, Employee p_o_c, Department owner, LocalDateTime entered)
        
        // Adding some logins
        logins.add(new Login("admin", "admin", "admin@admin.com", LocalDate.of(2011, Month.JUNE, 16)));
        logins.add(new Login("guest", "guest", "guest@guest.com", LocalDate.of(2015, Month.APRIL, 24)));
        logins.add(new Login("user1", "user1", "user1@user1.com", LocalDate.of(2014, Month.OCTOBER, 1)));
        logins.add(new Login("user2", "user2", "user2@user2.com", LocalDate.of(2015, Month.NOVEMBER, 28)));
        
        // Adding some employees
        Employee empCNickel = new Employee("Christian", "Nickel", Department.IT);
        employees.add(empCNickel);
        Employee empDRivers = new Employee("Denise", "Rivers", Department.IT);
        employees.add(empDRivers);
        Employee empMThompson = new Employee("Matt", "Thompson", Department.IT);
        employees.add(empMThompson);
        Employee empJPoage = new Employee("Jacob", "Poage", Department.IT);
        employees.add(empJPoage);
        
        // Adding items
        items.add(new Item(Item.Type.LAPTOP, "ASUS", "Chromebook", 
                LocalDate.of(2015, Month.NOVEMBER, 28),
                "Silver laptop/ultrabook "
                + "that runs the Chrome OS."
                + "Used for simple web browsing and testing of pages. Very stable but not recommended as a development "
                + "or word processing machine", 
                "2037196127371421571", 4, "On a desk", empCNickel, 
                Department.IT));
        items.add(new Item(Item.Type.LAPTOP, "Dell", "Latitude E6530", 
               LocalDate.of(2014, Month.NOVEMBER, 28), "", 
                "2037196127371421573", 10, "On a desk", empDRivers, 
                Department.IT));
        items.add(new Item(Item.Type.LAPTOP, "Dell", "22 inch Monitor", 
                LocalDate.of(2013, Month.NOVEMBER, 28), "", 
                "20371444441421573", 5, "On a few desks", empJPoage, 
                Department.IT));
        items.add(new Item(Item.Type.LAPTOP, "Dell", "WebCam", 
                LocalDate.of(2012, Month.NOVEMBER, 28), "", 
                "212323155177142341", 3, "On a few desks", empMThompson, 
                Department.IT));
        items.add(new Item(Item.Type.LAPTOP, "Logitech", "Ergo Mouse", 
                LocalDate.of(2011, Month.NOVEMBER, 28), "", 
                "83498200394879028", 23, "Somewhere", null, 
                Department.NONE));
        items.add(new Item(Item.Type.LAPTOP, "Apple", "Macbook", 
                LocalDate.of(2010, Month.NOVEMBER, 28), "", 
                "94529834759234741", 1, "Somewhere", null, 
                Department.ACCOUNTING));
		
    }
    
    private List<Login> logins;
    private List<Item> items;
    private List<Employee> employees;
    
    public static DatastoreSingleton getInstance() {
        return DatastoreSingletonHolder.INSTANCE;
    }
    
    
    private static class DatastoreSingletonHolder {
        private static final DatastoreSingleton INSTANCE = new DatastoreSingleton();
    }
    
    
    public static List<Login> getAllLogins() {
        return getInstance().logins;
    }
    
    public static Item getItemByID(int id) {
        
        Optional<Item> result = getInstance().items.stream()
            .filter(a -> ( a.getId() == id ))
             .findFirst();
        return result.get();
    }
    
    
    public static List<Item> getAllItems() {
        return getInstance().items;
    }
    
    
    public static List<Item> getItems(int offset, int rowcount) {
        int size = getInstance().items.size();
        int toIndex = (offset + rowcount);
        if(offset > size) {
            return null;
        }
        if (toIndex > size) {
            toIndex = size-1;
        }
        return getInstance().items.subList(offset, toIndex);
    }
    
    public static List<Item> searchItems(String term) {
        
        List<Item> result = getInstance().items.stream()
            .filter(a -> (
                        a.getMake().contains(term) ||
                        a.getModel().contains(term) ||
                        a.getDescription().contains(term) ||
                        a.getSerialNumber().contains(term) ||
                        a.getLocation().contains(term)
                    ))
            .collect(Collectors.toList());
        return result;
    }
    
    
    public static List<Item> searchItems(String term, int offset, int rowcount) {
        List<Item> result = searchItems(term);
        int size = result.size();
        int toIndex = (offset + rowcount);
        if(offset > size) {
            return null;
        }
        if (toIndex > size) {
            toIndex = size-1;
        }
        if (toIndex < 1) {
            return null;
        } else {
            return result.subList(offset, toIndex);
        }
    }
    
    
    public static List<Item> getLatestItems(int count) {
        List<Item> allItems = getInstance().items;
        Collections.sort(allItems, (Item i1, Item i2) -> i1.getDateEntered().compareTo(i2.getDateEntered()));
        if (count < allItems.size()) {
            allItems = allItems.subList(0, count-1);
        }
        return allItems;
    }
    
    public static Login getLoginByCredentials(String username, String password) 
            throws LockedAccountException, InvalidLoginException {
        Login found = null;
        Calendar calendar = new GregorianCalendar();
        for(Login login : getInstance().logins) {
            // Match on username and password
            if (username.equals(login.getUsername()) && 
                    password.equals(login.getPassword())) {
                
                // Checking for locked
                if (login.isLocked()) {
                    
                    // Unlocking if it was a while ago
                    LocalDate timeNow = LocalDate.now();
                    LocalDate lastTime = login.getLastInvalidLogin();
                    long minDiff = ChronoUnit.MINUTES.between(lastTime, timeNow);
                    
                    // comparing
                    if (minDiff > Login.ACCOUNT_LOCKOUT_MINUTES) {
                        
                        // We can unlock
                        login.setInvalidLoginCount(0);
                        login.setLocked(false);
                    } else {
                        
                        // Stays locked
                        login.setLastInvalidLogin(LocalDate.now());
                        login.setInvalidLoginCount(login.getInvalidLoginCount() + 1);
                        throw new LockedAccountException();
                    }
                    
                }
                login.setLastLogin(LocalDate.now());
                found = login;
                break;
            } else if (username.equals(login.getUsername())) {
                // This is an invalid login, we have to mark it
                login.setLastInvalidLogin(LocalDate.now());
                login.setInvalidLoginCount(login.getInvalidLoginCount() + 1);
                if (login.getInvalidLoginCount() >= Login.MAX_LOGIN_ATTEMPTS) {
                    login.setLocked(true);
                    throw new LockedAccountException();
                }
                throw new InvalidLoginException();
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
