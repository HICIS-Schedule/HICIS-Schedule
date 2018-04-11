package csc.colleguescheduller.Views.Entry_Views.StaffMemebers;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import csc.colleguescheduller.Models.Users.StaffMember;
import csc.colleguescheduller.R;
import csc.colleguescheduller.Views.ActivitytoFragment_interface;
import csc.colleguescheduller.Views.Entry_Views.Entry_Fragment;
import csc.colleguescheduller.Views.Main.Main_Activity;
import csc.colleguescheduller.Views.MyFragment;
import csc.colleguescheduller.Views.Entry_Views.TeachingInfo.TeachingInfo_Fragment;


public class TeachinInfo_Edit_Fragment extends Entry_Fragment {

    private StaffMember user;

    public TeachinInfo_Edit_Fragment() {
    }

    public TeachinInfo_Edit_Fragment(ActivitytoFragment_interface activity, StaffMember user, MyFragment previous) {
        super(activity, Main_Activity.TEACHING_INFO_TITLE, previous);
        this.user = user;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.staffmember_edit_teachinginfo_layout,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        getFragmentManager().beginTransaction().replace(R.id.staffmember_edit_teachinginfo_fragment,new TeachingInfo_Fragment(activity,user,this)).commit();
        super.onViewCreated(view, savedInstanceState);
    }
}
