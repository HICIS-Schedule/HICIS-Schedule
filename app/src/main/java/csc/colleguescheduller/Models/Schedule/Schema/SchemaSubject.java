package csc.colleguescheduller.Models.Schedule.Schema;

/*
Amr Samir
 */

import csc.colleguescheduller.Models.Subjects.Subject;

public class SchemaSubject {

    private Subject subject;
    private int noHoursApplied;
    private int noHoursPractical;

    public void setsubject(Subject subject) {
        this.subject = subject;
    }

    public Subject getsubject() {
        return subject;
    }

    public void setnoHoursApplied(int noHoursApplied) {
        this.noHoursApplied = noHoursApplied;
    }

    public int getnoHoursApplied() {
        return noHoursApplied;

    }

    public void setnoHoursPractical(int noHoursPractical) {
        this.noHoursPractical = noHoursPractical;
    }

    public int getnoHoursPractical() {
        return noHoursPractical;

    }
}


