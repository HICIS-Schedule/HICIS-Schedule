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


public class Subject_Spinner_Adapter extends ArrayAdapter<Subject> {

    ActivitytoFragment_interface activity;

    public Subject_Spinner_Adapter(Context context,ArrayList<Subject> s){
        super(context,android.R.layout.simple_spinner_dropdown_item,s);
        Subject subject = new Subject();
        subject.setName("Select Subject");
        s.add(0,subject);
        activity = (ActivitytoFragment_interface) context;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView = LayoutInflater.from((Context) activity).inflate(R.layout.profile_spinneritem,parent,false);
        ((TextView)convertView.findViewById(R.id.profile_spinneritem_txtv)).setText(getItem(position).getName());
        activity.set_font((ViewGroup) convertView);
        activity.set_animation((ViewGroup)convertView);
        return convertView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return getDropDownView(position,convertView,parent);
    }
}