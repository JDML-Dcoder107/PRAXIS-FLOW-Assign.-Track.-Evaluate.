import java.util.ArrayList;
//Inheritance - 2nd subclass focusing on the school
public class School extends User{
    private String schoolName;
    private int levelOfRecommendation;
    private ArrayList<String> partnerCompanies;
    private ArrayList<Internship> receivedInternsRecommendation;

    //constructor
    public School(String userID, String name, String email, String password, String schoolName){
        super(userID, name, email, password, "School Coordinator");
        this.schoolName = schoolName;
        this.levelOfRecommendation = 0;
        this.partnerCompanies = new ArrayList<>();
        this.receivedInternsRecommendation  = new ArrayList<>();
    }

    //school name getter
    public String getSchoolName(){
        return schoolName;
    }

    //school name setter;
    public void setSchoolName(String schoolName){
        this.schoolName = schoolName;
    }

    //level of recommendation getter
    public int getLevelOfRecommendation(){
        return levelOfRecommendation;
    }

    //level of recommendation setter
    public void setLevelOfRecommendation(int levelOfRecommendation){
        this.levelOfRecommendation = levelOfRecommendation;
    }

    //partner companies getter
    public ArrayList<String> getPartnerCompanies(){
        return partnerCompanies;
    }

    //interns recommendation's getter
    public ArrayList<Internship> getReceivedInternsRecommendation(){
        return receivedInternsRecommendation;
    }


    //adding a sister company of the school
    public void addPartnerCompany(String companyName){
        try{
            if(companyName == null || companyName.isEmpty()){
                throw new NullPointerException("The company name should not be left null or empty");
            }

            if(partnerCompanies.contains(companyName)){
                throw new IllegalStateException("The company is already an existing partner");
            }

            partnerCompanies.add(companyName);
            System.out.println(companyName + " is added as partner of " + schoolName);
        }
        catch(NullPointerException | IllegalStateException e){
            System.out.println("Error has been occurred: " + e.getMessage());
        }
    }
    //receiving of internship recommendation from the sister companies
    public void receiveInternshipRecommendation(Internship intern, String companyName){
        try {
            if(intern == null){
               throw new NullPointerException("This section should not be left null or blank");
            }

            receivedInternsRecommendation.add(intern);
            System.out.println(schoolName + " has received internship recommendation.");
            System.out.println("Position: " + intern.getPosition());
            System.out.println("From the Sister Company: " + companyName);
            System.out.println("Status Available for student recommendation");
        }
        catch(NullPointerException e){
            System.out.println("Error has occurred: " + e.getMessage());
        }
        catch(Exception e){
            System.out.println("Error has been found during the process: " + e.getMessage());
        }

    }

    public void viewInternshipRecommendation(){
        System.out.println();
        System.out.println("=============================================");
        System.out.println("||        Internship Recommendation        ||");
        System.out.println("=============================================");
        if(receivedInternsRecommendation.isEmpty()){
            System.out.println("No internship recommendation received yet.");
        }
        else{
            for(int i = 0; i < receivedInternsRecommendation.size(); i++){
                System.out.println((i + 1) + ". " + receivedInternsRecommendation.get(i));
            }
        }
        System.out.println("=============================================");
    }

    //Override the displayView method from the abstract class
    @Override
    public void displayView(){
        System.out.println();
        System.out.println("=============================================");
        System.out.println("||           School Coordinator            ||");
        System.out.println("=============================================");
        System.out.println("Name: " + getName());
        System.out.println("School: " + schoolName);
        System.out.println("Students Recommendation: " + levelOfRecommendation);
        System.out.println("Partner/Sister Companies: " + partnerCompanies.size());
        if(!partnerCompanies.isEmpty()){
            System.out.println("Partners: " + String.join(", ", partnerCompanies));
        }
        System.out.println("Internship Recommendation Received: " + receivedInternsRecommendation.size());
        System.out.println("=============================================");
    }

    //Student recommendation for internship
    public void recommendStudent(StudentIntern studentIntern, Internship intern){
        try{
            if(studentIntern == null || intern == null){
                throw new IllegalStateException("This section should not be left null or blank");
            }

            intern.setIntern(studentIntern);
            studentIntern.setStatus("Active");
            levelOfRecommendation++;
            System.out.println("School " + getName() + " recommended " + studentIntern.getName() + " for internship at " + intern.getCompanyName());
        }
        catch(IllegalArgumentException e){
            System.out.println("Error has been occurred: " + e.getMessage());
        }
        catch (Exception e){
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }
    }

    public void monitorProcess(StudentIntern studentIntern){
        System.out.println("Monitoring process of student: " + studentIntern.getName());
        studentIntern.viewTimesheet();
    }
}
