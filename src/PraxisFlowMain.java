import java.util.Scanner;
import java.util.ArrayList;

public class PraxisFlowMain {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<AdminMain> mainAdmin =  new ArrayList<>();
    private static ArrayList<Company> company = new ArrayList<>();
    private static ArrayList<Internship> internships = new ArrayList<>();
    private static ArrayList<School> school = new ArrayList<>();
    private static ArrayList<StudentIntern> stInterns = new ArrayList<>();
    private static ArrayList<Task> task = new ArrayList<>();


    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("Praxis Flow");
        System.out.println("Assign, Track, Evaluate");
        System.out.println("=============================================");
    }
    public static double getInputDouble (){
        try{
            double value = Double.parseDouble(input.nextLine());
            return value;
        }
        catch(NumberFormatException e){
            System.out.println("Invalid input. Please enter a double number\nNotice the value is defaulting to 0.0");
            return 0.0;
        }
    }
    public static int getInputInteger (String integer){
        System.out.println(integer);
        try {
            int value = Integer.parseInt(input.nextLine());
            return value;
        }
        catch(NumberFormatException e){
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        }
    }
}
