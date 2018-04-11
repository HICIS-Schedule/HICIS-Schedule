package csc.colleguescheduller.Controllers.CollectingInformation;

import android.os.Handler;

import csc.colleguescheduller.Controllers.Controller;
import csc.colleguescheduller.Views.CollectingInformation.CollectingInfomation_interface;


public class CollectingInformation_Controller extends Controller {
    CollectingInfomation_interface UI;

    public CollectingInformation_Controller(CollectingInfomation_interface UI) {
        super();
        this.UI = UI;
    }

    public void checkCollectingInformation() {
        /*
        Required to fill
         */

    }

    @Override
    public void Abort_Thread() {

    }
}
