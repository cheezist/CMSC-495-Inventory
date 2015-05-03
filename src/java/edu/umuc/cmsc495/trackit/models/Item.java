package edu.umuc.cmsc495.trackit.models;
import java.io.Serializable;
import java.time.LocalDate;

public class Item implements Serializable  {
    
    /**
     *
     */
    public enum Type {TOWER, MONITOR, LAPTOP, PRINTER, ACCESSORY, OTHER }
    
    private static int lastId = 0;
    
    public static void setLastId (int last) {
        lastId = last;
    }
    
    private int id;
    private Type type;
    private String make;
    private String model;
    private String description;
    private String serialNumber;
    private String location;
    private int contactEmplId;
    private Department owner;
    private LocalDate dateEntered;
    private LocalDate dateModified;
    
    public Item() {
    }
    
    public int incrementId() {
        this.id = ++lastId;
        this.dateEntered = LocalDate.now();
        this.dateModified = LocalDate.now();
        return this.id;
    }
    
    /**
     * @param type What type of item is it?
     * @param make Who made it?
     * @param model What is the name?
     * @param description Have a description?
     * @param serialNumber What are the digits?
     * @param location Where is it?
     * @param pointOfContact Who takes care of it?
     * @param deptOwner Which department owns it?
     */
    public Item(Type type, String make, String model, 
            String description, String serialNumber, 
            String location, Employee pointOfContact, Department deptOwner) {
        
        // Setting the ID to the last ID +1, also incrementing last ID
        this.id = ++lastId;
        this.type = type;
        this.make = make;
        this.model = model;
        this.description = description;
        this.serialNumber = serialNumber;
        this.location = location;
        if (pointOfContact != null) {
            this.contactEmplId = pointOfContact.getId();
        } else {
            this.contactEmplId = -1;
        }
        this.owner = deptOwner;
        
        this.dateEntered = LocalDate.now();
        this.dateModified = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Get the value of itemType
     * 
     * @return the value of itemType
     */
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
        this.dateModified = LocalDate.now();
    }
    
    /**
     * Get the value of serialNumber
     * 
     * @return the value of serialNumber
     */
    public String getSerialNumber() {
        return serialNumber;
    }
    
    /**
     * Set the value of serialNumber
     *
     * @param serialNumber new value of serialNumber
     */
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        this.dateModified = LocalDate.now();
    }
    
    /**
     * Get the value of make
     * 
     * @return the value of make
     */
    public String getMake() {
        return make;
    }
    
    /**
     * Set the value of make
     *
     * @param make new value of make
     */
    public void setMake(String make) {
        this.make = make;
        this.dateModified = LocalDate.now();
    }
    
    /**
     * Get the value of model
     * 
     * @return the value of model
     */
    public String getModel() {
        return model;
    }
    
    /**
     * Set the value of model
     *
     * @param model new value of model
     */
    public void setModel(String model) {
        this.model = model;
        this.dateModified = LocalDate.now();
    }
    
    /**
     * Get the value of location
     * 
     * @return the value of location
     */
    public String getLocation() {
        return location;
    }
    
    /**
     * Set the value of location
     *
     * @param location new value of location
     */
    public void setLocation(String location) {
        this.location = location;
        this.dateModified = LocalDate.now();
    }

    public int getContactEmplId() {
        return contactEmplId;
    }

    public void setContactEmplId(int contactEmplId) {
        this.contactEmplId = contactEmplId;
    }
    
    
    
    /**
     * Get the value of pointOfContact
     * 
     * @return the value of pointOfContact
     */
    public Employee getPointOfContact() {
        Employee contact = null;
        for(Employee employee : DatastoreSingleton.getAllEmployees()) {
            if (employee.getId() == contactEmplId) {
                contact = employee;
                break;
            }
        }
        return contact;
    }
    
    /**
     * Set the value of pointOfContact
     *
     * @param pointOfContact new value of pointOfContact
     */
    public void setPointOfContact(Employee pointOfContact) {
        this.contactEmplId = pointOfContact.getId();
        this.dateModified = LocalDate.now();
    }
    
    /**
     * Get the value of owner.getDeptName()
     * 
     * @return the value of owner.getDeptName()
     */
    public Department getOwner() {
        return owner;
    }
    
    /**
     * Set the value of owner
     *
     * @param owner new value of owner
     */
    public void setOwner(Department owner) {
        this.owner = owner;
        this.dateModified = LocalDate.now();
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
        this.dateModified = LocalDate.now();
    }
    
    /**
     * Get the value of dateEntered
     * 
     * @return the value of dateEntered
     */
    public LocalDate getDateEntered(){
        return dateEntered;
    }
    
    /**
     * Get the value of dateEntered
     * 
     * @return the value of dateEntered
     */
    public LocalDate getDateModified(){
        return dateModified;
    }
}
