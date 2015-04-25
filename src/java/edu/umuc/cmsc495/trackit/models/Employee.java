package edu.umuc.cmsc495.trackit.models;

public class Employee {
    
    private String f_name;
    private String l_name;
    private String phoneNumber;
    private int ID;
    private Department department;
    
    /**
     * @param f_name
     * @param l_name
     * @param iD
     * @param dept
     */
    public Employee(String f_name, String l_name, int iD, int dept) {
        this.f_name = f_name;
        this.l_name = l_name;
        this.ID = iD;
        this.department = new Department(dept);
    }
    
    /**
     * Get the value of f_name
     *
     * @return the value of f_name
     */
    public String getF_name() {
        return f_name;
    }
    
    /**
     * Set the value of f_name
     *
     * @param f_name new value of f_name
     */
    public void setF_name(String f_name) {
        this.f_name = f_name;
    }
    
    /**
     * Get the value of l_name
     *
     * @return the value of l_name
     */
    public String getL_name() {
        return l_name;
    }
    
    /**
     * Set the value of l_name
     *
     * @param l_name new value of l_name
     */
    public void setL_name(String l_name) {
        this.l_name = l_name;
    }
    
    /**
     * Get the value of ID
     *
     * @return the value of ID
     */
    public int getID() {
        return ID;
    }
    
    /**
     * Set the value of ID
     *
     * @param iD new value of ID
     */
    public void setID(int iD) {
        this.ID = iD;
    }
    
    /**
     * Get the value of department
     *
     * @return the value of department
     */
    public Department getDepartment() {
        return department;
    }
    
    /**
     * Set the value of department
     *
     * @param dept new value of department
     */
    public void setDepartment(int dept) {
        this.department = new Department(dept);
    }
    
    /**
     * Get the value of phoneNumber
     *
     * @return the value of phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /**
     * Set the value of phoneNumber
     *
     * @param phoneNumber new value of phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    
}