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
     * @return
     */
    public String getItemType() {
        return itemType;
    }
    
    public String getSerialNumber() {
        return serialNumber;
    }
    
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    
    public String getMake() {
        return make;
    }
    
    public void setMake(String make) {
        this.make = make;
    }
    
    public String getModel() {
        return model;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public Employee getPoint_of_contact() {
        return point_of_contact;
    }
    
    public void setPoint_of_contact(Employee point_of_contact) {
        this.point_of_contact = point_of_contact;
    }
    
    public String getOwner() {
        return owner.getDeptName();
    }
    
    public void setOwner(Department owner) {
        this.owner = owner;
    }
    
    public LocalDateTime getDateEntered(){
        return dateEntered;
    }
}
