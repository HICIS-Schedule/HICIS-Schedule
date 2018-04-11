package csc.colleguescheduller.Views.Entry_Views.TeachingInfo;

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


public class Subject_listview_Adapter extends ArrayAdapter<Subject> {
    private TeachingInfo_Fragment teachinginfo;
    private ActivitytoFragment_interface activity;

    public Subject_listview_Adapter(TeachingInfo_Fragment profile_fragment, @NonNull Context context, ArrayList<Subject> lst) {
        super(context, R.layout.profile_listitem, lst);
        this.teachinginfo = profile_fragment;
        activity = (ActivitytoFragment_interface)context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from((Context) activity).inflate(R.layout.profile_listitem, parent, false);
        ((TextView) convertView.findViewById(R.id.profile_listitem_txtv)).setText(getItem(position).getName());
        final Subject item = getItem(position);
        (convertView.findViewById(R.id.profile_listitem_btn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teachinginfo.remove_subject(item);
            }
        });
        activity.set_font((ViewGroup) convertView);
        activity.set_animation((ViewGroup) convertView);
        return convertView;
    }
}
