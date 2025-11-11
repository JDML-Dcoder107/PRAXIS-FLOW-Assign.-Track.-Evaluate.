//abstract interface for the tracker of time and timesheets
public interface Tracker {
    void loginData(double hours, String date);
    void viewTimesheet();
}
