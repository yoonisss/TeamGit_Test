package com.example.test_like;

public class UploadActivity {


    private FirebaseAuth mAuth;
    private FirebaseStorage storage;
    private FirebaseDatabase database;

    mAuth = FirebaseAuth.getInstance();
    storage = FirebaseStorage.getInstance();
    database = FirebaseDatabase.getInstance();
}
