import org.hibernate.Session;
import util.HibernateUtil;

/**
 * Created by celenmeh on 15.11.2018
 * 19:55
 */
public class Main {


    public static void main(String [] args){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.close();

    }
}
