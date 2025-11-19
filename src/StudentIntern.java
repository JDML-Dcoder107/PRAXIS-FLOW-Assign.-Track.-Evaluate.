import java.util.ArrayList;
//Inheritance
//Sub Class 1
public class StudentIntern extends User implements Evaluate,Tracker{
    private String srCode;
    private String school;
    private String status;
    private ArrayList<Task> taskLog;
    private ArrayList<TimeLog> timeLogs;
    private Evaluation evaluation;

    //constructor
    public StudentIntern(String srCode, String name, String email, String password, String schoolName){
        super(srCode, name, email, password, "Student Intern");
        this.srCode = srCode;
        this.school = schoolName;
        this.status = "Inactive";
        this.taskLog = new ArrayList<>();
        this.timeLogs = new ArrayList<>();
    }

    //getter of srCode
    public String getSrCode(){
        return srCode;
    }

    //setter of srCode
    public void setSrCode(String srCode){
        this.srCode = srCode;
    }

    //getters of school
    public String getSchool(){
        return school;
    }

    //setter for school
    public void setSchool(String school){
        this.school = school;
    }

    //getter for status
    public String getStatus(){
        return status;
    }

    //setter for status
    public void setStatus(String status){
        this.status = status;
    }

    //Polymorphism
    @Override
    public void displayView(){
        System.out.println();
        System.out.println("=============================================");
        System.out.println("||            Intern Dashboard             ||");
        System.out.println("=============================================");
        System.out.println();
        System.out.println("Name: " + getName());
        System.out.println("Sr-Code: " + getSrCode());
        System.out.println("Status: " + status);
        System.out.println("Active Tasks: " + taskLog.size());
        System.out.println("Total Time of Hours: " + getTotalHours());
        if(evaluation != null){
            System.out.println("Evaluation Score: " + evaluation.getScore() + "/5");
        }
        System.out.println("=============================================");
    }

    //methods for the interns assigned task.
    public void receiveTask(Task task){
        taskLog.add(task);
        System.out.println("Intern " + getName() + " receive task " + task.getTaskName());
    }
    public void completeTask(Task task){
        try{
            if(task == null){
                throw new NullPointerException("Task should not be leave null or blank!!");
            }
            if(!taskLog.contains(task)){
                throw new IllegalStateException("Task not assign to this intern");
            }
            task.setStatus("Completed");
            System.out.println("Intern " + getName() + " completed task " + task.getTaskName());
        }
        catch(NullPointerException | IllegalStateException e){
            System.out.println("Error found: " + e.getMessage());
        }
        catch(Exception e){
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }
    }

    //Override(Polymorphism) from the abstract interface
    @Override
    //for login hours
    public void logData(double hours, String date){
        try {
            if (hours <= 0 || hours > 24) {
                throw new IllegalArgumentException("Invalid value of hours.\nThe value of Hours should be between 0 and 24 only.");
            }
            if (date == null || date.isEmpty()) {
                throw new IllegalArgumentException("Invalid!! the date should not be empty or null.");
            }
            TimeLog log = new TimeLog(date, hours, getName());
            timeLogs.add(log);
            System.out.println("You are logged on " + hours + " hours on the day of " + date + " as intern " + getName());
        }
        catch(IllegalArgumentException e){
            System.out.println("Time logging error: " + e.getMessage());
        }
        catch(Exception e){
            System.out.println("Unexpected error occurred: " + e.getMessage());
        }
    }

    //for viewing the timesheet
    @Override
    public void viewTimesheet(){
        System.out.println();
        System.out.println("====== Timesheet for " + getName() + " ======");
        if(timeLogs.isEmpty()){
            System.out.println("There is no number of hours logged in under the name: " + getName());
        }
        else{
            for(TimeLog log : timeLogs){
                System.out.println(log);
            }
            System.out.println("Total Hours: " + getTotalHours());
        }
        System.out.println("=============================================");
    }

    //getter of the total hours
    private double getTotalHours(){
        double total = 0;
        for(TimeLog log : timeLogs){
            total += log.getHours();
        }
        return total;
    }

    //(Polymorphism)Implementing the evaluation(Submission and Viewing)
    @Override
    public void submitEvaluation(Evaluation eval){
        this.evaluation = eval;
    }

    @Override
    public double viewEvaluationScore(){
        if(evaluation != null){
            System.out.println("Your evaluation result is: " + evaluation.getScore() + "/5");
            if(evaluation.getScore() <= 3 && evaluation.getScore() > 0 ){
                System.out.println("Congratulation you have passed the internship!!");
            }
            else{
                System.out.println("Important Notice you have Failed the internship");
            }
            return evaluation.getScore();
        }
        System.out.println("No evaluation available yet");
        return 0;
    }
}
