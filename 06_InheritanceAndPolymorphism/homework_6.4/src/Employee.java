
import java.util.Random;


public interface Employee {

 Double getMonthSalary();



 default int generateMonthSalary(int minSalary, int maxSalary){
     Random random = new Random();
     return random.nextInt(maxSalary-minSalary) + maxSalary;
 }


}
