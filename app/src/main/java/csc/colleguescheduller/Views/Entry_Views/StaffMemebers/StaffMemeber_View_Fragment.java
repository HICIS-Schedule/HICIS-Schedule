package csc.colleguescheduller.Views.Entry_Views.StaffMemebers;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import csc.colleguescheduller.Models.Users.StaffMember;
import csc.colleguescheduller.R;
import csc.colleguescheduller.Views.ActivitytoFragment_interface;
import csc.colleguescheduller.Views.Entry_Views.Entry_Fragment;
import csc.colleguescheduller.Views.Main.Main_Activity;
import csc.colleguescheduller.Views.MyFragment;

public class StaffMemeber_View_Fragment extends Entry_Fragment {

    private StaffMember staffmember;

    public StaffMemeber_View_Fragment() {
    }

    public StaffMemeber_View_Fragment(ActivitytoFragment_interface activity,StaffMember staffmember ,MyFragment previous) {
        super(activity, Main_Activity.STAFFMEMBER_DETAIL_TITLE, previous);
        this.staffmember = staffmember;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.staffmember_view_layout,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        view.findViewById(R.id.staffmemeber_btn_teachinginfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teachinginfo_click();
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    private void teachinginfo_click(){
        activity.move_to_fragment(new TeachinInfo_Edit_Fragment(activity, staffmember,this));
    }

    @Override
    protected void apply_model(){
        View v = getView();
        ((TextView)v.findViewById(R.id.staffmember_view_txtv_id)).setText(staffmember.getMemberId());
        ((TextView)v.findViewById(R.id.staffmember_view_txtv_accesscode)).setText(staffmember.getAccessCode());
        ((TextView)v.findViewById(R.id.staffmember_view_txtv_fullname)).setText(staffmember.getAccessCode());
        ((TextView)v.findViewById(R.id.staffmember_view_txtv_scidegree)).setText(staffmember.getScientificDegree().toString().replace("_"," "));
        ((TextView)v.findViewById(R.id.staffmember_view_txtv_scidepartment)).setText(staffmember.getScientificDepartment().toString().replace("_"," "));
        ((TextView)v.findViewById(R.id.staffmember_view_txtv_workours)).setText(staffmember.getWorkHours() + " ");
        ((TextView)v.findViewById(R.id.staffmember_view_txtv_hiringdate)).setText((new SimpleDateFormat("dd/mm/yyyy")).format(staffmember.getHiringDate()));

    }

    @Override
    protected void set_buttons(){

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
        activity.move_to_fragment(new StaffMemeber_Edit_Fragment(activity, staffmember,this));
    }

    @Override
    public void Save() {
        RequiredToSave = false;
        ((StaffMember_list_Fragment)previous).RequiredToSave = true;
        staffmember.Unsaved = true;
        activity.onBackPressed();
    }
}
