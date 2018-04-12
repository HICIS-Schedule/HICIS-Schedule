package csc.colleguescheduller.Models.Schedule;

public class ScheduleSubject {

    private String subject;
    private int startPoint;
    private int enPpoint;

    public ScheduleSubject() {
        
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubject() {
        return this.subject;
    }

    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    public int getStartPoint() {
        return this.startPoint;
    }

    public void setEndPoint(int endPoint) {
        this.endPoint = endPoint;
    }

    public int getEndPoint() {
        return this.enPpoint;
    }

}
