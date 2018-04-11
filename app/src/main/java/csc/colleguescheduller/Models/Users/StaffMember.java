package csc.colleguescheduller.Models.Users;

/*
Mahmoud Maher
 */

import org.threeten.bp.DayOfWeek;

import java.util.ArrayList;
import java.util.Date;

import csc.colleguescheduller.Models.Subjects.Subject;

public class StaffMember {


    public Boolean Unsaved = false;

    private String memberId;
    private String memberName;
    private SciDegree scientificDegree;
    private SciDepartment scientificDepartment;
    private int workHours;
    private Date hiringDate;
    private HiringType hiringType;
    private Date birthDate;
    private ArrayList<Subject> teachingSubjects;
    private Permission permission;
    private ArrayList<DayOfWeek> wordays;
    private HiringDegree hiringDegree;
    private String accessCode;

    public StaffMember(String memberId,String accessCode, String memberName, SciDegree scientificDegree, SciDepartment scientificDepartment, int workHours, Date hiringDate, HiringType hiringType, Date birthDate, ArrayList<Subject> teachingSubjects, Permission permission, ArrayList<DayOfWeek> wordays, HiringDegree hiringDegree) {
        this(memberId,accessCode,memberName,scientificDegree,scientificDepartment,workHours,hiringDate,hiringType,birthDate,permission,hiringDegree);
        this.teachingSubjects = teachingSubjects;
        this.wordays = wordays;
    }

    public StaffMember(String memberId,String accessCode, String memberName, SciDegree scientificDegree, SciDepartment scientificDepartment, int workHours, Date hiringDate, HiringType hiringType, Date birthDate, Permission permission, HiringDegree hiringDegree) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.scientificDegree = scientificDegree;
        this.scientificDepartment = scientificDepartment;
        this.workHours = workHours;
        this.hiringDate = hiringDate;
        this.hiringType = hiringType;
        this.birthDate = birthDate;
        this.permission = permission;
        this.hiringDegree = hiringDegree;
    }

    public StaffMember() {
        teachingSubjects = new ArrayList<>();
        wordays = new ArrayList<>();
    }

    public HiringDegree getHiringDegree() {
        return hiringDegree;
    }

    public void setHiringDegree(HiringDegree hiringDegree) {
        this.hiringDegree = hiringDegree;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getAccessCode() {
        return accessCode;
    }

    public void setAccessCode(String accessCode) {
        this.accessCode = accessCode;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public SciDegree getScientificDegree() {
        return scientificDegree;
    }

    public void setScientificDegree(SciDegree scientificDegree) {
        this.scientificDegree = scientificDegree;
    }

    public SciDepartment getScientificDepartment() {
        return scientificDepartment;
    }

    public void setScientificDepartment(SciDepartment scientificDepartment) {
        this.scientificDepartment = scientificDepartment;
    }

    public int getWorkHours() {
        return workHours;
    }

    public void setWorkHours(int workHours) {
        this.workHours = workHours;
    }

    public Date getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
    }

    public HiringType getHiringType() {
        return hiringType;
    }

    public void setHiringType(HiringType hiringType) {
        this.hiringType = hiringType;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public ArrayList<Subject> getTeachingSubjects() {
        return teachingSubjects;
    }

    public void setTeachingSubjects(ArrayList<Subject> teachingSubjects) {
        this.teachingSubjects = teachingSubjects;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public ArrayList<DayOfWeek> getWordays() {
        return wordays;
    }

    public void setWordays(ArrayList<DayOfWeek> wordays) {
        this.wordays = wordays;
    }
}
