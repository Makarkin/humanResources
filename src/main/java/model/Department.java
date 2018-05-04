package model;

import javax.persistence.*;

@Entity(name = "departments")
@Table(name = "departments")
public class Department {

    @Id
    @Column(name = "name", nullable = false, insertable = true, updatable = true)
    private String name;

    @Column(name = "chief", nullable = true, insertable = true, updatable = true)
    private String chief;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "department")
    private Employee employee;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Employee getEmployee() { return employee; }

    public void setEmployee(Employee employee) { employee.setDepartment(this); this.employee = employee; }

    public String getChief() {
        return chief;
    }

    public void setChief(String chief) {
        this.chief = chief;
    }

    public Department() {
    }
}
