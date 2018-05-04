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

    public Department getDepartment() { return department; }

    public void setDepartment(Department department) { this.department = department; }

    public String getNameAndFamily() {
        return nameAndFamily;
    }

    public void setNameAndFamily(String nameAndFamily) {
        this.nameAndFamily = nameAndFamily;
    }

    public String getDepartmentName() { return departmentName; }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee() {
    }
}
