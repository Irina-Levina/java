import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;

public class Main {
    public static final String PATH_IMAGES = "images/";

    public static void main(String[] args) {

        Document doc = null;
        try {
            doc = Jsoup.connect("https://lenta.ru")
                    .data("query", "Java")
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                    .referrer("http://www.google.com")
                    .timeout(1000 * 7)
                    .get();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        Elements media = doc.select("img[src~=.*\\.(jpg|png|svg)]");
        for (Element src : media) {

            try {
                String fileName = getFileName(src.attr("abs:src"));
                saveImage(src.attr("abs:src"), fileName);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getFileName(String url) {
        if (url.isEmpty()) {
            throw new IllegalArgumentException("Url can not be empty");
        }
        String fileName;
        int i = url.lastIndexOf('/');
        if (i > -1) {
            fileName = url.substring(url.lastIndexOf('/') + 1);
            return fileName;
        } else {
            throw new IllegalArgumentException("Url is not valid, url: " + url);
        }
    }

    public static void saveImage(String imageUrl, String destinationFile) throws IOException {
        URL url = new URL(imageUrl);

        try (InputStream is = url.openStream();
             OutputStream os = new FileOutputStream(PATH_IMAGES + destinationFile)) {
            is.transferTo(os);
        }

    }
}
