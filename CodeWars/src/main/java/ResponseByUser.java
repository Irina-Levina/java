import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseByUser {
    private int totalPages;
    private  int totalItems;
    @SerializedName("data")
    List<KataByUser> kataByUsers;

    public ResponseByUser() {
    }

    public ResponseByUser(int totalPages, int totalItems, List<KataByUser> kataByUsers) {
        this.totalPages = totalPages;
        this.totalItems = totalItems;
        this.kataByUsers = kataByUsers;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public List<KataByUser> getKatasByUser() {
        return kataByUsers;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public void setKataUsers(List<KataByUser> kataByUsers) {
        this.kataByUsers = kataByUsers;
    }
}
