package com.sheridan.jobpill;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseFirestore firebaseFirestore;

    private String current_user_id;

    private Button btn_viewProfile;

    private TextView txtGreeting;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupWidgets();

        btn_viewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent profileIntent = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(profileIntent);
                finish();
            }
        });
    }

    public void setupWidgets(){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore = FirebaseFirestore.getInstance();
        btn_viewProfile = findViewById(R.id.btn_profile);
        txtGreeting = findViewById(R.id.txt_greeting);
    }

    @Override
    protected void onStart() {
        super.onStart();

        final FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if(currentUser == null){
            sendToLogin();
        }else{
            current_user_id = firebaseAuth.getCurrentUser().getUid();

            firebaseFirestore.collection("Users").document(current_user_id).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if(task.isSuccessful()){
                        if(!task.getResult().exists()){
                            Intent intent = new Intent(MainActivity.this,EditProfileActivity.class);
                            startActivity(intent);
                            finish();
                        }else{
                            txtGreeting.setText("Hello " + currentUser.getEmail());
                        }
                    }else{
                        String errorMessage = task.getException().getMessage();
                        Toast.makeText(MainActivity.this, "Error " + errorMessage, Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }



    private void sendToLogin() {
        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
