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

    /**
     *This is getter for String "name" field.
     *@return String "generalOrder" field.
     */
    public String getName() { return name; }


    /**
     *This is setter for String "name" field.
     */
    public void setName(String name) { this.name = name; }


    /**
     *This is getter for "employee" field.
     *@return Employee "generalOrder" field.
     * @see Employee
     */
    public Employee getEmployee() { return employee; }


    /**
     *This is setter for "employee" field.
     *@see Employee
     */
    public void setEmployee(Employee employee) { employee.setDepartment(this); this.employee = employee; }

    /**
     *This is getter for String "chief" field.
     *@return String "chief" field.
     */
    public String getChief() {
        return chief;
    }

    /**
     *This is setter for String "chief" field.
     */
    public void setChief(String chief) {
        this.chief = chief;
    }

    public Department() {
    }
}
