package holguin.jacobpasswordcrackerproject;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class userInputActivity extends AppCompatActivity {

    TextView titleText;
    TextView pWStrength;
    TextView pWUsage;
    ProgressBar progressBar;
    Button backBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_input);
        //Probably need to come afterschool to get help, specifically about the comparing passwords to some database and/or the machine learning to create a password cracking algorithm

        titleText = (TextView)findViewById(R.id.titleText);
        pWStrength = (TextView)findViewById(R.id.pWStrength);
        pWUsage = (TextView)findViewById(R.id.pWUsageText);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);
        backBtn = (Button)findViewById(R.id.backBtn);



        String password = getIntent().getStringExtra("userPassWord");

        if (password.length() == 0){
            pWStrength.setText("Password Strength: Invalid");
            progressBar.setProgress(3);
            progressBar.getProgressDrawable().setColorFilter(
                    Color.BLACK, android.graphics.PorterDuff.Mode.SRC_IN);


        } else if (password.length() >= 1 && password.length() <= 5){
            pWStrength.setText("Password Strength: Weak");
            progressBar.setProgress(1);
            progressBar.getProgressDrawable().setColorFilter(
                    Color.RED, android.graphics.PorterDuff.Mode.SRC_IN);


        } else if (password.length() >= 6 && password.length() <= 9) {
            pWStrength.setText("Password Strength: Moderate");
            progressBar.setProgress(2);
            progressBar.getProgressDrawable().setColorFilter(
                    Color.YELLOW, android.graphics.PorterDuff.Mode.SRC_IN);


        } else {
            pWStrength.setText("Password Strength: Strong");
            progressBar.setProgress(3);
            progressBar.getProgressDrawable().setColorFilter(
                    Color.GREEN, android.graphics.PorterDuff.Mode.SRC_IN);


        }

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);

            }
        });
    }

}
