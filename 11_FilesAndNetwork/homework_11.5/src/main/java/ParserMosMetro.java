import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ParserMosMetro {


    public static List<MertoLine> parseMetroline(Document document) {
        Elements lines = document.select("[class^=js-metro-line]");

        List<MertoLine> mertoLines = lines.stream()
                .map(l -> new MertoLine(l.text(), l.attr("data-line")))
                .collect(Collectors.toList());

        addStationAndConnections(document.select("[class^=js-metro-stations]"),mertoLines);

        return mertoLines;
    }


    public static void addStationAndConnections(Elements stations, List<MertoLine> mertoLines) {

        List<MertoLine> mertoLinesWithStations = new ArrayList<>(mertoLines);

        for (Element s : stations) {
            Elements nameStations = s.select("[class=name]");
            for (Element ns : nameStations) {
                MertoLine line = getLine(mertoLinesWithStations, s.attr("data-line"));
                Station station = new Station(ns.text(), line);
                line.addStation(station);
            }
        }
        parseConnections(stations,mertoLines);
    }

    public static void parseConnections(Elements stations, List<MertoLine> mertoLines){

        for (Element s : stations) {
            Elements metroost = s.select("[data-metrost]");
            for (Element ms : metroost) {
                if(ms.children().size() > 2){

                    MertoLine line = getLine(mertoLines, s.attr("data-line"));
                    Station station = getStation(ms.child(1).text(), line,mertoLines);
                    for (int i=2;i<ms.children().size();i++){
                        Station connectionStation = parseStationNameInConnect(ms.child(i),mertoLines);
                        station.setConnection(connectionStation);
                    }
                }
            }
        }

    }

    private static Station parseStationNameInConnect(Element element,List<MertoLine> mertoLines) {
        String line = element.attr("class");
        String stationStr = element.attr("title");
        String ll = line.substring(line.lastIndexOf("-")+1);

        MertoLine line1 = getLine(mertoLines, ll);
        int firstQuot = stationStr.lastIndexOf("«" );
        int lastQuot = stationStr.lastIndexOf("»");

        String stationName = stationStr.substring(firstQuot+1,lastQuot);
        return getStation(stationName,line1,mertoLines);

    }


    private static MertoLine getLine(List<MertoLine> mertoLines, String numberLine) {
        MertoLine line = mertoLines.stream()
                .filter(mertoLine -> mertoLine.getNumber().equals(numberLine))
                .findFirst()
                .get();

        return line;
    }

    private static List<Station> getAllStations(List <MertoLine> linesWithStations){
        List<Station> allStations = linesWithStations.stream()
                .flatMap(line -> line.getStations().stream())
                .collect(Collectors.toList());
        return allStations;
    }

   private static Station getStation(String nameStation, MertoLine line,List<MertoLine> mertoLines) {
        List<Station> allStations = getAllStations(mertoLines);


        Station station = allStations.stream()
                .filter(s -> s.getLine().equals(line))
                .filter(s -> s.getName().equals(nameStation))
                .findAny()
                .get();

        return station;
    }


}
