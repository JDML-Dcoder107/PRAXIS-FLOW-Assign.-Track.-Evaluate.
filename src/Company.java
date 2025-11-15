import java.util.ArrayList;

//4th Subclass that could inherit from the user abstract class
public class Company extends User implements Evaluate{
    private String companyName;
    private  int taskAssigned;
    private ArrayList<String> partnerSchools;
    private int levelOfRecommendation;

    //constructor
    public Company(String srCode, String name, String email, String password, String role){
        super(srCode, name, email, password, "Company Coordinator");
            this.companyName = companyName;
            this.taskAssigned = 0;
            this.partnerSchools = new ArrayList<>();
            this.levelOfRecommendation = 0;
    }

    //company name getter
    public String getCompanyName(){
        return companyName;
    }

    //company name setter
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    //assigned task getter
    public int getTaskAssigned(){
        return taskAssigned;
    }

    //assigned task setter
    public void setTaskAssigned(int taskAssigned){
        this.taskAssigned = taskAssigned;
    }

    //partner school getter
    public ArrayList<String> getPartnerSchools(){
        return partnerSchools;
    }

    //level of recommendation getter
    public int getLevelOfRecommendation(){
        return levelOfRecommendation;
    }

    //method for adding / sister school
    public void addPartnerSchool(String nameOfSchool){
        try{
            if(nameOfSchool == null || nameOfSchool.isEmpty()){
                throw new IllegalArgumentException("School should not be left null or empty.");
            }

            if(partnerSchools.contains(nameOfSchool)){
                throw new IllegalStateException("The school " + schoolName.getName() + " is already a part of the partnership.");
            }

            partnerSchools.add(nameOfSchool);
            System.out.println(schoolName + " is added as partner/sister school to " + companyName);
        }
        catch(IllegalArgumentException | IllegalStateException e){
            System.out.println("Error has been occurred: " + e.getMessage());
        }
        catch(Exception e){
            System.out.println("Their is an unexpected error occurred during the process: " + e.getMessage());
        }
    }

    //method for the recommended internship for the school to its sister or partner company
    public void recommendInternshipToSchool(Internship internship, School admin){
        try{
            if(internship == null || admin == null){
                throw new IllegalArgumentException("This section should not be left blank or null");
            }

            //check if school is an existing partner of the company
            if(!partnerSchools.contains(admin.getSchoolName())){
                System.out.println("Important Notice: " + admin.getSchoolName() + " is not registered as the partner school.");
                System.out.println("The recommendation will not be interrupted, but we encourage you to set a partnership first.");
            }

            //Sends recommendation to the school
            admin.receivedInternsRecommendation(internship, this.companyName);
            levelOfRecommendation++;

            System.out.println("Company " + companyName + " recommended internship to " + admin.getSchoolName());
            System.out.println("Position: " + internship.getPosition());
            System.out.println("Internship ID: " + internship.getInternshipId());
        }
        catch(IllegalArgumentException e){
            System.out.println("Error occurred: " + e.getMessage());
        }
        catch(Exception e){
            System.out.println("Unexpected error has been found: " + e.getMessage());
        }
    }

    //Overriding the display view
    @Override
    public void displayView(){
        System.out.println();
        System.out.println("===========================================");
        System.out.println("||       Company Mentor/Supervisor       ||");
        System.out.println("===========================================");
        System.out.println("Name: " + getName());
        System.out.println("Company: " + companyName);
        System.out.println("Task Assigned: " + taskAssigned);
        System.out.println("Partner/Sister Schools: " + partnerSchools.size());
        if(!partnerSchools.isEmpty()){
            System.out.println("Partners: " + String.join(", " + partnerSchools));
        }
        System.out.println("Internships Recommended to Schools: " + levelOfRecommendation);
        System.out.println("===========================================");
    }

    //for the Assign task
    public void assignTask(Task task, StudentIntern studentIntern) {
        try {
            if (task == null || studentIntern == null){
                throw new IllegalArgumentException("The section of Task and Intern should not be left blank or null");
            }

            studentIntern.receiveTask(task);
            taskAssigned++;
            System.out.println("Mentor " + getName() + " assigned task '" + task.getTaskName() + "' to intern " + studentIntern.getName());
        }
        catch(IllegalArgumentException e){
            System.out.println("Error has been occurred: " + e.getMessage());
        }
        catch(Exception e){
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }
    }

    //Override the submit evaluation
    @Override
    public void submitEvaluation(Evaluation eval){
        try{
            if(eval == null){
                throw new NullPointerException("The evaluation should not be left blank or null");
            }

            if(eval.getScore() < 1 || eval.getScore() > 5){
                throw new IllegalArgumentException("The evaluation score should be between 1 and 5");
            }

            System.out.println("Evaluation submitted by: " + getName());
            System.out.println("Score: " + eval.getScore() + "/5");
            System.out.println("Feedback: " + eval.getFeedback());
        }
        catch(IllegalArgumentException e){
            System.out.println("Error has been found due to invalid evaluation: " + e.getMessage());
        }
        catch (NullPointerException e){
            System.out.println("Error has been occurred: " + e.getMessage());
        }
        catch (Exception e){
            System.out.println("Unexpected error has been found: " + e.getMessage());
        }
    }

    public double viewEvaluationScore(){
        return 0;
    }
}