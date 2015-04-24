package edu.umuc.cmsc495.trackit.models;

public class Department {
    
    private enum DeptName {IT, HUMAN_RESOURCES, ACCOUNTING, OPERATIONS, PUBLIC_RELATIONS}
    private String deptName;
    
    private final DeptName[] names = DeptName.values();
    
    public Department(int dept_name) {
        setDeptName(dept_name);
    }

    public String getDeptName() {
        return deptName;
    }

    private void setDeptName(int dept_name) {
        this.deptName = names[dept_name].name();
    }
    
}
