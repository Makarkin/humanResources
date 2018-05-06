package controller;

import model.Employee;
import model.SQLFunction;
import view.UserView;

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
                createEntity();
                break;
            case "delete":
                deleteEntity();
                break;
            case "show departments":
                sqlFunction.listDepartments();
                break;
            case "show employees":
                sqlFunction.listEmployees();
                break;
            case "update":
                updateEntity();
                break;
        }
    }

    private void createEntity() {
        Employee employee = new Employee();
        employee.setNameAndFamily(userView.getEmployeeName());
        employee.setPhone(userView.getEmployeePhone());
        employee.setSalary(Double.parseDouble(userView.getEmployeeSalary()));
        sqlFunction.createDepartment(userView.getDepartmentName(), userView.getDepartmentChief(), employee);
    }

    private void deleteEntity() {
        tempName = userView.getDepartmentName();
        if (tempName != null) {
            sqlFunction.deleteDepartment(tempName);
        } else {
            sqlFunction.deleteEmployee(tempName);
        }
    }

    private void updateEntity() {
        tempName = userView.getDepartmentName();
        if (tempName != null) {
            sqlFunction.updateDepartmentChief(tempName, userView.getDepartmentChief());
        } else {
            sqlFunction.updateEmployeePhone(tempName, userView.getEmployeePhone());
            sqlFunction.updateEmployeeSalary(tempName, Double.parseDouble(userView.getEmployeeSalary()));
            sqlFunction.updateEmployeeDepartment(tempName, userView.getDepartmentName());
        }
    }
}
