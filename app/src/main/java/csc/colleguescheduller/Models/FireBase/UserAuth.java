package csc.colleguescheduller.Models.FireBase;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserAuth {
    private FirebaseAuth auth;
    private FirebaseUser user;
    private String[] message;

    public UserAuth() {
        this.auth = FirebaseAuth.getInstance();
        this.user = auth.getCurrentUser();
        this.message = new String[1];
    }

    public String getStatus() {
        // return user login status
        if (user != null)
            message[0] = "LOGGED_IN";
        else
            message[0] = "LOGGED_OUT";
        return message[0];
    }

    public String getDisplayName() {
        // return current user name
        return user.getDisplayName();
    }

    public String getEmail() {
        // return current user email
        return user.getEmail();
    }

    public boolean isEmailVerified() {
        /*
        Check if user's email is verified
        Return email verification status
        */
        return user.isEmailVerified();
    }

    public String updateDisplayName(String displayName) {
        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder().setDisplayName(displayName)
                .build();

        user.updateProfile(profileUpdates).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                    message[0] = "SUCCESS";
                else
                    message[0] = "FAILED";
            }
        });
        return message[0];
    }

    public String updateEmail(String email, String password) {
        user.updateEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                    message[0] = "SUCCESS";
                else
                    message[0] = "FAILED";
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof FirebaseAuthRecentLoginRequiredException)
                    message[0] = "ERROR_RE-AUTHENTICATION_NEEDED";
                else if (e instanceof FirebaseAuthUserCollisionException) {

                    String errorCode = ((FirebaseAuthUserCollisionException) e).getErrorCode();
                    message[0] = errorCode;
                }
            }
        });

        return message[0];
    }

    public String updatePassword(String oldPassword, String newPassword) {
        user.updatePassword(newPassword).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                    message[0] = "SUCCESS";
                else
                    message[0] = "FAILED";
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                if (e instanceof FirebaseAuthRecentLoginRequiredException)
                    message[0] = "ERROR_RE-AUTHENTICATION_NEEDED";
                else if (e instanceof FirebaseAuthWeakPasswordException)
                    message[0] = "ERROR_WEAK_PASSWORD";
            }
        });

        return message[0];
    }

    public String resetPassword(String email) {

        // To apply the default app language instead of explicitly setting it.
        auth.useAppLanguage();

        auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful())
                    message[0] = "SUCCESS";
                else
                    message[0] = "FAILED";
            }
        });
        return message[0];
    }

    public String signIn(String email, String password) {
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                            message[0] = "SUCCESS";
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if (e instanceof FirebaseAuthInvalidCredentialsException)
                            message[0] = "ERROR_INVALID_PASSWORD";
                        else if (e instanceof FirebaseAuthInvalidUserException) {

                            String errorCode = ((FirebaseAuthInvalidUserException) e).getErrorCode();
                            message[0] = errorCode;
                        }
                    }
                });

        return message[0];
    }

    public String signUp(String email, String password) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful())
                            message[0] = "SUCCESS";
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if (e instanceof FirebaseAuthInvalidUserException) {

                            String errorCode = ((FirebaseAuthInvalidUserException) e).getErrorCode();
                            message[0] = errorCode;
                        } else if (e instanceof FirebaseAuthUserCollisionException) {

                            String errorCode = ((FirebaseAuthUserCollisionException) e).getErrorCode();
                            message[0] = errorCode;
                        } else if (e instanceof FirebaseAuthWeakPasswordException)
                            message[0] = "ERROR_WEAK_PASSWORD";
                    }
                });

        return message[0];
    }

    public void signOut() {
        auth.signOut();
    }

    public void delete() {
        // Admin sdk not allowed in android
    }

}
