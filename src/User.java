//Abstract Class
abstract class User{
//Encapsulation
    private String userID;
    private String name;
    private String email;
    private String password;
    private String role;

    //Constructor
    public User(String userID, String name, String email, String password, String role){
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    //getter of SrCode
    public String getUserID(){
        return getUserID();
    }

    //setter for SrCode
    public void setUserID(String userID){
        this.userID = userID;
    }

    //getter of Name
    public String getName(){
        return name;
    }

    //setter of Name
    public void setName(String name){
        this.name = name;
    }

    //getter of Email
    public String getEmail(){
        return email;
    }

    //setter of Email
    public void setEmail(String email){
        this.email = email;
    }

    //getter of password
    public String getPassword(){
        return password;
    }

    //setter of password
    public void setPassword(String password){
        this.password = password;
    }

    //getter of role
    public String getRole(){
        return role;
    }

    //setter of role
    public void setRole(String role){
        this.role = role;
    }

    //boolean method for the systems password exception during log in
    public boolean login(String inputPassword){
        try{
            if(inputPassword == null || inputPassword.isBlank()){
                throw new IllegalArgumentException("This section should not be left blank");
            }
            if(this.password.equals(inputPassword)){
                System.out.println("Login successful, welcome " + name + "role: (" + role + ")");
                return true;
            }
            else{
                throw new SecurityException("Invalid input of credentials");
            }
        }
        catch (SecurityException e){
            System.out.println("Authentication process failed " + e.getMessage());
            return false;
        }
        catch (IllegalArgumentException e){
            System.out.println("Login error " + e.getMessage());
            return false;
        }
        catch (Exception e){
            System.out.println("Unexpected error during the login process: " + e.getMessage());
            return false;
        }
    }

    //abstract method for displaying the login view
    abstract void displayView();

    // method for the logout message
    public void logOut(){
        System.out.println("logout successfully");
    }
}