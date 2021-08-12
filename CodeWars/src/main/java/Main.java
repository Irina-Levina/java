import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final Gson GSON = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(KataByUser.class,new KataUserDeserializer())
            .create();

    public static void main(String[] args) {

        String resp = getDocument("http://www.codewars.com/api/v1/users/nklein/code-challenges/completed?page=0&access_key=4okdeUCSuvfPs6W9vqr5");

        ResponseByUser response = GSON.fromJson(resp, ResponseByUser.class);

        List<KataByUser> kataByUsers = response.getKatasByUser();
        kataByUsers.forEach(System.out::println);

    }


    public static String getDocument(String url) {
        Connection.Response response = null;

        try {

            response = Jsoup
                    .connect(url)
                    .ignoreContentType(true)
                    .method(Connection.Method.GET)
                    .execute();


        } catch (IOException ioException) {
            ioException.printStackTrace();
        }


        return response.body();
    }

}
