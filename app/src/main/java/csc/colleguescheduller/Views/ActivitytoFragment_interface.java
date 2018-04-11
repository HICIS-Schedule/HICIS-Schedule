package csc.colleguescheduller.Views;

/*
Ahmed Mokhtar Hassanin
 */

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public interface ActivitytoFragment_interface extends Message_interface {
    void set_animation(ViewGroup viewGroup);
    void set_font(ViewGroup main_view);
    void set_controls_enability(Boolean value, ViewGroup viewGroup);
    void move_to_fragment(MyFragment fragment);
    void onBackPressed();
    void set_buttons(ImageButton btn2, ImageView btn1);
    void show_askmessage(MyFragment target);
    void on_connecting();
    void abort_connection(View v);
}