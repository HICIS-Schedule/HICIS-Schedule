package csc.colleguescheduller.Views.Entry_Views.Subjects;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;

import csc.colleguescheduller.Models.Subjects.Subject;
import csc.colleguescheduller.Models.Subjects.SubjectType;
import csc.colleguescheduller.R;
import csc.colleguescheduller.Views.ActivitytoFragment_interface;
import csc.colleguescheduller.Views.Entry_Views.Entry_Fragment;
import csc.colleguescheduller.Views.Entry_Views.Enum_Adapter;
import csc.colleguescheduller.Views.Main.Main_Activity;
import csc.colleguescheduller.Views.MyFragment;

public class Subject_Edit_Fragment extends Entry_Fragment {

    Subject subject;

    public Subject_Edit_Fragment() {
        super();
    }

    public Subject_Edit_Fragment(ActivitytoFragment_interface activity, Subject subject, MyFragment previous) {
        this(activity, previous);
        this.subject = subject;
    }

    public Subject_Edit_Fragment(ActivitytoFragment_interface activity, MyFragment previous) {
        super(activity, Main_Activity.SUBJECT_EDIT_TITLE, previous);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.editsubject_fragment,container,false);
    }

    @Override
    protected void apply_model() {
        if(subject == null)return;
        View v = getView();
        ((EditText)v.findViewById(R.id.edit_subject_txe_id)).setText(subject.getSubjectId());
        ((EditText)v.findViewById(R.id.edit_subject_txe_name)).setText(subject.getName());
        ((EditText)v.findViewById(R.id.edit_subject_txe_nameinarabic)).setText(subject.getNameInArabic());
        Spinner spinner = v.findViewById(R.id.addsubject_sort_by_spinner);
        spinner.setAdapter(new Enum_Adapter<>((Context)activity, SubjectType.values()));
        spinner.setSelection(subject.getType().ordinal());
        ((EditText)v.findViewById(R.id.edit_subject_txe_nosectionpractical)).setText(subject.getNumberOfSectionsPractical() + "");
        ((EditText)v.findViewById(R.id.edit_subject_txe_noofsectionstraining)).setText(subject.getNumberOfSectionsApplied() + "");

    }
}
