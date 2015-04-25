package edu.umuc.cmsc495.trackit.models;

public class Department {
    
    private enum DeptName {IT, HUMAN_RESOURCES, ACCOUNTING, OPERATIONS, PUBLIC_RELATIONS}
    private String deptName;
    
    private final DeptName[] names = DeptName.values();
    
    /**
     * @param dept_name
     */
    public Department(int dept_name) {
        setDeptName(dept_name);
    }

     /**
     * Get the value of deptName
     *
     * @return the value of deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * Set the value of deptName
     *
     * @param deptName new value of deptName
     */
    private void setDeptName(int dept_name) {
        this.deptName = names[dept_name].name();
    }
    
}
