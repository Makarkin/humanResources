package view;

import java.util.Scanner;

public class UserView {

    private Scanner scanner = new Scanner(System.in);

    private String employeeName;

    private String employeePhone;

    private String employeeSalary;

    private String employeeDepartmentName;

    private String departmentName;

    private String departmentChief;

    private String typeOfActions;

    /**
     * This is getter for String "employeeDepartmentName" field.
     *@return String "employeeDepartmentName" field.
     */
    public String getEmployeeDepartmentName() {
        return employeeDepartmentName;
    }

    /**
     * This is getter for String "typeOfActions" field.
     *@return String "typeOfActions" field.
     */
    public String getTypeOfActions() {
        return typeOfActions;
    }

    /**
     * This is getter for String "employeeName" field.
     *@return String "employeeName" field.
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * This is getter for String "employeePhone" field.
     *@return String "employeePhone" field.
     */
    public String getEmployeePhone() {
        return employeePhone;
    }

    /**
     * This is getter for String "employeeSalary" field.
     *@return String "employeeSalary" field.
     */
    public String getEmployeeSalary() {
        return employeeSalary;
    }

    /**
     * This is getter for String "departmentName" field.
     *@return String "departmentName" field.
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * This is getter for String "departmentChief" field.
     *@return String "departmentChief" field.
     */
    public String getDepartmentChief() {
        return departmentChief;
    }

    /**
     * This method fills "UserView" class fields.
     */
    public void chooseAction() {
        String chooseString = "Enter the number and choose you actions: \n" + "1: Create employee and his department\n" + "2: Update department or employee\n" + "3: Show department or employee\n" + "4: Delete employee and his department";
        System.out.println(chooseString);
        int number = Integer.parseInt(scanner.nextLine());
        switch (number) {
            case 1:
                createView();
                break;
            case 2:
                updateView();
                break;
            case 3:
                showView();
                break;
            case 4:
                deleteView();
                break;
        }
    }

    private void createView() {
        this.typeOfActions = "create";
        System.out.println("Enter Name of Employee");
        employeeName = scanner.nextLine();
        System.out.println("Enter Phone of Employee");
        employeePhone = scanner.nextLine();
        System.out.println("Enter Salary of Employee");
        employeeSalary = scanner.nextLine();
        System.out.println("Enter Name of Department");
        departmentName = scanner.nextLine();
        System.out.println("Enter Chief of Department");
        departmentChief = scanner.nextLine();
    }

    private void updateView() {
        this.typeOfActions = "update";
        String chooseString = "Enter the type of updated entity: \n" +
                "1: Update employees entity\n" +
                "2: Update departments entity";
        System.out.println(chooseString);
        int number = Integer.parseInt(scanner.nextLine());
        switch (number) {
            case 1:
                System.out.println("Enter the phone of updated employee");
                this.employeePhone = scanner.nextLine();
                System.out.println("Enter the salary of updated employee");
                this.employeeSalary = scanner.nextLine();
                System.out.println("Enter the department name of updated employee");
                this.employeeDepartmentName = scanner.nextLine();
                break;
            case 2:
                System.out.println("Enter the chief of updated department");
                this.departmentChief = scanner.nextLine();
                break;
        }
    }

    private void showView() {
        this.typeOfActions = "show";
        String chooseString = "Enter the number and choose list of fields: \n" +
                "1: List of departments fields\n" +
                "2: List of employees fields";
        System.out.println(chooseString);
        int number = Integer.parseInt(scanner.nextLine());
        switch (number) {
            case 1:
                this.typeOfActions += " departments";
                break;
            case 2:
                this.typeOfActions += " employees";
                break;
        }
    }

    private void deleteView() {
        this.typeOfActions = "delete";
        String chooseString = "Enter the type of deleted entity: \n" +
                "1: Delete departments entity\n" +
                "2: Delete employees entity";
        System.out.println(chooseString);
        int number = Integer.parseInt(scanner.nextLine());
        switch (number) {
            case 1:
                System.out.println("Enter the name of deleted department");
                this.departmentName = scanner.nextLine();
                break;
            case 2:
                System.out.println("Enter the name of deleted employee");
                this.employeeName = scanner.nextLine();
                break;
        }
    }
}