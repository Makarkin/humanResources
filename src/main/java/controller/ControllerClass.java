package controller;

import model.Employee;
import model.SQLFunction;
import org.hibernate.HibernateException;
import view.UserView;
import java.util.ArrayList;

public class ControllerClass {
    private UserView userView = new UserView();
    private SQLFunction sqlFunction = new SQLFunction();
    String tempName;

    /**
     * This method collects information from "UserView" class fields,
     * and corresponds it to "SQLFunction" query creator.
     * @see UserView
     * @see SQLFunction
     */
    public void getInformation() {
        userView.chooseAction();
        String typeOfAction = userView.getTypeOfActions();
        switch (typeOfAction) {
            case "create":
                userView.response(createEntity());
                break;
            case "delete":
                userView.response(deleteEntity());
                break;
            case "show departments":
                userView.response(showDepartments());
                break;
            case "show employees":
                userView.response(showEmployees());
                break;
            case "update":
                userView.response(updateEntity());
                break;
        }
    }

    private ArrayList<String> showEmployees() throws HibernateException {
        return sqlFunction.showEmployees();
    }

    private ArrayList<String> showDepartments() throws HibernateException {
        return sqlFunction.showDepartments();
    }

    private ArrayList<String> createEntity() throws HibernateException {
        Employee employee = new Employee();
        employee.setNameAndFamily(userView.getEmployeeName());
        employee.setPhone(userView.getEmployeePhone());
        employee.setSalary(Double.parseDouble(userView.getEmployeeSalary()));
        return sqlFunction.createDepartment(userView.getDepartmentName(), userView.getDepartmentChief(), employee);
    }

    private ArrayList<String> deleteEntity() throws HibernateException {
        tempName = userView.getDepartmentName();
        if (tempName != null) {
            return sqlFunction.deleteDepartment(tempName);
        } else {
            return sqlFunction.deleteEmployee(tempName);
        }
    }

    private ArrayList<String> updateEntity() throws HibernateException {
        ArrayList<String> outputData = new ArrayList<>();
        tempName = userView.getDepartmentName();
        if (tempName != null) {
            return sqlFunction.updateDepartmentChief(tempName, userView.getDepartmentChief());
        } else {
            outputData.addAll(sqlFunction.updateEmployeePhone(tempName, userView.getEmployeePhone()));
            outputData.addAll(sqlFunction.updateEmployeeSalary(tempName, Double.parseDouble(userView.getEmployeeSalary())));
            outputData.addAll(sqlFunction.updateEmployeeDepartment(tempName, userView.getDepartmentName()));
            return outputData;
        }
    }
}
