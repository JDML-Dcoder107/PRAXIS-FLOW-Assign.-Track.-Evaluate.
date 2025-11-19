//abstract interface for the tracker of time and timesheets
public interface Tracker {
    void logData(double hours, String date);
    void viewTimesheet();
}
