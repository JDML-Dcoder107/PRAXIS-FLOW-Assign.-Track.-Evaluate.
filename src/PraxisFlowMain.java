import java.util.Scanner;
import java.util.ArrayList;

public class PraxisFlowMain {
    private static final Scanner input = new Scanner(System.in);
    private static final ArrayList<AdminMain> mainAdmin =  new ArrayList<>();
    private static final ArrayList<Company> company = new ArrayList<>();
    private static final ArrayList<Internship> internships = new ArrayList<>();
    private static final ArrayList<School> school = new ArrayList<>();
    private static final ArrayList<StudentIntern> stInterns = new ArrayList<>();
    private static final ArrayList<Task> task = new ArrayList<>();
    private static final String studentRegex = "^\\d{2}-\\d{5}@g\\.batstate-u\\.edu\\.ph$";
    private static final String companyRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(com|org|net|co\\.[a-z]{2,})$";
    private static final String schoolRegex = "^[a-zA-Z][a-zA-Z0-9._-]*@g\\.batstate-u\\.edu\\.ph$";
    private static final String adminRegex = "^admin[a-zA-Z0-9._%+-]*@[a-zA-Z0-9.-]+\\.[a-z]{2,}$";
    private static final String yearMothsDayRegex = "^(?:(?:19|20)\\d\\d)-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12]\\d|3[01])$\n";

    public static void main(String[] args) {
        boolean isItRunning = true;
        System.out.println("=============================================");
        System.out.println("Praxis Flow");
        System.out.println("Assign, Track, Evaluate");
        System.out.println("=============================================");

        while(isItRunning){
            mainMenu();
            int choice = getInputInteger("Enter your choice here: ");
            switch(choice){
                case 1: userLoginMenu();
                break;
                case 2: userRegisterMenu();
                break;
                case 3:
                    System.out.println();
                    System.out.println("Thank you for using the Praxis Flow System!");
                    isItRunning = false;
                    break;
                default: System.out.println("Invalid input please input a number between 1 - 3. \n");
            }
        }
        input.close();
    }

    //method for the input of double value
    private static double getInputDouble (){
        try{
            double value = Double.parseDouble(input.nextLine());
            return value;
        }
        catch(NumberFormatException e){
            System.out.println("Invalid input. Please enter a double number\nNotice the value is now defaulting to 0.0");
            return 0.0;
        }
    }

