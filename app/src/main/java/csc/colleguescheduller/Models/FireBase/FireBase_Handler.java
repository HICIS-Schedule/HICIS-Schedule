package csc.colleguescheduller.Models.FireBase;

/*
Ahmed Mokhtar Hassanin
Majed Seif El Nasr
 */

import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;

public class FireBase_Handler {
    /*
        Required To Be Filled
     */

    private FirebaseAuth authentication_manager;

    public FireBase_Handler(){
        authentication_manager = FirebaseAuth.getInstance();
    }

    public FirebaseAuth get_AuthenticationManager() {
        return authentication_manager;
    }

    public Calendar get_Subject_Register_Date(){
        /*
            connect to the database and get Subject_Register_Date;

            This is a dummy function until the database is created
         */
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH,16);
        return c;
    }
}
