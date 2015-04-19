package edu.umuc.cmsc495.trackit.models;

public class Employee {
    
    private String f_name;
    private String l_name;
    private String phoneNumber;
    private int ID;
    private Department department;
    
    public Employee(String f_name, String l_name, int iD, Department department) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.ID = iD;
        this.department = department;
    }
    
    public String getF_name() {
        return f_name;
    }
    
    public void setF_name(String f_name) {
        this.f_name = f_name;
    }
    
    public String getL_name() {
        return l_name;
    }
    
    public void setL_name(String l_name) {
        this.l_name = l_name;
    }
    
    public int getID() {
        return ID;
    }
    
    public void setID(int iD) {
        ID = iD;
    }
    
    public Department getDepartment() {
        return department;
    }
    
    public void setDepartment(Department department) {
        this.department = department;
    }
    
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}