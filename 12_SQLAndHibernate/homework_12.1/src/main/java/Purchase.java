import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "PurchaseList")
public class Purchase implements Serializable {

    @EmbeddedId
    private PurchaseKey purchaseKey;

    @Column(name = "student_name", updatable = false, insertable = false)
    private String studentName;


    @Column(name = "course_name",updatable = false, insertable = false)
    private String courseName;

    @Column(name = "price")
    private Integer price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;


    public String getStudent() {
        return studentName;
    }

    public void setStudent(String studentName) {
        this.studentName = studentName;
    }

    public String getCourse() {
        return courseName;
    }

    public void setCourse(String course) {
        this.courseName = course;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
