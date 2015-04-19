package edu.umuc.cmsc495.trackit.models;

public class Item {
    
    private String itemType;
    private String itemName;
    private String serialNumber;
    private String make;
    private String model;
    private String location;
    private Employee point_of_contact;
    private Department owner;
    
    public Item(String itemType, String item_name, String location, Employee employee, Department owner) {
        this.itemType = itemType;
        this.itemName = item_name;
        this.location = location;
        this.point_of_contact = employee;
        this.owner = owner;
    }
    
    public String getItemType() {
        return itemType;
    }
    
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
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
    
    public String getItem_name() {
        return itemName;
    }
    
    public void setItem_name(String item_name) {
        this.itemName = item_name;
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
    
    public Department getOwner() {
        return owner;
    }
    
    public void setOwner(Department owner) {
        this.owner = owner;
    }
    
}
