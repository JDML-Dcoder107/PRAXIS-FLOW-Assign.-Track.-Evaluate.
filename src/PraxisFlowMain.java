import java.util.Scanner;
import java.util.ArrayList;

public class PraxisFlowMain {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<AdminMain> mainAdmin =  new ArrayList<>();
    private static ArrayList<Company> company = new ArrayList<>();
    private static ArrayList<Internship> internships = new ArrayList<>();
    private static ArrayList<School> school = new ArrayList<>();
    private static ArrayList<StudentIntern> stInterns = new ArrayList<>();
    private static ArrayList<Task> task = new ArrayList<>();


    public static void main(String[] args) {
        boolean isItRunning = true;
        System.out.println("=============================================");
        System.out.println("Praxis Flow");
        System.out.println("Assign, Track, Evaluate");
        System.out.println("=============================================");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        System.out.println("=============================================");
        while(isItRunning){
            int choice = getInputInteger("Enter your choice here: ");

            switch(choice){
                case 1: userLoginMenu();
                break;
                case 2: userRegisterMenu();
                break;
                case 3: System.out.println("\nThank you for using Praxis Flow.");
                    isItRunning = false;
                    break;
                default: System.out.println("Invalid input please input a number between 1 - 3. \n");
            }
        }
    }
    public static double getInputDouble (){
        try{
            double value = Double.parseDouble(input.nextLine());
            return value;
        }
        catch(NumberFormatException e){
            System.out.println("Invalid input. Please enter a double number\nNotice the value is now defaulting to 0.0");
            return 0.0;
        }
    }

    //method for the login main menu
    public static void userLoginMenu(){
        System.out.println("=============================================");
        System.out.println("User Login Menu");
        System.out.println("=============================================");
        System.out.print("Enter email: ");
        String email = input.nextLine();
        System.out.println("Enter password: ");
        String password = input.nextLine();

        //Attempting to find the inputted login credentials
        User loggedInUser = findAndLoginUser(email, password);

        if(loggedInUser != null){
            loggedInUser.displayView();
            userRoleMenu(loggedInUser);
        }
        else{
            System.out.println("User not found. Please try again");
        }
    }

    private static User findAndLoginUser(String email, String password) {

        //Check the student intern
        for (StudentIntern stIntern : stInterns) {
            if (stIntern.getEmail().equals(email) && stIntern.login(password)) {
                return stIntern;
            }
        }

        //check the school
        for (School schoolCoordinator : school) {
            if (schoolCoordinator.getEmail().equals(email) && schoolCoordinator.login(password)) {
                return schoolCoordinator;
            }
        }

        //Check the administrator
        for (AdminMain admin : mainAdmin) {
            if (admin.getEmail().equals(email) && admin.login(password)) {
                return admin;
            }
        }

        //Check the company
        for (Company companyMentor : company) {
            if (companyMentor.getEmail().equals(email) && companyMentor.login(password)) {
                return companyMentor;
            }
        }
        return null;
    }

    //method for the user role menu
    private static void userRoleMenu(User user){
        boolean inSession = true;

        if(user instanceof AdminMain) {
            System.out.println("1. Approve Internship");
            System.out.println("2. View Dashboard");
            System.out.println("3. Logout");

            int choice = getInputInteger("Enter choice(1-3): ");
            switch (choice) {
                case 1:
                    approveInternshipMenu((AdminMain));
                    break;
                case 2:
                    user.displayView();
                    break;
                case 3:
                    user.logOut();
                    inSession = false;
                    break;
                default:
                    System.out.println("Invalid input please enter a number between (1-3)\n");
            }
        }

            else if(user instanceof School){
            System.out.println("1. Add Partner Company");
            System.out.println("2. View Internship Recommendation");
            System.out.println("3. Monitor Progress");
            System.out.println("4. Recommend Student");
            System.out.println("5. View Dashboard");
            System.out.println("6. Logout");

            int choice = getInputInteger("Enter your choice(1-6): ");
            School school = (School) user;
            switch(choice){
                case 1: addPartnerCompanyMenu(school);
                break;
                case 2: school.viewInternshipRecommendation();
                break;
                case 3: recommendStudentMenu(school);
                break;
                case 4: monitorProgessMenu(school);
                break;
                case 5: user.displayView();
                break;
                case 6: user.logOut();
                break;
                default:
                    System.out.println("Invalid input please enter a number between (1-6)\n");
            }
            }
            else if(user instanceof Company){
            System.out.println("1. Add Partner School: ");
            System.out.println("2. Recommended Internship to School");
            System.out.println("3. Assign Task");
            System.out.println("4. Submit Evaluation");
            System.out.println("5. View Dashboard");
            System.out.println("6. Logout");

            int choice = getInputInteger("Enter a number(1-6): ");
            Company mentor = (Company) user;
            switch(choice){
                case 1: addPartnerSchoolMenu(mentor);
                break;
                case 2: recommendInternshipToSchoolByMentorOrSupervisor(mentor);
                break;
                case 3:assignTaskToInternMenu(mentor);
                break;
                case 4: submitEvalToInternMenu(mentor);
                break;
                case 5: user.displayView();
                break;
                case 6: user.logOut();
                break;
                default:
                    System.out.println("Invalid input please enter a number between (1-6)\n");
            }
        }


    }

    //method for the students main menu
    private static void studentMainMenu(){
        System.out.println();
        System.out.println("=============================================");
        System.out.println("Student Main Menu");
        System.out.println("=============================================");
        System.out.println("1. Create Internship");
        System.out.println("2. Log Hours");
        System.out.println("=============================================");
    }

    //method for the company main menu
    private static void companyMainMenu(){
        System.out.println();
        System.out.println("=============================================");
        System.out.println("Company Main Menu");
        System.out.println("=============================================");
        System.out.println("1. Recommend Internship to School");
        System.out.println("2. Assign Task to Intern's");
        System.out.println("3. Submit Evaluation");
        System.out.println("4. View all Partnership");
        System.out.println("=============================================");
    }

    //method for the school main menu
    private static void schoolMainMenu(){
        System.out.println();
        System.out.println("=============================================");
        System.out.println("School Main Menu");
        System.out.println("=============================================");
        System.out.println("1. Establish Partnership");
        System.out.println("2. View all Internship");
        System.out.println("=============================================");
    }

    //method for the main admin main menu
    private static void adminMainMenu(){
        System.out.println();
        System.out.println("=============================================");
        System.out.println("Administrator Main Menu");
        System.out.println("=============================================");
        System.out.println("1. View all Intern's");
        System.out.println("2. View all Partnership's");
        System.out.println("=============================================");
    }

    public static int getInputInteger (String integer){
        System.out.println(integer);
        try {
            int value = Integer.parseInt(input.nextLine());
            return value;
        }
        catch(NumberFormatException e){
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        }
    }
}
