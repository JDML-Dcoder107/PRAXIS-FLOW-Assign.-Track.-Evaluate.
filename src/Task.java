//Task class this serves as a supporting class for the subclasses
public class Task {
    //Encapsulation of values
    private String taskId;
    private String taskName;
    private String description;
    private String dueDate;
    private String status;

    //constructor
    public Task(String taskId, String taskName, String description, String dueDate, String status){
        this.taskId = taskId;
        this.taskName = taskName;
        this.description = description;
        this.dueDate = dueDate;
        this.status = "Pending";
    }

    //TaskId's getter
    public String getTaskId(){
        return taskId;
    }

    //TaskId's setter
    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    //TaskName's getter
    public String getTaskName(){
        return taskName;
    }

    //TaskName's setter
    public void setTaskName(String taskName){
        this.taskName = taskName;
    }

    //task description's getter
    public String getDescription(){
        return description;
    }

    //task description setter
    public void setDescription(String description){
        this.description = description;
    }

    //task due date getter
    public String getDueDate(){
        return dueDate;
    }

    // task due date setter
    public void setDueDate(String dueDate){
        this.dueDate = dueDate;
    }

    //task status getter
    public String getStatus(){
        return status;
    }

    //task status setter
    public void setStatus(String status){
        this.status = status;
    }

    //Polymorphism of toString
    @Override
    public String toString(){
        return "Task[" + taskId + "]: " + taskName + " - Status: " + status + " (Due: " + dueDate + ")";
    }
}
