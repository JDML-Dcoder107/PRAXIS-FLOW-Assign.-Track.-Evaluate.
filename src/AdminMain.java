//Inheritance - 3rd subclass
public class AdminMain extends User {
    private int totalUser;

    //constructor
    public AdminMain(String srCode, String name, String email, String password, String role){
        super(srCode, name, email, password, "Administrator");
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
        System.out.println("======================");
        System.out.println("|| Main Admin ||");
        System.out.println("======================");
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

          internship.setStatus("Approved");
          System.out.println("Administrator: " + getName() + " approved internship of internshipID: " + internship.getInternshipId());
      }
      catch (NullPointerException e){
          System.out.println("Error occurred: " + e.getMessage());
      }
      catch (Exception e){
          System.out.println("Unexpected error occurred while approving the internship: " + e.getMessage());
      }
    }

    //method for the management of user
    public void manageUser(User user){
        System.out.println("Managing user: " + user.getName() + " - " + user.getRole());
    }
}
