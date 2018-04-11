package csc.colleguescheduller.Controllers.Profile;

import android.os.Handler;

import org.threeten.bp.DayOfWeek;

import java.util.ArrayList;
import java.util.Calendar;

import csc.colleguescheduller.Controllers.Controller;
import csc.colleguescheduller.Models.Subjects.Subject;
import csc.colleguescheduller.Models.Users.HiringDegree;
import csc.colleguescheduller.Models.Users.HiringType;
import csc.colleguescheduller.Models.Users.SciDegree;
import csc.colleguescheduller.Models.Users.SciDepartment;
import csc.colleguescheduller.Models.Users.StaffMember;

public class Profile_Controller extends Controller {

    public Profile_Controller() {
        super();
    }

    public void send_updates(StaffMember user) {

    }
    public StaffMember get_user(){
        // Dummy Code **********************************
        StaffMember tmp = new StaffMember();
        tmp.setMemberName("Mostafa Khairy ");
        tmp.setHiringType(HiringType.Full_Time);
        tmp.setHiringDegree(HiringDegree.Lecturer);
        tmp.setScientificDegree(SciDegree.Professor_Dr);
        tmp.setAccessCode("knasnasd");
        tmp.setWorkHours(5);
        tmp.setScientificDepartment(SciDepartment.Information_System);
        Calendar c = Calendar.getInstance();
        c.set(2012,4,23);
        tmp.setHiringDate(c.getTime());
        tmp.setMemberId("sdfmaksdm");
        tmp.getWordays().add(DayOfWeek.THURSDAY);
        tmp.getWordays().add(DayOfWeek.WEDNESDAY);
        for(int i=0;i<5;i++){
            tmp.getTeachingSubjects().add(new Subject("Subject no " + i));
        }

        return tmp;

        // **********************************
    }

}
