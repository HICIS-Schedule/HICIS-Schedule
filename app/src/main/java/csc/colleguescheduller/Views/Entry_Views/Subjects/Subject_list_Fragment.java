package csc.colleguescheduller.Views.Entry_Views.Subjects;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import csc.colleguescheduller.Controllers.Controller;
import csc.colleguescheduller.Models.Subjects.Subject;
import csc.colleguescheduller.Views.ActivitytoFragment_interface;
import csc.colleguescheduller.Views.Main.Main_Activity;
import csc.colleguescheduller.Views.MyFragment;


public class Subject_list_Fragment extends MyFragment {

    Controller controller;

    public Subject_list_Fragment() {
        super();
    }

    public Subject_list_Fragment(ActivitytoFragment_interface activity, MyFragment previous) {
        super(activity, Main_Activity.SUBJECTS_LIST_TITLE, previous);
        controller = new Controller();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final ListView list = new ListView((Context)activity);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                open_subject((Subject) list.getItemAtPosition(i));
            }
        });
        return list;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        refresh_list();
    }

    private void refresh_list(){
        ((ListView)getView()).setAdapter(new Subject_Adapter(activity,controller.get_subjects()));
    }

    private void open_subject(Subject subject){
        activity.move_to_fragment(new Subject_View_Fragment(activity,subject,this));
    }
}
