
public class Operator implements Employee {
    private double operatorSalary;

    Operator() {
        operatorSalary = generateMonthSalary(40000, 60000);
    }

    @Override
    public Double getMonthSalary() {
        return operatorSalary;
    }


}
