//Evaluation class serves as a support class for the subclasses
public class Evaluation {
    private String evaluationID;
    private double score;
    private String feedback;
    private String evaluatorsName;
    private String internsName;

    //constructor
    public Evaluation(String evaluationID, double score, String feedback, String evaluatorsName, String internsName){
        this.evaluationID = evaluationID;
        this.score = score;
        this.feedback = feedback;
        this.evaluatorsName = evaluatorsName;
        this.internsName = internsName;
    }

    //evaluationID's getter
    public String getEvaluationID(){
        return evaluationID;
    }

    //evaluationID's setter
    public void setEvaluationID(String evaluationID){
        this.evaluationID = evaluationID;
    }

    //score getter
    public double getScore(){
        return score;
    }

    //score setter
    public void setScore(double score){
        this.score = score;
    }

    //feedback getter
    public String getFeedback(){
        return feedback;
    }

    //feedback setter
    public void setFeedback(String feedback){
        this.feedback = feedback;
    }

    //evaluatorsName getter
    public String getEvaluatorsName(){
        return evaluatorsName;
    }

    //evaluatorsName setter
    public void setEvaluatorsName(String evaluatorsName){
        this.evaluatorsName = evaluatorsName;
    }

    //internsName getter
    public String getInternsName(){
        return internsName;
    }

    //intersName setter
    public void setInternsName(String internsName){
        this.internsName = internsName;
    }

    //Override in toString
    @Override
    public String toString(){
        return "Evaluation for " + internsName + "\nScore: " + score + "/5\nFeedback: " + feedback + "\nEvaluated by: " + evaluatorsName;
    }
}
