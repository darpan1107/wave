package com.dev334.wave;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class SplashScreen extends AppCompatActivity {
    private ImageView logo;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //logo=findViewById(R.id.splashLogo);
        mAuth=FirebaseAuth.getInstance();



        Handler mHandler= new Handler();  //Splash screen change act. delay 1 second
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if(mAuth.getCurrentUser()==null){
                    // if No logged in User
                    //Transition for Logo
                    Intent sharedintent= new Intent(SplashScreen.this,EmailLogin.class);
                    ActivityOptions options= ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this,
                            new android.util.Pair<View, String>(logo, "logoTransition"));
                    startActivity(sharedintent, options.toBundle());
                }else{
                    //directly then Opening the HomeActivity
                    Intent i=new Intent(SplashScreen.this, HomeActivity.class);
                    startActivity(i);
                }
            }
        },1000);

    }
}