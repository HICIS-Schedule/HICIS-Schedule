package csc.colleguescheduller.Models.Schedule.Schema;

import csc.colleguescheduller.Models.Subjects.Subject;

public class SchemaSubject {

    private String subjectID;
    private int noOfAppliedHours;
    private int noOfPracticalHours;

    public void setSubject(Subject id) {
        this.subjectID = id;
    }

    public String getSubject() {
        return this.subjectID;
    }

    public void setNoOfAppliedHours(int noOfAppliedHours) {
        this.noOfAppliedHours = noOfAppliedHours;
    }

    public int getNoHoursApplied() {
        return this.noOfAppliedHours;
    }

    public void setNoOfPracticalHours(int noOfPracticalHours) {
        this.noOfPracticalHours = noOfPracticalHours;
    }

    public int gitNoOfPracticalHours() {
        return this.noOfPracticalHours;
    }
}