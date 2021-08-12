import com.skillbox.airport.Aircraft;
import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        Airport airport = Airport.getInstance();

        findPlanesLeavingInTheNextTwoHours(airport).forEach(System.out::println);


    }

    public static List<Flight> findPlanesLeavingInTheNextTwoHours(Airport airport) {
        //TODO Метод должден вернуть список рейсов вылетающих в ближайшие два часа.
        List<Terminal> terminals = airport.getTerminals();
        List<Flight> flights = new ArrayList<>();
        for (Terminal t : terminals) {
            List<Flight> flights1 = t.getFlights();
            flights.addAll(flights1);
        }

        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(System.currentTimeMillis());




        return  terminals.stream()
                .flatMap(terminal -> terminal.getFlights().stream())
                .filter(f -> (f.getDate().getHours() - now.get(Calendar.HOUR_OF_DAY) <= 2) & (f.getDate().getHours() - now.get(Calendar.HOUR_OF_DAY) > 0) & (f.getType() == Flight.Type.DEPARTURE))
                //.sorted((f1, f2) -> (int) (f1.getDate().getTime() / 1000000 - f2.getDate().getTime() / 1000000)) не понимаю почему не работает
                .collect(Collectors.toList());


    }
}