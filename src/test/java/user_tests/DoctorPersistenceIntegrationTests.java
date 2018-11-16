package user_tests;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.user.USER_ROLE;
import entity.user.User;
import entity.user.doctor.LevelOfCareer;
import entity.user.doctor.Oncologist;
import entity.user.doctor.Surgeon;
import entity.user.doctor.SurgeonType;
import org.hibernate.Session;
import org.junit.Test;
import util.HibernateUtil;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by celenmeh on 15.11.2018
 * 23:29
 */
public class DoctorPersistenceIntegrationTests {

    @Test
    public void returnOnchologist_whenPersistOnchologist() {

        Oncologist oncologist = new Oncologist();
        oncologist.setName("myName");
        oncologist.setUser_role(USER_ROLE.ROLE_DOCTOR);
        oncologist.setLevelOfCareer(LevelOfCareer.LEVEL_OF_CAREER_SPECIALIST);
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.saveOrUpdate(oncologist);
        session.getTransaction().commit();
        User user = session.get(User.class, oncologist.getId());
        session.close();

        assertEquals(oncologist.getUsername(), user.getUsername());


    }

    @Test
    public void returnSurgeon_whenPersistSurgeon() {
        Surgeon surgeon = new Surgeon();
        surgeon.setName("surgeon");
        surgeon.setSurgeonType(SurgeonType.SURGEON_TYPE_CARDIOTHORACIC);
        surgeon.setPassword("123");
        surgeon.setSurname("surname");
        surgeon.setProfId("654654");
        surgeon.setUser_role(USER_ROLE.ROLE_DOCTOR);
        surgeon.setUsername("username");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.saveOrUpdate(surgeon);
        session.getTransaction().commit();
        User user = session.get(User.class, surgeon.getId());
        session.close();

        assertEquals(surgeon.getUsername(), user.getUsername());

    }

    @Test
    public void whenListSurgeons_thenReturnSurgeonArrayList() {
        UserDao patientDao = new UserDaoImpl();
        ArrayList<Surgeon> surgeonArrayList = patientDao.listSurgeons();
        for (Surgeon surgeon : surgeonArrayList) {
            assertTrue(surgeon instanceof Surgeon);
        }
    }

    @Test
    public void whenListOncologists_thenReturnOncologistArrayList() {
        UserDao patientDao = new UserDaoImpl();
        ArrayList<Oncologist> oncologistArrayList = patientDao.listOncologists();
        for (Oncologist oncologist : oncologistArrayList) {
            System.out.println(oncologist.getUsername());
            assertTrue(oncologist instanceof Oncologist);
        }
    }
}
