package csc.colleguescheduller.Views.CollectingInformation;

/*
Mohamed Mostafa Mohamed
 */

import java.util.Calendar;
import java.util.Date;

import csc.colleguescheduller.Views.MyInterface;


public interface CollectingInfomation_interface extends MyInterface {
    void ready();
    void time_Waiting(Calendar date);
    void not_Ready();
}
