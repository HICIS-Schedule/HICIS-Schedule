package csc.colleguescheduller.Views.Entry_Views.Subjects;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import csc.colleguescheduller.Models.Subjects.Subject;
import csc.colleguescheduller.R;
import csc.colleguescheduller.Views.ActivitytoFragment_interface;
import csc.colleguescheduller.Views.Entry_Views.Entry_Fragment;
import csc.colleguescheduller.Views.Main.Main_Activity;
import csc.colleguescheduller.Views.MyFragment;

public class Subject_View_Fragment extends Entry_Fragment {

    private Subject subject;

    public Subject_View_Fragment() {
        super();
    }

    public Subject_View_Fragment(ActivitytoFragment_interface activity, Subject subject, MyFragment previous) {
        super(activity, Main_Activity.SUBJECTS_DETAILED_TITLE, previous);
        this.subject = subject;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.subject_detailed,container,false);
    }

    @Override
    protected void apply_model(){
        View v = getView();
        ((TextView) v.findViewById(R.id.subject_detailed_id_txt)).setText(subject.getSubjectId());
        ((TextView)v.findViewById(R.id.subject_detailed_name_txt)).setText(subject.getName());
        ((TextView)v.findViewById(R.id.subject_detailed_name_in_arabic_txt)).setText(subject.getNameInArabic());
        ((TextView)v.findViewById(R.id.subject_detailed_type_txt)).setText(subject.getType().toString());
        ((TextView)v.findViewById(R.id.subject_detailed_no_of_sections_practical_txt)).setText(subject.getNumberOfSectionsPractical() + "");
        ((TextView)v.findViewById(R.id.subject_detailed_no_of_sections_training_txt)).setText(subject.getNumberOfSectionsApplied() + "");
    }

    @Override
    protected void set_buttons() {
        ImageButton btn1 = new ImageButton((Context)activity);
        btn1.setImageResource(R.drawable.ic_delete);
        btn1.setBackgroundResource(android.R.color.transparent);

        ImageButton btn2 = new ImageButton((Context)activity);
        btn2.setImageResource(R.drawable.ic_edit);
        btn2.setBackgroundResource(android.R.color.transparent);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edit();
            }
        });

        activity.set_buttons(btn2,btn1);

    }

    private void edit(){
        activity.move_to_fragment(new Subject_Edit_Fragment(activity,subject,this));
    }
}
