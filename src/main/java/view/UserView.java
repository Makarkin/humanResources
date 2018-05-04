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

    public String getEmployeeDepartmentName() {
        return employeeDepartmentName;
    }

    public String getTypeOfActions() {
        return typeOfActions;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public String getEmployeeSalary() {
        return employeeSalary;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public String getDepartmentChief() {
        return departmentChief;
    }

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