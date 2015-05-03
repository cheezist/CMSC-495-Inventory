package edu.umuc.cmsc495.trackit.models;

import edu.umuc.cmsc495.trackit.exceptions.InvalidLoginException;
import edu.umuc.cmsc495.trackit.exceptions.LockedAccountException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Used to store all data, every set method should write to disk.
 * @author Jacob Poage, Matthew Thompson, Denise Rivers, Christian Nickel
 */
public class DatastoreSingleton {
    
    private static final String LOGIN_FILENAME = "logins.dat";
    private static final String ITEM_FILENAME = "items.dat";
    private static final String EMPL_FILENAME = "employees.dat";
    
    private List<Login> logins;
    private List<Item> items;
    private List<Employee> employees;
    
    private DatastoreSingleton() {
        
        // Try to open logins, items, and employees from files
        logins = (List<Login>) openObject(LOGIN_FILENAME);
        items = (List<Item>) openObject(ITEM_FILENAME);
        employees = (List<Employee>) openObject(EMPL_FILENAME);
        
        // Initializing logins if they weren't found on disk
        if (logins == null) {
            logins = new ArrayList<>();
            // Adding some logins
            logins.add(new Login("admin", "admin", "admin@admin.com", LocalDate.of(2011, Month.JUNE, 16)));
            logins.add(new Login("guest", "guest", "guest@guest.com", LocalDate.of(2015, Month.APRIL, 24)));
            logins.add(new Login("user1", "user1", "user1@user1.com", LocalDate.of(2014, Month.OCTOBER, 1)));
            logins.add(new Login("user2", "user2", "user2@user2.com", LocalDate.of(2015, Month.NOVEMBER, 28)));
            // saving file
            saveObject(LOGIN_FILENAME, logins);
        }
        
        // Initializing employees, even if they weren't found on disk
        Employee empCNickel = new Employee("Christian", "Nickel", Department.IT);
        Employee empDRivers = new Employee("Denise", "Rivers", Department.IT);
        Employee empMThompson = new Employee("Matt", "Thompson", Department.IT);
        Employee empJPoage = new Employee("Jacob", "Poage", Department.IT);
        if (employees == null) {
            employees = new ArrayList<>();
            // Adding some employees
            employees.add(empCNickel);
            employees.add(empDRivers);
            employees.add(empMThompson);
            employees.add(empJPoage);
            // saving file
            saveObject(EMPL_FILENAME, employees);
        }
        
        // Initializing items if they werent found on disk
        if (items == null) {
            items = new ArrayList<>();
            // Adding some items
            items.add(new Item(Item.Type.LAPTOP, "ASUS", "Chromebook", 
                    "Silver laptop/ultrabook "
                    + "that runs the Chrome OS."
                    + "Used for simple web browsing and testing of pages. Very stable but not recommended as a development "
                    + "or word processing machine", 
                    "2037196127371421571", "On a desk", empCNickel, 
                    Department.IT));
            items.add(new Item(Item.Type.LAPTOP, "Dell", "Latitude E6530", "", 
                    "2037196127371421573", "On a desk", empDRivers, 
                    Department.IT));
            items.add(new Item(Item.Type.LAPTOP, "Dell", "22 inch Monitor", "", 
                    "20371444441421573", "On a few desks", empJPoage, 
                    Department.IT));
            items.add(new Item(Item.Type.LAPTOP, "Dell", "WebCam", "", 
                    "212323155177142341", "On a few desks", empMThompson, 
                    Department.IT));
            items.add(new Item(Item.Type.LAPTOP, "Logitech", "Ergo Mouse", "", 
                    "83498200394879028", "Somewhere", null, 
                    Department.NONE));
            items.add(new Item(Item.Type.LAPTOP, "Apple", "Macbook", "", 
                    "94529834759234741", "Somewhere", null, 
                    Department.ACCOUNTING));
            // saving file
            saveObject(ITEM_FILENAME, items);
        } else {
            // Setting the last ID to create new items
            int lastId = 0;
            for(Item item : items) {
                if (item.getId() > lastId) {
                    lastId = item.getId();
                }
            }
            Item.setLastId(lastId);
        }
		
    }

    private static void saveObject(String fileName, Object obj) {

        // Serialize
        try {
                FileOutputStream fileOut = new FileOutputStream("webapps/" + fileName);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(obj);
                out.close();
                fileOut.close();

        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }
    }

    private static Object openObject(String fileName) {
        
        Object data = null;
        
        // deserialize
        try {
                FileInputStream fileIn = new FileInputStream("webapps/" + fileName);
                ObjectInputStream in = new ObjectInputStream(fileIn);
                data = in.readObject();
                in.close();
                fileIn.close();
        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }

        return data;
    }
    
    
    public static DatastoreSingleton getInstance() {
        return DatastoreSingletonHolder.INSTANCE;
    }
    
    
    private static class DatastoreSingletonHolder {
        private static final DatastoreSingleton INSTANCE = new DatastoreSingleton();
    }
    
    public static List<Employee> getAllEmployees() {
        return getInstance().employees;
    }
    
    public static List<Login> getAllLogins() {
        return getInstance().logins;
    }

    public static void deleteItem(Item item) {
        int index = -1;
        for(int i=0; i < getInstance().items.size(); i++) {
            if (getInstance().items.get(i).getId() == item.getId()) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            getInstance().items.remove(index);
            // saving file
            getInstance().saveObject(ITEM_FILENAME, getInstance().items);
        }
    }

    public static void setUpdatedItem(Item newItem) {
        int index = -1;
        for(int i=0; i < getInstance().items.size(); i++) {
            if (getInstance().items.get(i).getId() == newItem.getId()) {
                index = i;
                break;
            }
        }
        if (index > -1) {
            getInstance().items.set(index, newItem);
            // saving file
            getInstance().saveObject(ITEM_FILENAME, getInstance().items);
        }
    }
    
    public static Item getItemByID(int id) {
        
        Optional<Item> result = getInstance().items.stream()
            .filter(a -> ( a.getId() == id ))
             .findFirst();
        Item found = null;
        try {
            found = result.get();
        } catch (NoSuchElementException ex) {
            // Do nothing
        }
        return found;
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
            toIndex = size;
        }
        return getInstance().items.subList(offset, toIndex);
    }
    
    public static List<Item> searchItems(String term) {
        String searchTerm = term.toLowerCase();
        List<Item> result = getInstance().items.stream()
            .filter(a -> (
                        a.getMake().toLowerCase().contains(searchTerm) ||
                        a.getModel().toLowerCase().contains(searchTerm) ||
                        a.getDescription().toLowerCase().contains(searchTerm) ||
                        a.getSerialNumber().toLowerCase().contains(searchTerm) ||
                        a.getLocation().toLowerCase().contains(searchTerm)
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
        if (allItems.size() <= count) {
            return allItems;
        }
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
        // saving file
        getInstance().saveObject(LOGIN_FILENAME, getInstance().logins);
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
        // saving file
        getInstance().saveObject(ITEM_FILENAME, getInstance().items);
    }
}
