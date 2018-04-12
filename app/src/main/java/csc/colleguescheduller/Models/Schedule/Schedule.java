package csc.colleguescheduller.Models.Schedule;

import csc.colleguescheduller.Models.Globals.Semester;
import csc.colleguescheduller.Models.Globals.Specialization;
import csc.colleguescheduller.Models.Globals.Year;

import java.util.Map;

public class Schedule {

    private Year year;
    private Specialization specialization;
    private Semester semester;
    private Map<String, ScheduleDay> day;

    public Schedule() {

    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Year getYear() {
        return this.year;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Specialization getSpecialization() {
        return this.specialization;
    }

    public void setSemester(Semester semester) {
        this.semester = semester;
    }

    public Semester getSemester() {
        return this.semester;
    }

    public void setDay(Map<String, ScheduleDay> day) {
        this.day = day;
    }

    public Map<String, ScheduleDay> getDay() {
        return this.day;
    }

}
