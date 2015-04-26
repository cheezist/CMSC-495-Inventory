package edu.umuc.cmsc495.trackit.models;
import java.util.Date;

public class Item {
    
    private String model;
    private String description;
    private String itemName;
    private String serialNumber;
    private String make;
    private String location;
    private Integer quantity;
    private Employee point_of_contact;
    private Department owner;
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
    public Date getMade() {
        return made;
    }

    public void setMade(Date made) {
        this.made = made;
    }
    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
}
