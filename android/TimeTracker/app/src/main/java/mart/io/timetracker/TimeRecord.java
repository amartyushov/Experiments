package mart.io.timetracker;

public class TimeRecord {

    public void setTime(String time) {
        this.time = time;
    }

    public void setNote(String note) {
        this.note = note;
    }

    private String time;

    public String getNote() {
        return note;
    }

    public String getTime() {
        return time;
    }

    private String note;

    public TimeRecord(String time, String note) {
        this.time = time;
        this.note = note;
    }


}
