import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeService {

    private ArrayList<Employee> employees = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    // Add Employee
    public void addEmployee() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String department = sc.nextLine();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();

        Employee emp = new Employee(id, name, department, salary);
        employees.add(emp);

        System.out.println("Employee added successfully!");
    }

    // View All Employees
    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee emp : employees) {
            System.out.println(emp.display());
        }
    }

    // Search Employee by ID
    public void searchEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println(emp.display());
                return;
            }
        }

        System.out.println("Employee not found.");
    }

    // Delete Employee
    public void deleteEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        employees.removeIf(emp -> emp.getId() == id);

        System.out.println("Employee deleted (if existed).");
    }

    // Update Employee
    public void updateEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Employee emp : employees) {
            if (emp.getId() == id) {

                System.out.print("Enter new name: ");
                emp.setName(sc.nextLine());

                System.out.print("Enter new department: ");
                emp.setDepartment(sc.nextLine());

                System.out.print("Enter new salary: ");
                emp.setSalary(sc.nextDouble());

                System.out.println("Employee updated successfully!");
                return;
            }
        }

        System.out.println("Employee not found.");
    }
}