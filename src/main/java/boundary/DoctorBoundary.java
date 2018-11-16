package boundary;

import controller.DoctorController;
import entity.medicine.Medicine;
import entity.patient.PatientFolder;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by celenmeh on 15.11.2018
 * 21:32
 */
@SuppressWarnings("Duplicates")
public class DoctorBoundary {
    private static DoctorController doctorController = new DoctorController();

    public static void main(String[] args) {
        String username;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.close();
        Scanner loginScanner = new Scanner(System.in);
        while (true) {
            System.out.println("Username: ");
            username = loginScanner.nextLine();
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
            System.out.println("1.Add Outside Tests To Patient Folders");
            System.out.println("2. Add New Medicine");
            System.out.println("3. List Medicines");
            System.out.println("4. Exit");

            int choice = 0;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException ignored) {

            }
            switch (choice) {
                case 1:
                    for (PatientFolder patientFolder : doctorController.listPatientFoldersByOncologist(username)) {
                        System.out.println(":::PATIENT_ID::::___" + patientFolder.getPatient().getIdCode());
                    }
                    System.out.println("Please enter patient id you will work on.");
                    String patientIdToAddTests = scanner.nextLine();
                    System.out.println("Enter Anamnesis Information:");
                    String anamnesisInformation = scanner.nextLine();
                    System.out.println("Enter outside test by catalogue number--- 0 will be exit from loop");
                    int i = 1;
                    ArrayList<String> outsideTests = new ArrayList<String>();
                    while (true) {
                        System.out.println("enter " + i + ". test : ");
                        String testByCatalogue = scanner.nextLine();
                        if (testByCatalogue.equals("0"))
                            break;
                        i++;
                        outsideTests.add(testByCatalogue);
                    }
                    if (doctorController.addTestsAndAnamnesisToPatientFolder(patientIdToAddTests,
                            anamnesisInformation,
                            outsideTests)) {
                        System.out.println("Tests added successfully!");
                        break;
                    } else System.out.println("An error occured when adding tests to patient folder.");
                    break;
                case 2:
                    System.out.println("Insert Medicine Name:");
                    String medicineName = scanner.nextLine();
                    System.out.println("Insert Pharmaceutical Company:");
                    String medicinePharmCompany = scanner.nextLine();
                    boolean addedNewMedicine = DoctorController.addMedicineToCatalogue(medicineName,
                            medicinePharmCompany);
                    if (addedNewMedicine)
                        System.out.println(medicineName + " has been added to the catalogue.");
                    break;
                case 3:
                    for (Medicine medicine : DoctorController.listMedicines()) {
                        System.out.println("Medicine Name:: " + medicine.getName() + "________ Company:: " + medicine.getPharmCompany());
                    }
                    break;
                default:
                    choice = 4;
                    break;
            }
            if (choice == 4)
                System.exit(1);
        }

    }
}
