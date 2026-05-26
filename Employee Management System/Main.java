import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        EmployeeManager manager =
                new EmployeeManager();

        while (true) {

            System.out.println("\n===== Employee Management System =====");

            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Search Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();

                    Employee emp =
                            new Employee(id, name, dept);

                    manager.addEmployee(emp);

                    break;

                case 2:

                    manager.viewEmployees();

                    break;

                case 3:

                    System.out.print("Enter Employee ID: ");

                    int searchId = sc.nextInt();

                    manager.searchEmployee(searchId);

                    break;

                case 4:

                    System.out.print("Enter Employee ID to Delete: ");

                    int deleteId = sc.nextInt();

                    manager.deleteEmployee(deleteId);

                    break;

                case 5:

                    System.out.println("Exiting Program");
                    

                      sc.close();

 

                    return;

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}