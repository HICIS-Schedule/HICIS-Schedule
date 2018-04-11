package csc.colleguescheduller.Models.Globals;

/*
Ahmed Mokhtar Hassanin
 */

import csc.colleguescheduller.Controllers.Controller;
import csc.colleguescheduller.Models.FireBase.FireBase_Handler;
import csc.colleguescheduller.Models.Users.StaffMember;

public class Session {
    public StaffMember user = null;
    public FireBase_Handler fireBase_handler;
    public Session(){
        fireBase_handler = new FireBase_Handler();
    }
}
