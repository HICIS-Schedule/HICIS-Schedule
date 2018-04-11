package csc.colleguescheduller.Views.Entry_Views.Profile;

/*
Ahmed Mokhtar Hassanin
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import csc.colleguescheduller.Controllers.Profile.Profile_Controller;
import csc.colleguescheduller.Models.Users.StaffMember;
import csc.colleguescheduller.R;
import csc.colleguescheduller.Views.ActivitytoFragment_interface;
import csc.colleguescheduller.Views.Entry_Views.Entry_Fragment;
import csc.colleguescheduller.Views.Entry_Views.TeachingInfo.TeachingInfo_Fragment;
import csc.colleguescheduller.Views.Main.Main_Activity;

public class Profile_Fragment extends Entry_Fragment {

    private Profile_Controller controller;
    private StaffMember user;
    private TeachingInfo_Fragment teachingInfo;

    public Profile_Fragment() {
        super();
    }

    public Profile_Fragment(ActivitytoFragment_interface activity) {
        super(activity, Main_Activity.PROFILE_TITLE);
        controller = new Profile_Controller();
        user = controller.get_user();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.profile_layout, container, false);
        set_teachinginfo();
        return v;
    }

    private void set_teachinginfo(){
        teachingInfo = new TeachingInfo_Fragment(activity,user,this);
        getFragmentManager().beginTransaction().replace(R.id.profile_fragment_teachinginfo,teachingInfo).commit();
    }

    @Override
    protected void apply_model() {
        View v = getView();
        ((TextView) v.findViewById(R.id.profile_txtv_username)).setText(user.getMemberId());
        ((TextView) v.findViewById(R.id.profile_txtv_fullname)).setText(user.getMemberName());
        ((TextView) v.findViewById(R.id.profile_txtv_scientificdegree)).setText(user.getScientificDegree().toString().replace("_", " "));
        ((TextView) v.findViewById(R.id.profile_txtv_hiringdegree)).setText(user.getHiringDegree().toString().replace("_", " "));
        ((TextView) v.findViewById(R.id.profile_txtv_workhours)).setText(user.getWorkHours() + "");
    }

    @Override
    public void Save() {
        super.Save();
    }
}