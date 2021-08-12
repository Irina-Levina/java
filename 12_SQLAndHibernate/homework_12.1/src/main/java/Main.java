import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.NativeQuery;

import java.util.List;


public class Main {
    public static void main(String[] args) {


        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();

        try (SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
             Session session = sessionFactory.openSession()) {

            String sql = "insert into linkedpurchselist(`student_id`, `course_id`,`price_cource`)\n" +
                    "select students.id,courses.id,courses.price\n" +
                    " from courses \n" +
                    " join purchaselist on courses.name = course_name\n" +
                    " join students on students.name = student_name;";

            session.beginTransaction();
            int str = session.createNativeQuery(sql).executeUpdate();
            System.out.println(str);
            session.getTransaction().commit();

            session.close();

        }
    }
}

