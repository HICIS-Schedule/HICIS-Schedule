package csc.colleguescheduller.Controllers.SignIn;

/*
Mostafa Gamal
 */

import android.os.Handler;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

import csc.colleguescheduller.Controllers.Controller;
import csc.colleguescheduller.Views.SignIn.SignIn_Interface;

public class SignIn_Controller extends Controller {

    SignIn_Interface UI;

    public SignIn_Controller(SignIn_Interface UI, Handler handler) {
        super();
        this.UI = UI;
    }

    public void SignIn(String username, String password) {

        // check if the user or password are empty

        if(username.equals("")){
            UI.on_userpassword_error("UserName Can't be Empty");
        }else if(password.equals("")){
            UI.on_userpassword_error("Password Can't be Empty");
        }else{

            DB.get_AuthenticationManager().signInWithEmailAndPassword(username, password)
                    .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            UI.on_success();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            if (e instanceof FirebaseAuthInvalidCredentialsException)

                                UI.on_userpassword_error("Username and password not\n" +
                                        "correct. If you still have\n" +
                                        "that error please check\n" +
                                        "system admin");
                            else if (e instanceof FirebaseAuthInvalidUserException) {
                                UI.on_userpassword_error("Firebase Error");
                            }
                        }
                    });
        }
    }

    @Override
    public void Abort_Thread() {

    }
}
