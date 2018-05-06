package model;

import javax.persistence.*;

@Entity(name = "employees")
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "name", nullable = false, insertable = true, updatable = true)
    private String nameAndFamily;

    @Column(name = "phone", nullable = true, insertable = true, updatable = true)
    private String phone;

    @Column(name = "salary",  nullable = true, insertable = true, updatable = true)
    private double salary;

    @Column(name = "department_name",  nullable = true, insertable = false, updatable = false)
    private String departmentName;

    @OneToOne
    @JoinColumn(name = "department_name", referencedColumnName = "name")
    private Department department;

    /**
     *This is getter for Department "department" field.
     *@return Department "department" field.
     *@see Department
     */
    public Department getDepartment() { return department; }


    /**
     *This is setter for Department "department" field.
     *@see Department
     */
    public void setDepartment(Department department) { this.department = department; }

    /**
     *This is getter for String "nameAndFamily" field.
     *@return String "nameAndFamily" field.
     */
    public String getNameAndFamily() {
        return nameAndFamily;
    }

    /**
     *This is setter for String "nameAndFamily" field.
     */
    public void setNameAndFamily(String nameAndFamily) {
        this.nameAndFamily = nameAndFamily;
    }


    /**
     *This is getter for String "departmentName" field.
     *@return String "departmentName" field.
     */
    public String getDepartmentName() { return departmentName; }

    /**
     *This is setter for String "departmentName" field.
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     *This is getter for String "phone" field.
     *@return String "phone" field.
     */
    public String getPhone() {
        return phone;
    }

    /**
     *This is setter for String "phone" field.
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *This is getter for double "salary" field.
     *@return double "phone" field.
     */
    public double getSalary() {
        return salary;
    }

    /**
     *This is setter for double "salary" field.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee() {
    }
}
