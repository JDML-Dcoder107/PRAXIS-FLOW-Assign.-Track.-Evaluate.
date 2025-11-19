//Inheritance - 3rd subclass
public class AdminMain extends User {
    private int totalUser;

    //constructor
    public AdminMain(String userID, String name, String email, String password){
        super(userID, name, email, password, "Administrator");
            this.totalUser = 0;

    }

    //totalUser getter
    public int getTotalUser(){
        return totalUser;
    }

    //totalUser setter
    public void setTotalUser(int totalUser){
        this.totalUser = totalUser;
    }

    //Override the display view method from the abstract class
    @Override
    public void displayView(){
        System.out.println("=============================================");
        System.out.println("||               Main Admin                ||");
        System.out.println("=============================================");
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Total number of user currently managing: " + totalUser);
    }

    //Approving the internship
    public void approveInternship(Internship internship){
      try{
          if(internship == null){
              throw new NullPointerException(("Internship object should not leave blank"));
          }
          //make a new variable for the getter of the intern's status
            StudentIntern stIntern = internship.getIntern();

          if(stIntern == null){
              throw new IllegalStateException("No student intern assign to this particular internship");
          }

          //Updating the status of the internship and the student intern
          internship.setStatus("Approved");
          stIntern.setStatus("Active");

          System.out.println("Administrator: " + getName() + " approved internship of internshipID: " + internship.getInternshipId());
          System.out.println("Student: " + stIntern.getName() + " status updated to: Active");
          System.out.println("Position: " + internship.getPosition() + " at " + internship.getCompanyName());

      }
      catch (NullPointerException | IllegalStateException e){
          System.out.println("Error occurred: " + e.getMessage());
      }
      catch (Exception e){
          System.out.println("Unexpected error occurred while approving the internship: " + e.getMessage());
      }
      System.out.println("=============================================");
    }

    //Rejecting method of internship
    public void rejectInternship(Internship internship, String reason){
        try{
            if(internship == null){
                throw new NullPointerException("Internship object should not be left blank.");
            }

            StudentIntern stIntern = internship.getIntern();

            if(stIntern == null){
                throw new IllegalStateException("No student intern assigned to this internship");
            }

            internship.setStatus("Rejected");
            stIntern.setStatus("Application Failed");

            System.out.println("Administrator: " + getName() + " rejected internship ID: " + internship.getInternshipId());
            System.out.println("Reason: " + reason);
        }
        catch (NullPointerException | IllegalStateException e){
            System.out.println("Error occurred: " + e.getMessage());
        }
        catch (Exception e){
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    //method for the management of user
    public void manageUser(User user){
        System.out.println("Managing user: " + user.getName() + " - " + user.getRole());
    }
}
