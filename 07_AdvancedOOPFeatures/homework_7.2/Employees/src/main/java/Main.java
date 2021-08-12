import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;


public class Main {

    private static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);

        staff.stream()
                .filter((Employee e) -> (e.getWorkStart().getYear() + 1900) == 2017)
                .forEach(System.out::println);
        System.out.println("-------------------------\n");

        Employee employeeMaxSalary = findEmployeeWithHighestSalary(staff, 2017);
        System.out.println(employeeMaxSalary);
    }


    public static Employee findEmployeeWithHighestSalary(List<Employee> staff, int year) {

        var employee = staff.stream()
                .filter((Employee e) -> LocalDate.ofInstant(e.getWorkStart().toInstant(), ZoneId.systemDefault()).getYear() == year)
                .max(Comparator.comparing(Employee::getSalary))
                .get();
        return employee;
    }
}