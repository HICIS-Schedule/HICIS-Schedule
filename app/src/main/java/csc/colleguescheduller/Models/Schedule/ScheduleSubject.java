/**
 * @author SiCo
 */
/**
 * @author SiCo
 *
 */
package csc.colleguescheduller.Models.Schedule;

/*
Amr Samir
 */



public class ScheduleSubject {

    private String subject;
    private int startpoint;
    private int endpoint;

    public ScheduleSubject() {
        super();
    }


    public void setsubject(String subject) {
        this.subject = subject;
    }

    public String getsubject() {
        return subject;
    }

    public void setstartpoint(int startpoint) {
        this.startpoint = startpoint;
    }

    public int getstartpoint() {
        return startpoint;
    }

    public void setendpoint(int endpoint) {
        this.endpoint = endpoint;
    }

    public int getendpoint() {
        return endpoint;
    }

}
