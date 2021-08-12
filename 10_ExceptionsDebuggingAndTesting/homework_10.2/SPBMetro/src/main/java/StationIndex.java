import core.Line;
import core.Station;

import java.util.*;
import java.util.stream.Collectors;

public class StationIndex {
    private final Map<Integer, Line> number2line; // номер линии - ключ номер
    private final TreeSet<Station> stations; //уникальное множество станций
    private final Map<Station, TreeSet<Station>> connections;// перходы Ключ - Станция


    public StationIndex() {
        number2line = new HashMap<>();
        stations = new TreeSet<>();
        connections = new TreeMap<>();

    }

    public void addStation(Station station) { //добавить станцию
        stations.add(station);
    }

    public void addLine(Line line) {//добавить линию
        number2line.put(line.getNumber(), line);
    }

    public void addConnection(List<Station> stations) { //добавить переход
        for (Station station : stations) {
            if (!connections.containsKey(station)) { // если нет станции в connections keys
                connections.put(station, new TreeSet<>());  // добавить
            }
            TreeSet<Station> connectedStations = connections.get(station);  //по ключу (станция) получаем значения(переходов)
            connectedStations.addAll(stations.stream()
                    .filter(s -> !s.equals(station)).collect(Collectors.toList())); // добавить все станции в коннестедстаейшн из стейшнс
        }
    }

    public Line getLine(int number) { //получить название линии по номеру
        return number2line.get(number);
    }

    public Station getStation(String name) { // получить объект Стейшн по стринг знач
        for (Station station : stations) {
            if (station.getName().equalsIgnoreCase(name)) {
                return station;
            }
        }
        return null;
    }

    public Station getStation(String name, int lineNumber) { //поллучить объект Station по стрингу и номеру линии
        Station query = new Station(name, getLine(lineNumber));
        Station station = stations.ceiling(query);
        return station.equals(query) ? station : null;
    }

    public Set<Station> getConnectedStations(Station station) { // получить переход в конкретной станции
        return connections.containsKey(station) ?
                connections.get(station) : new TreeSet<>();
    }
}
