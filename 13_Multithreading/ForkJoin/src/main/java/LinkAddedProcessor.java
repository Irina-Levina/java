
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;

public class LinkAddedProcessor extends RecursiveTask<Node> {

    private Node node = null;
    private final String url;
    
    public static Set<String> linkList = Collections.newSetFromMap(new ConcurrentHashMap<>());


    public LinkAddedProcessor(String url) {
        this.url = url;
        node = new Node(url);
    }

    @Override
    protected Node compute() {

        Document document = getDocument(url);


        if (document != null) {
            List<LinkAddedProcessor> taskList = new ArrayList<>();

            List<String> links = getlinks(document);
            node.setCildren(links);

            for (String link : links) {
                LinkAddedProcessor task = new LinkAddedProcessor(link);

                task.fork();
                taskList.add(task);
            }

            if (taskList.size() > 0) {
                taskList.forEach(task -> linkList.addAll(task.join()));
            }

        }
        return linkList;
    }


    private Document getDocument(String url) {
        Document document = null;

        try {
            Thread.sleep(150);

            document = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/535.21 (KHTML, like Gecko) Chrome/19.0.1042.0 Safari/535.21")
                    .timeout(10000)
                    .ignoreHttpErrors(true)
                    .get();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return document;
    }

    private List<String> getlinks(Document document) {
        List<String> newLinks = new ArrayList<>();

        Elements elements;
        if (url.equals("https://skillbox.ru/") | url.equals("https://skillbox.ru")) {
            elements = document.select("[abs:href~=https://skillbox.ru/]");
        } else {
            elements = document.select("[abs:href~=https://skillbox.ru/[a-z]+/.]");
        }

        for (Element e : elements) {
            String link = String.valueOf(e.attr("abs:href"));

            if (link.endsWith("/") && !linkList.contains(link)) {
                newLinks.add(link);
            }
        }

        linkList.addAll(newLinks);
        return newLinks;
    }
}

