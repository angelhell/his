package boundary;

import controller.ReceptionistController;
import entity.Insurance.PrivateInsurance;
import entity.patient.Patient;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Scanner;

/**
 * Created by celenmeh on 15.11.2018
 * 21:32
 */
@SuppressWarnings("Duplicates")
public class ReceptionistBoundary {
    private static ReceptionistController receptionistController = new ReceptionistController();

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.close();
        Scanner loginScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Username: ");
            String username = loginScanner.nextLine();
            System.out.println("Password: ");
            String password = loginScanner.nextLine();

            if (receptionistController.login(username, password)) {
                break;
            } else {
                System.out.println("Wrong username or password try again!");
            }
        }
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select an option:");
            System.out.println("1. Create New Patient Folder");
            System.out.println("2. List Patients");
            System.out.println("3. Exit");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {

            }
            switch (choice) {
                case 1:
                    System.out.println("Insert Patient Id Code:");
                    String patientId = scanner.nextLine();
                    System.out.println("Insert Patient Name:");
                    String patientName = scanner.nextLine();
                    System.out.println("Insert Patient Surname:");
                    String patientSurname = scanner.nextLine();
                    System.out.println("Insert Patient Birth Date:");
                    String patientBirthdate = scanner.nextLine();
                    System.out.println("Choose Patient Insurance Type: ");
                    System.out.println("1.Private Insurance: ");
                    System.out.println("2. National Insurance: ");
                    String privateInsuranceCode = "";
                    String privateInsuranceCompany = "";
                    int insuranceChoice = 0;
                    try {
                        insuranceChoice = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException ignored) {

                    }
                    switch (insuranceChoice) {
                        case 1:
                            System.out.println("Enter Private Insurance Code : ");
                            privateInsuranceCode = scanner.nextLine();
                            System.out.println("Enter Private Insurance Company : ");
                            privateInsuranceCompany = scanner.nextLine();
                            break;
                        case 2:
                            break;
                    }
                    System.out.println("Insert Patient First Visit: ");
                    String patientFirstVisit = scanner.nextLine();
                    boolean addedNewPatientFolder = receptionistController.openNewPatientFolder(patientId,
                            patientName,
                            patientSurname,
                            patientBirthdate,
                            privateInsuranceCode,
                            privateInsuranceCompany,
                            patientFirstVisit);
                    if (addedNewPatientFolder)
                        System.out.println("New patient has been added and patient folder has been created");
                    break;
                case 2:
                    for (Patient patient : receptionistController.listPatients()) {
                        System.out.println("Patient Name:: " + patient.getName() + "________ Patient ID:: " + patient.getIdCode());
                    }
                    break;
                default:
                    choice = 3;
                    break;
            }
            if (choice == 3)
                System.exit(1);
        }

    }
}
