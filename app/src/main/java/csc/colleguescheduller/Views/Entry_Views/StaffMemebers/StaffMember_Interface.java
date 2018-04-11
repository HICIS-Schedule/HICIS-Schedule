package csc.colleguescheduller.Views.Entry_Views.StaffMemebers;


import csc.colleguescheduller.Views.MyInterface;

public interface StaffMember_Interface extends MyInterface {
    void on_process_failed(String Message);
    void add_remove_success();
    void edit_success();
}
