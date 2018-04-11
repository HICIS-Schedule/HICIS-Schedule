package csc.colleguescheduller.Views.Entry_Views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import csc.colleguescheduller.Views.ActivitytoFragment_interface;
import csc.colleguescheduller.Views.MyFragment;


public abstract class Entry_Fragment extends MyFragment {

    public Boolean Asking = false;
    public Boolean RequiredToSave = false;
    public MyFragment targetfragment_onhold;

    public Entry_Fragment() {
        super();
    }

    public Entry_Fragment(ActivitytoFragment_interface activity){
        super(activity);
    }

    public Entry_Fragment(ActivitytoFragment_interface activity, String title, MyFragment previous) {
        super(activity, title, previous);
    }

    public Entry_Fragment(ActivitytoFragment_interface activity, String title) {
        super(activity, title);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apply_model();
        set_buttons();

    }

    protected void apply_model(){

    }

    protected void set_buttons(){

    }

    public void Save(){

    }

    public void on_askmessage_result(Boolean result){
        if(result){
            Save();
            activity.move_to_fragment(targetfragment_onhold);
        }else{
            RequiredToSave = false;
            activity.move_to_fragment(targetfragment_onhold);
        }
    }

}
