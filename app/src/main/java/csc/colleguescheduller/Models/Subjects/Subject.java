package csc.colleguescheduller.Models.Subjects;

/*
Bahaa Oyoun Ahmed
 */

import java.util.ArrayList;

import csc.colleguescheduller.Models.Users.StaffMember;

public class Subject {

    private String subjectId;
    private String Name;
    private String NameInArabic;
    private SubjectType Type;
    private ArrayList<StaffMember> TeachingMembers;
    private int NumberOfSectionsPractical;
    private int NumberOfSectionsApplied;

    public Subject(String name) {
        Name = name;
    }

    public Subject() {
        TeachingMembers = new ArrayList<>();
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNameInArabic() {
        return NameInArabic;
    }

    public void setNameInArabic(String nameInArabic) {
        NameInArabic = nameInArabic;
    }

    public SubjectType getType() {
        return Type;
    }

    public void setType(SubjectType type) {
        Type = type;
    }

    public ArrayList<StaffMember> getTeachingMembers() {
        return TeachingMembers;
    }

    public void setTeachingMembers(ArrayList<StaffMember> teachingMembers) {
        TeachingMembers = teachingMembers;
    }

    public int getNumberOfSectionsPractical() {
        return NumberOfSectionsPractical;
    }

    public void setNumberOfSectionsPractical(int numberOfSectionsPractical) {
        NumberOfSectionsPractical = numberOfSectionsPractical;
    }

    public int getNumberOfSectionsApplied() {
        return NumberOfSectionsApplied;
    }

    public void setNumberOfSectionsApplied(int numberOfSectionsApplied) {
        NumberOfSectionsApplied = numberOfSectionsApplied;
    }

    public void add() {
    }

    public void remove() {
    }
}
