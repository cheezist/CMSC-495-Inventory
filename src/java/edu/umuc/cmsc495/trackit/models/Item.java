package edu.umuc.cmsc495.trackit.models;

import java.time.LocalDateTime;

public class Item {
    
    /**
     *
     */
    public enum Type {TOWER, MONITOR, KEYBOARD, MOUSE, PRINTER }
    
    private final Type[] types = Type.values();
    private final String itemType;
    //Deleted itemName
    private String serialNumber;
    private String make;
    private String model;
    private String location;
    private Employee point_of_contact;
    private Department owner;
    private final LocalDateTime dateEntered;
    
    /**
     * @param item_Type
     * @param location
     * @param p_o_c
     * @param dateEntered
     * @param deptOwner
     */
    public Item(int item_Type, String location, Employee p_o_c, int deptOwner, LocalDateTime dateEntered) {
        this.itemType = types[item_Type].name();
        this.location = location;
        this.point_of_contact = p_o_c;
        this.owner = new Department(deptOwner);
        this.dateEntered = dateEntered;
    }
    
    /**
     * Get the value of itemType
     * 
     * @return the value of itemType
     */
    public String getItemType() {
        return itemType;
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
    public String getOwner() {
        return owner.getDeptName();
    }
    
    /**
     * Set the value of owner
     *
     * @param owner new value of owner
     */
    public void setOwner(Department owner) {
        this.owner = owner;
    }
    
    /**
     * Get the value of dateEntered
     * 
     * @return the value of dateEntered
     */
    public LocalDateTime getDateEntered(){
        return dateEntered;
    }
}
