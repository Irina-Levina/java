import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;

public class Main {

    public static void main(String[] args) {
        Airport airport = Airport.getInstance();
        System.out.println(airport.getAllAircrafts());

        System.out.println(airport.getAllAircrafts().size());

        System.out.println(airport.getTerminals());

        Aircraft aircraft = new Aircraft("Boeing 777-220");
        System.out.println(aircraft.getModel());


    }
}
