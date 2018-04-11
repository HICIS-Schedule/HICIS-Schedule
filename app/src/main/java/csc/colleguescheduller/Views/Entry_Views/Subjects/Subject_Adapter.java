package csc.colleguescheduller.Views.Entry_Views.Subjects;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import csc.colleguescheduller.Models.Subjects.Subject;
import csc.colleguescheduller.R;
import csc.colleguescheduller.Views.ActivitytoFragment_interface;

public class Subject_Adapter extends ArrayAdapter<Subject> {

    ActivitytoFragment_interface activity;

    public Subject_Adapter(ActivitytoFragment_interface c, ArrayList<Subject> subjects) {
        super((Context) c, R.layout.databasemanage_listitem, subjects);
        activity = c;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.databasemanage_listitem, parent, false);
        ((TextView) v.findViewById(R.id.databasemanage_listitem_txtv)).setText(getItem(position).getName());
        activity.set_font((ViewGroup) v);
        return v;
    }
}
