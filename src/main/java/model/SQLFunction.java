package model;

import org.hibernate.*;
import org.hibernate.Session;
import utils.HibernateSessionFactory;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SQLFunction {

    /**
     * This method create new entity "Employee" in database table "employees".
     * @see Employee
     * @throws Exception
     */
    public ArrayList<String> createEmployee(String nameAndFamily, String phone, double salary) throws Exception {
        ArrayList<String> outputData = new ArrayList<>();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Employee employee = new Employee();
        employee.setNameAndFamily(nameAndFamily);
        employee.setPhone(phone);
        employee.setSalary(salary);
        session.save(employee);
        transaction.commit();
        outputData.add("Employee " + nameAndFamily + " was created");
        session.getSessionFactory().close();
        return outputData;

    }

    /**
     * This method create new entity "Department" in database table "departments".
     * @see Department
     * @throws Exception
     */
    public ArrayList<String> createDepartment(String name, String chief, Employee employee) throws Exception {
        ArrayList<String> outputData = new ArrayList<>();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Department department = new Department();
        department.setName(name);
        department.setChief(chief);
        department.setEmployee(employee);
        session.save(department);
        transaction.commit();
        outputData.add("Department " + name + " was created");
        session.getSessionFactory().close();
        return outputData;

    }

    /**
     * This method shows all fields from "employees" table in database.
     * @throws Exception
     */
    public ArrayList<String> showEmployees() throws Exception {
        ArrayList<String> outputData = new ArrayList<>();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        List employees = session.createQuery("FROM employees").list();
        for (Iterator iterator = employees.iterator(); iterator.hasNext(); ) {
            Employee employee = (Employee) iterator.next();
            outputData.add("Name: " + employee.getNameAndFamily());
            outputData.add("Department: " + employee.getDepartmentName());
            outputData.add("Phone: " + employee.getPhone());
            outputData.add("Salary: " + String.valueOf(employee.getSalary()));
        }
        transaction.commit();
        session.getSessionFactory().close();
        return outputData;
    }

    /**
     * This method shows all fields from "departments" table in database.
     * @throws Exception
     */
    public ArrayList<String> showDepartments() throws Exception {
        ArrayList<String> outputData = new ArrayList<>();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        List departments = session.createQuery("FROM departments").list();
        for (Iterator iterator = departments.iterator(); iterator.hasNext(); ) {
            Department department = (Department) iterator.next();
            outputData.add("Name: " + department.getName());
            outputData.add("Chief: " + department.getChief());
        }
        transaction.commit();
        session.getSessionFactory().close();
        return outputData;
    }

    /**
     * This method update "salary" field in selected entity "Employee" in database table "employees".
     * @see Employee
     * @throws Exception
     */
    public ArrayList<String> updateEmployeeSalary(String employeeName, double salary) throws Exception {
        ArrayList<String> outputData = new ArrayList<>();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Employee employee = (Employee) session.get(Employee.class, employeeName);
        employee.setSalary(salary);
        session.update(employee);
        transaction.commit();
        outputData.add(employeeName + " salary was replaced on " + String.valueOf(salary));
        session.getSessionFactory().close();
        return outputData;
    }

    /**
     * This method update "departmentName" field in selected entity "Employee" in database table "employees".
     * @see Employee
     * @throws Exception
     */
    public ArrayList<String> updateEmployeeDepartment(String employeeName, String department) throws Exception {
        ArrayList<String> outputData = new ArrayList<>();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Employee employee = (Employee) session.get(Employee.class, employeeName);
        employee.setDepartmentName(department);
        session.update(employee);
        transaction.commit();
        outputData.add(employeeName + " department was replaced on " + department);
        session.getSessionFactory().close();
        return outputData;
    }

    /**
     * This method update "phone" field in selected entity "Employee" in database table "employees".
     * @see Employee
     * @throws Exception
     */
    public ArrayList<String> updateEmployeePhone(String employeeName, String phone) throws Exception {
        ArrayList<String> outputData = new ArrayList<>();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Employee employee = (Employee) session.get(Employee.class, employeeName);
        employee.setPhone(phone);
        session.update(employee);
        transaction.commit();
        outputData.add(employeeName + " phone was replaced on " + phone);
        session.getSessionFactory().close();
        return outputData;
    }

    /**
     * This method update "chief" field in selected entity "Department" in database table "departments".
     * @see Department
     * @throws Exception
     */
    public ArrayList<String> updateDepartmentChief(String departmentName, String chief) throws Exception {
        ArrayList<String> outputData = new ArrayList<>();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Department department = (Department) session.get(Department.class, departmentName);
        department.setChief(chief);
        session.update(department);
        transaction.commit();
        outputData.add(departmentName + " chief was replaced on " + chief);
        session.getSessionFactory().close();
        return outputData;
    }

    /**
     * This method delete selected entity "Employee" in database table "employees".
     * @see Employee
     * @throws Exception
     */
    public ArrayList<String> deleteEmployee(String employeeName) throws Exception {
        ArrayList<String> outputData = new ArrayList<>();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Employee employee = (Employee) session.get(Employee.class, employeeName);
        session.delete(employee);
        transaction.commit();
        outputData.add(employeeName + " was deleted.");
        session.getSessionFactory().close();
        return outputData;
    }

    /**
     * This method delete selected entity "Department" in database table "departments".
     * @see Department
     * @throws Exception
     */
    public ArrayList<String> deleteDepartment(String departmentName) throws Exception {
        ArrayList<String> outputData = new ArrayList<>();
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        transaction = session.beginTransaction();
        Department department = (Department) session.get(Department.class, departmentName);
        session.delete(department);
        transaction.commit();
        outputData.add(departmentName + " was deleted.");
        session.getSessionFactory().close();
        return outputData;
    }
}