    //method for the registration for new user
    private static void userRegisterMenu(){
        System.out.println("=============================================");
        System.out.println("Register Menu");
        System.out.println("=============================================");

        System.out.print("Enter User ID: ");
        String userID = input.nextLine();
        System.out.print("Enter your name: ");
        String name = input.nextLine();
        System.out.print("Enter Email: ");
        String email = input.nextLine();


        if(email.matches(studentRegex)){
            System.out.print("Enter Password: ");
            String password = input.nextLine();
            System.out.print("Confirm Password: ");
            String confirmPassword = input.nextLine();
            if(password.equals(confirmPassword)){
                System.out.print("Enter SrCode: ");
                String srCode = input.nextLine();
                System.out.print("Enter School: ");
                String schoolName = input.nextLine();
                stInterns.add(new StudentIntern(userID, name, email, password, srCode, schoolName));
                System.out.println("Student Intern Registration Complete!");
            }
            else{
                System.out.println("Password do not match to each other. Try again");
            }
        }
        else if(email.matches(schoolRegex)){
            System.out.print("Enter Password: ");
            String password = input.nextLine();
            System.out.print("Confirm Password: ");
            String confirmPassword = input.nextLine();
            if(password.equals(confirmPassword)) {
                System.out.print("Enter School: ");
                String schoolName = input.nextLine();
                school.add(new School(userID, name, email, password, schoolName));
                System.out.println("School Coordinator Registration Complete!");
            }
            else{
                System.out.println("Password do not match to each other. Try again");
            }
        }
        else if(email.matches(companyRegex)){
            System.out.print("Enter Password: ");
            String password = input.nextLine();
            System.out.print("Confirm Password: ");
            String confirmPassword = input.nextLine();
            if(password.equals(confirmPassword)){
                System.out.print("Enter Company: ");
                String companyName = input.nextLine();
                company.add(new Company(userID, name, email, password, companyName));
                System.out.println("Company Mentor/Supervisor Registration Complete!");
            }
            else{
                System.out.println("Password do not match to each other. Try again");
            }
        }
        else if(email.matches(adminRegex)){
            System.out.print("Enter Password: ");
            String password = input.nextLine();
            System.out.print("Confirm Password: ");
            String confirmPassword = input.nextLine();
            if(password.equals(confirmPassword)){
                mainAdmin.add(new AdminMain(userID, name, email, password));
                System.out.println("Administrator Registration Complete!");
            }
            else{
                System.out.println("Password do not match to each other. Try again");
            }
        }
        else{
            System.out.println("No valid role matches your email.");
        }


    }
    //method for the login main menu
    private static void userLoginMenu(){
        System.out.println("=============================================");
        System.out.println("User Login Menu");
        System.out.println("=============================================");
        System.out.print("Enter email: ");
        String email = input.nextLine();
        System.out.print("Enter password: ");
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
    private static void userRoleMenu(User user) {
        boolean inSession = true;

        while (inSession) {
            //For the admin main
            if (user instanceof AdminMain) {
                System.out.println("1. Approve Internship");
                System.out.println("2. View Dashboard");
                System.out.println("3. View All Internships");
                System.out.println("4. View All Partnerships");
                System.out.println("5. View All User");
                System.out.println("6. Logout");

                int choice = getInputInteger("Enter choice(1-6): ");
                switch (choice) {
                    case 1: approveInternshipMenu((AdminMain) user);
                        break;
                    case 2: user.displayView();
                        break;
                    case 3: viewALlInternships();
                        break;
                    case 4: viewPartnershipsMenu();
                        break;
                    case 5: viewAllUser();
                        break;
                    case 6:
                        user.logOut();
                        inSession = false;
                        break;
                    default:
                        System.out.println("Invalid input please enter a number between (1-6)\n");

                }
            }

            //For the School
            else if (user instanceof School schoolCoordinator) {
                System.out.println("1. Add Partner Company");
                System.out.println("2. View Internship Recommendation");
                System.out.println("3. Monitor Progress");
                System.out.println("4. Recommend Student");
                System.out.println("5. View Dashboard");
                System.out.println("6. Established Partnership");
                System.out.println("7. Logout");

                int choice = getInputInteger("Enter your choice(1-7): ");
                switch (choice) {
                    case 1:
                        addPartnerCompanyMenu(schoolCoordinator);
                        break;
                    case 2:
                        schoolCoordinator.viewInternshipRecommendation();
                        break;
                    case 3:
                        monitorProgressMenu(schoolCoordinator);
                        break;
                    case 4:
                        recommendStudentMenu(schoolCoordinator);
                        break;
                    case 5:
                        user.displayView();
                        break;
                    case 6: establishPartnershipS();
                        break;
                    case 7:
                        user.logOut();
                        inSession = false;
                        break;
                    default:
                        System.out.println("Invalid input please enter a number between (1-7)\n");
                }
            }

            //For the Company
            else if (user instanceof Company mentor) {
                System.out.println("1. Add Partner School: ");
                System.out.println("2. Recommended Internship to School");
                System.out.println("3. Assign Task");
                System.out.println("4. Submit Evaluation");
                System.out.println("5. View Dashboard");
                System.out.println("6. Establish ");
                System.out.println("7. Logout");

                int choice = getInputInteger("Enter a number(1-7): ");
                switch (choice) {
                    case 1:
                        addPartnerSchoolMenu(mentor);
                        break;
                    case 2:
                        recommendInternshipToSchoolMenu();
                        break;
                    case 3:
                        assignTaskToInternMenu();
                        break;
                    case 4:
                        submitEvalToInternMenu();
                        break;
                    case 5:
                        user.displayView();
                        break;
                    case 6: establishPartnerShipC();
                        break;
                    case 7:
                        user.logOut();
                        inSession = false;
                        break;
                    default:
                        System.out.println("Invalid input please enter a number between (1-7)\n");
                }
            }

            //For the Student Intern
            else if (user instanceof StudentIntern) {
                System.out.println("1. Log Hours");
                System.out.println("2. Complete Task");
                System.out.println("3. View Timesheet");
                System.out.println("4. View Dashboard");
                System.out.println("5. Create Internship");
                System.out.println("6. View Evaluation");
                System.out.println("7. Logout");

                int choice = getInputInteger("Enter a number(1-6): ");
                switch (choice) {
                    case 1:
                        logHoursForStudentIntern((StudentIntern) user);
                        break;
                    case 2:
                        completeTaskMenu((StudentIntern) user);
                        break;
                    case 3:
                        ((StudentIntern) user).viewTimesheet();
                        break;
                    case 4:
                        user.displayView();
                        break;
                    case 5: createInternshipMenu();
                        break;
                    case 6: ((StudentIntern)user).viewEvaluationScore();
                        break;
                    case 7:
                        user.logOut();
                        inSession = false;
                    default:
                        System.out.println("Invalid input please enter a number between 1-6\n");
                }
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
    private static void establishPartnerShipC(){
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

    //method for the establishment of partnership to company
    private static void establishPartnershipS(){
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
        if(date.matches(yearMothsDayRegex)) {
            studentIntern.loginData(hours, date);
        }
        else{
            System.out.println("Invalid input or improper format has been occurred.");
        }
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

    //method for the approval of internship
    private static void approveInternshipMenu(AdminMain admin){
        if(internships.isEmpty()){
            System.out.println("No internships to approve.");
            return;
        }

        System.out.println();
        System.out.println("Pending Internships:");
        for (int i = 0; i < internships.size(); i++){
            System.out.println((i + 1) + ". " + internships.get(i));
        }

        int index = getInputInteger("Select internship to approve: ");
        if (index >= 0 && index < internships.size()){
            admin.approveInternship(internships.get(index));
        }
    }

    //method for the recommendation to student
    private static void recommendStudentMenu(School school){
        if(stInterns.isEmpty() || internships.isEmpty()){
            System.out.println("Student Intern's and Internships are both required in this system.");
            return;
        }

        System.out.println();
        System.out.println("Student Interns:");
        for(int i = 0; i <  stInterns.size(); i++){
            System.out.println((i + 1) + ". " + stInterns.get(i).getName());
        }
        int internIndex = getInputInteger("Select Intern: ");

        System.out.println();
        System.out.println("Internships:");
        for (int i = 0; i < internships.size(); i++){
            System.out.println((i + 1) + ". " + internships.get(i));
        }

        int internshipIndex = getInputInteger("Select internship: ") - 1;

        if(internIndex >= 0 && internIndex < stInterns.size() && internshipIndex >= 0 && internshipIndex < internships.size()){
            school.recommendStudent(stInterns.get(internIndex), internships.get(internshipIndex));
        }
    }

    //method for the progress view
    private static void monitorProgressMenu(School school){
        if(stInterns.isEmpty()){
            System.out.println("No interns to monitor to be found.");
            return;
        }

        System.out.println();
        System.out.println("Student Intern: ");
        for(int i = 0; i < stInterns.size(); i++){
            System.out.println((i + 1) + ". " + stInterns.get(i).getName());
        }
        int index = getInputInteger("Select Student Intern: ");

        if(index >= 0 && index < stInterns.size()){
            school.monitorProcess(stInterns.get(index));
        }
    }

    //method for the assign task to intern
    private static void completeTaskMenu(StudentIntern studentIntern){
       if(task.isEmpty()){
           System.out.println("No task available at the moment.");
           return;
       }

        System.out.println();
        System.out.println("Task: ");
        for(int i = 0; i < task.size(); i++) {
            System.out.println((i + 1) + ". " + task.get(i));
        }

        int index = getInputInteger("Select task to complete: ") - 1;

        if (index >= 0 && index < task.size()){
            studentIntern.completeTask(task.get(index));
        }
    }

    //method for viewing all user
    private static void viewAllUser(){
        System.out.println();
        System.out.println("=============================================");
        System.out.println("ALl User");
        System.out.println("=============================================");
        System.out.println();
        System.out.println("Administrator: ");
        for (AdminMain admin : mainAdmin){
            System.out.println(" - " + admin.getName() + " (" + admin.getEmail() + ")");
        }

        System.out.println();
        System.out.println("School Coordinators: ");
        for(School coordinator : school){
            System.out.println(" -" + coordinator.getName() + " - " + coordinator.getSchoolName());
        }

        System.out.println();
        System.out.println("Company Mentors/Supervisors:");
        for(Company mentor : company){
            System.out.println(" - " + mentor.getName() + " - " + mentor.getCompanyName());
        }

        System.out.println();
        System.out.println("Student Interns: ");
        for(StudentIntern studentIntern : stInterns){
            System.out.println(" - " + studentIntern.getName() + " ( "+ studentIntern.getSrCode() + ")");
        }
    }

    //method for the viewing of all internship
    private static void viewALlInternships(){
        System.out.println();
        System.out.println("=============================================");
        System.out.println("ALl Internships");
        System.out.println("=============================================");
        if(internships.isEmpty()){
            System.out.println("No internship created yet.");
        }
        else{
            for(Internship intern : internships){
                System.out.println(intern);
            }
        }
    }

    private static void viewPartnershipsMenu(){
        System.out.println();
        System.out.println("=============================================");
        System.out.println("Partnerships");
        System.out.println();
        System.out.println("--- Company -> School Partnerships ---");
        System.out.println("=============================================");
        for(Company mentor : company){
            if(!mentor.getPartnerSchools().isEmpty()){
                System.out.println(mentor.getCompanyName() + " partners with: ");
                for(String school : mentor.getPartnerSchools()){
                    System.out.println(" ." + school);
                }
            }
        }

        System.out.println();
        System.out.println("--- School -> Company Partnerships ---");
        for(School coordinator : school){
            if(!coordinator.getPartnerCompanies().isEmpty()){
                System.out.println(coordinator.getSchoolName() + " partners with:");
                for(String company : coordinator.getPartnerCompanies()){
                    System.out.println(" ." + company) ;
                }
            }
        }
        System.out.println("=============================================");
    }
    //method for the students main menu
    private static void mainMenu(){
        System.out.println();
        System.out.println("=============================================");
        System.out.println("Main Menu");
        System.out.println("=============================================");
        System.out.println("1. Login");
        System.out.println("2. Register New User");
        System.out.println("3. Exit");
        System.out.println("=============================================");
    }

    //method for the input of integer value
    private static int getInputInteger (String integer){
        System.out.print(integer);
        try {
            int value = Integer.parseInt(input.nextLine());
            return value;
        }
        catch(NumberFormatException e){
            System.out.println("Invalid input. Please enter a number.");
            return - 1;
        }
    }
}
