package edu.umuc.cmsc495.trackit.models;
<<<<<<< HEAD
import java.util.Date;

public class Item {
    
    private String model;
    private String description;
    private String itemName;
    private String serialNumber;
    private String make;
=======
import java.time.LocalDate;
import java.util.Date;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Item {
    
    /**
     *
     */
    public enum Type {TOWER, MONITOR, LAPTOP, PRINTER, ACCESSORY, OTHER }
    
    private static int lastId = 0;
    
    private int id;
    private Type type;
    private String make;
    private String model;
    private String description;
    private String serialNumber;
>>>>>>> e65eed8e48efbba429c992590abd19961a4ec15b
    private String location;
    private Integer quantity;
    private Employee point_of_contact;
    private Department owner;
<<<<<<< HEAD
    private Date made;
        
    public Item(String model, String make, Date made, Integer quantity, String description) {
        this.model = model;
        this.make = make;
        this.made = made;
        this.quantity = quantity;
        this.description = description;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
=======
    private LocalDate made;
    private LocalDate dateEntered;
    private LocalDate dateModified;
    
    /**
     * @param type What type of item is it?
     * @param make Who made it?
     * @param model What is the name?
     * @param made When it was made?
     * @param description Have a description?
     * @param serialNumber What are the digits?
     * @param location Where is it?
     * @param quantity How many exist?
     * @param p_o_c Who takes care of it?
     * @param deptOwner Which department owns it?
     */
    public Item(Type type, String make, String model, LocalDate made, 
            String description, String serialNumber, int quantity,
            String location, Employee p_o_c, Department deptOwner) {
        
        // Setting the ID to the last ID +1, also incrementing last ID
        this.id = ++lastId;
        this.type = type;
        this.make = make;
        this.model = model;
        this.made = made;
        this.description = description;
        this.serialNumber = serialNumber;
        this.quantity = quantity;
        this.location = location;
        this.point_of_contact = p_o_c;
        this.owner = deptOwner;
        
        this.dateEntered = LocalDate.now();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
>>>>>>> e65eed8e48efbba429c992590abd19961a4ec15b
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
    }
<<<<<<< HEAD
        
    public String getItem_name() {
        return itemName;
    }
    
    public void setItem_name(String item_name) {
        this.itemName = item_name;
    }
    
=======
    
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
    }
    
    /**
     * Get the value of location
     * 
     * @return the value of location
     */
>>>>>>> e65eed8e48efbba429c992590abd19961a4ec15b
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
    }
    
    /**
     * Get the value of point_of_contact
     * 
     * @return the value of point_of_contact
     */
    public Employee getPoint_of_contact() {
        return point_of_contact;
    }
    
    /**
     * Set the value of point_of_contact
     *
     * @param point_of_contact new value of point_of_contact
     */
    public void setPoint_of_contact(Employee point_of_contact) {
        this.point_of_contact = point_of_contact;
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
    }
<<<<<<< HEAD
    public Date getMade() {
        return made;
    }

    public void setMade(Date made) {
=======
    public LocalDate getMade() {
        return made;
    }

    public void setMade(LocalDate made) {
>>>>>>> e65eed8e48efbba429c992590abd19961a4ec15b
        this.made = made;
    }
    public Integer getQuantity() {
        return quantity;
    }
<<<<<<< HEAD
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
=======
>>>>>>> e65eed8e48efbba429c992590abd19961a4ec15b
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
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
