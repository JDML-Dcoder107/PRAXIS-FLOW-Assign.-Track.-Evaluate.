//Encapsulation
public class PersonalInformation {
    private String firstName;
    private String lastName;
    private String middleInitial;
    private int age;
    private String position;

    //constructor
    public PersonalInformation(String firstName, String lastName, String middleInitial, int age, String position){
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.age = age;
        this.position = position;
    }
    //getters
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public String getMiddleInitial(){
        return middleInitial;
    }
    public int getAge(){
        return age;
    }
    public String getPosition(){
        return position;
    }

    //setters
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public void setMiddleInitial(String middleInitial){
        this.middleInitial = middleInitial;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setPosition(String position){
        this.position = position;
    }
    public String getLastFirstName() {
        String first = getFirstName();
        String middle = getMiddleInitial();
        String last = getLastName();

        StringBuilder sb = new StringBuilder();

        if (last != null && !last.trim().isEmpty()) {
            sb.append(last.trim());
        }

        if ((first != null && !first.trim().isEmpty()) || (middle != null && !middle.trim().isEmpty())) {
            sb.append(","); // last, ...
            if (first != null && !first.trim().isEmpty()) {
                sb.append(' ').append(first.trim());
            }
            if (middle != null && !middle.trim().isEmpty()) {
                sb.append(' ');
                String m = middle.trim();
                if (m.length() == 1) sb.append(m).append('.');
                else sb.append(m);
            }
        }

        return sb.toString();
    }
}
