package csc.colleguescheduller.Models.Subjects;

import java.util.ArrayList;

public class Subject {

    private String id;
    private String name;
    private String nameInArabic;
    private SubjectType type;
    private ArrayList<String> teachingMembers;
    private int noOfPracticalSections;
    private int noOfAppliedSections;

    public Subject() {
        TeachingMembers = new ArrayList<>();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setNameInArabic(String nameInArabic) {
        this.nameInArabic = nameInArabic;
    }

    public String getNameInArabic() {
        return this.nameInArabic;
    }

    public void setType(SubjectType type) {
        this.type = type;
    }

    public SubjectType getType() {
        return this.type;
    }

    public void addTeachingMember(String teachingMember) {
        this.teachingMembers.add(teachingMember);
    }

    public void removeTeachingMember(String teachingMember) {
        this.teachingMembers.remove(teachingMember);
    }

    public void setTeachingMembers(ArrayList<String> teachingMembers) {
        this.teachingMembers = teachingMembers;
    }

    public ArrayList<String> getTeachingMembers() {
        return this.teachingMembers;
    }

    public void setNumberOfPracticalSections(int noOfPracticalSections) {
        this.noOfPracticalSections = noOfPracticalSections;
    }

    public int getNumberOfPracticalSections() {
        return this.noOfPracticalSections;
    }

    public void setNumberOfAppliedSections(int noOfAppliedSections) {
        this.noOfAppliedSections = noOfAppliedSections;
    }

    public int getNumberOfAppliedSections() {
        return this.noOfAppliedSections;
    }

}
