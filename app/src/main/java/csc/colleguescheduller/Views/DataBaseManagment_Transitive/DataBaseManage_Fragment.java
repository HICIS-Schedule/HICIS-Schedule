package csc.colleguescheduller.Views.DataBaseManagment_Transitive;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import csc.colleguescheduller.R;
import csc.colleguescheduller.Views.ActivitytoFragment_interface;
import csc.colleguescheduller.Views.Main.Main_Activity;
import csc.colleguescheduller.Views.MyFragment;
import csc.colleguescheduller.Views.Entry_Views.Subjects.Subject_list_Fragment;


public class DataBaseManage_Fragment extends MyFragment {

    public DataBaseManage_Fragment(){

    }

    public DataBaseManage_Fragment(ActivitytoFragment_interface activity,MyFragment previous){
        super(activity, Main_Activity.DATABASE_MANAGMENT_TITLE,previous);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.databasemanagme_layout,container,false);
        v.findViewById(R.id.databasemanage_btn_subjects).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToSubjcts();
            }
        });
        return v;
    }

    public void goToSubjcts()
    {
        activity.move_to_fragment(new Subject_list_Fragment(activity,this));

    }

    public void goToHallsAndLaps()
    {
        //activity.move_to_fragment(new HallsAndLaps_Fragment(activity));

    }
}
