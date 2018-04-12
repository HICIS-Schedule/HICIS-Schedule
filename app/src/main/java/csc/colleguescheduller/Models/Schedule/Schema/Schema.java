package csc.colleguescheduller.Models.Schedule.Schema;

import java.util.Map;

import csc.colleguescheduller.Models.Room.Room;
import csc.colleguescheduller.Models.Subjects.Subject;

public class Schema {

    private Year year;
    private Specialization specialization;
    private Semester semester;
    private Map<String, Object> subjects;
    private int noOfStudents;
    private Room hall;

    public Schema() {

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

    public void addSubject(String key, Subject subject) {
        this.subjects.put(key, subject);
    }

    public void removeSubject(String key) {
        this.subjects.remove(key);
    }

    public Subject getSubject(String key) {
        return this.subjects.get(key);
    }

    public Map<String, Object> getSubjectList() {
        return this.subjects;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public int getNoOfStudents() {
        return this.noOfStudents;
    }

    public void setHall(Room hall) {
        this.hall = hall;
    }

    public Room getHall() {
        return this.hall;
    }
}