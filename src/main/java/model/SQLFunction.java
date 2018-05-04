package model;

import org.hibernate.*;
import org.hibernate.Session;
import utils.HibernateSessionFactory;
import java.util.Iterator;
import java.util.List;

public class SQLFunction {

    public void createEmployee(String nameAndFamily, String phone, double salary) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Employee employee = new Employee();
            employee.setNameAndFamily(nameAndFamily);
            employee.setPhone(phone);
            employee.setSalary(salary);
            session.save(employee);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.getSessionFactory().close();
        }
    }

    public void createDepartment(String name, String chief, Employee employee) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Department department = new Department();
            department.setName(name);
            department.setChief(chief);
            department.setEmployee(employee);
            session.save(department);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.getSessionFactory().close();
        }
    }

    public void listEmployees() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List employees = session.createQuery("FROM employees").list();
            for (Iterator iterator = employees.iterator(); iterator.hasNext(); ) {
                Employee employee = (Employee) iterator.next();
                System.out.print("Name: " + employee.getNameAndFamily());
                System.out.print("Department: " + employee.getDepartmentName());
                System.out.print("Phone: " + employee.getPhone());
                System.out.println("Salary: " + employee.getSalary());
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.getSessionFactory().close();
        }
    }

    public void listDepartments() {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List departments = session.createQuery("FROM departments").list();
            for (Iterator iterator = departments.iterator(); iterator.hasNext(); ) {
                Department department = (Department) iterator.next();
                System.out.print("Name: " + department.getName());
                System.out.print("Chief: " + department.getChief());
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.getSessionFactory().close();
        }
    }

    public void updateEmployeeSalary(String employeeName, double salary) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, employeeName);
            employee.setSalary(salary);
            session.update(employee);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.getSessionFactory().close();
        }
    }

    public void updateEmployeeDepartment(String employeeName, String department) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, employeeName);
            employee.setDepartmentName(department);
            session.update(employee);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.getSessionFactory().close();
        }
    }

    public void updateEmployeePhone(String employeeName, String phone) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, employeeName);
            employee.setPhone(phone);
            session.update(employee);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.getSessionFactory().close();
        }
    }

    public void updateEmployeeName(String employeeName, String name) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, employeeName);
            employee.setNameAndFamily(name);
            session.update(employee);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.getSessionFactory().close();
        }
    }

    public void updateDepartmentName(String departmentName, String name) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Department department = (Department) session.get(Department.class, departmentName);
            department.setName(name);
            session.update(department);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.getSessionFactory().close();
        }
    }

    public void updateDepartmentChief(String departmentName, String chief) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Department department = (Department) session.get(Department.class, departmentName);
            department.setChief(chief);
            session.update(department);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.getSessionFactory().close();
        }
    }

    public void deleteEmployee(String employeeName) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Employee employee = (Employee) session.get(Employee.class, employeeName);
            session.delete(employee);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.getSessionFactory().close();
        }
    }

    public void deleteDepartment(String departmentName) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Department department = (Department) session.get(Department.class, departmentName);
            session.delete(department);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
                e.printStackTrace();
            }
        } finally {
            session.getSessionFactory().close();
        }
    }
}

