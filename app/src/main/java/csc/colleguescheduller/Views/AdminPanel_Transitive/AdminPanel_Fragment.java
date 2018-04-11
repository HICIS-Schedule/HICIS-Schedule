package csc.colleguescheduller.Views.AdminPanel_Transitive;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import csc.colleguescheduller.R;
import csc.colleguescheduller.Views.ActivitytoFragment_interface;
import csc.colleguescheduller.Views.DataBaseManagment_Transitive.DataBaseManage_Fragment;
import csc.colleguescheduller.Views.Main.Main_Activity;
import csc.colleguescheduller.Views.MyFragment;
import csc.colleguescheduller.Views.StaffManagment_Transitive.StaffManagment_Fragment;


public class AdminPanel_Fragment extends MyFragment {

    public AdminPanel_Fragment(){

    }

    public AdminPanel_Fragment(ActivitytoFragment_interface activity){
        super(activity, Main_Activity.ADMIN_PANEL_TITLE);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.adminpanel_layout,container,false);
        v.findViewById(R.id.adminpanel_btn_databasemanagment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToDataBaseManagment();
            }
        });
        v.findViewById(R.id.adminpanel_btn_staffmanagment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToStaffManage();
            }
        });
        return v;
    }

    public void goToDataBaseManagment()
    {
       activity.move_to_fragment(new DataBaseManage_Fragment(activity,this));
    }

    public void goToSchudleMange(View v)
    {
        //activity.move_to_fragment(new ScheduleManage_Fragment(activity));
    }

    public void goToStaffManage()
    {
        activity.move_to_fragment(new StaffManagment_Fragment(activity,this));
    }

    public void goToReportsSchedule(View v)
    {
        //activity.move_to_fragment(new ReportsSchedule_Fragment(activity));
    }

    public void goToEnapleSystem(View v)
    {
        //activity.move_to_fragment(new EnableSystem_Fragment(activity));
    }

}
