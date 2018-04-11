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


import csc.colleguescheduller.Models.Schedule.Schema.*;

import java.util.Map;


public class Schedule {


    private Year year;
    private Specialization specialization;
    private Semester semester;
    private Map<String, Object> day;


    public Schedule() {
        super();
    }


    public void setyear(Year year) {
        this.year = year;
    }

    public Year getyear() {
        return year;
    }

    public void setspecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Specialization getspecialization() {
        return specialization;
    }

    public void setsemester(Semester semester) {
        this.semester = semester;
    }

    public Semester getsemester() {
        return semester;
    }

    public void setday(Map<String, Object> day) {
        this.day = day;
    }

    public Map<String, Object> getday() {
        return day;
    }


}

	
	
