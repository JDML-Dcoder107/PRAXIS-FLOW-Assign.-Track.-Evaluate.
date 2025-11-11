//TimeLog serves as a supporting class for the subclasses
public class TimeLog {
    private String date;
    private double hours;
    private String internName;

    //constructor
    public TimeLog(String date, double hours, String internName){
        this.date = date;
        this.hours = hours;
        this.internName = internName;
    }

    //date's getter
    public String getDate(){
        return date;
    }

    //date's setter
    public void setDate(){
        this.date = date;
    }

    //hours getters
    public double getHours(){
        return hours;
    }

    //hours setter
    public void setHours(double hours){
        this.hours = hours;
    }

    //internName getter
    public String getInternName(){
        return internName;
    }

    //internName setter
    public void setInternName(String internName){
        this.internName = internName;
    }

    //Override the toString for the TimeLog
    @Override
    public String toString(){
        return "Date: " + date + "Hours: " + hours;
    }
}
