package csc.colleguescheduller.Controllers.StaffMembers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

import csc.colleguescheduller.Controllers.Controller;
import csc.colleguescheduller.Models.Users.HiringDegree;
import csc.colleguescheduller.Models.Users.HiringType;
import csc.colleguescheduller.Models.Users.SciDegree;
import csc.colleguescheduller.Models.Users.SciDepartment;
import csc.colleguescheduller.Models.Users.StaffMember;
import csc.colleguescheduller.Views.Entry_Views.StaffMemebers.StaffMember_Interface;

public class Staffmemebers_Controller extends Controller {

    private StaffMember_Interface UI;

    public Staffmemebers_Controller(StaffMember_Interface UI) {
        super();
        this.UI = UI;
    }

    public ArrayList<StaffMember> get_staffmembers(HiringType hiringType, HiringDegree hiringDegree){
        //Dummy Code ***************************************

        ArrayList<StaffMember> lst = new ArrayList<>();

        for(int i = 0;i<6;i++){
            StaffMember tmp = new StaffMember();
            tmp.setMemberName("Mostafa Khairy " + i);
            tmp.setHiringType(hiringType);
            tmp.setHiringDegree(hiringDegree);
            tmp.setScientificDegree(SciDegree.Professor_Dr);
            tmp.setAccessCode("knasnasd");
            tmp.setWorkHours(5);
            tmp.setScientificDepartment(SciDepartment.Information_System);
            Calendar c = Calendar.getInstance();
            c.set(2012,4,23);
            tmp.setHiringDate(c.getTime());
            tmp.setMemberId("sdfmaksdm");
            lst.add(tmp);
        }
         return lst;
        // ***************************************

    }

    public void save_list(ArrayList<StaffMember> list){

    }
}
