package csc.colleguescheduller.Controllers;

/*
Ahmed Mokhtar Hassanin
 */

import android.os.Handler;

import org.threeten.bp.DayOfWeek;

import java.util.ArrayList;
import java.util.Calendar;

import csc.colleguescheduller.Models.FireBase.FireBase_Handler;
import csc.colleguescheduller.Models.Globals.Globals;
import csc.colleguescheduller.Models.Subjects.Subject;
import csc.colleguescheduller.Models.Subjects.SubjectType;
import csc.colleguescheduller.Models.Users.HiringDegree;
import csc.colleguescheduller.Models.Users.HiringType;
import csc.colleguescheduller.Models.Users.Permission;
import csc.colleguescheduller.Models.Users.SciDegree;
import csc.colleguescheduller.Models.Users.StaffMember;

public class Controller{

    protected FireBase_Handler DB;

    public Controller() {
        if(Globals.session != null)
            this.DB = Globals.session.fireBase_handler;
    }

    public void Logout(){
        DB.get_AuthenticationManager().signOut();
    }

    public void Abort_Thread(){

    }

    public StaffMember get_user() {

        // Dummy Code **************************
        StaffMember user = new StaffMember();
        Calendar c = Calendar.getInstance();
        c.set(2014, 2, 23);
        user.setBirthDate(c.getTime());
        c.set(1880, 3, 16);
        user.setBirthDate(user.getBirthDate());
        user.setHiringDegree(HiringDegree.Lecturer);
        user.setHiringType(HiringType.Part_Time);
        user.setMemberId("ER45G");
        user.setMemberName("Mohammed Mostafa Mahmoud");
        user.setPermission(Permission.User);
        user.setScientificDegree(SciDegree.Professor_Dr);
        user.setWorkHours(7);
        ArrayList<Subject> subjectlist = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Subject tmp = new Subject();
            tmp.setName("subject no " + i);
            subjectlist.add(tmp);
        }
        user.setTeachingSubjects(subjectlist);
        ArrayList<DayOfWeek> daylist = new ArrayList<>();
        daylist.add(DayOfWeek.SUNDAY);
        daylist.add(DayOfWeek.WEDNESDAY);
        user.setWordays(daylist);
        user.setPermission(Permission.Admin);
        return user;
        // **************************

    }

    public ArrayList<Subject> get_subjects(){
        // Dummy Code *****************************
        ArrayList<Subject> lst = new ArrayList<>();
        for(int i=0;i<10;i++){
            Subject subject = new Subject();
            subject.setName("Subject no " + i);
            subject.setNameInArabic("المادة رقم " + i);
            subject.setSubjectId("sdfr45");
            subject.setType(SubjectType.Finished);
            subject.setNumberOfSectionsApplied(4);
            subject.setNumberOfSectionsPractical(7);
            lst.add(subject);
        }
        return lst;

        // **********************************
    }



}
