import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        Company company = new Company(3000000);

        ArrayList<Employee> topManagers = generateTopManagers(10, company);
        ArrayList<Employee> managers = generateManagers(80);
        ArrayList<Employee> operators = generateOperators(180);

        company.hireAll(topManagers);
        company.hireAll(managers);
        company.hireAll(operators);

        System.out.println("\nТоп 5 самых высоких зарплат компании\n");

        ArrayList<Employee> topSalaryStaff = (ArrayList<Employee>) company.getTopSalaryStaff(5);
        for (Employee employee : topSalaryStaff) {
            System.out.println(employee.getMonthSalary());

        }
        System.out.println("\nТоп 10 самых низких зарплат компании\n");

        ArrayList<Employee> lowestSalaryStaff = (ArrayList<Employee>) company.getLowestSalaryStaff(10);
        for (Employee employee : lowestSalaryStaff) {
            System.out.println(employee.getMonthSalary());

        }

        System.out.println(company.employees.size() + " --- Увольняем 50% сотрудников\n");
        int medium = company.employees.size() / 2;

        for (int i = 0; i < medium; i++) {
            company.fire(company.employees.get(i));
        }

        System.out.println(company.employees.size() + " --- 50% сотрудников\n");


        System.out.println("\nТоп 5 самых высоких зарплат компании\n");


        ArrayList<Employee> topSalaryStaff1 = (ArrayList<Employee>) company.getTopSalaryStaff(5);
        for (Employee employee : topSalaryStaff1) {
            System.out.println(employee.getMonthSalary());

        }
        System.out.println("\nТоп 10 самых низких зарплат компании\n");

        ArrayList<Employee> lowestSalaryStaff1 = (ArrayList<Employee>) company.getLowestSalaryStaff(10);
        for (Employee employee : lowestSalaryStaff1) {
            System.out.println(employee.getMonthSalary());

        }


    }

    public static ArrayList<Employee> generateTopManagers(int count, Company company) {
        ArrayList<Employee> topManagers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            topManagers.add(new TopManager(company));
        }
        return topManagers;
    }

    public static ArrayList<Employee> generateManagers(int count) {
        ArrayList<Employee> managers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            managers.add(new Manager());
        }
        return managers;
    }

    public static ArrayList<Employee> generateOperators(int count) {
        ArrayList<Employee> operators = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            operators.add(new Operator());
        }
        return operators;
    }


}
