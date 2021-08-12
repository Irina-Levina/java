import java.time.LocalDate;
import java.util.List;

public class KataByUser {

    private String id;
    private String name;
    private String slug;
    private List<String> completedLanguages;
    private String completedAt;

    public KataByUser() {
    }

    public KataByUser(String id, String name, String slug, List<String>  completedLanguages, String completedAt) {
        this.id = id;
        this.name = name;
        this.slug = slug;
        this.completedAt = completedAt;
        this.completedLanguages = completedLanguages;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public void setCompletedLanguages(List<String> completedLanguages) {
        this.completedLanguages = completedLanguages;
    }

    public void setCompletedAt(String completedAt) {
        this.completedAt = completedAt;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public List<String>  getCompletedLanguages() {
        return completedLanguages;
    }

    public String getCompletedAt() {
        return completedAt;
    }

    @Override
    public String toString() {
        return "KataByUser{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", completedLanguages=" + completedLanguages +
                ", completedAt='" + completedAt + '\'' +
                '}';
    }
}
