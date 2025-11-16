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

        //For the admin main
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

            //For the School
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
                inSession = false;
                break;
                default:
                    System.out.println("Invalid input please enter a number between (1-6)\n");
            }
            }

            //For the Company
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
                case 3: assignTaskToInternMenu(mentor);
                break;
                case 4: submitEvalToInternMenu(mentor);
                break;
                case 5: user.displayView();
                break;
                case 6: user.logOut();
                inSession = false;
                break;
                default:
                    System.out.println("Invalid input please enter a number between (1-6)\n");
            }
        }

            //For the Student Intern
            else if(user instanceof StudentIntern){
            System.out.println("1. Log Hours");
            System.out.println("2. Complete Task");
            System.out.println("3. View Timesheet");
            System.out.println("4. View Dashboard");
            System.out.println("5. Logout");

            int choice = getInputInteger("Enter a number(1-5): ");
            switch (choice){
                case 1: logHoursForStudentIntern((StudentIntern) user);
                break;
                case 2: completeTaskMenu((StudentIntern) user);
                break;
                case 3: ((StudentIntern) user).viewTimesheet();;
                break;
                case 4: user.displayView();;
                break;
                case 5: user.logOut();
                inSession = false;
                default:
                    System.out.println("Invalid input please enter a number between 1-5\n");
            }
        }

    }

    //method for the display and the input location in the creation of internship
    private static void createInternshipMenu(){
        System.out.println();
        System.out.println("=============================================");
        System.out.println("Create Internship");
        System.out.println("=============================================");
        System.out.print("Enter Internship ID: ");
        String internID = input.nextLine();
        System.out.print("Enter Company Name: ");
        String companyName = input.nextLine();
        System.out.print("Enter Position: ");
        String position = input.nextLine();

        Internship intern = new Internship(internID, companyName, position);
        internships.add(intern);
        System.out.println("Internship created: " + intern);
    }

    //method for the establishment of partnership to school
    private static void establishPartnerShip(){
        System.out.println();
        System.out.println("=============================================");
        System.out.println("Establish Partnership");
        System.out.println("=============================================");
        System.out.println("1. Company adds Partner School");
        System.out.println("2. School adds Partner Company");

        int choice = getInputInteger("Enter a number(1-2): ");

        if(choice == 1){
            if (company.isEmpty()){
                System.out.println("No company mentors and supervisor available.");
                return;
            }

            System.out.println("\nCompany Mentors/Supervisor:");
            for(int i = 0; i < company.size(); i++){
                System.out.println((i + 1) + "." + company.get(i).getName() + " - " + company.get(i).getCompanyName());
            }
            int companyMentorIndex = getInputInteger("Select a mentor/supervisor: ") - 1;

            if(companyMentorIndex >= 0 && companyMentorIndex < company.size()){
                System.out.print("Enter partner school name: ");
                String schoolName = input.nextLine();
                company.get(companyMentorIndex).addPartnerSchool(schoolName);
            }
        }
        else if (choice == 2){
            if(school.isEmpty()){
                System.out.println("Their is no school coordinators available at the moment.");
                return;
            }

            System.out.println();
            System.out.println("School Coordinators:");
            for(int i = 0; i < school.size(); i++){
                System.out.println((i+1) + ". " + school.get(i).getName() + " - " + school.get(i).getSchoolName());
            }
            int scIndex = getInputInteger("Select a School Coordinator: ") - 1;

            if(scIndex >= 0 && scIndex < school.size()){
                System.out.print("Enter partner company name: ");
                String companyName = input.nextLine();
                school.get(scIndex).addPartnerCompany(companyName);
            }
        }
    }

    //method for the recommendation of internship
    private static void recommendInternshipToSchoolMenu(){
        if(company.isEmpty() || school.isEmpty() || internships.isEmpty()){
            System.out.println("Need company mentors, school coordinators, and internship in this system.");
            return;
        }

        System.out.println();
        System.out.println("=============================================");
        System.out.println("Recommend Internship to School");
        System.out.println("=============================================");
        for(int i = 0; i < company.size(); i++){
            System.out.println((i + 1) + ". " + company.get(i).getName() + " - " + company.get(i).getCompanyName());
        }

        int companyIndex = getInputInteger("Select Mentor: ") - 1;

        if(companyIndex >= 0 && companyIndex < company.size()){
            System.out.println("\nAvailable Internships: ");
            for(int i = 0; i < internships.size(); i++){
                System.out.println((i + 1) + ". " + internships.get(i));
            }

            int internIndex = getInputInteger("Select internship: ") - 1;

            System.out.println();
            System.out.println("School Coordinator: ");
            for(int i = 0; i < school.size(); i++){
                System.out.println((i+1) +". " + school.get(i).getName() + " - " + school.get(i).getSchoolName());
            }

            int scIndex = getInputInteger("Select School: ") - 1;

            if(internIndex >= 0 && internIndex < internships.size() && scIndex >= 0 && scIndex < school.size()){
                company.get(companyIndex).recommendInternshipToSchool(internships.get(internIndex), school.get(scIndex));
            }
        }
    }

    //method for the adding of partner school
    private static void addPartnerSchoolMenu(Company company){
        System.out.print("Enter the partner school's name: ");
        String schoolName = input.nextLine();
        company.addPartnerSchool(schoolName);
    }

    //method for the adding a partner company
    private static void addPartnerCompanyMenu(School school){
        System.out.print("Enter the partner company's name: ");
        String companyName = input.nextLine();
        school.addPartnerCompany(companyName);
    }

    private static void recommendInternshipToSchoolByMentorOrSupervisor(Company company){
        if(internships.isEmpty() || school.isEmpty()){
            System.out.println("Need internships and school coordinators in system.");
            return;
        }

        System.out.println();
        System.out.print("Available Internship: ");
        for(int i = 0 ; i < internships.size(); i++){
            System.out.println((i + 1) + ". " + internships.get(i));
        }
        int internIndex = getInputInteger("Select internship: ") - 1;

        System.out.println();
        System.out.print("School Coordinators: ");
        for(int i = 0; i < school.size(); i++){
            System.out.println((i + 1) + ". " + school.get(i).getName() + " - " + school.get(i).getSchoolName());
        }
        int scIndex = getInputInteger("Select a school: ");

        if(internIndex >= 0 && internIndex < internships.size() && scIndex >= 0 && school.size() > scIndex){
            company.recommendInternshipToSchool(internships.get(internIndex), school.get(scIndex));
        }
    }

    //method for the assigning of task
    private static void assignTaskToInternMenu(){
        if(stInterns.isEmpty()){
            System.out.println("No interns available at the moment.");
            return;
        }

        System.out.println();
        System.out.println("=============================================");
        System.out.println("Assign Task Menu");
        System.out.println("=============================================");
        System.out.print("Enter Task ID: ");
        String taskID = input.nextLine();
        System.out.print("Enter Task Name: ");
        String taskName = input.nextLine();
        System.out.print("Enter Description: ");
        String description = input.nextLine();
        System.out.println("Enter the Deadline/Due Date (YYYY-MM-DD): ");
        String dueDate = input.nextLine();

        Task tasks = new Task(taskID, taskName, description, dueDate);
        task.add(tasks);

        System.out.println();
        System.out.println("Available Interns: ");
        for(int i = 0; i < stInterns.size(); i++){
            System.out.println((i + 1) + ". " + stInterns.get(i).getName() + " (" + stInterns.get(i).getSrCode() + ")" );
        }
        int stInternIndex = getInputInteger("Select intern number: ") - 1;
        if(stInternIndex >= 0 && stInternIndex< stInterns.size()){
            System.out.println("Task assigned successfully!");
        }
        else{
            System.out.println("Invalid input, Please try again.");
        }
    }

    //method for the log hours for the interns
    private static void logHoursForStudentIntern(StudentIntern studentIntern){
        System.out.print("Enter hours worked: ");
        double hours = getInputDouble();
        System.out.print("Enter date (YYYY-MM-DD): ");
        String date = input.nextLine();

        studentIntern.loginData(hours, date);
    }

    private static void submitEvalToInternMenu(){
        if(stInterns.isEmpty() || company.isEmpty()){
            System.out.println("Invalid!! the system need both interns and company mentors.");
            return;
        }

        System.out.println();
        System.out.println("=============================================");
        System.out.println("Submit Evaluation");
        System.out.println("=============================================");
        System.out.println("Student Interns: ");
        for(int i = 0; i < stInterns.size(); i++){
            System.out.println((i + 1) + ". " + stInterns.get(i).getName());
        }

        int stIndex = getInputInteger("Select student intern to evaluate: ") - 1;
        if(stIndex >= 0 && stIndex < stInterns.size()){
            System.out.print("Enter evaluation score (1 \"Highest\"- 5 \"Lowest\"): ");
            double score = getInputDouble();
            System.out.println("Enter feedback: ");
            String feedback = input.nextLine();

            System.out.println("Company Mentors/Supervisor: ");
            for(int i = 0; i < company.size(); i++){
                System.out.println((i + 1) + ". " + company.get(i).getName());
            }
            int companyIndex = getInputInteger("Select evaluator: ") - 1;

            if(companyIndex >= 0 && companyIndex < company.size()){
                String evalID = "EVALUATED ON: " + System.currentTimeMillis();
                Evaluation eval = new Evaluation(evalID, score, feedback, company.get(companyIndex).getName(), stInterns.get(stIndex).getName());
                company.get(companyIndex).submitEvaluation(eval);
                stInterns.get(stIndex).submitEvaluation(eval);
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
