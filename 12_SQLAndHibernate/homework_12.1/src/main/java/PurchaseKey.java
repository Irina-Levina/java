import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PurchaseKey implements Serializable {

    @Column(name = "student_name",updatable = false,insertable = false)
    private String studentName;

    @Column(name = "course_name",updatable = false,insertable = false)
    private String courseName;

    public PurchaseKey() {
    }

    public PurchaseKey(String studentName, String courseName) {
        this.studentName = studentName;
        this.courseName = courseName;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PurchaseKey that = (PurchaseKey) o;

        if (!studentName.equals(that.studentName)) return false;
        return courseName.equals(that.courseName);
    }

    @Override
    public int hashCode() {
        int result = studentName.hashCode();
        result = 31 * result + courseName.hashCode();
        return result;
    }
}
