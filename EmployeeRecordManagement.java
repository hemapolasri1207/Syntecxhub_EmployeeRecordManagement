
import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeRecordManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Employee> empList = new ArrayList<>();
        Set<Integer> empIds = new HashSet<>();
        Map<Integer, Employee> empMap = new HashMap<>();

        int choice;

        do {
        	 System.out.print("Enter your choice: \n");
            System.out.println("\n1.Add \n 2.Update \n 3.Delete \n 4.Display \n 5.Exit");
            choice = sc.nextInt();

            switch (choice) {

                case 1: // Add
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    if (empIds.contains(id)) {
                        System.out.println("ID already exists!");
                        break;
                    }

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    Employee e = new Employee(id, name, salary);
                    empList.add(e);
                    empIds.add(id);
                    empMap.put(id, e);

                    System.out.println("Employee Added!");
                    break;

                case 2: // Update
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    sc.nextLine();

                    if (empMap.containsKey(uid)) {
                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Salary: ");
                        double newSalary = sc.nextDouble();

                        Employee emp = empMap.get(uid);
                        emp.name = newName;
                        emp.salary = newSalary;

                        System.out.println("Updated!");
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;

                case 3: // Delete
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();

                    if (empMap.containsKey(did)) {
                        Employee emp = empMap.get(did);
                        empList.remove(emp);
                        empIds.remove(did);
                        empMap.remove(did);

                        System.out.println("Deleted!");
                    } else {
                        System.out.println("Employee not found!");
                    }
                    break;

                case 4: // Display
                    System.out.println("Employee List:");
                    for (Employee emp : empList) {
                        System.out.println(emp);
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}