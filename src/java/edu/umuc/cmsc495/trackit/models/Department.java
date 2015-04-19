package edu.umuc.cmsc495.trackit.models;

public class Department {
    
    private String dept_name;
    
    public Department(String dept_name) {
        this.setDept_name(dept_name);
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }
    
}
