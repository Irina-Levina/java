import core.Station;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class RouteCalculator {
    private final StationIndex stationIndex; //карта метро

    private static final double INTER_STATION_DURATION = 2.5;
    private static final double INTER_CONNECTION_DURATION = 3.5;

    public RouteCalculator(StationIndex stationIndex) {
        this.stationIndex = stationIndex;
    }

    public List<Station> getShortestRoute(Station from, Station to) { // выдать самый короткий путь
        List<Station> route = getRouteOnTheLine(from, to);
        if (route != null) {
            return route;
        }

        route = getRouteWithOneConnection(from, to);
        if (route != null) {
            return route;
        }

        route = getRouteWithTwoConnections(from, to);
        return route;
    }

    public static double calculateDuration(List<Station> route) { //расчитать время в пути
        double duration = 0;
        Station previousStation;

        for (int i = 1; i < route.size(); i++) {
            Station station = route.get(i);
            previousStation = route.get(i - 1);
            duration += previousStation.getLine().equals(station.getLine()) ?
                    INTER_STATION_DURATION : INTER_CONNECTION_DURATION;


        }
        return duration;
    }

    private List<Station> getRouteOnTheLine(Station from, Station to) {
        if (!from.getLine().equals(to.getLine())) {
            return null;
        }
        List<Station> route = new ArrayList<>();
        List<Station> stations = from.getLine().getStations();
        int direction = 0;
        for (Station station : stations) {
            if (direction == 0) {
                if (station.equals(from)) {
                    direction = 1;
                } else if (station.equals(to)) {
                    direction = -1;
                }
            }

            if (direction != 0) {
                route.add(station);
            }

            if ((direction == 1 && station.equals(to)) ||
                    (direction == -1 && station.equals(from))) {
                break;
            }
        }
        if (direction == -1) {
            Collections.reverse(route);
        }
        return route;
    }

    private List<Station> getRouteWithOneConnection(Station from, Station to) { //вычиляет путь с одной пересадкой
        if (from.getLine().equals(to.getLine())) {// если лини равны то вернуть нул
            return null;
        }

        List<Station> route = new ArrayList<>(); // создать маршрут
        List<Station> connectFrom = from.getLine().getConnections();
        List<Station> connectTo = to.getLine().getConnections();

        for (Station frSt : connectFrom) { // для каждой connectionFrom
            for (Station toSt : connectTo) { //для каждой connectionTo
                if (isConnected(frSt, toSt)) {
                    ArrayList<Station> way = new ArrayList<>();  //создаем путь
                    way.addAll(getRouteOnTheLine(from, frSt)); //добавляем в путь все станции до перехода
                    way.addAll(getRouteOnTheLine(toSt, to)); //добавляем все станции после перехода
                    if (route.isEmpty() || route.size() > way.size()) { //если маршрут пустой или станций в маршруте больше чем в Пути
                        route.clear(); // маршрут чистим
                        route.addAll(way); //добавляем Путь
                    }
                }
            }
        }
        if (route.size() == 0) {
            return null;
        }
        return route; //возвращаем значение
    }

    private boolean isConnected(Station station1, Station station2) {  //является ли нужной перестадкой
        Set<Station> connected = stationIndex.getConnectedStations(station1);
        return connected.contains(station2);
    }

    private List<Station> getRouteViaConnectedLine(Station from, Station to) {//путь между двумя пересадками
        Set<Station> fromConnected = stationIndex.getConnectedStations(from);
        Set<Station> toConnected = stationIndex.getConnectedStations(to);
        for (Station srcStation : fromConnected) {
            for (Station dstStation : toConnected) {
                if (srcStation.getLine().equals(dstStation.getLine())) {
                    return getRouteOnTheLine(srcStation, dstStation);
                }
            }
        }
        return null;
    }

    private List<Station> getRouteWithTwoConnections(Station from, Station to) { //с двумя пересадками
        if (from.getLine().equals(to.getLine())) {
            return null;
        }

        ArrayList<Station> route = new ArrayList<>();
        List<Station> fromLineStations = from.getLine().getConnections();
        List<Station> toLineStations = to.getLine().getConnections();

        for (Station srcStation : fromLineStations) {
            for (Station dstStation : toLineStations) {
                List<Station> connectedLineRoute =
                        getRouteViaConnectedLine(srcStation, dstStation);
                if (connectedLineRoute == null) {
                    continue;
                }
                List<Station> way = new ArrayList<>();
                way.addAll(getRouteOnTheLine(from, srcStation));
                way.addAll(connectedLineRoute);
                way.addAll(getRouteOnTheLine(dstStation, to));
                if (route.isEmpty() || route.size() > way.size()) {
                    route.clear();
                    route.addAll(way);
                }
            }
        }

        return route;
    }

    public StationIndex getStationIndex() {
        return stationIndex;
    }
}
