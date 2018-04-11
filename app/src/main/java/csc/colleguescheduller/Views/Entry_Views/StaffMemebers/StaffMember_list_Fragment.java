package csc.colleguescheduller.Views.Entry_Views.StaffMemebers;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import csc.colleguescheduller.Controllers.StaffMembers.Staffmemebers_Controller;
import csc.colleguescheduller.Models.Users.HiringDegree;
import csc.colleguescheduller.Models.Users.HiringType;
import csc.colleguescheduller.Models.Users.StaffMember;
import csc.colleguescheduller.R;
import csc.colleguescheduller.Views.ActivitytoFragment_interface;
import csc.colleguescheduller.Views.Entry_Views.Entry_Fragment;
import csc.colleguescheduller.Views.MyFragment;

public class StaffMember_list_Fragment extends Entry_Fragment implements StaffMember_Interface {

    private Staffmemebers_Controller controller;
    private HiringType hiringType;
    private HiringDegree hiringDegree;
    private ArrayList<StaffMember> staffMembers;

    public StaffMember_list_Fragment() {
    }

    public StaffMember_list_Fragment(ActivitytoFragment_interface activity, HiringType hiringType, HiringDegree hiringDegree, MyFragment previous) {
        super(activity,
                hiringType.toString().replace("_"," ") + " " + hiringDegree.toString(),
                previous);
        this.hiringType = hiringType;
        this.hiringDegree = hiringDegree;
        controller = new Staffmemebers_Controller(this);
        staffMembers = controller.get_staffmembers(hiringType,hiringDegree);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        final ListView lst = new ListView((Context)activity);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                item_selected((StaffMember) lst.getItemAtPosition(i));
            }
        });
        return lst;
    }

    @Override
    protected void apply_model() {
        ((ListView)getView()).setAdapter(new StaffMemebrs_Adapter((Context)activity,staffMembers,activity));
        for(StaffMember staffMember : staffMembers){
            if(staffMember.Unsaved){
                RequiredToSave = true;
            }
        }
    }

    @Override
    protected void set_buttons() {
        ImageButton btn1 = new ImageButton((Context)activity);
        btn1.setImageResource(R.drawable.ic_add);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
            }
        });
        btn1.setBackgroundResource(android.R.color.transparent);

        ImageButton btn2 = new ImageButton((Context)activity);
        btn2.setImageResource(R.drawable.ic_save);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Save();
            }
        });
        btn2.setBackgroundResource(android.R.color.transparent);
        activity.set_buttons(btn2,btn1);
    }

    private void add(){
        activity.move_to_fragment(new StaffMemeber_Edit_Fragment(activity,this));
    }


    private void item_selected(StaffMember staffMember){
        activity.move_to_fragment(new StaffMemeber_View_Fragment(activity,staffMember,this));
    }

    @Override
    public void on_connection_error() {

    }

    @Override
    public void on_process_failed(String Message) {

    }

    @Override
    public void add_remove_success() {
        staffMembers = controller.get_staffmembers(hiringType,hiringDegree);
        apply_model();
    }

    @Override
    public void edit_success() {

    }

    @Override
    public void Save() {

    }
}
