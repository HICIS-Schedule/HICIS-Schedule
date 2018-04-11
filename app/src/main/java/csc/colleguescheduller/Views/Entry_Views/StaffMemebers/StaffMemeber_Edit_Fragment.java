package csc.colleguescheduller.Views.Entry_Views.StaffMemebers;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.text.SimpleDateFormat;

import csc.colleguescheduller.Controllers.StaffMembers.Staffmemebers_Controller;
import csc.colleguescheduller.Models.Users.SciDegree;
import csc.colleguescheduller.Models.Users.SciDepartment;
import csc.colleguescheduller.Models.Users.StaffMember;
import csc.colleguescheduller.R;
import csc.colleguescheduller.Views.ActivitytoFragment_interface;
import csc.colleguescheduller.Views.Entry_Views.Entry_Fragment;
import csc.colleguescheduller.Views.Entry_Views.Enum_Adapter;
import csc.colleguescheduller.Views.Main.Main_Activity;
import csc.colleguescheduller.Views.MyFragment;

public class StaffMemeber_Edit_Fragment extends Entry_Fragment implements StaffMember_Interface {

    private StaffMember staffmember;
    Staffmemebers_Controller controller;

    public StaffMemeber_Edit_Fragment() {
    }

    public StaffMemeber_Edit_Fragment(ActivitytoFragment_interface activity, StaffMember user, MyFragment previous) {
        super(activity,Main_Activity.STAFFMEMBER_Edit_TITLE, previous);
        this.staffmember = user;
    }
    public StaffMemeber_Edit_Fragment(ActivitytoFragment_interface activity, MyFragment previous) {
        super(activity, Main_Activity.STAFFMEMBER_ADD_TITLE, previous);
        controller = new Staffmemebers_Controller(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.staffmember_edit_layout,container,false);
        v.findViewById(R.id.staffmember_edit_btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Save();
            }
        });
        if(staffmember == null){
            ((Button)v.findViewById(R.id.staffmember_edit_btn_submit)).setText("ADD");
        }else{
            apply_model(v);
        }
        TextWatcher textWatcher = new TextWatcher() {
            String before = "";
            String after = "";
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                before = charSequence.toString();
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!before.equals(after)) {
                    RequiredToSave = true;
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                after = editable.toString();
            }
        };
        ((EditText)v.findViewById(R.id.staffmember_edit_txte_id)).addTextChangedListener(textWatcher);
        ((EditText)v.findViewById(R.id.staffmember_edit_txte_accesscode)).addTextChangedListener(textWatcher);
        ((EditText)v.findViewById(R.id.staffmember_edit_txte_fullname)).addTextChangedListener(textWatcher);
        ((EditText)v.findViewById(R.id.staffmember_edit_txte_workours)).addTextChangedListener(textWatcher);
        ((EditText)v.findViewById(R.id.staffmember_edit_txte_hiringdate)).addTextChangedListener(textWatcher);

        return v;
    }
    private void apply_model(View v){
        ((EditText)v.findViewById(R.id.staffmember_edit_txte_id)).setText(staffmember.getMemberId());
        ((EditText)v.findViewById(R.id.staffmember_edit_txte_accesscode)).setText(staffmember.getAccessCode());
        ((EditText)v.findViewById(R.id.staffmember_edit_txte_fullname)).setText(staffmember.getMemberName());

        Spinner spinner = v.findViewById(R.id.staffmember_edit_spinner_scidegree);
        spinner.setAdapter(new Enum_Adapter<>((Context)activity,SciDegree.values()));
        spinner.setSelection(staffmember.getScientificDegree().ordinal());

        spinner = v.findViewById(R.id.staffmember_edit_spinner_scidepartment);
        spinner.setAdapter(new Enum_Adapter<>((Context)activity,SciDepartment.values()));
        spinner.setSelection(staffmember.getScientificDepartment().ordinal());

        ((EditText)v.findViewById(R.id.staffmember_edit_txte_workours)).setText(staffmember.getWorkHours() + "");
        ((EditText)v.findViewById(R.id.staffmember_edit_txte_hiringdate)).setText((new SimpleDateFormat("dd/mm/yyyy")).format(staffmember.getHiringDate()));

    }

    @Override
    public void Save() {
        RequiredToSave = false;
        /*

         */
        activity.onBackPressed();
    }

    @Override
    public void on_connection_error() {
        activity.abort_connection(new View(null));
    }

    @Override
    public void on_process_failed(String Message) {
        activity.abort_connection(new View((Context)activity));
        activity.show_message("Save Failed",R.drawable.ic_change_password);
    }

    @Override
    public void add_remove_success() {

    }

    @Override
    public void edit_success() {
        activity.abort_connection(new View((Context)activity));
        activity.move_to_fragment(targetfragment_onhold);
    }
}
