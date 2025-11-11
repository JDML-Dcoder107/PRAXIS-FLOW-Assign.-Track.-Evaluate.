//Internship class is a subclass that provides assistance to the AdminMain
public class Internship {
    private String internshipId;
    private String companyName;
    private String position;
    private String status;
    private StudentIntern intern;

    //constructor
    public Internship(String internshipId, String companyName, String position){
        this.internshipId = internshipId;
        this.companyName = companyName;
        this.position = position;
        this.status = "Pending";
    }

    //internshipId getter
    public String getInternshipId(){
        return internshipId;
    }

    //internshipId setter
    public void setInternshipId(String internshipId){
        this.internshipId = internshipId;
    }

    //companyName getter
    public String getCompanyName(){
        return companyName;
    }

    //companyName setter
    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    //position getter
    public String getPosition(){
        return position;
    }

    //position setter
    public void setPosition(String position){
        this.position = position;
    }

    //status getter
    public String getStatus(){
        return status;
    }

    //status setter
    public void setStatus(String status){
        this.status = status;
    }

    //intern getter
    public StudentIntern intern (){
        return intern;
    }

    //intern setter
    public void setIntern(StudentIntern intern){
        this.intern = intern;
    }

    //Override the toString method in internship
    @Override
    public String toString(){
        return "Internship[" + internshipId + "]: " + position + " at the company named " + companyName + " - Status: " + status;
    }
}
