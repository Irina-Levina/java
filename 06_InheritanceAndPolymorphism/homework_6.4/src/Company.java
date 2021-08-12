import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Company {

    ArrayList<Employee> employees = new ArrayList<>();
    double companyIncome;


    Company(double companyIncome) {
        this.companyIncome = companyIncome;
    }

    public double getCompanyIncome() {
        return companyIncome;
    }


    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(ArrayList<Employee> employeesList) {
        employees.addAll(employeesList);
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public List<Employee> getTopSalaryStaff(int count) {
        if (count > 0 & count <= employees.size()) {
            ArrayList<Employee> topSalaryStaff = new ArrayList<>();

            employees.sort(new EmployeesComparator().reversed());
            for (int i = 0; i < count; i++) {
                topSalaryStaff.add(employees.get(i));
            }
            return topSalaryStaff;
        } else return null;


    }

    public List<Employee> getLowestSalaryStaff(int count) {
        if (count > 0 & count <= employees.size()) {
            ArrayList<Employee> lowestSalaryStaff = new ArrayList<>();

            employees.sort(new EmployeesComparator());
            for (int i = 0; i < count; i++) {
                lowestSalaryStaff.add(employees.get(i));
            }
            return lowestSalaryStaff;
        } else {
            return null;
        }

    }

}

class EmployeesComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.getMonthSalary().compareTo(emp2.getMonthSalary());
    }
}
