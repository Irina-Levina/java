
import core.Line;
import core.Station;
import org.junit.*;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RouteCalculatorTest {

    RouteCalculator routeCalculator = Main.getRouteCalculator();
    StationIndex stationIndex = routeCalculator.getStationIndex();
    Line line1 = new Line(1, "Кировско-Выборгская");
    Line line3 = new Line(3, "Невско-Василеостровская");
    Line line2 = new Line(2, "Московско-Петроградская");
    Line line5 = new Line(5, "Фрунзенско-Приморская");
    List<Station> stationsOfOneLine = new ArrayList<>();
    List<Station> stationsOfTwoLine = new ArrayList<>();
    List<Station> stationsOfThreeLine = new ArrayList<>();


    @Before
    public void setUp() {


        stationsOfOneLine.add(new Station("Лесная", line1));
        stationsOfOneLine.add(new Station("Выборгская", line1));
        stationsOfOneLine.add(new Station("Площадь Ленина", line1));
        stationsOfOneLine.add(new Station("Чернышевская", line1));
        stationsOfOneLine.add(new Station("Площадь Восстания", line1));


        stationsOfTwoLine.addAll(stationsOfOneLine);
        stationsOfTwoLine.add(new Station("Маяковская", line3));
        stationsOfTwoLine.add(new Station("Гостиный двор", line3));
        stationsOfTwoLine.add(new Station("Василеостровская", line3));
        stationsOfTwoLine.add(new Station("Приморская", line3));


        stationsOfThreeLine.add(new Station("Приморская", line3));
        stationsOfThreeLine.add(new Station("Василеостровская", line3));
        stationsOfThreeLine.add(new Station("Гостиный двор", line3));
        stationsOfThreeLine.add(new Station("Невский проспект", line2));
        stationsOfThreeLine.add(new Station("Сенная площадь", line2));
        stationsOfThreeLine.add(new Station("Садовая", line5));
        stationsOfThreeLine.add(new Station("Адмиралтейская", line5));
        stationsOfThreeLine.add(new Station("Спортивная", line5));


    }


    @Test
    public void getShortestRouteInOneLine() {
        Station from = stationIndex.getStation("Лесная");
        Station to = stationIndex.getStation("Площадь Восстания");
        List<Station> actual = routeCalculator.getShortestRoute(from, to);
        assertEquals(stationsOfOneLine, actual);
    }

    @Test
    public void calculateDurationInOneLine() {
        double extend = 10;
        assertEquals(extend, RouteCalculator.calculateDuration(stationsOfOneLine), 0.0);
    }
    @Test
    public void getShortestRouteInTwoLine() {
        Station from = stationIndex.getStation("Лесная");
        Station to = stationIndex.getStation("Приморская");
        List<Station> actual = routeCalculator.getShortestRoute(from, to);
        assertEquals(stationsOfTwoLine, actual);
    }
    @Test
    public void getShortestRouteInThreeLine() {
        Station from = stationIndex.getStation("Приморская");
        Station to = stationIndex.getStation("Спортивная");
        List<Station> actual = routeCalculator.getShortestRoute(from, to);
        assertEquals(stationsOfThreeLine, actual);
    }


    @Test
    public void calculateDurationInTwoLine() {
        double extend = 21;
        assertEquals(extend, RouteCalculator.calculateDuration(stationsOfTwoLine), 0.0);

    }
    @Test
    public void calculateDurationInThreeLine() {
        double extend = 19.5;
        assertEquals(extend, RouteCalculator.calculateDuration(stationsOfThreeLine), 0.0);

    }
}