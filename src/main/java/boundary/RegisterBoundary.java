package boundary;

import controller.UserController;
import entity.user.USER_ROLE;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Scanner;

/**
 * Created by celenmeh on 16.11.2018
 * 06:41
 */
public class RegisterBoundary {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.close();
       /* System.out.println("Do you want to initialize the database? (Y/N)");
        Scanner scan= new Scanner(System.in);
        if(scan.nextLine().equals("Y")){
            DatabaseManager.resetDatabase();
            DatabaseManager.initializeDatabase();
        }*/
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a username: ");
        String username = scanner.nextLine();
        System.out.println("Enter a password: ");
        String password = scanner.nextLine();
        System.out.println("Choose role");
        System.out.println("1 - ADMIN");
        System.out.println("2 - RECEPTIONIST");
        System.out.println("3 - DOCTOR");
        int choice = new Integer(scanner.nextLine());
        USER_ROLE userRole;
        switch (choice) {
            case 1:
                userRole = USER_ROLE.ROLE_ADMIN;
                break;
            case 2:
                userRole = USER_ROLE.ROLE_RECEPTIONIST;
                break;
            case 3:
                userRole = USER_ROLE.ROLE_DOCTOR;
                break;
            default:
                userRole = null;
                break;
        }

        if (UserController.register(username, password, userRole)) {
            System.out.println("New User has been created you can login.");
            System.exit(1);
        } else {
            System.out.println("An error occured, please try again.");
            System.exit(0);
        }

    }
}
