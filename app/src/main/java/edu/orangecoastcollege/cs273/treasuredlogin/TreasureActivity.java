package edu.orangecoastcollege.cs273.treasuredlogin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TreasureActivity extends AppCompatActivity {

    //TODO (1): Add Firebase member variables (auth and user)
    // Connection to the Firebase service
    private FirebaseAuth mAuth;
    // The current user
    private FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treasure);



        //TODO (2): Initialize Firebase authentication
        //TODO (3): Initialize current user
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        TextView welcomeTextView = (TextView) findViewById(R.id.welcomeTextView);
        //TODO (4): Set the text view's text to "Welcome " + user's email address
        welcomeTextView.setText(getString(R.string.welcome_message, mUser.getEmail()));

    }


    // TODO (5): Create a public void handleSignOut(View v) that signs out of Firebase authentication,
    // TODO (5): finishes this activity and starts a new Intent back to the LoginActivity.
    public void handleSignOut(View v)
    {
        mAuth.signOut();
        finish();
        Intent loginActivity = new Intent(this, LoginActivity.class);
        startActivity(loginActivity);
    }
}
