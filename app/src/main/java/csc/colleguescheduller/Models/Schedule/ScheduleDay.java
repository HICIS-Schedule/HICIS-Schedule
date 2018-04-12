package csc.colleguescheduller.Models.Schedule;

import java.util.Map;

public class ScheduleDay {

    private Map<String, ScheduleSubject> subjects;

    public ScheduleDay() {

    }

    public void setSubjects(Map<String, ScheduleSubject> subjects) {
        this.subjects = subjects;
    }

    public Map<String, ScheduleSubject> getSubjects() {
        return this.subjects;
    }
}
