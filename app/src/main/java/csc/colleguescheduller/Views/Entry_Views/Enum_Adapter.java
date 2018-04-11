package csc.colleguescheduller.Views.Entry_Views;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Enum_Adapter<T> extends ArrayAdapter<T> {
    public Enum_Adapter(@NonNull Context context, T[] s) {
        super(context, android.R.layout.simple_spinner_dropdown_item,s);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_spinner_dropdown_item,parent,false);
        ((TextView)v.findViewById(android.R.id.text1)).setText(getItem(position).toString());
        return v;
    }
}
