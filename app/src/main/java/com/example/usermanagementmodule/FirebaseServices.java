package com.example.usermanagementmodule;

import android.net.Uri;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

public class FirebaseServices {

    private static FirebaseServices instance;
    private FirebaseAuth auth;
    private FirebaseFirestore fire;
    private FirebaseStorage storage;
    private Uri selectedImageURL;
    private DataUser currentUser;
    private boolean userChangeFlag;

    public Uri getSelectedImageURL() {
        return selectedImageURL;
    }

    public FirebaseServices() {
        auth=FirebaseAuth.getInstance();
        fire=FirebaseFirestore.getInstance();
        storage=FirebaseStorage.getInstance();
    }
 public static  FirebaseServices GetInstance(){
        if (instance==null)
            instance=new FirebaseServices();
        return instance;

 }
    public FirebaseAuth getAuth() {
        return auth;
    }

    public FirebaseFirestore getFire() {
        return fire;
    }

    public FirebaseStorage getStorage() {
        return storage;
    }

     public static FirebaseServices getInstance(){
        if(instance==null){
            instance=new FirebaseServices();
        }
        return instance;
     }

    public void setSelectedImageURL(Uri uri) {

    }
}
