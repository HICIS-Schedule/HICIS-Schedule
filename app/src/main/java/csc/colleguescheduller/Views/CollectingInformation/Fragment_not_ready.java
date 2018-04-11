package csc.colleguescheduller.Views.CollectingInformation;

/*
Mohamed Mostafa Mohamed
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import csc.colleguescheduller.Controllers.CollectingInformation.CollectingInformation_Controller;
import csc.colleguescheduller.R;
import csc.colleguescheduller.Views.ActivitytoFragment_interface;
import csc.colleguescheduller.Views.MyFragment;

public class Fragment_not_ready extends MyFragment {
    CollectingInformation_Controller controller;
    public Fragment_not_ready() {
    }

    public Fragment_not_ready(ActivitytoFragment_interface activity) {
         super(activity);
     }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.collectinginformation_fragment_not_ready, container, false);

        activity.set_animation(v);
        activity.set_font(v);


        return v;
    }

    public void btn_CollectingFragment_LogOut(View v)
    {
        controller.Logout();
        activity.onBackPressed();
    }
}
