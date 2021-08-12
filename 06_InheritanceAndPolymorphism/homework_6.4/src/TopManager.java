

public class TopManager implements Employee {
    private double topManagerSalary;
    private Company company;


    TopManager(Company company) {
        topManagerSalary = generateMonthSalary(100000, 200000);
        this.company = company;

    }

    @Override
    public Double getMonthSalary() {
        if (this.company.getCompanyIncome() > 10000000) {
            return this.topManagerSalary * 1.5;
        } else {
            return this.topManagerSalary;
        }

    }


}
