package csc.colleguescheduller.Views.StaffManagment_Transitive;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import csc.colleguescheduller.Models.Users.HiringDegree;
import csc.colleguescheduller.Models.Users.HiringType;
import csc.colleguescheduller.R;
import csc.colleguescheduller.Views.ActivitytoFragment_interface;
import csc.colleguescheduller.Views.Main.Main_Activity;
import csc.colleguescheduller.Views.MyFragment;
import csc.colleguescheduller.Views.Entry_Views.StaffMemebers.StaffMember_list_Fragment;


public class StaffManagment_Fragment extends MyFragment {

    public StaffManagment_Fragment(){

    }

    public StaffManagment_Fragment(ActivitytoFragment_interface activity,MyFragment previous){
        super(activity, Main_Activity.STAFF_CATEGORIES_TITLE,previous);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.staffmembers_transitive,container,false);
        set_navigation(v);
        return v;
    }

    private void set_navigation(View v){
        v.findViewById(R.id.staffmembers_transitive_btn_lecturerfulltime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigate(HiringType.Full_Time,HiringDegree.Lecturer);
            }
        });
        v.findViewById(R.id.staffmembers_transitive_btn_lecturerparttime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigate(HiringType.Part_Time,HiringDegree.Lecturer);
            }
        });
        v.findViewById(R.id.staffmembers_transitive_btn_assissatntfulltime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigate(HiringType.Full_Time,HiringDegree.Assisstant);
            }
        });
        v.findViewById(R.id.staffmembers_transitive_btn_assisstantparttime).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navigate(HiringType.Part_Time,HiringDegree.Assisstant);
            }
        });
    }

    private void navigate(HiringType hiringType,HiringDegree hiringDegree){
        activity.move_to_fragment(new StaffMember_list_Fragment(activity, hiringType, hiringDegree,this));
    }
}