
import java.util.Random;

public class Manager implements Employee{
    private int managerSalary;

    Manager(){
        managerSalary = generateMonthSalary(70000,100000);
    }



    @Override
    public Double getMonthSalary() {
        Random random = new Random();
        int proceeds ;
        proceeds = random.nextInt(26000) + 115000;

        return this.managerSalary + proceeds*0.05;
    }




}
