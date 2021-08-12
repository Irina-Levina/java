import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "LinkedPurchseList")
public class LinkedPurchseList implements Serializable {

    @EmbeddedId
    private LinkedPurchaseKey purchaseKey;


    @Column(name = "student_id",insertable = false,updatable = false)
    private Integer studentId;


    @Column(name = "course_id",insertable = false,updatable = false)
    private Integer courseId;

    @Column(name = "price_cource")
    private Integer price;



    public LinkedPurchseList() {
    }

    public LinkedPurchseList(Student student, Course course) {
        this.purchaseKey = new LinkedPurchaseKey(student.getId(), course.getId());
        this.price = course.getPrice();

    }

    public LinkedPurchaseKey getPurchaseKey() {
        return purchaseKey;
    }

    public void setPurchaseKey(LinkedPurchaseKey purchaseKey) {
        this.purchaseKey = purchaseKey;
    }

    public Integer getStudent_id() {
        return studentId;
    }

    public void setStudent_id(Integer student_id) {
        this.studentId = student_id;
    }

    public Integer getCourse_id() {
        return courseId;
    }

    public void setCourse_id(Integer course_id) {
        this.courseId = course_id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
