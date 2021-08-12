import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class KataUserDeserializer implements JsonDeserializer<KataByUser> {

    @Override
    public KataByUser deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        KataByUser kataByUser = new KataByUser();
        kataByUser.setId(jsonObject.get("id").getAsString());

        if (jsonObject.get("name") == null) {
            kataByUser.setName("");
        } else {
            kataByUser.setName(jsonObject.get("name").getAsString());
        }

        if (jsonObject.get("slug") == null) {
            kataByUser.setSlug("");
        } else {
            kataByUser.setSlug(jsonObject.get("slug").getAsString());
        }


        JsonArray jsonArray = jsonObject.getAsJsonArray("completedLanguages");
        List<String> languages = new ArrayList<>();
        for (JsonElement e : jsonArray) {
            languages.add(e.getAsString());
        }
        kataByUser.setCompletedLanguages(languages);

        kataByUser.setCompletedAt(jsonObject.get("completedAt").getAsString());

        return kataByUser;
    }
}
