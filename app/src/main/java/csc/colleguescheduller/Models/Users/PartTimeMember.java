package csc.colleguescheduller.Models.Users;

/*
Mahmoud Maher
 */

import org.threeten.bp.DayOfWeek;

import java.util.ArrayList;
import java.util.Date;

import csc.colleguescheduller.Models.Subjects.Subject;

public class PartTimeMember extends StaffMember {

	private String college;
	private String university;

	public PartTimeMember() {
	}

	public PartTimeMember(String memberId,String accessCode, String memberName, SciDegree scientificDegree, SciDepartment scientificDepartment,
						  int workHours, Date hiringDate, HiringType hiringType, Date birthDate, ArrayList<Subject> teachingSubjects,
						  Permission permission, ArrayList<DayOfWeek> wordays, HiringDegree hiringDegree, String college, String university) {

		super(memberId,accessCode, memberName, scientificDegree, scientificDepartment, workHours, hiringDate, hiringType, birthDate, teachingSubjects, permission, wordays, hiringDegree);
		this.college = college;
		this.university = university;
	}

	public PartTimeMember(String memberId,String accessCode, String memberName, SciDegree scientificDegree, SciDepartment scientificDepartment, int workHours,
						  Date hiringDate, HiringType hiringType, Date birthDate, Permission permission, HiringDegree hiringDegree, String college, String university) {

		super(memberId,accessCode, memberName, scientificDegree, scientificDepartment, workHours, hiringDate, hiringType, birthDate, permission, hiringDegree);
		this.college = college;
		this.university = university;
	}

	public void setcollege(String college)
	{this.college=college;
	}
	public String getcollege()
	{
		return college;
	}
	
	public void setuniversity(String university)
	{
		this.university=university;
	}
	public String getuniversity() 
	{
		return university;
	}	
	
}
