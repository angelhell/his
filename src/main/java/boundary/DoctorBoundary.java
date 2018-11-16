package boundary;

import controller.DoctorController;
import controller.UserController;
import entity.medicine.Medicine;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.Scanner;

/**
 * Created by celenmeh on 15.11.2018
 * 21:32
 */
@SuppressWarnings("Duplicates")
public class DoctorBoundary {
    private static DoctorController doctorController = new DoctorController();

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

            if (doctorController.login(username, password)) {
                break;
            } else {
                System.out.println("Wrong username or password try again!");
            }
        }
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Select an option:");
            System.out.println("1. Add New Medicine");
            System.out.println("2. List Medicines");
            System.out.println("3. Exit");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {

            }
            switch (choice) {
                case 1:
                    System.out.println("Insert Medicine Name:");
                    String medicineName = scanner.nextLine();
                    System.out.println("Insert Pharmaceutical Company:");
                    String medicinePharmCompany = scanner.nextLine();
                    boolean addedNewMedicine = DoctorController.addMedicineToCatalogue(medicineName,
                            medicinePharmCompany);
                    if (addedNewMedicine)
                        System.out.println(medicineName + " has been added to the catalogue.");
                    break;
                case 2:
                    for(Medicine medicine : DoctorController.listMedicines()){
                        System.out.println("Medicine Name:: " +medicine.getName() + "________ Company:: " + medicine.getPharmCompany());
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
