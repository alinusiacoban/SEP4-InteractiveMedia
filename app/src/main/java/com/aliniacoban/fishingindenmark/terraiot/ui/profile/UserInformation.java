package com.aliniacoban.fishingindenmark.terraiot.ui.profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.aliniacoban.fishingindenmark.R;
import com.aliniacoban.fishingindenmark.terraiot.firebaseAuth.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserInformation extends AppCompatActivity {

    private FirebaseUser user;
    private DatabaseReference reference;

    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);

        user = FirebaseAuth.getInstance().getCurrentUser();
        reference = FirebaseDatabase.getInstance("https://terrasmart-5f4d8-default-rtdb.firebaseio.com/").getReference("User");
        userId = user.getUid();

        final TextView fullNameProfile = (TextView) findViewById(R.id.profileFullName);
        final TextView emailProfile = (TextView) findViewById(R.id.profileEmail);

        reference.child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                User userProfile = snapshot.getValue(User.class);
                if(userProfile!=null)
                {
                    String fullName = userProfile.username;
                    String email = userProfile.email;

                    fullNameProfile.setText(fullName);
                    emailProfile.setText(email);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(UserInformation.this, "Something wrong happened!", Toast.LENGTH_LONG).show();
            }
        });
    }
}