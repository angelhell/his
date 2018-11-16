package boundary;

import controller.AdminController;
import entity.user.doctor.LevelOfCareer;
import entity.user.doctor.OncologistType;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Scanner;

/**
 * Created by celenmeh on 15.11.2018
 * 21:32
 */

//TODO: add new surgeon is ready to implement && list surgeons and list oncologist are ready to implement &&delete patient folder
@SuppressWarnings("Duplicates")
public class AdminBoundary {
    private static AdminController adminController = new AdminController();

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
        Scanner loginScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Username: ");
            String username = loginScanner.nextLine();
            System.out.println("Password: ");
            String password = loginScanner.nextLine();

            if (adminController.login(username, password)) {
                break;
            } else {
                System.out.println("Wrong username or password try again!");
            }
        }

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select an option:");
            System.out.println("1. Add New Oncologist");
            System.out.println("2. Add New Surgeon");
            System.out.println("3. List Surgeons");
            System.out.println("4. List Oncologists");
            System.out.println("5. Exit");
            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {

            }

            switch (choice) {
                case 1:
                    System.out.println("Insert Oncologist Name:");
                    String oncologistName = scanner.nextLine();
                    System.out.println("Insert Oncologist Surname:");
                    String oncologistSurname = scanner.nextLine();
                    System.out.println("Insert Oncologist username:");
                    String oncologistUsername = scanner.nextLine();
                    System.out.println("Insert Oncologist password:");
                    String oncologistPassword = scanner.nextLine();
                    System.out.println("Insert Oncologist profId:");
                    String oncologistProfId = scanner.nextLine();
                    System.out.println("Insert Oncologist Type - Press Number Keys :");
                    OncologistType oncologistType;
                    System.out.println("1 - MEDICAL");
                    System.out.println("2 - RADIATION"); //There is more types but...
                    int choiceOfOncologistType = scanner.nextInt();
                    switch (choiceOfOncologistType) {
                        case 1:
                            oncologistType = OncologistType.DOCTOR_TYPE_MEDICAL;
                            break;
                        case 2:
                            oncologistType = OncologistType.DOCTOR_TYPE_RADIATION;
                            break;
                        default:
                            oncologistType = null;
                            break;
                    }
                    System.out.println("Insert Level Of career - Press Number Keys :");
                    LevelOfCareer oncologistLevelOfCareer;
                    System.out.println("1 - SPECIALIST");
                    System.out.println("2 - PHYSICIAN"); //There is more types but...
                    int choiceOfOncologistLevelOfCareer = scanner.nextInt();
                    switch (choiceOfOncologistLevelOfCareer) {
                        case 1:
                            oncologistLevelOfCareer = LevelOfCareer.LEVEL_OF_CAREER_SPECIALIST;
                            break;
                        case 2:
                            oncologistLevelOfCareer = LevelOfCareer.LEVEL_OF_CAREER_PHYSICIAN;
                            break;
                        default:
                            oncologistLevelOfCareer = null;
                            break;
                    }
                    if (AdminController.addNewOncologist(oncologistUsername,
                            oncologistPassword,
                            oncologistName,
                            oncologistSurname,
                            oncologistProfId,
                            oncologistType,
                            oncologistLevelOfCareer)) {
                        System.out.println("New Oncologist has been added!");
                    }
                    break;
                default:
                    choice = 5;
                    break;
            }
            if (choice == 5)
                System.exit(1);
        }
    }
}
