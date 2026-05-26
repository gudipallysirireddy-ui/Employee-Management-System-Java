import java.io.*;
import java.util.ArrayList;

public class EmployeeManager {

    ArrayList<Employee> employees = new ArrayList<>();

    String fileName = "employees.txt";

    // ADD EMPLOYEE
    public void addEmployee(Employee emp) {

        employees.add(emp);

        saveToFile();

        System.out.println("Employee Added Successfully");
    }

    // VIEW EMPLOYEES
    public void viewEmployees() {

        loadFromFile();

        if (employees.isEmpty()) {

            System.out.println("No Employees Found");
            return;
        }

        System.out.println("\nEmployee Records:");

        for (Employee emp : employees) {

            String[] data = emp.toString().split(",");

            System.out.println(
                    "ID: " + data[0] +
                    " | Name: " + data[1] +
                    " | Department: " + data[2]
            );
        }
    }

    // SEARCH EMPLOYEE
    public void searchEmployee(int id) {

        loadFromFile();

        boolean found = false;

        for (Employee emp : employees) {

            String[] data = emp.toString().split(",");

            if (Integer.parseInt(data[0]) == id) {

                System.out.println(
                        "Employee Found -> " +
                        "Name: " + data[1] +
                        ", Department: " + data[2]
                );

                found = true;
            }
        }

        if (!found) {

            System.out.println("Employee Not Found");
        }
    }

    // DELETE EMPLOYEE
    public void deleteEmployee(int id) {

        loadFromFile();

        boolean removed = employees.removeIf(emp -> {

            String[] data = emp.toString().split(",");

            return Integer.parseInt(data[0]) == id;
        });

        saveToFile();

        if (removed) {

            System.out.println("Employee Deleted");
        } else {

            System.out.println("Employee Not Found");
        }
    }

    // SAVE DATA TO FILE
    public void saveToFile() {

        try {

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(fileName));

            for (Employee emp : employees) {

                writer.write(emp.toString());

                writer.newLine();
            }

            writer.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }

    // LOAD DATA FROM FILE
    public void loadFromFile() {

        employees.clear();

        try {

            File file = new File(fileName);

            if (!file.exists()) {

                return;
            }

            BufferedReader reader =
                    new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                Employee emp = new Employee(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2]
                );

                employees.add(emp);
            }

            reader.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}