package csc.colleguescheduller.Models.Schedule.Schema;

/*
Amr Samir
 */


import java.util.Map;

import csc.colleguescheduller.Models.Room.Room;

public class Schema{

    private Year year;
    private Specialization specialization;
    private Semester semester;
    private Map<String, Object> subjects;
    private int noStudents;
    private Room hall;




    public Schema() {
        super();
    }

    public void setyear(Year year ) {

        this.year=year;
    }

    public Year getyear() {

        return year;
    }

    public void setpecialization(Specialization specialization) {

        this.specialization=specialization;
    }

    public Specialization getspecialization() {

        return specialization;
    }

    public void setsemestertype(Semester smestertype) {

        this.semester=semester;
    }

    public Semester getsemestertype() {
        return semester;
    }

    public void setsubject(Map<String, Object> subject) {
        this.subjects=subject;
    }

    public Map<String, Object> getsubjects() {
        return subjects;
    }

    public void setnoStudents(int noStudents) {
        this.noStudents=noStudents;
    }

    public int getnoStudents() {
        return noStudents;
    }

    public void sethall(Room hall) {
        this.hall=hall;
    }

    public Room gethall() {
        return hall;
    }


}
		
		