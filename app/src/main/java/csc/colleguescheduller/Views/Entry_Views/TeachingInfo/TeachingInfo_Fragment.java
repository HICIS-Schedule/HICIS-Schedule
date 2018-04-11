package csc.colleguescheduller.Views.Entry_Views.TeachingInfo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.threeten.bp.DayOfWeek;

import csc.colleguescheduller.Controllers.Controller;
import csc.colleguescheduller.Models.Subjects.Subject;
import csc.colleguescheduller.Models.Users.StaffMember;
import csc.colleguescheduller.R;
import csc.colleguescheduller.Views.ActivitytoFragment_interface;
import csc.colleguescheduller.Views.Entry_Views.Entry_Fragment;
import csc.colleguescheduller.Views.Main.Main_Activity;
import csc.colleguescheduller.Views.MyFragment;

public class TeachingInfo_Fragment extends Entry_Fragment {

    private StaffMember user;
    Controller controller;

    public TeachingInfo_Fragment(){

    }

    public TeachingInfo_Fragment(ActivitytoFragment_interface activity,StaffMember user ,MyFragment previous) {
        super(activity, Main_Activity.TEACHING_INFO_TITLE, previous);
        this.user = user;
        controller = new Controller();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.teachinginfo_layout,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.teachinginfo_btn_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_subject();
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    protected void apply_model() {
        set_days();
        refresh_subjectlist();
        load_spinner();
    }

    private void set_days(){
        View v = getView();
        ViewGroup teaching_subjects_v = v.findViewById(R.id.teachinginfo_lyt_teachingdays);

        for (int i = 0; i < teaching_subjects_v.getChildCount(); i++) {
            TextView txt = (TextView) teaching_subjects_v.getChildAt(i);
            for (DayOfWeek day : user.getWordays()) {
                if (txt.getText().toString().equals(day.toString().toLowerCase().substring(0, 3))) {
                    txt.setBackgroundResource(R.drawable.ic_txt_backgrount);
                }
            }
            txt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    select_workday(view);
                }
            });
        }

    }

    private void refresh_subjectlist() {
        View main_view = getView();
        ListView lst = main_view.findViewById(R.id.teachinginfo_lstv_teachingsubjects);
        lst.setAdapter(new Subject_listview_Adapter(this, (Context)activity,user.getTeachingSubjects()));
    }
    private void load_spinner(){
        View main_view = getView();
        Spinner subject_spinner = main_view.findViewById(R.id.teachinginfo_spinner);
        subject_spinner.setAdapter(new Subject_Spinner_Adapter((Context) activity,controller.get_subjects()));
    }

    void remove_subject(Subject subject) {
       user.getTeachingSubjects().remove(subject);
        refresh_subjectlist();
    }

    private void select_workday(View v){
        DayOfWeek day = DayOfWeek.valueOf((String) v.getTag());
        if(user.getWordays().contains(day)){
            user.getWordays().remove(day);
            v.setBackgroundResource(android.R.color.transparent);
        }else{
            user.getWordays().add(day);
            v.setBackgroundResource(R.drawable.ic_txt_backgrount);
        }
    }

    private void add_subject(){
        Subject subject = (Subject) ((Spinner)getView().findViewById(R.id.teachinginfo_spinner)).getSelectedItem();
        if(!subject.getName().equals("Select Subject")){
            user.getTeachingSubjects().add(subject);
            refresh_subjectlist();
        }
    }
}
