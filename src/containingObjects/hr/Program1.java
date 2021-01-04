package containingObjects.hr;

import java.util.Scanner;

public class Program1 {
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        final int EXIT = -1;

        //int maxEmployees, maxDepartments;

        System.out.print("Enter maximum employees --> ");
        int maxEmployees = s.nextInt();

        System.out.print("Enter maximum departments --> ");
        int maxDepartments = s.nextInt();

        HR theHR = new HR(maxEmployees, maxDepartments);

        int answer;
        do {
            System.out.println();
            System.out.println("Choose one of the following options:");
            System.out.println("1)  Add departments");
            System.out.println("2)  Add employees");
            System.out.println("3)  Show all data");
            System.out.println("4)  Change employee name");
            System.out.println(EXIT + ") to exit");
            System.out.println("Enter your choice --> ");
            answer = s.nextInt();
            s.nextLine();

            switch (answer) {
                case 1:
                    readDepartments(theHR);
                    break;
                case 2:
                    readEmployees(theHR);
                    break;
                case 3:
                    System.out.println(theHR.toString());
                    break;
                case 4:
                    changeEmployeeName(theHR);
                    break;
                case EXIT:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        } while (answer != EXIT);
    } // main

    public static void readDepartments(HR theHR) {
        boolean fContinue = true;

        do {
            String departmentName;
            int maxEmployees;

            System.out.println("Enter the name of the department: ");
            departmentName = s.nextLine();

            System.out.println("Enter max employees: ");
            maxEmployees = s.nextInt();

            boolean res = theHR.addDepartment(departmentName, maxEmployees);
            if (res) {
                System.out.println("\nAdd another department? (Y/N) ");
                char answer = s.next().charAt(0);
                s.nextLine();

                if (answer == 'n' || answer == 'N') {
                    fContinue = false;
                } else if (answer != 'y' && answer != 'Y') {
                    System.out.println("Invalid answer..");
                }
                // else: answer is 'y'/'Y'
            } else {
                System.out.println("Can not add any more departments");
                fContinue = false;
            }
        } while (fContinue);
    }

    public static void readEmployees(HR theHR) {
        boolean fContinue = true;
        do {
            String employeeName, employeePhone, departmentName;

            System.out.println("Enter employee's name: ");
            employeeName = s.nextLine();

            System.out.println("Enter employee's phone: ");
            employeePhone = s.next();

            System.out.println("Enter the employee's department: ");
            s.nextLine();
            departmentName = s.nextLine();

            boolean res = theHR.addEmployee(new Employee(employeeName, employeePhone), departmentName);

            if (res) {
                System.out.println("\nAdd another employee? (Y/N) ");
                char answer = s.next().charAt(0);
                s.nextLine();

                if (answer == 'n' || answer == 'N') {
                    fContinue = false;
                } else if (answer != 'y' && answer != 'Y') {
                    System.out.println("Invalid answer..");
                }
                // else: answer is 'y'/'Y'
            } else {
                System.out.println("Failed adding the employee " + "(full capacity or department doesn't exist");
                fContinue = false;
            }
        } while (fContinue);
    }

    public static void changeEmployeeName(HR theHR) {
        String name, newName;

        System.out.print("Enter name of employee to change: ");
        name = s.nextLine();

        Employee theEmployee = theHR.getEmployeeByName(name);
        if (theEmployee == null) {
            System.out.println("There is no employee with that name");
            return;
        }

        System.out.print("Enter new name: ");
        newName = s.nextLine();
        theEmployee.setName(newName);

        System.out.println("Name change succeed");
    }
}
