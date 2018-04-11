package csc.colleguescheduller.Views.Main;

/*
Ahmed Mokhtar Hassanin
 */

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import csc.colleguescheduller.Controllers.Controller;
import csc.colleguescheduller.Models.Globals.Globals;
import csc.colleguescheduller.Models.Users.Permission;
import csc.colleguescheduller.Models.Users.StaffMember;
import csc.colleguescheduller.R;
import csc.colleguescheduller.Views.ActivitytoFragment_interface;
import csc.colleguescheduller.Views.AdminPanel_Transitive.AdminPanel_Fragment;
import csc.colleguescheduller.Views.Entry_Views.Entry_Fragment;
import csc.colleguescheduller.Views.MyActivity;
import csc.colleguescheduller.Views.MyFragment;
import csc.colleguescheduller.Views.Entry_Views.Profile.Profile_Fragment;

public class Main_Activity extends MyActivity implements ActivitytoFragment_interface {

    Controller controller;

    public static String PROFILE_TITLE = "Profile";
    public static String ACADEMIC_SCHEDULE_TITLE = "Academic Schedule";
    public static String ADMIN_PANEL_TITLE = "Admin Panel";
    public static String CHANGE_PASSWORD_TITLE = "Change Password";
    public static String DATABASE_MANAGMENT_TITLE = "Database Managment";
    public static String STAFF_CATEGORIES_TITLE = "Staff Managment";
    public static String STAFFMEMBER_DETAIL_TITLE = "Member Detailed";
    public static String STAFFMEMBER_Edit_TITLE = "Edit Member";
    public static String STAFFMEMBER_ADD_TITLE = "Add Member";
    public static String TEACHING_INFO_TITLE = "Teaching Info";
    public static String SUBJECTS_LIST_TITLE = "Subjects";
    public static String SUBJECTS_DETAILED_TITLE = "Subject Detailed";
    public static String SUBJECT_EDIT_TITLE = "Edit Subject";

    private MyFragment current_fragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        controller = new Controller();
        set_navigation();
        set_animation();
        set_font();
        move_to_fragment(new Profile_Fragment(this));
    }

    private void set_navigation() {
        StaffMember user = controller.get_user();
        ((TextView) findViewById(R.id.mainview_nav_txtv_username)).setText(user.getMemberName());
        ((TextView) findViewById(R.id.mainview_nav_txtv_degree)).setText(user.getPermission().toString());
        add_nav_item(ACADEMIC_SCHEDULE_TITLE, R.drawable.ic_schedule);
        if (user.getPermission() == Permission.Assistant) {

        }
        if (user.getPermission() == Permission.Admin) {
            add_nav_item(ADMIN_PANEL_TITLE, R.drawable.ic_admin_panel);
        }
        add_nav_item(CHANGE_PASSWORD_TITLE, R.drawable.ic_change_password);
    }

    private void add_nav_item(String label, @DrawableRes int icon) {
        LinearLayout list = findViewById(R.id.mainview_nav_list);
        View v = getLayoutInflater().inflate(R.layout.main_nav_item, null);
        ((TextView) v.findViewById(R.id.mainview_nav_item_txtv)).setText(label);
        ((ImageView) v.findViewById(R.id.mainview_nav_item_imgv)).setImageResource(icon);
        list.addView(v);
    }

    public void navigate(View v) {
        if (current_fragment.previous != null) {
            move_to_fragment(current_fragment.previous);
        } else {
            ((DrawerLayout) findViewById(R.id.mainview)).openDrawer(Gravity.START);
        }

    }

    @Override
    public void move_to_fragment(MyFragment fragment) {
        if(current_fragment != null && current_fragment instanceof Entry_Fragment && fragment.previous != current_fragment){
            if(((Entry_Fragment)current_fragment).RequiredToSave && !((Entry_Fragment)current_fragment).Asking){
                show_askmessage(fragment);
            }else if(!((Entry_Fragment)current_fragment).Asking){
                move_to_fragment_(fragment);
            }
        }else{
            move_to_fragment_(fragment);
        }
    }
    private void move_to_fragment_(MyFragment fragment){
        clear_btns();
        ((TextView) findViewById(R.id.mainview_txtv_title)).setText(fragment.title);
        getFragmentManager().beginTransaction().replace(R.id.mainview_fragment, fragment).commit();
        current_fragment = fragment;
        if (fragment.previous != null) {
            ((ImageView) findViewById(R.id.mainview_btn_nav)).setImageResource(R.drawable.ic_back);
        } else {
            ((ImageView) findViewById(R.id.mainview_btn_nav)).setImageResource(R.drawable.ic_menu);
        }
    }

    private void clear_btns() {
        FrameLayout layout = findViewById(R.id.mainview_fragment_btn1);
        layout.removeAllViews();
        layout.setVisibility(View.GONE);
        layout = findViewById(R.id.mainview_fragment_btn2);
        layout.removeAllViews();
        layout.setVisibility(View.GONE);
    }

    public void nav_item_click(View v) {
        ((DrawerLayout) findViewById(R.id.mainview)).closeDrawer(Gravity.START);
        if (v.getId() == R.id.main_nav_profile) {
            move_to_fragment(new Profile_Fragment(this));
        } else {
            String target = ((TextView) v.findViewById(R.id.mainview_nav_item_txtv)).getText().toString();
            if (target.equals(ACADEMIC_SCHEDULE_TITLE)) {

            } else if (target.equals(ADMIN_PANEL_TITLE)) {
                move_to_fragment(new AdminPanel_Fragment(this));
            } else if (target.equals(CHANGE_PASSWORD_TITLE)) {

            }
        }

    }

    @Override
    public void set_buttons(ImageButton btn2, ImageView btn1) {
        clear_btns();
        FrameLayout layout_btn1 = findViewById(R.id.mainview_fragment_btn1);
        FrameLayout layout_btn2 = findViewById(R.id.mainview_fragment_btn2);
        if (btn1 != null) {
            layout_btn1.setVisibility(View.VISIBLE);
            layout_btn1.addView(btn1);
            set_animation(layout_btn1);
        }
        if (btn2 != null) {
            layout_btn2.setVisibility(View.VISIBLE);
            layout_btn2.addView(btn2);
            set_animation(layout_btn2);
        }
    }

    @Override
    public void onBackPressed() {
        if (current_fragment.previous != null) {
            move_to_fragment(current_fragment.previous);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public void show_askmessage(MyFragment target) {
        ((Entry_Fragment)current_fragment).Asking = true;
        View message = getLayoutInflater().inflate(R.layout.message_layout, null, false);
        message.findViewById(R.id.message_btn_retry).setVisibility(View.GONE);
        message.findViewById(R.id.message_lyt_ask).setVisibility(View.VISIBLE);
        message.findViewById(R.id.message_btn_retry);
        get_main_view().addView(message);
        ((Entry_Fragment)current_fragment).targetfragment_onhold = target;
    }

    @Override
    public void hide_message() {
        super.hide_message();
        ((Entry_Fragment)current_fragment).Asking = false;
    }

    public void on_messageresult(View v) {
        hide_message();
        ((Entry_Fragment)current_fragment).on_askmessage_result(((TextView) v).getText().toString().equals("YES"));
    }
}
