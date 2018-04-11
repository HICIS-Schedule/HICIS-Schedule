package csc.colleguescheduller.Views.SignIn;

/*
Ahmed Mokhtar Hassanin
 */

import csc.colleguescheduller.Views.MyInterface;

public interface SignIn_Interface extends MyInterface {

    void on_userpassword_error(String message);
    void on_success();

    /*
        NOTE :-
            this Interface extends MyInterface Which Contains the Function on_connection_error()
            So This Interface Contains This Function As Well So Every Future Interface To Be Made
     */
}
